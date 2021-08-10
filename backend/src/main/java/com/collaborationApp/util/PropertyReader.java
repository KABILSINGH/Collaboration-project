package com.collaborationApp.util;

import java.io.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author kabilsingh.balan
 *
 */
public class PropertyReader {
	
	final private static String PROPERTIES_FILE_PATH="dbconfig.properties";
	private static final Logger logger = LoggerFactory.getLogger(PropertyReader.class);

	public static String getProperty (String propertyName){
       
		try(InputStream reader = PropertyReader.class.getResourceAsStream(PROPERTIES_FILE_PATH)){
			Properties properties = new Properties();
			properties.load(reader);
			return  properties.getProperty(propertyName);
		} catch(Exception e) {
			logger.error("Failed in loading dbconfig properties file");
		}
		return null;
	}
}
