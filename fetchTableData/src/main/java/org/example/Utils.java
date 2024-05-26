package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
    public String reader(String key) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("ConfigFile.properties");
        try {

            if (inputStream == null) {
                throw new FileNotFoundException("Config file 'ConfigFile.properties' not found in the classpath");
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        Properties props=new Properties();
        props.load(inputStream);

        key=props.getProperty(key);
        return key;
    }
}
