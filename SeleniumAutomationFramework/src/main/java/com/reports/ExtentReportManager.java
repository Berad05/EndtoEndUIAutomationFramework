package com.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {
	private ExtentReportManager() {};
	private static ThreadLocal<ExtentTest> extest=new ThreadLocal<>();

	static ExtentTest getExtest() {
		return extest.get();
	}

	static void setExtest(ExtentTest test) {
		extest.set(test);
	}
   static void unload()
   {
	   extest.remove();
   }
   
}
