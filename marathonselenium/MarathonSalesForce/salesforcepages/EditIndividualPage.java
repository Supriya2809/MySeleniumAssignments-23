package salesforcepages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import salesforcebase.baseclassSFIndividual;

public class EditIndividualPage  extends baseclassSFIndividual{

	public EditIndividualPage(ChromeDriver driver) {
		// TODO Auto-generated constructor stub
	}
	public EditIndividualPage clickSalutation() {
		driver.findElement(By.xpath("//a[@class='select']")).click();
		return this;
	}
	
	public EditIndividualPage selectSalutation() {
		driver.findElement(By.xpath("//a[text()='Mr.']")).click();
		return this;
	}
	
	public EditIndividualPage enterFirstName(String fName)
	{
		driver.findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys(fName);
		return this;
		
	}
	
	public IndividualHomePage clickEditSave() {
	
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		return new IndividualHomePage(driver);
	}
	
	
	

	
}
