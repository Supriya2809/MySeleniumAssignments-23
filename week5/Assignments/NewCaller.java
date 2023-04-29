package week5.Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class NewCaller extends BaseClassServiceNow{

	@Test
	public void runNewCaller() throws InterruptedException {
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(30);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("caller");
		shadow.findElementByXPath("//mark[text()='Caller']").click();
		shadow.setImplicitWait(5);
		WebElement aframe = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(aframe);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys("Sarah");
		driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys("Miller");
		String fname = shadow.findElementByXPath("//input[@id='sys_user.first_name']").getAttribute("value");
		driver.findElement(By.xpath("//input[@id='sys_user.title']")).sendKeys("System Adminstrator");
		driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys("dummy@mail.com");
		driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys("999999");
		driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys("999999");
		driver.findElement(By.id("sysverb_insert")).click();
		driver.findElement(By.xpath("//div[@class='input-group']/input[@placeholder='Search']")).sendKeys(fname+Keys.ENTER);
		Thread.sleep(2000);
		List<WebElement> callerlist = driver.findElements(By.xpath("//a[@class='linked formlink']"));
		boolean found=false;
		for (WebElement webElement : callerlist) {
			if(webElement.getText().contains(fname)) {
				found=true;
				break;
			}
		}
		if(found) {
			System.out.println("Caller created successfully for: "+fname);
		}
		else {
			System.out.println("Caller not created");
		}

	}
}
