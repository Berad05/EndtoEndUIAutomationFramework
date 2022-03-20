 package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.driver.DriverManager;
import com.reports.ExtentLogger;

public class HrmLoginPage extends BasePage{
	
  private By txtUserName=By.xpath("//input[@id='txtUsername']");
  private By txtPassword=By.xpath("//input[@id='txtPassword']");
  private By btnLogin=By.xpath("//input[@id='btnLogin']");
  
  
  
  public HrmLoginPage enterUserName(String userName,String elementName)
  {
	  sendkeys(txtUserName,userName,elementName);
	   return this;
  }
  
  public HrmLoginPage enterPassword(String password,String elementName)
  {
	 sendkeys(txtPassword,password,elementName);
	  return this;
  }
  public HrmHomePage clickbtnLogin(String element)
  {
	  clickonElement(btnLogin,element);
	  ExtentLogger.pass("Logged in Orange Hrm", false);
	  return new HrmHomePage();
  }
  
  public String getLoginPageTitle()
  {
	  String title=getPageTitle();
	  return title;
  }

}
