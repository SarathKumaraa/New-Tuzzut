package org.test;

import org.base.BaseClass;
import org.pages.ContactDetailsPage;
import org.pages.HomePage;
import org.pages.ProductDetailsPage;
import org.pages.ProductList;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testasser extends BaseClass {

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
		sendkeys(hp.getSearchBox(), "mobiles");
		click(hp.getSubmitBtn());

		ProductList pl = new ProductList();
		pl.getProductsName().get(0).click();

		ProductDetailsPage pdp = new ProductDetailsPage();

		String price = pdp.getProductPrice().getText();
		String[] Split = price.split(" ");

		double parsedouble = Double.parseDouble(Split[1]);
		System.out.println(parsedouble);

		pdp.getWatchBuyBtn().click();

		ContactDetailsPage cdp = new ContactDetailsPage();
		sendkeys(cdp.getEmailInfo(), "sarath1234@test.com");
		sendkeys(cdp.getNameInfo(), "sa");
		sendkeys(cdp.getLastNameInfo(), "kumar");
		sendkeys(cdp.getAddressInfo(), "chennai");
		sendkeys(cdp.getCityInfo(), "chemmai");
		sendkeys(cdp.getPhoneInfo(), "123456");
		click(cdp.getContinueBtn());

		String shippingtext = cdp.getShippingPrice().getText();
		String[] split2 = shippingtext.split("R");

		double shipping = Double.parseDouble(split2[1]);

		String totaltext = cdp.getTotalPrice().getText();

		String[] split3 = totaltext.split("R");

		double total = Double.parseDouble(split3[1]);
		System.out.println(total);

		Assert.assertEquals(parsedouble + shipping, total);

	}

}