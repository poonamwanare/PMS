package com.qa.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.TestBase;

public class LoginPage extends TestBase
{

	public LoginPage() throws FileNotFoundException 
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement loginbtn;
	
	@FindBy(linkText = "Password forgotten?")
	WebElement forgetpasslink;
	
	@FindBy(className = "form-title")
	WebElement restorepasspage;
	
	@FindBy(name = "username")
	WebElement recvusername;
	
	@FindBy(name = "email")
	WebElement recvemail;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement sendbtn;
	
	@FindBy(xpath = "//*[text()=\"A new password has been sent to your e-mail address.\"]")
	WebElement emailsentforrecvorymsg;
	

	
	public DashboardPage enterLoginCredentials(String uname,String pass) throws FileNotFoundException
	{
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginbtn.click();
		return new DashboardPage();
	}
	
	public void clickOnForgetPassLink()
	{
		forgetpasslink.click();
	}
	
	public void checkNewPageOpenForRecovery()
	{
		String recoverypage = restorepasspage.getText();
		Assert.assertEquals(recoverypage, "Restore Password");
		System.out.println("Successfully opened Recover Password Link");
	}
	
	public void enterCredentialsForPassRecovery()
	{
		recvusername.sendKeys("poonam");
		recvemail.sendKeys("wanarepoonam2019@gmail.com");
		sendbtn.click();
	}
	
	public void emailSentForPassRecovery()
	{
		String sentmsg = emailsentforrecvorymsg.getText();
		System.out.println(sentmsg);
	}

	
}
