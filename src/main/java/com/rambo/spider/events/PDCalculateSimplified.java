package com.rambo.spider.events;

import com.rambo.spider.entity.Infotemplatepreview;
import com.rambo.spider.entity.PdCalSimplified;
import com.rambo.spider.entity.Pdcprocess;
import com.rambo.spider.repository.*;
import com.rambo.spider.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PDCalculateSimplified implements Runnable {
    @Autowired
    DatafileRepository datafileRepository;
    @Autowired
    PdCalculateSimplifiedRepository pdCalculateSimplifiedRepository;
    @Autowired
    InfotemplatepreviewRepository infotemplatepreviewRepository ;
    @Autowired
    MatrixRepository matrixRepository;

    @Override
    public void run() {
        while (true) {
            try {
                if (pdCalculateSimplifiedRepository.existsByStageAndBasis(1,"SIM")) {
                    PdCalSimplified pdcprocess = pdCalculateSimplifiedRepository.findByStageAndBasis(1,"SIM").get(0);;
                    pdcprocess.setStage(2);
                    pdCalculateSimplifiedRepository.save(pdcprocess);

                    List<Infotemplatepreview> list = infotemplatepreviewRepository.findAllByStateOrderByMonthDesc(1);
                    for (int i = 0; i < list.size()-1; i++) {

                        Infotemplatepreview infotemplatepreview = new Infotemplatepreview();
                        infotemplatepreview.setId(list.get(i).getId());
                        infotemplatepreview.setMonth(list.get(i).getMonth());
                        infotemplatepreview.setBucket1(list.get(i).getBucket1());
                        infotemplatepreview.setBucket2(list.get(i).getBucket2());
                        infotemplatepreview.setBucket3(list.get(i).getBucket3());
                        infotemplatepreview.setBucket4(list.get(i).getBucket4());
                        infotemplatepreview.setBucket5(list.get(i).getBucket5());
                        infotemplatepreview.setBucket6(list.get(i).getBucket6());
                        infotemplatepreview.setBucket7(list.get(i).getBucket7());
                        infotemplatepreview.setBucket8(list.get(i).getBucket8());
                        infotemplatepreview.setState(2);
                        for (int j = 0; j < Integer.parseInt(pdcprocess.getDefaultPoint()); j++) {
                            if(j == 0){
                                infotemplatepreview.setPdb1(DataMapper.generatePDBPecentage(list.get(i).getBucket2(),list.get(i+1).getBucket1()));
                            }
                            if(j == 1){
                                infotemplatepreview.setPdb2(DataMapper.generatePDBPecentage(list.get(i).getBucket3(),list.get(i+1).getBucket2()));
                            }
                            if(j == 2){
                                infotemplatepreview.setPdb3(DataMapper.generatePDBPecentage(list.get(i).getBucket4(),list.get(i+1).getBucket3()));
                            }
                            if(j == 3){
                                infotemplatepreview.setPdb4(DataMapper.generatePDBPecentage(list.get(i).getBucket5(),list.get(i+1).getBucket4()));
                            }
                            if(j == 4){
                                infotemplatepreview.setPdb5(DataMapper.generatePDBPecentage(list.get(i).getBucket6(),list.get(i+1).getBucket5()));
                            }
                            if(j == 5){
                                infotemplatepreview.setPdb6(DataMapper.generatePDBPecentage(list.get(i).getBucket7(),list.get(i+1).getBucket6()));
                            }
                            if(j == 6){
                                infotemplatepreview.setPdb7(DataMapper.generatePDBPecentage(list.get(i).getBucket8(),list.get(i+1).getBucket7()));
                            }
                        }
                        infotemplatepreviewRepository.save(infotemplatepreview);
                        System.out.println(infotemplatepreview.toString());
                    }
                    list.clear();
                    list = infotemplatepreviewRepository.findAllByStateOrderByMonthDesc(2);
                    double pdb1Sum = 0;
                    double pdb2Sum = 0;
                    double pdb3Sum = 0;
                    double pdb4Sum = 0;
                    double pdb5Sum = 0;
                    double pdb6Sum = 0;
                    double pdb7Sum = 0;
                    double pdb8Sum = 0;
                    double pdb1Average = 0;
                    double pdb2Average = 0;
                    double pdb3Average = 0;
                    double pdb4Average = 0;
                    double pdb5Average= 0;
                    double pdb6Average = 0;
                    double pdb7Average = 0;
                    double pdb8Average= 0;
                    for (Infotemplatepreview infotemplatepreview: list) {
                        pdb1Sum = pdb1Sum + infotemplatepreview.getPdb1();
                        pdb2Sum = pdb2Sum + infotemplatepreview.getPdb2();
                        pdb3Sum = pdb3Sum + infotemplatepreview.getPdb3();
                        pdb4Sum = pdb4Sum + infotemplatepreview.getPdb4();
                        pdb5Sum = pdb5Sum + infotemplatepreview.getPdb5();
                        pdb6Sum = pdb6Sum + infotemplatepreview.getPdb6();
                        pdb7Sum = pdb7Sum + infotemplatepreview.getPdb7();
                        pdb8Sum = pdb8Sum + infotemplatepreview.getPdb8();
                    }
                    pdb1Average = pdb1Sum/list.size();
                    pdb2Average = pdb2Sum/list.size();
                    pdb3Average = pdb3Sum/list.size();
                    pdb4Average = pdb4Sum/list.size();
                    pdb5Average = pdb5Sum/list.size();
                    pdb6Average = pdb6Sum/list.size();
                    pdb7Average = pdb7Sum/list.size();
                    pdb8Average = pdb8Sum/list.size();

                    double[] numArray ;

                }
                Thread.sleep(1000 * 11);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static double calculateSD(double numArray[])
    {
        double sum = 0.0, standardDeviation = 0.0;
        int length = numArray.length;

        for(double num : numArray) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: numArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);
    }
}
