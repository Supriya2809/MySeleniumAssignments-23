package week7.day1;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTableAssignment3 {

	public ChromeDriver driver;
	@BeforeMethod
	public void launchURL() {
//		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--disable-notifications");
		driver=new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
	}
	
	@Test
	public void getTableSize() {
		WebElement table = driver.findElement(By.xpath("//table/caption[text()='The Three Most Popular JavaScript Libraries']"));
		
		int colsize = driver.findElements(By.xpath("//table/caption[text()='The Three Most Popular JavaScript Libraries']/following-sibling::thead//th")).size();
		int rowsize = driver.findElements(By.xpath("//table/caption[text()='The Three Most Popular JavaScript Libraries']/following-sibling::tbody[1]/tr")).size();
				
		System.out.println("Row Size: "+rowsize);
		System.out.println("Column size: "+colsize);
		
		String varlibrary;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the Library : ");
      	varlibrary = sc.nextLine();
      	System.out.println(varlibrary);
      	String[] lib=new String[2];
      	int l=lib.length;
      	for (int i = 1; i <= rowsize; i++) {
		
			lib[i-1] = driver.findElement(By.xpath("//table/caption[text()='The Three Most Popular JavaScript Libraries']/following-sibling::tbody/tr["+i+"]/td[1]")).getText();
		
      	}
      	
      		for (int j = 0; j < lib.length; j++) {
				if(lib[j].equalsIgnoreCase(varlibrary))
				{
					System.out.println(lib[j]+" "+varlibrary);
					for (int j2 = 1; j2 < colsize; j2++) {
						String text2 = driver.findElement(By.xpath("//table/caption[text()='The Three Most Popular JavaScript Libraries']/following-sibling::tbody/tr["+(j+1)+"]/td["+j2+"]")).getText();
		      			System.out.println(text2);
					}
				}
      			
      			
			}
      		
      	
		
      	
      	
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}

