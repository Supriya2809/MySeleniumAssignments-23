package salesforcetestcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import salesforcebase.baseclassSFIndividual;
import salesforcepages.HomePage;
import salesforcepages.LoginPage;


public class CreateNewIndividual extends baseclassSFIndividual{

	@BeforeTest
	public void setFile() {	
		filename="CreateNewIndividual";

	}
	@Test(dataProvider="fetchData")
		public void runCreateNewIndividual(String lName) {
			
			HomePage ob=new HomePage(driver);
			
			ob.clickAppLauncher()
			.clickViewAll()
			.clickIndividualApp()
			.clickIndividualdd()
			.clickNewIndividual()
			.enterLastName(lName)
			.clickSave()
			.getCreatedMessage(lName);
			

		}
		
	}
