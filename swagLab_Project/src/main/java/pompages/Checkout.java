package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {
	@FindBy (xpath="//input[@id='first-name']")
	private WebElement firstname;
	
	@FindBy (xpath="//input[@id='last-name']")
	private WebElement lastname;
	
	@FindBy (xpath="//input[@id='postal-code']")
	private WebElement pincode;
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement continuebutton;
	

	;
	
	private WebDriver driver;
	
	public  Checkout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void firstname()
	{
		firstname.sendKeys("xyz");
	}
	public void lastname()
	{
		lastname.sendKeys("hcgh");
	}
	public void pincode() {
		pincode.sendKeys("87654");
	}
	public void continueb()
	{
		continuebutton.click();
	}
	
	

}
