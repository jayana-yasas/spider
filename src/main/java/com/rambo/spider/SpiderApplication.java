package com.rambo.spider;

import com.rambo.spider.events.FileReader;
import com.rambo.spider.events.ProcessManager;
import com.rambo.spider.events.SimplifiedFileReader;
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
            LOGGER.info("Initialized PD data processing");
        }catch (Exception e){
            LOGGER.error("Error, Something went wrong with ProcessManager Thread");
            System.exit(0);
        }
        try {
            FileReader fileProcessor=context.getBean(FileReader.class);
            taskExecutor.execute(fileProcessor);
            SimplifiedFileReader simplifiedFileReader=context.getBean(SimplifiedFileReader.class);
            taskExecutor.execute(simplifiedFileReader);
            LOGGER.info("Initialized file reading");
        }catch (Exception e){
            LOGGER.error("Error, Something went wrong with FileReader Thread");
            System.exit(0);
        }

    }


}
