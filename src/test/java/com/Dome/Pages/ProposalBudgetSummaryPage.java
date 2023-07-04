package com.Dome.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProposalBudgetSummaryPage {
	
	WebDriver ldriver;
	
	public ProposalBudgetSummaryPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[5]/div[1]/div[3]/div[1]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtFlipperInvestment;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[5]/div[1]/div[5]/button[2]")
	@CacheLookup
	WebElement btnContinue5;
	
	public void enterExpectedCostofMaterials(String flipperInvestment) throws InterruptedException {
		txtFlipperInvestment.sendKeys(flipperInvestment);
	}
	public void clickOnContinueButton() throws InterruptedException {
		btnContinue5.click();
	}

}
