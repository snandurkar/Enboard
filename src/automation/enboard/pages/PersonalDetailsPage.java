package automation.enboard.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(xpath = "/html/body/div[1]/div/nav/ul/li[2]/a")
	private WebElement personalDetailsTab;
	
	public void clickOnPersonalDetailsTab(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		personalDetailsTab.click();
	}
	
	public void fillPersonalDetails(Map<String, String> personalDetails){
		actions.sendKeys(fatherNameTextBox, personalDetails.get("FatherName"));
		actions.selectDropdownByVisibleText(natinalityDropDown, personalDetails.get("Nationality"));
		actions.selectDropdownByVisibleText(bloodGroupDropDown, personalDetails.get("BloodGroup"));
		
		actions.selectDropdownByVisibleText(maritalStatusDropDown, personalDetails.get("MaritalStatus"));
		actions.sendKeys(spouseNameTextBox, personalDetails.get("SpouseName"));
		actions.selectDropdownByVisibleText(motherTongueDropDown, personalDetails.get("MotherTongue"));
		
		actions.sendKeys(panNumberTextBox, personalDetails.get("PanNumber"));
		actions.sendKeys(aadharCardNumberTextBox, personalDetails.get("AadharCardNumber"));
		actions.sendKeys(uanNumberTextBox, personalDetails.get("UANNumber"));
		
		actions.sendKeys(passportNumberTextBox, personalDetails.get("PassPortNumber"));
		actions.sendKeys(nameOnPassportTextBox, personalDetails.get("NameOnPassword"));
		actions.sendKeys(passportExpiryDateCalender, personalDetails.get("ExpiryDateOnPassport"));
		nameOnPassportTextBox.click();
		
		actions.selectDropdownByVisibleText(birthPlaceStateDropDown, personalDetails.get("BirthState"));
		actions.selectDropdownByVisibleText(birthPlaceCityDropDown, personalDetails.get("BirthCity"));
		
		//saveDetailsButton.click();
	}
	
	public Map<String, String> getPersonalDetails(){
		Map<String, String> personalDetails = new HashMap<String, String>();
		personalDetails.put("FatherName", "testFName");
		personalDetails.put("Nationality", "India");
		personalDetails.put("BloodGroup", "A+");
		personalDetails.put("SpouseName", "testSName");
		personalDetails.put("MaritalStatus", "Married");
		personalDetails.put("MotherTongue", "Marathi");
		personalDetails.put("AadharCardNumber", "112367899778");
		personalDetails.put("UANNumber", "767878784");
		personalDetails.put("PassPortNumber", "KMH5640JK3+");
		personalDetails.put("NameOnPassword", "testPName");
		personalDetails.put("ExpiryDateOnPassport", "18/12/2019");
		personalDetails.put("BirthState", "Maharashtra");
		personalDetails.put("BirthCity", "Pune");
		personalDetails.put("PanNumber", "76787876");
		return personalDetails;
	}
	
	public boolean verifyUpdatedPersonalDetails(Map<String, String> personalDetails){
		return personalDetails.get("FatherName").equalsIgnoreCase(fatherNameTextBox.getText());
	}

}
