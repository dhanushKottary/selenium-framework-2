package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css = "a[href*='addcustomerpage']")
	WebElement newCustomerLink;
	
	@FindBy(css = "[name='name']")
	WebElement customerName;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "rad1")
	WebElement rdGender;
	
	@FindBy(how = How.ID_OR_NAME, using="dob")
	WebElement txtdob;
	
	@FindBy(how=How.NAME, using="addr")
	WebElement txtaddress;
	
	@FindBy(how=How.NAME, using="city")
	WebElement txtcity;
	
	@FindBy(how=How.NAME, using="state")
	WebElement txtstate;
	
	@FindBy(how=How.NAME, using="pinno")
	WebElement txtpin;
	
	@FindBy(how=How.NAME, using="telephoneno")
	WebElement txttelephone;
	
	@FindBy(how=How.NAME, using="emailid")
	WebElement txtemailid;
	
	@FindBy(how=How.NAME, using="password")
	WebElement txtpassword;
	
	@FindBy(how=How.CSS, using="[type='submit']")
	WebElement submitBtn;
	
	@FindBy(how=How.CSS, using="#customer td p")
	WebElement customerAddedSuccessMessage;
	
	public void clickNewCustomerLink() {
		newCustomerLink.click();
	}
	
	public void setCustomerName(String name) {
		customerName.sendKeys(name);
	}
	
	public void setCustomerGender() {
		rdGender.click();
	}
	
	public void setCustomerDOB(String dd,String mm, String yyyy) {
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(yyyy);
	}
	
	public void setCustomerAddress(String address) {
		txtaddress.sendKeys(address);
	}
	
	public void setCustomerCity(String city) {
		txtcity.sendKeys(city);
	}
	
	public void setCustomerState(String state) {
		txtstate.sendKeys(state);
	}
	
	public void setCustomerPin(String pin) {
		txtpin.sendKeys(pin);
	}
	
	public void setCustomertelephone(String telephone) {
		txttelephone.sendKeys(telephone);
	}
	
	public void setCustomerEmailId(String emailId) {
		txtemailid.sendKeys(emailId);
	}
	
	public void setCustomerPassword(String password) {
		txtpassword.sendKeys(password);
	}
	
	public void clickSubmitBtn() {
		submitBtn.click();
	}
	
	public String getSuccessMessage() {
		return customerAddedSuccessMessage.getText();
	}

}
