package com.sefra.utils;

import java.io.*;
import java.net.URL;

/**
 * Util for loading resources
 * @author Krzysztof Korolczuk <krzysztofkorolczuk2@gmail.com>
 */
public class ResourceUtil {

    private ResourceUtil() {
    }

    public static File loadFileFromResources(String path) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(path);
        if (url == null || url.getPath() == null) {
            return null;
        }
        return new File(url.getPath());
    }

    public static InputStream loadStreamFromResources(String path) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    }

    public static void printFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

}

