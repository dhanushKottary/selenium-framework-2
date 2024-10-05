package com.banking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;

public class TC_LoginTest_002 extends BaseClass {
	
	
	@Test
	public void loginTestFailedTestcase() {
		
		driver.get(baseUrl);
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		logger.info("Clicked on submit button");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage11")) {
			Assert.assertTrue(true);
			logger.info("Testcase passed!!");
		}
		else {
			captureScreenshot(driver, "loginTestFailedTestcase");
			Assert.assertTrue(false);
			logger.error("Testcase failed!!");
		}
	}

}
