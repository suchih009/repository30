package com.crm.comcast.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
/**
 * this class contains all the cofiguration annotations
 * 
 * @author suchi
 *
 */

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;

	//Object creation for utilities
	public FileUtility fUtil=new FileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	
    //Connection to database
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBs() {
		System.out.println("Connect to database");
	}
	
	//launching the browser
	
	//@Parameters("browser")
	@BeforeClass(groups= {"smokeTest","regressionTest"}) 
	public void configBc() throws Throwable  {
	//public void configBc(String browser) throws Throwable  {
	//System.out.println("======Launch the browser=====");
	  //getting the data from property file
	  String browser= fUtil.getPropertyFileData("browser");
	   String url = fUtil.getPropertyFileData("url");

		if(browser.equals("chrome")) {
			System.setProperty(IPathConstants.CHROME_KEY,IPathConstants.CHROME_PATH);
			driver = new ChromeDriver();
		} else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
			System.setProperty(IPathConstants.FIREFOX_KEY,IPathConstants.FIREFOX_PATH);
		}
		else {
			System.out.println("browser is not supported");
		}
    sdriver = driver;		
	//maximize the window
	driver.manage().window().maximize();
	wUtil.waitForPageLoad(driver);
		
	//navigate to application
	driver.get(url);
	}
	
	//login to application
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBm() throws Throwable {
		String username = fUtil.getPropertyFileData("username");
		String password = fUtil.getPropertyFileData("password");
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(username, password);
	}
	
	//logout application
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAm() {
		HomePage homePage = new HomePage(driver);
		homePage.clickOnLogoutImage();
	}
	
	//closing or quiting the browser
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC() {
	            driver.quit();
	}
	
	//closing the database connection
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAs() {
		System.out.println("Database connection is closed");
	}

}

