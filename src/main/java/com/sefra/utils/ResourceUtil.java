package com.sefra.utils;

import java.io.File;
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

}

