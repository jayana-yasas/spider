package com.rambo.spider.service;

import com.rambo.spider.entity.Datafile;
import com.rambo.spider.repository.DatafileRepository;
import com.rambo.spider.util.DataMapper;
import com.rambo.spider.util.Validations;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ExcelFileServiceImpl implements  ExcelFileService{
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

    public void getSheets(String SAMPLE_XLSX_FILE_PATH) throws Exception{

        Workbook workbook = getWorkbook(SAMPLE_XLSX_FILE_PATH);

        Sheet sheet = workbook.getSheetAt(WORK_SHEET_NO);

        DataFormatter dataFormatter = new DataFormatter();

        String dateCellValue = dataFormatter.formatCellValue(sheet.getRow(MONTH_ROW).getCell(0));
        Pattern pattern = Pattern.compile(MONTH_REGEX);
        Matcher matcher = pattern.matcher(dateCellValue);
        String dateAtCell =null;
        if (matcher.find()){
            dateAtCell = matcher.group(1).trim();
        }
        System.out.println("apply regex     : "+MONTH_REGEX);
        System.out.println("date cell value : "+dateCellValue);
        System.out.println("extracted date  : "+dateAtCell);
        System.out.println("date format     : "+MONTH_FORMAT);
        String product = dataFormatter.formatCellValue(sheet.getRow(PRODUCT_ROW).getCell(0)).split(":",2)[1].trim();
        Date entryMonth = new SimpleDateFormat(MONTH_FORMAT).parse(dateAtCell);
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        cal.setTime(entryMonth);

        String idPrefix = cal.get(Calendar.YEAR) +"_" + (cal.get(Calendar.MONTH)+1) + "_" + product;

        ThreadPoolExecutor executor =  (ThreadPoolExecutor) Executors.newFixedThreadPool(5);


        for (int rowNum=DATA_START_ROW;rowNum <sheet.getLastRowNum();rowNum++) {         //Row row: sheet
            if (dataFormatter.formatCellValue(sheet.getRow(rowNum).getCell(0)).trim().isEmpty()){
                break;              // if starting cell is empty, iterating stops
            }

            final  Datafile datafile = new Datafile();
            datafile.setProduct(product);
            datafile.setMonth(entryMonth);
            datafile.setIdData(idPrefix+"_"+sheet.getRow(rowNum).getCell(0));
            datafile.setStage(1);
            for(int cellNum = 0; cellNum <sheet.getRow(rowNum).getLastCellNum(); cellNum++ ) {       //Cell cell: row
                String cellValue = dataFormatter.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));
                DataMapper.mapDataFile(rowNum,cellNum,cellValue,datafile);
            }

            System.out.println(datafile.toString());

            FutureTask<Datafile> futureTask = new FutureTask<>(new Callable<Datafile>() {
                @Override
                public Datafile call() throws Exception {
                    return datafileRepository.save(datafile);
                }
            });

            executor.execute(futureTask);

        }
        executor.shutdown();
        // Closing the workbook
        workbook.close();
    }

    public Workbook getWorkbook(String SAMPLE_XLSX_FILE_PATH) throws Exception {

        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has    : " + workbook.getNumberOfSheets() + " Sheets");
        for(Sheet sheet: workbook) {
            System.out.println("================> " + sheet.getSheetName());
        }
        return workbook;
    }

}
