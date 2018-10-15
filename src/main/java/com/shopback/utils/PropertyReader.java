package com.shopback.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public static String readConfigProperties(String key)
    {
        String value = "";
        try{
            InputStream inputStream = new FileInputStream("src/main/resources/Config.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            value = properties.getProperty(key);
        }catch(IOException e){e.printStackTrace();}

        return value;

    }
}
