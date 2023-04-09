package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

public class TextboxAssignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//https://www.leafground.com/input.xhtml
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml");
		//to apply global wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	

		driver.manage().window().maximize();
		//1. Type your name
		driver.findElement(By.xpath("(//input[@class='ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all'])[1]")).sendKeys("Supriya");
		Thread.sleep(2000);
		//2. Append Country to this City
		driver.findElement(By.xpath("//input[@class='ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all city ui-state-filled']")).sendKeys("India");
		Thread.sleep(2000);
		//3. Verify if text box is disabled
		driver.findElement(By.xpath("//input[@ placeholder ='Disabled']")).isEnabled();
		Thread.sleep(2000);
		//4. Clear the typed text
		WebElement element1 = driver.findElement(By.xpath("//input[@value='Can you clear me, please?']"));
		   //To Check that text box is empty or not
		element1.clear();
          String CLbox =element1.getAttribute("value");
          if(CLbox.isEmpty())
          {
                 System.out.println("Yes Text box is clear");
          }
          else
          {
                 System.out.println("No Text box is not clear");
          }
		Thread.sleep(2000);
		//5. Retrieve the typed text
		WebElement element2 = driver.findElement(By.xpath("//form//input[contains(@value,'learning')]"));
		System.out.println(element2.getAttribute("value"));
		
		Thread.sleep(2000);
		//6. Type email and Tab. Confirm control moved to next element
		WebElement element3 = driver.findElement(By.xpath("(//input[@class ='ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all'])[2]"));
		element3.sendKeys("text@mail.com");
		element3.sendKeys(Keys.TAB);
		Thread.sleep(2000);		
		//7. Type about yourself
		driver.findElement(By.xpath("//textarea[@placeholder ='About yourself']")).sendKeys("Hi Everyone. My name is Supriya and I am staying in Singapore.My hobbies include reading and listening music");
		Thread.sleep(2000);
		//8. Text Editor
		driver.findElement(By.xpath("(//div[@class ='ql-editor ql-blank'])[1]")).sendKeys("This is a text editor");
		
		Thread.sleep(2000);
		//9. Just Press Enter and confirm error message*
		driver.findElement(By.xpath("(//input[contains(@class,'state-default')])[7]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//10. Click and Confirm Label Position Changes
		driver.findElement(By.xpath("(//input[@class='ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all'])[3]")).click();
		
		Thread.sleep(2000);
		//11. Type your name and choose the third option
		WebElement element4 = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		element4.sendKeys("Supriya");
		driver.findElement(By.xpath("//li[contains(@class,'list-item')][3]")).click();
		Thread.sleep(2000);
		//12. Click and Confirm Keyboard appears
		boolean displayed = driver.findElement(By.xpath("//input[contains(@class,'keyboard')]")).isDisplayed();
		System.out.println("The keyboard is displyed:"+displayed);
		Thread.sleep(2000);
		//13. Custom Toolbar
		driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[2]")).sendKeys("this is a custom toolbar");
		driver.close();
	}

}
