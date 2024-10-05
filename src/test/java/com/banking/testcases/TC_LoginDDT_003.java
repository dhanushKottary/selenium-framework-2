package com.banking.testcases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;
import com.banking.utilities.XLUtils;

public class TC_LoginDDT_003 extends BaseClass{
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String userid, String userpassword) {
		
		driver.get(baseUrl);
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(userid);
		logger.info("Entered username: "+userid);
		lp.setPassword(userpassword);
		logger.info("Entered password: "+userpassword);
		lp.clickSubmit();
		logger.info("Clicked on submit button");
		
        if(isAlertPresent()) {
        	logger.error("Testcase failed");
        	captureScreenshot(driver, "loginDDT");
        	driver.switchTo().alert().accept();
        	driver.switchTo().defaultContent();
        	Assert.assertTrue(false);
        }
        else {
        	Assert.assertTrue(true);
        	logger.info("Testcase passed");
        	lp.clickLogout();
        	driver.switchTo().alert().accept();
        	driver.switchTo().defaultContent();
        }
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	
	@DataProvider(name = "LoginData")
	public String[][] getData() {
		
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\banking\\testdata\\Test-data.xlsx";
		String sheet = "loginData";
		int rownum = XLUtils.getRowCount(path, sheet);
		int colnum = XLUtils.getCellCount(path, sheet, 0);
		String[][] loginData = new String[rownum][colnum];
		for(int i=1; i<rownum; i++) {
			for(int j=0; j<colnum;j++) {
				String data = XLUtils.getCellData(path, sheet, i, j);
				loginData[i-1][j] = data;
			}
		}
		return loginData;
	}
	

}
