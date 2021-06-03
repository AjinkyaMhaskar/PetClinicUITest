package test.java.commonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.java.runner.TestRunner;

public class CommonUIFunctions {

	public static void implicitWait(int time) {
		TestRunner.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(TestRunner.driver, 3000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// To wait for element visible by xpath
	public static void waitWithXpath(String xpath) {
		try {
			WebDriverWait wait = new WebDriverWait(TestRunner.driver, 30);
			wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))));
			System.out.println("Element is visible now : " + xpath);
		} catch (Exception e) {
			System.out.println("Element is not visible : " + xpath);
		}
	}

	// To wait for element visible by id
	public static void waitWithid(String id) {
		try {
			WebDriverWait wait = new WebDriverWait(TestRunner.driver, 30);
			wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.id(id))));
			System.out.println("Element is visible now : " + id);
		} catch (Exception e) {
			System.out.println("Element is not visible : " + id);
		}
	}

	// Count number of elements by xpath
	public static int countNumber(String xpath) {
		int count = TestRunner.driver.findElements(By.xpath(xpath)).size();
		return count;
	}
}
