package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookAssignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//to launch the browser
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		
		//to apply global wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
		
		//to maximise the window
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		driver.findElement(By.xpath("//input[@aria-label='First name']")).sendKeys("supriya");
		driver.findElement(By.xpath("//input[@aria-label='Surname']")).sendKeys("ravi");
		driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys("999999999");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("dummy");
		
		WebElement dd1 = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select birthdate=new Select(dd1);
		birthdate.selectByValue("28");
		
		WebElement dd2 = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select month=new Select(dd2);
		month.selectByIndex(9);
		
		WebElement dd3 = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select year=new Select(dd3);
		year.selectByVisibleText("1988");
		
		
		driver.findElement(By.xpath("//span/label[text()='Female']")).click();
		
		System.out.println("The testing for facebook page is done");
		
		
		
	}

}
