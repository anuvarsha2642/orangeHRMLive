package commonFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class CommonFunctions {
	static Properties prop;
	static WebDriver driver;
	public Properties loadPropertyFile()
	{
		
		try(FileInputStream fis=new FileInputStream("config.properties");)
		{
			prop.load(fis);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}
	@BeforeTest
	public void launchBrowser()
	{
		String browser=loadPropertyFile().getProperty(prop.getProperty("browser"));
		if(browser.equalsIgnoreCase("chrome"))
		{
			/*String downloadPath=System.getProperty("user.dir");
			HashMap<String,Object> chromePrefs=new HashMap<String,Object>();
			chromePrefs.put("profile.default_content_settings.popups",0);
			chromePrefs.put("download.default_directory",downloadPath);
			ChromeOptions options=new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);*/
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeLocation"));
			driver=new ChromeDriver();
		}
		else if(browser=="IE")
		{
			System.setProperty("webdriver.ie.driver", prop.getProperty("IElocation"));
			 driver = new InternetExplorerDriver();
		}
		else if(browser=="firefox")
		{
			System.setProperty("webdriver.gecko.driver",prop.getProperty("Firefoxlocation"));
			 driver = new FirefoxDriver();
		}
				
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
		
	}
	
	
	
	
	@AfterTest
	
	public void tearDown()
	{
		//driver.quit();	
	}
	
	
}
