package sig.ikea.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import sig.ikea.pages.BaseClass;
import sig.ikea.pages.ProductPage;
import sig.ikea.utility.Helper;

public class ProductTestEcommerce extends BaseClass
{
	
	@Test
	public void productApp() throws InterruptedException
	{
//		To get the class name: String testName = this.getClass().getSimpleName();
		
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
		
/*		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		productPage.searchSKU(excel.getNumericData("Product",0, 0));
		
		productPage.assertSKUPage(excel.getNumericData("Product",0, 0), excel.getStringData("Product", 0, 1));
		
		Helper.captureScreenshot(driver,testName,"02_Search_SKU");
		
		productPage.checkForStock();
		
		Helper.captureScreenshot(driver,testName,"03_Stock_Status");
		
		productPage.checkForLocation();
		
		productPage.assertLocation(excel.getNumericData("Product",0, 0), excel.getStringData("Product", 0, 1));
		
		Helper.captureScreenshot(driver,testName,"04_Location_Status");
		
*/		productPage.productDetails();
		
		Helper.captureScreenshot(driver,testName,"05_Product_details");
	}

}
