package org.test;

import java.io.IOException;

import org.base.BaseClass;
import org.base.ReRunFailedTC;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test4 extends BaseClass {
	
	@BeforeClass
	private void beforeMethod() {
		System.out.println("beforeMethod");
		launchBrowser();

	}

	@Test()
	private void test1() throws InterruptedException {
		getUrl("https://tuzzut.com/");
		waitAll();
		Thread.sleep(3000);
		Assert.assertTrue(false);
		
	}
	
	@AfterClass
	private void afterMethod() {
		System.out.println("afterMethod");
		close();

	}
	
}
