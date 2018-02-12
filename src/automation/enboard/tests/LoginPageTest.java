package automation.enboard.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.enboard.common.BaseTest;
import automation.enboard.pages.LoginPage;

public class LoginPageTest extends BaseTest{
	LoginPage loginPage;
	
	@Test
	public void loginTest(){
		//Arrangement
		loginPage = new LoginPage(eventDriver, handler);
		//Act
		loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		//Assert
		Assert.assertTrue(loginPage.isUserLoggedIn());
	}
}
