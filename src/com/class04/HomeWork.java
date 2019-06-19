package com.class04;


	
	//Identify Priority of Test Cases
	//
	//http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx
	//
	//TC 1: WebOrder Verify Successful Login ( )
	//Step 1: Open browser and navigate to WebOrder
	//Step 2: Enter valid username, enter valid password and click on the  login button
	//Step 3: Verify user successfully logged in
	//
	//TC 2: WebOrder Creating and verifying Users( )
	//Step 1: Create Two users and fill out all the required fields
	// Step 2: Verify that user one name appears within the table 
	// Step 3: Edit user one  and update user one’s State, assert the new updated State is displayed and save the changes.
	// Step 4: Verify that user two name appears within the table 
	// Step 5: Edit user two and update user two’s City and assert the new updated City is displayed and save the changes.

	//TC 3: WebOrder verifying Users( )
//	        Step 1 : Assert Both User one and User Two are displayed
	//
	//Note: Create BeforeClass and AfterClass annotations to open browser and logout from the application. 
	//The creation of users two should depend on the creation of users one.
	//The validation both users should depend on the creation of both users. 
	//Create xml file and share a screenshot of the test.

	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	
	import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import utils.CommonMethods;


	public class HomeWork extends CommonMethods {

		@BeforeClass(alwaysRun = true)
		public void set() {
			setUpDriver("chrome",
					"http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");

			sendText(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_username\"]")), "Tester");
			sendText(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_password\"]")), "test");
			jsClick(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_login_button\"]")));
			String text = driver.findElement(By.xpath("//div[@class='login_info']")).getText().trim();
			System.out.println(text);
			Assert.assertEquals(text, "Welcome, Tester! | Logout");
		}


		@Test
		public void enterUser1() {
			driver.findElement(By.xpath("//a[text()='Order']")).click();
			WebElement productDD = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
			Select obj = new Select(productDD);
			obj.selectByVisibleText("FamilyAlbum");

			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")), "125");
			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtUnitPrice']")), "123");
			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtDiscount']")), "10");

			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']")), "James");
			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")), "Arlongton blvd");
			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")), "Arlington");
			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")), "VA");
			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")), "222007");

			String expectedCard = "MasterCard";
			List<WebElement> cells = driver
					.findElements(By.xpath("//table[@id='ctl00_MainContent_fmwOrder_cardList']/tbody/tr/td"));
			for (WebElement cell : cells) {

				String cellText = cell.getText();
				if (cellText.equals(expectedCard)) {
					cell.click();
				}
			}

			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")), "123456789");
			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")), "11/12");

			driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();

			// changing state

			driver.findElement(By.xpath("//a[text()='View all orders']")).click();
			driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td[13]")).click();

			driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")).clear();
			WebElement newAddress = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
			newAddress.sendKeys("CA");
			driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_UpdateButton']")).click();
			String expectedAddress = "CA";
			List<WebElement> cells3 = driver
					.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td"));
			for (WebElement cell : cells3) {
				String cellText = cell.getText();
				if (cellText.equalsIgnoreCase(expectedAddress)) {
					System.out.println("Yes, state has been updated to CA");
				}
			}
		}

		@Test(dependsOnMethods = { "enterUser1" })
		public void enterUser2() {
			driver.findElement(By.xpath("//a[text()='Order']")).click();
			WebElement productDD = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
			Select obj = new Select(productDD);
			obj.selectByVisibleText("FamilyAlbum");

			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")), "125");
			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtUnitPrice']")), "123");
			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtDiscount']")), "10");

			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']")), "Mike");
			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")), "Chrome street");
			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")), "Arlington");
			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")), "VA");
			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")), "22204");

			String expectedCard = "Visa";
			List<WebElement> cells = driver
					.findElements(By.xpath("//table[@id='ctl00_MainContent_fmwOrder_cardList']/tbody/tr/td"));
			for (WebElement cell : cells) {

				String cellText = cell.getText();
				if (cellText.equals(expectedCard)) {
					cell.click();
				}
			}

			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")), "100000000");
			sendText(driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")), "10/12");

			driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();

			// changing city

			driver.findElement(By.xpath("//a[text()='View all orders']")).click();
			driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td[13]")).click();

			driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")).clear();
			WebElement newAddress = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
			newAddress.sendKeys("Ashburn");
			driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_UpdateButton']")).click();
			String expectedAddress = "Ashburn";
			List<WebElement> cells3 = driver
					.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td"));
			for (WebElement cell : cells3) {
				String cellText = cell.getText();
				if (cellText.equalsIgnoreCase(expectedAddress)) {
					System.out.println("Yes, city has been updated to Ashburn");
				}
			}
		}

		@Test(dependsOnMethods = { "enterUser2" })

		public void valid() {
			driver.findElement(By.xpath("//a[text()='View all orders']")).click();
			String expectedUser = "Mike";
			List<WebElement> cells2 = driver
					.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td"));
			for (WebElement cell : cells2) {
				String cellText = cell.getText();
				if (cellText.equalsIgnoreCase(expectedUser)) {
					System.out.println("Yes, Mike person is displayed");
				}
			}
			driver.findElement(By.xpath("//a[text()='View all orders']")).click();
			String expectedUser2 = "James";
			List<WebElement> cells3 = driver
					.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td"));
			for (WebElement cell : cells3) {
				String cellText = cell.getText();
				if (cellText.equalsIgnoreCase(expectedUser2)) {
					System.out.println("Yes, James person is displayed");
				}
			}
		}


		@AfterClass
		public void tearDown() {
			driver.findElement(By.xpath("//*[@id=\"ctl00_logout\"]")).click();
			driver.close();
		}

	}

