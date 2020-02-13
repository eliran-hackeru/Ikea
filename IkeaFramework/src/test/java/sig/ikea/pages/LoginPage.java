package sig.ikea.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import sig.ikea.utility.Helper;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//span[@class='login ng-binding']") WebElement extensionButton;
	
	@FindBy(name="user_name") WebElement uname;
	
	@FindBy(name="password") WebElement pass;
	
	@FindBy(xpath="//input[@value='כניסה']") WebElement loginButton;
	
	
	public void userCredential(String userApplication, String passwordApplication)
	{
		extensionButton.click();
		uname.sendKeys(userApplication);
		pass.sendKeys(passwordApplication);

	}

	public void clickLogin()
	{
		loginButton.click();
				
	}
	
//	This method combines the two methods	
	public void loginToEcommerce(String userApplication, String passwordApplication)
	{
		userCredential(userApplication,passwordApplication);
		clickLogin();
	}

}