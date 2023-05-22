package salesforcetestcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import salesforcebase.baseclassSFIndividual;
import salesforcepages.HomePage;
import salesforcepages.IndividualHomePage;


public class DeleteIndividual extends baseclassSFIndividual {
	
	@BeforeTest
	public void setFile() {	
		filename="DeleteIndividual";

	}
	@Test(dataProvider="fetchData")
		public void runDeleteIndividual(String lName) throws InterruptedException {
			
			HomePage ob=new HomePage(driver);
			ob.clickAppLauncher()
			.clickViewAll()
			.clickIndividualApp()
			.clickIndividual()
			.enterSearchText(lName)
			.clickFirstIndividual();
			if(parseInt>0)
			{
			
			IndividualHomePage obj= new IndividualHomePage(driver);
			obj.clickDeleteIndividual()
			.clickDelete()
			.getDeleteMessage(lName);
			}
			else
			{
				IndividualHomePage obj= new IndividualHomePage(driver);
				obj.getDeleteMessage(lName);
			}
	}
}