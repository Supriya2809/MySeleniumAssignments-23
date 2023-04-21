package marathonselenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class AdministratorCertifications {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://login.salesforce.com/");
		System.out.println("Browser has been launched");
		
		//to apply global wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
		
		//maximise the window
		driver.manage().window().maximize();
		
		
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> windowHS = driver.getWindowHandles();
		List<String> whs=new ArrayList<String>(windowHS);
		driver.switchTo().window(whs.get(1));
		driver.findElement(By.xpath("//button[@onclick='goAhead()']")).click();
		driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
	
		Shadow dom=new Shadow(driver);
		dom.findElementByXPath("//span[text()='Learning']").click();
		
		Actions s=new Actions(driver);
		WebElement learningOnTrailhead = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		WebElement salesforcecert = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		s.moveToElement(learningOnTrailhead).click(salesforcecert).perform();
		
		driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
		driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		System.out.println(driver.getTitle());
		List<WebElement> certList = driver.findElements(By.xpath("//div[@class='trailMix-card-body_title']"));
		System.out.println("List of certifications for Adminstrator: ");
		for (int i = 0; i < certList.size(); i++) {
			
			String text = certList.get(i).getText();
			System.out.println(text);
		}
		
		driver.quit();
		
		

	}

}
