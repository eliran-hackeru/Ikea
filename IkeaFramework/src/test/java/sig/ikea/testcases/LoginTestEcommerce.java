package sig.ikea.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sig.ikea.pages.BaseClass;
import sig.ikea.pages.LoginPage;
import sig.ikea.utility.BrowserFactory;
import sig.ikea.utility.ExcelDataProvider;
import sig.ikea.utility.Helper;

public class LoginTestEcommerce extends BaseClass {
	
	
	
	@Test
	public void loginApp()
	{
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		Helper.captureScreenshot(driver,"01_BrowserStarted");
		
		loginPage.userCredential(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		Helper.captureScreenshot(driver,"02_InsertUserDetails");
		
		loginPage.clickLogin();
		
		loginPage.assertLogin();
		
		Helper.captureScreenshot(driver,"03_Complete");
	}
		
}
