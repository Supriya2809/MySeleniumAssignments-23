package marathonselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonTestCase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.amazon.in/");
		System.out.println("Browser has been launched");
		
		//to apply global wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
		
		//maximise the window
		driver.manage().window().maximize();
		System.out.println("Browser has been maximised");
		
		
		 //Type "Bags" in the Search box
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys("Bags");
		
		Thread.sleep(2000);
		 //Choose the 	 item in the result (bags for boys)
		driver.findElement(By.xpath("//div[@aria-label='bags for boys']")).click();
		//WebElement sleeper = driver.findElement(By.xpath("//label[text()='SLEEPER']"));
		//driver.executeScript("arguments[0].click();",sleeper);
		
		
		 //Print the total number of results (like 40000)
		     //1-48 of over 40,000 results for "bags for boys"
		WebElement totresult = driver.findElement(By.xpath("//span[text()='1-48 of over 50,000 results for']"));
		WebElement forboys = driver.findElement(By.xpath("//span[text()='\"bags for boys\"']"));
		System.out.println(totresult.getText()+forboys.getText());
		// Select the first 2 brands in the left menu
		     //(like American Tourister, Generic)
		driver.findElement(By.xpath("//li/span/a/span[text()='Safari']")).click();
		driver.findElement(By.xpath("//li/span/a/span[text()='American Tourister']")).click();
		 // Choose New Arrivals (Sort)
		driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
		driver.findElement(By.xpath("//li[@aria-labelledby='s-result-sort-select_4']")).click();
		//Print the first resulting bag info (name, discounted price
		WebElement desc = driver.findElement((By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal'][1]")));
		WebElement rate = driver.findElement(By.xpath("(//div[@class='a-row a-size-base a-color-base'])[1]"));
		System.out.println("description of product :"+desc.getText());
		System.out.println("Rate of product :"+rate.getText());
		 //Get the page title and close the browser(driver.close())
		 System.out.println(driver.getTitle());
		 driver.close();
	}

}
