package com.absoft.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.absoft.qa.base.TestBase;

public class HomePage extends TestBase{
	
	public HomePage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	// Object Repository
	@FindBy(linkText="Shop")
	WebElement lnkShop;

	@FindBy(linkText="Cart")
	WebElement lnkCart;
	
	@FindBy(linkText="My Account")
	WebElement lnkLogin;
	
	@FindBy(linkText="How to Use")
	WebElement lnkHelp;
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public LoginPage clickLoginLink() {
		lnkLogin.click();
		return new LoginPage();
	}
	
	public ShopPage clickShopLink() {
		lnkShop.click();
		return new ShopPage();
	}
}
