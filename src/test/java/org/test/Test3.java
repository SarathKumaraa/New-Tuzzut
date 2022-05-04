package org.test;

import org.base.BaseClass;
import org.pages.HomePage;
import org.pages.ProductList;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test3 extends BaseClass {

	@BeforeSuite
	private void beforeMethod() {
		System.out.println("beforeMethod");
		launchBrowser();

	}

	@Test()
	private void test1() {
		getUrl("https://tuzzut.com/");
		waitAll();

		HomePage hp = new HomePage();
		sendkeys(hp.getSearchBox(), "mobiles");
		click(hp.getSubmitBtn());

		ProductList pl = new ProductList();
		pl.getProductsName().get(0).click();
		pl.getProductName().click();
		String a = pl.getProductName().getText();
		String b = pl.getSelectedProductName().getText();

		Assert.assertEquals(a, b);

	}
	
	@Test()
	private void test3() {
		getUrl("https://tuzzut.com/");
		waitAll();

		HomePage hp = new HomePage();
		String c = "watches";
		sendkeys(hp.getSearchBox(), c);
		click(hp.getSubmitBtn());

		ProductList pl = new ProductList();
		String d = pl.getProductForWatches().getText();
		
	Assert.assertTrue(d.contains(c));
	
	}
	
	@Test()
	private void test2() {
		getUrl("https://tuzzut.com/");
		waitAll();
		
		HomePage hp = new HomePage();
		moveToElement(hp.getBeautyAndFashionList());
		click(hp.getSkinCareIcon());
		
		ProductList pl = new ProductList();
		int size=pl.getAllProductsBox().size();
		
		for(int i=0; i<size;i++) {
			String price = pl.getPrice().get(i).getText();
			System.out.println(price);
			String[] Split = price.split(" ");
			System.out.println(Split);
			
			double parsedouble = Double.parseDouble(Split[1]);
			
			if(parsedouble<10.0) {
				click(pl.getProductsName().get(i));
				break;
		}else {
			System.out.println("No product under 10 QAR");
		}
			
			Assert.assertTrue(false);
	}
	}
	
}
