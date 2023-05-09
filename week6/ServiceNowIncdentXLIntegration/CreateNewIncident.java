package week6;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;


import io.github.sukgu.Shadow;

public class CreateNewIncident extends BaseClassServiceNow{

	
	@BeforeTest
	public void setFile() {	
	 filename="CreateNewIncdent";
	
	}
	@Test(dataProvider = "fetchData")
	public void runCreateNewIncident(String desc) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(30);
		WebElement allSelection = shadow.findElementByXPath("//div[text()='All']");
		wait.until(ExpectedConditions.elementToBeClickable(allSelection));
		WebElement filter = shadow.findElementByXPath("//input[@id='filter']");
		wait.until(ExpectedConditions.visibilityOf(filter));
		filter.sendKeys("incident");
		shadow.setImplicitWait(5);
		shadow.findElementByXPath("//span[text()='Create New']").click();
		Thread.sleep(2000);
		WebElement aframe = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(aframe);
		String incidentnumber = driver.findElement(By.xpath("//input[@id='sys_original.incident.number']")).getAttribute("value");
		System.out.println("Incident Created: "+incidentnumber);
		driver.findElement(By.id("incident.short_description")).sendKeys(desc);
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> whs=new ArrayList<String>(windowHandles);
		driver.switchTo().window(whs.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='input-group']/input[@placeholder='Search']")).sendKeys("system"+Keys.ENTER);
		Thread.sleep(4000);	
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(whs.get(0));
		driver.switchTo().frame(aframe);
		WebElement submit = shadow.findElementByXPath("//button[@id='sysverb_insert']");
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
			System.out.println("Incident not created");
		}

	}
}