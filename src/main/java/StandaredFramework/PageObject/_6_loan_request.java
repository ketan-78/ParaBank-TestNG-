package StandaredFramework.PageObject;

import java.net.SocketException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import StandardFramework.ReusableComponents.waitHelper;

public class _6_loan_request extends waitHelper{

	WebDriver driver;
	
	_6_loan_request(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[href='requestloan.htm']")
	WebElement loanOp;
	@FindBy(id="requestLoanForm")
	WebElement applyForLoan;
	@FindBy(id="amount")
	WebElement amount;
	@FindBy(id="downPayment")
	WebElement downPayment;
	@FindBy(id="fromAccountId")
	WebElement acctSelection;
	@FindBy(css="[value='Apply Now']")
	WebElement apply;
	@FindBy(id="requestLoanResult")
	WebElement loanProcess;
	@FindBy(css=".form tr")
	List<WebElement> confirmation;
	
	public _7_account_overview reqLoan(String amt,String downPay,String acct) throws SocketException
	{
		loanOp.click();
		explicitWait(applyForLoan);
		amount.sendKeys(amt);
		downPayment.sendKeys(downPay);
		Select select=new Select(acctSelection);
		select.selectByIndex(Integer.parseInt(acct));
		apply.click();
		explicitWait(loanProcess);
		confirmation.stream().map(WebElement::getText).forEach(s -> System.out.print(s + "\n"));
		_7_account_overview over=new _7_account_overview(driver);
		return over;
	}
}