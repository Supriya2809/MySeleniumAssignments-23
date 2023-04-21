package marathonselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BookMyShowTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://in.bookmyshow.com/");
		System.out.println("Browser has been launched");
		
		//to apply global wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
		
		//maximise the window
		driver.manage().window().maximize();
		System.out.println("Browser has been maximised");
		
		//Type the city as"Hyderabad"in Select City
		driver.findElement(By.xpath("//input[@placeholder='Search for your city']")).sendKeys("Hyderabad");
		
		//Confirm the URL has got loaded with Hyderabad 
		driver.findElement(By.xpath("//span[@class='sc-dBaXSw gYlrLO']")).click();
		System.out.println(driver.getCurrentUrl());
		
		//Search for your favorite movie 
		driver.findElement(By.xpath("//span[contains(text(),'Search for Movies')]")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search for Movies')]")).sendKeys("dasara");
		//Click on movie
		driver.findElement(By.xpath("//div[@class='sc-dXfzlN iPwaRU']")).click();
		
		//Print the name of the theater displayed first
		driver.findElement(By.xpath("//div/div/button//div/span[text()='Book tickets']")).click();
		driver.findElement(By.xpath("(//div[@class='sc-vhz3gb-3 dRokFO'])[1]")).click();
		WebElement theatrename = driver.findElement(By.linkText("Aarti Theater: Sanginagar"));
		System.out.println("Name of theatre: "+theatrename.getText());
		
		
		//Click on the info of the theater
		driver.findElement(By.xpath("(//div[@class='venue-info-text'])[1]")).click();
		
		
		//Confirm if there is a parking facility in the theater
		WebElement parking = driver.findElement(By.xpath("//img[contains(@src,'parking')]"));
		
		if(parking != null) 
			System.out.println("Parking facility available");
		
		else
			System.out.println("No parking facility");
		

		//Close the theater popup
		driver.findElement(By.xpath("//div[@class='cross-container']")).click();
		//Click on the first green (available) timing
		driver.findElement(By.xpath("(//a[contains(@href,'ARTI')])[2]")).click();
		//Click Accept
		//Choose 1 Seat and Click Select Seats
		driver.findElement(By.xpath("//li[@id='pop_1']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Select Seats')]")).click();
		//Choose any available ticket and Click Pay
		driver.findElement(By.xpath("(//a[contains(@onclick,'fnSelectSeat')])[25]")).click();
		driver.findElement(By.xpath("(//span[@id='btnSTotal_reserve'])[1]")).click();
		//Print the sub total
		WebElement subtotal = driver.findElement(By.xpath("//span[text()='Rs.116.52']"));
		System.out.println("Subtotal: "+subtotal.getText());

	

	}

}
