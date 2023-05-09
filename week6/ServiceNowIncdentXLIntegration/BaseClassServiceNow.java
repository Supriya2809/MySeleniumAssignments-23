package week6;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClassServiceNow {

	public ChromeDriver driver;
	//public static String incidentnumber;
	public String filename;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preCondition(String url,String uname,String pwd) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver.findElement(By.id("user_name")).sendKeys(uname);
		driver.findElement(By.id("user_password")).sendKeys(pwd);
		driver.findElement(By.id("sysverb_login")).click();
		//System.out.println("Incident No: "+incidentnumber);
	}

	
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException{
		return ReadfromExcel.readData(filename);			
		
	}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
}
