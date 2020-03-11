package sig.ikea.testcases;

import org.testng.annotations.Test;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import sig.ikea.pages.BaseClass;
import sig.ikea.pages.ProductPage;
import sig.ikea.pages.WishlistPage;
import sig.ikea.utility.ExcelDataProvider;
import sig.ikea.utility.Helper;

public class WishlistTestEcommerce extends BaseClass
{
	@Test
	public void wishlistApp() throws IOException, AWTException
	{
//		To get the class name: String testName = this.getClass().getSimpleName();
		
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
		
		WishlistPage wishlistpage = PageFactory.initElements(driver, WishlistPage.class);
		
		for (int i=0; i<=ExcelDataProvider.rowCounter("Product"); i++)
		{
			productPage.searchSKU(excel.getNumericData("Product",i, 0));
			
			productPage.addProductToWishlist();
			
			Helper.captureScreenshot(driver,testName,"Adding product #"+(i+1));
			
			productPage.assertAddProduct();
			
			productPage.closeAddProduct();
		}
		
		productPage.moveToWishlist();
		
		for (int i=0; i<=ExcelDataProvider.rowCounter("Product"); i++)
		{	
			wishlistpage.checkProductsListInfo(i);
		}
		
		wishlistpage.checkTotalPrice();
		
		wishlistpage.emptyList();
		
		Helper.robotScrollUp();
		Helper.robotScrollUp();
		Helper.robotScrollUp();
		Helper.robotScrollUp();
				
		productPage.closeTheAd();
		
		Helper.waitASec();
		Helper.waitASec();
		Helper.waitASec();
		
		wishlistpage.assertList();
	}	
}
