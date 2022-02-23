package exercise_1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG_annotations {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before test");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");
	}

	@BeforeMethod
	public void beforeMethod1() {
		System.out.println("Before method 1");
	}

	@Test
	public void testCase1() {
		System.out.println("This is test case 1");
	}

	@AfterMethod
	public void afterMethod1() {
		System.out.println("After method 1");
	}

	@BeforeMethod
	public void beforeMethod2() {
		System.out.println("Before method 2");
	}

	@Test
	public void testCase2() {
		System.out.println("This is test case 2");
	}

	@AfterMethod
	public void afterMethod2() {
		System.out.println("After method 2");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After test");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After suite");
	}

}
