package tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.ProductsPage;
import pages.corePage;

import utils.TestListener;

@Listeners(TestListener.class)
public class TestExecutionWeb extends corePage {
	public WebDriver driver;

	@Test(description = "Web-test")
	
	public void WebTest( ) {
		
		ProductsPage.CompareProductsNameAndPriceBeforeClick();
		ProductsPage.ClickFirstProduct();
		ProductsPage.CompareProductsNameAndPriceAfterClick();
		ProductsPage.qtyBoxClick();
		ProductsPage.AddtoCart();			
		ProductsPage.ViewCart();
		ProductsPage.ChangeAddressProcess();
		ProductsPage.ProceedtoCheckout();		

		ProductsPage.ViewCartIcon();
		ProductsPage.RemoveCart();
		
		assertEquals(ProductsPage.getCartRemovedTxt(),
				"“Floral Crop Top” removed. Undo?");

	}
}
