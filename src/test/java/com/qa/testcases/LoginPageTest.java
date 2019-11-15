package com.qa.testcases;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{

	public LoginPageTest() throws FileNotFoundException 
	{
		super();
	}
	
	LoginPage loginpage;
	DashboardPage dashboarpage;
	
	@BeforeMethod
	public void setUp() throws FileNotFoundException
	{
		initialization();
		loginpage = new LoginPage();
	}
	

	@Test(priority = 1)
	public void loginpageCredentialsTest()
	{
		try {
			dashboarpage = loginpage.enterLoginCredentials(prop.getProperty("username"), prop.getProperty("password"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		dashboarpage.dashboardVerifyTitle();
	}
	
	@Test(priority = 2)
	public void blankCredentialsTest()
	{
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();
		String usererrormsg = driver.findElement(By.id("username-error")).getText();
		System.out.println("Username : " +usererrormsg);
		String passerrormsg = driver.findElement(By.id("password-error")).getText();
		System.out.println("Password : " +passerrormsg);
		System.out.println("User is unable to login due to blank credentials");
	}
	
	@Test(priority =3)
	public void forgetPasswordTest()
	{
		loginpage.clickOnForgetPassLink();
		loginpage.checkNewPageOpenForRecovery();
		loginpage.enterCredentialsForPassRecovery();
		loginpage.emailSentForPassRecovery();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
