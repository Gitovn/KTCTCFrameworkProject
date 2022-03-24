package KTCTC.regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonTest {
	
	private WebDriver driver;
	
	By accountsAndListsOnHomePage = By.id("nav-link-accountList");
	By searchBoxOnAmazonHomePage = By.id("twotabsearchtextbox");
	By signInButtonUnderAccountsAndList = By.xpath("//*[@id='nav-flyout-ya-signin']//*[contains(text(),'Sign in')]");

}
