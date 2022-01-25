package com.rambo.spider.util;

import com.rambo.spider.entity.Datafile;
import com.rambo.spider.entity.Infotemplatepreview;
import com.rambo.spider.entity.ReceiptReport;
import org.apache.poi.ss.usermodel.DateUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DataMapper {

    public static void mapDataFile(int rowNum, int cellNum, String data, Datafile datafile, String columnName) {
        try {
            switch (columnName) {

                case "month end":
                    if(data.isEmpty()){


                    }else{
                        Date entryMonth = new SimpleDateFormat("MM/dd/yy").parse(data);
                        Timestamp ts=new Timestamp(entryMonth.getTime());
                        datafile.setMonth(ts);

                        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
                        cal.setTime(entryMonth);
                        String idPrefix = cal.get(Calendar.YEAR) +"_" + (cal.get(Calendar.MONTH)+1) + "_" + datafile.getProduct();
                        datafile.setIdData(idPrefix+"_"+rowNum);
                    }

                    break;
                case "Facility No":
                    datafile.setFacilityNo(data);
                  break;
                case "Client Full name":
                    datafile.setClientFullName(data);
                  break;
                case "NIC/BR No":
                    datafile.setNicBr(data);
                  break;
                case "Address":
                    datafile.setAddress(data);
                  break;
                case "Facility Period":
                    try {
                        datafile.setFacilityPeriod(Integer.parseInt(data));
                    } catch (Exception e){

                    }

                  break;
                case "Facility Amount" :
                    datafile.setFacilityAmount(setDoubleValue(rowNum ,"Facility Amount", data));
                  break;
                case "Facility Amt" :
                    datafile.setFacilityAmount(setDoubleValue(rowNum ,"Facility Amt", data));
                    break;
                case "Facility Status":
                    datafile.setFacilityStatus(data);
                  break;
                case "Activate Date":
//                    datafile.setActivateDate(new SimpleDateFormat("dd/MM/yyyy").parse(data));
                  break;
                case "Rental Amount":
                    datafile.setRentalAmount(setDoubleValue(rowNum ,"Rental Amount", data));
                  break;
                case "Facility Type":
                    datafile.setFacilityType(data);
                  break;
                case "Interest Rate":
                    datafile.setInterestRate(setDoubleValue(rowNum ,"Interest Rate", data));
                  break;
                case "No Of Arr":
                    datafile.setNoOfArr(setDoubleValue(rowNum ,"No Of Arr", data));
                  break;
                case "P/NP Flag":
                    datafile.setpNpFlag(data);
                  break;
                case "Future Capital":
                    datafile.setFutureCapital(setDoubleValue(rowNum ,"Future Capital", data));
                  break;
                case "Future Interest":
                    datafile.setFutureInterest(setDoubleValue(rowNum ,"Future Interest", data));
                  break;
                case "Interest In Suspence":
                    datafile.setInterestInSuspence(setDoubleValue(rowNum ,"Interest In Suspence", data));
                  break;
                case "VAT In Suspence":
//                    datafile.setVatInSuspence(Integer.parseInt(data));
                  break;
                case "OverPay Balance":
                    datafile.setOverPayBalance(setDoubleValue(rowNum ,"OverPay Balance", data));
                  break;
                case "UnUtilized Prepayment":
//                    datafile.setUnUtilizedPrepayment(Integer.parseInt(data));
                  break;
                case "RNT - CAP":
                    datafile.setRntCap(setDoubleValue(rowNum ,"RNT - CAP", data));
                  break;
                case "RNT - INT":
                    datafile.setRntInt(setDoubleValue(rowNum ,"RNT - INT", data));
                  break;
                case "PRE - PRE":
                    datafile.setPrePre(setDoubleValue(rowNum ,"PRE - PRE", data));
                  break;
                case "RNO - RNO":
                    datafile.setRnoRno(setDoubleValue(rowNum ,"RNO - RNO", data));
                  break;
                case "GSO - GSO":
                    datafile.setGsoGso(setDoubleValue(rowNum ,"GSO - GSO", data));
                  break;
                case "INS - INS":
                    datafile.setInsIns(setDoubleValue(rowNum ,"INS - INS", data));
                  break;
                case "INO - CAP":
                    datafile.setInoCap(setDoubleValue(rowNum ,"INO - CAP", data));
                  break;
                case "INO - GST":
                    datafile.setInoGst(setDoubleValue(rowNum ,"INO - GST", data));
                  break;
                case "GST - GST":
                    datafile.setGstGst(setDoubleValue(rowNum ,"GST - GST", data));
                  break;
                case "CHR - CAP":
                    datafile.setChrCap(setDoubleValue(rowNum ,"CHR - CAP", data));
                  break;
                case "CHR - GST":
                    datafile.setChrGst(setDoubleValue(rowNum ,"CHR - GST", data));
                  break;
                case "UPS - UPS":
                    datafile.setUpsUps(setDoubleValue(rowNum ,"UPS - UPS", data));
                  break;
                case "RMV - RMV":
                    datafile.setRmvRmv(setDoubleValue(rowNum ,"RMV - RMV", data));
                  break;
                case "NDP - NDP":
                    datafile.setNdpNdp(setDoubleValue(rowNum ,"NDP - NDP", data));
                  break;
                case "OCH - CAP":
                    datafile.setOchCap(setDoubleValue(rowNum ,"OCH - CAP", data));
                  break;
                case "OCH - GST":
                    datafile.setOchGst(setDoubleValue(rowNum ,"OCH - GST", data));
                  break;
                case "INC - CAP":
                    datafile.setIncCap(setDoubleValue(rowNum ,"INC - CAP", data));
                  break;
                case "INC - GAT":
                    datafile.setIncGat(setDoubleValue(rowNum ,"INC - GAT", data));
                  break;
                case "SIF - SIF":
                    datafile.setOthGst(setDoubleValue(rowNum ,"SIF - SIF", data));
                  break;
                case "LGL - LGL":
                    datafile.setSifSif(setDoubleValue(rowNum ,"LGL - LGL", data));
                  break;
                case "OST - OST":
                    datafile.setLglLgl(setDoubleValue(rowNum ,"OST - OST", data));
                  break;
                case "WCH - WCH":
                    datafile.setOstOst(setDoubleValue(rowNum ,"WCH - WCH", data));
                  break;
                case "HYF - HYF":
                    datafile.setWchWch(setDoubleValue(rowNum ,"HYF - HYF", data));
                  break;
                case "SCH - CAP":
                    datafile.setHyfHyf(setDoubleValue(rowNum ,"SCH - CAP", data));
                  break;
                case "SCH - GST":
                    datafile.setSchCap(setDoubleValue(rowNum ,"SCH - GST", data));
                  break;
                case "ADV - ADV":
                    datafile.setSchGst(setDoubleValue(rowNum ,"ADV - ADV", data));
                  break;
                case "OTH - CAP":
                    datafile.setAdvAdv(setDoubleValue(rowNum ,"OTH - CAP", data));
                  break;
                case "OTH - GST":
                    datafile.setOthCap(setDoubleValue(rowNum ,"OTH - GST", data));
                  break;
                case "CAV - CAV":
                    datafile.setCavCav(setDoubleValue(rowNum ,"CAV - CAV", data));
                  break;
                case "LUX - LUX":
                    datafile.setLuxLux(setDoubleValue(rowNum ,"LUX - LUX", data));
                  break;
                case "TC - TC":
                    datafile.setTcTc(setDoubleValue(rowNum ,"TC - TC", data));
                  break;
                case "CLO - CLO":
                    datafile.setCloClo(setDoubleValue(rowNum ,"CLO - CLO", data));
                  break;
                case "CLO - CAP":
                    datafile.setCloCap(setDoubleValue(rowNum ,"CLO - CAP", data));
                  break;
                case "CLO - OTH":
                    datafile.setCloOth(setDoubleValue(rowNum ,"CLO - OTH", data));
                  break;
                case "Fallen Due Rentals":
                    datafile.setFallenDueRentals(Integer.parseInt(data));
                  break;
                case "Setteld":
                    datafile.setSetteld(setDoubleValue(rowNum ,"Setteld", data));
                  break;
                case "Tot. Outstanding":
                    datafile.setTotOutstanding(setDoubleValue(rowNum ,"Tot. Outstanding", data));
                  break;
                case "Outstanding":
                    datafile.setTotOutstanding(setDoubleValue(rowNum ,"Outstanding", data));
                  break;
                case "Tot. Out. Balance":
                    datafile.setTotOutBalance(setDoubleValue(rowNum ,"Tot. Out. Balance", data));
                  break;
                case "Rnt. Amt. Arrears":
                    datafile.setRntAmtArrears(setDoubleValue(rowNum ,"Rnt. Amt. Arrears", data));
                  break;
                case "Equip Type":
                    datafile.setEquipType(data);
                  break;
                case "Equip Description":
                    datafile.setEquipDescription(data);
                  break;
                case "Age":
                    datafile.setAge(setDoubleValue(rowNum ,"Age", data));
                    datafile.setAgeRental(setDoubleValue(rowNum ,"Age", data));
                    break;
                case "Exp.Date":
//                    datafile.setExpDate(new SimpleDateFormat("dd/MM/yyyy").parse(data));
                  break;
                case "Sector":
                    datafile.setSector(data);
                  break;
                case "District":
                    datafile.setDistrict(data);
                  break;
            }
        }catch (ParseException | NumberFormatException paEx ){
            datafile.setStage(9);
        }

    }

    public static Infotemplatepreview mapDataFile(int rowNum, int cellNum, String data, Infotemplatepreview infotemplatepreview, String columnName) {
        try {
            switch (columnName) {

                case "month-year":
                    if(data.isEmpty()){


                    }else{
                        Date entryMonth = new SimpleDateFormat("MMM-yy").parse(data);
                        infotemplatepreview.setMonth(entryMonth);
                    }

                    break;
                case "1":
                    if(data.equals("-")){
                        infotemplatepreview.setBucket1(Double.parseDouble("0"));
                    }else{
                        infotemplatepreview.setBucket1(Double.parseDouble(data));
                    }

                    break;
                case "2":
                    if(data.equals("-")){
                        infotemplatepreview.setBucket2(Double.parseDouble("0"));
                    }else{
                        infotemplatepreview.setBucket2(Double.parseDouble(data));
                    }
                    break;
                case "3":
                    if(data.equals("-")){
                        infotemplatepreview.setBucket3(Double.parseDouble("0"));
                    }else{
                        infotemplatepreview.setBucket3(Double.parseDouble(data));
                    }
                    break;
                case "4":
                    if(data.equals("-")){
                        infotemplatepreview.setBucket4(Double.parseDouble("0"));
                    }else{
                        infotemplatepreview.setBucket4(Double.parseDouble(data));
                    }
                    break;
                case "5":
                    if(data.equals("-")){
                        infotemplatepreview.setBucket5(Double.parseDouble("0"));
                    }else{
                        infotemplatepreview.setBucket5(Double.parseDouble(data));
                    }
                    break;
                case "6":
                    if(data.equals("-")){
                        infotemplatepreview.setBucket6(Double.parseDouble("0"));
                    }else{
                        infotemplatepreview.setBucket6(Double.parseDouble(data));
                    }
                    break;
                case "7":
                    if(data.equals("-")){
                        infotemplatepreview.setBucket7(Double.parseDouble("0"));
                    }else{
                        infotemplatepreview.setBucket7(Double.parseDouble(data));
                    }
                    break;
                case "8":
                    if(data.equals("-")){
                        infotemplatepreview.setBucket8(Double.parseDouble("0"));
                    }else{
                        infotemplatepreview.setBucket8(Double.parseDouble(data));
                    }
                    break;

            }
        }catch (ParseException | NumberFormatException paEx ){
            paEx.printStackTrace();
        }
        return infotemplatepreview;
    }

    public static void mapDataFile(int rowNum, int cellNum, String data, ReceiptReport receiptsReports, String columnName) {
        try {
            switch (columnName) {

                case "Facility No":
                    receiptsReports.setFacilityNo(data);
                    break;
                case "Date":
                    Date javaDate= DateUtil.getJavaDate((double) new Double(data));
                    System.out.println(new SimpleDateFormat("MM/dd/yyyy").format(javaDate));
                    receiptsReports.setDate(javaDate);
                    break;
                case "Receipt":
                    receiptsReports.setReceipt(data);
                    break;
                case "Amount":
                    receiptsReports.setAmount(setDoubleValue(rowNum ,"Amount", data));
                    break;


            }
        }catch ( NumberFormatException paEx ){

        }

    }


    public static double generateDC(double age,String basis) {
        if (basis.equalsIgnoreCase("REN")) {
            if (age <= 0) {
                return 1;
            } else if (age <= 1) {
                return 2;
            } else if (age <= 2) {
                return 3;
            } else if (age <= 3) {
                return 4;
            } else if (age <= 4) {
                return 5;
            } else if (age <= 5) {
                return 6;
            } else if (age < 6) {
                return 7;
            } else if (age >= 6) {
                return 8;
            } else {
                return 0;
            }
        } else if (basis.equalsIgnoreCase("DPD")) {
            if (age <= 0) {
                return 1;
            } else if (age < 30) {
                return 2;
            } else if (age < 60) {
                return 3;
            } else if (age < 90) {
                return 4;
            } else if (age < 120) {
                return 5;
            } else if (age < 150) {
                return 6;
            } else if (age < 180) {
                return 7;
            } else if (age >= 180) {
                return 8;
            } else {
                return 0;
            }
        }else{
            return 0;
        }

    }

    private static double setDoubleValue(int rowNum,String cellName, String data){
        try {
            return Double.parseDouble(data.replace(",",""));
        }catch (NumberFormatException nfE){
            System.out.println("Invalid data found at row : "+rowNum+", cell : "+cellName+", value : "+data);
            throw nfE;
        }
    }

    private static String getCellName(int cellNum){
        if(cellNum == 0 ){
            return "Facility No";
        }else if(cellNum == 1) {
            return "Client Full name";
        }else{
            return "NIC/BR No";
        }
    }

    public static Datafile calculationFirstRow(Datafile currentRow, Datafile nextRow,String basis){

        currentRow.setDc(generateDC(currentRow.getAge(),basis));


        currentRow.setFirst(currentRow.getDc());
        currentRow.setWorst(currentRow.getFirst());

        if(nextRow.getFacilityNo().equals(currentRow.getFacilityNo())){
            currentRow.setLast("N");
        }else{
            currentRow.setLast(currentRow.getDc().toString());
        }

        return currentRow;
    }

    public static Datafile calculation(Datafile lastRow,Datafile currentRow, Datafile nextRow, int i,String basis){
        currentRow.setDc(generateDC(currentRow.getAge(),basis));

        if(i==0){
                currentRow.setFirst(currentRow.getDc());
                currentRow.setWorst(currentRow.getFirst());
            }else{
                if(currentRow.getFacilityNo().equals(lastRow.getFacilityNo())){ // when first or not last facility
                    currentRow.setFirst(lastRow.getFirst());
                    if (currentRow.getDc() > lastRow.getWorst()){
                        currentRow.setWorst(currentRow.getDc());
                    }else{
                        currentRow.setWorst(lastRow.getWorst());
                    }
                }else{
                    currentRow.setFirst(currentRow.getDc());         // when last facility
                    currentRow.setWorst(currentRow.getDc());
                }
            }

            if(nextRow.getFacilityNo().equals(currentRow.getFacilityNo())){
                currentRow.setLast("N");
            }else{
                currentRow.setLast(currentRow.getDc().toString());
            }
        return currentRow;
    }

    public static Datafile calculationLastRow(Datafile lastRow, Datafile currentRow,String basis){
        currentRow.setDc(generateDC(currentRow.getAge(),basis));

        currentRow.setFirst(lastRow.getFirst());
        currentRow.setLast(currentRow.getDc().toString());
        if (currentRow.getDc() > lastRow.getWorst()){
            currentRow.setWorst(currentRow.getDc());
        }else{
            currentRow.setWorst(lastRow.getWorst());
        }
        return currentRow;
    }

    public static double generatePDBPecentage(double budketN, double bucketO){
        double pdbValue = 0;
        if(bucketO != 0){
            pdbValue = (budketN/bucketO)*100;
            if(pdbValue>100) return 100;
            return pdbValue;
        }else{
            return pdbValue;
        }
    }

}
