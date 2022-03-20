package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.enums.ConfigProperties;

public final class PropertyUtils {
	private static Properties property=new Properties();
	private static final Map<String,String> CONFIQMAP=new HashMap<String,String>();
	private PropertyUtils()
	{
		
	}
	
	static
	{
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/config.properties");
			property.load(fis);
			property.entrySet().forEach(entry->CONFIQMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	/*public static String getValue(String key) throws Exception
	{
		if(Objects.isNull(property.getProperty(key))||Objects.isNull(key))
		{
			throw new Exception("Value not found");
		}
		return property.getProperty(key);
		
	}*/
	
	
	/*
	 * This is to fetch values from HashMap
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	public static String get(ConfigProperties key) throws Exception
	{
		if(Objects.isNull(key)|| Objects.isNull(CONFIQMAP.get(key.name().toLowerCase())))
		{
			throw new Exception("Key doesnot match");
		}
		else
			return CONFIQMAP.get(key.name().toLowerCase());
	}
}
