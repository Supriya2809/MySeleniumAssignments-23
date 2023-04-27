package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("DemoSalesManager");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> whs=new ArrayList<String>(windowHandles1);
		driver.switchTo().window(whs.get(1));
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[contains(@href,'set_value')])[1]")).click();
		Thread.sleep(2000);
		driver.switchTo().window(whs.get(0));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Thread.sleep(2000);
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> whs2=new ArrayList<String>(windowHandles2);
		driver.switchTo().window(whs2.get(1));
		System.out.println(driver.getTitle());
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[contains(@href,'set_value')])[2]")).click();
		Thread.sleep(2000);
		driver.switchTo().window(whs2.get(0));
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		System.out.println("Title of page after merging contact "+driver.getTitle());
		
		

		
	}

}
