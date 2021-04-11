package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	
	public Properties init_prop () {
		
		/*1. this method is used to load the properties from config.properties file 
		 * 
		 *2. It returns Properties prop object 
		*/
		prop = new Properties();
		
		FileInputStream ip = null;
		try {
			ip = new FileInputStream("D:\\selenium java workspace\\HybridCucumberFramework\\"
					+ "src\\test\\resources\\config\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return prop;
	}

}
