package KTCTC.regression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uiFramework.KTCTC.Pages.StudentRegistrationFormPage;
import com.uiFramework.KTCTC.helper.excel.ExcelHelper;
import com.uiFramework.KTCTC.helper.excel.ExcelHelper2;
import com.uiFramework.KTCTC.helper.property.PropertyFileHelper;
import com.uiFramework.KTCTC.testbase.TestBase;

public class StudentRegistrationFormTest extends TestBase {

	StudentRegistrationFormPage studentRegistrationForm;

	@Test(priority = 1)
	public void verifyUserCanNavigateToStudentsRegFormPage() {

		studentRegistrationForm = new StudentRegistrationFormPage(driver);
		cmObj.navigateToReQuiredPage(driver, "Forms");
		studentRegistrationForm.navigateToStudentRegistrationFormPage();
	}
	
	@DataProvider (name = "getTestData")
	public Object[][] provideMultipleTestData() {
		ExcelHelper2 excelHelper = new ExcelHelper2();
		Object[][] data = excelHelper.getExcelData("C:\\Users\\A\\eclipse-workspace\\ABCD-main\\ABCD-main\\src\\main\\resources\\ExcelFile\\MultipleData.xlsx", "AllDetails");
		return data;
	}
	
	@Test(dataProvider = "getTestData")
	public void verifyNewStudentsInfoCanBeAddedOnFormPage(String firstName, String lastName, String email, String gender, Double mobile, Double date, String subjects, String hobbies, String picture, String currentAddress, String state, String city) {
		
	}
}

	