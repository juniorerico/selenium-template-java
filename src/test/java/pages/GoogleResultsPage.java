package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.PageBase;
import utils.SeleniumUtils;

/**
 * Example of Page Object Model(POM) using Page Factory of the Google Search
 * Page.
 * 
 * @author ejunior
 *
 */
public class GoogleResultsPage extends PageBase {
	private WebDriver driver;
	
	private String txtSearch = "//input[@name='q']";
	private String btnSearch = "//input[@jsname='Tg7LZd']";
	private String divResults = "//div[contains(@class, 'rc')]";
	private String linkResult = ".//div[contains(@class, 'r')]/a[1]";

	/**
	 * Constructor of the page. Initialize the Page Factory objects.
	 * 
	 * @param driver
	 */
	public GoogleResultsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Performs a simple google search
	 * 
	 * @param query
	 */
	public void searchFor(String query) {
		SeleniumUtils.waitForElement(driver, txtSearch).sendKeys(query);
		SeleniumUtils.waitForElementToBeClickable(driver, btnSearch).click();
	}

	/**
	 * Check if a result is present inside the page
	 * 
	 * @param resultTitle
	 * @return
	 */
	public boolean isResultPresent(String resultTitle) {
		List<WebElement> results = getDivResults();
		
		for (WebElement result : results) {
			WebElement title = result.findElement(By.xpath(linkResult));
			
			System.out.println(title.getText());

			if (title.getText().contains(resultTitle))
				return true;
		}

		return false;
	}

	/**
	 * Get the results elements inside the page
	 * 
	 * @return
	 */
	public List<WebElement> getDivResults() {
		return SeleniumUtils.waitForElements(driver, divResults);
	}
}
