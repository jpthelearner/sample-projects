package com.jp.app_name.util;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtil {
	
	private static Logger log = Logger.getLogger(PropertiesUtil.class);

	public static Properties loadPropertiesFromFile(String fileName)
	{
		log.debug("Method Entry: loadPropertiesFromFile, fileName - "+ fileName);
		Properties returnValue = new Properties();
		InputStream is = null;
		try
		{
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			returnValue.load(is);
		}
		catch (Exception ex)
		{
			if(fileName.equals("override.properties")) {
				log.info("Error initializing props from override.properties. Looks like property overriding is not intended.");
			} else {
				log.error("Error in loadPropertiesFromFile, fileName - "+fileName, ex);
			}
		}
		finally{
			try
			{
				if(is!=null) is.close();
			}catch(java.io.IOException e){
				log.error(e);
			}
		}
		log.debug("Method Exit: loadPropertiesFromFile, fileName - "+fileName +" - "+returnValue);
		return returnValue;
	}
	
	public static String getProperty(String propertyName) {
		return loadPropertiesFromFile("application.properties").getProperty(propertyName);
	}
	
	public static boolean getBooleanProperty(String propertyName) {
		boolean result = false;
		String value = loadPropertiesFromFile("application.properties").getProperty(propertyName);
		if(value != null && value.trim().equalsIgnoreCase("true"))
			result = true;
		return result;
	}	
	
	public static Long getLongProperty(String propertyName) {
		Long result = null;
		String value = loadPropertiesFromFile("application.properties").getProperty(propertyName);
		if(value != null ) {			
			result = Long.parseLong(value);
		}
		return result;
	}		

}
