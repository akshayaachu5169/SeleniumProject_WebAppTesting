package com.vcentry.lab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.vcentry.lab.intializer.Initializer;

public class HomePage extends Initializer {

	public static void enterProdname(String data) {
		 getElementById("LOGIN_TYPE_PRODNAME_ID").sendKeys(data);

	}

	public static void enterMobileno(String data) {
		getElementById("LOGIN_TYPE_MOBILENO_ID").sendKeys(data);
	}

	public static void enterEmail(String data) {
		getElementById("LOGIN_TYPE_EMAIL_ID").sendKeys(data);
	}

	public static void enterProdcat(String datas) {
		WebElement data = getElementById("LOGIN_TYPE_PRODCAT_ID");
		Select s = new Select(data);
		s.selectByVisibleText(datas);
	}

	public static void enterProdqua(String data) {
		getElementById("LOGIN_TYPE_PRODQUA_ID").sendKeys(data);
	}

	public static void enterPurchasername(String data) {
		getElementById("LOGIN_TYPE_PURCHASERNAME_ID").sendKeys(data);
	}

	public static void clickGst() {
		getElementById("LOGIN_CLICK_GST_ID").click();
	}

	public static void clickCod() {
		getElementById("LOGIN_CLICK_COD_ID").click();
	}

	public static void clickSubmit() {
		getElementById("LOGIN_CLICK_SUBMIT_ID").click();
	}

}
