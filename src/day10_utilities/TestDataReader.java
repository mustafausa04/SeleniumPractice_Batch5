package day10_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TestDataReader {
	//we have to create this class so we can implement it in the Driver.java file it's part of the requirement
	//that we don't have to worry about it
	
    private static Properties property;
    
    static {
    	try {
    		File file = new File("./src/test/resources/testData/testData.properties");
    		FileInputStream input = new FileInputStream(file);
    		property = new Properties();
    		property.load(input);
    		input.close();
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static String getProperty(String key) {
    	return property.getProperty(key);
    }

}
