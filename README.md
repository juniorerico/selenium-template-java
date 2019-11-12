# selenium-template-java

A Java implementation of a **Selenium Project** using the developing Factory Pattern to manage the WebDrivers, containing Utility Functions and using **TestNG** to execute the tests. This project intends to be in constant evolution and help other tester to create their own test framework using the best developing practices as possible. 

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


## The Page Object Model (POM)

**Page Object Model** is a design pattern which has become popular in test automation for enhancing test maintenance and reducing code duplication. A page object is an object-oriented class that serves as an interface to a page of the system under test.

In this framework, **the Page Objects do not use the Page Factory** concept in order to let the project more flexible and also to avoid slowness.

### Creating a Page Object

All Page Object is class that extends the **PageBase** class. This class don't have much utility now, but let us add functionalities in the future, if necessary.

#### Declaring the Web Elements

The elements of the Page Object are **Strings** containing their **xpath**. In order to keep everything organized and easy to read, the elements must be declared following the pattern bellow:

Web Element Type|	Prefix|	Examples
----------------|-------------|----------
Text Box	|txt|	txtEmail , txtPassword
Button|	btn|	btnRegister , btnLogin
Drop down|	dd|	ddCountry , ddYear
Select Drop Down|	sdd|	sddMonth , sddYear
Check Box|	cb|	cbGender, cbSalaryRange
Header|	hdr|	hdrPrint, hdrUser
Table|	tbl|	tblBooks, tblProducts
Label|	lbl|	lblUserName, lblPassword
Image|	img|	imgProfile, imgCart

#### Example

```java
public class GoogleHomePage extends PageBase {
	private WebDriver driver;

	private String txtSearch = "//input[@name='q']";
	private String btnSearch = "//input[@name='btnK']";
```

#### Using the Web Elements



### To be continued...
