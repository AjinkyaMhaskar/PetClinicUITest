# Alef Education - Spring-petclinic application UI Test
## Selenium WebDriver, BDD(Cucumber)
## Tools:
- Eclipse
- Maven
- TestNG
- Selenium WebDriver
- Cucumber

## Maven dependencies: 
- Selenium WebDriver
- Cucumber
- TestNG
- Extent report

#### Application URLs:
>https://github.com/spring-projects/spring-petclinic

## Features:
- Crisp & Clear maven folder structures
- CucumberOptions with detailed explanation of using "tags", "glue"
- Screenshots on failure feature in CucumberRunner class
- TestNG Annotations/hooks like "Before, "BeforeSuite", "AfterClass", "AfterMethod", "AfterSuit" etc.
- Descriptive pom.xml and testng.xml
- Method to read data from configuration properties file

## BDD Style Development:
- Test Runner Main Class - PetClinicUITest\src\test\java\runner
- Feature file - PetClinicUITest\src\test\java\features
- Step Defination - PetClinicUITest\src\test\java\gluecode
- Common Functions - PetClinicUITest\src\test\java\commonFunctions
- Read Configuration File - PetClinicUITest\src\test\java\dataProviders
- Failure Screen-shots - PetClinicUITest\target\screenshots
- Extent report - PetClinicUITest\target\html\CustomExtentReport.html

## Explanation:
Test script receive its data from the property file "Configuration.properties". teardown method is used after every script failure, Screen shots are recorder for every method under "PetClinicUITest\target\screenshots". Once the test execution finish, Admin should navigate to "PetClinicUITest\target\html\CustomExtentReport.html" to review test results in custom extent report.

### To Run: 
```
Navigate to "PetClinicUITest\src\test\java\runner\TestRunner.java", Right-click and Run As "1 TestNG Test"
```