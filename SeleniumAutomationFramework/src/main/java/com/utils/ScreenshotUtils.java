package com.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.driver.DriverManager;

public final class ScreenshotUtils {

	private ScreenshotUtils(){};
	public static String get64BaseImage() {
		// TODO Auto-generated method stub
		
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
