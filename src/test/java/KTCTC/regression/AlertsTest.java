package KTCTC.regression;

import org.testng.annotations.Test;

import com.uiFramework.KTCTC.Pages.AlertsPage;
import com.uiFramework.KTCTC.testbase.TestBase;

public class AlertsTest extends TestBase {
	AlertsPage alertsPage;

	@Test(priority = 1)
	public void verifyUserCanNavigateToAlertsPage() {
		alertsPage = new AlertsPage(driver);
		cmObj.navigateToReQuiredPage(driver, "Alerts, Frame & Windows");
		alertsPage.navigateToAlertsPage();

	}

	@Test(priority = 2)
	public void verifyUserCanClickOnAlertButton() {
		alertsPage.clickOnButtonToSeeAlertAndAcceptIt();
		alertsPage.waitForAlertToBeVisible();
		alertsPage.clickOnAlertToPerformAction();
		alertsPage.clickOnButtonToEnterPromptText();
	}

}
