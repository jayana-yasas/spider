package com.rambo.spider.service;

import com.monitorjbl.xlsx.StreamingReader;
import com.rambo.spider.entity.Datafile;
import com.rambo.spider.entity.Infotemplatepreview;
import com.rambo.spider.repository.DatafileRepository;
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
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Pattern;

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

    public void processSimplifiedApproach(String SAMPLE_XLSX_FILE_PATH) throws Exception{
        LOGGER.info("1. called getSheets() {}",SAMPLE_XLSX_FILE_PATH);
        Workbook workbook = getWorkbook(SAMPLE_XLSX_FILE_PATH);

//        try (
//                InputStream fis = new FileInputStream(new File(SAMPLE_XLSX_FILE_PATH));
//                Workbook wb = StreamingReader.builder()
//                        .rowCacheSize(100)
//                        .bufferSize(4096)
//                        .open(fis)) {
//            for (Sheet sheet : workbook){
//                System.out.println(sheet.getSheetName());
//                for (Row r : sheet) {
//                    for (Cell c : r) {
//                        System.out.println(c.getStringCellValue());
//                    }
//                }
//            }
//        }catch (Exception ee){
//            ee.printStackTrace();
//        }

        Sheet sheet = workbook.getSheetAt(WORK_SHEET_NO);
        LOGGER.info("1. called processSimplifiedApproach() {}",SAMPLE_XLSX_FILE_PATH);
        LOGGER.info("2. reading sheet number {}",WORK_SHEET_NO);
        String product = "LE";
        try{

        }catch (Exception e){
            product = "TP";
            e.printStackTrace();
        }

        ThreadPoolExecutor executor =  (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        List<String> columnNames =new ArrayList<>();
        int rowNum = -1;
        int cellNum = 0;
        nestedBreaker:
        for (Row r : sheet) {
            rowNum++;
            cellNum = 0;
            final Infotemplatepreview infotemplatepreview = new Infotemplatepreview();
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
                    String idPrefix = "16_01"+rowNum ;
                    infotemplatepreview.setState(1);
                    infotemplatepreview.setId(idPrefix+"_"+product);
                    data = data.replace(",","");
                    DataMapper.mapDataFile(rowNum, cellNum, data.trim(), infotemplatepreview, columnNames.get(cellNum-1));


                }
            }
            System.out.println(infotemplatepreview.toString());
            LOGGER.info("{}", infotemplatepreview);
            FutureTask<Infotemplatepreview> futureTask = new FutureTask<>(new Callable<Infotemplatepreview>() {
                @Override
                public Infotemplatepreview call() throws Exception {
                    return infotemplatepreviewRepository.save(infotemplatepreview);
                }
            });

            executor.execute(futureTask);
        }
        LOGGER.info("columnNames {}", columnNames);

        executor.shutdown();
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
