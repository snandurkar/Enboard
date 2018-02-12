package automation.enboard.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	protected Properties properties;
	Map<String, String> propertiesData = new HashMap<String, String>();
	protected WebDriver driver;
	
	@BeforeSuite
	public Properties getPropertiesData(){
		try{
			properties = new Properties();
			FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "\\Input data\\config.properties");
			properties.load(inputStream);
			return properties;
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
			return properties;
		} 
		catch (IOException e) {
			e.printStackTrace();
			return properties;
		}
	}
	
	@BeforeTest
	public void launchBrowser(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		AutoLogger logger = new AutoLogger(this.getClass());
		eventDriver.register(logger);
		driver.manage().window().maximize();
		driver.get(properties.getProperty("baseURL"));
	}
}
