package org.test;

import org.base.BaseClass;
import org.pages.HomePage;
import org.pages.ProductDetailsPage;
import org.pages.ProductList;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 extends BaseClass {

	@BeforeMethod
	private void beforeMethod() {
		System.out.println("beforeMethod");
		launchBrowser();

	}

	@Test()
	private void test() {
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
