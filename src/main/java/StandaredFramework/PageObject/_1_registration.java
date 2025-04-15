package StandaredFramework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StandardFramework.ReusableComponents.waitHelper;

public class _1_registration extends waitHelper{

	WebDriver driver;
	_1_registration(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[href='register.htm']")
	WebElement signUp;
	@FindBy(css="[id='customer.firstName']")
	WebElement fname;
	@FindBy(css="[id='customer.lastName']")
	WebElement lname;
	@FindBy(css="[id='customer.address.street']")
	WebElement addr;
	@FindBy(css="[id='customer.address.city']")
	WebElement city;
	@FindBy(css="[id='customer.address.state']")
	WebElement state;
	@FindBy(css="[id='customer.address.zipCode']")
	WebElement zipCode;
	@FindBy(css="[id='customer.phoneNumber']")
	WebElement phone;
	@FindBy(css="[id='customer.ssn']")
	WebElement ssn;
	@FindBy(css="[id='customer.username']")
	WebElement userr;
	@FindBy(css="[id='customer.password']")
	WebElement pass;
	@FindBy(css="#repeatedPassword")
	WebElement passConf;
	@FindBy(css="[value='Register']")
	WebElement register;
	@FindBy(xpath="//*[text()='Signing up is easy!']")
	WebElement regPage;
	
	public _2_account_creation registration(String fn,String ln,String addrr,String cty,String statee,String zip,
			String mob,String ss, String usr,String passd,String passcon)
	{
		signUp.click();
		explicitWait(regPage);
		fname.sendKeys(fn);
		lname.sendKeys(ln);
		addr.sendKeys(addrr);
		city.sendKeys(cty);
		state.sendKeys(statee);
		zipCode.sendKeys(zip);
		phone.sendKeys(mob);
		ssn.sendKeys(ss);
		userr.sendKeys(usr);
		pass.sendKeys(passd);
		passConf.sendKeys(passcon);
		register.click();
		_2_account_creation newAccount=new _2_account_creation(driver);
		return newAccount; 
	}
}