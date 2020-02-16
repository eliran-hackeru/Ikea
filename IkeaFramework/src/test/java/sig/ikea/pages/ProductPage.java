package sig.ikea.pages;

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
	
	@FindBy(xpath="//span[@class='select2-chosen ng-binding']") WebElement stockInfo;
	
	@FindBy(xpath="//span[@ng-bind-html='current_store.status_msg']") WebElement stockStatus;
	
	@FindBy(xpath="//span[.='לבירור מלאי אנא בחרו חנות מהרשימה']") WebElement moreStockInfo;
	
	@FindBy(xpath="//span[.='קריית אתא']") WebElement stockKiryatAta;
	
	@FindBy(xpath="//span[.='נתניה']") WebElement stockNetanya;
	
	@FindBy(xpath="//span[.='ראשל\"צ']") WebElement stockRishonLeZion;
	
	@FindBy(xpath="//span[.='באר שבע']") WebElement stockBeersheba;
	
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
		stockInfo.click();
		stockKiryatAta.click();
		System.out.println(stockStatus.getText());
		
		moreStockInfo.click();
		stockNetanya.click();
		System.out.println(stockStatus.getText());
		
		moreStockInfo.click();
		stockRishonLeZion.click();
		System.out.println(stockStatus.getText());
		
		moreStockInfo.click();
		stockBeersheba.click();
		System.out.println(stockStatus.getText());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
