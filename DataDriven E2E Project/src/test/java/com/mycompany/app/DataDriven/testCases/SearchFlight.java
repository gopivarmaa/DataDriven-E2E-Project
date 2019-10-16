package com.mycompany.app.DataDriven.testCases;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.mycompany.app.DataDriven.base.BrowserFactory;
import com.mycompany.app.DataDriven.pageObjects.HomePage;
import com.mycompany.app.DataDriven.utility.CaptureScreenshot;
import com.mycompany.app.DataDriven.utility.ConfigDataProvider;

public class SearchFlight extends BrowserFactory {
	
	public WebDriver driver;
	CaptureScreenshot cs;
	public static Logger log =LogManager.getLogger(Login.class.getName());
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@Test
	public void searchFlight() throws InterruptedException {
		BrowserFactory browser = new BrowserFactory();
		driver=browser.initDriver();
		ConfigDataProvider cdp = new ConfigDataProvider();
		Properties prop=cdp.getProperties();
		String url = prop.getProperty("homeurl");
		
		driver.get(url);
		
		HomePage homePage = new HomePage(driver);
		Thread.sleep(3000);
		WebElement tripType = homePage.getOneWayTrip();
		if (tripType.isSelected()) {
			// nothing to do
		} else {
			tripType.click();
		}
		
		WebElement originField = homePage.getOriginField();
		originField.click();
		WebElement originStation = homePage.getOriginStation();
		originStation.click();
		
		WebElement destinationField = homePage.getDestinationField();
		destinationField.click();
		WebElement destinationStation = homePage.getDestinationStation();
		destinationStation.click();
		
		Thread.sleep(3000);
		WebElement departDate=homePage.getDepartDate();
		departDate.click();
		
		cs=new CaptureScreenshot();
		cs.captureScreenshot(driver, "SearchFlight");
		log.info("Captured screen shot");
		Thread.sleep(5000);
		
		WebElement searchButton = homePage.getSearchButton();
		searchButton.click();
		
		// cs.captureScreenshot(driver, "SearchFlight");		
		Assert.assertTrue(false);
				
		Thread.sleep(5000);	
	}
}