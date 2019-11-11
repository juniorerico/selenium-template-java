# selenium-template-java

A Java implementation of a **Selenium Test Project** using the Factory Pattern to manage the WebDrivers, containing Utility Functions and using **TestNG** to execute the tests. This project intends to be in constant evolution and help other tester to create their own test framework using the best developing practices as possible. 

**Feel free to fork it and suggest any improvement!**


## The Factory Pattern

In class-based programming, the factory method pattern is a pattern that uses factory methods to deal with the problem of **creating objects without having to specify the exact class** of the object that will be created.

The purpose of using this pattern in this project is to help us to create the **WebDriver** object without worrying about the creation logic every time.

### The Browser Enum

This enum defines how each browser is initialized or instantiated.

```java
public abstract WebDriver initialize(DesiredCapabilities capabilities);
```

To handle a new browser, just create a new **Browser Enum field** and implement the **initialize** method that return a WebDriver.

```java
CHROME {
    @Override
		public WebDriver initialize(DesiredCapabilities capabilities) {
			synchronized (BrowserProvider.class) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.merge(capabilities);
				return new ChromeDriver(options);
			}
		}
	}
```

## Instantiating a WebDriver

After implementing the initialize logic behind the scenes, in order to help us to instantiate a new WebDriver, just call the method **createDriver** of the class **BrowserProvider** passing a **Browser Enum**.

```java
WebDriver driver = BrowserProvider.createDriver(Browser.CHROME);
```



### To be continued...
