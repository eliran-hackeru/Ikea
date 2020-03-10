package sig.ikea.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import sig.ikea.utility.Helper;

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
	
	@FindBy(id="quick_links_close") WebElement closeLocation;
	
	@FindBy(xpath="//li[@id='ui-select-choices-row-1-1']") WebElement locationNetanya;
	
	@FindBy(xpath="//li[@id='ui-select-choices-row-1-2']") WebElement locationRishonLeZion;
	
	@FindBy(xpath="//li[@id='ui-select-choices-row-1-3']") WebElement locationKiryatAta;
	
	@FindBy(xpath="//li[@id='ui-select-choices-row-1-4']") WebElement locationBeersheba;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[1]/div/a/span[2]/div/span/span[2]") WebElement locationName;
	
	@FindBy(xpath="(//*[@class='picking_bin_title small'])[7]") WebElement locationStatus;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]") WebElement locationAvailability;
	
	@FindBy(css="span[class*='product_picking_bin aisle ng-binding']") List<WebElement> pickingBin;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]") WebElement nameLocation;
	
	@FindAll({@FindBy(className="ng-binding")}) List<WebElement> SKULocation;
	
	@FindBy(xpath="//span[.='הוראות הרכבה/ שימוש']") WebElement instructions;
	
	@FindBy(xpath="//span[.='סביבה וחומרים']") WebElement environment;
	
	@FindBy(xpath="//span[.='טוב לדעת']") WebElement goodToKnow;
	
	@FindBy(xpath="//span[.='פירוט מרכיבי המוצר']") WebElement components;
	
	@FindBy(xpath="//span[.='גודל ומשקל']") WebElement sizeAndWeight;
	
	@FindBy(xpath="//span[@class='details_text break_line_wrap ng-binding']") WebElement information;
	
	@FindBy(id="ZA_CANVAS_640983_CLICKABLE_BIMAGE_2") WebElement closeAd;
	
	@FindBy(css="i[class*='glyphicon glyphicon-menu-']") List<WebElement> toggles;
	
	@FindBy(css="div[ng-click*='openDocFolder = !openDocFolder']") WebElement assemble;
	
	@FindBy(css="span[class*='doc_title ng-binding']") List<WebElement> pdfList;
	
	@FindBy(css="span[ng-bind-html*='product.Material_s']") WebElement materials;
	
	@FindBy(css="span[ng-bind-html*='product.Good_to_Know_s']") WebElement goodContent;
	
	@FindBy(css="span[class*='details_text ng-binding ng-scope']") List<WebElement> countries;
	
	@FindBy(css="span[ng-bind-html*='product.Designer_s']") WebElement designer;
	
	@FindBy(className="tab_head_title") List<WebElement> details;
	
	@FindBy(css="span[ng-bind-html='product.Customer_Benefits_s']") WebElement generalInfo;
	
	@FindBy(css="td[class='alias ng-binding']") List<WebElement> aliasFields;
	
	@FindBy(css="td[class='solr_value details_text ng-binding']") List<WebElement> solrFields;
	
	@FindBy(css="div[ng-bind-html='sprsQuickLinksProduct.product.Description_s']") List<WebElement> spr;
	
	@FindBy(css="div[ng-bind-html='sprsQuickLinksProduct.product.Series_s || sprsQuickLinksProduct.product.Series_t']") List<WebElement> sprNames;
	
	@FindBy(xpath="/html/body/div[3]/div[2]/div[2]/div/div[1]/div[2]/div/div[4]") WebElement addToWishlist;
	
	@FindBy(css="span[ng-click='closeNotification()']") WebElement closeNotification;
	
	@FindBy(css="a[data-ng-click='viewWishlist()']") WebElement goToWishlist;
	
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
		int counter = 0;
		String[] storeNames = {"נתניה","ראשל\"צ","קריית אתא","באר שבע"};
		location.click();
		
		WebElement toggleLocation = toggles.get(16);
		toggleLocation.click();
		
		ArrayList<WebElement> stores = new ArrayList<WebElement>();
		stores.add(locationNetanya);
		stores.add(locationRishonLeZion);
		stores.add(locationKiryatAta);
		stores.add(locationBeersheba);
		System.out.println("Testing the location status of product: " + SKU.getText() + " " + series.getText());
		
		for (int i=0; i<stores.size(); i++)
			{
						
			WebElement store = stores.get(i);
			store.click();
			
			System.out.println("Location of "+storeNames[i]+" is: "+pickingBin.get(0).getAttribute("innerHTML"));
			toggleLocation.click();
			counter++;
			}
		assertLocation(counter);
	}
	
	public void productDetails()
	{
		closeLocation.click();
		
		Helper.scrollDown(driver);
		
		checkInstruction();
		
		checkForEnvironment();
		
		checkGoodToKnow();
		
		checkComponents();
		
		checkSizeAndWeight();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void checkInstruction()
	{
		assertInstructions();
		
		instructions.click();
		details.get(5).click();	
		assemble.click();
		
		System.out.println("The content of " + instructions.getText() + " is:");
		
		for(WebElement element: pdfList)
		{
			System.out.println(element.getText());
		}
	}
	
	public void checkForEnvironment()
	{
		assertEnvironment();
		
		environment.click();
		
		System.out.println("The content of " + environment.getText() + " is:");
		System.out.println(materials.getAttribute("innerHTML"));
	}
	
	public void checkGoodToKnow()
	{
		assertGoodToKnow();
		
		goodToKnow.click();
		
		System.out.println("The content of " + goodToKnow.getText() + " is:");
		System.out.println(goodContent.getAttribute("innerHTML"));
		
		System.out.println("The manufacturer countries are: ");
		
		for(WebElement element: countries)
		{
			System.out.print(element.getText());
		}
		
		System.out.println();
		System.out.println("Designed by: ");
		System.out.println(designer.getAttribute("innerHTML"));
	}
	
	public void checkComponents()
	{
		int counter = 0;
		
		if (Helper.checkIfElementExists(components))
		{
			components.click();
			
			System.out.println("The content of " + components.getText() + " is:");
			
			for(int i=0; i<spr.size(); i++)
			{
				System.out.println(spr.get(i).getText()+" of "+sprNames.get(i).getText());
				counter++;
			}
			assertComponents(counter,spr.size());
		}
		else
		{
			System.out.println("This product doesn't have components details");
		}
	}
	
	public void checkSizeAndWeight()
	{
		assertSizeAndWeight();
		sizeAndWeight.click();
		
		System.out.println("The content of " + sizeAndWeight.getText() + " is:");
		System.out.println("General Information: ");
		System.out.println(generalInfo.getAttribute("innerHTML"));
		
		
		System.out.println("Product Dimensions:");

		for(int i=0; i<solrFields.size(); i++)
		{
			System.out.println(aliasFields.get(i).getAttribute("innerHTML")+": "+solrFields.get(i).getAttribute("innerHTML"));
		}
		
	}
	
	public void assertSKUPage(String valueSKU, String valueSeries)
	{
		Assert.assertEquals(SKU.getText(), valueSKU,"Can't find product code: "+SKU.getText());
		System.out.println("Assert Product SKU passed");
		Assert.assertEquals(series.getText(), valueSeries, "Can't find product series name: "+series.getText());
		System.out.println("Assert Product Name passed");
	}
	
	
	public void assertStock(WebElement element)
	{
		Assert.assertNotNull(stockAssertion.getText(), "Can't find the stock status of: " + element.getText());
		System.out.println("Assert Stock of "+element.getText()+" passed");
	}
	
	public void assertLocation(int counter)
	{
		
		Assert.assertEquals(counter,4,"Didn't count 4 stores");
		System.out.println("Assert Location passed");
	}
	
	public void assertInstructions()
	{
		Assert.assertTrue(Helper.checkIfElementExists(instructions), "Can't find " +instructions.getText());
		System.out.println("Assert Instructions passed");
	}
	
	public void assertEnvironment()
	{
		Assert.assertTrue(Helper.checkIfElementExists(environment), "Can't find " +environment.getText());
		System.out.println("Assert Environment passed");
	}
	
	public void assertGoodToKnow()
	{
		Assert.assertTrue(Helper.checkIfElementExists(goodToKnow), "Can't find " +goodToKnow.getText());
		System.out.println("Assert Good To Know passed");
	}
	
	public void assertComponents(int counter, int size)
	{
		Assert.assertEquals(counter, size, "Missing parts of "+ components.getText());
		System.out.println("Assert Components passed");
	}
	
	public void assertSizeAndWeight()
	{
		Assert.assertTrue(Helper.checkIfElementExists(sizeAndWeight), "Can't find " +sizeAndWeight.getText());
	System.out.println("Assert Size And Weight passed");
	}
	
	public static boolean checkForAd(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		boolean exists = driver.findElements(By.id("ZA_CANVAS_640983_CLICKABLE_BIMAGE_2")).size() != 0;
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return exists;
	}
	
	public void closeTheAd()
	{
		if (Helper.checkForElementID(driver, "ZA_CANVAS_640983_CLICKABLE_BIMAGE_2"))
		{
			closeAd.click();
		}
	}
	
	public void addProductToWishlist()
	{
		addToWishlist.click();
		
		Helper.waitASec();
		
		closeNotification.click();
		
		Helper.waitASec();
	}
	
	public void moveToWishlist()
	{
		goToWishlist.click();
	}
}
