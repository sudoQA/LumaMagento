package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	//WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
	WebElement createAnAccount;
	
	@FindBy(xpath="//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/ul/li[1]/a")
	WebElement linkReg;
	
	@FindBy(xpath="//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement signIn;
	
	@FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
	WebElement userProfileDropdown;
	
	@FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
	WebElement signOutLink;
	
	public void clickCreateAnAccountLink()
	{
		createAnAccount.click();
	}
	
	public void clickRegister()
	{
		linkReg.click();

	}
	
	public void clickSignIn()
	{
		signIn.click();
	}
	
	public void clickSignOut()
	{
		userProfileDropdown.click();
		signOutLink.click();
	}
	
	public Boolean isHomePageExists()
	{
		if(driver.getTitle().equals("Home Page"))
		{
			return true;
		}
		else
			return false;	
	}
	
}
