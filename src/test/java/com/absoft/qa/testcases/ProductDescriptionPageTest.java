package com.absoft.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.absoft.qa.base.TestBase;
import com.absoft.qa.pages.HomePage;
import com.absoft.qa.pages.ProductDescriptionPage;

public class ProductDescriptionPageTest extends TestBase{

	ProductDescriptionPage productDescriptionPage;
	HomePage homePage;
	
	public ProductDescriptionPageTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		productDescriptionPage = new ProductDescriptionPage();
		homePage = new HomePage();
		
		productDescriptionPage = homePage.clickShopLink().clickProduct();
	}
	
	@Test(priority = 1)
	public void verifyProdDescPage() {
		Assert.assertEquals(productDescriptionPage.validateProdDescLink(), "Home / FreeProducts / Test Product1");
	}
	
	@Test(priority = 2)
	public void addProductinCart() {
		String cartMessage = productDescriptionPage.clickAddToCart();
		Assert.assertTrue(cartMessage.contains("has been added to your cart."));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
