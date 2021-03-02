package br.com.testejusta.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {

	public String getSiConvertion(String key) throws IOException {
		String value = "";
		Properties properties = new Properties();
		String propFileName = "convertion.properties";

		InputStream inputFile = getClass().getClassLoader().getResourceAsStream(propFileName);
		
		if(inputFile != null ) {
			properties.load(inputFile);
		} else {
			throw new FileNotFoundException("Propertie : " + propFileName + " has not found!");
		}
		
		value = ( properties.getProperty(key));

		return value;
	}
}
