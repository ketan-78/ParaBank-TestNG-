package StandaredFramework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import StandardFramework.ReusableComponents.waitHelper;

public class _1_logIn_page extends waitHelper{
	
	WebDriver driver;
	public boolean flag=false;
	
	public _1_logIn_page(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[name='username']")
	WebElement user;
	@FindBy(css="[name='password']")
	WebElement pwd;
	@FindBy(css="[value='Log In']")
	WebElement log_in;
	@FindBy(css="[href='logout.htm']")
	WebElement logout;
	@FindBy(css=".error")
	WebElement error;

	String logInError="The username and password could not be verified.";
	String internalError="An internal error has occurred and has been logged.";
	
	//If the user exist, then go for services
	public _2_account_creation login(String usr,String pswd)
	{
		user.sendKeys(usr);
		pwd.sendKeys(pswd);
		log_in.click();
		if (error.getText().trim().equalsIgnoreCase(logInError))
		{
			goToRegistration();
		}
		if(error.getText().trim().equalsIgnoreCase(internalError))
		{
			System.out.println(internalError);
			System.out.println("Please try again after sometime");
			logout.click();
		}
		_2_account_creation newAccount=new _2_account_creation(driver);
		return newAccount; 
	}
	//If the user doesn't exist, go to registration page
	 public _1_registration goToRegistration()
	 {
		 flag=true;
		 _1_registration register = new _1_registration(driver);
		 return register;
	 }
}