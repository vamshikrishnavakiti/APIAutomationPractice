package com.testingacademy.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

    public static String readkey(String key){
        Properties properties = new Properties();
        try {
            FileInputStream fileinputstream = new FileInputStream("data.properties");
            properties.load(fileinputstream);
            return properties.getProperty(key);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return properties.getProperty(key);
    }
}
