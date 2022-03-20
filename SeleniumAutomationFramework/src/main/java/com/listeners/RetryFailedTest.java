package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.enums.ConfigProperties;
import com.utils.PropertyUtils;

public class RetryFailedTest implements IRetryAnalyzer{

	private int count=0;
	private int retry=1;

	@Override
	public boolean retry(ITestResult result) {
		boolean value=false;
		try {
			if(PropertyUtils.get(ConfigProperties.RETRYFAILTEST).equalsIgnoreCase("yes"))
			{
				count++;
				value= count<=retry;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

}
