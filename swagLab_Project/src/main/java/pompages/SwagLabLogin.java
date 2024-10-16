package pompages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLogin {

	@FindBy (xpath="//input[@id='user-name']")
	private WebElement username;
	
	@FindBy (xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy (xpath="//input[@id='login-button']")
	private WebElement login;
	//button[text()='Open Menu']
	
//	@FindBy (xpath="//button[text()='Open Menu']")
//	private WebElement openMenu;
//	
//	@FindBy (xpath="//a[text()='Logout']")
//	private WebElement logout;
	
	private WebDriver driver;
	
	public  SwagLabLogin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void username(String userId)
	{
		username.sendKeys(userId);
	}
	public void password(String userPassword)
	{
		password.sendKeys(userPassword);
	}
	public void login()
	{
		login.click();
		List<String> address = new ArrayList<String>(driver.getWindowHandles());
		String a1= address.get(0);
		driver.switchTo().window(a1);
	}
	
}
