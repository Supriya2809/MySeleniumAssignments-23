package week6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class UpdateIncident extends BaseClassServiceNow {

	@BeforeTest
	public void setFile() {	
	 filename="UpdateIncident";
	
	}
	
	@Test(dataProvider = "fetchData")
	public void runUpdateIncident(String incidentnumber) throws InterruptedException {		
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(40);
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
		WebElement urgency = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		Select dd=new Select(urgency);
		dd.selectByValue("1");
		WebElement state = driver.findElement(By.xpath("//select[@id='incident.state']"));
		Select dd2=new Select(state);
		dd2.selectByValue("2");
		driver.findElement(By.id("sysverb_update")).click();

		shadow.findElementByXPath("//a[@class='linked formlink']").click();
		String confirmincidentnumber = driver.findElement(By.xpath("//input[@id='sys_original.incident.number']")).getAttribute("value");
		System.out.println("Incident number: "+confirmincidentnumber);
		WebElement retrieveurgency = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		Select dd3=new Select(retrieveurgency);
		WebElement urgencyselected = dd3.getFirstSelectedOption();
		System.out.println("Urgency of the incdent: "+urgencyselected.getText());
		WebElement retrievestate = driver.findElement(By.id("incident.state"));
		Select dd4=new Select(retrievestate);
		WebElement stateselected = dd4.getFirstSelectedOption();
		
		System.out.println("The state of incident is: "+stateselected.getText());
		
		
		
		
	}
}
