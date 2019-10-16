package com.mycompany.app.DataDriven.testCases;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mycompany.app.DataDriven.base.BrowserFactory;
import com.mycompany.app.DataDriven.pageObjects.LoginPage;
import com.mycompany.app.DataDriven.utility.CaptureScreenshot;
import com.mycompany.app.DataDriven.utility.ConfigDataProvider;
import com.mycompany.app.DataDriven.utility.ReadExcelFile;

public class Login extends BrowserFactory{
	
	public WebDriver driver;
	Properties prop;
	public static Logger log =LogManager.getLogger(Login.class.getName());
	//CaptureScreenshot cs;
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	//@BeforeTest
	public void setUp() throws IOException {
		BrowserFactory browser = new BrowserFactory();
		driver=browser.initDriver();
		ConfigDataProvider cdp = new ConfigDataProvider();
		prop=cdp.getProperties();
	}
	
	@Test(dataProvider="getTestData")
	public void login(String uid, String pw) throws InterruptedException {
		BrowserFactory browser = new BrowserFactory();
		driver=browser.initDriver();
		ConfigDataProvider cdp = new ConfigDataProvider();
		prop=cdp.getProperties();
		
		String url = prop.getProperty("loginurl");
		driver.get(url);
		
		LoginPage loginPage = new LoginPage(driver);
				
		ReadExcelFile book = new ReadExcelFile();
		
		//String uid = book.getNumericData("Login", 1, 0);
		WebElement userId = loginPage.getUserId();
		//userId.sendKeys(prop.getProperty("userName"));
		userId.sendKeys(uid);
		
		//String pw= book.getStringData("Login", 1, 1);
		WebElement password = loginPage.getPassword();
		// password.sendKeys(prop.getProperty("password"));
		password.sendKeys(pw);
		
		WebElement login = loginPage.getLoginButton();
		login.click();
		log.info("Clicked on login button");
	}
	
	@DataProvider
	public String[][] getTestData(){
		ReadExcelFile ed = new ReadExcelFile();
		int rows = ed.getRowCount(0);
		String[][] testData = new String[rows-1][2];
		for(int i=1;i<rows;i++) {
			testData[i-1][0]=ed.getNumericData(0, i, 0);
			testData[i-1][1]=ed.getStringData(0, i, 1);
		}
		return testData;
	}
	
	//@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
}
