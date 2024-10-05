package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css = "[name='uid']")
	WebElement txtUsername;
	
	@FindBy(css = "[name='password']")
	WebElement txtPassword;
	
	@FindBy(css = "[name='btnLogin']")
	WebElement loginButton;
	
	@FindBy(css = "a[href*='Logout']")
	WebElement logoutLink;
	
	public void setUsername(String username) {
		txtUsername.sendKeys(username);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickSubmit() {
		loginButton.click();
	}
	
	public void clickLogout() {
		logoutLink.click();
	}
	

}
