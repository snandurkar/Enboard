package automation.enboard.common;

import org.openqa.selenium.WebDriver;

public class BasePage {
	protected BrowserActions actions;
	WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver = driver;
		actions = new BrowserActions(driver);
		
	}
}
