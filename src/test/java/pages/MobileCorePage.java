package pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.ConfigUtils;

public class MobileCorePage {
	
	public static AppiumDriver<WebElement> driver;
	
	@BeforeSuite
	
	public void setup() throws MalformedURLException {
	
			
			DesiredCapabilities caps = new DesiredCapabilities();
				
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 30");
			caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			
			caps.setCapability("appPackage", "com.landmarkgroup.centrepointstores");
			caps.setCapability("appActivity", "com.landmarkgroupreactapps.SplashActivity");
			
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			
			driver = new AndroidDriver<WebElement>(url,caps);
		
			
	
	
	}
	
	@AfterTest
	public static void teardown() {
		driver.quit();
	}
}
