package com.vcentry.lab.intializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Initializer {

	/**
	 * @author Akshaya
	 * @Date Feb 2023
	 * @usage holds environmental properties
	 */

	public static FileInputStream envfis;
	public static Properties envprop;

	/**
	 * @author Akshaya
	 * @Date Feb 2023
	 * @usage holds locator properties
	 */
	public static FileInputStream locfis;
	public static Properties locprop;

	/**
	 * @author Akshaya
	 * @throws IOException
	 * @Date Feb 2023
	 * @usage holds env properties, locator properties, excel files
	 */
public static WebDriver wd;
	public void intialize() throws IOException {

		envfis = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "com" + File.separator + "vcentry" + File.separator
				+ "lab" + File.separator + "config" + File.separator + "env.properties");
		envprop = new Properties();
		envprop.load(envfis);

		locfis = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "com" + File.separator + "vcentry" + File.separator
				+ "lab" + File.separator + "config" + File.separator + "locator.properties");
		locprop = new Properties();
		locprop.load(locfis);

		if (envprop.get("BROWSER").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			 wd = new ChromeDriver();
		} else if (envprop.get("BROWSER").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 wd = new FirefoxDriver();
			 
		}
		wd.manage().window().maximize();
		wd.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	public static WebElement getElementByName(String name) {
		return wd.findElement(By.name(locprop.getProperty(name)));
		
	}
public static WebElement getElementById(String id) {
	return wd.findElement(By.id(locprop.getProperty(id)));
	}
public static WebElement getElementByxpath(String xpath) {
	return wd.findElement(By.xpath(locprop.getProperty(xpath)));
	
}
}