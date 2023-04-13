package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Paralleltesting 
{
    WebDriver driver;
    @Parameters("browser")
    
    @Test
    public void open(String a)
    {
    	if(a.equalsIgnoreCase("Chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver_win32\\chromedriver.exe");
   		    driver = new ChromeDriver();
    	}
    	
    	else if(a.equalsIgnoreCase("Firefox"))
    	{
    		System.setProperty("webdriver.gecko.driver","C:\\Users\\pc\\Downloads\\geckodriver-v0.32.0-win64\\geckodriver.exe");
    		driver = new FirefoxDriver();
    	}
    	
    	else if(a.equalsIgnoreCase("IE"))
    	{
    		System.setProperty("webdriver.ie.driver","C:\\Users\\pc\\Downloads\\IEDriverServer_x64_4.7.0\\IEDriverServer.exe");
    		driver = new InternetExplorerDriver();
    	}
    	
    	else
    	{
    		System.out.println("given browsername is wrong");
    	}
    	
    	 driver.get("https://www.facebook.com/reg/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
   
		String j= driver.getTitle();
		System.out.println(j);
    
    }
}

//Suite file
//<?xml version="1.0" encoding="UTF-8"?>
//<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
//<suite parallel="tests" name="Suite">
//  <test thread-count="5" parallel="tests" name="Test">
//  <parameter name="browser" value="Chrome">
//  <classes>
//  <class name="testng.Paralleltesting">
//  </class>
//  </classes>
//  </parameter>
//  </test> <!-- Test -->
//  
//   <test thread-count="5" parallel="tests" name="Test1">
//  <parameter name="browser" value="Firefox">
//  <classes>
//  <class name="testng.Paralleltesting">
//  </class>
//  </classes>
//  </parameter>
//  </test> <!-- Test -->
//  
//   <test thread-count="5" parallel="tests" name="Test2">
//  <parameter name="browser" value="IE">
//  <classes>
//  <class name="testng.Paralleltesting">
//  </class>
//  </classes>
//  </parameter>
//  </test> <!-- Test -->
//</suite> <!-- Suite -->
