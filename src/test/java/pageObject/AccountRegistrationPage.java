package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class AccountRegistrationPage extends BasePage

{
	public AccountRegistrationPage(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
	}

	//Elements
	@CacheLookup@FindBy(name="firstname")WebElement txtFirstName;
	@CacheLookup@FindBy(id="input-lastname")WebElement txtLastName;
	@CacheLookup@FindBy(id="input-email")WebElement txtEmail;
	@CacheLookup@FindBy(id="input-telephone")WebElement txtTelephone;
	@CacheLookup@FindBy(id="input-password")WebElement txtPassword;
	@CacheLookup@FindBy(id="input-confirm")WebElement txtConfirmPassword;
	@CacheLookup@FindBy(xpath="//label[text()='Yes']")WebElement radioYesButton;
	@CacheLookup@FindBy(xpath="//label[text()='No']")WebElement radioNoButton;
	@CacheLookup@FindBy(name="agree")WebElement checkBoxAgree;
	@CacheLookup@FindBy(xpath ="//input[@value='Continue']")WebElement btnContinue;
	@CacheLookup@FindBy(xpath ="//h1[normalize-space()='Your Account Has Been Created!']")WebElement msgHeading;
	
	//Actions
	public void setFirstName(String firstName)
	{
		txtFirstName.sendKeys(firstName);
	}
	public void setLastName(String lastName)
	{
		txtLastName.sendKeys(lastName);
	}
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setTelephone(String phone)
	{
		txtTelephone.sendKeys(phone);
	}
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	public void setConfirmPassword(String confirmpassword)
	{
		txtConfirmPassword.sendKeys(confirmpassword);
	}
	public void clkRadioBtn()
	{
		radioYesButton.click();
	}
	public void clkAgree()
	{
		checkBoxAgree.click();
	}
	public void clkContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMsg()
	{
		try 
		{
			Thread.sleep(10);
			return msgHeading.getText();
		} catch (Exception e) 
		{
			return(e.getMessage());
		}	
	}	
}
