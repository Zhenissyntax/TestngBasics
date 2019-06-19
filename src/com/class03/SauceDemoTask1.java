package com.class03;

import org.openqa.selenium.By;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class SauceDemoTask1 extends CommonMethods {
   @BeforeGroups({"Smoke","Regression1","Regression2"})
   public void setUP() {
	   setUpDriver("chrome","https://www.saucedemo.com/");
   }
   @Test (groups="Smoke")
   public void userOne() {
	   driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
	   driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
	   driver.findElement(By.cssSelector("input.btn_action")).click();
	  
   }
   @Test (groups="Regression1")
   public void userTwo() {
	   driver.findElement(By.cssSelector("input#user-name")).sendKeys("problem_user");
	   driver.findElement(By.cssSelector("input.form_input")).sendKeys("secret_sauce");
	   driver.findElement(By.cssSelector("input.btn_action")).click();
   }
   @Test  (groups="Regression2")
   public void userThree() {
	   driver.findElement(By.cssSelector("input#user-name")).sendKeys("performance_glitch_user");
	   driver.findElement(By.cssSelector("input.form_input")).sendKeys("secret_sauce");
	   driver.findElement(By.cssSelector("input.btn_action")).click();
   }
   @AfterGroups (groups="Smoke")
   public void tearDown() {
	   driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
	   driver.findElement(By.xpath("//a[text()='Logout']")).click();
	   
	   driver.close();
   }
}
