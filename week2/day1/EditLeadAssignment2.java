package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class EditLeadAssignment2 {

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
				
		//* 8 Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("ramesh");
		//* 9 Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		//* 10 Click on first resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[contains(@href,'viewLead')])[1]")).click();
		//* 11 Verify title of the page
		String title = driver.findElement(By.xpath("//div[text()='View Lead']")).getText();
		System.out.println("Title: "+title);
		//* 12 Click Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		//* 13 Change the company name
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("WFM");
		//* 14 Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		//* 15 Confirm the changed name appears
		String companyname = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		System.out.println("new company name: "+companyname);
		//* 16 Close the browser (Do not log out)
		driver.close();
	}

}
