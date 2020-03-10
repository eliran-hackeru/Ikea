package sig.ikea.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Helper {
	
	//Screenshots, alerts, frames, windows, Sync issue, javascript executor
	
	public static void captureScreenshot(WebDriver driver, String testName, String screenshotName) 
	{
		try 
		{
			TakesScreenshot ts =((TakesScreenshot)driver);
			
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			File DestFile=new File("./Screenshots/"+testName+"_"+screenshotName+"_"+getCurrentDateTime()+".png");
			
			FileUtils.copyFile(src,DestFile);
			
			System.out.println("Screenshot captured");
		}
		catch (Exception e) {
			
			System.out.println("Exception while capturing screenshot "+e.getMessage());
		} 
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat = new SimpleDateFormat("yyyy-MM-dd");
		
//		Full date format: DateFormat customFormat = new SimpleDateFormat("yyyy-MM-dd HH_mm_ss");
		
		Date currentDate = new Date();
		
		return customFormat.format(currentDate);
	}
	
	public static void waitForElementByID(WebDriver driver, String value)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
	}
	
	public static void waitForElementByClassName(WebDriver driver, String className)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.className(className)));
	}
	
	public static void waitForElementBycssSelector(WebDriver driver, String lable, String element, String value)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("lable[element='value']")));
	}

	public static boolean checkForElementID(WebDriver driver, String value)
	{
		if (driver.findElements(By.id(value)).size() != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
	}
	
	public static void scrollUp(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public static boolean checkIfElementExists(WebElement element)
	{
		if (element.isDisplayed() && element.isEnabled())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void waitASec()
	{
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	public static void robotScrollUp() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_UP);
	}
	public void handleFrames() 
	{
		
	}
	
	public void handle() 
	{
		
	}

}
