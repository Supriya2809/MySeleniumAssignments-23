package salesforcetestcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import salesforcebase.baseclassSFIndividual;
import salesforcepages.HomePage;

public class EditIndividual extends baseclassSFIndividual{

	
	@BeforeTest
	public void setFile() {	
		filename="EditIndividual";

	}
	@Test(dataProvider="fetchData")
	public void runEditIndividual(String lName,String fName) throws InterruptedException {
		
		HomePage ob=new HomePage(driver);
		ob.clickAppLauncher()
		.clickViewAll()
		.clickIndividualApp()
		.clickIndividual()
		.enterSearchText(lName)
		.clickFirstIndividual()
		.clickEditIndividual()
		.clickSalutation()
		.selectSalutation()
		.enterFirstName(fName)
		.clickEditSave()
		.getEditMessage(lName);
	}
}
