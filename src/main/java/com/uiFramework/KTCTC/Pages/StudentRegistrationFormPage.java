package com.uiFramework.KTCTC.Pages;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiFramework.KTCTC.helper.logger.LoggerHelper;

public class StudentRegistrationFormPage {

	// in drop down values are directly passed in drop down text boxes

	private Logger log = LoggerHelper.getLogger(StudentRegistrationFormPage.class);
	private WebDriver driver;

	By practiseFormPageLink = By.xpath("//*[(@id='item-0')]//*[contains(text(),'Practice Form')]");
	By firstNameOnStudentRegPage = By.id("firstName");
	By lastNameOnStudentRegPage = By.id("lastName");
	By emailOnStudentRegPage = By.id("userEmail");
	By maleRadioButtonOnStudentRegPage = By.xpath("//*[contains(text(),'Male')]/preceding-sibling::input[1]");
	By femaleRadioButtonOnStudentRegPage = By.xpath("//*[contains(text(),'Female')]/preceding-sibling::input[1]");
	By otherRadioButtonOnStudentRegPage = By.xpath("//*[contains(text(),'Other')]/preceding-sibling::input[1]");
	By mobileOnStudentRegPage = By.id("userNumber");
	By dateOfBirthOnStudentRegPage = By.id("dateOfBirthInput");
	By subjectsOnStudentRegPage = By.id("subjectsContainer");
	By sportsOnStudentRegPage = By.xpath("//*[contains(text(),'Sports')]/preceding-sibling::input[1]");
	By readingOnStudentRegPage = By.xpath("//*[contains(text(),'Reading')]/preceding-sibling::input[1]");
	By musicOnStudentRegPage = By.xpath("//*[contains(text(),'Music')]/preceding-sibling::input[1]");
	By pictureOnStudentRegPage = By.id("uploadPicture");
	By currentAddressOnStudentRegPage = By.id("currentAddress");
	By stateOnStudentRegPage = By.id("state");
	By cityOnStudentRegPage = By.id("city");

	public StudentRegistrationFormPage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToStudentRegistrationFormPage() {
		log.info("Navigating to Student Registration Form Page.....");
		driver.findElement(practiseFormPageLink).click();
		log.info("Navigated to Student Registration Form page.");
	}

	public void fillNewStudentsRegForm(String fName, String lName, String email, String gender, String mbNo, String dOB,
			String subject, String hobby, String fileUpload, String crrAddress, String state, String city) {

		log.info("Filling all information of New User....");
		Actions action = new Actions(driver);
		driver.findElement(firstNameOnStudentRegPage).sendKeys(fName);
		driver.findElement(lastNameOnStudentRegPage).sendKeys(lName);
		driver.findElement(emailOnStudentRegPage).sendKeys(email);

		switch (gender) {
		case "Male":
			driver.findElement(maleRadioButtonOnStudentRegPage).click();
			break;

		case "Female":
			driver.findElement(femaleRadioButtonOnStudentRegPage).click();
			break;

		default:
			driver.findElement(otherRadioButtonOnStudentRegPage).click();
			break;
		}
		driver.findElement(mobileOnStudentRegPage).sendKeys(mbNo);
		driver.findElement(dateOfBirthOnStudentRegPage).sendKeys(dOB);
		driver.findElement(subjectsOnStudentRegPage).sendKeys(subject);

		switch (hobby) {
		case "Sports":
			driver.findElement(sportsOnStudentRegPage).click();
			break;

		case "Reading":
			driver.findElement(readingOnStudentRegPage).click();
			break;

		default:
			driver.findElement(musicOnStudentRegPage).click();
			break;
		}

		driver.findElement(pictureOnStudentRegPage).sendKeys(fileUpload);
		action.keyDown(Keys.TAB).keyUp(Keys.TAB).keyDown(Keys.ENTER).keyUp(Keys.ENTER);
		driver.findElement(currentAddressOnStudentRegPage).sendKeys(crrAddress);
		driver.findElement(stateOnStudentRegPage).sendKeys(state);
		driver.findElement(cityOnStudentRegPage).sendKeys(city);
		log.info("Information filled successfully");

	}

	public boolean isUserWithProvidedEmailIdDisplayed(String email) {
		boolean flag = false;
		String info = driver.findElement(By.xpath("//tbody//tr[2]")).getText();
		String[] emailData = info.split(":");
		String emailOutput = emailData[1].toString();
		if (email.equals(emailOutput)) {
			flag = true;
			log.info("Provided user is displayed on Text Box page");
		} else {
			log.info("Provided user is not displayed on Text Box page");
		}
		return flag;

	}

	public HashMap<String, String> getAllInformationOfStudent() {
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("Name", driver.findElement(By.xpath("//tbody//tr[1]")).getText());
		data.put("Email", driver.findElement(By.xpath("//tbody//tr[2]")).getText());
		data.put("Gender", driver.findElement(By.xpath("//tbody//tr[3]")).getText());
		data.put("Mobile No", driver.findElement(By.xpath("//tbody//tr[4]")).getText());
		data.put("Date of Birth", driver.findElement(By.xpath("//tbody//tr[5]")).getText());
		data.put("Subjects", driver.findElement(By.xpath("//tbody//tr[6]")).getText());
		data.put("Hobbies", driver.findElement(By.xpath("//tbody//tr[7]")).getText());
		data.put("Picture", driver.findElement(By.xpath("//tbody//tr[8]")).getText());
		data.put("Address", driver.findElement(By.xpath("//tbody//tr[9]")).getText());
		data.put("State & City", driver.findElement(By.xpath("//tbody//tr[10]")).getText());

		return data;
	}
}
