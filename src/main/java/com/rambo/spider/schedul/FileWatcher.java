package com.rambo.spider.schedul;

import com.rambo.spider.repository.PdcProcessRepository;
import com.rambo.spider.service.ExcelFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

@Component
public class FileWatcher {
    @Value(value = "${file.watch.path.pdc}")
    private String FILE_PATH_PDC;
    @Value(value = "${file.watch.pdc.poll.interval}")
    private int POLL_INTERVAL;
    @Value(value = "${file.watch.pdc.read.delay}")
    private int READ_DELAY;
    @Autowired
    ExcelFileService excelFileService;
    @Autowired
    PdcProcessRepository pdcProcessRepository;
    @Scheduled(initialDelay = 1000 * 2, fixedDelay=Long.MAX_VALUE)
    public void watchFile(){
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path path = Paths.get(FILE_PATH_PDC);
//            path.register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
            path.register(watchService, ENTRY_CREATE);

            System.out.println("Listening for   :"+path.toAbsolutePath());
            boolean poll = true;

            while (poll) {
                if(pdcProcessRepository.existsByStage(2)){
                    WatchKey key = watchService.take();

                    for (WatchEvent<?> event : key.pollEvents()) {
                        System.out.println("Event kind : " + event.kind() + " - File : " + event.context());
                        String SAMPLE_XLSX_FILE_PATH = FILE_PATH_PDC+event.context().toString(); //         C:\\AA\\file_name.xlms
                        System.out.println(SAMPLE_XLSX_FILE_PATH);
                        Thread.sleep(READ_DELAY);
                        excelFileService.getSheets(SAMPLE_XLSX_FILE_PATH);
                        System.out.println("Event done, File : " + event.context());
                        deleteFile(SAMPLE_XLSX_FILE_PATH);
                    }
                    poll = key.reset();
                }
                Thread.sleep(POLL_INTERVAL);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteFile(String SAMPLE_XLSX_FILE_PATH){
        try{
            Files.deleteIfExists(Paths.get(SAMPLE_XLSX_FILE_PATH));
        }
        catch(NoSuchFileException e){
            System.out.println("No such file/directory exists");
        }
        catch(DirectoryNotEmptyException e){
            System.out.println("Directory is not empty.");
        }
        catch(IOException e){
            System.out.println("Invalid permissions.");
        }
        System.out.println("Deletion successful.");
    }

}
