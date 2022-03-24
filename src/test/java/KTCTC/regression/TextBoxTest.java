package KTCTC.regression;


import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.model.Log;
import com.uiFramework.KTCTC.Pages.TextBoxPage;
import com.uiFramework.KTCTC.testbase.TestBase;

public class TextBoxTest extends TestBase {

	TextBoxPage textBoxPage;
	String fullName = cmObj.getcharacterString(5) + " " + cmObj.getcharacterString(5) + " "
			+ cmObj.getcharacterString(7);
	String email = cmObj.getcharacterString(4) + "@" + cmObj.getcharacterString(5) + ".com";
	String crrAddress = cmObj.getcharacterString(4) + " " + cmObj.getcharacterString(6) + " "
			+ cmObj.getcharacterString(3);
	String perAddress = cmObj.getcharacterString(3) + " " + cmObj.getcharacterString(4) + " "
			+ cmObj.getcharacterString(5);

	@Test(priority = 1)
	public void verifyUserCanNavigateToTextBoxPage() {

		textBoxPage = new TextBoxPage(driver);
		cmObj.navigateToReQuiredPage(driver, "Elements");
		textBoxPage.navigateToTextBoxPage();
	}

	@Test(priority = 2)
	public void verifyNewUserDetailsCanBeAddedOnTextBoxPage() {

		textBoxPage.addInfoOnTextBoxPage(fullName, email, crrAddress, perAddress);
		boolean flag = textBoxPage.isUserWithProvidedEmailIdDisplayed(email);
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void verifyAllDetailsOfNewlyAddedUser() {

		HashMap<String, String> details = textBoxPage.getAllDetailsOfProvidedUse();
		Assert.assertEquals(fullName, details.get("Full Name"));
		Assert.assertEquals(email, details.get("Email"));
		Assert.assertEquals(crrAddress, details.get("Current Address"));
		Assert.assertEquals(perAddress, details.get("Permanent Address"));

	}

}
