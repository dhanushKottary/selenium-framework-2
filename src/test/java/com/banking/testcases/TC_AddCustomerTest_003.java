package com.banking.testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.AddCustomerPage;
import com.banking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() {
		
		driver.get(baseUrl);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(username);
		logger.info("Entered username");
		loginPage.setPassword(password);
		logger.info("Entered password");
		loginPage.clickSubmit();
		logger.info("Submitted login credentials");
		
		AddCustomerPage addCstmr = new AddCustomerPage(driver);
		logger.info("Entering customer details....");
		addCstmr.clickNewCustomerLink();
		addCstmr.setCustomerName("Pavan");
		addCstmr.setCustomerGender();
		addCstmr.setCustomerDOB("28", "08", "2000");
		addCstmr.setCustomerAddress("INDIA");
		addCstmr.setCustomerCity("Mangalore");
		addCstmr.setCustomerState("Karnataka");
		addCstmr.setCustomerPin("1122334455");
		addCstmr.setCustomertelephone("2345467278");
		addCstmr.setCustomerEmailId(randomString()+"@gmail.com");
		addCstmr.setCustomerPassword("seleniumautomation@");
		addCstmr.clickSubmitBtn();
		
		logger.info("Verifying customer added success message!!");
		Assert.assertEquals("Customer Registered Successfully!!!", addCstmr.getSuccessMessage());
		logger.info("Testcase passed.........");
		
	}
	

}
