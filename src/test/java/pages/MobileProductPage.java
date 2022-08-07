package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;

public class MobileProductPage {

	public static AppiumDriver<WebElement> driver;
	
	public MobileProductPage(AppiumDriver<WebElement> driver){
		MobileProductPage.driver = driver;
	}
	
	
	public static void test1() {
		System.out.println("Hi");
	}
	
	
}
