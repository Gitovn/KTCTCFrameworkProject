package com.uiFramework.KTCTC.Pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.uiFramework.KTCTC.helper.action.ActionHelper;
import com.uiFramework.KTCTC.helper.javaScript.JavaScriptHelper;
import com.uiFramework.KTCTC.helper.logger.LoggerHelper;
import com.uiFramework.KTCTC.helper.wait.WaitHelper;
import com.uiFramework.KTCTC.helper.window.WindowHelper;

public class AmazonPage {

	private Logger log = LoggerHelper.getLogger(AmazonPage.class);
	private WebDriver driver;
	private ActionHelper actionHelper;
	private WaitHelper waitHelper;
	private WindowHelper windowHelper;
	private JavaScriptHelper javaScriptHelper;
	

	// elements on home page
	By accountsAndListsOnHomePage = By.id("nav-link-accountList");
	By searchBoxOnAmazonHomePage = By.id("twotabsearchtextbox");

	// elements under Accounts and Lists
	By signInButtonUnderAccountsAndList = By.xpath("//*[@id='nav-flyout-ya-signin']//*[contains(text(),'Sign in')]");
	By newAccountLinkUnderAccountsAndList = By
			.xpath("//*[@id='nav-flyout-ya-newCust']/*[contains(text(),'Start here')]");

	// elements to create account
	By createYourAmazonAccountButtonOnSignInPage = By.id("createAccountSubmit");
	By yourNameToCreateAccount = By.id("ap_customer_name");
	By mobileOrEmailToCreateAndSignInAccount = By.id("ap_email"); // to create & sign in account
	By passwordToCreateAndSignInAccount = By.id("ap_password");
	By repeatPasswordToCreateAccount = By.id("ap_password_check");
	By continueButtonOnCreateAccountPage = By.id("continue");
	By signInButtonToSignInUsersAccount = By.id("signInSubmit");
	By signOutButton = By.id("nav-item-signout");

	// elements on home page to apply filter
	By checkBoxToSelectBrandOnHomePage = By.xpath("//*[@id='p_89/Vivo']//*[contains(text(),'Vivo')]");
	By priceRangeLinkOnHomePage = By.id("p_36/1318507031");
	By lowPriceRangeTextBoxOnHomePage = By.id("low-price");
	By highPriceRangeTextBoxOnHomePage = By.id("high-price");
	By goButtonToApplyPriceRange = By.className("a-button-input");
	By linkToGetRequiredMobile = By.xpath(
			"//*[contains(text(),'Vivo X50 (Frost Blue, 8GB RAM, 128GB Storage) with No Cost EMI/Additional Exchange Offers')]");

	// elements on page when mobile is selected
	By selectColorOfMobile = By.id("a-autoid-15-announce");
	By selectRamAndStorageOfMobile = By
			.xpath("//*[@class='a-button-text']//*[contains(text(),'12GB RAM|256GB Storage')]");
	By originalPriceOfItem = By.xpath("//*[contains(text(),'M.R.P.:')]/following-sibling::td");
	By discountedPriceOfItem = By.xpath("//*[contains(text(),'Price:')]/following-sibling::td");
	By moneySavedOnItem = By.xpath("//*[contains(text(),'  You Save: ')]/following-sibling::td");
	By addToCartButton = By.id("add-to-cart-button");
	By cartContainer = By.id("nav-cart-count-container");
	By goToCartButton = By.className("a-button-input");
	By toReadItemFromCart = By.className("a-truncate-cut");
	By itemAddedToWishlistMessage = By
			.xpath("//*[@id='huc-atwl-header-section']//*[contains(text(),'One item added to')]");
	By nameOfItemAddedToWishlist = By.id("huc-item-link");

	public AmazonPage(WebDriver driver) {
		this.driver = driver;
		actionHelper = new ActionHelper(driver);
		waitHelper = new WaitHelper(driver);
		windowHelper = new WindowHelper(driver);
		javaScriptHelper = new JavaScriptHelper(driver);

	}

	public void navigateToAmazonsLoginPage() {
		log.info("Navigating to amazon login page ....");
		actionHelper.moveToElement(driver.findElement(accountsAndListsOnHomePage));
		waitHelper.pageLoadTime(3, TimeUnit.SECONDS);
		driver.findElement(signInButtonUnderAccountsAndList).click();
		// waitHelper.pageLoadTime(3, TimeUnit.SECONDS);
		log.info("User navigated successfully to amazon login page ....");

	}

	public void loginToUsersExistingAmazonAccount(String email, String password) {

		log.info("Logging in to users existing account & navigating to home page .....");
		navigateToAmazonsLoginPage();
		driver.findElement(mobileOrEmailToCreateAndSignInAccount).sendKeys(email);
		driver.findElement(continueButtonOnCreateAccountPage).click();
		// waitHelper.pageLoadTime(3, TimeUnit.SECONDS);

		driver.findElement(passwordToCreateAndSignInAccount).sendKeys(password);
		driver.findElement(signInButtonToSignInUsersAccount).click();
		// waitHelper.pageLoadTime(3, TimeUnit.SECONDS);
		log.info("User successfully navigated to Amazon Home page");

	}

	public boolean isUserSuccessfullyLoggedIn() {
		log.info("Checking user logged to existing account......");
		boolean flag = false;
		try {
			waitHelper.pageLoadTime(10, TimeUnit.SECONDS);
			actionHelper.moveToElement(driver.findElement(accountsAndListsOnHomePage));
			flag = driver.findElement(signOutButton).isDisplayed();
			log.info("User is successfully logged in");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Please Enter valid credentials & try again");
		}
		return flag;

	}

	public void toCreateNewUserAccount(String name, String mobileOrEmail, String password) {
		log.info("creating new user account on amazon....");
		navigateToAmazonsLoginPage();
		driver.findElement(createYourAmazonAccountButtonOnSignInPage).click();
		// waitHelper.pageLoadTime(3, TimeUnit.SECONDS);
		driver.findElement(yourNameToCreateAccount).sendKeys(name);
		driver.findElement(mobileOrEmailToCreateAndSignInAccount).sendKeys(mobileOrEmail);
		driver.findElement(passwordToCreateAndSignInAccount).sendKeys(password);
		driver.findElement(repeatPasswordToCreateAccount).sendKeys(password);
		driver.findElement(continueButtonOnCreateAccountPage).click();

		log.info("users account successfully created on amazon....");
	}

	public void selectItemFromList() {

		log.info("selecting mobile And adding it to cart ....");
		driver.findElement(searchBoxOnAmazonHomePage).sendKeys("vivo x50");
		driver.findElement(searchBoxOnAmazonHomePage).sendKeys(Keys.ENTER);
		// driver.findElement(checkBoxToSelectBrandOnHomePage).click();
		// driver.findElement(lowPriceRangeTextBoxOnHomePage).sendKeys("20000");
		// driver.findElement(highPriceRangeTextBoxOnHomePage).sendKeys("40000");
		// driver.findElement(goButtonToApplyPriceRange).click();
		javaScriptHelper.clickElement(driver.findElement(linkToGetRequiredMobile));
		windowHelper.switchToWindow(2);

	}

	public void addItemToCart() {
		log.info("adding item to cart....");
		// actionHelper.moveToElementAndClick(driver.findElement(selectColorOfMobile));
		// waitHelper.pageLoadTime(5, TimeUnit.SECONDS);
		// actionHelper.click(driver.findElement(selectRamAndStorageOfMobile));
		// waitHelper.pageLoadTime(5, TimeUnit.SECONDS);
		// getOriginalDiscountedPriceOfItem();
		driver.findElement(addToCartButton).click();
		log.info("Item added successfully to cart");
	}

	public boolean isUserSelectedItemAddedToCart() {
		log.info("Checking the item from Cart......");
		boolean flag = false;

		actionHelper.click(driver.findElement(cartContainer));
		String itemName = driver.findElement(toReadItemFromCart).getText();
		waitHelper.pageLoadTime(5, TimeUnit.SECONDS);
		if (itemName.startsWith("Vivo X50")) {
			flag = true;
			log.info("item is added to Cart");

		} else {
			log.info("item is not added to Cart");
		}
		return flag;

	}

	public void getOriginalDiscountedPriceOfItem() {
		log.info("getting original, discounted & discount on original price...");
		
		String originalAmount = driver.findElement(originalPriceOfItem).getText();
		waitHelper.waitForElement(driver.findElement(originalPriceOfItem), 10);
		waitHelper.pageLoadTime(10, TimeUnit.SECONDS);
		System.out.println("M.R.P. = " + originalAmount);
		String discountedAmount = driver.findElement(discountedPriceOfItem).getText();
		System.out.println("Discounted price of item is = " + discountedAmount);
		String savedAmount = driver.findElement(moneySavedOnItem).getText();
		System.out.println("Your saving on total amount of item is = " + savedAmount);
	}

}
