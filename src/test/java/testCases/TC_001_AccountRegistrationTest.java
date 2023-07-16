package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.MyAccountPage;
import pageObject.AccountRegistrationPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass
{
	@Test(groups ={"Regression","Master"})
	public void test_AccountRegistration()
	{
		logger.info("*staring TC_001_AccountRegistrationTest ******");
		try 
		{
			HomePage hp = new HomePage(d);
			hp.clkMyAccount();
			logger.info("Clicked the MyAccount...");
			hp.clkRegister();
			logger.info("Clicked the Registration...");
			
			logger.info("Proving customer details");
			AccountRegistrationPage regPage = new AccountRegistrationPage(d);
			regPage.setFirstName(randomAlphabetic().toUpperCase());
			regPage.setLastName(randomAlphabetic().toLowerCase());
			String email = randomAlphanumeric()+"@gmail.com";
			regPage.setEmail(email);
			regPage.setTelephone(randomNumeric());
			String password = randomAlphabetic();
			regPage.setPassword(password);
			regPage.setConfirmPassword(password);
			regPage.clkRadioBtn();
			regPage.clkAgree();
			regPage.clkContinue();
			logger.info("Form Filled... Clicked contiune...");
			String ConfMsg = regPage.getConfirmationMsg();

			if (ConfMsg.equals("Your Account Has Been Created!")) 
			{
				logger.info("Test passed..");
				Assert.assertTrue(true);
			}
			else
			{
				logger.warn("customer registration is not successful");
				logger.error("Test failed..");
				Assert.assertFalse(false);
			}
			
			MyAccountPage myacc=new MyAccountPage(d);
			myacc.test_logout();
		}catch (Exception e) 
		{
			Assert.fail();
		}
		logger.info("**finished TC_001_AccountRegistrationTest **");
	}
}
