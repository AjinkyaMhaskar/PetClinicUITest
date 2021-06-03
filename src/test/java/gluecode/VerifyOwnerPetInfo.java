package test.java.gluecode;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.java.commonFunctions.CommonUIFunctions;
import test.java.dataProviders.ConfigFileReader;
import test.java.runner.TestRunner;

public class VerifyOwnerPetInfo {
		
		@Given("^I navigate to Find Owners tab$")
		public void i_navigate_to_Find_Owners_tab() throws Throwable {
			TestRunner.driver.navigate().to(ConfigFileReader.getfindOwnerURL());
		}
	
		@When("^I enter user last name$")
		public void i_enter_user_last_name() throws Throwable {
			TestRunner.driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(ConfigFileReader.getOwnerLastName());
			TestRunner.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
		/*Use this method when testing for same user again.*/
		@And("^I  select first row$")
		public void i_select_first_row() throws Throwable {
			
			 @SuppressWarnings("rawtypes")
				List rows = TestRunner.driver.findElements(By.xpath("//*[@id=\"owners\"]/tbody/tr/td[1]")); 
		        List<String> OwnerListSearch = new ArrayList<String>();
		        for(int i=1;i<=rows.size();i++)
		        {
		        	OwnerListSearch.add(TestRunner.driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr["+i+"]/td[1]/a[1]")).getText());
		        }
			System.out.println(OwnerListSearch);
			TestRunner.driver.findElement(By.xpath("//*[@id=\"owners\"]/tbody/tr[1]/td[1]/a[1]")).click();
			CommonUIFunctions.waitWithXpath("//h2[contains(text(),'Owner Information')]");
		}
		
		@Then("^Verify Onwer details$")
		public void verify_Onwer_details() throws Throwable {
			TestRunner.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			String tabHeader = TestRunner.driver.findElement(By.xpath("//h2[contains(text(),'Owner Information')]")).getText();
			assertEquals("Owner Information", tabHeader, "Correct tab name - Owner Information");
			
			String OwnerName = TestRunner.driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
			assertEquals(ConfigFileReader.getOwnerName()+" "+ConfigFileReader.getOwnerLastName(), OwnerName, "OwnerName");
			
			String OwnerAddress = TestRunner.driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).getText();
			assertEquals(ConfigFileReader.getOwnerAddress(), OwnerAddress, "OwnerAddress");
			
			String OwnerCity = TestRunner.driver.findElement(By.xpath("//tbody/tr[3]/td[1]")).getText();
			assertEquals(ConfigFileReader.getOwnerCity(), OwnerCity, "OwnerCity");
			
			String OwnerTelephone = TestRunner.driver.findElement(By.xpath("//tbody/tr[4]/td[1]")).getText();
			assertEquals(ConfigFileReader.getOwnerTelephone(), OwnerTelephone, "OwnerTelephone");
		}
		
		@And("^Verify pet details$")
		public void veriify_pet_details() throws Throwable {
			TestRunner.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			String PetInfotabHeader = TestRunner.driver.findElement(By.xpath("//h2[contains(text(),'Pets and Visits')]")).getText();
			assertEquals("Pets and Visits", PetInfotabHeader, "Correct tab name - Pets and Visits");
			
			String PetName = TestRunner.driver.findElement(By.xpath("//dd[contains(text(),'Lio')]")).getText();
			assertEquals(ConfigFileReader.getPetName(), PetName, "PetName");
			
			String PetDOB = TestRunner.driver.findElement(By.xpath("//dd[contains(text(),'2005-12-02')]")).getText();
			assertEquals(ConfigFileReader.getPetDOB(), PetDOB, "PetDOB");
			
			String PetType = TestRunner.driver.findElement(By.xpath("//dd[contains(text(),'dog')]")).getText();
			assertEquals(ConfigFileReader.getPetType(), PetType, "PetType");
		}
}
