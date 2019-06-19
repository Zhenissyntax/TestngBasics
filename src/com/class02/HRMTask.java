package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class HRMTask extends CommonMethods {
@BeforeMethod
public static void title() {
	CommonMethods.setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com");
	WebElement validate=driver.findElement(By.xpath("//img[@src='/webres_5cc83b08d42f86.60948938/themes/default/images/login/logo.png']"));
	if(validate.isDisplayed()) {
		System.out.println("You are on right page");
	}else {
		System.out.println("You are in wrong page");
	}
}
	@Test
	public static void Log() throws InterruptedException {
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("admin123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		Thread.sleep(3000);
		WebElement span=driver.findElement(By.cssSelector("span#spanMessage"));
		Thread.sleep(3000);
		if(!span.isDisplayed()) {
			System.out.println("Logged in successfully");
		}else {
			System.out.println("Cannot Log in");
		}
	}

	@AfterMethod
	
	public static void close() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
	

}
