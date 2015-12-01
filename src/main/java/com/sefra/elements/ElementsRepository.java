package com.sefra.elements;

import com.sefra.SefraException;
import com.sefra.utils.ResourceUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ElementsRepository {

    private Properties properties = new Properties();

    public ElementsRepository(String propertyFile) throws SefraException {
        try (InputStream stream = new FileInputStream(
                ResourceUtil.loadFileFromResources(propertyFile))) {
            properties.load(stream);
        }
        catch(IOException e){
            throw new SefraException("Cannot read element repository: " + propertyFile);
        }
    }

    public Properties getElements() {
        return properties;
    }

}
