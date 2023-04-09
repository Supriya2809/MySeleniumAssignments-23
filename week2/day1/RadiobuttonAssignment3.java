package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadiobuttonAssignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//https://www.leafground.com/radio.xhtml
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		//to apply global wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//label[text()='Firefox']/preceding-sibling::div/div[2]")).click();
		//driver.findElement(By.xpath("//label[text()='Safari']/preceding-sibling::div/div[2]")).click();
		driver.findElement(By.xpath("//label[text()='Bengaluru']/preceding-sibling::div/div[2]")).click();
		//chrome
		 WebElement chrome = driver.findElement(By.xpath("(//label[text()='Chrome']/preceding-sibling::div/div[2])[2]"));
		 String chromeisActive = chrome.getAttribute("class");
		
		WebElement ff = driver.findElement(By.xpath("(//label[text()='Firefox']/preceding-sibling::div/div[2])[2]"));
		String ffisActive = ff.getAttribute("class");
		
		
		//safari
		 WebElement safari = driver.findElement(By.xpath("(//label[text()='Safari']/preceding-sibling::div/div[2])[2]"));
		 String safariisActive=safari.getAttribute("class");
		
		 
		 //edge
		WebElement edge = driver.findElement(By.xpath("(//label[text()='Edge']/preceding-sibling::div/div[2])[2]"));
		 String edgeisActive = edge.getAttribute("class");
		
		
		
		if(chromeisActive.contains("active"))
			System.out.println("Chrome is checked");
		else if (ffisActive.contains("active"))
			System.out.println("firefox is checked");
		else if (safariisActive.contains("active"))
			System.out.println("safari is checked");
		else if(edgeisActive.contains("active"))
			System.out.println("edge is checked");
		
		String text = driver.findElement(By.xpath("//label[text()='21-40 Years']")).getText();
		
		System.out.println(text);
		
		
	}

}
