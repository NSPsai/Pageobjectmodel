package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{
	//Declaration the Element
		@FindBy(xpath="/html/body/nav/a")
		WebElement homelink;
		
		@FindBy(xpath="/html/body/nav/div[1]/ul/li[3]/a")
		WebElement Aboutlink;
		
		@FindBy(xpath="/html/body/nav/div[1]/ul/li[2]/a")
		WebElement Contactlink;
		
		@FindBy(id="logout2")
		WebElement Logoutlink;
		
		@FindBy(id="nameofuser")
		WebElement welcometestlink;
		
		@FindBy(xpath="/html/body/div[1]/div/div/div[3]/button[1]")
		WebElement Closebtn;
		

		//Initialize the Element
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		//Utilize the Element
		public void clickonHome() {
			homelink.click();
		}
		
		public void ClickonAbout() {
			Aboutlink.click();
		}
		
		public void clickonContact() {
			Contactlink.click();
		}
		
		public void clickonLogout() {
			Logoutlink.click();
		}
		
		public void clickonContactclose() {
			Closebtn.click();
		}

		public void Welcometest() {
			welcometestlink.click();
		}
		
		
		


}
