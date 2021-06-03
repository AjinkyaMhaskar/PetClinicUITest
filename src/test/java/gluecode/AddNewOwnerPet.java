package test.java.gluecode;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.java.commonFunctions.CommonUIFunctions;
import test.java.dataProviders.ConfigFileReader;
import test.java.runner.TestRunner;

public class AddNewOwnerPet {
	
	@When("^I click on Add Owner button$")
	public void i_click_on_Add_Owner_button() throws Throwable {
		TestRunner.driver.findElement(By.xpath("//a[contains(text(),'Add Owner')]")).click();
		CommonUIFunctions.waitWithXpath("//h2[contains(text(),'Owner')]");
	}
	

	@When("^I click on Add Owner button again$")
	public void i_click_on_Add_Owner_button_again() throws Throwable {
		TestRunner.driver.findElement(By.xpath("//button[contains(text(),'Add Owner')]")).click();
		CommonUIFunctions.waitWithXpath("//h2[contains(text(),'Owner Information')]");
	}

	@When("^Add Owner details$")
	public void add_Owner_details() throws Throwable {
		TestRunner.driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(ConfigFileReader.getOwnerName());
		TestRunner.driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(ConfigFileReader.getOwnerLastName());
		TestRunner.driver.findElement(By.xpath("//input[@id='address']")).sendKeys(ConfigFileReader.getOwnerAddress());
		TestRunner.driver.findElement(By.xpath("//input[@id='city']")).sendKeys(ConfigFileReader.getOwnerCity());
		TestRunner.driver.findElement(By.xpath("//input[@id='telephone']")).sendKeys(ConfigFileReader.getOwnerTelephone());
	}
	
	@Given("^I click on Add New Pet button$")
	public void i_click_on_Add_New_Pet_button() throws Throwable {
		TestRunner.driver.findElement(By.xpath("//a[contains(text(),'New Pet')]")).click();
		CommonUIFunctions.waitWithXpath("//h2[contains(text(),'Pet')]");
	}

	@And("^Add Pet details$")
	public void add_Pet_details() throws Throwable {
		TestRunner.driver.findElement(By.xpath("//input[@id='name']")).sendKeys(ConfigFileReader.getPetName());
		TestRunner.driver.findElement(By.xpath("//input[@id='birthDate']")).sendKeys(ConfigFileReader.getPetDOB());
		
		Select petType = new Select(TestRunner.driver.findElement(By.xpath("//select[@id='type']")));
		petType.selectByVisibleText(ConfigFileReader.getPetType());
	}

	@Then("^I click on Add Pet button again$")
	public void i_click_on_Add_Pet_button() throws Throwable {
		TestRunner.driver.findElement(By.xpath("//button[contains(text(),'Add Pet')]")).click();
		CommonUIFunctions.waitWithXpath("//h2[contains(text(),'Owner Information')]");
	}
}
