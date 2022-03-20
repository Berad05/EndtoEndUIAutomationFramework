package com.pages;

import org.openqa.selenium.By;


import com.driver.DriverManager;
import com.enums.WaitStrategy;
import com.factories.ExplicitWaitStrategy;
import com.reports.ExtentLogger;

public class BasePage {

	
	
	
	protected void sendkeys(By by,String value,String element)
	{
		ExplicitWaitStrategy.performexplicitwait(by, WaitStrategy.VISIBLE).sendKeys(value);
		ExtentLogger.pass(value+" is entered in "+element);
		
	}
	
	protected void clickonElement(By by,String element)
	{
		ExplicitWaitStrategy.performexplicitwait(by, WaitStrategy.CLICKABLE).click();
		ExtentLogger.pass("Clicked on "+element);
		
	}
	
	protected String getPageTitle()
	{
		return DriverManager.getDriver().getTitle();
	}
	
	protected String getText(By by)
	{
		return ExplicitWaitStrategy.performexplicitwait(by, WaitStrategy.VISIBLE).findElement(by).getText();
		
	}
	protected String getCurrentUrl()
	{
		
		return DriverManager.getDriver().getCurrentUrl();
	
	}
}
