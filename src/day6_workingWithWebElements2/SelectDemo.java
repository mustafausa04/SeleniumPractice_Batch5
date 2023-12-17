package day6_workingWithWebElements2;

import java.time.Duration;
import java.util.List;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SelectDemo {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", 
				//"C:\\Users\\MIKE\\Prime Tech School\\Batch5\\week17\\HTML\\Day2\\selenium_tools\\chromedriver_win32/chromedriver.exe");
		
		SelectDemo demo = new SelectDemo();// creating object
		//calling method
		demo.selectDemo();

	}
	
	
	public void selectDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// go to http://practice.primetech-apps.com/practice/select-menu
		driver.get("http://practice.primetech-apps.com/practice/select-menu");
		
		// select French from the language dropdown
		// whenever you get a dropdown which started with <select> tagname in HTML, 
		// at that time you can use this Select class.
		
		WebElement languageDropdown = driver.findElement(By.id("language"));
		Select letsSelect = new Select(languageDropdown);//here we used Select class as we mentioned above
		
		//using getAllOptions() and get text print them
		List<WebElement> allOptions = letsSelect.getOptions();
		for (WebElement option : allOptions) {
			System.out.println(option.getText());
		}
		
		//using getFirstSelectedOption()
		WebElement firstSelectedOption = letsSelect.getFirstSelectedOption();
		System.out.println("First selected item is: " + firstSelectedOption.getText());
		Thread.sleep(2000);
		
		
		// selectByVisibleText - most commonly used one
		letsSelect.selectByVisibleText("French");
		Thread.sleep(2000);
		
		//using getFirstselectedoption() 
		System.out.println("After selecting French, first selected option is: " 
		+ letsSelect.getFirstSelectedOption().getText());
		
		//using selectByIndex()
		letsSelect.selectByIndex(4);
		
		Thread.sleep(2000);
		
		//using selectByValue
		letsSelect.selectByValue("Spanish");
		Thread.sleep(2000);
		
		// deselect option only works with multi-select dropdown
		
		
		// select methods  only works with a dropdown which is created by <select> tag in html or DOM
		// if the dropdown is not created with <select> tag in HTML, we just treat the dropdown as a regular element.
		// we find the dropdown element, and click on it to expand, then find the value we wanna select, 
		// click on it.
		
		
	}

}
