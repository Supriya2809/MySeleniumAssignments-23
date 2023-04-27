package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafgroundAssignment1 {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml;jsessionid=node0ohpw87cjok1dz9p1fgudvj6l12019.node0");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> whs1=new ArrayList<String>(windowHandles1);
		
		driver.switchTo().window(whs1.get(1));
		System.out.println("Title of new tab: "+driver.getTitle());
		for(int i=1;i<whs1.size();i++) {
			driver.switchTo().window(whs1.get(i));
			driver.close();
		}
		driver.switchTo().window(whs1.get(0));
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> whs2=new ArrayList<String>(windowHandles2);
		driver.switchTo().window(whs2.get(1));
		System.out.println("Title of new window: "+driver.getTitle());
		System.out.println("Number of open tabs: "+whs2.size());
		for(int i=1;i<whs2.size();i++) {
			driver.switchTo().window(whs2.get(i));
			driver.close();
		}
		driver.switchTo().window(whs2.get(0));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Set<String> windowHandlesalert = driver.getWindowHandles();
		List<String> whsalert=new ArrayList<String>(windowHandlesalert);
		for(int i=1;i<whsalert.size();i++) {
			driver.switchTo().window(whsalert.get(i));
			driver.close();
		}
		driver.switchTo().window(whsalert.get(0));
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> whs3=new ArrayList<String>(windowHandles3);
		driver.switchTo().window(whs3.get(1));
		System.out.println("Title of new window: "+driver.getTitle());
		for(int i=1;i<whs3.size();i++) {
			driver.switchTo().window(whs3.get(i));
			driver.close();
		}
		driver.switchTo().window(whs3.get(0));
		driver.quit();
		
		

	}

}
