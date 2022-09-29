package keywordsNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGP13 {
	
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
	
	//  testB depends on testC AND testD
	@Test (priority = 2, dependsOnMethods = {"testC", "testD"})
	public void testB() {
		System.out.println("Test B");
	}
	
	@Test (priority = 3)
	public void testC() {
		System.out.println("Test C");
		Assert.fail();  // testC will be fail
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
