package com.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.base.TestBase;
import com.pages.DashBoardPage;
import com.pages.LoginPage;

	public class LoginPageTest extends TestBase
	 		
	{
		public static ExtentTest test;
		
		public static String name;
		 	LoginPage lp;
		 	DashBoardPage dp;
		 	
		public LoginPageTest() throws IOException 
		{
			super();
			
		}
		
		@BeforeMethod
		public void setup()
		{
			initialization();
			lp= new LoginPage();
			dp = new DashBoardPage();
		}
		
		@Test(priority = 1)
		public void loginPageTitleTest()
		{
			extent.createTest(reportPath);
			String actualTitle = lp.validateTitle();
			String expTitle= "OrangeHRM";
			Assert.assertEquals(actualTitle, expTitle);
			extent.flush();
		}
		
		@Test(priority = 2)
		public void loginTest()
		{
			
			extent.createTest(reportPath);
			dp = lp.login(prop.getProperty("userName"), prop.getProperty("password"));
			logger.info("entered the username and pwd");
			dp.validateTitle();
			logger.info("Validating the title");
			dp.admin();
			logger.info("click on add");
			dp.addNew();
			dp.succesfullyAdded();
			logger.info("Added Sucessfully!" );
			
		
			try {
				Thread.sleep(4000);
				
			}
			catch(InterruptedException e)
			{}
			extent.flush();
			
		}
		
		
		
	    @AfterMethod
	   
		public void closeSetup()
		
		{
			tearDown();
		}
		
		
	}

