package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.MobileCorePage;
import pages.MobileProductPage;
import pages.corePage;
import utils.TestListener;

@Listeners(TestListener.class)
public class TestExecutionMobile extends MobileCorePage {

/* 
 * I am unable to run Centrepoint app on either emulator or android mobile phone because
 * of the limitation of Centrepoint app that requires VPN access to eiher UAE or UK VPN.
 * I have tried couple of free VPN to figure this out and tries to run Centrepoint app
 * but not able to do so. I am informing you as I have completed all tasks from the 
 * assignment but if you guys think you can send me different app that will not have
 * VPN access requirement as I am based in Pakistan.
 * 
 */
	
	
	@Test(description = "Mobile-test")
	public void sampletest() {
		MobileProductPage.test1();
	}
}
