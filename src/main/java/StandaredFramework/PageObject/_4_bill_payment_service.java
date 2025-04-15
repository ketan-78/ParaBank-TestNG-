package StandaredFramework.PageObject;

import java.net.SocketException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import StandardFramework.ReusableComponents.waitHelper;

public class _4_bill_payment_service extends waitHelper{

	WebDriver driver;
	_4_bill_payment_service(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="payee.name")
	WebElement payeeName;
	@FindBy(name="payee.address.street")
	WebElement payeeAddr;
	@FindBy(name="payee.address.city")
	WebElement payeeCity;
	@FindBy(name="payee.address.state")
	WebElement payeeState;
	@FindBy(name="payee.address.zipCode")
	WebElement payeeZip;
	@FindBy(name="payee.phoneNumber")
	WebElement payeePhone;
	@FindBy(name="payee.accountNumber")
	WebElement merchantAcctNo;
	@FindBy(name="verifyAccount")
	WebElement merchantAcctVerify;
	@FindBy(name="fromAccountId")
	WebElement payeeAcct;
	@FindBy(name="amount")
	WebElement payment;
	@FindBy(css="[value='Send Payment']")
	WebElement pay;
	@FindBy(css="#billpayResult p")
	List<WebElement> billComplete;
	@FindBy(css=".title")
	WebElement billPage;
	@FindBy(css="[href='billpay.htm']")
	WebElement billPay;
	@FindBy(id="billpayResult")
	WebElement confirmation;
	
	public _5_update_contact paymentService(String name,String addr,String custCity,String custState,String zip, 
			String mobile,String merchAcc,String amount,String acctNo) throws SocketException
	{
		billPay.click();
		explicitWait(billPage);
		payeeName.sendKeys(name);
		payeeAddr.sendKeys(addr);
		payeeCity.sendKeys(custCity);
		payeeState.sendKeys(custState);
		payeeZip.sendKeys(zip);
		payeePhone.sendKeys(mobile);
		merchantAcctNo.sendKeys(merchAcc);
		merchantAcctVerify.sendKeys(merchAcc);
		payment.sendKeys(amount);
		Select acctdp=new Select(payeeAcct);
		acctdp.selectByIndex(Integer.parseInt(acctNo));
		pay.click();
		explicitWait(confirmation);
		billComplete.stream().map(WebElement::getText).forEach(s -> System.out.print(s + "\n"));
		_5_update_contact update=new _5_update_contact(driver);
		return update;
	}
}