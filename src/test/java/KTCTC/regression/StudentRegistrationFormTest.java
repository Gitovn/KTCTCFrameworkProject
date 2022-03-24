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

	/*
	 * @DataProvider(name = "getValueFromPropertyFile") public Object[][]
	 * provideStudentsDetailsInKeyValuePair() {
	 * 
	 * PropertyFileHelper propertyHelper = new
	 * PropertyFileHelper("Students Details.properties"); HashMap<String, String>
	 * data = new HashMap<String, String>(); Object[][] file = new Object[0][12];
	 * int i =0; for(Entry<String, String> each:data.entrySet()) { file[i][0] =
	 * data.put(key, value) file[i][1] = each.getValue();
	 * 
	 * file[i][0] = each.getKey(); file[i][1] = each.getValue();
	 * 
	 * file[i][0] = each.getKey(); file[i][1] = each.getValue();
	 * 
	 * file[i][0] = each.getKey(); file[i][1] = each.getValue();
	 * 
	 * file[i][0] = each.getKey(); file[i][1] = each.getValue();
	 * 
	 * file[i][0] = each.getKey(); file[i][1] = each.getValue();
	 * 
	 * file[i][0] = each.getKey(); file[i][1] = each.getValue();
	 * 
	 * file[i][0] = each.getKey(); file[i][1] = each.getValue();
	 * 
	 * file[i][0] = each.getKey(); file[i][1] = each.getValue();
	 * 
	 * file[i][0] = each.getKey(); file[i][1] = each.getValue();
	 * 
	 * file[i][0] = each.getKey(); file[i][1] = each.getValue();
	 * 
	 * file[i][0] = each.getKey(); file[i][1] = each.getValue(); i++; }
	 * 
	 * String email = propertyHelper.getPropertyValueFromFile("Email"); String
	 * gender = propertyHelper.getPropertyValueFromFile("Gender"); String mbNo =
	 * propertyHelper.getPropertyValueFromFile("Mobile"); String dOB =
	 * propertyHelper.getPropertyValueFromFile("DateOfBirth"); String subject =
	 * propertyHelper.getPropertyValueFromFile("Subjects"); String hobby =
	 * propertyHelper.getPropertyValueFromFile("Hobbies"); String fileUpload =
	 * propertyHelper.getPropertyValueFromFile("Picture"); String crrAddress =
	 * propertyHelper.getPropertyValueFromFile("CurrentAddress"); String state =
	 * propertyHelper.getPropertyValueFromFile("State"); String city =
	 * propertyHelper.getPropertyValueFromFile("City");
	 * 
	 * return file; }
	 */

	@DataProvider(name = "getKeyValueFromHashmap")
	public String[][] provideStudentsDetailsInKeyValuePair() {
		ExcelHelper excelHelper = new ExcelHelper("MultipleData.xlsx", "StudentsInfo");
		ArrayList<String> keys = excelHelper.getKeysListFromExcel();
		ArrayList<String> values = excelHelper.getValuesListFromExcel();
		String[][] data = new String[keys.size()][2];

		for (int i = 0; i < keys.size(); i++) {
			data[i][0] = keys.get(i);
			data[i][1] = values.get(i);

		}

		return data;

	}

	@Test(dataProvider = "getKeyValueFromHashmap", dependsOnMethods = "verifyUserCanNavigateToStudentsRegFormPage")
	public void verifyNewStudentsInformationCanBeFilledOnRegForm(String key, String value) {

		//studentRegistrationForm.fillNewStudentsRegForm(fName, lName, email, gender, mbNo, dOB, subject, hobby,
			//	fileUpload, crrAddress, state, city);
		//studentRegistrationForm.isUserWithProvidedEmailIdDisplayed(email);
	}
}
