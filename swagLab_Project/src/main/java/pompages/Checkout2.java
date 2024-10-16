package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout2 {
	@FindBy (xpath="//button[text()='Finish']")
	private WebElement finish;
	//button[text()='Back Home']
	@FindBy (xpath="//button[text()='Back Home']")
	private WebElement back;
	private WebDriver driver;
	
	public  Checkout2(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void finish() {
		finish.click();
	}
	public void backhome()
	{
		back.click();
	}
}
