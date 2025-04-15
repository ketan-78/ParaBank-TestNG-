package StandardFramework.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import StandaredFramework.PageObject._1_logIn_page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public WebDriver driver;
	public _1_logIn_page bk;
		public WebDriver intialization() throws IOException
	{	//properties class
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\StandardFramework\\Resources\\GlobalData.properties");
		prop.load(file);
		String BrowserName=System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		if(BrowserName.contains("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			
//			credentials_enable_service: false → disables Google's Password Manager.
//			profile.password_manager_enabled: false → prevents the "Change Password" popups.
//			"excludeSwitches" removes annoying warnings about automation control.
			options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation", "enable-logging"});
			HashMap<String, Object> prefs = new HashMap<>();
			prefs.put("credentials_enable_service", false); 
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.default_content_setting_values.notifications", 2);
			
			options.setExperimentalOption("prefs", prefs);
			// This disables the "Save Password" popup properly!
			options.addArguments("--disable-save-password-bubble"); // Important!!
			options.addArguments("--incognito");
			
			if(BrowserName.contains("headless"))
				options.addArguments("headless");
			driver=new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));//to run browser in full screen in headless
			driver.manage().deleteAllCookies();
		}
		else if(BrowserName.contains("firefox"))
		{
			FirefoxOptions options=new FirefoxOptions();
			if(BrowserName.contains("headless"))
				options.addArguments("headless");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ketan\\Downloads\\geckodriver-v0.34.0-win-aarch64");
			driver=new FirefoxDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
		}
		else if(BrowserName.contains("edge"))
		{
			EdgeOptions options=new EdgeOptions();
			if(BrowserName.contains("headless"))
				options.addArguments("headless");
			driver=new EdgeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
		}
		else if(BrowserName.equalsIgnoreCase("opera"))
		{ 
			driver=WebDriverManager.operadriver().create();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver; 
	}
	public List<HashMap<String, String>> getData(String filepath) throws IOException
	{
		//json to String
		File file =new File(filepath);
		String jsonfile=FileUtils.readFileToString(file,StandardCharsets.UTF_8);
		//String to HashMap---->Jackson databind dependency 
		ObjectMapper mapper=new ObjectMapper(); 
		List<HashMap<String,String>> data=mapper.readValue(jsonfile, new TypeReference<List<HashMap<String,String>>>(){
		});
		return data;
	}
	@BeforeMethod(alwaysRun=true)
	public _1_logIn_page Launch() throws IOException
	{
		driver=intialization();
		driver.get("https://parabank.parasoft.com/parabank/contact.htm");
		bk=new _1_logIn_page(driver);
		return bk;
	}
	
	public String takeScreenshot(String ErrorReason,WebDriver driver) throws IOException
	{
		TakesScreenshot ss=(TakesScreenshot)driver; 
		File source =ss.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"\\reports\\"+ErrorReason+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"\\reports\\"+ErrorReason+".png";
	}
	@AfterMethod(alwaysRun=true)
	public void closure()
	{
		driver.close();
	}
}
