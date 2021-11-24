package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Declaration the Element
	@FindBy(xpath="//input[@id='loginusername']")
	WebElement Idtxt;
	
	@FindBy(xpath="//input[@id='loginpassword']")
	WebElement Pwdtxt;
	
	@FindBy(id="login2")
	WebElement loginBtn;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div[3]/button[2]")
	WebElement loginBtn2;
	
	//Initialize the Element
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Utilize the Element
	public void setUsername(String un) throws Exception {
		Idtxt.clear();
		Idtxt.sendKeys(un);
		Thread.sleep(2000);
	}
	
	public void setpwd(String pwd) {
		Pwdtxt.sendKeys(pwd);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	public void clickLogin2() {
		loginBtn2.click();
	}
}
