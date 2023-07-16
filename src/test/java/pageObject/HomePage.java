package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	public HomePage(WebDriver d)
	{
		super(d);
	}
	
	//Elements
	@CacheLookup@FindBy(xpath = "//span[text()='My Account']") WebElement lnkMyAccount;
	@CacheLookup@FindBy(xpath ="//a[text()='Register']") WebElement lnkRegister;
	@CacheLookup@FindBy(xpath = "//a[text()='Login']")WebElement lnkLogin;
	//Action
	public void clkMyAccount()
	{
		lnkMyAccount.click();
	}
	public void clkRegister()
	{
		lnkRegister.click();
	}
	public void clkLogin()
	{
		lnkLogin.click();
	}
}
