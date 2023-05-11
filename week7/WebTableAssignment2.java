package week7.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTableAssignment2 {
	public ChromeDriver driver;
	@BeforeMethod
	public void launchURL() {
//		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--disable-notifications");
		driver=new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
	}
	
	@Test
	public void getTableSize() {
		WebElement table = driver.findElement(By.xpath("//table[@class='attributes-list']"));
		int colsize = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr/th")).size();
		int rowsize = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr")).size();
		System.out.println("Row Size: "+rowsize);
		System.out.println("Column size: "+colsize);
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
