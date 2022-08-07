package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.MobileCorePage;
import pages.MobileProductPage;
import pages.corePage;
import utils.TestListener;

@Listeners(TestListener.class)
public class TestExecutionMobile extends MobileCorePage {

	@Test(description = "Mobile-test")
	public void sampletest() {
		MobileProductPage.test1();
	}
}
