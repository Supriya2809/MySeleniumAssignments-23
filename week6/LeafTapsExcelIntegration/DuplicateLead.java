package week6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class DuplicateLead extends BaseLeafTaps{
	
	@BeforeTest
	public void setFile() {	
		 filename="DuplicateLeadTestdata";		
		}

@Test(dataProvider = "fetchData")
public void runDuplicateLead(String text) throws InterruptedException {
	driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		
		
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(text);
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(1000);
		String id = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[contains(@href,'viewLead')])[1]")).getText();
		String fn = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[contains(@href,'viewLead')])[1]")).getText();
		String ln = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-lastName']/a[contains(@href,'viewLead')])[1]")).getText();
		String name=fn+" "+ln;
		System.out.println("id: "+id+"\nname: "+name);
		
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[contains(@href,'viewLead')])[1]")).click();
		
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		
		WebElement title = driver.findElement(By.xpath("//div[text()='Duplicate Lead']"));
		System.out.println(title.getText());
		
		
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		
		String idd = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		String firstname = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		String lastname = driver.findElement(By.xpath("//span[@id='viewLead_lastName_sp']")).getText();
		String dupname=firstname+" "+lastname;
		System.out.println("id: "+idd+"\nname: "+dupname);
		
}

}
