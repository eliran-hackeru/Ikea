package sig.ikea.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import sig.ikea.pages.BaseClass;
import sig.ikea.pages.LoginPage;
import sig.ikea.pages.ProductPage;
import sig.ikea.utility.Helper;
import sig.ikea.pages.BaseClass;

public class WishlistTestEcommerce extends BaseClass
{
	@Test
	public void wishlistApp()
	{
//		To get the class name: String testName = this.getClass().getSimpleName();
		
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
		
		for (int i=0; i<4; i++)
		{
			productPage.searchSKU(excel.getNumericData("Product",i, 0));
			
			Helper.waitForElementByClassName(driver, "button radius large add_to_wishlist ng-scope");
			
			productPage.addProductToWishlist();
			
			i++;
		}
	}	
}
