package orangehrm.library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.AppUtils;

public class User extends AppUtils {
	

	public boolean addUser(String role,String empname,String uname,String pword) throws InterruptedException
	{
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("User Management")).click();
		driver.findElement(By.linkText("Users")).click();
		
		driver.findElement(By.id("btnAdd")).click();
		
		Select rolelist = new Select(driver.findElement(By.id("systemUser_userType")));
		rolelist.selectByVisibleText(role);
		
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(empname);
		driver.findElement(By.id("systemUser_userName")).sendKeys(uname);
		driver.findElement(By.id("systemUser_password")).sendKeys(pword);
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(pword);
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(uname);
		driver.findElement(By.id("searchBtn")).click();
		
		WebElement usertable = driver.findElement(By.id("resultTable"));
		List<WebElement> rows = usertable.findElements(By.tagName("tr"));
		//declaring variable isuserexist
		boolean isuserexist = false;
		//there are no rows in the table the forloop not execute even one time, forloop not execute not return any value thats why create above boolean variable("boolean isuserexist = false;"), not execute forloop will return boolean variable
		
		
		for(int i=1;i<rows.size();i++)
		{
			//capture all of the columns create list
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			if(cols.get(1).getText().equals(uname))
				//cols.get(1) means second horizontal block
				//equals(uname)) means compare with the uname id
			{
				//above condition forloop satisfy boolean variable isuserexist = true will execute
				isuserexist = true;
				break;
				
			}
		}		
		
		return isuserexist;
	}

}
