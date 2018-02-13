package automation.enboard.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	protected Properties properties;
	Map<String, String> propertiesData = new HashMap<String, String>();
	protected WebDriver driver;
	protected EventFiringWebDriver eventDriver;
	protected AutoLogger handler;
	
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
	
	public void launchBrowser(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		eventDriver = new EventFiringWebDriver(driver);
		handler = new AutoLogger();
		eventDriver.register(handler);
		eventDriver.manage().window().maximize();
		eventDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		eventDriver.get(properties.getProperty("baseURL"));
	}
	
	@BeforeClass
	public void getEnvironmentReady(){
		getPropertiesData();
		launchBrowser();
	}
	
	@AfterClass
	public void quitBrowser(){
		if(eventDriver != null)
			eventDriver.quit();
	}
}
