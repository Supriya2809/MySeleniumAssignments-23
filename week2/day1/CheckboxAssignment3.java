package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxAssignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//https://www.leafground.com/button.xhtml
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml");
		//to apply global wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	

		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[text()='Basic']/preceding-sibling::div[1]")).click();
		driver.findElement(By.xpath("//span[text()='Ajax']/preceding-sibling::div[1]")).click();
		driver.findElement(By.xpath("//label[text()='Java']/preceding-sibling::div[1]")).click();
		driver.findElement(By.xpath("//div/h5[text()='Tri State Checkbox']/following-sibling::div/div/div/div[2]")).click();
		driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']")).click();
		boolean enabled = driver.findElement(By.xpath("//div/h5[text()='Verify if check box is disabled']/following-sibling::div/div/div/div[2]")).isEnabled();
		if(enabled)
			System.out.println("Checkbox is enabled");
		else
			System.out.println("Checkbox is disabled");
		
		
		driver.findElement(By.xpath("//ul[@data-label='Cities']")).click();
		driver.findElement(By.xpath("//label[text()='London']/preceding-sibling::div")).click();
		driver.findElement(By.xpath("//label[text()='Rome']/preceding-sibling::div")).click();
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-close']")).click();
	}

}
