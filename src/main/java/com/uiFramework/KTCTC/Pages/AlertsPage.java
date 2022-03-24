package com.uiFramework.KTCTC.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.KTCTC.helper.alert.AlertHelper;
import com.uiFramework.KTCTC.helper.javaScript.JavaScriptHelper;
import com.uiFramework.KTCTC.helper.logger.LoggerHelper;
import com.uiFramework.KTCTC.helper.wait.WaitHelper;

public class AlertsPage {

	private Logger log = LoggerHelper.getLogger(AlertsPage.class);
	private WebDriver driver;
	private AlertHelper alertHelper;
	JavaScriptHelper javaScriptHelper;

	By alertsPageLink = By.xpath("//*[@class='element-list collapse show']//*[contains(text(),'Alerts')]");
	By clickOnButtonForInstantAlert = By.id("alertButton");
	By waitForAlert5SecAfterClickOnButton = By.id("timerAlertButton");
	By clickOnAlertToTakeAction = By.id("confirmButton");
	By clickOnAlertToEnterTextInPromptBox = By.id("promtButton");

	public AlertsPage(WebDriver driver) {
		this.driver = driver;
		alertHelper = new AlertHelper(driver);
		javaScriptHelper = new JavaScriptHelper(driver);
	}

	public void navigateToAlertsPage() {
		log.info("Navigating to Alerts Page ....");
		javaScriptHelper.scrollIntoViewAndClick(driver.findElement(alertsPageLink));
		log.info("Navigated to Alerts Page");
	}

	public void clickOnButtonToSeeAlertAndAcceptIt() {
		log.info("User clicking on alert on Alerts page....");
		driver.findElement(clickOnButtonForInstantAlert).click();
		alertHelper.acceptAlert();
		log.info("User clicked on alert successfully");
	}

	public void waitForAlertToBeVisible() {
		log.info("User clicking on alert on Alerts page & wait for 5 seconds....");
		WaitHelper waitHelper = new WaitHelper(driver);
		driver.findElement(waitForAlert5SecAfterClickOnButton).click();
		waitHelper.waitUntilAlertIsPresent();
		alertHelper.acceptAlert();
		log.info("User clicked on alert on Alerts page");
	}

	public void clickOnAlertToPerformAction() {
		log.info("User clicking on alert on Alerts page....");
		driver.findElement(clickOnAlertToTakeAction).click();
		alertHelper.acceptAlert();
		String alertAcceptMessage = driver.findElement(By.id("confirmResult")).getText();
		System.out.println(alertAcceptMessage);

		driver.findElement(clickOnAlertToTakeAction).click();
		alertHelper.dismissAlert();
		String alertRejectMessage = driver.findElement(By.id("confirmResult")).getText();
		System.out.println("Alert text is :" + alertRejectMessage);
		log.info("User clicked on alert successfully");
	}

	public void clickOnButtonToEnterPromptText() {
		log.info("User clicking on alert on Alerts page....");
		javaScriptHelper.clickElement(driver.findElement(clickOnAlertToEnterTextInPromptBox));
		//driver.findElement(clickOnAlertToEnterTextInPromptBox).sendKeys("Hello World");
		alertHelper.acceptPrompt("Hello World");
		log.info("User clicked on alert successfully");
	}

}
