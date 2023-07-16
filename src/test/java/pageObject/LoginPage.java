package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
	}

	//Elements
	@CacheLookup@FindBy(id="input-email")WebElement txtemail;
	@CacheLookup@FindBy(id="input-password")WebElement txtpassword;
	@CacheLookup@FindBy(xpath="//input[@value='Login']")WebElement btnContiune;
	
	//Action
	public void setEmail(String email)
	{
		txtemail.sendKeys(email);
	}
	public void setPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	public void clkContiune()
	{
		btnContiune.click();
	}

}
