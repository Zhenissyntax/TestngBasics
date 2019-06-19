package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class TaskHomeWork  extends CommonMethods{
	@BeforeMethod
	public void setUp() {
		setUpDriver("chrome","https://www.saucedemo.com/");
		
	}
	@Test
	public void log() {
		driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("input.btn_action")).click();
		String text=driver.findElement(By.xpath("//div[text()='Products']")).getText();
		if(text.equals("Products")) {
			System.out.println("Text Displayed");
		}else {
			System.out.println("No Text");
		}
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
	@AfterMethod
public void Close() {
        
        driver.findElement(By.xpath("//button[@style=\"position: absolute; left: 0px; top: 0px; width: 100%; height: 100%; margin: 0px; padding: 0px; border: none; opacity: 0; font-size: 8px; cursor: pointer;\"]")).click();
        WebDriverWait wait=new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a#logout_sidebar_link")));
        driver.findElement(By.cssSelector("a#logout_sidebar_link")).click();
        
      
    }
}
