package com.rambo.spider.listener;

import com.rambo.spider.repository.PdcProcessRepository;
import com.rambo.spider.service.GeneralService;
import com.rambo.spider.util.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.File;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

@Service
public class GeneralFileReader implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralFileReader.class);
    public static String deployedDate = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date());

    @Value(value = "${file.watch.path.pdc}")
    private String FILE_PATH_PDC;
    @Value(value = "${file.watch.pdc.poll.interval}")
    private int POLL_INTERVAL;
    @Value(value = "${file.watch.pdc.read.delay}")
    private int READ_DELAY;
    @Autowired
    GeneralService generalService;
    @Autowired
    PdcProcessRepository pdcProcessRepository;

    @Override
    public void run() {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path path = Paths.get(FILE_PATH_PDC);
//            path.register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
            path.register(watchService, ENTRY_CREATE);
            LOGGER.info("Listening for {}", path.toAbsolutePath());
            boolean poll = true;

            while (true) {
                File FOLDER_PATH = new File(FILE_PATH_PDC);
                File[] LIST_OF_FILES = FOLDER_PATH.listFiles();
                for (int i = 0; i < LIST_OF_FILES.length; i++) {
                    if (LIST_OF_FILES[i].isFile()) {
                        String SAMPLE_XLSX_FILE_PATH = FILE_PATH_PDC + LIST_OF_FILES[i].getName();
                        LOGGER.info("File process started {}", LIST_OF_FILES[i].getName());
                        Thread.sleep(READ_DELAY);
                        generalService.processGeneralApproach(SAMPLE_XLSX_FILE_PATH,LIST_OF_FILES[i].getName());

                        Common.deleteFile(SAMPLE_XLSX_FILE_PATH);

                        LOGGER.info("File process finished {}", LIST_OF_FILES[i].getName());
                    }
                }
                try {
                    Thread.sleep(2000);
                }catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
