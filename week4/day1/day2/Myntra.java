package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions action=new Actions(driver);
		WebElement menlink = driver.findElement(By.xpath("//a[@data-group='men']"));
		action.moveToElement(menlink).perform();
		WebElement jackets = driver.findElement(By.xpath("(//a[text()='Jackets'])[1]"));
		driver.executeScript("arguments[0].click();", jackets);
//		action.moveToElement(menlink).click(jackets).perform();
//		System.out.println("Count of Jackets : "+driver.findElement(By.xpath("//span[@class='title-count']")).getText());
//		List<WebElement> catcount = driver.findElements(By.xpath("//span[@class='categories-num']"));
//		List<String> categorycount=new ArrayList<String>();
//		for(int i=0;i<catcount.size();i++) {
//			String text = catcount.get(i).getText();
//			
//			categorycount.add(text);
//			}
//		System.out.println(categorycount);
		

		
	}

}
