package com.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.annotations.FrameworkAnnotation;
import com.constants.FrameworkConstants;
import com.reports.ExtentLogger;
import com.reports.ExtentReport;

public class ListenerClass implements ITestListener,ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
	
		ExtentReport.initReport();
	}

	@Override
	public void onFinish(ISuite suite) {
	

		try {
			ExtentReport.flushReport();
		    try {
				Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFile()).toURI());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentReport.assignauthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).authors());
		ExtentReport.assigncategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).categories());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	     ExtentLogger.pass(result.getMethod().getMethodName()+" is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		 ExtentLogger.fail(result.getMethod().getMethodName()+" is failed", true);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		 ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped");
	}

	
}
