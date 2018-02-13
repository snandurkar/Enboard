package automation.enboard.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.enboard.common.BaseTest;
import automation.enboard.pages.PersonalDetailsPage;

public class PersonalDetailsTest extends BaseTest{
	
	PersonalDetailsPage personalDetails;
	
	@Test
	public void loginTest(){
		//Arrangement
		personalDetails = new PersonalDetailsPage(eventDriver, handler);
		//Act
		personalDetails.clickOnPersonalDetailsTab();
		Map<String, String> userpersonalDetails = personalDetails.getPersonalDetails();
		personalDetails.fillPersonalDetails(userpersonalDetails);
		//Assert
		Assert.assertTrue(personalDetails.verifyUpdatedPersonalDetails(userpersonalDetails));
	}

}
