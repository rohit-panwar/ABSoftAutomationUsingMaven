package com.absoft.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.absoft.qa.base.TestBase;
import com.absoft.qa.pages.HomePage;
import com.absoft.qa.pages.MyAccountPage;

public class MyAccountPageTest extends TestBase{

	HomePage homePage;
	MyAccountPage myAccountPage;
	
	public MyAccountPageTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		homePage = new HomePage();
		myAccountPage = new MyAccountPage();
		myAccountPage = homePage.clickLoginLink().loginAccount(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
	}
	
	@Test(priority = 1)
	public void validateMyAccountPageHeaderTest() {
		String myAccountPageHeader = myAccountPage.validateMyAccountPageHeader();
		Assert.assertTrue(myAccountPageHeader.contains("Hello testuser2 (not testuser2? Sign out)."));
	}
	
/*	@Test(priority = 2)
	public void validateMyAccountPageBillingTest() {
		String myAccountPageBilling = myAccountPage.validateMyAccountPageBilling();
		Assert.assertTrue(myAccountPageBilling.contains("naveen kumar"));
	}
	
	@Test(priority = 3)
	public void validateMyAccountPageShippingTest() {
		String myAccountPageShipping = myAccountPage.validateMyAccountPageShipping();
		Assert.assertTrue(myAccountPageShipping.contains("naveen kumar"));
	}*/
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
