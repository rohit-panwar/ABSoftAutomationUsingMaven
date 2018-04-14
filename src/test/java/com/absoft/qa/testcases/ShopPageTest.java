package com.absoft.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.absoft.qa.base.TestBase;
import com.absoft.qa.pages.HomePage;
import com.absoft.qa.pages.ProductDescriptionPage;
import com.absoft.qa.pages.ShopPage;

public class ShopPageTest extends TestBase{
	
	ShopPage shopPage;
	HomePage homePage;
	ProductDescriptionPage productDescriptionPage;
	
	public ShopPageTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		shopPage = new ShopPage();
		homePage = new HomePage();
		shopPage = homePage.clickShopLink();
	}
	
	@Test(priority = 1)
	public void verifyShopPage() {
		Assert.assertEquals(shopPage.validateShopLink(), "Home / Shop");
	}
	
	@Test(priority = 2)
	public void clickProduct() {
		productDescriptionPage = shopPage.clickProduct();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
