package factory;

import org.openqa.selenium.WebDriver;

/**
 * Class to be extended by all Page Objects Model (POM) classes.
 * 
 * Contains common methods to be used by every page.
 * 
 * @author ejunior
 *
 */
public class PageBase {
	private WebDriver driver;
	
	public PageBase (WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Get the page title
	 * 
	 * @return
	 */
	public String getTitle() {
		return driver.getTitle();
	}
}
