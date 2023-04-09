package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContactAssignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		//* //Pseudo Code
		//*
		//* 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		//* 2. Enter UserName and Password Using Id Locator
		//* 3. Click on Login Button using Class Locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		//* 4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		//* 5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		//* 6. Click on Create Contact
		driver.findElement(By.linkText("Create Contact")).click();
		
		//* 7. Enter FirstName Field Using id Locator
		driver.findElement(By.id("firstNameField")).sendKeys("Tester");
		//* 8. Enter LastName Field Using id Locator
		driver.findElement(By.id("lastNameField")).sendKeys("leaf");
		Thread.sleep(2000);
		//* 9. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Tester");
		//* 10. Enter LastName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("leaf");
		Thread.sleep(2000);
		//* 11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Testing");
		//* 12. Enter Description Field Using any Locator of your choice
		driver.findElement(By.id("createContactForm_description")).sendKeys("sample description");
		Thread.sleep(2000);
		//* 13. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("dummy@mail.com");
		Thread.sleep(2000);
		//* 14. Select State/Province as NewYork Using Visible Text
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dd=new Select(state);
		dd.selectByVisibleText("New York");
		Thread.sleep(2000);
		
		//* 15. Click on Create Contact
		driver.findElement(By.xpath("//input[@value='Create Contact']")).click();
		Thread.sleep(2000);
		//* 16. Click on edit button
		driver.findElement(By.linkText("Edit")).click();
		//* 17. Clear the Description Field using .clear
		driver.findElement(By.id("updateContactForm_description")).clear();
		Thread.sleep(2000);
		//* 18. Fill ImportantNote Field with Any text
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("This is important note section");
		Thread.sleep(2000);
		//* 19. Click on update button using Xpath locator
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		//* 20. Get the Title of Resulting Page.
		System.out.println("Page Title is : "+driver.getTitle());
	}

}
