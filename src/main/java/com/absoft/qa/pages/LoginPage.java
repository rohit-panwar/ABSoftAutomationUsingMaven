package com.absoft.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.absoft.qa.base.TestBase;

public class LoginPage extends TestBase{

	public LoginPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement txtUserName; 
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public MyAccountPage loginAccount(String un, String pwd) {
		txtUserName.sendKeys(un);
		txtPassword.sendKeys(pwd);
		btnLogin.click();
		return new MyAccountPage();
	}
}
