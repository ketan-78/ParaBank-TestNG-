package StandaredFramework.PageObject;

import java.net.SocketException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import StandardFramework.ReusableComponents.waitHelper;

public class _3_funds_transfer extends waitHelper{

	WebDriver driver;
	_3_funds_transfer(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="amount")
	WebElement amtTrans;
	@FindBy(id="fromAccountId")
	WebElement fromAcct;
	@FindBy(id="toAccountId")
	WebElement toAcct;
	@FindBy(css="[value='Transfer']")
	WebElement transfer;
	@FindBy(css="[href='transfer.htm']")
	WebElement fundTrans;
	@FindBy(css="[href='logout.htm']")
	WebElement logout;
	
	public _4_bill_payment_service transferFunds(String amt,String fromA, String toA) throws SocketException
	{
		fundTrans.click();
		amtTrans.sendKeys(amt);
		Select fromAc=new Select(fromAcct);
		fromAc.selectByIndex(Integer.parseInt(fromA));
		Select toAc=new Select(toAcct);
		toAc.selectByIndex(Integer.parseInt(toA));
		transfer.click();
		_4_bill_payment_service payment=new _4_bill_payment_service(driver);
		return payment;
	}
}