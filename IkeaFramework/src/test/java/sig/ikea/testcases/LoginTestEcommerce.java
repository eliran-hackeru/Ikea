package sig.ikea.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import sig.ikea.pages.BaseClass;
import sig.ikea.pages.LoginPage;
import sig.ikea.utility.Helper;

public class LoginTestEcommerce extends BaseClass
{
	
	@Test
	public void loginApp()
	{
		String testName = this.getClass().getSimpleName();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		Helper.captureScreenshot(driver,"01_BrowserStarted",testName);
		
		loginPage.userCredential(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		Helper.captureScreenshot(driver,"02_InsertUserDetails",testName);
		
		loginPage.clickLogin();
		
		loginPage.assertLogin();
		
		Helper.captureScreenshot(driver,"03_Complete",testName);
	}
		
}
