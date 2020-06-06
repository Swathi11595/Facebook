package com.abc.Facebook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class Facebook 
{
	WebDriver dr;
	@BeforeTest
	@Parameters({"url"})
	public void openFacebook(String ul)
	{
		ChromeOptions o=new ChromeOptions();  // to handle web level notifications
		o.addArguments("--disable-notifications"); // write argument as it is
		dr=new ChromeDriver(o);
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dr.get(ul);
	}
	@Test
	@Parameters({"email","pass"})
	public void dataSet1(String em,String pwd) throws Exception
	{
		dr.findElement(By.xpath("//input[@id='email']")).sendKeys(em);
		dr.findElement(By.xpath("//input[@id='pass']")).sendKeys(pwd);
		dr.findElement(By.xpath("//input[@id='u_0_b']")).click();
		Thread.sleep(1000);
		dr.findElement(By.xpath("//div[text()='Account Settings']")).click();
		Thread.sleep(3000);
		dr.findElement(By.xpath("//li[@class='_54ni navSubmenu _6398 _64kz __MenuItem']")).click();
	}
	@AfterTest
	public void closeFacebook()
	{
		dr.quit();
	}
}
