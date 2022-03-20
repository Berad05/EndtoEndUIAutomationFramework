package com.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.FrameworkConstants;
import com.enums.ConfigProperties;
import com.exceptions.BrowserInvokationException;
import com.factories.DriverFactory;
import com.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
	private Driver() {};

	
	public static void initDriver(String browser)
	{
		if(Objects.isNull(DriverManager.getDriver()))
		{
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));
				DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
			} catch (Exception e) {
				// TODO Auto-generated catch block
			     throw new BrowserInvokationException("Issue while launching browser",e);
			}
			
		}
		
		DriverManager.getDriver().manage().window().maximize();
	
	}
	
	public static void quitDriver()
	{
		if(Objects.nonNull(DriverManager.getDriver()))
		{
			DriverManager.getDriver().quit();
			DriverManager.unload();
			//////
			
		}
		
		
	}

	

}
