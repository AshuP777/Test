package Pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;
import pages.MessengerPage;
import pages.RoomsPage;

public class TestClass {
	
public static void main(String[] args) throws InterruptedException{
		
        System.setProperty("webdriver.chrome.driver", "H:\\SW Testing\\chromedriver_win32(1)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openMessenger();
		
		MessengerPage messengerPage = new MessengerPage(driver);
		messengerPage.openRooms();
		Thread.sleep(3000);
		
		RoomsPage roomsPage = new RoomsPage(driver);
		roomsPage.contactToHelpCenter();
		
		System.out.println(driver.getCurrentUrl());
}

}
