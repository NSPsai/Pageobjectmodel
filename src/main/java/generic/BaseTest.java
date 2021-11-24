package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConstant {
	public static WebDriver driver;
	static {
		System.setProperty(EDGE_KEY,EDGE_PATH);
		System.setProperty(CHROME_KEY,CHROME_PATH);
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void openApplication(String browser){
		System.out.println("Execution started");
		System.out.println(browser);
		if (browser.equals("edge")) {
			driver =new EdgeDriver(); 
		}else if(browser.equals("chrome")) {
			driver =new ChromeDriver();
		}
	 driver.get(Lib.getPropertyValue("URL"));
	 driver.manage().window().maximize();
	}
	@AfterMethod
	public void closeApplication(ITestResult res) 
	{
		//Capture Screenshot for only the failed test script
		if(ITestResult.FAILURE==res.getStatus()) 
		{
			Lib.CaptureScreenshots(driver, res.getName());
		}
		//close the webPage
		driver.close();
	}
}
