package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
	public MyAccountPage(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
	}

	@CacheLookup@FindBy(xpath ="//h2[normalize-space()='My Account']")WebElement msgHeading;
	@CacheLookup@FindBy(xpath = "//a[@class='list-group-item'][text()='Logout']")WebElement lnkLogout;

	public boolean test_MyAccountValidatation()
	{
		try 
		{
			return msgHeading.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void test_logout()
	{
		lnkLogout.click();
	}
}
