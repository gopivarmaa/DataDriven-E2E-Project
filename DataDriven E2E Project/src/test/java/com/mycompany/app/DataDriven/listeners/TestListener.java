package com.mycompany.app.DataDriven.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.openqa.selenium.WebDriver;
import com.mycompany.app.DataDriven.base.BrowserFactory;
import com.mycompany.app.DataDriven.utility.CaptureScreenshot;

public class TestListener implements ITestListener {

	private WebDriver driver;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailure(ITestResult result) {
		this.driver = ((BrowserFactory) result.getInstance()).getDriver();
		// screenshot code
		CaptureScreenshot css = new CaptureScreenshot();
		css.captureScreenshot(driver, result);
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}
}