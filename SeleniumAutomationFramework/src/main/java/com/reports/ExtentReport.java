package com.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.model.Category;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.constants.FrameworkConstants;
import com.enums.CategoryType;

public final class ExtentReport {
	private ExtentReport() {};
	private static ExtentReports extent;

	public static void initReport()
	{
		if(Objects.isNull(extent))
		{
			extent=new ExtentReports();
			ExtentSparkReporter spark = null;
			try {
				spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFile());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Automation Report");
			spark.config().setReportName("Automation Report");
		}
		
	
	   
	}
	public static void flushReport() throws IOException
	{
		if(Objects.nonNull(extent))
		{
			extent.flush();
		}
	
	}

	public static void createTest(String testCaseName)
	{
	     ExtentReportManager.setExtest(extent.createTest(testCaseName));
	}
	
	public static void assignauthor(String [] authors)
	{
		for(String author:authors)
		{
			ExtentReportManager.getExtest().assignAuthor(author);
		}
	}
	
	
	public static void assigncategory(CategoryType [] categories)
	{
		for(CategoryType category:categories)
		{
			ExtentReportManager.getExtest().assignCategory(category.toString());
		}
	}
}
