package KTCTC.regression;

import java.util.HashMap;

import javax.xml.crypto.Data;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.uiFramework.KTCTC.Pages.WebTablesPage;
import com.uiFramework.KTCTC.testbase.TestBase;

public class WebTablesTest extends TestBase {

	WebTablesPage webTablesPage;
	String fname = cmObj.getcharacterString(5);
	String lname = cmObj.getcharacterString(7);
	String email = cmObj.getcharacterString(4) + "@" + cmObj.getcharacterString(5) + ".com";
	String age = cmObj.getNumericString(2);
	String salary = cmObj.getNumericString(8);
	String department = cmObj.getcharacterString(5);

	String newFname = cmObj.getcharacterString(5);
	String newLname = cmObj.getcharacterString(7);
	String newEmail = cmObj.getcharacterString(4) + "@" + cmObj.getcharacterString(5) + ".com";
	String newAge = cmObj.getNumericString(2);
	String newSalary = cmObj.getNumericString(8);
	String newDepartment = cmObj.getcharacterString(5);

	@Test(priority = 1)
	public void verifyUserCanNavigateToWebTablesPage() {
		webTablesPage = new WebTablesPage(driver);
  		cmObj.navigateToReQuiredPage(driver, "Element");
		webTablesPage.navigateToWebTablePage();
	}

	@Test(priority = 2)
	public void verifyNewUserCanBeAddedOnWebTablePage() {

		webTablesPage.addingNewUserOnWebTablePage(fname, lname, email, age, salary, department);
		boolean flag = webTablesPage.isUserWithProvidedEmailIdDisplayed(email);
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void verifyAllDetailsOfNewlyAddedUser() {

		HashMap<String, String> details = webTablesPage.getAllDetailsOfProvidedUser(email);

		Assert.assertEquals(fname, details.get("FirstName"));
		Assert.assertEquals(lname, details.get("LastName"));
		Assert.assertEquals(email, details.get("Email"));
		Assert.assertEquals(age, details.get("Age"));
		Assert.assertEquals(salary, details.get("Salary"));
		Assert.assertEquals(department, details.get("Department"));

	}

	@Test(priority = 4)
	public void verifyExistingUserCanBeEdited() {
		webTablesPage.editExistingUserWithProvidedDetails(email, newFname, newLname, newEmail, newAge,
				newSalary, newDepartment);
		boolean flag = webTablesPage.isUserWithProvidedEmailIdDisplayed(newEmail);
		Assert.assertTrue(flag);
	}

	@Test(priority = 5)
	public void verifyAllDetailsOfEditedUser() {
		HashMap<String, String> details = webTablesPage.getAllDetailsOfProvidedUser(newEmail);

		Assert.assertEquals(newFname, details.get("FirstName"));
		Assert.assertEquals(newLname, details.get("LastName"));
		Assert.assertEquals(newEmail, details.get("Email"));
		Assert.assertEquals(newAge, details.get("Age"));
		Assert.assertEquals(newSalary, details.get("Salary"));
		Assert.assertEquals(newDepartment, details.get("Department"));

	}

	@Test(priority = 6)
	public void verifyExistingUserCanBeDeleted() {
		webTablesPage.deleteExistingUserWithProvidedDetails(newEmail);
		boolean flag = webTablesPage.isUserWithProvidedEmailIdDisplayed(newEmail);
		Assert.assertFalse(flag);

	}
}
