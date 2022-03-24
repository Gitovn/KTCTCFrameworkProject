package com.uiFramework.KTCTC.Pages;

import java.util.HashMap;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.uiFramework.KTCTC.helper.logger.LoggerHelper;
import com.uiFramework.KTCTC.helper.wait.WaitHelper;
import com.uiFramwork.KTCTC.ObjectPages.WebTablesObjectPage;

public class WebTablesPage2 {

	private Logger log = LoggerHelper.getLogger(WebTablesPage2.class);
	By webTablePageLink = By.xpath("//*[contains(@id,'item')]/*[contains(text(),'Web')]");
	private WebDriver driver;

	// add button
	By addButtonOnWebTablesPage = By.id("addNewRecordButton");
	// Registration form details
	By firstNameOnRegistrationPage = By.id("firstName");
	By lastNameOnRegistrationPage = By.id("lastName");
	By emailOnRegistrationPage = By.id("userEmail");
	By ageOnRegistrationPage = By.id("age");
	By salaryOnRegistrationPage = By.id("salary");
	By departmentOnRegistrationPage = By.id("department");
	By submitButtonOnRegistrationPage = By.id("submit");
	// search box
	By searchBoxOnWebTablesPage = By.id("searchBox");
	// edit button
	By editButtonOnWebTablesPage = By.xpath("//*[contains(@id,'edit-record')]");
	// delete button
	By deleteButtonOnWebTablesPage = By.xpath("//*[contains(@id,'delete-record')]");

	public WebTablesPage2(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToWebTablePage() {
		log.info("Navigating to webtable page.....");

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[contains(@id,'item')]/*[contains(text(),'Dynamic')]")))
				.build().perform();
		driver.findElement(webTablePageLink).click();
		log.info("Navigated to webtable page successfully");
	}

	public void addNewUserOnWebTablePage(WebTablesObjectPage obj) {
		log.info("Adding new user to webtable page...");
		driver.findElement(addButtonOnWebTablesPage).click();
		WaitHelper wt = new WaitHelper(driver);
		wt.WaitForElementVisibleWithPollingTime(driver.findElement(firstNameOnRegistrationPage), 5, 200);
		driver.findElement(firstNameOnRegistrationPage).sendKeys(obj.getfName());
		driver.findElement(lastNameOnRegistrationPage).sendKeys(obj.getlName());
		driver.findElement(emailOnRegistrationPage).sendKeys(obj.getEmail());
		driver.findElement(ageOnRegistrationPage).sendKeys(obj.getAge());
		driver.findElement(salaryOnRegistrationPage).sendKeys(obj.getSalary());
		driver.findElement(departmentOnRegistrationPage).sendKeys(obj.getDepartment());
		driver.findElement(submitButtonOnRegistrationPage).click();
		log.info("New user added successfully");
	}

	public void searchStringInSearchBox(String email) {
		log.info("searching provided string in search box .....");
		driver.findElement(searchBoxOnWebTablesPage).clear();
		driver.findElement(searchBoxOnWebTablesPage).sendKeys(email);
		log.info("Searched provided string in search box = " + email);
	}

	public boolean isUserWithProvidedEmailIdDisplayed(String email) {
		searchStringInSearchBox(email);

		boolean flag = false;

		try {
			flag = driver.findElement(By.xpath("//*[contains(text(),'" + email + "')]")).isDisplayed();
			log.info("Provided user is displayed on webtable page ....");

		} catch (Exception e) {
			log.info("Provided user is not displayed on webtable page");
		}
		return flag;
	}

	public HashMap<String, String> getAllDetailsOfProvidedUser(String email) {
		log.info("Getting all details of provided user ....");
		searchStringInSearchBox(email);
		HashMap<String, String> data = new HashMap<String, String>();

		data.put("FirstName", driver
				.findElement(By.xpath("//*[contains(text(),'" + email + "')]/preceding-sibling::div[3]")).getText());
		data.put("LastName", driver
				.findElement(By.xpath("//*[contains(text(),'" + email + "')]/preceding-sibling::div[2]")).getText());
		data.put("Age", driver.findElement(By.xpath("//*[contains(text(),'" + email + "')]/preceding-sibling::div[1]"))
				.getText());
		data.put("Email", driver.findElement(By.xpath("//*[contains(text(),'" + email + "')]")).getText());
		data.put("Salary", driver
				.findElement(By.xpath("//*[contains(text(),'" + email + "')]/following-sibling::div[1]")).getText());
		data.put("Department", driver
				.findElement(By.xpath("//*[contains(text(),'" + email + "')]/following-sibling::div[2]")).getText());
		log.info("User details are provided successfully");
		return data;
	}

	public void editExistingUserWithProvidedDetails(WebTablesObjectPage obj, WebTablesObjectPage objNew) {
		log.info("Editing existing user with provided detail...");
		searchStringInSearchBox(obj.getEmail());
		driver.findElement(editButtonOnWebTablesPage).click();
		WaitHelper wt = new WaitHelper(driver);
		wt.WaitForElementVisibleWithPollingTime(driver.findElement(firstNameOnRegistrationPage), 5, 200);

		driver.findElement(firstNameOnRegistrationPage).clear();
		driver.findElement(firstNameOnRegistrationPage).sendKeys(objNew.getfName());
		driver.findElement(lastNameOnRegistrationPage).clear();
		driver.findElement(lastNameOnRegistrationPage).sendKeys(objNew.getlName());
		driver.findElement(emailOnRegistrationPage).clear();
		driver.findElement(emailOnRegistrationPage).sendKeys(objNew.getEmail());
		driver.findElement(ageOnRegistrationPage).clear();
		driver.findElement(ageOnRegistrationPage).sendKeys(objNew.getAge());
		driver.findElement(salaryOnRegistrationPage).clear();
		driver.findElement(salaryOnRegistrationPage).sendKeys(objNew.getSalary());
		driver.findElement(departmentOnRegistrationPage).clear();
		driver.findElement(departmentOnRegistrationPage).sendKeys(objNew.getDepartment());
		driver.findElement(submitButtonOnRegistrationPage).click();
		log.info("User is edited successfully");
	}

	public void deleteExistingUserWithProvidedDetails(WebTablesObjectPage objNew) {
		log.info("Deleting user with provided details....");
		searchStringInSearchBox(objNew.getEmail());
		driver.findElement(deleteButtonOnWebTablesPage).click();
		log.info("Existing user with provided details is deleted");
	}

}
