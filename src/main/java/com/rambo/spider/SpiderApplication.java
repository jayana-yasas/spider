package com.rambo.spider;

import com.rambo.spider.events.LGDProcessManager;
import com.rambo.spider.listener.GeneralFileReader;
import com.rambo.spider.events.ProcessManager;
import com.rambo.spider.listener.LGDFileReader;
import com.rambo.spider.listener.SimplifiedFileReader;
import com.rambo.spider.events.SimplifiedProcessManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@SpringBootApplication
@EnableScheduling
public class SpiderApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpiderApplication.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext context =  SpringApplication.run(SpiderApplication.class, args);

        ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) context.getBean("taskExecutor");

        try {
            ProcessManager processManager=context.getBean(ProcessManager.class);
            taskExecutor.execute(processManager);
            SimplifiedProcessManager simplifiedProcessManager=context.getBean(SimplifiedProcessManager.class);
            taskExecutor.execute(simplifiedProcessManager);
            LGDProcessManager lgdProcessManager=context.getBean(LGDProcessManager.class);
            taskExecutor.execute(lgdProcessManager);
            LOGGER.info("Initialized PD data processing");
        }catch (Exception e){
            LOGGER.error("Error, Something went wrong with ProcessManager Thread");
            System.exit(0);
        }
        try {
            GeneralFileReader fileProcessor=context.getBean(GeneralFileReader.class);
            taskExecutor.execute(fileProcessor);
            SimplifiedFileReader simplifiedFileReader=context.getBean(SimplifiedFileReader.class);
            taskExecutor.execute(simplifiedFileReader);
            LGDFileReader lgdFileReader=context.getBean(LGDFileReader.class);
            taskExecutor.execute(lgdFileReader);

            LOGGER.info("Initialized file reading");
        }catch (Exception e){
            LOGGER.error("Error, Something went wrong with FileReader Thread");
            System.exit(0);
        }

    }


}
