package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase 
{
	public static Properties prop;
	public static WebDriver driver;

	public TestBase() throws FileNotFoundException 
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\SHYAM\\eclipse-workspace\\MAVEN\\PMS\\src\\main\\java\\com\\qa\\config\\config.properties");
		try 
		{
			prop.load(fis);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	
	public static void initialization() 
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D://sellib/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("FF")) 
		{
			System.setProperty("webbdriver.gecko.driver", "D://sellib/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
			
	}
}	

	

