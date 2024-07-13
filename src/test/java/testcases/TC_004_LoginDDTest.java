package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_004_LoginDDTest extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String email, String pwd, String res) {
		
		logger.info("****** Starting TC_004_loginDDT *******");

			
		try {
			HomePage hp = new HomePage(driver);
			hp.clickSignIn(); // signin link

			LoginPage lp = new LoginPage(driver);

			// Assert.assertEquals(lp.validatePageTitle(), p.get("LoginPageTitle"));
			logger.info("user is redirected to customer login page");

			lp.enterEmail(email);
			logger.info("email entered");

			lp.enterPassword(pwd);
			logger.info("password entered");

			lp.clickSignInButton(); // sign button
			logger.info("clicked login button");
			
			Boolean targetPage = hp.isHomePageExists();
			
			if(res.equalsIgnoreCase("valid"))
			{
				if(targetPage == true)
				{
					Assert.assertTrue(true);
					hp.clickSignOut();
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(res.equalsIgnoreCase("invalid"))
			{
				if(targetPage == true)
				{
					Assert.assertTrue(false);
				}
				else
					Assert.assertTrue(true);
					hp.clickSignOut();
			}
	}catch(Exception e)
	{
		Assert.fail();
	}
		
		logger.info("*********  Finished Data Driven Test Case *********");
}
}
