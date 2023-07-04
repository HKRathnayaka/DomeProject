package com.Dome.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Propose_a_PropertyPage {
	
	WebDriver ldriver;
	public static WebDriverWait wait;
	
	public Propose_a_PropertyPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@id='email']")
	@CacheLookup
	public WebElement txtProjectName;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/button[1]")
	@CacheLookup
	WebElement ddProjectType;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/ul[1]/div[1]/li[contains(text(), 'Flip')]")
	@CacheLookup
	WebElement optProjectType1;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/ul[1]/div[1]/li[contains(text(), 'Development')]")
	@CacheLookup
	WebElement optProjectType2;
	//opts -> Residential = /div[1]/input[1], Commercials = /div[2]/input[1]
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[3]/div[2]/div[1]/div[1]/input[1]")
	@CacheLookup
	WebElement cbProjectKind1;
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[3]/div[2]/div[1]/div[2]/input[1]")
	@CacheLookup
	WebElement cbProjectKind2;
	//opts -> Yes = /div[1]/input[1], No = /div[2]/input[1]
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[4]/div[2]/div[1]/div[1]/input[1]")
	@CacheLookup
	WebElement cbOwnershipYes;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[4]/div[2]/div[1]/div[2]/input[1]")
	@CacheLookup
	WebElement cbOwnershipNo;
	//opts -> Yes = /div[1]/input[1], No = /div[2]/input[1]
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[5]/div[2]/div[1]/div[2]/input[1]")
	@CacheLookup
	WebElement cbIncomeProducing;
	//If Rental = /div[6]/button[2]
	@FindBy(xpath="//p[contains(text(),'Continue')]")
	@CacheLookup
	WebElement btnContinue1;
	
	
	
	public void enterProjectName(String pName) throws InterruptedException {
		txtProjectName.sendKeys(pName);
	}
	public void clickOnProjectTypeDropdown() throws InterruptedException {
		ddProjectType.click();
	}
	public void selectProjectType(String type) throws InterruptedException {
		
//		if(type.equalsIgnoreCase("flip")){
//			optProjectType1.click();
//		}else if(type.equalsIgnoreCase("rental")){
//			optProjectType2.click();
//		}
		String paramType = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/ul[1]/div[1]/li[contains(text(), '"+type+"')]";
		WebElement selectType = ldriver.findElement(By.xpath(paramType));
		selectType.click();
		
	}
	public void selectProjectKind(String kind) throws InterruptedException {
		
		if(kind.equalsIgnoreCase("Residential")){
			cbProjectKind1.click();
		}else{
			cbProjectKind2.click();
		}
		
	}
	public void selectOwnership(String ownership) throws InterruptedException {

		if(ownership.equalsIgnoreCase("yes")){
			cbOwnershipYes.click();
		}else{
			cbOwnershipNo.click();
		}
		
	}
	public void clickOnContinueButton() throws InterruptedException {
		btnContinue1.click();
	}

}
