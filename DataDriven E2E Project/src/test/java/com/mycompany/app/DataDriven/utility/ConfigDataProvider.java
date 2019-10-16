package com.mycompany.app.DataDriven.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	private Properties prop = null;
	private FileInputStream fis = null;

	public Properties getProperties() {
		prop = new Properties();
		try {
			fis = new FileInputStream(
					"./src/test/resources/com/mycompany/app/DataDriven/resources/configurationData.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}
		return prop;
	}
}
