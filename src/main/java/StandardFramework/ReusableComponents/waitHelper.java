package StandardFramework.ReusableComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitHelper {
	
	WebDriver driver;
	public waitHelper(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void hardWait() 
	{
	    try 
	    {
	        Thread.sleep(2000);
	    } 
	    catch (InterruptedException e) 
	    {
	        e.printStackTrace();
	    }
	}
	public void explicitWait(WebElement element)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(element));
		//w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
}
