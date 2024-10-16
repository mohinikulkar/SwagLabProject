package pompages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	//div[@id='inventory_container']//div[@class='inventory_item_description']//a[@id='item_4_title_link']//div[@id='inventory_container']//div[@class='inventory_item_description']//a[@id='item_4_title_link']
	@FindBy (xpath="//button[text()='Open Menu']")
	private WebElement openMenu;
	
	@FindBy (xpath="//a[text()='Logout']")
	private WebElement logout;
	
	@FindBy (xpath="//select[@class='product_sort_container']")
	private WebElement dropdown;
	//div[text()='Test.allTheThings() T-Shirt (Red)']
	@FindBy (xpath="//div[text()='Test.allTheThings() T-Shirt (Red)']")
	private WebElement Clickshirt;
	
	//div[@class='inventory_item_description']//a[@id='item_3_title_link']
	@FindBy (xpath="//div[text()='Test.allTheThings() T-Shirt (Red)']")
	private WebElement productname;
	
	//(//div[@class='inventory_item'])[6]//div[@class='pricebar']//div[@data-test='inventory-item-price']
	
	@FindBy (xpath="(//div[@class='inventory_item'])[6]//div[@class='pricebar']//div[@data-test='inventory-item-price']")
	private WebElement clickshirtproductprice;
			
	@FindBy (xpath="(//div[@class='inventory_item'])[1]//div[@class='inventory_item_price']")
	private WebElement productprice;
	
	@FindBy (xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	private WebElement addToCart;
	
	@FindBy (xpath="//div[text()='Sauce Labs Backpack']")
	private WebElement firstproduct;
	
	
	
	//button[@id='add-to-cart-sauce-labs-bike-light']
	@FindBy (xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")
	private WebElement addToCart2;
	
	@FindBy (xpath="//a[@class='shopping_cart_link']")
	private WebElement GoToCart;
	
	//@FindBy (xpath="(//div[@class='inventory_item'])[1]//div[@class='inventory_item_price']")
	//private WebElement product1;
	

	@FindBy (xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
	private WebElement product2;
	

	@FindBy (xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
	private WebElement product3;
	

	@FindBy (xpath="//button[@id='add-to-cart-sauce-labs-onesie']")
	private WebElement product4;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public  HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait= new WebDriverWait(driver,Duration.ofSeconds(2));
		
	}
	
	public void openmenu() {
		openMenu.click();
	}
	
	public void logout()
	{
		logout.click();
	}
	public void addTocart()
	{
		addToCart.click();
	}
	public void goTocart()
	{
		GoToCart.click();
	}
	public void addToCart2()
	{
		addToCart2.click();
	}
	public void drop()
	{
		Select select = new Select(dropdown);
		select.selectByVisibleText("Name (Z to A)");
	}
	
//	public void product1()
//	{
//		product1.click();
//	}
	public void product2()
	{
		product2.click();
	}
	public void product3()
	{
		product3.click();
	}
	public void product4()
	{
		product4.click();
	}
	public String productname()
	{
		//wait.until(ExpectedConditions.visibilityOf(productname));
		return productname.getText().trim();
	}
	public void clickshirt()
	{
		Clickshirt.click();
	}
	public String firstproduct()
	{
		return firstproduct.getText().trim();
	}
	public String firstprice()
	{
		wait.until(ExpectedConditions.visibilityOf(productprice));
		return productprice.getText().trim();
	}
	public String clickshirtproductprice()
	{
		return clickshirtproductprice.getText().trim();
	}

}
