package orangehrm.library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.AppUtils;

public class Employee extends AppUtils {
	
	public boolean addEmployee(String fname,String lname)
	{
		
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		
		driver.findElement(By.id("firstName")).sendKeys(fname);
		driver.findElement(By.id("lastName")).sendKeys(lname);
		//getAttribute("value") means get capture the employ id, this id is unique, for employ searching purpose
		String empid = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
		
		driver.findElement(By.linkText("Employee List")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(empid);
		driver.findElement(By.id("searchBtn")).click();
		//find the table element
		WebElement emptable = driver.findElement(By.id("resultTable"));
		//Capture all of the rows
		List<WebElement> rows = emptable.findElements(By.tagName("tr"));
		//declaring variable isempexist
		boolean isempexist = false;
		//there are no rows in the table the forloop not execute even one time, forloop not execute not return any value thats why create above boolean variable("boolean isempexist = false;"), not execute forloop will return boolean variable 
		
		
		for(int i=1;i<rows.size();i++)
		{
			//capture all of the columns create list
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			//cols.get(1) means second horizontal block
			//equals(empid)) means compare with the employ id
			if(cols.get(1).getText().equals(empid))
			{
				//above condition forloop satisfy boolean variable isempexist = true will execute
				isempexist = true;
				break;
			}
		}		
		
		return isempexist;
		
	}
	
	
	
	public boolean addEmployee(String fname,String mname,String lname)
	{
		
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		
		driver.findElement(By.id("firstName")).sendKeys(fname);
		driver.findElement(By.id("middleName")).sendKeys(mname);
		driver.findElement(By.id("lastName")).sendKeys(lname);
		String empid = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
		
		driver.findElement(By.linkText("Employee List")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(empid);
		driver.findElement(By.id("searchBtn")).click();
		
		WebElement emptable = driver.findElement(By.id("resultTable"));
		List<WebElement> rows = emptable.findElements(By.tagName("tr"));
		
		boolean isempexist = false;
		
		for(int i=1;i<rows.size();i++)
		{
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			if(cols.get(1).getText().equals(empid))
			{
				
				isempexist = true;
				break;
			}
		}		
		
		return isempexist;
		
	}
}


