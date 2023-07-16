package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass
{
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void test_LoginDDT(String email,String pwd, String Result)
	{
		logger.info(" ***Starting TC_003_LoginDataDrivenTest***");
		try 
		{
		HomePage hp=new HomePage(d);
		hp.clkMyAccount();
		hp.clkLogin();
		
		LoginPage lp=new LoginPage(d);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clkContiune();
		
		MyAccountPage myAcc=new MyAccountPage(d);
		boolean status = myAcc.test_MyAccountValidatation();
		
		//------------------------------------
		//Data		TargetPage		Test
		//valid		True			pass
		//valid 	fail			fail
		//Invalid  	true			fail
		//Invalid	fail			pass
		//-------------------------------------
		
		if (Result.equalsIgnoreCase("valid")) 
		{
			if (status==true) 
			{
				logger.info("Login is successfull - Data is valid and Target page is true");
				myAcc.test_logout();
				logger.info("Test case passed....");
				Assert.assertTrue(true);
			}
			else if (status==false) 
			{
				logger.info("Login is Unsuccessfull - Data is valid and Target page is false");
				logger.error("Test case passed....");
				Assert.fail();
			}
		}else if (Result.equalsIgnoreCase("Invalid")) 
		{
			if (status==true)  //-ve here already logged in but testcase is passed but invalid .so, we want to fail the test case
			{
				logger.info("Login is successfull - Data is invalid and Target page is True");
				myAcc.test_logout();
				logger.info("Test case passed....");
				Assert.fail();
			}else if (status==false) 
			{
				logger.info("Login is Unsuccessfull - Data is invalid and Target page is True");
				logger.info("Test case passed....");
				Assert.assertTrue(true);
			}
		}
		} catch (Exception e) 
		{
			logger.info("Test Case Failed");
			Assert.fail();
		}
		logger.info(" ***Finished TC_003_LoginDataDrivenTest***");
	}
}
