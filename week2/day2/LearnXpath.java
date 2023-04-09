package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.cucumber.messages.types.Duration;

public class LearnXpath {

	public static void main(String[] args) throws InterruptedException {
		//to launch the browser
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://www.leafground.com/input.xhtml");
				
				//to apply global wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
				
				//to maximise the window
				driver.manage().window().maximize();
				
				/*//to enter username using attribute based Xpath
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
				
				//to enter password using attribute based Xpath
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
				
				//to find element login button and do click action using attribute based Xpath
				driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click(); 
				
				//to find the hyperlink CRM/SFA using partial text based Xpath
				driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
				
				//to find the Leads link using partial attribute based Xpath
				driver.findElement(By.xpath("//a[contains(@href,'leads')]")).click();*/
				
				//4. Clear the typed text
				WebElement element2 = driver.findElement(By.xpath("//input[@value='Can you clear me, please?']"));
				   //To Check that text box is empty or not
				element2.clear();
	              String CLbox =element2.getAttribute("value");
	              if(CLbox.isEmpty())
	              {
	                     System.out.println("Yes Text box is clear");
	              }
	              else
	              {
	                     System.out.println("No Text box is not clear");
	              }

				
				
				//5. Retrieve the typed text
				WebElement element = driver.findElement(By.xpath("//form//input[contains(@value,'learning')]"));
				System.out.println(element.getAttribute("value"));
				
				Thread.sleep(2000);
				driver.close();
				
				
				


	}

}
