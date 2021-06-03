package test.java.gluecode;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import test.java.commonFunctions.CommonUIFunctions;
import test.java.runner.TestRunner;

public class FindExistingOwners {
	
	@Given("^I click on Find Owners tab$")
	public void i_click_on_owner_tab() throws Throwable {
		TestRunner.driver.findElement(By.xpath("//span[contains(text(),'Find owners')]")).click();
		CommonUIFunctions.waitWithXpath("//h2[contains(text(),'Find Owners')]");
		String tabHeader = TestRunner.driver.findElement(By.xpath("//h2[contains(text(),'Find Owners')]")).getText();
		assertEquals("Find Owners", tabHeader, "Correct tab name - Find Owner");
	}

	@And("^I click on Find Owner button$")
	public void i_click_on_Find_Owner_button() throws Throwable {
		TestRunner.driver.findElement(By.xpath("//button[contains(text(),'Owner')]")).click();
		CommonUIFunctions.waitWithXpath("//h2[contains(text(),'Owners')]");
	}

	@Then("^I find all owner list and verify names$")
	public void i_find_all_owner_list_and_verify_names() throws Throwable {
		
		//No.of rows 
        @SuppressWarnings("rawtypes")
		List rows = TestRunner.driver.findElements(By.xpath("//*[@id=\"owners\"]/tbody/tr/td[1]")); 
        List<String> OwnerList = new ArrayList<String>();
        for(int i=1;i<=rows.size();i++)
        {
        	OwnerList.add(TestRunner.driver.findElement(By.xpath("//tbody/tr["+i+"]/td[1]")).getText());
        }
        System.out.println(OwnerList);
	}
}
