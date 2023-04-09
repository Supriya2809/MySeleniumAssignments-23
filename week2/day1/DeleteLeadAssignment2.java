package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLeadAssignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//1 Launch the browser
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		//to apply global wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
				
		driver.manage().window().maximize();
		//2 Enter the username
		//3 Enter the password
		//4 Click Login
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		//5 Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//6 Click Leads link
		 driver.findElement(By.linkText("Leads")).click();
		//7 Click Find leads
		 driver.findElement(By.linkText("Find Leads")).click();
		//8 Click on Phone
		 driver.findElement(By.xpath("//span[text()='Phone']")).click();
		//9 Enter phone number
		// driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("65");
		 driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		//10 Click find leads button
		 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		 Thread.sleep(2000);
		//11 Capture lead ID of First Resulting lead
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
		 
		 
		//12 Click First Resulting lead
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[contains(@href,'viewLead')])[1]")).click();
		 WebElement leadid = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']"));
		 String leadidnumber=leadid.getText();
		 System.out.println("Lead id which is deleted: "+leadidnumber);
		//13 Click Delete
		 driver.findElement(By.xpath("//a[text()='Delete']")).click();
		//14 Click Find leads
		 driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		 Thread.sleep(1000);
		//15 Enter captured lead ID
		 driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadidnumber);
		//16 Click find leads button
		 Thread.sleep(1000);
		//17 Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		 
		 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		 Thread.sleep(1000);
		 WebElement message = driver.findElement(By.xpath("//div[@class='x-paging-info']"));
		 System.out.println("Result Message: "+message.getText());
		//18 Close the browser (Do not log out)
		 



















	}

}
