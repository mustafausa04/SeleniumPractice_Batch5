package day10_utilities;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
	//we are creating this class so we don't have to call these steps everytime and we could call the getDriver() in
	//a different files
	/*WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));*/
	
	public static WebDriver driver;
	static ChromeOptions chromeOptions;

		public static WebDriver getDriver() {
			
			String browser = System.getProperty("browser");
			//we will use the if statement so when we call this getDriver() in a different files and run it, it will
			//prevent the browser to open multiple times so it will open 1 page of browser only otherwise will open
			//multiple pages of the browser when we run it
			if (browser == null) {
				browser = "chrome";//here we could put chrome, firefox, edge to choose the browser we want to run, we
			}                      //could also use chrome-headless but it will not launch the chrome browser, when we 
			                       //run it will run only behind as an API, so we need this mode because in reality 
			                       //we run code on virtual machine not ours so no one is there to see the browser 
			if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
				switch(browser) {
				case "chrome-headless" :
				    chromeOptions = new ChromeOptions();
					chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
					chromeOptions.addArguments("--headless");
					driver = new ChromeDriver(chromeOptions);
					break;
				case "chrome" :
					chromeOptions = new ChromeOptions();
					chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
					driver = new ChromeDriver();
					break;
				case "firefox" :
					driver = new FirefoxDriver();
					break;
				case "firefox-headless" :
					FirefoxOptions firefoxOptions = new FirefoxOptions();
					firefoxOptions.addArguments("--headless");
					driver = new FirefoxDriver(firefoxOptions);
					break;
				case "safari" :
					driver = new SafariDriver();
					break;
				case "edge" :
					driver = new EdgeDriver();
					break;
				default:
					ChromeOptions Options = new ChromeOptions();
					Options.addArguments("--headless");
					driver = new ChromeDriver(Options);
					break;
				}
			}
			return driver;
		}
		
		//we can call this method in a different files or class to close down the browser after we launch it
		public static void quitDriver() {
			if (driver != null) {
				driver.quit();
				driver = null;
			}
	    }

}
