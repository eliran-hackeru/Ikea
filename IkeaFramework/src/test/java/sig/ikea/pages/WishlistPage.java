package sig.ikea.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import sig.ikea.utility.Helper;

public class WishlistPage 
{
WebDriver driver;
	
	public WishlistPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(css="span[ng-bind-html='item.product.Description_s']") List<WebElement> prodNameList;
	
	@FindBy(css="span[class='price_m ng-binding']") List<WebElement> priceList;
	
	@FindBy(css="span[ng-bind-html='item.product.product_code_s']") List<WebElement> makatList; //reduce 1 from list length
	
	@FindBy(css="span[ng-bind-html='item.product.Series_s || item.product.Series_t']") List<WebElement> seriesNameList; //reduce 1 from list length
	
	@FindBy(css="span[class='price_m bolded ng-binding']") WebElement totalPrice;
	
	@FindBy(css="strong[class='price ng-binding']") WebElement totalPriceTop;
	
	@FindBy(className="button large ng-scope") List<WebElement> saveList; //first and second are usable
	
	@FindBy(xpath="//span[.='מחק הכל']") WebElement deleteAll;
	
	@FindBy (className="wishlis_subtitle") WebElement subTitle;
	
	public void checkProductsListInfo(int i)
	{
		int j = i+1;
		
		System.out.println("Product #"+j+" Info:");
		
		System.out.println("Type: "+prodNameList.get(i).getText());
		
		System.out.println("Series Name: "+seriesNameList.get(i).getText());
		
		System.out.println("Price: "+priceList.get(i).getText());
		
		System.out.println("SKU: "+makatList.get(i).getText());
		
		System.out.println();
	}
	
	public void checkTotalPrice()
	{
		System.out.println("Total Price: "+totalPrice.getText());
		Assert.assertEquals(totalPrice.getText(), totalPriceTop.getText(), "The total price of the top and the bottom of the page are not equal");
		System.out.println("Price Assert Passed");
	}
	
	public void emptyList()
	{
		deleteAll.click();
	}
	
	public void assertList()
	{
		Assert.assertEquals(subTitle.getText(), "הרשימה שלך ריקה", "the wishlist isn't empty");
		System.out.println("Assert empty list passed");
	}
}
