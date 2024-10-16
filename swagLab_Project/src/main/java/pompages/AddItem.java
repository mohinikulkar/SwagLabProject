package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddItem {
	
	//div[@class='inventory_details_desc_container']//div[@data-test='inventory-item-name']
	@FindBy (xpath="//button[@id='add-to-cart']")
	private WebElement addtocart;
	
	@FindBy (xpath="//div[@class='inventory_details_desc_container']//div[@data-test='inventory-item-name']")
	private WebElement getproductname;
	
	//div[@class='cart_item'] //div[@class='inventory_item_price']
	@FindBy (xpath="//div[@class='cart_item'] //div[@class='inventory_item_price']")
	private WebElement getproductprice;
	
	//div[@id='inventory_item_container']//div[@class='inventory_details_price']//div[@id='inventory_item_container']//div[@class='inventory_details_price']
	@FindBy (xpath="//div[@id='inventory_item_container']//div[@class='inventory_details_price']")
	private WebElement clickshirtproductprice;
private WebDriver driver;
	
	public  AddItem(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addingcart()
	{
		addtocart.click();
	}
	
	public String getproductname() {
		return getproductname.getText().trim();
	}
	public String getclickshirtproductprice()
	{
		return  clickshirtproductprice.getText();
	}
}
