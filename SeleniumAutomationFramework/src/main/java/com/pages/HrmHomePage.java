package com.pages;

import org.openqa.selenium.By;

import com.driver.DriverManager;
import com.enums.WaitStrategy;
import com.utils.DynamicXpathUtils;

public class HrmHomePage extends BasePage{
	
	
	private By linkWelcome=By.xpath("//a[@id='welcome']");
	private By linkLogout=By.xpath("//a[text()='Logout']");
	private String headerLink="//b[text()='%s']/parent::a";
	
	public String getHrmPageTitle()
	{
		String title=getPageTitle();
		return title;
	}
	
	public HrmHomePage clickOnWelcomelink()
	{
		clickonElement(linkWelcome,"Welcome Link");
		return this;
	}
	public HrmLoginPage clickonLogout()
	{
		clickonElement(linkLogout,"Log Out Link");
		return new HrmLoginPage();
	}
   public AdminPage clickonHeaderLink(String linkName)
   {
	   String newXpath=DynamicXpathUtils.getDynamicXpath(headerLink, linkName);
	   
	     clickonElement(By.xpath(newXpath),linkName);
	     return new AdminPage();
   }
   
}
