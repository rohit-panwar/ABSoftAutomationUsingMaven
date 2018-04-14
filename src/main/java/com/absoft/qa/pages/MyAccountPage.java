package com.absoft.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.absoft.qa.base.TestBase;

public class MyAccountPage extends TestBase{
	
	public MyAccountPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="user_info")
	WebElement lblHeader;
	
	@FindBy(xpath=".//*[@id='post-12']/div/div/div[2]/div[1]/address")
	WebElement lblBillingHeader;
	
	@FindBy(xpath=".//*[@id='post-12']/div/div/div[2]/div[2]/address")
	WebElement lblShippingHeader;
	
	public String validateMyAccountPageHeader() {
		return lblHeader.getText();
	}
	
	public String validateMyAccountPageBilling() {
		return lblBillingHeader.getText();
	}
	
	public String validateMyAccountPageShipping() {
		return lblShippingHeader.getText();
	}
}
