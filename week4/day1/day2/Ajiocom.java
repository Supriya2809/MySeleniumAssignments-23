package week4.day2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ajiocom {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.ajio.com/");
		driver.findElement(By.xpath("//input[@placeholder='Search AJIO']")).sendKeys("bags"+Keys.ENTER);
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@class='length']")).getText());
		List<WebElement> brands = driver.findElements(By.xpath("//div[@class='brand']"));
		List<String> brandlist=new ArrayList<String>();
		for (int i = 0; i < brands.size(); i++) {
			String text = brands.get(i).getText();
			brandlist.add(text);
			
		}
		System.out.println("List of brands: "+brandlist);
		
		List<WebElement> name = driver.findElements(By.xpath("//div[@class='nameCls']"));
		List<String> namelist=new ArrayList<String>();
		for (int i = 0; i <name.size(); i++) {
			String text = name.get(i).getText();
			namelist.add(text);
		}
		System.out.println("Name of the bags: "+namelist);
	}

}
