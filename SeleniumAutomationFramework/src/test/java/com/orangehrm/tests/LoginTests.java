package com.orangehrm.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.pages.HrmLoginPage;
import com.utils.DataProviderUtils;

public class LoginTests extends BaseTest {

	private LoginTests() {};
	@FrameworkAnnotation(authors= {"Vaibhav","Rahul"},categories= CategoryType.SMOKE)
	@Test()
	public void validate_loginorangehrm_functionality(Map<String,String> data)
	{
		
	 String actualTitle = new HrmLoginPage().enterUserName(data.get("UserName"),"UserName TextBox").
			 enterPassword(data.get("Password"),"Password TextBox").clickbtnLogin("Login Button")
	   .clickOnWelcomelink().clickonLogout().getLoginPageTitle();
	 Assertions.assertThat(actualTitle).isEqualTo("OrangeHRM");
		
	}
	
	
}
