package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
//	@FindBy (xpath="//a[@class='shopping_cart_link']")
//	private WebElement GoToCart;
	
	@FindBy (xpath="//button[text()='Checkout']")
	private WebElement Checkout;
	
	@FindBy (xpath="//button[@id='remove-sauce-labs-backpack']")
    private WebElement Remove;
	
	@FindBy (xpath="//button[@name='continue-shopping']")
    private WebElement continueShopping;
	
//	
	@FindBy (xpath="//div[@class='cart_item']//a[@id='item_4_title_link']")
	private WebElement getfirstproductname;
	
	@FindBy (xpath="//div[@class='cart_item'] //div[@class='inventory_item_price']")
	private WebElement getfirstproductprice;
//	
//	@FindBy (xpath="//input[@id='continue']")
//	private WebElement continuebutton;
	
	private WebDriver driver;
	
	public  Cart(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkout()
	{
		Checkout.click();
	}
	public void remove()
	{
	Remove.click();
	}
	public void continueShopping()
	{
	continueShopping.click();
	}
	public String getfirstproductname() {
		return  getfirstproductname.getText().trim();
	}
public String getfirstproductprice()
{
	return  getfirstproductprice.getText().trim();
}
}
