package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions s=new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
		s.moveToElement(brands).click(searchbox).perform();
		searchbox.sendKeys("L'Oreal Paris",Keys.ENTER);
		driver.findElement(By.xpath("(//a[contains(text(),'real Paris')])[1]")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(2000);
		WebElement filterElement = driver.findElement(By.xpath("(//span[@class='filter-value'])[1]"));
		System.out.println("The filter applied is : "+filterElement.getText());
		driver.findElement(By.xpath("//img[contains(@alt,'Paris Colour Protect Shampoo')]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> whs =new ArrayList<String>(windowHandles);
		driver.switchTo().window(whs.get(1));
		driver.findElement(By.xpath("//span[text()='180ml']")).click();
		System.out.println("Price of Shampoo: "+driver.findElement(By.xpath("(//span[text()='₹209'])[1]")).getText());
		driver.findElement(By.xpath("(//button/span[text()='Add to Bag'])[1]")).click();
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		driver.switchTo().frame(0);
		System.out.println("Grand Total: "+driver.findElement(By.xpath("(//span[text()='Grand Total']/preceding::span)[14]")).getText());
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.quit();




	}

}
