package com.orangehrm.tests;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.constants.FrameworkConstants;
import com.driver.Driver;

public class BaseTest {

		protected BaseTest() {};
		@BeforeMethod()
		public void setUp(Object[] data) throws Exception
		{
			Map<String,String> map=(Map<String, String>) data[1];
			Driver.initDriver(map.get("Browser"));
		}
		@AfterMethod()
		public void tearDown()
		{
			Driver.quitDriver();
		}
}
