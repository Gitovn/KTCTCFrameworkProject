package com.uiFramework.KTCTC.helper.action;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.uiFramework.KTCTC.helper.logger.LoggerHelper;

public class ActionHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(ActionHelper.class);

	public ActionHelper(WebDriver driver) {
		this.driver = driver;
		log.info("ActionHelper has been initialized.....");
	}

	// this method move to the element
	public void moveToElement(WebElement element) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		log.info("element is clicked: " + element.toString());
	}

	// this method will click on element which is passed as method argument
	public void click(WebElement element) {

		Actions actions = new Actions(driver);
		actions.click(element).build().perform();
		log.info("element is clicked: " + element.toString());
	}

	// this method moves to the element & click on it
	public void moveToElementAndClick(WebElement element) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		log.info("element is clicked: " + element.toString());
	}

	// this method is used to right click on element
	public void rightClickOnElement(WebElement element) {

		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
		log.info("element is clicked: " + element.toString());
	}

	// this method is used to double click on element
	public void doubleClickOnElement(WebElement element) {

		Actions actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
		log.info("element is clicked: " + element.toString());
	}

}
