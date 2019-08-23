package factory;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import enums.Browser;

/**
 * Class responsible to handle the WebDrivers 
 * 
 * @author ejunior
 *
 */
public class BrowserProvider {
	/**
	 * Create a driver with the given capabilities.
	 * 
	 * @param browser
	 * @param capabilities
	 * @return
	 */
	public static WebDriver createDriver(Browser browser, DesiredCapabilities capabilities) {
		capabilities.setBrowserName(browser.toString().toLowerCase());
		return browser.initialize(capabilities);
	}

	/**
	 * Create a driver with default capabilities.
	 * 
	 * @param browser
	 * @return
	 */
	public static WebDriver createDriver(Browser browser) {
		return createDriver(browser, new DesiredCapabilities());
	}

	/**
	 * Create a remote driver given the hub URL and capabilities
	 * 
	 * @param hubUrl
	 * @param browser
	 * @param capabilities
	 * @return
	 */
	public static RemoteWebDriver createDriver(URL hubUrl, Browser browser, DesiredCapabilities capabilities) {
		capabilities.setBrowserName(browser.toString().toLowerCase());
		return new RemoteWebDriver(hubUrl, capabilities);
	}

	/**
	 * Create a remote driver given the hub URL using the default capabilities
	 * 
	 * @param hubUrl
	 * @param browser
	 * @return
	 */
	public static RemoteWebDriver createDriver(URL hubUrl, Browser browser) {
		return createDriver(hubUrl, browser, new DesiredCapabilities());
	}
}
