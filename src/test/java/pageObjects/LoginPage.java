package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement txtEmail;

	@FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
	WebElement textPassword;

	@FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
	WebElement btnSignIn;

	
	// ****************************** Action Methods ********************************
	
	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void enterPassword(String pwd) {
		textPassword.sendKeys(pwd);
	}

	public void clickSignInButton() {
		btnSignIn.click();
	}

	public String validatePageTitle() {

		String title = driver.getTitle();
		return title;
	}

}
