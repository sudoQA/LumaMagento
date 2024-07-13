package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups= {"regression", "sanity"})
	public void verify_login() {
		
		logger.info("***************** Starting login test *************** ");
		
		try{
			HomePage hp = new HomePage(driver);
			hp.clickSignIn();    //signin link
						
			LoginPage lp = new LoginPage(driver);
			
			//Assert.assertEquals(lp.validatePageTitle(), p.get("LoginPageTitle"));
			logger.info("user is redirected to customer login page");
			
			lp.enterEmail(p.getProperty("email"));
			logger.info("email entered");
			
			//lp.enterPassword(p.getProperty("password"));
			lp.enterPassword(p.getProperty("password"));
			logger.info("password entered");
			
			lp.clickSignInButton();   //sign button
			logger.info("clicked login button");
			
			Assert.assertEquals(lp.validatePageTitle(), p.get("homePageTitle"));
			logger.info("User is on Home page");
			
			hp.clickSignOut();
			
			
			
			Thread.sleep(5000);
			
		}catch(Exception e)
		{
			Assert.fail();
			logger.info("invalid credentials");
		}
		 

	}

}

