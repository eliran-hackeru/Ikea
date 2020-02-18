package sig.ikea.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import sig.ikea.pages.BaseClass;
import sig.ikea.pages.ProductPage;
import sig.ikea.utility.BrowserFactory;
import sig.ikea.utility.Helper;

public class ProductTestEcommerce extends BaseClass
{
	
	@Test
	public void productApp()
	{
		String testName = this.getClass().getSimpleName();
		
		ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
		
		Helper.captureScreenshot(driver,"01_BrowserStarted",testName);
		
		productPage.searchSKU(excel.getNumericData("Product",0, 0));
		
		Helper.captureScreenshot(driver,"02_Search_SKU",testName);
		
		productPage.assertProductPage(excel.getNumericData("Product",0, 0), excel.getStringData("Product", 0, 1));
		
		productPage.checkForStock();
		
		Helper.captureScreenshot(driver,"03_Stock_Status",testName);
		
		productPage.checkForLocation();
		
		Helper.captureScreenshot(driver,"04_Location_Status",testName);
	}

}
