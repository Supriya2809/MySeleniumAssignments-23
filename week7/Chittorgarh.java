package week7.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Chittorgarh {

	public ChromeDriver driver;
	@BeforeMethod
	public void launchURL() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver(option);
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
	}
	
	@Test
	public void runGetSecurityNames() {
		
		driver.findElement(By.xpath("//a[text()='STOCK MARKET ']")).click();
		driver.findElement(By.xpath("(//a[text()='NSE Bulk Deals'])[1]")).click();
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped table-hover w-auto']"));
		int rowsize = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped table-hover w-auto']/tbody/tr")).size();
		int colsize = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped table-hover w-auto']//tr/th")).size();
		System.out.println("No of Security Names: "+rowsize);
		System.out.println("Col Size: "+colsize);
		List<WebElement> secNamesList = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped table-hover w-auto']/tbody/tr/td/a"));
		System.out.println(driver.findElement(By.xpath("//table[@class='table table-bordered table-striped table-hover w-auto']/tbody/tr[6]/td/a")).getAttribute("title"));
		for(int i=1;i<=rowsize;i++) {
			String allrowsfirstcolvalue = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped table-hover w-auto']/tbody/tr["+i+"]/td/a")).getAttribute("title");
		    System.out.println(allrowsfirstcolvalue);
		}	
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
