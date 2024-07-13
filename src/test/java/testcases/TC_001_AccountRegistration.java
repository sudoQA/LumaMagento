package testcases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {

	@Test
	public void verify_account_registration() {
		
		
		logger.info("**** staring account registration test ****");
		logger.debug("Application logs...!");
		
		try {
			
		HomePage hp = new HomePage(driver);
		hp.clickCreateAnAccountLink();
		logger.info("Clicked Create an Account");
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName((randomString().toUpperCase()));
		regPage.enterEmail(randomAlphaNumeric() + "@gmail.com");
		regPage.setPassword("Test@1234");
		regPage.confirmPassword("Test@1234");
		logger.info("User details entered");
		regPage.clickCreateAnAccount();
		logger.info("Button clicked");

		Assert.assertEquals(driver.getTitle(), p.getProperty("myAccountPageTitle"));
		logger.info("Validating expected message...!");
		}catch(Exception e)
		{
			logger.error("test failed...!");
			Assert.fail();		
		}
		
		logger.info("**** finishing account registration test ****");

	}

}
