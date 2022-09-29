package keywordsNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGP16 {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@Test (priority = 4)
	public void testA() {
		System.out.println("Test A");
	}
	
	@Test (priority = 2, timeOut = 3000)  // 300ms = 3 sec
	public void testB() throws InterruptedException {
		System.out.println("Test B");
		
		Thread.sleep(4000);  //2000
		
		System.out.println("HIiii");
	}
	
	@Test (priority = 3)
	public void testC() {
		System.out.println("Test C");
	}
	
	@Test (priority = 1)
	public void testD() {
		System.out.println("Test D");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println();
	}

}
