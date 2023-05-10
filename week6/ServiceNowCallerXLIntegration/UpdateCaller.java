package week6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class UpdateCaller extends BaseClassServiceNow{
	@BeforeTest
	public void setFile()
	{
		filename="UpdateCallerTestdata";
	}
	
	
	@Test(dataProvider = "fetchData")
	public void runUpdateCaller(String fName,String lName,String bPhno) throws InterruptedException {
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(30);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("caller");
		shadow.findElementByXPath("//mark[text()='Caller']").click();
		shadow.setImplicitWait(5);
		WebElement aframe = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(aframe);
		driver.findElement(By.xpath("//span[text()='Show / hide filter']/..")).click();
		driver.findElement(By.xpath("//span[text()='-- choose field --']")).click();
		driver.findElement(By.xpath("//input[@class='select2-input']")).sendKeys("name");
		driver.findElement(By.xpath("//div[text()='First ']")).click();
		WebElement fnameselect = driver.findElement(By.xpath("//select[@aria-label='Operator For Condition 1: First name starts with']"));
		Select dd1=new Select(fnameselect);
		dd1.selectByVisibleText("is");
		driver.findElement(By.xpath("//input[@aria-label='First name']")).sendKeys(fName);
		driver.findElement(By.xpath("//button[text()='AND' and  @aria-label='Add AND Condition To Condition 1: First name is']")).click();
		
		driver.findElement(By.xpath("//span[text()='-- choose field --']")).click();
		driver.findElement(By.xpath("//div[@id='select2-drop']//input[@class='select2-input']")).sendKeys("name");
		driver.findElement(By.xpath("//div[text()='Last ']")).click();
		WebElement lnameselect = driver.findElement(By.xpath("//select[@aria-label='Operator For Condition 2: Last name starts with']"));
		Select dd2=new Select(lnameselect);
		dd2.selectByVisibleText("is");
		driver.findElement(By.xpath("//input[@aria-label='Last name']")).sendKeys(lName);
		driver.findElement(By.xpath("//button[@aria-label='Run filter']")).click();
		
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		WebElement webelementbph = driver.findElement(By.id("sys_user.phone"));
		webelementbph.clear();
		webelementbph.sendKeys(bPhno);
		driver.findElement(By.xpath("(//button[@value='sysverb_update'])[1]")).click();
		
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		String businessph = driver.findElement(By.id("sys_user.phone")).getAttribute("value");
		if (businessph.contains(bPhno))
		{
			System.out.println("Business Phone Number updated for "+fName+lName);
		}
		else
		{
			System.out.println("Business Phone number not updated for "+fName+lName);
		}
		

	}
}
