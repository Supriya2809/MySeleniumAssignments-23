package salesforcepages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import salesforcebase.baseclassSFIndividual;

public class DeleteIndividualPage extends baseclassSFIndividual{

	public DeleteIndividualPage(ChromeDriver driver) {
		// TODO Auto-generated constructor stub
	}

	public IndividualHomePage clickDelete() {
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		return new IndividualHomePage(driver);
	}
}
