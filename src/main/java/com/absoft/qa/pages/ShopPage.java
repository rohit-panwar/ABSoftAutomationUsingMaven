package com.absoft.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.absoft.qa.base.TestBase;

public class ShopPage extends TestBase{

	public ShopPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//*[@id='left-area']/nav")
	WebElement lnkShop;
	
	@FindBy(xpath=".//*[@id='left-area']/ul/li[1]/a/span[2]/span")
	WebElement iconProduct;
	
	public String validateShopLink() {
		return lnkShop.getText();
	}
	
	public ProductDescriptionPage clickProduct() {
		iconProduct.click();
		return new ProductDescriptionPage();
	}
	
}
