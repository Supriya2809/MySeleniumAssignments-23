package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLeadAssignment2 {

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
		
		//8 Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		//9 Enter Email
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("@gmail.com");
		//10 Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//11 Capture name of First Resulting lead
		Thread.sleep(1000);
		String id = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[contains(@href,'viewLead')])[1]")).getText();
		String fn = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[contains(@href,'viewLead')])[1]")).getText();
		String ln = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-lastName']/a[contains(@href,'viewLead')])[1]")).getText();
		String name=fn+" "+ln;
		System.out.println("id: "+id+"\nname: "+name);
		
		//12 Click First Resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[contains(@href,'viewLead')])[1]")).click();
		//13 Click Duplicate Lead
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		//14 Verify the title as 'Duplicate Lead'
		WebElement title = driver.findElement(By.xpath("//div[text()='Duplicate Lead']"));
		System.out.println(title.getText());
		
		//15 Click Create Lead
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		//16 Confirm the duplicated lead name is same as captured name
		String idd = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		String firstname = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		String lastname = driver.findElement(By.xpath("//span[@id='viewLead_lastName_sp']")).getText();
		String dupname=firstname+" "+lastname;
		System.out.println("id: "+idd+"\nname: "+dupname);
		//17 Close the browser (Do not log out)
		driver.close();
	}

}
