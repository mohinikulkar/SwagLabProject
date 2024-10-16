package testClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browser;
import pompages.AddItem;
import pompages.Cart;
import pompages.Checkout;
import pompages.Checkout2;
import pompages.HomePage;
import pompages.SwagLabLogin;

public class SwaglabTestClass2 extends Browser{
	private WebDriver driver;
	private SwagLabLogin swagloginpage;
	private HomePage homepage;
	private Cart cart;
	private Checkout checkout;
	private Checkout2 checkout2;
	private AddItem additem;
	
	
	@Parameters("browser")
	@BeforeTest
	void openBrowser(String expectedBrowser)
	{
		driver= launchBrowser(expectedBrowser);
	}
	@BeforeClass
	public void initializePOM() {

		cart =new Cart(driver);
		checkout = new Checkout(driver);
		checkout2 = new Checkout2(driver);
		additem = new AddItem(driver);
		swagloginpage = new SwagLabLogin(driver);
		homepage = new HomePage(driver);
	}
	@BeforeMethod
	public void loginToSwaglab() {
		driver.get("https://www.saucedemo.com/");
		swagloginpage.username("");
		swagloginpage.password("");
		swagloginpage.login();
	}
	
	 @Test
   public void selectDropdownTC_01() throws InterruptedException
   {
	Thread.sleep(5000);
	homepage.drop();
	homepage.clickshirt();
	additem.addingcart();
	String expectedname = homepage.productname();
	String actualname = additem.getproductname();
	Assert.assertEquals( actualname,expectedname );
	System.out.println(expectedname);
	System.out.println(actualname);
	 String actualprice = additem.getclickshirtproductprice();
	 String expectedprice = homepage.clickshirtproductprice();
	 Assert.assertEquals(actualprice, expectedprice);

 }
//
 @Test
public void addingMultipleItemTc_02() throws InterruptedException
{
	   Thread.sleep(5000);
	  // homepage.product1();
	   homepage.product2();
	   homepage.product3();
	   homepage.product4();
} 
// 
 @Test
 public void removeCartTc_03()
 {
	   homepage.addTocart();
	   homepage.goTocart();
	   cart.remove();
	   cart.continueShopping();
 }
	@AfterMethod
	public void logout() {
	homepage.openmenu();
	 homepage.logout();
	}
	
	//@AfterClass
	//public void closeBrowser() {
		//driver.quit();
	//}
	
	@AfterTest
	public void closeBrowser() {
		//driver.quit();
	}
	
		

}


