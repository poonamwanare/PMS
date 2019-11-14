package com.qa.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	

	
	public DashboardPage enterLoginCredentials(String uname,String pass) throws FileNotFoundException
	{
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginbtn.click();
		return new DashboardPage();
	}

	
}
