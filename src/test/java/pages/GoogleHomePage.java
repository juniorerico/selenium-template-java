package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import factory.PageBase;

/**
 * Example of Page Object Model(POM) using Page Factory of the Google Home Page.
 * 
 * @author ejunior
 *
 */
public class GoogleHomePage extends PageBase {
	private WebDriver driver;
	
	@FindBy(how = How.NAME, using = "q")
	private WebElement txtSearch;
	
	@FindBy(how = How.NAME, using = "btnK")
	private WebElement btnSearch;

	/**
	 * Constructor of the page. Initialize the Page Factory objects. 
	 * 
	 * @param driver
	 */
	public GoogleHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Performs a simple google search and return the next page.
	 * 
	 * @param query
	 */
	public GoogleResultsPage searchFor(String query) {
		txtSearch.sendKeys(query);
		waitUntil(ExpectedConditions.elementToBeClickable(btnSearch)).click();
		
		return new GoogleResultsPage(driver);
	}
}
