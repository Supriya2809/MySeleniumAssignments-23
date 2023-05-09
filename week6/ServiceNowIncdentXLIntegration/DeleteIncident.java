package week6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class DeleteIncident extends BaseClassServiceNow{

	@BeforeTest
	public void setFile() {	
	 filename="DeleteIncident";
	
	}
	
	
@Test(dataProvider = "fetchData")
	
	public void runDeleteIncident(String incidentnumber) throws InterruptedException {
		
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(30);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Incident");
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//mark[text()='Incident']").click();
		WebElement aframe = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(aframe);
		
		driver.findElement(By.xpath("//div[@class='input-group']/input[@placeholder='Search']")).sendKeys(incidentnumber+Keys.ENTER);
		Thread.sleep(2000);
		shadow.findElementByXPath("//a[@class='linked formlink']").click();
		Thread.sleep(1000);
		shadow.findElementByXPath("//button[@id='sysverb_delete']").click();
		shadow.findElementByXPath("//button[@id='ok_button']").click();
		String text = shadow.findElementByXPath("//div[text()='No records to display']").getText();
		System.out.println("The status of incident: "+text);
	}
}

