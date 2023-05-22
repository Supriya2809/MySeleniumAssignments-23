package salesforcepages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import salesforcebase.baseclassSFIndividual;

public class NewIndividualPage extends baseclassSFIndividual {

	
	
	public NewIndividualPage(ChromeDriver driver) {
		// TODO Auto-generated constructor stub
	}
	public NewIndividualPage enterLastName(String lName) {
		driver.findElement(By.xpath("//input[contains(@class,'lastName compound')]")).sendKeys(lName);
		return this;
	}
	public IndividualHomePage clickSave() {
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		return new IndividualHomePage(driver);
	}
}
