package StandaredFramework.PageObject;

import java.net.SocketException;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StandardFramework.ReusableComponents.waitHelper;

public class _5_update_contact extends waitHelper{
	
	WebDriver driver;
	_5_update_contact(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[href='updateprofile.htm']")
	WebElement updateCont;
	@FindBy(id="updateProfileForm")
	WebElement profile;
	@FindBy(id="customer.firstName")
	WebElement fname;
	@FindBy(id="customer.lastName")
	WebElement lname;
	@FindBy(id="customer.address.street")
	WebElement addr;
	@FindBy(id="customer.address.city")
	WebElement city;
	@FindBy(id="customer.address.state")
	WebElement state;
	@FindBy(id="customer.address.zipCode")
	WebElement zip;
	@FindBy(id="customer.phoneNumber")
	WebElement phone;
	@FindBy(css="[value='Update Profile']")
	WebElement updateProfile;
	@FindBy(id="updateProfileResult")
	WebElement updated;
	@FindBy(css="#updateProfileResult p")
	WebElement updateConfirmation;
	@FindBy(css="#updateProfileError")
	WebElement error;
	
	public _6_loan_request profileUpdation(String first,String last,String address,String City,
			String State,String code,String mobile) throws SocketException, InterruptedException,
	 		TimeoutException
	{
		updateCont.click();
		explicitWait(profile);
		fname.sendKeys(first);
		lname.sendKeys(last);
		addr.sendKeys(address);
		city.sendKeys(City);
		state.sendKeys(State);
		zip.sendKeys(code);
		phone.sendKeys(mobile);
		updateProfile.click();
		Thread.sleep(1000);
		if(error.isDisplayed())
		{
			System.out.println("Internal error, please try again after sometime");
		}
		else
		{
			explicitWait(updated);
			System.out.println(updateConfirmation.getText().trim());
		}
		_6_loan_request request=new _6_loan_request(driver);
		return request;
	}
}