package com.rambo.spider.service;

import com.monitorjbl.xlsx.StreamingReader;
import com.rambo.spider.entity.ReceiptReport;
import com.rambo.spider.repository.ReceiptReportRepository;
import com.rambo.spider.util.DataMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ReceiptReportServiceImpl implements ReceiptReportService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiptReportServiceImpl.class);

    @Value(value = "${workbook.sheet.no}")
    private int WORK_SHEET_NO;
    @Value(value = "${workbook.data.month.row}")
    private int MONTH_ROW;
    @Value(value = "${workbook.data.month.regex}")
    private String MONTH_REGEX;
    @Value(value = "${workbook.data.month.format}")
    private String MONTH_FORMAT;
    @Value(value = "${workbook.data.product.row}")
    private int PRODUCT_ROW;
    @Value(value = "${workbook.data.start.row}")
    private int DATA_START_ROW;
    @Autowired
    ReceiptReportRepository receiptsReportsRepository;

    public void processRecieptReport(String SAMPLE_XLSX_FILE_PATH, String FileName) throws Exception {
        Workbook workbook = getWorkbook(SAMPLE_XLSX_FILE_PATH);
        Sheet sheet = workbook.getSheetAt(WORK_SHEET_NO);
        List<String> columnNames = new ArrayList<>();
        final ReceiptReport receiptsReports = new ReceiptReport();
        Iterator<Row> rowIterator = sheet.iterator();
        nestedBreaker:
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String data = cell.getStringCellValue().trim();

                if (row.getRowNum() == 0) {  // get colomn names
                    String columnName = cell.getStringCellValue();
                    columnNames.add(columnName.trim());
                    continue;
                } else {                      // get data
                    if (cell.getColumnIndex() == 1) {
                        if (data.isEmpty() || data == null) {
                            break nestedBreaker;           // if starting cell is empty, iterating stops
                        }
                    }
                    DataMapper.mapDataFile(row.getRowNum(), cell.getColumnIndex(), data, receiptsReports, columnNames.get(cell.getColumnIndex()));
                }

            }

            if (row.getRowNum() > 0) {
                System.out.println(row.getRowNum() + " " + receiptsReports);
                try {
                    receiptsReportsRepository.save(receiptsReports);
                } catch (Exception ex) {

                }
            }

        }


        workbook.close();
        workbook = null;
    }


    public Workbook getWorkbook(String SAMPLE_XLSX_FILE_PATH) {
        try {

            InputStream is = new FileInputStream(new File(SAMPLE_XLSX_FILE_PATH));

            Workbook workbook = StreamingReader.builder()
                    .rowCacheSize(80)    // number of rows to keep in memory (defaults to 10)
                    .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
                    .open(is);

            LOGGER.info("workbook has {} Sheets", workbook.getNumberOfSheets());
            for (Sheet sheet : workbook) {
                LOGGER.info("{}", sheet.getSheetName());
            }
            return workbook;
        } catch (Exception e) {
            return null;
        }

    }

}
