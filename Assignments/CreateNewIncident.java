package week5.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class CreateNewIncident extends BaseClassServiceNow{

	public String incidentno;	
	
	@Test
	public String runCreateNewIncident(String number) throws InterruptedException {
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(30);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Incident");
		shadow.setImplicitWait(5);
		shadow.findElementByXPath("//span[text()='Create New']").click();
		Thread.sleep(2000);

		//createnewincident page
		Shadow s2=new Shadow(driver);
		WebElement aframe = s2.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(aframe);
		String incidentnumber = driver.findElement(By.xpath("//input[@id='sys_original.incident.number']")).getAttribute("value");
		System.out.println("Incident Created: "+incidentnumber);
		driver.findElement(By.id("incident.short_description")).sendKeys("New feature not working");
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> whs=new ArrayList<String>(windowHandles);
		driver.switchTo().window(whs.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='input-group']/input[@placeholder='Search']")).sendKeys("system administrator"+Keys.ENTER);
		Thread.sleep(2000);	
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(whs.get(0));
		

		WebElement a2frame = s2.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(a2frame);
		WebElement submit = s2.findElementByXPath("//button[@id='sysverb_insert']");
		submit.click();
		Thread.sleep(2000);


		driver.findElement(By.xpath("//div[@class='input-group']/input[@placeholder='Search']")).sendKeys(incidentnumber+Keys.ENTER);
		Thread.sleep(3000);
		String confirmincidentno = driver.findElement(By.xpath("(//a[contains(@aria-label,'Open record')])[1]")).getText();

		System.out.println("Incident listed: "+confirmincidentno);
		if(incidentnumber.equalsIgnoreCase(confirmincidentno))
		{
			System.out.println("Incident successfully created");
		}
		else
		{
			System.out.println("Incindet not created");
		}
		this.incidentno=incidentnumber;
		return incidentnumber;

	}
	
	@BeforeTest
		public String getIncidentno() {
			System.out.println("Incident no: "+incidentno);
			return incidentno;
		}
	 @Test
	   public void normalMethod()
	   {
	      System.out.println("Normal Method");
	      runCreateNewIncident();
	   }

		

}
