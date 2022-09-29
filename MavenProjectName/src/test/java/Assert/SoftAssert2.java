package Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MessengerPage;
import pages.RoomsPage;

public class SoftAssert2 {
	
	private WebDriver driver ;
	private LoginPage loginPage ;
	private RoomsPage roomsPage ;
	private SoftAssert soft ;
	
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
		soft = new SoftAssert();
	}
	
	@Test
	public void verifycontactToHelpCenterButton() {
		roomsPage.contactToHelpCenter();
        String url = driver.getCurrentUrl();
		String title = driver.getTitle();
				
		soft.assertEquals(url, "https://www.messenger.com/help", "URL of Home page is wrong");
		soft.assertEquals(title, " Messenger Help Centre", "Title of Home page is wrong");
		
		soft.assertAll();
	}
	
	@Test
	public void verifygoBackToMessengerButton() {
		roomsPage.goBackToMessenger();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		soft.assertEquals(url, "https://www.messenger.co/");
		soft.assertEquals(title, "Messenge");
		
		soft.assertAll();
		
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
