package com.mycompany.app.DataDriven.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.mycompany.app.DataDriven.utility.ConfigDataProvider;

public class BrowserFactory {

	public WebDriver driver = null;
	public Properties prop = null;
	
	public WebDriver getDriver() {
		return this.driver;
	}

	public WebDriver initDriver() {
		ConfigDataProvider cdp = new ConfigDataProvider();
		prop = cdp.getProperties();
		String browser =prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			//options.setPageLoadStrategy(PageLoadStrategy.NONE);
			String chromePath = prop.getProperty("chromePath");
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver(options);
		} 
		/** 
		 * else if (browser.equalsIgnoreCase("firefox")) {
			String firefoxPath = prop.getProperty("firefoxPath");
			System.setProperty("webdriver.gecko.driver", firefoxPath);
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			String IEPath = prop.getProperty("IEPath");
			System.setProperty("webdriver.ie.driver", IEPath);
			driver = new InternetExplorerDriver();
		} 
		*/
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		
		return driver;
	}
}