package com.rambo.spider.util;

import com.rambo.spider.entity.Datafile;
import com.rambo.spider.entity.Infotemplatepreview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class DataMapper {

    public static Datafile mapDataFile(int rowNum,int cellNum, String data,Datafile datafile,String columnName) {
        try {
            switch (columnName) {

                case "month end":
                    if(data.isEmpty()){


                    }else{
                        Date entryMonth = new SimpleDateFormat("MM/dd/yy").parse(data);
                        datafile.setMonth(entryMonth);

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
                case "Facility Amount":
                    datafile.setFacilityAmount(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "Facility Status":
                    datafile.setFacilityStatus(data);
                  break;
                case "Activate Date":
                    datafile.setActivateDate(new SimpleDateFormat("dd/MM/yyyy").parse(data));
                  break;
                case "Rental Amount":
                    datafile.setRentalAmount(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "Facility Type":
                    datafile.setFacilityType(data);
                  break;
                case "Interest Rate":
                    datafile.setInterestRate(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "No Of Arr":
                    datafile.setNoOfArr(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "P/NP Flag":
                    datafile.setpNpFlag(data);
                  break;
                case "Future Capital":
                    datafile.setFutureCapital(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "Future Interest":
                    datafile.setFutureInterest(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "Interest In Suspence":
                    datafile.setInterestInSuspence(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "VAT In Suspence":
//                    datafile.setVatInSuspence(Integer.parseInt(data));
                  break;
                case "OverPay Balance":
                    datafile.setOverPayBalance(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "UnUtilized Prepayment":
//                    datafile.setUnUtilizedPrepayment(Integer.parseInt(data));
                  break;
                case "RNT - CAP":
                    datafile.setRntCap(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "RNT - INT":
                    datafile.setRntInt(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "PRE - PRE":
                    datafile.setPrePre(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "RNO - RNO":
                    datafile.setRnoRno(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "GSO - GSO":
                    datafile.setGsoGso(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "INS - INS":
                    datafile.setInsIns(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "INO - CAP":
                    datafile.setInoCap(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "INO - GST":
                    datafile.setInoGst(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "GST - GST":
                    datafile.setGstGst(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "CHR - CAP":
                    datafile.setChrCap(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "CHR - GST":
                    datafile.setChrGst(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "UPS - UPS":
                    datafile.setUpsUps(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "RMV - RMV":
                    datafile.setRmvRmv(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "NDP - NDP":
                    datafile.setNdpNdp(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "OCH - CAP":
                    datafile.setOchCap(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "OCH - GST":
                    datafile.setOchGst(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "INC - CAP":
                    datafile.setIncCap(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "INC - GAT":
                    datafile.setIncGat(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "SIF - SIF":
                    datafile.setOthGst(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "LGL - LGL":
                    datafile.setSifSif(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "OST - OST":
                    datafile.setLglLgl(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "WCH - WCH":
                    datafile.setOstOst(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "HYF - HYF":
                    datafile.setWchWch(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "SCH - CAP":
                    datafile.setHyfHyf(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "SCH - GST":
                    datafile.setSchCap(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "ADV - ADV":
                    datafile.setSchGst(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "OTH - CAP":
                    datafile.setAdvAdv(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "OTH - GST":
                    datafile.setOthCap(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "CAV - CAV":
                    datafile.setCavCav(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "LUX - LUX":
                    datafile.setLuxLux(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "TC - TC":
                    datafile.setTcTc(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "CLO - CLO":
                    datafile.setCloClo(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "CLO - CAP":
                    datafile.setCloCap(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "CLO - OTH":
                    datafile.setCloOth(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "Fallen Due Rentals":
                    datafile.setFallenDueRentals(Integer.parseInt(data));
                  break;
                case "Setteld":
                    datafile.setSetteld(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "Tot. Outstanding":
                    datafile.setTotOutstanding(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "Tot. Out. Balance":
                    datafile.setTotOutBalance(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "Rnt. Amt. Arrears":
                    datafile.setRntAmtArrears(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case "Equip Type":
                    datafile.setEquipType(data);
                  break;
                case "Equip Description":
                    datafile.setEquipDescription(data);
                  break;
                case "Age":
                    datafile.setAge(setDoubleValue(rowNum ,cellNum, data));
                    break;
                case "Exp.Date":
                    datafile.setExpDate(new SimpleDateFormat("dd/MM/yyyy").parse(data));
                  break;
                case "Sector":
                    datafile.setSector(data);
                  break;
                case "District":
                    datafile.setDistrict(data);
                  break;
            }
        }catch (ParseException | NumberFormatException paEx ){
            paEx.printStackTrace();
        }
        return datafile;
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

    private static double generateDC(double age,String basis) {
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

    private static double setDoubleValue(int rowNum,int cellNum, String data){
        try {
            return Double.parseDouble(data.replace(",",""));
        }catch (NumberFormatException nfE){
            System.out.println("Invalid data found at row : "+rowNum+", cell : "+cellNum+", value : "+data);
            return 0;
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
