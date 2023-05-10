package week6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;



public class NewCaller extends BaseClassServiceNow {
	@BeforeTest
	public void setFile()
	{
		filename="NewCallerTestdata";
	}
	
	
	@Test(dataProvider = "fetchData")
	public void runNewCaller(String fName,String lName,String title,String eMail,String bPhno,String mPhno) throws InterruptedException {
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
		driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys(fName);
		driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys(lName);
		String fname = shadow.findElementByXPath("//input[@id='sys_user.first_name']").getAttribute("value");
		driver.findElement(By.xpath("//input[@id='sys_user.title']")).sendKeys(title);
		driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys(eMail);
		driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys(bPhno);
		driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys(mPhno);
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
