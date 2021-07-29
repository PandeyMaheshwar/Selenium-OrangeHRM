package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LoginPage extends TestBase
{
	@FindBy(id = "txtUsername")
	WebElement usernameTB;
	@FindBy(name = "txtPassword")
	WebElement passwordTB;
	@FindBy(id ="btnLogin")
	WebElement loginButton;
	
	public LoginPage()                       
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	public DashBoardPage login(String uName, String passWord)
	{
		usernameTB.sendKeys(uName);
		passwordTB.sendKeys(passWord);
		loginButton.click();
		return new DashBoardPage();
	} 
	
}