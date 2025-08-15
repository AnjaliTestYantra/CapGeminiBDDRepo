package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility {
	public String readDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./configAppData/CommonData.properties");
		Properties prop= new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
	}

}
