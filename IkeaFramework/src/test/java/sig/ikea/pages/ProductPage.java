package sig.ikea.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;
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
	
	@FindBy(xpath="/html/body/div[3]/div[2]/div[2]/div/div[1]/div[2]/div/div[6]/div/a/span[2]/div/span/i") WebElement twiggleStock;
	
	@FindBy(xpath="/html/body/div[3]/div[2]/div[2]/div/div[1]/div[2]/div/div[8]/span[1]/span") WebElement stockStatus;

	@FindBy(xpath="//span[.='קריית אתא']") WebElement stockKiryatAta;
	
	@FindBy(xpath="//span[.='נתניה']") WebElement stockNetanya;
	
	@FindBy(xpath="//span[.='ראשל\"צ']") WebElement stockRishonLeZion;
	
	@FindBy(xpath="//span[.='באר שבע']") WebElement stockBeersheba;
	
	@FindBy(xpath="//span[.='לחץ כאן לבדיקת מיקום המוצר בחנויות ושעות פתיחה']") WebElement location;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[1]/div/a/span[2]/div/span") WebElement twiggleLocation;
	
	@FindBy(xpath="//li[@id='ui-select-choices-row-1-1']") WebElement locationNetanya;
	
	@FindBy(xpath="//li[@id='ui-select-choices-row-1-2']") WebElement locationRishonLeZion;
	
	@FindBy(xpath="//li[@id='ui-select-choices-row-1-3']") WebElement locationKiryatAta;
	
	@FindBy(xpath="//li[@id='ui-select-choices-row-1-4']") WebElement locationBeersheba;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[1]/div/a/span[2]/div/span/span[2]") WebElement locationName;
	
	@FindBy(xpath="(//*[@class='picking_bin_title small'])[7]") WebElement locationStatus;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]") WebElement locationAvailability;
	
	public void searchSKU(String userSKU)
	{
		searchButton.click();
		searchButton.sendKeys(userSKU);
		submitSearch.click();
	}
	
	public void assertProductPage(String valueSKU, String valueSeries)
	{
		Assert.assertEquals(SKU.getText(), valueSKU,"Can't find product code: "+SKU.getText());
		
		Assert.assertEquals(series.getText(), valueSeries, "Can't find product series name: "+series.getText());		
	}
	
	public void checkForStock()
	{
		openStock.click();
		
		ArrayList<WebElement> stores = new ArrayList<WebElement>();
		stores.add(stockKiryatAta);
		stores.add(stockNetanya);
		stores.add(stockRishonLeZion);
		stores.add(stockBeersheba);
		
		for(WebElement element: stores)
		{
			element.click();
			
			System.out.println("The current stock status of "+element.getText()+" is: "+stockStatus.getText());
			
			twiggleStock.click();
		}
	}
		
	public void checkForLocation()
	{
		location.click();
		
		twiggleLocation.click();
		
		ArrayList<WebElement> stores = new ArrayList<WebElement>();
		stores.add(locationNetanya);
		stores.add(locationRishonLeZion);
		stores.add(locationKiryatAta);
		stores.add(locationBeersheba);
				
		for (WebElement element: stores)
		{
			element.click();
			
			System.out.println("The location status of " + locationName.getAttribute("innerHTML") + " is: " + locationAvailability.getAttribute("innerHTML"));
			
			twiggleLocation.click();
		}
	}
}
