package com.qa.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class DashboardPage extends TestBase
{

	public DashboardPage() throws FileNotFoundException 
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//div[@class='alert alert-danger']")
	WebElement wronguserpassmsg;
	
	public void dashboardVerifyTitle()
	{
		String dashboardtitle = driver.getTitle();
		if(dashboardtitle.equals("Rukovoditel | Dashboard"))
		{
			System.out.println("Successfully Login");
		}
		else 
		{
				//System.out.println("Wrong Credentials Entered by user");
			String geterrmsg = wronguserpassmsg.getText();
			System.out.println(geterrmsg);
		}
		
	}
	


}
