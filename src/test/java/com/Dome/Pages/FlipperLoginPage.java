package com.Dome.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipperLoginPage {
	
WebDriver ldriver;
	
	public FlipperLoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/input[1]")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	@CacheLookup
	WebElement btnSignin;
	
	public void setEmail(String email) throws InterruptedException {
		txtEmail.sendKeys(email);
	}
	public void setPassword(String password) throws InterruptedException {
		txtPassword.sendKeys(password);
	}
	public void clickOnSignIn() throws InterruptedException {
		btnSignin.click();
	}

}
