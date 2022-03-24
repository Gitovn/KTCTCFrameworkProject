package com.uiFramework.KTCTC.Pages;

import java.util.HashMap;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.uiFramework.KTCTC.helper.logger.LoggerHelper;

public class TextBoxPage {

	private Logger log = LoggerHelper.getLogger(TextBoxPage.class);
	private WebDriver driver;

	By textBoxPageLink = By.xpath("//*[contains(text(),'Text Box')]");
	By fullNameOnTextBoxPage = By.id("userName");
	By emailOnTextBoxPage = By.id("userEmail");
	By currentAddressOnTextBoxPage = By.id("currentAddress");
	By permanentAddressOnTextBoxPage = By.id("permanentAddress");
	By submitButtonOnTextBoxPage = By.id("submit");

	public TextBoxPage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToTextBoxPage() {
		log.info("Navigating to Text box page ....");
		driver.findElement(textBoxPageLink).click();
		log.info("Navigated to Text box page successfully");

	}

	public void addInfoOnTextBoxPage(String name, String email, String crrAdd, String perAdd) {

		log.info("Adding info on Text box page....");
		driver.findElement(fullNameOnTextBoxPage).sendKeys(name);
		driver.findElement(emailOnTextBoxPage).sendKeys(email);
		driver.findElement(currentAddressOnTextBoxPage).sendKeys(crrAdd);
		driver.findElement(permanentAddressOnTextBoxPage).sendKeys(perAdd);
		driver.findElement(permanentAddressOnTextBoxPage).sendKeys(Keys.TAB);
		driver.findElement(submitButtonOnTextBoxPage).sendKeys(Keys.ENTER);
		log.info("New user added successfully");
	}

	public boolean isUserWithProvidedEmailIdDisplayed(String email) {

		boolean flag = false;
		String info = driver.findElement(By.id("email")).getText();
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

	public String toPrintOnlyEnteredUserDetails(String arg) {

		//String info = driver.findElement(By.id(arg)).getText();
		String[] argData = arg.split(":");
		String DataOutput = argData[1].toString();
		return DataOutput;
	}

	public HashMap<String, String> getAllDetailsOfProvidedUse() {

		log.info("Getting all details of provided user...");
		HashMap<String, String> data = new HashMap<String, String>();
		String fname = driver.findElement(By.id("name")).getText();
		String uEmail = driver.findElement(By.id("email")).getText();
		String crrAdd = driver.findElement(By.xpath("//*[@id='email']/following-sibling::p[1]")).getText();
		String perAdd = driver.findElement(By.xpath("//*[@id='email']/following-sibling::p[2]")).getText();

		data.put("Full Name", toPrintOnlyEnteredUserDetails(fname));
		data.put("Email", toPrintOnlyEnteredUserDetails(uEmail));
		data.put("Current Address", toPrintOnlyEnteredUserDetails(crrAdd));
		data.put("Permanent Address", toPrintOnlyEnteredUserDetails(perAdd));
		log.info("User details are provided successfully");
		return data;

	}

}
