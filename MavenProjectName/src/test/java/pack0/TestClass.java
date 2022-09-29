package pack0;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;
import pages.MessengerPage;
import pages.RoomsPage;

public class TestClass {
	
public static void main(String[] args) throws InterruptedException{
		
        System.setProperty("webdriver.chrome.driver", "H:\\SW Testing\\chromedriver_win32(1)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openMessenger();
		
		MessengerPage messengerPage = new MessengerPage(driver);
		messengerPage.openRooms();
		Thread.sleep(3000);
		
		RoomsPage roomsPage = new RoomsPage(driver);
		roomsPage.contactToHelpCenter();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		// Current Page URL and TITLE
		if(url.equals("https://www.messenger.com/help") && title.equals("Help Centre")) {
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
}

}
