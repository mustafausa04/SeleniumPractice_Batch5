package day7_webdriverwait_alerts_popups;

import java.time.Duration;
import java.util.List;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeworkReview {

	public static void main(String[] args) {
		//------------------Select class------------------------
		
		//System.setProperty("webdriver.chrome.driver", 
				//"C:\\Users\\MIKE\\Prime Tech School\\Batch5\\week17\\HTML\\Day2\\selenium_tools\\chromedriver_win32/chromedriver.exe");
		
		//homework2();
		homework3();

	}
	
	public static void homework2() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//go to amazon.com
		driver.get("https://amazon.com");
		//get all the options in the departments select dropdown 
		   // first we need  to locate the dropdown element 
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		   //we need to create an object select class 
		Select letsSelect = new Select(dropdown);
		   //use getOptions() methods 
		   //when we hover over getOptoons() we can see that accept a List 
		List<WebElement> deOptions = letsSelect.getOptions();
		//verify there are total 56 departments and print them out 
		if (deOptions.size() == 56) {
			System.out.println("Number of departments match.");
		}else {
			System.out.println("Number of departments doesn't match." + deOptions.size());
		}
		
		//and print them out 
		for (int i = 0; i < deOptions.size(); i++) {
			System.out.println((i+1) + ". " + deOptions.get(i).getText ());
		}
		
	}
	
	
	public static void homework3() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		 //go to amazon.com
		driver.get("https://amazon.com");
		
	    //verify that you are on the amazon home page. (verify with title).
		//go to the DOM then title and store it in string'
		String homeTitle = "Amazon.com. Spend less. Smile more.";
		if (driver.getTitle().equals(homeTitle)) {
			System.out.println("Title matches!, Test Pass.");
		}else {
			System.out.println("Title Doesn't match!, Test Fail.");
		}
		
	    //verify dropdown value is by default “All Departments” so we compare it with the actual ones
		String defaultDepartment = "All Departments";
		
		     // first we need to locate the dropdown element
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		
		    // we need to create an object select class
		Select letsSelect = new Select(dropdown);
		    //here we are getting all the first selection as a text and compare it 
		    if (letsSelect.getFirstSelectedOption().getText().equals(defaultDepartment)) {
				System.out.println("Default department is All Departments, Test Pass.");
			}else {
				System.out.println("Default department is NOT All Departments, Test Fail.");
			}
		
	     //select department Home & Kitchen, and search coffee mug.
		    letsSelect.selectByVisibleText("Home & Kitchen");
		    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Coffee mug", Keys.ENTER);
		    
	     //verify you are on coffee mug search results page (use title).
		    if (driver.getTitle().contains("Coffee mug")) {
				System.out.println("Title contains the coffee mug search.");
			}else {
				System.out.println("Title Doesn't contain the coffee mug search.");
			}
		    
		    //here we call the element back again so we can select it again because when we pass it first time we can 
		    //read it after unless we call  it back again.
		    Select letsSelect2 = new Select(driver.findElement(By.id("searchDropdownBox")));
	     //verify you are in Home & Kitchen department.
		    if (letsSelect2.getFirstSelectedOption().getText().equals("Home & Kitchen")) {
				System.out.println("The selected department is Home & Kitchen. Test pass.");
			} else {
				System.out.println("The selected department is NOT Home & Kitchen. Test fail.");
			}
		    
		    //if you want to select for example gift cards
		    letsSelect2.selectByVisibleText("Gift Cards");
	}

}
