package automation.enboard.pages;

import org.openqa.selenium.WebDriver;

import automation.enboard.common.BasePage;

public class HomePage extends BasePage{
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
