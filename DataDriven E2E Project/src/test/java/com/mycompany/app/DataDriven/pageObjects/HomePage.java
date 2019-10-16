package com.mycompany.app.DataDriven.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver=null;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(id="ControlGroupSearchView_AvailabilitySearchInputSearchView_OneWay")
	WebElement oneWayTrip;
	
	@FindBy(id="ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT")
	WebElement originField;
	
	@FindBy(xpath="//a[@value='HYD']")
	WebElement originStation;
	
	@FindBy(id="ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTXT")
	WebElement destinationField;
	
	@FindBy(xpath="//a[@value='BLR']")
	WebElement destinationStation;
	
	@FindBy(css="a.ui-state-default.ui-state-highlight.ui-state-active")
	WebElement departDate;
		
	@FindBy(id="ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit")
	WebElement searchButton;

	public WebElement getOneWayTrip() {
		return oneWayTrip;
	}

	public WebElement getOriginStation() {
		return originStation;
	}

	public WebElement getDestinationStation() {
		return destinationStation;
	}

	public WebElement getDepartDate() {
		return departDate;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getOriginField() {
		return originField;
	}

	
	public WebElement getDestinationField() {
		return destinationField;
	}
	
	
}
