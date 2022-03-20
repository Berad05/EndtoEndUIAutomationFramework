package com.reports;


import com.aventstack.extentreports.MediaEntityBuilder;

import com.enums.ConfigProperties;
import com.utils.PropertyUtils;
import com.utils.ScreenshotUtils;

public class ExtentLogger {

	private ExtentLogger() {};
	
	public static void pass(String message)
	{
		ExtentReportManager.getExtest().pass(message+" is passsed");
	}
	public static void fail(String testCase)
	{
		ExtentReportManager.getExtest().fail(testCase+" is failed");
	}
	public static void skip(String testCase)
	{
		ExtentReportManager.getExtest().skip(testCase+" is skipped");
	
	}
	public static void pass(String message,boolean isScreenshotNeeded)
	{
		try {
			if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")&&isScreenshotNeeded)
			{
				ExtentReportManager.getExtest().pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.get64BaseImage()).build());
			}
			else
			{
				pass(message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void fail(String message,boolean isScreenshotNeeded)
	{
		try {
			if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")&&isScreenshotNeeded)
			{
				ExtentReportManager.getExtest().fail(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.get64BaseImage()).build());
			}
			else
			{
				fail(message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void skip(String message,boolean isScreenshotNeeded)
	{
		try {
			if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes")&&isScreenshotNeeded)
			{
				ExtentReportManager.getExtest().skip(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.get64BaseImage()).build());
			}
			else
			{
				skip(message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

