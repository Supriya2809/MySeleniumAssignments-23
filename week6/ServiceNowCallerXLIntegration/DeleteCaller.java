package week6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class DeleteCaller extends BaseClassServiceNow {
	@BeforeTest
	public void setFile()
	{
		filename="DeleteCallerTestdata";
	}
	
	
	@Test(dataProvider = "fetchData")
	public void runDeleteCaller(String fName,String lName) throws InterruptedException {
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
		String firstname = driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).getAttribute("value");
		String lastname = driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).getAttribute("value");
		
		driver.findElement(By.xpath("(//button[@id='sysverb_delete'])[1]")).click();
		driver.findElement(By.id("ok_button")).click();
		
		String result = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		
		if(result.contains("No records"))
		{
			System.out.println("Record "+fName+" "+lName+" is deleted ");
		}
		else
		{
			System.out.println("Record "+fName+" "+lName+" is not deleted ");
		}
		
		
		

	}
}
