package com.rambo.spider.util;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class Common {

    public static void deleteFile(String SAMPLE_XLSX_FILE_PATH) {
        try {
            Files.deleteIfExists(Paths.get(SAMPLE_XLSX_FILE_PATH));
        } catch (NoSuchFileException e) {
            System.out.println("No such file/directory exists");
        } catch (DirectoryNotEmptyException e) {
            System.out.println("Directory is not empty.");
        } catch (IOException e) {
            System.out.println("Invalid permissions.");
        }
        System.out.println("Deletion successful.");
    }
}
