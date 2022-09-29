package setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
/*	public static WebDriver openChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", "H:\\SW Testing\\chromedriver_win32(1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
*/	
	public static WebDriver openFirefoxBrowser() {
        System.setProperty("webdriver.firefox.driver", "H:\\SW Testing\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
/*	public static WebDriver openInternetExplorerBrowser() {
		System.setProperty("webdriver.internetExplorer.driver", "H:\\SW Testing\\IEDriverServer_Win32_4.3.0\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		return driver;
	}
*/
}
