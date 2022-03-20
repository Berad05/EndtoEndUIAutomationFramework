package com.orangehrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.driver.Driver;
import com.driver.DriverManager;

public class HomepageTest extends BaseTest {
	
  @Test(enabled=false)
  public void test2() {
	  
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Sachin",Keys.ENTER);
  }
  @Test(enabled=false)
  public void test3() {
	  
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Saurav",Keys.ENTER);
}
}
