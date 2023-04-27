package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Salesforce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		 
			
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			ChromeDriver driver=new ChromeDriver(options);
			driver.get("https://login.salesforce.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
			driver.findElement(By.id("password")).sendKeys("Leaf@1234");
			driver.findElement(By.id("Login")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[text()='Learn More']")).click();
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> whs=new ArrayList<String>(windowHandles);
			driver.switchTo().window(whs.get(1));
			driver.findElement(By.xpath("//button[@onclick='goAhead()']")).click();
			System.out.println("Title of new window:"+driver.getTitle());

	}

}
