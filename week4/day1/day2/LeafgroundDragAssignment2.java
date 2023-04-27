package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LeafgroundDragAssignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions s=new Actions(driver);
		WebElement drag = driver.findElement(By.xpath("//span[text()='Drag me around']"));
		
		s.dragAndDropBy(drag, 150,200).perform();
		
		WebElement dragTarget=driver.findElement(By.xpath("//p[text()='Drag to target']"));
		WebElement drophere=driver.findElement(By.xpath("//p[text()='Drop here']"));

		s.dragAndDrop(dragTarget,drophere).perform();
		WebElement coldragsource = driver.findElement(By.xpath("(//span[text()='Quantity'])[1]"));
		WebElement coldragtarget = driver.findElement(By.xpath("(//span[text()='Category'])[1]"));
		s.dragAndDrop(coldragsource, coldragtarget).perform();
		WebElement rowdragsource = driver.findElement(By.xpath("(//td[text()='Bamboo Watch']/parent::tr)[2]"));
		WebElement rowdragtarget = driver.findElement(By.xpath("(//td[text()='Blue Band']/parent::tr)[2]"));
		s.dragAndDrop(rowdragsource, rowdragtarget).perform();
		WebElement imgresize = driver.findElement(By.xpath("//img[@id='form:logo']"));
		//s.dragAndDropBy(imgresize, 150, 200).perform();
		
	}

}
