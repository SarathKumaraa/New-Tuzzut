package org.test;

import org.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

	WebDriver driver;

	@Parameters({ "browser" })
	@Test
	private void launchURLTest(String browser) {

		if (browser.equals("Chrome")) {
			launchBrowser();

		} else {
			System.out.println("browser not working");
		}

		getUrl("https://tuzzut.com/");

	}

}
