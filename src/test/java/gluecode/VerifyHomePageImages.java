package test.java.gluecode;

import static org.testng.Assert.assertEquals;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import test.java.commonFunctions.CommonUIFunctions;
import test.java.dataProviders.ConfigFileReader;
import test.java.runner.TestRunner;

public class VerifyHomePageImages {

	@Then("^I validate images on home page\\.$")
	public void i_validate_images_on_home_page() throws Throwable {
		CommonUIFunctions.waitWithXpath("//h2[contains(text(),'Welcome')]");
		List<WebElement> imgElement = TestRunner.driver.findElements(By.tagName("img"));
		
		// this will display list of all images exist on page and verify it with resource file
        for(WebElement ele:imgElement){
            assertEquals(ConfigFileReader.getImgresourceURL(), ele.getAttribute("src").substring(0, 39), "Correct URL source for Images");
        }
 			
	}
}
