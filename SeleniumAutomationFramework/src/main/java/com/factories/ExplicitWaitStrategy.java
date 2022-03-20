package com.factories;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverManager;
import com.enums.WaitStrategy;

public class ExplicitWaitStrategy {
	private ExplicitWaitStrategy() {};
	public static WebElement performexplicitwait(By by,WaitStrategy wait)
	{
		WebElement element=null;
		
		if(wait==WaitStrategy.CLICKABLE)
		{
	       element=  new WebDriverWait(DriverManager.getDriver(),10).until(ExpectedConditions.elementToBeClickable(by));
		}else if(wait==WaitStrategy.NONE)
		{
			element=DriverManager.getDriver().findElement(by);
		}
		else if(wait==WaitStrategy.PRESENCE)
		{
			element=new WebDriverWait(DriverManager.getDriver(),10).until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if(wait==WaitStrategy.VISIBLE)
		{
			element=new WebDriverWait(DriverManager.getDriver(),10).until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		return element;
	}

}
