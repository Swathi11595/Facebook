

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class Magento 
{
	WebDriver dr;
	@BeforeMethod
	public void openWebsite()
	{
		dr=new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dr.get("https://magento.com");
		dr.findElement(By.linkText("My Account")).click();
	}
	
	@Test
	public void enterInvalid()
	{
		dr.findElement(By.id("email")).sendKeys("ihassan395@gmail.com");
		dr.findElement(By.id("pass")).sendKeys("Welcome@123");
	}
	@AfterMethod
	public void closeWebsite()
	{
		dr.findElement(By.id("send2")).click();	
		dr.findElement(By.linkText("Log Out")).click();
		dr.quit();
	}
}
