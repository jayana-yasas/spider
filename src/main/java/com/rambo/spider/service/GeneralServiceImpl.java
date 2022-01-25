package com.rambo.spider.service;

import com.monitorjbl.xlsx.StreamingReader;
import com.rambo.spider.entity.Datafile;
import com.rambo.spider.repository.DatafileRepository;
import com.rambo.spider.util.DataMapper;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

@Service
public class GeneralServiceImpl implements GeneralService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralServiceImpl.class);

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
    DatafileRepository datafileRepository;

    public void processGeneralApproach(String SAMPLE_XLSX_FILE_PATH, String FileName) throws Exception {
        Workbook workbook = getWorkbook(SAMPLE_XLSX_FILE_PATH);
        Sheet sheet = workbook.getSheetAt(WORK_SHEET_NO);
        String product = FileName.substring(0, 2); //LE 2020
        String year = FileName.substring(3, 7);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        List<String> columnNames = new ArrayList<>();
        int rowNum = -1;
        AtomicInteger cellNum = new AtomicInteger(0);
        nestedBreaker:
        for (Row row : sheet) {
            rowNum++;
            cellNum.set(0);

            final Datafile datafile = new Datafile();

            datafile.setProduct(product);
            datafile.setStage(1);

            for (Cell cell : row) {
                cellNum.incrementAndGet();
                if (rowNum == 0) {
                    String columnName = cell.getStringCellValue();
                    columnNames.add(columnName.trim());
                } else if (rowNum > 0) {
                    String data = cell.getStringCellValue().trim();
                    if (cellNum.get() == 1) {
                        if (data.isEmpty() || data == null) {
                            break nestedBreaker;           // if starting cell is empty, iterating stops
                        }
                    }
                    DataMapper.mapDataFile(rowNum, cellNum.get(), data.trim(), datafile, columnNames.get(cellNum.get() - 1));
                }

            }

            FutureTask<Datafile> futureTask = new FutureTask<>(new Callable<Datafile>() {
                @Override
                public Datafile call() throws Exception {

                    return datafileRepository.save(datafile);
                }
            });
            executor.execute(futureTask);
            if (datafile.getStage() == 9) {
                if (datafile.getAge() == null)
                    System.out.println(datafile.getFacilityNo() + ", " + datafile.getMonth());

            }

        }
        LOGGER.info("columnNames {}", columnNames);
        executor.shutdown();

        // Closing the workbook
        workbook.close();
        workbook = null;
    }

    public void processGeneralApproach__(String SAMPLE_XLSX_FILE_PATH, String FileName) throws Exception {
        Workbook workbook = getWorkbook(SAMPLE_XLSX_FILE_PATH);
        Sheet sheet = workbook.getSheetAt(WORK_SHEET_NO);
        String product = FileName.substring(0, 2); //LE 2020
        String year = FileName.substring(3, 7);
        List<String> columnNames = new ArrayList<>();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        final Datafile datafile = new Datafile();
        Iterator<Row> rowIterator = sheet.iterator();
        datafile.setProduct(product);
        datafile.setStage(1);
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
                    DataMapper.mapDataFile(row.getRowNum(), cell.getColumnIndex(), data, datafile, columnNames.get(cell.getColumnIndex()));
                }

            }

            if (row.getRowNum() > 0) {
                datafile.setIdData(product + "_" + datafile.getMonth().toString().substring(0, 10).replace("-", "") + "_" + datafile.getFacilityNo()+"_"+row.getRowNum());
                System.out.println(row.getRowNum() + " " + datafile);
                try {
                    datafileRepository.save(datafile);
                }catch (Exception ex){

                }

//                FutureTask<Datafile> futureTask = new FutureTask<>(new Callable<Datafile>() {
//                    @Override
//                    public Datafile call() throws Exception {
//
//                        return datafileRepository.save(datafile);
//                    }
//                });
//                executor.execute(futureTask);
            }

        }

        executor.shutdown();

        workbook.close();
        workbook = null;
    }

    public void generateDC(String product) {
        List<Datafile> datafileList = datafileRepository.findAllByProductOrderByFacilityNoAscMonthAsc(product);
        
    }


    public Workbook getWorkbook(String SAMPLE_XLSX_FILE_PATH) {
        try {

            InputStream is = new FileInputStream(new File(SAMPLE_XLSX_FILE_PATH));

            Workbook workbook = StreamingReader.builder()
                    .rowCacheSize(1000)    // number of rows to keep in memory (defaults to 10)
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
