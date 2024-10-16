package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {

	public static WebDriver launchChromeBrowser()
	{
		WebDriver driver = new ChromeDriver();
	    return driver;
	}
	
	public static WebDriver launchEdgeBrowser()
	{
		WebDriver driver = new EdgeDriver();
		return driver;
	}
	public static WebDriver launchBrowser(String targetBrowser)
	{
		WebDriver driver =null;
		if(targetBrowser.equals("Chrome"))
		{
			driver= Browser.launchChromeBrowser();
		}
		
		if(targetBrowser.equals("Edge"))
		{
			driver= Browser.launchEdgeBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    return driver;	
	}
	
	
}
