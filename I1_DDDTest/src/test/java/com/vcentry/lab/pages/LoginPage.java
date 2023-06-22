package com.vcentry.lab.pages;

import org.openqa.selenium.WebElement;

import com.vcentry.lab.intializer.Initializer;

public class LoginPage extends Initializer {

	public static void enterUsername(String data) {
		
		WebElement username =getElementByName("LOGIN_TYPE_USERNAME_NAME");
		if(username.isEnabled()) {
			username.sendKeys(data);
		}
		}
public static void enterPassword(String data) {
	WebElement password =getElementByName("LOGIN_TYPE_PASSWORD_NAME");
	if(password.isEnabled()) {
		password.sendKeys(data);
	}
	
	}
public static void clickLoginButton() {
	getElementByxpath("LOGIN_CLICK_LOGINBUTTON_XPATH").click();

}


}
