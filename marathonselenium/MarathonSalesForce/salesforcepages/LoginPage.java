package salesforcepages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;

import salesforcebase.baseclassSFIndividual;

public class LoginPage extends baseclassSFIndividual{
	
	

	public LoginPage(ChromeDriver driver) {
		// TODO Auto-generated constructor stub
	}



	@Parameters("username")
	public LoginPage enterUserName(String uname) {
		driver.findElement(By.id("username")).sendKeys(uname);
		
			return this;//same as new LoginPage();
		}

	@Parameters("password")
	public LoginPage enterPassword(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
		return this;

	}
	public HomePage clickLogin() {

		driver.findElement(By.id("Login")).click();
		return new HomePage(driver);
	}

}
