package com.absoft.qa.testcases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.absoft.qa.base.TestBase;
import com.absoft.qa.pages.HomePage;
import com.absoft.qa.util.ExtentReportUtil;

public class HomePageTest extends TestBase{

	HomePage homePage;
	
	@BeforeMethod
	public void setUp(Method method) {
		initilization();
		homePage = new HomePage();
		extendReportRegister(method);
	}
		
	@Test
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.validateHomePageTitle();
		//Assert.assertEquals(homePageTitle, "E-Commerce test web site | Home Page");
		Assert.assertTrue(homePageTitle.contains("E-Commerce test web site | Home Page"));
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		//extentReportUtil.extendReportCaptureStatus(result);
		extendReportCaptureStatus(result);
		driver.quit();
	}
}
