package week5.Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class NewProposal extends BaseClassServiceNow {
	@Test
	public void runNewProposal() throws InterruptedException {
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(30);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("proposal");
		shadow.findElementByXPath("//mark[text()='Proposal']").click();
		shadow.setImplicitWait(5);
		WebElement aframe = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(aframe);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		Thread.sleep(2000);
		String proposalno = driver.findElement(By.xpath("//input[@id='std_change_proposal.number']")).getAttribute("value");
		driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys("Sample creation");
		driver.findElement(By.id("sysverb_insert")).click();
		driver.findElement(By.xpath("//div[@class='input-group']/input[@placeholder='Search']")).sendKeys(proposalno+Keys.ENTER);
		Thread.sleep(2000);
		List<WebElement> proposalslist = driver.findElements(By.xpath("//a[@class='linked formlink']"));
		boolean found=false;
		for (WebElement webElement : proposalslist) {
			if(webElement.getText().contains(proposalno)) {
				found=true;
				break;
			}
		}
		if(found) {
			System.out.println("Proposal created successfully.no.:"+proposalno);
		}
		else {
			System.out.println("Proposal not created");
		}
	}

}
