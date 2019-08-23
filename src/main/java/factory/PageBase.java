package factory;

import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class to be extended by all page objects
 * 
 * @author ejunior
 *
 */
public class PageBase {
	private WebDriver driver;
	private final int DEFAULT_WAIT_TIME = 10;
	
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
	
	/**
	 * Wait for a certain condition to occur for up to DEFAULT_WAIT_TIME
	 * 
	 * @param condition
	 * @return
	 */
	public <T> T waitUntil(Function<? super WebDriver, T> condition) {
		return waitUntil(condition, DEFAULT_WAIT_TIME);
	}
	
	/**
	 * Wait for a certain condition to occur for up to a given time
	 * 
	 * @param condition
	 * @param waitTime
	 * @return
	 */
	public <T> T waitUntil(Function<? super WebDriver, T> condition, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		return wait.until(condition);
	}
}
