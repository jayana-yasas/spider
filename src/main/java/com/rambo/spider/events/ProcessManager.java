package com.rambo.spider.events;

import com.rambo.spider.entity.Datafile;
import com.rambo.spider.entity.Matrix;
import com.rambo.spider.entity.Pdcprocess;
import com.rambo.spider.repository.DatafileRepository;
import com.rambo.spider.repository.MatrixRepository;
import com.rambo.spider.repository.PdcProcessRepository;
import com.rambo.spider.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessManager implements Runnable {
    @Autowired
    DatafileRepository datafileRepository;
    @Autowired
    PdcProcessRepository pdcProcessRepository;
    @Autowired
    MatrixRepository matrixRepository;

    @Override
    public void run() {
        while (true) {
            try {
                if (pdcProcessRepository.existsByStageAndBasis(1,"DPD")) {
                    Pdcprocess pdcprocess = pdcProcessRepository.findByStageAndBasis(1,"DPD");
                    pdcprocess.setStage(2);
                    pdcProcessRepository.save(pdcprocess);

                    List<Datafile> datafileList = datafileRepository.findAllByOrderByFacilityNoAscMonthAsc();
                    System.out.println("Number of lines : " + datafileList.size());
                    Datafile datafile = DataMapper.calculationFirstRow(datafileList.get(0), datafileList.get(1), pdcprocess.getBasis());
                    System.out.println("0"+"\t"+datafile);
                    datafileRepository.save(datafile);

                    for (int i = 1; i < datafileList.size() - 1; i++) {
                        try {
                            datafile = DataMapper.calculation(datafileList.get(i - 1), datafileList.get(i), datafileList.get(i + 1), i, pdcprocess.getBasis());
                            System.out.println( i+"\t"+datafile);
                        } catch (Exception ee) {
                            ee.printStackTrace();
                            break;
                        }
                        datafileRepository.save(datafile);
                    }
                    datafile = DataMapper.calculationLastRow(datafileList.get(datafileList.size()-2), datafileList.get(datafileList.size()-1), pdcprocess.getBasis());
                    System.out.println(datafileList.size()-1+"\t"+datafile);
                    datafileRepository.save(datafile);

                    datafile = null;

                    List<Datafile> lastdatafileList = datafileRepository.findByLastIsNotNullAndLastIsNot("N");
                    Matrix matrix = new Matrix();
                    System.out.println("lastdatafileList size \t" + lastdatafileList.size());
                    String toConsole = "";

                    for (int first = 1; first <= 8; first++) {
                        int total = 0;
                        double percentage = 0;
                        matrix.setFirst(first);
                        for (int worst = 1; worst <= 8; worst++) {
                            double double_first = first;
                            double double_worst = worst;
                            int count = datafileRepository.findByFirstAndWorstAndLastIsNot(double_first, double_worst, "N").size();
                            total = total + count;
                            if (worst == 1) {
                                matrix.setC1(count);
                                toConsole = toConsole + "\n" + count + "\t";
                            }
                            if (worst == 2) {
                                matrix.setC2(count);
                                toConsole = toConsole + count + "\t";
                            }
                            if (worst == 3) {
                                matrix.setC3(count);
                                toConsole = toConsole + count + "\t";
                            }
                            if (worst == 4) {
                                matrix.setC4(count);
                                toConsole = toConsole + count + "\t";
                            }
                            if (worst == 5) {
                                matrix.setC5(count);
                                toConsole = toConsole + count + "\t";
                            }
                            if (worst == 6) {
                                matrix.setC6(count);
                                toConsole = toConsole + count + "\t";
                            }
                            if (worst == 7) {
                                matrix.setC7(count);
                                toConsole = toConsole + count + "\t";
                            }
                            if (worst == 8) {
                                matrix.setC8(count);

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
                        matrix.setGrandTotal(total);
                        if (total != 0) {
                            percentage = (double) matrix.getC8() / total;
                            matrix.setPercentage(percentage);
//                        System.out.println(matrix.getC8() + "\t" + total + "\t" + percentage);
                        } else {
                            matrix.setPercentage(0.0);
                        }
                        matrixRepository.save(matrix);
                    }
                    System.out.println(toConsole);
                }
                Thread.sleep(1000 * 11);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
