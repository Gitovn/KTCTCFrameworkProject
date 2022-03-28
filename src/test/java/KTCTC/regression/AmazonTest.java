package KTCTC.regression;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.uiFramework.KTCTC.Pages.AmazonPage;
import com.uiFramework.KTCTC.helper.property.PropertyFileHelper;
import com.uiFramework.KTCTC.testbase.TestBase;

public class AmazonTest extends TestBase {

	AmazonPage amazonPage;
	String userEmail;
	String userPassword;
	PropertyFileHelper propertyHelper = new PropertyFileHelper("env.properties");

	@Test (priority = 1)
	public void verifyUserCanLoginToExistingAccount() {

		amazonPage = new AmazonPage(driver);
		userEmail = propertyHelper.getPropertyValueFromFile("email");
		userPassword = propertyHelper.getPropertyValueFromFile("password");
		amazonPage.loginToUsersExistingAmazonAccount(userEmail, userPassword);
		boolean flag = amazonPage.isUserSuccessfullyLoggedIn();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void verifyUserRequiredItemIsAddetToCart() {
		amazonPage.selectItemFromList();
		amazonPage.getOriginalDiscountedPriceOfItem();
		amazonPage.addItemToCart();
		boolean flag = amazonPage.isUserSelectedItemAddedToCart();
		Assert.assertTrue(flag);
	}
	
}
