package seleniuminstallation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstBrowserLaunch {
	
	public static void main(String[] args) {
		//you have to go to teachable and watch the recording video (Day1 introduction to Selenium and first browser
		// launch Tuesday July 18 2023)
		
		
		
		/*// this is how it looks like on mac computer
				System.setProperty("webdriver.chrome.driver", 
						"/Users/primetech/Documents/selenium_tools/chromedriver_mac64/chromedriver");
		
		// on windows computer, this is how it looks like
		       //System.setProperty("webdriver.chrome.driver", 
						//"/Users/primetech/Documents/selenium_tools/chromedriver_mac64/chromedriver.exe");*/
				
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\MIKE\\Prime Tech School\\Batch5\\week17\\HTML\\Day2\\selenium_tools\\chromedriver_win32/chromedriver.exe");
		
		// we are creating an object here
		// WebDriver is an interface being a reference type
		// ChromeDriver is a class being an object type here.
		WebDriver driver = new ChromeDriver();
		
		// navigate to amazon
		driver.get("https://amazon.com");
		
		// type for coffee mug in search field in amazon webpage
		// 1. find the element of the search field which is the input box for the search box inspect it, you will see
		//an id get the text in that id and put it in between the " " like below
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		  
		// 2. sendKeys() to the element we found which is 
		//here we put the words "coffee mug" only
		searchBox.sendKeys("coffee mug");//hover over sendkeys you will see it void so we can use it to return anything
		
		// click on search button to inspect it in amazon webpage and get what it has in the id " " copy that and paste
		//it like below
		// 1. find the search button element
		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
		
		// 2. click on the element which is the search button
		searchButton.click();
		
		//now run it, everything will run automaticlly, first will take you to amazon website,then type coffee mug there
		//the it will find the search button then click on it.
		
		
	}

}
