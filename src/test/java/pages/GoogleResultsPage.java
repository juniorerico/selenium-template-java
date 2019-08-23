package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import factory.PageBase;

/**
 * Example of Page Object Model(POM) using Page Factory of the Google Search
 * Page.
 * 
 * @author ejunior
 *
 */
public class GoogleResultsPage extends PageBase {
	private WebDriver driver;

	@FindBy(how = How.NAME, using = "q")
	private WebElement txtSearch;

	@FindBy(how = How.CSS, using = "[jsname='Tg7LZd']")
	private WebElement btnSearch;

	@FindBy(how = How.CLASS_NAME, using = "rc")
	private List<WebElement> divResults;

	/**
	 * Constructor of the page. Initialize the Page Factory objects.
	 * 
	 * @param driver
	 */
	public GoogleResultsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Performs a simple google search
	 * 
	 * @param query
	 */
	public void searchFor(String query) {
		txtSearch.sendKeys(query);
		waitUntil(ExpectedConditions.elementToBeClickable(btnSearch)).click();
	}

	public boolean isResultPresent(String resultTitle) {
		for (WebElement result : divResults) {
			WebElement title = result.findElement(By.cssSelector(".r .ellip"));
			System.out.println(title.getText());

			if (title.getText().equals(resultTitle))
				return true;
		}

		return false;
	}

	public List<WebElement> getDivResults() {
		return divResults;
	}
}
