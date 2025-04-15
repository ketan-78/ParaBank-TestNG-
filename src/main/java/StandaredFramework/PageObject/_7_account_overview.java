package StandaredFramework.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StandardFramework.ReusableComponents.waitHelper;

public class _7_account_overview extends waitHelper{

	WebDriver driver;
	
	public _7_account_overview(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[href='overview.htm']")
	WebElement acctOverview;
	@FindBy(id="showOverview")
	WebElement overviewPage;
	@FindBy(xpath="//thead/tr")
	List<WebElement> header;
	@FindBy(xpath="//tbody/tr")
	List<WebElement> acctDetails;
	@FindBy(css="[href='logout.htm']")
	WebElement logout;
		
	public void overview()
	{
		acctOverview.click();
		explicitWait(overviewPage);
		header.stream().map(WebElement::getText).forEach(s -> System.out.print(s + "\n"));
		acctDetails.stream().map(WebElement::getText).forEach(s -> System.out.print(s + "\n"));
		logout.click();
	}
}