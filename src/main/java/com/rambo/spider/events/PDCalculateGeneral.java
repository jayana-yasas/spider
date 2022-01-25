package com.rambo.spider.events;

import com.rambo.spider.bean.MatrixBean;
import com.rambo.spider.entity.*;
import com.rambo.spider.repository.*;
import com.rambo.spider.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PDCalculateGeneral implements Runnable {
    @Autowired
    DatafileRepository datafileRepository;
    @Autowired
    PdCalculateGeneralRepository pdCalculateGeneralRepository;
    @Autowired
    MatrixRepository matrixRepository;
    @Autowired
    PdCalGeneralMatrixRepository pdCalGeneralMatrixRepository;

    @Override
    public void run() {
        while (true) {
            try {
                if (pdCalculateGeneralRepository.existsByStageAndBasis(1,"DPD")) {
                    PdCalGeneral pdcprocess = pdCalculateGeneralRepository.findByStageAndBasis(1,"DPD").get(0);
                    pdcprocess.setStage(2);
                    pdCalculateGeneralRepository.save(pdcprocess);

                    List<Datafile> datafileList = datafileRepository.findAllByOrderByFacilityNoAscMonthAsc();
                    List<Datafile> datafileListTemp = new ArrayList<>();
                    List<Datafile> lastdatafileListTemp = new ArrayList<>();
                    System.out.println("Number of lines : " + datafileList.size());
                    Datafile datafile = DataMapper.calculationFirstRow(datafileList.get(0), datafileList.get(1), pdcprocess.getBasis());
                    System.out.println("0"+"\t"+datafile);

//                    datafileRepository.save(datafile);  //to database
                    datafileListTemp.add(datafile);     //to memory

                    for (int i = 1; i < datafileList.size() - 1; i++) {
                        try {
                            datafile = DataMapper.calculation(datafileList.get(i - 1), datafileList.get(i), datafileList.get(i + 1), i, pdcprocess.getBasis());
                            System.out.println( i+"\t"+datafile);
                        } catch (Exception ee) {
                            ee.printStackTrace();
                            break;
                        }
//                        datafileRepository.save(datafile);  //to database
                        datafileListTemp.add(datafile);     //to memory
                    }
                    datafile = DataMapper.calculationLastRow(datafileList.get(datafileList.size()-2), datafileList.get(datafileList.size()-1), pdcprocess.getBasis());
                    System.out.println(datafileList.size()-1+"\t"+datafile);
//                    datafileRepository.save(datafile);  //to database
                    datafileListTemp.add(datafile);     //to memory

//                    List<Datafile> lastdatafileList = datafileRepository.findByLastIsNotNullAndLastIsNot("N");

                    for ( Datafile df:datafileListTemp) {
                        if(df.getLast()!=null && !df.getLast().equals("N")){
                            lastdatafileListTemp.add(df);
                        }
                    }

                    List<Datafile> lastdatafileList = lastdatafileListTemp;
                    List<Datafile> fandwListList = new ArrayList<>();
                    Matrix matrix = new Matrix();

                    List<MatrixBean> matrixBeanList = new ArrayList<>();
                    System.out.println("lastdatafileList size \t" + lastdatafileList.size());
                    String toConsole = "";
                    String matrixStr = "";
                    HashMap<String, List<Double>> jsonMap = new HashMap<>();
                    matrixStr = "";
                    for (int first = 1; first <= 8; first++) {
                        int total = 0;
                        double percentage = 0;
                        matrix.setFirst(first);
                        List<Double> arr =new ArrayList<>();
                        for (int worst = 1; worst <= 8; worst++) {
                            double double_first = first;
                            double double_worst = worst;
//                            int count = datafileRepository.findByFirstAndWorstAndLastIsNot(double_first, double_worst, "N").size();

                            for ( Datafile df:datafileListTemp) {
                                if(df.getFirst() == double_first && df.getWorst()==double_worst && !df.getLast().equals("N")){
                                    fandwListList.add(df);
                                }
                            }

                            int count = fandwListList.size();

                            total = total + count;
                            if (worst == 1) {
                                matrix.setC1(count);
                                arr.add((double) count);
                                toConsole = toConsole + "\n" + count + "\t";
                            }
                            if (worst == 2) {
                                matrix.setC2(count);
                                arr.add((double) count);
                                toConsole = toConsole + count + "\t";
                            }
                            if (worst == 3) {
                                matrix.setC3(count);
                                arr.add((double) count);
                                toConsole = toConsole + count + "\t";
                            }
                            if (worst == 4) {
                                matrix.setC4(count);
                                arr.add((double) count);
                                toConsole = toConsole + count + "\t";
                            }
                            if (worst == 5) {
                                matrix.setC5(count);
                                arr.add((double) count);
                                toConsole = toConsole + count + "\t";
                            }
                            if (worst == 6) {
                                matrix.setC6(count);
                                arr.add((double) count);
                                toConsole = toConsole + count + "\t";
                            }
                            if (worst == 7) {
                                matrix.setC7(count);
                                arr.add((double) count);
                                toConsole = toConsole + count + "\t";
                            }
                            if (worst == 8) {
                                matrix.setC8(count);
                                arr.add((double) count);
                                toConsole = toConsole + count + "\t";
                                toConsole = toConsole + total + "\t";

                                if (total != 0) {
                                    double per_count = count;
                                    double per = per_count / total;

                                    toConsole = toConsole + per + "\t";
                                } else {
                                    toConsole = toConsole + "--";
                                }
                            }

                        }
                        arr.add((double) total);
                        matrix.setGrandTotal(total);

                        if (total != 0) {
                            percentage = (double) matrix.getC8() / total;
                            matrix.setPercentage(percentage);
                            arr.add(arr.get(7)/total);

                        } else {
                            matrix.setPercentage(0.0);
                            arr.add(0.0);
                        }
                        MatrixBean matrixBean = new MatrixBean();
                        matrixBean.setLbl("lbl_"+first);
                        matrixBean.setArr(arr);

                        jsonMap.put("lbl_"+first, arr);
                        matrixBeanList.add(first-1,matrixBean);
                        matrixRepository.save(matrix);

                        matrixStr = matrixStr+ "|"+
                                +first + "|"+
                                +arr.get(0) + "|"+
                                +arr.get(1) + "|"+
                                +arr.get(2) + "|"+
                                +arr.get(3) + "|"+
                                +arr.get(4) + "|"+
                                +arr.get(5) + "|"+
                                +arr.get(6) + "|"+
                                +arr.get(7) + "|"+
                                +arr.get(8) + "|"+
                                +arr.get(9)  ;
                    }
                    System.out.println(matrixStr);
                    System.out.println(matrixBeanList.toString());
//                    for (Map.Entry<String, ArrayList<Double>> entry : jsonMap.entrySet()){
//                        System.out.println(entry.getKey()+"\t"+entry.getValue().toString());
//                    }

                    PdCalGeneralMatrix pdCalGeneralMatrix = new PdCalGeneralMatrix();
                    pdCalGeneralMatrix.setId(pdcprocess.getId());
                    pdCalGeneralMatrix.setMatrix(matrixStr);
                    pdCalGeneralMatrixRepository.save(pdCalGeneralMatrix);
                    System.out.println(toConsole);
                }
                Thread.sleep(1000 * 11);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
