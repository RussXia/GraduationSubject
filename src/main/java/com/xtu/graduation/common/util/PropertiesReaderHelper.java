package com.xtu.graduation.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReaderHelper {

	private static Properties prop = null;
	private static InputStream is = null; 
	public static Properties getEmailProperties(){
		if(is == null){
			is = PropertiesReaderHelper.class.getClassLoader().getResourceAsStream("env/email.properties");
		}
		if(prop == null){
			prop = new Properties();
			try {
				prop.load(is);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		return prop;
	}
}
