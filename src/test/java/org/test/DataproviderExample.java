package org.test;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.pages.HomePage;
import org.pages.ProductList;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderExample extends BaseClass {

	@Test(dataProvider = "test Data")
	private void Test(String product) {
		launchBrowser();
		
		getUrl("https://tuzzut.com/");
		
		HomePage hp = new HomePage();
		hp.getSearchBox().sendKeys(product);
		hp.getSubmitBtn().click();
		ProductList pl = new ProductList();
		
		System.out.println(pl.getProductsName().get(0).getText());
		
		
		
		
//		getUrl("https://www.facebook.com/");
//		driver.findElement(By.id("email")).sendKeys(username);		
//		driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy _9npi']")).sendKeys(password);
		
		
		
		
	}

	@DataProvider(name="test Data")
	private Object [] TestData(){
		Object [] prod = new Object [4];
		prod[0] = "mobiles";
		prod[1] = "watches";
		prod[2] = "pen";
		prod[3] = "bat";
		
		
		
		return prod;
		
	}

}
