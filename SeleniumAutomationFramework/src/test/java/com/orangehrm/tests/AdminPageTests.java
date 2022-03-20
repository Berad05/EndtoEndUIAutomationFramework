package com.orangehrm.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.annotations.FrameworkAnnotation;
import com.enums.CategoryType;
import com.pages.AdminPage;
import com.pages.HrmLoginPage;

public class AdminPageTests extends BaseTest{
	private AdminPageTests() {};
	@FrameworkAnnotation(authors= {"Vaibhav","Rahul"},categories= CategoryType.SMOKE)
	@Test
	public void validate_job_title_navigation(Map<String,String> data)
	{
		AdminPage jobTitlePage=new HrmLoginPage().enterUserName(data.get("UserName"),"UserName TextBox").
		 enterPassword(data.get("Password"),"Password TextBox").clickbtnLogin("Login Button")
		 .clickonHeaderLink("Admin")
		 .clickonAdminSubHeaderLink("Job").
		 clickonAdminSubHeaderLink("Job Titles");
		
		Assertions.assertThat(jobTitlePage.getPageCurrentUrl()).isEqualTo(data.get("NavigationURL"));
		Assertions.assertThat(jobTitlePage.getPageHeadText("Job Titles")).isEqualTo("Job Titles");
	}
	@FrameworkAnnotation(authors= {"Vaibhav","Rahul"},categories= {CategoryType.REGRESSION,CategoryType.SMOKE})
	@Test()
	public void validate_add_jobTitle(Map<String,String> data)
	{

		new HrmLoginPage().enterUserName(data.get("UserName"),"UserName TextBox").
		 enterPassword(data.get("Password"),"Password TextBox").clickbtnLogin("Login Button")
		 .clickonHeaderLink("Admin")
		 .clickonAdminSubHeaderLink("Job").
		 clickonAdminSubHeaderLink("Job Titles").addJob(data.get("JobTitle"), data.get("JobDesc"), data.get("JobNote"));
		
	}

	
	
	
}
