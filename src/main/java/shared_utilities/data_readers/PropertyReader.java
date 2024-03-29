package shared_utilities.data_readers;

import shared_utilities.data_readers.property_file.PropertyFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class PropertyReader {

    public static String getProperty(String fileName, String key) {
        String property = null;
        try {
            Properties properties = new Properties();
            properties.load(PropertyReader.class.getResourceAsStream(fileName));
            property = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }

    public static String getProperty(PropertyFile propertyFile, String key) {
        String property = null;
        try {
            Properties properties = new Properties();
            properties.load(PropertyReader.class.getResourceAsStream(propertyFile.getFilePath()));
            property = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }

    public static HashMap<String, Object> getFileAsMap(String file) {
        try {
            HashMap<String, Object> mapOfProperties = new HashMap<>();
            Properties properties = new Properties();
            properties.load(PropertyReader.class.getResourceAsStream(file));
            for (Object o : properties.keySet()) {
                String value = properties.getProperty(o.toString());
                mapOfProperties.put(o.toString(), value);
            }
            return mapOfProperties;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static HashMap<String, Object> getFileAsMap(PropertyFile propertyFile) {
        try {
            HashMap<String, Object> mapOfProperties = new HashMap<>();
            Properties properties = new Properties();
            properties.load(PropertyReader.class.getResourceAsStream(propertyFile.getFilePath()));
            for (Object o : properties.keySet()) {
                String value = properties.getProperty(o.toString());
                mapOfProperties.put(o.toString(), value);
            }
            return mapOfProperties;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> getFileAsList(String fileName) {
        try {
            List<String> listOfProperties = new ArrayList<>();
            Properties properties = new Properties();
            properties.load(PropertyReader.class.getResourceAsStream(fileName));
            for (Object o : properties.keySet()) {
                String value = properties.getProperty(o.toString());
                if (!value.equals("false") && !value.equals("")) {
                    listOfProperties.add(o + "=" + value);
                }
            }
            return listOfProperties;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> getFileAsList(PropertyFile propertyFile) {
        try {
            List<String> listOfProperties = new ArrayList<>();
            Properties properties = new Properties();
            properties.load(PropertyReader.class.getResourceAsStream(propertyFile.getFilePath()));
            for (Object o : properties.keySet()) {
                String value = properties.getProperty(o.toString());
                if (!value.equals("false") && !value.equals("")) {
                    listOfProperties.add(o + "=" + value);
                }
            }
            return listOfProperties;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
