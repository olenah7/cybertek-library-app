package com.cybertek.library.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * this util is used to read values from configuration.properties file
 */

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {
        try {
            //open the file using inputstream
            FileInputStream inputStream = new FileInputStream("configuration.properties");

            //load to properties object
            properties.load(inputStream);

            //close the file after loading
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * method is used to read value from a configuration.properties file
     * @param key -> key name is properties file
     * @return -> value for the key. returns null if key nof found
     * EX: driver.get( ConfigurationReader.getProperty("url") ) ;
     */
    public static String getProperty(String key){
        return properties.getProperty(key);

    }


}