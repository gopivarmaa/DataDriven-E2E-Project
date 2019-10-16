package com.mycompany.app.DataDriven.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class CaptureScreenshot {
	public TakesScreenshot ss;
	public void captureScreenshot(WebDriver driver, String testName) {
		 ss = (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		String date = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss").format(new GregorianCalendar().getTime());
		File destination = 
		new File("D:\\Selenium\\eclipse-workspace\\DataDriven\\Screenshots\\" + testName + "_" + date + ".png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public void captureScreenshot(WebDriver driver, ITestResult result) {
		ss = (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		String testName = result.getMethod().getMethodName();
		String date = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss").format(new GregorianCalendar().getTime());
		File destination = new File("./Screenshots/" + testName + "_" + date + ".png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
}
