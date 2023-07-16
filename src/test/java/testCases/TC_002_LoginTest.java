package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test(groups = {"Sanity","Master"})
	public void test_loginTest()
	{
		logger.info("****Starting TC_002_LoginTest**");
		HomePage hp=new HomePage(d);
		hp.clkMyAccount();
		logger.info("Clicked My Account...");
		hp.clkLogin();
		logger.info("Clicked Login...");
		
		LoginPage lp=new LoginPage(d);
		lp.setEmail("pavanoltraining@gmail.com");
		logger.info("Enter the Email...");
		lp.setPassword("test@123");
		logger.info("Entered the password...");
		lp.clkContiune();
		logger.info("CLicked the contiune button");
		
		MyAccountPage myacc=new MyAccountPage(d);
		boolean status = myacc.test_MyAccountValidatation();
		if (status==true) 
		{
			Assert.assertTrue(status);
			logger.info("Testcase Passed....");
		}else
		{
			Assert.fail();
			logger.warn("Testcase Failed....");
		}
	}
	
}
