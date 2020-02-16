package sig.ikea.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
	
	@FindBy(xpath="//input[@value='יציאה']") WebElement logoutButton;
	
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
	
//	This method combines the two methods userCredential() & clickLogin()
	public void loginToEcommerce(String userApplication, String passwordApplication)
	{
		userCredential(userApplication,passwordApplication);
		clickLogin();
	}
	
//	Run this after clickLogin() to verify the test
	public void assertLogin()
	{
		Assert.assertEquals(logoutButton.getAttribute("value"), "יציאה","Can't find the logout button.");
		
	}
	
}