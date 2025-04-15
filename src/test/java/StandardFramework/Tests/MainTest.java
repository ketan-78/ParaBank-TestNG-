package StandardFramework.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import StandardFramework.TestComponents.BaseTest;
import StandaredFramework.PageObject._1_registration;
import StandaredFramework.PageObject._2_account_creation;
import StandaredFramework.PageObject._3_funds_transfer;
import StandaredFramework.PageObject._4_bill_payment_service;
import StandaredFramework.PageObject._5_update_contact;
import StandaredFramework.PageObject._6_loan_request;
import StandaredFramework.PageObject._7_account_overview;

public class MainTest extends BaseTest{
 
	@Test(dataProvider="data")
	public void funtion(HashMap<String,String> data) throws IOException, InterruptedException 
	{
		_2_account_creation newAccount=bk.login(data.get("user"),data.get("pswd"));
		
		//this will only execute for new users.
		if(bk.flag==true)
		{
			_1_registration register=bk.goToRegistration();
			register.registration(data.get("fname"),data.get("lname"),data.get("addr"),data.get("city"),
				    data.get("state"),data.get("zip"),data.get("phone"),data.get("ssn"),
				    data.get("username"),data.get("password"),data.get("confirmp"));
		}
		
		_3_funds_transfer fundTransfer=newAccount.openNewAccount(data.get("newAcctType"),data.get("existingAcct"));
		_4_bill_payment_service payment=fundTransfer.transferFunds(data.get("transferAmt"),
				data.get("fromAmt"),data.get("toAmt"));
		
		_5_update_contact update=payment.paymentService(data.get("payeeName"),data.get("payeeAddr"),
				data.get("payeeCity"),data.get("payeeState"),	data.get("payeeZip"),data.get("payeeMobile"),
				data.get("merchantAcct"),data.get("amount"),data.get("payeeAcctNo"));
		_6_loan_request request=update.profileUpdation(data.get("updateFname"),data.get("updateLname"),
				data.get("updateAddr"),data.get("updateCity"),data.get("updateState"),data.get("updateZip"),
				data.get("updatePhone"));
		_7_account_overview over=request.reqLoan(data.get("loanAmt"),data.get("downPay"),data.get("acctSelect"));
		over.overview();
		
	}
	
	@DataProvider
	public Object[][] data() throws IOException
	{
		List<HashMap<String,String>> data=getData(System.getProperty("user.dir")+"\\src\\test\\java\\StandardFramework\\Data\\Data.json");
		return new Object[][] {{data.get(0)}};
	}
}

