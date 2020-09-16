package com.asirefundapi.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

	private static ConfigManager manager;
	private static final Properties prop=new Properties();
	
	private ConfigManager() throws IOException{
	InputStream inputstream = ConfigManager.class.getResourceAsStream("C:\\Users\\garima\\workspace\\Practice1\\ASIRefundAPI\\resources\\config.properties");
	prop.load(inputstream);	
	}
	
	public static ConfigManager getInstance()
	{
		if(manager==null)
			synchronized (ConfigManager.class) {
				try{
					manager=new ConfigManager();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
			}
		return manager;
	}
	
	public String getString(String key)
	{
		return System.getProperty(key, prop.getProperty(key));
	}
	
}
