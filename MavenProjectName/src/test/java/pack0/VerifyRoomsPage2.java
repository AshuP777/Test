package pack0;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginPage;
import pages.MessengerPage;
import pages.RoomsPage;
import utils.Utility;

public class VerifyRoomsPage2 {
	
	private WebDriver driver ;
	private LoginPage loginPage ;
	private RoomsPage roomsPage ;
	private MessengerPage messengerPage ;
	private SoftAssert soft ;
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName) {
		System.out.println("browserName");
		
		if(browserName.equals("Crome"))
		{
        System.setProperty("webdriver.chrome.driver", "H:\\SW Testing\\chromedriver_win32(1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

/*		if(browserName.equals("Firefox"))
		{
        System.setProperty("webdriver.firefox.driver", "H:\SW Testing\geckodriver-v0.31.0-win64\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
*/		
		if(browserName.equals("InternetExplorer"))
		{
        System.setProperty("webdriver.internetExplorer.driver", "H:\\SW Testing\\IEDriverServer_Win32_4.3.0\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}
	@BeforeClass
	public void creatPOMObject() {
		loginPage = new LoginPage(driver);
		messengerPage = new MessengerPage(driver);
		roomsPage = new RoomsPage(driver);
	}
	
	@BeforeMethod
	public void openRoomPage() {
	    driver.get("https://www.facebook.com/");
		loginPage.openMessenger();
		messengerPage.openRooms();
		soft = new SoftAssert();
	}
	
	@Test
	public void verifycontactToHelpCenterButton() {
		System.out.println("verifycontactToHelpCenterButton");
        roomsPage.contactToHelpCenter();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		soft.assertEquals(url, "https://www.messenger.com/help", "URL of Home is wrong"); 
	    soft.assertEquals(title, "Messenger Help Centre", "Title of Home page is wrong");
		
		soft.assertAll();	
	}
	
	@Test
	public void verifygoBackToMessengerButton() {		
		System.out.println("verifygoBackToMessengerButton");
        roomsPage.goBackToMessenger();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		soft.assertEquals(url, "https://www.messenger.com/");
		soft.assertEquals(title, "Messenger");
		
		soft.assertAll();
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
		System.out.println("LOGOUT");
	}
	
	@AfterClass
	public void afterClass() {
		loginPage = null;
		messengerPage = null;
		roomsPage = null;
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("After Class");
		driver.close();
		driver = null;
		System.gc();    // garbeg collector
	}

}
////"H:\SW Testing\IEDriverServer_Win32_4.3.0\IEDriverServer.exe"
