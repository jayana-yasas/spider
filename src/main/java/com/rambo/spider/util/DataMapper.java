package com.rambo.spider.util;

import com.rambo.spider.entity.Datafile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataMapper {
    public static Datafile mapDataFile(int rowNum,int cellNum, String data,Datafile datafile) {
        try {
            switch (cellNum) {
                case 0:
                    datafile.setFacilityNo(data);
                  break;
                case 1:
                    datafile.setClientFullName(data);
                  break;
                case 2:
                    datafile.setNicBr(data);
                  break;
                case 3:
                    datafile.setAddress(data);
                  break;
                case 4:
                    datafile.setFacilityPeriod(Integer.parseInt(data));
                  break;
                case 5:
                    datafile.setFacilityAmount(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 6:
                    datafile.setFacilityStatus(data);
                  break;
                case 7:
                    datafile.setActivateDate(new SimpleDateFormat("dd/MM/yyyy").parse(data));
                  break;
                case 8:
                    datafile.setRentalAmount(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 9:
                    datafile.setFacilityType(data);
                  break;
                case 10:
                    datafile.setInterestRate(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 11:
                    datafile.setNoOfArr(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 12:
                    datafile.setpNpFlag(data);
                  break;
                case 13:
                    datafile.setFutureCapital(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 14:
                    datafile.setFutureInterest(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 15:
                    datafile.setInterestInSuspence(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 16:
                    datafile.setVatInSuspence(Integer.parseInt(data));
                  break;
                case 17:
                    datafile.setOverPayBalance(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 18:
                    datafile.setUnUtilizedPrepayment(Integer.parseInt(data));
                  break;
                case 19:
                    datafile.setRntCap(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 20:
                    datafile.setRntInt(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 21:
                    datafile.setPrePre(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 22:
                    datafile.setRnoRno(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 23:
                    datafile.setGsoGso(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 24:
                    datafile.setInsIns(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 25:
                    datafile.setInoCap(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 26:
                    datafile.setInoGst(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 27:
                    datafile.setGstGst(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 28:
                    datafile.setChrCap(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 29:
                    datafile.setChrGst(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 30:
                    datafile.setUpsUps(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 31:
                    datafile.setRmvRmv(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 32:
                    datafile.setNdpNdp(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 33:
                    datafile.setOchCap(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 34:
                    datafile.setOchGst(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 35:
                    datafile.setIncCap(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 36:
                    datafile.setIncGat(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 37:
                    datafile.setOthGst(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 38:
                    datafile.setSifSif(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 39:
                    datafile.setLglLgl(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 40:
                    datafile.setOstOst(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 41:
                    datafile.setWchWch(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 42:
                    datafile.setHyfHyf(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 43:
                    datafile.setSchCap(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 44:
                    datafile.setSchGst(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 45:
                    datafile.setAdvAdv(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 46:
                    datafile.setOthCap(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 47:
                    datafile.setCavCav(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 48:
                    datafile.setLuxLux(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 49:
                    datafile.setTcTc(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 50:
                    datafile.setCloClo(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 51:
                    datafile.setCloCap(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 52:
                    datafile.setCloOth(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 53:
                    datafile.setFallenDueRentals(Integer.parseInt(data));
                  break;
                case 54:
                    datafile.setSetteld(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 55:
                    datafile.setTotOutstanding(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 56:
                    datafile.setTotOutBalance(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 57:
                    datafile.setRntAmtArrears(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 58:
                    datafile.setEquipType(data);
                  break;
                case 59:
                    datafile.setEquipDescription(data);
                  break;
                case 60:
                    datafile.setAge(setDoubleValue(rowNum ,cellNum, data));
                  break;
                case 61:
                    datafile.setExpDate(new SimpleDateFormat("dd/MM/yyyy").parse(data));
                  break;
                case 62:
                    datafile.setSector(data);
                  break;
                case 63:
                    datafile.setDistrict(data);
                  break;
            }
        }catch (ParseException | NumberFormatException paEx ){
            paEx.printStackTrace();
        }
        return datafile;
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

}
