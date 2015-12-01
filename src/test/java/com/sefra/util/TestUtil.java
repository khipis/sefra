package com.sefra.util;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;


public class TestUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestUtil.class);

    public static final String TEXT_ONE = "text_one.txt";
    public static final String TEXT_TWO = "text_two.txt";

    public static final String GENERATED_XML_PATH = "target/generated-test-sources/xml/";


    private TestUtil() {
    }

    public static void cleanFolder(String path) throws IOException {
        File folderDir = new File(path);
        if (folderDir.exists()) {
            FileUtils.deleteDirectory(folderDir);
        }

        Files.createDirectories(folderDir.toPath());
    }

    @Deprecated
    public static void printFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            for (String line; (line = br.readLine()) != null; ) {
                LOGGER.info(line);
            }
        } catch (IOException e) {
            LOGGER.error("Cannot print file: " + filePath, e.getMessage());
        }

    }


}
