package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownAssignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		//https://www.leafground.com/button.xhtml
		
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://www.leafground.com/select.xhtml");
				//to apply global wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	

				driver.manage().window().maximize();
				
				WebElement findElement = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
				Select dd=new Select(findElement);
				dd.selectByVisibleText("Selenium");
				
				driver.findElement(By.xpath(("//label[text()='Select Country']"))).click();
				driver.findElement(By.xpath("//li[@data-label='Germany']")).click();
				//findElement2.click();
				//Select dd2=new Select(findElement2);
				//dd2.selectByIndex(2);
				
			driver.findElement(By.xpath("//label[text()='Select City']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[@data-label='Berlin']")).click();
				//Select dd3=new Select(findElement3);
				//dd3.selectByValue("Berlin");
				
				driver.findElement(By.xpath("//button[contains(@class,'dropdown')]")).click();
				driver.findElement(By.xpath("//li[text()='PostMan']")).click();
				
				driver.findElement(By.xpath("//label[text()='Select Language']")).click();
				driver.findElement(By.xpath("//li[text()='English']")).click();
				
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//label[text()='Select Values']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//li[text()='One']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//label[text()='One']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//li[text()='Three']")).click();
				
	}

}
