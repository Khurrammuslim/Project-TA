package pages;


import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ProductsPage {
	
	public static WebDriver driver;
	
	static By navBarSelectionWomen = By.xpath("//a[text()='Women']");
	static By filterRating = By.xpath("//li[@class='wc-layered-nav-rating']");
	static By firstProductName = By.xpath("//h2[text()='Floral Crop Top']");
	static By firstProductPrice = By.xpath("//*[contains(text(),'67.00')]");
	static By productTitle = By.xpath("//h1[text()='Floral Crop Top']");
	static By productPrice = By.xpath("//*[@class='price']");
	static By qtyBox = By.xpath("//*[@name='quantity']");
	static By addtocartBtn = By.xpath("//button[@name='add-to-cart']");
	static By viewCartBtn = By.xpath("//a[@class='button wc-forward']");
	static By changeAddress = By.className("shipping-calculator-button");
	static By countryDrpDwn = By.id("select2-calc_shipping_country-container");
	static By countrySearchField = By.cssSelector("span.select2-search.select2-search--dropdown > input");
	static By stateField = By.xpath("//input[@id='calc_shipping_state']");
	static By cityField = By.id("calc_shipping_city");
	static By updateBtn = By.name("calc_shipping");
	static By proceedtocheckoutBtn = By.linkText("Proceed to checkout");
	static By addtoCartIcon = By.xpath("//i[@class='fa fa-shopping-cart']");
	static By removeCartBtn = By.cssSelector("td.product-remove > a");

	public static By cartRemovedMsg = By.xpath("//div[@class='woocommerce-message']");
	public ProductsPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void navbarSwitches() {
		driver.switchTo().frame("iframe");
		driver.findElement(navBarSelectionWomen).click();
	}
	
	public void filtersbyRating() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,250)", "");
	driver.findElement(filterRating).click();
	}
	
	public static void CompareProductsNameAndPriceBeforeClick(){
		
		String compare1 = driver.findElement(firstProductName).getText();
		System.out.println(compare1);
		String compare2 = driver.findElement(firstProductPrice).getText();
		System.out.println(compare2);		
		

		assertEquals("Floral Crop Top" , compare1);
		assertEquals("$67.00" , compare2);
		
	}
	
	
	public static void ClickFirstProduct() {
	driver.findElement(firstProductName).click();
	}
	

	
	public static void CompareProductsNameAndPriceAfterClick() {

		String compare3 = driver.findElement(productTitle).getText();
		System.out.println(compare3);
		String compare4 = driver.findElement(productPrice).getText();
		System.out.println(compare4);
		
		assertEquals("Floral Crop Top" , compare3);
		assertEquals("$67.00" , compare4);
	
	}
	
	public static void qtyBoxClick() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
//		driver.switchTo().parentFrame();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(qtyBox).click();
		driver.findElement(qtyBox).sendKeys(Keys.ARROW_UP);		
	}
	
	public static void AddtoCart() {
		driver.findElement(addtocartBtn).click();
	}
	
	public static void ViewCart() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(viewCartBtn).click();		
	}
	
	public static void ChangeAddressProcess(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		driver.findElement(changeAddress).click();
		driver.findElement(countryDrpDwn).click();
		driver.findElement(countrySearchField).sendKeys("United Arab Emirates");
		driver.findElement(countrySearchField).sendKeys(Keys.ENTER);
		driver.findElement(stateField).sendKeys("Dubai");
		driver.findElement(cityField).sendKeys("Dubai");		
		driver.findElement(updateBtn).click();		
	}
	
	public static void ProceedtoCheckout() {
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", driver.findElement(proceedtocheckoutBtn));

		driver.navigate().back();
		driver.navigate().refresh();	
	}
	
	public static void ViewCartIcon() {
		driver.switchTo().frame("iframe");
		driver.findElement(addtoCartIcon).click();
	}
	
	public static void RemoveCart() {
		
		driver.findElement(removeCartBtn).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static String getCartRemovedTxt() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(cartRemovedMsg))).getText();
	}
	
}
