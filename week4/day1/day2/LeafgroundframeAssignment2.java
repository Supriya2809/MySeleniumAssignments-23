package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafgroundframeAssignment2 {

	public static void main(String[] args) {
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/frame.xhtml;jsessionid=node05us3gij8ed091h38fieurov685953.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//button[@id='Click'])[1]")).click();
		System.out.println(driver.findElement(By.xpath("(//button[@id='Click'])[1]")).getText());
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		String text = driver.findElement(By.xpath("//button[text()='Count Frames']")).getText();
		System.out.println(text);
		 driver.switchTo().defaultContent(); 
		//to Switch into nested frame
		  List<WebElement>Outerframe =
		  driver.findElements(By.xpath("(//iframe)"));
		  
		  int size = Outerframe.size(); 
		  System.out.println("Number of frames" +size);	
		 driver.switchTo().frame(2);
		 driver.switchTo().frame("frame2");
		 driver.findElement(By.id("Click")).click();
		 driver.switchTo().parentFrame();

	}

}
