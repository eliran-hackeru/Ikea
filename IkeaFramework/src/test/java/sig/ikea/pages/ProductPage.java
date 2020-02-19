package sig.ikea.pages;

import static org.testng.Assert.assertNotNull;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductPage {
	
	WebDriver driver;
	
	public ProductPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(css="input[type='text']") WebElement searchButton;
	
	@FindBy(id="search_btn_find") WebElement submitSearch;
	
	@FindBy(xpath="//span[@class='product_code ng-binding']") WebElement SKU;
	
	@FindBy(xpath="//span[@class='prod_series ng-binding']") WebElement series;
	
	@FindBy(xpath="//span[@class='select2-chosen ng-binding']") WebElement openStock;
	
	@FindBy(css="i[ng-class^='$select.open ?']") WebElement toggleStock;
	
	@FindBy(css="span[ng-bind-html='current_store.status_msg']") WebElement stockStatus;

	@FindBy(xpath="//span[.='קריית אתא']") WebElement stockKiryatAta;
	
	@FindBy(xpath="//span[.='נתניה']") WebElement stockNetanya;
	
	@FindBy(xpath="//span[.='ראשל\"צ']") WebElement stockRishonLeZion;
	
	@FindBy(xpath="//span[.='באר שבע']") WebElement stockBeersheba;
	
	@FindBy(css="span[ng-bind-html='current_store.status_msg']") WebElement stockAssertion;
	
	@FindBy(xpath="//span[.='לחץ כאן לבדיקת מיקום המוצר בחנויות ושעות פתיחה']") WebElement location;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[1]/div/a/span[2]/div/span") WebElement toggleLocation;
	
	@FindBy(id="quick_links_close") WebElement closeLocation;
	
	@FindBy(xpath="//li[@id='ui-select-choices-row-1-1']") WebElement locationNetanya;
	
	@FindBy(xpath="//li[@id='ui-select-choices-row-1-2']") WebElement locationRishonLeZion;
	
	@FindBy(xpath="//li[@id='ui-select-choices-row-1-3']") WebElement locationKiryatAta;
	
	@FindBy(xpath="//li[@id='ui-select-choices-row-1-4']") WebElement locationBeersheba;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[1]/div/a/span[2]/div/span/span[2]") WebElement locationName;
	
	@FindBy(xpath="(//*[@class='picking_bin_title small'])[7]") WebElement locationStatus;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]") WebElement locationAvailability;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/span[1]/span[2]") WebElement aisleNetanya;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div[3]/span[1]/span[2]") WebElement aisleRishonLeZion;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[4]/div[2]/div[3]/span[1]/span[2]") WebElement aisleKiryatAta;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[5]/div[2]/div[3]/span[1]/span[2]") WebElement aisleBeersheba;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/span[2]/span[2]") WebElement shelfNetanya;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div[3]/span[2]/span[2]") WebElement shelfRishonLeZion;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[4]/div[2]/div[3]/span[2]/span[2]") WebElement shelfKiryatAta;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[5]/div[2]/div[3]/span[2]/span[2]") WebElement shelfBeersheba;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]") WebElement nameLocation;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[3]") WebElement SKULocation;
	
	@FindBy(xpath="//span[.='הוראות הרכבה/ שימוש']") WebElement instructions;
	
	@FindBy(xpath="//span[.='סביבה וחומרים']") WebElement environment;
	
	@FindBy(xpath="//span[.='טוב לדעת']") WebElement goodToKnow;
	
	@FindBy(xpath="//span[.='פירוט מרכיבי המוצר']") WebElement components;
	
	@FindBy(xpath="//span[.='גודל ומשקל']") WebElement sizeNweight;
	
	@FindBy(xpath="//span[@class='details_text break_line_wrap ng-binding']") WebElement information;
	
	@FindBy(id="ZA_CANVAS_640983_CLICKABLE_BIMAGE_2") WebElement closeAd;
	
	public void searchSKU(String userSKU)
	{
		searchButton.click();
		searchButton.sendKeys(userSKU);
		submitSearch.click();
	}
	
	public void checkForStock()
	{
		openStock.click();
		
		ArrayList<WebElement> stores = new ArrayList<WebElement>();
		stores.add(stockKiryatAta);
		stores.add(stockNetanya);
		stores.add(stockRishonLeZion);
		stores.add(stockBeersheba);
		
		System.out.println("Testing the stock status of product: " + SKU.getText() + " " + series.getText());
		
		for(WebElement element: stores)
		{
			element.click();
			
			assertStock(element);
			
			System.out.println("The current stock status of "+element.getText()+" is: "+stockStatus.getText());
			
			toggleStock.click();
		}
	}
		
	public void checkForLocation()
	{
		location.click();
		
		toggleLocation.click();
		
		ArrayList<WebElement> stores = new ArrayList<WebElement>();
		stores.add(locationNetanya);
		stores.add(locationRishonLeZion);
		stores.add(locationKiryatAta);
		stores.add(locationBeersheba);
		
		ArrayList<WebElement> aisles = new ArrayList<WebElement>();
		aisles.add(aisleNetanya);
		aisles.add(aisleRishonLeZion);
		aisles.add(aisleKiryatAta);
		aisles.add(aisleBeersheba);
		
		ArrayList<WebElement> shelfs = new ArrayList<WebElement>();
		shelfs.add(shelfNetanya);
		shelfs.add(shelfRishonLeZion);
		shelfs.add(shelfKiryatAta);
		shelfs.add(shelfBeersheba);
		
		System.out.println("Testing the location status of product: " + SKU.getText() + " " + series.getText());
		
//		Enhanced for Loop: for (WebElement element: stores)
		
		for (int i=0; i<aisles.size(); i++)
			{
			
			WebElement store = stores.get(i);
			WebElement aisle = aisles.get(i);
			WebElement shelf = shelfs.get(i);
			
			store.click();
			
			if (aisle.getAttribute("innerHTML").contentEquals("חד"))
			{
				locationAvailability = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[3]/div[1]"));
				System.out.println("The location status of " + locationName.getAttribute("innerHTML") + " is: " + locationAvailability.getAttribute("innerHTML"));
				System.out.println("The product can be found at: מחלקת "+aisle.getAttribute("innerHTML")+shelf.getAttribute("innerHTML"));
			}
			else
			{
				System.out.println("The location status of " + locationName.getAttribute("innerHTML") + " is: " + locationAvailability.getAttribute("innerHTML"));
				System.out.println("The product can be found at aisle: "+aisle.getAttribute("innerHTML")+" on shelf number: "+shelf.getAttribute("innerHTML"));
			}
			toggleLocation.click();
		}
		
	}
	
	public void productDetails()
	{
		closeLocation.click();

		ArrayList<WebElement> details = new ArrayList<WebElement>();
		details.add(instructions);
		details.add(environment);
		details.add(goodToKnow);
		details.add(components);
		details.add(sizeNweight);
		
						
		for(WebElement element: details)
		{
			if (element.getText().equalsIgnoreCase("גודל ומשקל"))
			{
				closeAd.click();
			}
			element.click();
			System.out.println("The content of " + element.getText() + " is:");
			System.out.println(information.getText());
		}
	
		
	}
	
	public void assertSKUPage(String valueSKU, String valueSeries)
	{
		Assert.assertEquals(SKU.getText(), valueSKU,"Can't find product code: "+SKU.getText());
		System.out.println("Assert passed");
		Assert.assertEquals(series.getText(), valueSeries, "Can't find product series name: "+series.getText());
		System.out.println("Assert passed");
	}
	
	
	public void assertStock(WebElement element)
	{
		Assert.assertNotNull(stockAssertion.getText(), "Can't find the stock status of: " + element.getText());
		System.out.println("Assert passed");
	}
	
	public void assertLocation(String valueSKU, String valueSeries)
	{
		Assert.assertEquals(SKULocation.getText(), valueSKU,"Can't find the location of product code: "+SKU.getText());
		System.out.println("Assert passed");
		Assert.assertEquals(nameLocation.getText(), valueSeries, "Can't find the location of product series name: "+series.getText());
		System.out.println("Assert passed");
	}
}
