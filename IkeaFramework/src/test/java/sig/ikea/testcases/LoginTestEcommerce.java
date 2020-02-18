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
//		To get the class name: String testName = this.getClass().getSimpleName();
		
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		loginPage.userCredential(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		Helper.captureScreenshot(driver,testName,"02_InsertUserDetails");
		
		loginPage.clickLogin();
		
		loginPage.assertLogin();
		
		Helper.captureScreenshot(driver,testName,"03_Complete");
	}
		
}
