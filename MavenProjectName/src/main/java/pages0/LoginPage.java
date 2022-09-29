package pages0;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
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
	
	
	public LoginPage(WebDriver driver)     // driver123 = driver = new ChromeDriver()
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		//wait = new WebDriverWait(driver, 20);  // 20 sec
	}
	
	public void clickOnCreateNewAcc() {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(createNewAccount));
		createNewAccount.click();
	}
	
	public void sendUserName(String user) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(userName));
		
		userName.sendKeys("user");
	}
	
	public boolean checkPasswordIsDisplayed() {
		
		return password.isDisplayed();
	}
	
	public void sendPasswordName() {
		password.sendKeys("12345678");
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void openMessenger() {
		messengerLink.click();
	}
	
	//OR
	// Complete Functionality
/*	public void loginToApplication() {
		userName.sendKeys("Velocity@gmail.com");
		password.sendKeys("12345678");
		loginButton.click();
	}
	 OR
	
	public void loginFacebook() {
		userName.sendKeys("Velocity");
		password.sendKeys("12345");
		loginButton.click();
	}
*/	

}
