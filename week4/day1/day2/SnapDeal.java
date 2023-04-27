package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions s=new Actions(driver);
		WebElement mensfashion = driver.findElement(By.xpath("(//span[contains(text(),'Men')])[1]"));
		WebElement sportsshoes = driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]"));
		s.moveToElement(mensfashion).click(sportsshoes).perform();
		System.out.println("Count of Sports shoes for Men: "+driver.findElement(By.xpath("//div[text()='Sports Shoes for Men']/following-sibling::div")).getText());
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		Thread.sleep(2000);
		List<WebElement> pricelth = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<String> price=new ArrayList<String>();
		for(int i=0;i<pricelth.size();i++) {
			String text = pricelth.get(i).getText();
			//17,999-->17999 String
			//String replace = text.replace(",", "");
			//System.out.println(replace);
			//if(!replace.isBlank()) {
			//int parseInt = Integer.parseInt(text);
			price.add(text);
			}
				
		System.out.println("Price of shoes in ascending order: "+price);
//		WebElement leftslider = driver.findElement(By.xpath("//a[contains(@class,'price-slider-scroll left-handle')]"));
//		WebElement rightslider = driver.findElement(By.xpath("//a[contains(@class,'price-slider-scroll right-handle')]"));
//		s.dragAndDropBy(leftslider, 20, 0);
//		Thread.sleep(1000);
//		s.dragAndDropBy(rightslider, -20, 0);
//		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
        driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900");
        driver.findElement(By.xpath("//input[@name='toVal']")).clear();
        driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1200");
        driver.findElement(By.xpath("//div[contains(@class,'arrow btn')]")).click();
        Thread.sleep(1000);
        
		WebElement nvy = driver.findElement(By.xpath("//label[@for='Color_s-Navy']"));
        driver.executeScript("arguments[0].click();", nvy);
		Thread.sleep(1000);
		List<WebElement> filters = driver.findElements(By.xpath("//div[@class='navFiltersPill']"));
		List<String> f=new ArrayList<String>();
		for(int i=0;i<filters.size();i++) {
			String text = filters.get(i).getText();
			//17,999-->17999 String
			//String replace = text.replace(",", "");
			//System.out.println(replace);
			//if(!replace.isBlank()) {
			//int parseInt = Integer.parseInt(text);
			f.add(text);
			}
		System.out.println("Filters applied are: "+f);
		WebElement img = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		WebElement qview = driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']"));
		s.moveToElement(img).click(qview).perform();
		
		String text = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']")).getText();
		String text2 = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		String text3 = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println(text+text2+text3);
		driver.findElement(By.xpath("//div[@class='close close1 marR10']/i[@class='sd-icon sd-icon-delete-sign']")).click();
		
		driver.quit();
		
		
	}

}
