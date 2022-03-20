package com.pages;

import org.openqa.selenium.By;

import com.utils.DynamicXpathUtils;

public class AdminPage extends BasePage{

	private String adminsubheaderlink="//a[text()='%s']";
	private String pageheaderText="//div[@class='head']/h1[text()='%s']";
	private By btnAdd=By.id("btnAdd");
	private By textJobTitle=By.id("jobTitle_jobTitle");
	private By jobTitleDescription=By.id("jobTitle_jobDescription");
	private By jobNoteDesc=By.id("jobTitle_note");
	private By btnSave=By.id("btnSave");
	public AdminPage clickonAdminSubHeaderLink(String subheaderlinkName)
	{
		String newxpath=DynamicXpathUtils.getDynamicXpath(adminsubheaderlink,subheaderlinkName);
		clickonElement(By.xpath(newxpath),subheaderlinkName);
		return this;
	}
	
	public String getPageHeadText(String page)
	{
		String newxpath=DynamicXpathUtils.getDynamicXpath(pageheaderText,page);
		return getText(By.xpath(newxpath));
	}
	public String getPageCurrentUrl()
	{
		return getCurrentUrl();
	}
	
	public AdminPage clickonAddButton()
	{
		clickonElement(btnAdd,"Add Button");
		return this;
	}
	public AdminPage addJob(String jobTitle,String jobDesc,String jobNote)
	{
		clickonAddButton().
		sendkeys(textJobTitle, jobTitle, "Job Title");
		sendkeys(jobTitleDescription,jobDesc,"Job Description");
		sendkeys(jobNoteDesc,jobNote,"Job Note");
		clickonElement(btnSave," Save Button");
		return null;
	}
	
	
}
