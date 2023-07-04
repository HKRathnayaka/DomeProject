package com.Dome.TestCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Dome.Base.BaseClass;
import com.Dome.Pages.*;

public class tc_001_FlipperLoginWithValidCredentials extends BaseClass {
	
	@Test
	public void flipperLoginWithValidCredentials() throws InterruptedException, IOException {
		
		test = extent.createTest("flipperLoginWithValidCredentials");
		
		driver.get(url);
		test.info("Dome-Flipper URL opened");
		FlipperLoginPage flp = new FlipperLoginPage(driver);
		flp.setEmail(email);
		test.info("Email entered");
		flp.setPassword(password);
		test.info("Password entered");
		flp.clickOnSignIn();
		test.info("Sign In button clicked");
		FlipperHomePage fhp = new FlipperHomePage(driver);
		wait.until(ExpectedConditions.visibilityOf(fhp.lnkPropose_a_Property));
		if(fhp.lnkPropose_a_Property.isDisplayed()){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
		
	}

}
