package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	// Declaration
	@FindBy (xpath = "//input[@id='email']")
	private WebElement userName ;
	
	@FindBy (xpath = "//input[@id='pass']")
	private WebElement password ;
	
	@FindBy (xpath = "//button[text()='Log In']")
	private WebElement loginButton ;
	
	@FindBy (xpath = "//a[text()='Create New Account']")
	private WebElement createNewAccount;
	
	@FindBy (xpath = "//a[text()='Messenger']")
	private WebElement messengerLink;
	
	
	// Initilization
	public LoginPage(WebDriver driver123)     // driver123 = driver = new ChromeDriver()
	{
		PageFactory.initElements(driver123, this);
	}
	
	// Use
	public void sendUserName(String data) {
		userName.sendKeys("Velocity@gmail.com");
	}
	
	public void sendPasswordName() {
		password.sendKeys("12345678");
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void clickOnCreateNewAcc() {
		createNewAccount.click();
	}
	
	public void openMessenger() {
		messengerLink.click();
	}
	
	//OR
	// Complete Functionality
	public void loginToApplication() {
		userName.sendKeys("Velocity@gmail.com");
		password.sendKeys("12345678");
		loginButton.click();
	}
	// OR

		
	//public void loginFacebook() {
	//	userName.sendKeys("Velocity");
	//	password.sendKeys("12345");
	//	loginButton.click();
	//}
	

}
