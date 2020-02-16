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
	public void searchtApp()
	{
		ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
		
		productPage.searchSKU(excel.getNumericData("Product",0, 0));
		
		productPage.assertProductPage(excel.getNumericData("Product",0, 0), excel.getStringData("Product", 0, 1));
		
		productPage.checkForStock();
		
	}

}
