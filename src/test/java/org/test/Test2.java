package org.test;

import org.base.BaseClass;
import org.pages.HomePage;
import org.pages.ProductDetailsPage;
import org.pages.ProductList;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 extends BaseClass {

	@BeforeMethod
	private void beforeMethod() {
		System.out.println("beforeMethod");
		launchBrowser();

	}

	@Test()
	private void test() throws InterruptedException {
		getUrl("https://tuzzut.com/");
		waitAll();

		HomePage hp = new HomePage();
		moveToElement(hp.getBeautyAndFashionList());
		Thread.sleep(2000);
		click(hp.getSkinCareIcon());

		ProductList pl = new ProductList();
		int size = pl.getProductsName().size();

		ProductDetailsPage pdp = new ProductDetailsPage();

		for (int i = 0; i < size; i++) {
			pl.getProductsName().get(i).click();
			String price = pdp.getProductPrice().getText();
			String[] Split = price.split(" ");

			double parsedouble = Double.parseDouble(Split[1]);

			if (parsedouble < 10.0) {
				System.out.println(pdp.getProductsName().getText());
				break;

			} else {
				backward();
			}

		}

	}
}
