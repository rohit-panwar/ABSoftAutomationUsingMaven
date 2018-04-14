package com.absoft.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.absoft.qa.base.TestBase;

public class ProductDescriptionPage extends TestBase{

	public ProductDescriptionPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//*[@id='left-area']/nav")
	WebElement lnkProductDescription;
	
	@FindBy(id="addtocart")
	WebElement btnAddToCart;
	
	@FindBy(xpath=".//*[@id='left-area']/div[1]")
	WebElement lblCartMessage;
	
	public String validateProdDescLink() {
		return lnkProductDescription.getText();
	}
	
	public String clickAddToCart() {
		btnAddToCart.click();
		return lblCartMessage.getText();
	}
}
