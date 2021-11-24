package script;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import pompages.HomePage;
import pompages.LoginPage;

public class TestDemoApplication extends BaseTest {

	@Parameters("browser")
	@Test
	public void runInMulitpleBrowser(String browser) throws Exception {
		
		System.out.println(browser);
		LoginPage login = new LoginPage(driver);
		login.clickLogin();
		Thread.sleep(2000);
		login.setUsername("test");
		login.setpwd("test");
		Thread.sleep(2000);
		login.clickLogin2();
		Thread.sleep(2000);	
		
		HomePage hp = new HomePage(driver);
		String title =driver.getTitle();
		Thread.sleep(2000);
		System.out.println(title);
		Thread.sleep(2000);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(title,"STORE");
		Thread.sleep(2000);
		hp.clickonLogout();
		sa.assertAll();
		Thread.sleep(2000);
		driver.close();
	}

}
