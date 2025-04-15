package StandaredFramework.PageObject;

import java.net.SocketException;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import StandardFramework.ReusableComponents.waitHelper;

public class _2_account_creation extends waitHelper{

	WebDriver driver;
	_2_account_creation(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[href='logout.htm']")
	WebElement logout;
	@FindBy(css="[href='openaccount.htm']")
	WebElement openNewAcct;
	@FindBy(id="type")
	WebElement option;
	@FindBy(id="fromAccountId")
	WebElement acctNum;
	@FindBy(css="[value='Open New Account']")
	WebElement openAcct;
	@FindBy(css="#openAccountResult p")
	List<WebElement> confiramtion;
	@FindBy(css=".error")
	WebElement error;
	@FindBy(id="openAccountForm")
	WebElement accountForm;
	@FindBy(id="openAccountResult")
	WebElement opened;
	
	public _3_funds_transfer openNewAccount(String type,String exAcct) throws SocketException
	{
		try
		{
			openNewAcct.click();
			explicitWait(accountForm);
			Select dropdown=new Select(option);
			dropdown.selectByIndex(Integer.parseInt(type));
			Select acctDP=new Select(acctNum);
			acctDP.selectByIndex(Integer.parseInt(exAcct));
			openAcct.click();
			explicitWait(opened);
			confiramtion.stream().map(WebElement::getText).forEach(s -> System.out.print(s + "\n"));
		}
		catch (NoSuchElementException e)
		{
			System.out.println(error);
			logout.click();
		}
		_3_funds_transfer fundTransfer=new _3_funds_transfer(driver);
		return fundTransfer;
	}
}