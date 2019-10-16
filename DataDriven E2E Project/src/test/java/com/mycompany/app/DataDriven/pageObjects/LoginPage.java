package com.mycompany.app.DataDriven.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver=null;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(id="ControlGroupLoginView_MemberLoginView2LoginView_TextBoxUserID")
	WebElement userId;
	
	@FindBy(id="ControlGroupLoginView_MemberLoginView2LoginView_PasswordFieldPassword")
	WebElement password;
	
	@FindBy(id="ControlGroupLoginView_MemberLoginView2LoginView_ButtonLogIn")
	WebElement loginButton;

	public WebElement getUserId() {
		return userId;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

}
