package orangehrm.library;

import org.openqa.selenium.By;

import utils.AppUtils;

public class LoginPage extends AppUtils{
	
	public void login(String uid,String pwd)
	{		
		// I am access "driver" object from "AppUtils" class using extend keyword
		driver.findElement(By.id("txtUsername")).sendKeys(uid);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();		
	}
	//admin displayed or not check here
	public boolean isAdminModuleDisplayed()
	{
		try 
		{
			driver.findElement(By.linkText("Admin")).isDisplayed();		
			return true;
			
		} catch (Exception e) 
		{
			return false;
		}		
	}
	
	public void logout() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	
	public boolean isErrMsgDisplayed()
	{
		String errmsg = driver.findElement(By.id("spanMessage")).getText().toLowerCase();
		//if error message contains(have) invalid or empty
		if(errmsg.contains("invalid") || errmsg.contains("empty"))
		{
			return true;
		}else
		{
			return false;
		}
		
	}
	//if admin link is not available in the window it is a Employ Module
	public boolean isEmpModuleDisplayed()
	{
		try 
		{
			// we are writing code employ module display or not,
			//the code is checking admin link is available in the window or not, the admin element not in the window exception occur internally it goes to catch block finally returns true, if true test pass
			driver.findElement(By.linkText("Admin")).isDisplayed();
			return false;
		} catch (Exception e) 
		{
			return true;
		}		
	}
	

}
