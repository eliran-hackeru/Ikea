package sig.ikea.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
	public void loginToEcommerce(String userApplication, String passwordApplication)
	{
		extensionButton.click();
		uname.sendKeys(userApplication);
		pass.sendKeys(passwordApplication);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		loginButton.click();
				
	}

}