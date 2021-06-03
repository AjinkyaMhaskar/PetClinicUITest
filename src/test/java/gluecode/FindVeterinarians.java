package test.java.gluecode;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import test.java.commonFunctions.CommonUIFunctions;
import test.java.runner.TestRunner;

public class FindVeterinarians {
	@Given("^I click on veterinarians tab$")
	public void i_click_on_veterinarians_tab() throws Throwable {
		TestRunner.driver.findElement(By.xpath("//span[contains(text(),'Veterinarians')]")).click();
		CommonUIFunctions.waitWithXpath("//h2[contains(text(),'Veterinarians')]");
		String tabHeader = TestRunner.driver.findElement(By.xpath("//h2[contains(text(),'Veterinarians')]")).getText();
		assertEquals("Veterinarians", tabHeader, "Correct tab name - Veterinarians");
	}

	@Then("^I find all veterinarians list and verify names$")
	public void i_find_all_veterinarians_list_and_verify_names() throws Throwable {
		//No.of rows 
        @SuppressWarnings("rawtypes")
		List rows = TestRunner.driver.findElements(By.xpath("//*[@id=\"vets\"]/tbody/tr/td[1]")); 
        List<String> VeterinariansList = new ArrayList<String>();
        for(int i=1;i<=rows.size();i++)
        {
        	VeterinariansList.add(TestRunner.driver.findElement(By.xpath("//tbody/tr["+i+"]/td[1]")).getText());
        }
        System.out.println(VeterinariansList);
	}
}
