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

@Test
public class GoogleSearchTests {
	WebDriver driver;

	@BeforeSuite
	public void initalize() {
		driver = BrowserProvider.createDriver(Browser.CHROME);
		driver.manage().window().maximize();
	}

	@Test
	public void googleSearchTest() {
		driver.get("http://www.google.com");
		GoogleHomePage googleHomePage = new GoogleHomePage(driver);
		GoogleResultsPage googleResultsPage = googleHomePage.searchFor("Selenium with java");

		assertTrue(googleResultsPage.getTitle().equals("Selenium with java - Pesquisa Google"));
		assertTrue(googleResultsPage.isResultPresent("Selenium Tutorial"));
	}

	@AfterSuite
	public void quitDriver() {
		driver.quit();
		driver = null;
	}
}
