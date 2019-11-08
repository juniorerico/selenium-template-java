package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import enums.Browser;
import factory.BrowserProvider;
import pages.GoogleHomePage;
import pages.GoogleResultsPage;

/**
 * Example of a test case using TestNG
 * 
 * @author ejunior
 *
 */
@Test
public class GoogleSearchTests {
	private WebDriver driver;

	/**
	 * This method will be executed before the test start.
	 */
	@BeforeSuite
	public void initalize() {
		driver = BrowserProvider.createDriver(Browser.CHROME);
		driver.manage().window().maximize();
	}

	/**
	 * This method perform a google search test. We can have multiple @Test methods inside this class.
	 */
	@Test
	public void googleSearchTest() {
		driver.get("http://www.google.com");
		
		GoogleHomePage googleHomePage = new GoogleHomePage(driver);
		GoogleResultsPage googleResultsPage = googleHomePage.searchFor("Selenium with java");

		assertTrue(googleResultsPage.getTitle().equals("Selenium with java - Pesquisa Google"));
		assertTrue(googleResultsPage.isResultPresent("Selenium Tutorial"));
	}

	/**
	 * This method will be executed at the end of the test.
	 */
	@AfterSuite
	public void quitDriver() {
		driver.quit();
		driver = null;
	}
}
