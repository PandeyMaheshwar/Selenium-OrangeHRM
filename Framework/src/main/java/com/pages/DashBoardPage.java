package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class DashBoardPage extends TestBase {
	
	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement admBtn;
	@FindBy(id =  "btnAdd")
	WebElement addBtn;
	@FindBy(id = "systemUser_employeeName_empName")
	WebElement eName;
	@FindBy(id = "systemUser_userName")
	WebElement uName;
	@FindBy(id = "systemUser_password")
	WebElement sysPwd;
	@FindBy(id = "systemUser_confirmPassword")
	WebElement cnfPwd;
	@FindBy(id = "btnSave")
	WebElement saveBtn;
	
	

	public DashBoardPage()                       
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle()
	{
		return driver.getTitle();
	}

	
	public  void admin()
	{
		admBtn.click();
	}
	
	public void addNew()
	{
		addBtn.click();
		
		eName.sendKeys("Ram");
		uName.sendKeys("Ram@123");
		sysPwd.sendKeys("12345");
		cnfPwd.sendKeys("12345");
		saveBtn.click();
	}
	
	public void succesfullyAdded()
	{
		saveBtn.click();
	}
	

	
	
}

