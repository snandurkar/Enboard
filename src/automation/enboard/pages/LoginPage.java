package automation.enboard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.enboard.common.BasePage;

public class LoginPage extends BasePage {
	
	@FindBy(css = "#Email")
	WebElement email;
	
	@FindBy(css = "#Password")
	WebElement password;
	
	@FindBy(css = "button[class='btn btn-lg btn-info waves-effect waves-light m-t-10']")
	WebElement loginBtn;
	
	@FindBy(name = "password")
	WebElement loggedInUser;
	
	public LoginPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username, String password){
		this.email.sendKeys(username);
		this.password.sendKeys(password);
		loginBtn.click();
	}
	
	public boolean isUserLoggedIn(){
		return actions.isDisplayed(loggedInUser);
	}

}
