package marathonselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RedBusTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//to launch browser
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		System.out.println("Browser has been launched");
		
		//to apply global wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
		
		//maximise the window
		driver.manage().window().maximize();
		System.out.println("Browser has been maximised");
		
		
		//Type "Chennai" in the FROM text box
		driver.findElement(By.xpath("//input[contains(@data-message,'source city')]")).sendKeys("Chennai");
		
		
		//Click the first option from the pop up box
		driver.findElement(By.xpath("//li[text()='Chennai'] ")).click();
		System.out.println("Chennai entered");
		
		//Type "Bangalore" in the TO text box
		driver.findElement(By.xpath("//input[contains(@data-message,'destination city')]")).sendKeys("Bangalore");
		
		//Click the first option from the pop up box
		driver.findElement(By.xpath("//li[text()='Bangalore'] ")).click();
		System.out.println("Bangalore entered");
		
		//Select tomorrow's date in the Date field
		driver.findElement(By.xpath("//tbody/tr/td[text()='6'] ")).click();
		
		//Click Search Buses
		driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
		System.out.println("Clicked on search button");
		
		//Print the number of buses shown as results
		WebElement noofbuses = driver.findElement(By.xpath("//span[@class='f-bold busFound']"));
		System.out.println("Number of busses: "+noofbuses.getText());
		
		//Choose SLEEPER in the left menu 
		driver.findElement(By.xpath("//label[@title='SLEEPER']")).click();
		
		//Print the name of the second resulting bus (use .getText())
		WebElement secondbus = driver.findElement(By.xpath("//div[text()='KMRL Kalaimakal']"));
		System.out.println("Name of second bus: "+secondbus.getText());
		
		//Get the Title of the page(use .getTitle())
		System.out.println("Title of the page: "+driver.getTitle());
		
		

	}

}
