package salesforcebase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import marathonselenium.ReadExcel;
import salesforcepages.LoginPage;


public class baseclassSFIndividual {

	public static ChromeDriver driver;
	public String filename;
	public int parseInt;
	public static ExtentReports extentReports;
	public static ExtentTest test;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preConditoin(ITestContext context,String url,String uname,String pwd)
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		test = extentReports.createTest(context.getName());
		String author=context.getCurrentXmlTest().getParameter("author");
		test.assignAuthor(author);
		test.assignCategory("Functional");
		LoginPage ob=new LoginPage(driver);
		ob.enterUserName(uname)
		.enterPassword(pwd)
		.clickLogin();
		
		
		
	}
	
	@AfterMethod
	public void postConditoin() {
		driver.close();
	}
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {	
		
		return ReadExcel.readData(filename);			
		
	}
	
	@BeforeSuite
	public void intilializeReports() {
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./reports/result.html");
		extentReports = new ExtentReports();
		reporter.setAppendExisting(true);
		extentReports.attachReporter(reporter);
		//extentReports.createTest("CreateNewIndividual","Creating New individuals- Positive test");
	}
	
	@AfterSuite
	public void generateReport() {
		extentReports.flush();
	}
}
