package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utility{
    public String reader(String key) throws IOException {
        Properties props = new Properties();
        FileReader reader = new FileReader("ConfigFile.properties");
        props.load(reader);
        props.getProperty(key);
                return key;
    }

}