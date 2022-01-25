package com.rambo.spider.events;

import com.rambo.spider.entity.Datafile;
import com.rambo.spider.entity.Matrix;
import com.rambo.spider.entity.Pdcprocess;
import com.rambo.spider.entity.ReceiptReport;
import com.rambo.spider.repository.DatafileRepository;
import com.rambo.spider.repository.MatrixRepository;
import com.rambo.spider.repository.PdcProcessRepository;
import com.rambo.spider.repository.ReceiptReportRepository;
import com.rambo.spider.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Service
public class LGDProcessManager implements Runnable {
    @Autowired
    DatafileRepository datafileRepository;
    @Autowired
    ReceiptReportRepository receiptReportRepository;
    @Autowired
    PdcProcessRepository pdcProcessRepository;
    @Autowired
    MatrixRepository matrixRepository;

    @Override
    public void run() {
        while (true) {
            try {
                if (pdcProcessRepository.existsByStageAndBasis(1,"LGD")) {
                    Pdcprocess pdcprocess = pdcProcessRepository.findByStageAndBasis(1,"LGD");
                    pdcprocess.setStage(2);
                    pdcProcessRepository.save(pdcprocess);
                    System.out.println(pdcprocess.getProduct());
                    List<Datafile> datafileList = datafileRepository.findAllByProductOrderByFacilityNoAscMonthAsc(pdcprocess.getProduct());
                    System.out.println("Number of lines : " + datafileList.size());
                    Datafile datafile = DataMapper.calculationFirstRow(datafileList.get(0), datafileList.get(1), pdcprocess.getBasis());
//                    System.out.println("0"+"\t"+datafile);
                    datafileRepository.save(datafile);

                    for (int i = 1; i < datafileList.size() - 1; i++) {
                        try {
                            datafile = DataMapper.calculation(datafileList.get(i - 1), datafileList.get(i), datafileList.get(i + 1), i, pdcprocess.getBasis());
                            System.out.println( i+"\t"+datafile);
                        } catch (Exception ee) {
                            ee.printStackTrace();
                            break;
                        }
//                        datafileRepository.save(datafile);
                    }

                    datafile = DataMapper.calculationLastRow(datafileList.get(datafileList.size()-2), datafileList.get(datafileList.size()-1), pdcprocess.getBasis());
                    System.out.println(datafileList.size()-1+"\t"+datafile);
                    datafileRepository.save(datafile);

                    datafile = null;

                    List<Datafile> nonPerformFullList = datafileRepository.findAllByProductAndDcOrderByFacilityNoAscMonthAsc(pdcprocess.getProduct(),new Double(8));
                    List<Datafile> nonPerformFilteredList =new ArrayList<>();

                    for (int i=0; i<nonPerformFullList.size(); i++) {
                        if(i==0){
                            System.out.println("maxedOutDcList\\t"+i+"\t"+nonPerformFullList.get(i));
                            nonPerformFilteredList.add(nonPerformFullList.get(i));
                        }else{
                            if(nonPerformFullList.get(i).getFacilityNo().equals(nonPerformFullList.get(i-1).getFacilityNo())){

                            }else{
                                System.out.println(i+"\t"+nonPerformFullList.get(i));
                                nonPerformFilteredList.add(nonPerformFullList.get(i));
                            }

                        }


                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

                    double gross_reciepts_amount = 0;
                    double pvFactor = 0;
                    double pvReciepts = 0;
                    double recoveryRate = 0;
                    double lgd = 0;

                        for (Datafile nonPerformDatafile : nonPerformFilteredList) {
                        List<ReceiptReport> recieptAfterNPLDateList = receiptReportRepository.findAllByFacilityNoAndDateGreaterThan(nonPerformDatafile.getFacilityNo(), nonPerformDatafile.getMonth());


                        for (ReceiptReport receiptReport:recieptAfterNPLDateList) {
                            Date firstDate = nonPerformDatafile.getMonth();
                            Date secondDate = receiptReport.getDate();

                            long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
                            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                            receiptReport.setDateGap((int) diff);

                            pvFactor = 1/Math.pow(1+nonPerformDatafile.getInterestRate()/365,(int) diff);
                            receiptReport.setPvFactor(pvFactor);
                            pvReciepts = pvReciepts +( pvFactor * receiptReport.getAmount());

                        }

                        recoveryRate = pvReciepts/nonPerformDatafile.getTotOutstanding();
                        lgd = 1-recoveryRate;

                            System.out.println(
                                    nonPerformDatafile.getFacilityNo() +"\t" +
                                            nonPerformDatafile.getTotOutstanding()+"\t" +
                                            nonPerformDatafile.getInterestRate() +"\t" +
                                            pvReciepts     +"\t" +
                                            recoveryRate*100 +"%"   +"\t" +
                                            lgd
                            );
                    }


                    }

                }
                Thread.sleep(1000 * 11);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
