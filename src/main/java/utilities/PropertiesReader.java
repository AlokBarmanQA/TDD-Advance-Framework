package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesReader {
	
	public static String getPropertyValueByKey(String key) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("../TDD-Advance-Framework/src/test/resources/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String propertyValue = prop.get(key).toString();
		if(StringUtils.isEmpty(propertyValue)) {
			try {
				throw new Exception("Value is not specified for '" + key + "' in Properties file");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return propertyValue;
	}
}
