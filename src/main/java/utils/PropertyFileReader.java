package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

    FileInputStream fis;
    Properties properties;

    public PropertyFileReader(String filename){
        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/properties/"+filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        properties = new Properties();
        try {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }


}