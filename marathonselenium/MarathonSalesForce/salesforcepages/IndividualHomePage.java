package salesforcepages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import salesforcebase.baseclassSFIndividual;

public class IndividualHomePage extends baseclassSFIndividual{
	
	

	public IndividualHomePage(ChromeDriver driver) {
		// TODO Auto-generated constructor stub
	}
//create
	public IndividualHomePage clickIndividualdd() {
		driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']//a")).click();
		return this;
	}
	
	public NewIndividualPage clickNewIndividual() {
		
		WebElement clk = driver.findElement(By.xpath("//span[text()='New Individual']"));
		driver.executeScript("arguments[0].click();", clk);
		return new NewIndividualPage(driver);
	}
	
	public IndividualHomePage getCreatedMessage(String lName) {
		String message = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();

		if(message.contains("created"))
		{
			System.out.println("Individual "+lName+" successfully created");
		}
		else
		{
			System.out.println("Failed to create indiviual "+lName);
		}
		return this;
	}
	
	//edit & delete
	public IndividualHomePage clickIndividual() {
		WebElement clk = driver.findElement(By.xpath("//a[@title='Recently Viewed | Individuals']//span[1]"));
		driver.executeScript("arguments[0].click();", clk);
		return this;
	}
	//edit & delete

	public IndividualHomePage enterSearchText(String lName) throws InterruptedException {
		WebElement name =driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys(lName);
		name.sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		return this;
	}
	//edit & delete

	public IndividualHomePage clickFirstIndividual() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		String count = driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText();
		String numberonly=count.replaceAll("[^0-9]", "");
		parseInt = Integer.parseInt(numberonly);
		System.out.println("Result count: "+parseInt);
		if(parseInt>0)
		{
		try {
			
		
		WebElement ele = driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		//driver.executeScript("arguments[0].click();", ele);
		ele.click();
		return this;
		}catch(Exception E)
		{
			System.out.println("There is an exception"+E);
			return this;
			}
		}
		else
		{
			String text = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
			System.out.println("There are no individuals listed: "+text);
			return this;
		}
		}
	//edit
	public EditIndividualPage clickEditIndividual() throws InterruptedException {
		Thread.sleep(5000);
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']/div"));
		//wait.until(ExpectedConditions.elementToBeClickable(edit));
		driver.executeScript("arguments[0].click();", edit);
		return new EditIndividualPage(driver);
	}
	//edit
	public IndividualHomePage getEditMessage(String lName) {
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		   if(msg.contains("saved")) {
			   System.out.println("Individual "+lName+" successfully edited");
		   }
		   else
		   {
			   System.out.println("Failed to edit indiviual "+lName);
		   }
		   return this;
		   
	}
	
	//delete
	public DeleteIndividualPage clickDeleteIndividual() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement delete = driver.findElement(By.xpath("//a[@role='menuitem']/div[@title='Delete']"));
		wait.until(ExpectedConditions.elementToBeClickable(delete));
		driver.executeScript("arguments[0].click();", delete);
		return new DeleteIndividualPage(driver);
	}
	
	//delete
	public IndividualHomePage getDeleteMessage(String lName) {
		if(parseInt>0)
		{
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		 System.out.println(msg);
		}
		
			
		
		String actualverify = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		String expectedverify="No items to display";
		if(actualverify.contains(expectedverify))
		{
			System.out.println("Individual successfully deleted");
		}
		else
		{
			System.out.println("Failed to delete individual");
		}
		return this;
		   
	}
}
