package com.rambo.spider.service;

import com.monitorjbl.xlsx.StreamingReader;
import com.rambo.spider.entity.Infotemplatepreview;
import com.rambo.spider.repository.InfotemplatepreviewRepository;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class SimplifiedServiceImpl implements  SimplifiedService{
    private static final Logger LOGGER = LoggerFactory.getLogger(SimplifiedServiceImpl.class);

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
    InfotemplatepreviewRepository infotemplatepreviewRepository;

    public void processSimplifiedApproach(String SAMPLE_XLSX_FILE_PATH,String FileName) throws Exception{
        LOGGER.info("1. called getSheets() {}",SAMPLE_XLSX_FILE_PATH);
        Workbook workbook = getWorkbook(SAMPLE_XLSX_FILE_PATH);
        Sheet sheet = workbook.getSheetAt(WORK_SHEET_NO);
        String product = "LE" ;// FileName.substring(0,2); //LE 2020
        String year = "2020";//FileName.substring(3, 7);

        List<String> columnNames =new ArrayList<>();
        int rowNum = -1;
        int cellNum = 0;
        nestedBreaker:
        for (Row r : sheet) {
            rowNum++;
            cellNum = 0;
            Infotemplatepreview infotemplatepreview = new Infotemplatepreview();
            for (Cell c : r) {
                cellNum++;
                if(rowNum == 0){
                    String columnName =  c.getStringCellValue();
                    columnNames.add(columnName.trim());
                }else if(rowNum > 0){
                    String data = c.getStringCellValue().trim();
                    if(cellNum == 1){
                        if(data.isEmpty() || data == null){
                              break nestedBreaker;           // if starting cell is empty, iterating stops
                        }
                    }

                    String uuid = UUID.randomUUID().toString().replace("-","");
                    String idPrefix = product+"_"+year + "_"+uuid ;
                    infotemplatepreview.setState(1);
                    infotemplatepreview.setId(idPrefix);
                    data = data.replace(",","");
                    DataMapper.mapDataFile(rowNum, cellNum, data.trim(), infotemplatepreview, columnNames.get(cellNum-1));


                }
            }
            if(rowNum > 0){
                System.out.println(infotemplatepreview.toString());
                LOGGER.info("{}", infotemplatepreview);
                infotemplatepreviewRepository.save(infotemplatepreview);
            }


        }
        LOGGER.info("columnNames {}", columnNames);

        workbook.close();
    }

    public Workbook getWorkbook(String SAMPLE_XLSX_FILE_PATH) {
        try {

            InputStream is = new FileInputStream(new File(SAMPLE_XLSX_FILE_PATH));

            Workbook workbook = StreamingReader.builder()
                    .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
                    .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
                    .open(is);

//            InputStream is = new FileInputStream(new File(SAMPLE_XLSX_FILE_PATH));

//            File f = new File(SAMPLE_XLSX_FILE_PATH);
//            Workbook workbook = StreamingReader.builder()
//                    .rowCacheSize(100)
//                    .bufferSize(4096)
//                    .open(f);
//            for (Row r : reader) {
//                for (Cell c : r) {
//                    System.out.println(c.getStringCellValue());
//                }
//            }

//            Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
            // Retrieving the number of sheets in the Workbook
            LOGGER.info("workbook has {} Sheets", workbook.getNumberOfSheets());
            for(Sheet sheet: workbook) {
                LOGGER.info("{}", sheet.getSheetName());
            }
            return workbook;
        }catch (Exception e){
            return null;
        }

    }

}
