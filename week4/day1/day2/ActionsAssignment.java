package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActionsAssignment obj=new ActionsAssignment();
		//obj.draggable();
		//obj.droppable();
		//obj.resizable();
		obj.selectable();
		

	}
	public void draggable() {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/draggable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement frame1 = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(frame1);
		Actions s=new Actions(driver);
		WebElement dragelement = driver.findElement(By.id("draggable"));
		s.dragAndDropBy(dragelement, 100,200).perform();
		
	}
	
public void droppable() {
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://jqueryui.com/droppable");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement frame1 = driver.findElement(By.xpath("//iframe"));
	driver.switchTo().frame(frame1);
	Actions s=new Actions(driver);
	WebElement dragelement = driver.findElement(By.id("draggable"));
	WebElement dropelement = driver.findElement(By.id("droppable"));
	s.dragAndDrop(dragelement, dropelement).perform();
	
	
		
	}
public void resizable() {
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://jqueryui.com/resizable");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement frame1 = driver.findElement(By.xpath("//iframe"));
	driver.switchTo().frame(frame1);
	Actions s=new Actions(driver);
	WebElement dragelement = driver.findElement(By.xpath("//*[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
	s.clickAndHold(dragelement).moveByOffset(100, 50).perform();
	
}
public void selectable() {
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://jqueryui.com/selectable");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement frame1 = driver.findElement(By.xpath("//iframe"));
	driver.switchTo().frame(frame1);
	Actions s=new Actions(driver);
	WebElement item1 = driver.findElement(By.xpath("//li[@class='ui-widget-content ui-selectee' and text()='Item 1']"));
	String s1=item1.getAttribute("class");
	item1.click();
	String s2=item1.getAttribute("class");

	// validation
	 
	if(s1.equals(s2))
	 {
	 System.out.println("not selectable");
	 }
	 else
	 {
	 System.out.println("selectable");
	 }
	s.clickAndHold(item1).moveByOffset(50, 70).perform();

	
}

}
