package salesforcepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import salesforcebase.baseclassSFIndividual;

public class HomePage extends baseclassSFIndividual{
	
	public HomePage(ChromeDriver driver) {
		
	}

	public HomePage clickAppLauncher() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		return this;
	}
	
	public HomePage clickViewAll() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		return this;
		}
	
	public  IndividualHomePage clickIndividualApp() {
		WebElement individual = driver.findElement(By.xpath("//p[text()='Individuals']"));
		driver.executeScript("arguments[0].scrollIntoView();", individual);
		driver.executeScript("arguments[0].click();", individual);
		return new IndividualHomePage(driver);
	}
	
}
