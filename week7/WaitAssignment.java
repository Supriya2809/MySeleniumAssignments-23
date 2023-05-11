package week7.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WaitAssignment {

	
	public ChromeDriver driver;
	@BeforeMethod
	public void launchURL() {
//		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--disable-notifications");
		driver=new ChromeDriver();
		driver.get("https://www.leafground.com/waits.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		
	}
	
	@Test
	
	public void waitAssignment()
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		//visibility
		driver.findElement(By.xpath("(//span[text()='Click'])[1]")).click();
		//WebElement waitelement1 = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]"));
		//wait.until(ExpectedConditions.elementToBeClickable(waitelement1));
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='I am here']")));
		
		System.out.println("Text displayed is : "+driver.findElement(By.xpath("//span[text()='I am here']")).getText());
		
		//invisibility
		driver.findElement(By.xpath("(//span[text()='Click'])[2]")).click();
		
		//clickability
		driver.findElement(By.xpath("//span[text()='Click First Button']")).click();
		WebElement element2 = driver.findElement(By.xpath("//span[text()='Click Second']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Click Second']")));
		
		
		//text change
		System.out.println("Text before clicking: "+driver.findElement(By.xpath("//span[text()='I am going to change!']")).getText());
		driver.findElement(By.xpath("(//span[text()='Click'])[3]")).click();
		//WebElement element3 = driver.findElement(By.xpath("//span[text()='Did you notice?']"));
		//wait.until(ExpectedConditions.visibilityOf(element3));
		System.out.println(driver.findElement(By.xpath("//span[text()='Did you notice?']")).getText());
		
	}
	
}
