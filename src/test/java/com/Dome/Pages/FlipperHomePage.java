package com.Dome.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipperHomePage {
	
WebDriver ldriver;
	
	public FlipperHomePage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Propose a Property')]")
	@CacheLookup
	public WebElement lnkPropose_a_Property;
	
	public void clickOnPropose_a_Property() throws InterruptedException {
		lnkPropose_a_Property.click();
	}

}
