package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	private WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='email_address']")
	private WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='password-confirmation']")
	private WebElement txtConfirmPassword;
		
	@FindBy(xpath="//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
	private WebElement btnCreate;	

	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void enterEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void confirmPassword(String pwd)
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public void clickCreateAnAccount()
	{
		btnCreate.click();
	}
	
}
