package automation.enboard.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import automation.enboard.common.AutoLogger;
import automation.enboard.common.BasePage;

public class PersonalDetailsPage extends BasePage{

	public PersonalDetailsPage(WebDriver driver, AutoLogger handler) {
		super(driver);
		PageFactory.initElements(driver, this);
		super.handler = handler;
		handler.setCurrentPageClass(this.getClass());
	}
	
	@FindBy(id = "PD_txtFatherName")
	private WebElement fatherNameTextBox;
	
	@FindBy(id = "PD_ddlNationality")
	private WebElement natinalityDropDown;
	
	@FindBy(id = "PD_ddlBloodGroup")
	private WebElement bloodGroupDropDown;
	
	@FindBy(id = "PD_ddlMaritalStatus")
	private WebElement maritalStatusDropDown;
	
	@FindBy(id = "PD_txtSpouseName")
	private WebElement spouseNameTextBox;
	
	@FindBy(id = "PD_ddlMotherTongue")
	private WebElement motherTongueDropDown;
	
	@FindBy(id = "PD_txtPANNumber")
	private WebElement panNumberTextBox;
	
	@FindBy(id = "PD_txtUANNumber")
	private WebElement uanNumberTextBox;
	
	@FindBy(id = "PD_txtAadharCardNumber")
	private WebElement aadharCardNumberTextBox;
	
	@FindBy(id = "PD_lstPlaceofBirthState")
	private WebElement birthPlaceStateDropDown;
	
	@FindBy(id = "PD_lstPlaceofBirthCity")
	private WebElement birthPlaceCityDropDown;
	
	@FindBy(id = "PD_txtPassportNumber")
	private WebElement passportNumberTextBox;
	
	@FindBy(id = "PD_txtPassportExpiryDate")
	private WebElement passportExpiryDateCalender;
	
	@FindBy(id = "PD_SaveId")
	private WebElement saveDetailsButton;
	
	@FindBy(id = "PD_txtNameOnPassport")
	private WebElement nameOnPassportTextBox;
	
	@FindBy(id = "a[href='/User/PersonalDetails']")
	private WebElement personalDetailsTab;
	
	public void clickOnPersonalDetailsTab(){
		personalDetailsTab.click();
	}
	
	public void fillPersonalDetails(Map<String, String> personalDetails){
		fatherNameTextBox.sendKeys(personalDetails.get("FatherName"));
		new Select(natinalityDropDown).selectByVisibleText(personalDetails.get("Nationality"));
		new Select(bloodGroupDropDown).selectByVisibleText(personalDetails.get("BloodGroup"));
		
		new Select(maritalStatusDropDown).selectByVisibleText(personalDetails.get("MaritalStatus"));
		spouseNameTextBox.sendKeys(personalDetails.get("SpouseName"));
		new Select(motherTongueDropDown).selectByVisibleText(personalDetails.get("MotherTongue"));
		
		panNumberTextBox.sendKeys(personalDetails.get("PanNumber"));
		aadharCardNumberTextBox.sendKeys(personalDetails.get("AadharCardNumber"));
		uanNumberTextBox.sendKeys(personalDetails.get("UANNumber"));
		
		passportNumberTextBox.sendKeys(personalDetails.get("PassPortNumber"));
		nameOnPassportTextBox.sendKeys(personalDetails.get("NameOnPassword"));
		passportExpiryDateCalender.sendKeys(personalDetails.get("ExpiryDateOnPassport"));
		
		new Select(birthPlaceStateDropDown).selectByVisibleText(personalDetails.get("BirthState"));
		new Select(birthPlaceCityDropDown).selectByVisibleText(personalDetails.get("BirthCity"));
		
		saveDetailsButton.click();
	}
	
	public Map<String, String> getPersonalDetails(){
		Map<String, String> personalDetails = new HashMap<String, String>();
		personalDetails.put("FatherName", "testFName");
		personalDetails.put("Nationality", "India");
		personalDetails.put("BloodGroup", "B+");
		personalDetails.put("SpouseName", "testSName");
		personalDetails.put("MotherTongue", "Marathi");
		personalDetails.put("AadharCardNumber", "112367899778");
		personalDetails.put("UANNumber", "767878784");
		personalDetails.put("PassPortNumber", "KMH5640JK3+");
		personalDetails.put("NameOnPassword", "testPName");
		personalDetails.put("ExpiryDateOnPassport", "18/12/2019");
		personalDetails.put("BirthState", "Maharastra");
		personalDetails.put("BirthCity", "Pune");
		return personalDetails;
	}
	
	public boolean verifyUpdatedPersonalDetails(Map<String, String> personalDetails){
		return personalDetails.get("FatherName").equalsIgnoreCase(fatherNameTextBox.getText());
	}

}
