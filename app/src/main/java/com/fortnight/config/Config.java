package com.fortnight.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {
	private static Config INSTANCE;
	private Properties properties;
	private static final Logger logger=LoggerFactory.getLogger(Config.class);
	
	private Config() {
	}

	public static Config getInstance() {
		if(INSTANCE==null) {
			INSTANCE=new Config();
		}
		return INSTANCE;
	}

	public void load(String path) {
		logger.info("Loading file for configuration:",path);
		File file = new File(path);
		FileInputStream fis=null;
		Properties properties=new Properties();
		
		try{
			fis = new FileInputStream(file);
			properties.load(fis);
			logger.debug("Loaded {} no. of properties",properties.size());
		} catch(FileNotFoundException fnf) {
			System.out.println("File doesn't exist or application has no access to read the file.");
			fnf.printStackTrace();
			System.exit(1);
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		}
		this.properties=properties;
	}
	
	public String getProperty(String propertyName) {
		logger.debug("Value for property:{} is value:{}",propertyName,properties.getProperty(propertyName));
		return properties.getProperty(propertyName);
	}
	
}
