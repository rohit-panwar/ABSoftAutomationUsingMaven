package com.absoft.qa.testcases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.absoft.qa.base.TestBase;
import com.absoft.qa.pages.HomePage;
import com.absoft.qa.pages.LoginPage;
import com.absoft.qa.pages.MyAccountPage;
import com.absoft.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	MyAccountPage myAccountPage;
	
	
	String sheetName = "login";

	public LoginPageTest() {
		// TODO Auto-generated constructor stub
		super();
	}
		
	@BeforeMethod
	public void setUp(Method method) {
		initilization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		//myAccountPage = new MyAccountPage();
		
		loginPage = homePage.clickLoginLink();
		extendReportRegister(method);
	}
	
	@Test(priority= 1)
	public void verifyLoginPageTitleTest() {
		String loginPageTitle = loginPage.validateLoginPageTitle();
		Assert.assertTrue(loginPageTitle.contains("My Account | ABSoft Trainings"
				+ " – E-Commerce test web site*"));
	}
	
	@Test(priority= 2)
	public void loginTest() {
		myAccountPage = loginPage.loginAccount(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
	}
	
	/*@DataProvider
	public Object[][] getABSoftTestData(){
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority= 3, dataProvider="getABSoftTestData")
	public void validateMultipleLogin(String un, String pwd) {
		myAccountPage = loginPage.loginAccount(un, pwd);
	}*/
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		extendReportCaptureStatus(result);
		driver.quit();
	}
}
 