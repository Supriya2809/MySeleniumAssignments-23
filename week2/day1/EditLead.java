package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		System.out.println("Browser has been launched");
		driver.manage().window().maximize();
		System.out.println("Browser has been maximised");
		//find the element username by using the locator id
		WebElement username = driver.findElement(By.id("username"));
		//send the username input
		username.sendKeys("DemoSalesManager");
		//find the element password by using the locator id
		WebElement password = driver.findElement(By.id("password"));
		//send the password in put
		password.sendKeys("crmsfa");
		//to click on the login button by using the locator class and perform click action
		driver.findElement(By.className("decorativeSubmit")).click();
		System.out.println("We have logged in and our current page title is "+driver.getTitle());
		//to find the element CRM/SFA hyperlink using locator linktext and do clieck action
		driver.findElement(By.linkText("CRM/SFA")).click();
		System.out.println("We have clicked on CRM/SFA hyperlink and the current page title is "+driver.getTitle());
		//to find the element Leads hyperlink using locator linktext and do click action
		driver.findElement(By.linkText("Leads")).click();
		//to find the element Create Lead using linktext and do click action
		 driver.findElement(By.linkText("Create Lead")).click();
		 //companyname
		 driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		 
		 
		 //firstname,lastname,firstname(local),description,email,department
		 driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Supriya");
		 driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Mohan");
		 driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("supri");
		 driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Software Tersting");        
		 driver.findElement(By.id("createLeadForm_description")).sendKeys("This is my first assignment");        
		 driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("dummy@email.com");       
		 Thread.sleep(3000);
		 //to find the element dropdown for state
		 WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"))    ;
		 Select dd=new Select(state);
		 dd.selectByVisibleText("New York");
		 //to find the element for create lead button and then do click action
		 driver.findElement(By.className("smallSubmit")).click();
		 
		 Thread.sleep(3000);
		 
		 driver.findElement(By.linkText("Edit")).click();
		 Thread.sleep(2000);
		 //to find the element description and clear it
		 driver.findElement(By.id("updateLeadForm_description")).clear();
		 Thread.sleep(2000);
		 //to find the element for Important note and add some text
		 driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("This is important notes field updated as part of assignment 2");
		 Thread.sleep(2000);
		 //to find the update element and do click action
		 driver.findElement(By.className("smallSubmit")).click();
		 
		//to get the recent page title
		 System.out.println(driver.getTitle());


		
	}

}
