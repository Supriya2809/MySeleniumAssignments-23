package week6;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseLeafTaps {

	public ChromeDriver driver;
	public String text;
	public String filename;
	
	@Parameters({"username","password","url"})

		@BeforeMethod
		public void preCOndition(String uname, String pwd,String url) {
			driver  = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(By.id("username")).sendKeys(uname);
			driver.findElement(By.id("password")).sendKeys(pwd);
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
			
			
		}
		
		@AfterMethod
		public void postCondition() {
			driver.close();
		}
		
		
		@DataProvider(name="fetchData")
		public String[][] sendData() throws IOException {	
			
			return ReadfromExcel.readData(filename);			
			
		}

}
