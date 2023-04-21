package marathonselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class OrderingMobile {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://dev120081.service-now.com/");
		System.out.println("Browser has been launched");
		
		//to apply global wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
		
		//maximise the window
		driver.manage().window().maximize();
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("$AWWF0/a2afr");
		driver.findElement(By.id("sysverb_login")).click();
		Shadow dom=new Shadow(driver);
		dom.setImplicitWait(30);
		dom.findElementByXPath("//div[text()='All']").click();
		dom.findElementByXPath("//input[@id='filter']").sendKeys("Service Catalog");
		dom.setImplicitWait(5);
		dom.findElementByXPath("//a[@aria-label='Service Catalog']").click();

		Shadow shadow=new Shadow(driver);
		WebElement aframe = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(aframe);
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
		driver.findElement(By.xpath("//a/h2/strong[text()='Apple iPhone 13']")).click();
		driver.findElement(By.xpath("//label[text()='Yes']")).click();
		driver.findElement(By.xpath("//td/div/div/div[2]/input[2]")).sendKeys("9999999999");
		Thread.sleep(2000);
		WebElement select = driver.findElement(By.xpath("//div/select[@class='form-control cat_item_option ']"));
		Select dd=new Select(select);
		dd.selectByValue("500MB");
		driver.findElement(By.xpath("//label[text()='Blue']")).click();
		driver.findElement(By.xpath("//label[contains(text(),'256 GB')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Order Now')]")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[@class='notification notification-success']/span")).getText());
		String request = driver.findElement(By.xpath("//a[@id='requesturl']/b")).getText();
		
		if(request.contains("REQ"))
			System.out.println("Order is placed. Request no. is: "+request);
		else
			System.out.println("Order not placed");
		
	
	
	}

}
