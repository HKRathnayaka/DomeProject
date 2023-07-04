package com.Dome.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyDetailsPage {
	
	WebDriver ldriver;
	
	public PropertyDetailsPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")
	@CacheLookup
	public WebElement ddPropertyType;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/div[1]/li[contains(text(), 'Duplex')]")
	@CacheLookup
	WebElement optPropertyType;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[2]/div[1]//*[@name=\"fenced_property\"]")
	@CacheLookup
	public WebElement cbFencedPro;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[2]//*[@name=\"garage\"]")
	@CacheLookup
	WebElement cbGarage;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[2]//*[@name=\"backyard\"]")
	@CacheLookup
	WebElement cbBackyard;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtAdd1;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtAdd2;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[5]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[6]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[7]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtZip;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[4]/img[1]")
	@CacheLookup
	public WebElement txtLatitude;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[8]/div[2]/div[2]/div[1]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtLongitude;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtNoOfBeds;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtNoOfBaths;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtSquareFt;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/input[1]")
	@CacheLookup
	WebElement txtLotSize;
	
	@FindBy(xpath="//textarea[@id='email']")
	@CacheLookup
	WebElement txtDescription;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/input[1]")
	@CacheLookup
	WebElement imgUpload;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/button[2]")
	@CacheLookup
	WebElement btnContinue2;
	
	public void clickOnTypeDropdown() throws InterruptedException {
		ddPropertyType.click();
	}
	public void clickOnPropertyTypeOption() throws InterruptedException {
		optPropertyType.click();
	}
	public void selectAditionalDetails() throws InterruptedException {
		cbFencedPro.click();
		//cbGarage.click();
		//cbBackyard.click();
	}
	public void enterAddressLine1(String add1) throws InterruptedException {
		txtAdd1.sendKeys(add1);
	}
	public void enterAddressLine2(String add2) throws InterruptedException {
		txtAdd2.sendKeys(add2);
	}
	public void enterCity(String city) throws InterruptedException {
		txtCity.sendKeys(city);
	}
	public void enterState(String state) throws InterruptedException {
		txtState.sendKeys(state);
	}
	public void enterZipCode(String zip) throws InterruptedException {
		txtZip.sendKeys(zip);
	}
	public void enterLatitude(String lati) throws InterruptedException {
		txtLatitude.sendKeys(lati);
	}
	public void enterLongitude(String longi) throws InterruptedException {
		txtLongitude.sendKeys(longi);
	}
	public void enterNumberOfBedrooms(String beds) throws InterruptedException {
		txtNoOfBeds.sendKeys(beds);
	}
	public void enterNumberOfBathrooms(String baths) throws InterruptedException {
		txtNoOfBaths.sendKeys(baths);
	}
	public void enterSquareFeets(String sqrft) throws InterruptedException {
		txtSquareFt.sendKeys(sqrft);
	}
	public void enterLotSize(String lSize) throws InterruptedException {
		txtLotSize.sendKeys(lSize);
	}
	public void enterDescription(String desc) throws InterruptedException {
		txtDescription.sendKeys(desc);
	}
	public void uploadAnImage(String imgPath) throws InterruptedException {
		imgUpload.sendKeys(imgPath);
	}
	public void clickOnContinueButton() throws InterruptedException {
		btnContinue2.click();
	}

}
