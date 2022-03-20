package com.factories;

import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.driver.DriverManager;
import com.enums.ConfigProperties;
import com.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {
	static WebDriver driver;
	private DriverFactory() {};
	
	
	public static WebDriver getDriver(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			if(PropertyUtils.get(ConfigProperties.RUNMODE).equalsIgnoreCase("remote"))
			{
				DesiredCapabilities cap=new DesiredCapabilities();
				cap.setBrowserName(browser);
				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			}
			else
			{
				
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
			}
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			if(PropertyUtils.get(ConfigProperties.RUNMODE).equalsIgnoreCase("remote"))
			{
				DesiredCapabilities cap=new DesiredCapabilities();
				cap.setBrowserName(browser);
				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			}
			else
			{
				
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
					
			}
		}else if(browser.equalsIgnoreCase("edge"))
		{
			if(PropertyUtils.get(ConfigProperties.RUNMODE).equalsIgnoreCase("remote"))
			{
				DesiredCapabilities cap=new DesiredCapabilities();
				cap.setBrowserName(browser);
				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			}
			else
			{
				
					WebDriverManager.edgedriver().setup();
					driver=new EdgeDriver();
					
				
			}
		}
	
	return driver;
		
	}

}
