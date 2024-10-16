package testClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import base.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pompages.AddItem;
import pompages.Cart;
import pompages.Checkout;
import pompages.Checkout2;
import pompages.HomePage;
import pompages.SwagLabLogin;

public class SwagLabTest extends Browser{

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
	public void initializePom() {
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
	
	@Test (groups =("sanity"))
	public void buyProductTC_01() throws InterruptedException
	{
	
		Thread.sleep(5000);
	
		homepage.addTocart();
		homepage.goTocart();
		String expectedname= homepage.firstproduct();
		String actualname= cart.getfirstproductname();
		
		//String expectedprice = homepage.firstprice();
		//String actualprice = cart.getfirstproductprice();
		
		SoftAssert softassert = new SoftAssert();
		
		softassert.assertEquals(actualname, expectedname);
		
		//softassert.assertEquals(actualprice , expectedprice);
		//System.out.println(actualprice);
		//System.out.println(expectedprice);
		
		cart.checkout();
		checkout.firstname();
		checkout.lastname();
		checkout.pincode();
		checkout.continueb();
		checkout2.finish();
		checkout2.backhome();
		
		softassert.assertAll();
		
	}
    @Test
    public void addToCart_TC_02()
{
		
		//homepage.addToCart2();
		//homepage.goTocart();
	  
      //cart.checkout();

}
//     @Test
//     public void selectDropdownTC_03() throws InterruptedException
//     {
//	Thread.sleep(5000);
//	homepage.drop();
//	homepage.clickshirt();
//	additem.addingcart();
//	
//    }
//
//   @Test
//   public void addingMultipleItemTc_04() throws InterruptedException
//   {
//	   Thread.sleep(5000);
//	  // homepage.product1();
//	   homepage.product2();
//	   homepage.product3();
//	   homepage.product4();
//   } 
//   
//   @Test
//   public void removeCartTc_05()
//   {
//	   homepage.addTocart();
//	   homepage.goTocart();
//	   cart.remove();
//	   cart.continueShopping();
//   }
	@AfterMethod
	public void logout() {
	homepage.openmenu();
	 homepage.logout();
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
