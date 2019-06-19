package com.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class Task1 extends CommonMethods {
	public class SauceDemo extends CommonMethods {
		@BeforeClass
		public void setUp() {
			setUpDriver("chrome", "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Process.aspx");
			driver.findElement(By.cssSelector("input#ctl00_MainContent_username")).sendKeys("Tester");
			driver.findElement(By.cssSelector("input#ctl00_MainContent_password")).sendKeys("test");
			driver.findElement(By.cssSelector("input#ctl00_MainContent_login_button")).click();
			
			WebElement login=driver.findElement(By.cssSelector("div.login_info"));
			Assert.assertTrue(login.isDisplayed());
			System.out.println("Succesfully logged IN");
		}
		
		
		
		@Test
		public void enterUser1() {
		WebElement productDD = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
		Select obj = new Select(productDD);
		obj.selectByVisibleText("FamilyAlbum");

		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")), "125");
		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtUnitPrice']")), "123");
		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtDiscount']")), "10");

		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']")), "John");
		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")), "Washington blvd");
		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")), "Fairfax");
		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")), "Va");
		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")), "222007");

		 String expectedCard = "MasterCard";
		List<WebElement> cells = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_fmwOrder_cardList']/tbody/tr/td"));
		for (WebElement cell : cells) {

			String cellText = cell.getText();
			if (cellText.equals(expectedCard)) {
				cell.click();
			}
		

		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")), "123456789");
		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")), "11/12");
		takeScreenshot("TaskOne", "smartbearsoftware");
		driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();
		}
		}
		
		
		
		@Test
		public void enterUser2() {
		WebElement productDD = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
		Select obj = new Select(productDD);
		obj.selectByVisibleText("MyMoney");

		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")), "125");
		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtUnitPrice']")), "123");
		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtDiscount']")), "");

		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']")), "Sam");
		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")), "Washington blvd");
		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")), "TysonsCorner");
		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")), "Va");
		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")), "222007");

		 String expectedCard = "Visa";
		List<WebElement> cells = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_fmwOrder_cardList']/tbody/tr/td"));
		for (WebElement cell : cells) {

			String cellText = cell.getText();
			if (cellText.equals(expectedCard)) {
				cell.click();
			}
		

		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")), "123456789123");
		sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")), "10/12");

		driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();
		}
		}
		
		
		
		
		@AfterClass
		public void tearDown() {
	    driver.close();
		}
	}

}
