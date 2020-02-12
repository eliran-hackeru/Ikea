package sig.ikea.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	//Screenshots, alerts, frames, windows, Sync issue, javascript executor
	
	public static void captureScreenshot(WebDriver driver, String screenshotName) 
	{
		try 
		{
			TakesScreenshot ts =((TakesScreenshot)driver);
			
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			File DestFile=new File("./Screenshots/"+screenshotName+"_LoginTest.png");
			
			FileUtils.copyFile(src,DestFile);
			
			System.out.println("Screenshot captured");
		}
		catch (Exception e) {
			
			System.out.println("Exception while capturing screenshot "+e.getMessage());
		} 
	}
	
	public void handleFrames() 
	{
		
	}
	
	public void handle() 
	{
		
	}

}
