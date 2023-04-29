package week5.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class NewKnowledge extends BaseClassServiceNow{

	@Test
	public void runNewKnowledge() throws InterruptedException {
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(30);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Knowledge");
		shadow.findElementByXPath("//mark[text()='Knowledge']").click();
		shadow.setImplicitWait(5);
		WebElement aframe = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(aframe);
		driver.findElement(By.xpath("//span[text()='Create an Article']")).click();
		Thread.sleep(2000);
		WebElement knowledgeid = driver.findElement(By.xpath("//input[@id='sys_readonly.kb_knowledge.number']"));
		driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_knowledge_base']")).click();
		Thread.sleep(1000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> whs=new ArrayList<String>(windowHandles);
		driver.switchTo().window(whs.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(whs.get(0));
		Thread.sleep(2000);	
		WebElement a2frame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(a2frame);
		driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_category']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(@aria-label,'IT,level1')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(@aria-label,'Java,level2')]")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys("New Knowledge");
		driver.findElement(By.id("sysverb_insert")).click();
		System.out.println("Knowledge Id creted is: "+knowledgeid);
		
	}
}
