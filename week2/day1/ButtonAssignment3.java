package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonAssignment3 {

	public static void main(String[] args) {
		//https://www.leafground.com/button.xhtml
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		//to apply global wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	

		driver.manage().window().maximize();
		//1. Click and Confirm title
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		driver.navigate().back();
		//2. Confirm if the button is disabled
		boolean enabled = driver.findElement(By.xpath("//span[text()='Disabled']/parent::button")).isEnabled();
		if(enabled)
		System.out.println("the button is enabled");
		else
			System.out.println("the button is disabled");
		//3. Find the position of the Submit button
		Point location = driver.findElement(By.xpath("//span[text()='Disabled']/ancestor::button")).getLocation();
		System.out.println("Location of button: "+location);
		driver.close();

	}

}
