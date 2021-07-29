package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	//Declaration
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	public static String reportPath;
	

	public TestBase() 
	{
	//Initialisation
			
		prop = new Properties();
		FileInputStream fs;
		try
		{
		fs = new FileInputStream("./src/main/java/com/config/config.properties");
		prop.load(fs);
		}
		catch(IOException e)
		{
		
		}
		
	}
	
	public static void initialization()
	{
		//Utilization
		reportPath = System.getProperty("user.dir") + "//report//index.html";
		reporter = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = Logger.getLogger(TestBase.class);
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		logger.info("entering the url");
	}
	
	public static void tearDown()
	{
		driver.close();
	}
}
