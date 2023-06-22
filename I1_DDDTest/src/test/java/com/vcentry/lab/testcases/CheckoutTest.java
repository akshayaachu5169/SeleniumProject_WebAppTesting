package com.vcentry.lab.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vcentry.lab.intializer.Initializer;
import com.vcentry.lab.pages.HomePage;
import com.vcentry.lab.pages.LoginPage;

public class CheckoutTest extends Initializer {
	@BeforeTest
	@Parameters({ "username", "password" })
	public void validateCheckout(String username, String password) throws IOException {

		intialize();
		wd.get(envprop.getProperty("URL"));

		// login page
		// step1
//	wd.findElement(By.name("username")).sendKeys("Akshayaachu");
//	wd.findElement(By.name("password")).sendKeys("Aswin@1a");
//	wd.findElement(By.xpath(".//button[text()='Login']")).click();

		// step2
//	wd.findElement(By.name(locprop.getProperty("LOGIN_TYPE_USERNAME_NAME"))).sendKeys("Akshayaachu");
//	wd.findElement(By.name(locprop.getProperty("LOGIN_TYPE_PASSWORD_NAME"))).sendKeys("Aswin@1a");
//	wd.findElement(By.xpath(locprop.getProperty("LOGIN_CLICK_LOGINBUTTON_XPATH"))).click();

		// step3
//	getElementByName("LOGIN_TYPE_USERNAME_NAME").sendKeys("Akshayaachu");
//	getElementByName("LOGIN_TYPE_PASSWORD_NAME").sendKeys("Aswin@1a");
//	getElementByxpath("LOGIN_CLICK_LOGINBUTTON_XPATH").click();

		// step4
//		LoginPage.enterUsername("Akshayaachu");
//		LoginPage.enterPassword("Aswin@1a");
//		LoginPage.clickLoginButton();

		// step5
//
		LoginPage.enterUsername(username);
		LoginPage.enterPassword(password);
		LoginPage.clickLoginButton();
		
	}

	@Test(dataProvider = "test data")
	public void validateHomePage(String prodname, String mobileno, String email, String prodcat,
			String prodqua, String purchasername) throws InterruptedException, IOException {
	intialize();
	wd.get(envprop.getProperty("SIMPLEURL"));
		
//		 home page
		
		HomePage.enterProdname(prodname);
		HomePage.enterMobileno(mobileno);
		HomePage.enterEmail(email);
		HomePage.enterProdcat(prodcat);
		HomePage.enterProdqua(prodqua);
		HomePage.enterPurchasername(purchasername);
		HomePage.clickGst();
		HomePage.clickCod();
		HomePage.clickSubmit();
		Thread.sleep(2000);
	}

	@DataProvider(name = "test data")
	public static Object[][] getHomeTest() throws InterruptedException, FileNotFoundException, IOException {

//		Object data[][] = new Object[3][6];
//		Thread.sleep(2000);
//		data[0][0] = "mobiles";
//		data[0][1] = "99999";
//		data[0][2] = "Achu@123";
//		data[0][3] = "Electrical";
//		data[0][4] = "1";
//		data[0][5] = "Akshaya";
//		
//		Thread.sleep(2000);
//		data[1][0] = "Tv";
//		data[1][1] = "88888";
//		data[1][2] = "Ash@123";
//		data[1][3] = "Electronics";
//		data[1][4] = "2";
//		data[1][5] = "Aswin";
//		
//		Thread.sleep(2000);
//		data[2][0] = "cars";
//		data[2][1] = "77777";
//		data[2][2] = "Aak@123";
//		data[2][3] = "Vehicle";
//		data[2][4] = "3";
//		data[2][5] = "Aakash";
//		return data;

		File f = new File("C:\\SeleniumPractiseWorkSpace2\\I2_DDDTest\\files\\feb.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Home");
		int rowsize = sheet.getLastRowNum() + 1;
		int cellsize = sheet.getRow(0).getLastCellNum();
		Object data[][] = new Object[rowsize][cellsize];
		for (int i = 0; i < rowsize; i++) {

			for (int j = 0; j < cellsize; j++) {
				sheet.getRow(i).getCell(j).setCellType(CellType.STRING);
				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
