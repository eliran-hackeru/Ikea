package sig.ikea.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import sig.ikea.pages.BaseClass;
import sig.ikea.pages.ProductPage;
import sig.ikea.utility.Helper;

public class ProductTestEcommerce extends BaseClass
{
	
	@Test
	public void productApp()
	{
//		To get the class name: String testName = this.getClass().getSimpleName();
		
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
		
		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		productPage.searchSKU(excel.getNumericData("Product",0, 0));
		
		Helper.captureScreenshot(driver,testName,"02_Search_SKU");
		
		productPage.assertProductPage(excel.getNumericData("Product",0, 0), excel.getStringData("Product", 0, 1));
		
		productPage.checkForStock();
		
		Helper.captureScreenshot(driver,testName,"03_Stock_Status");
		
		productPage.checkForLocation();
		
		Helper.captureScreenshot(driver,testName,"04_Location_Status");
	}

}
