package pack0;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MessengerPage;
import pages.RoomsPage;

public class VerifyRoomsPage {
	
	private WebDriver driver ;
	private LoginPage loginPage ;
	private RoomsPage roomsPage ;
	
	@BeforeClass
	public void openBrowser() {
		System.out.println("Before Class");
        System.setProperty("webdriver.chrome.driver", "H:\\SW Testing\\chromedriver_win32(1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void openRoomPage() {
		System.out.println("Before Method");
        driver.get("https://www.facebook.com/");
		
		loginPage = new LoginPage(driver);
		loginPage.openMessenger();
		
		MessengerPage messengerPage = new MessengerPage(driver);
		messengerPage.openRooms();
		roomsPage = new RoomsPage(driver);
	}
	
	@Test
	public void verifycontactToHelpCenterButton() {
		System.out.println("Test 1");
        roomsPage.contactToHelpCenter();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		// Current Page URL and TITLE
		if(url.equals("https://www.messenger.com/help") && title.equals("Messenger Help Centre")) {
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
	}
	
	@Test
	public void verifygoBackToMessengerButton() {
		System.out.println("Test 2");
        roomsPage.goBackToMessenger();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		// Current Page URL and TITLE
		if(url.equals("https://www.messenger.com/") && title.equals("Messenger")) {
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
		System.out.println("LOGOUT");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
		driver.close();
	}

}
