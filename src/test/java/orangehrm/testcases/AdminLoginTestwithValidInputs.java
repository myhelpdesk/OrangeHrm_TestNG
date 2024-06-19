package orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import orangehrm.library.LoginPage;
import utils.AppUtils;

public class AdminLoginTestwithValidInputs extends AppUtils {
	
	@Parameters({"adminuid","adminpwd"})
	@Test
	public void checkAdminLogin(String uid,String pwd) throws InterruptedException
	{
		//call this nonstatic function must create object for class
		LoginPage lp = new LoginPage();
		lp.login(uid, pwd);
		//calling method from LoginPage class
		boolean res = lp.isAdminModuleDisplayed();
		//assertTrue means expected admin module is displayed true
		// res means really displayed true test case is pass
		Assert.assertTrue(res);
		lp.logout();
	}

}
