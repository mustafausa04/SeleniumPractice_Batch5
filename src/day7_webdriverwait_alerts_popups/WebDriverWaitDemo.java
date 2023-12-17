package day7_webdriverwait_alerts_popups;

import java.time.Duration;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitDemo {

	public static void main(String[] args) throws InterruptedException {
		//-------------------------Explicitly wait---------------------------
		
		//System.setProperty("webdriver.chrome.driver", 
				//"C:\\Users\\MIKE\\Prime Tech School\\Batch5\\week17\\HTML\\Day2\\selenium_tools\\chromedriver_win32/chromedriver.exe");
		
		explicitlyWaitDemo();

	}
	
	
	public static void explicitlyWaitDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// implicitlyWait is for the page objects/elements to be loaded.
		
		// go to etsy.com
		driver.get("https://etsy.com");
		
		// click on signin button
		driver.findElement(By.cssSelector(".select-signin")).click();
		
		// wait until the register button is visible
		   // create an object of webDriverWait class
		WebDriverWait letswait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		   // wait until the visibility of the register button
		
		// Thread.sleep(1000);  - from now on, we don't use thread.sleep unless we want to see what is going on.
		letswait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".select-register")));
		
		// click on the register button
		driver.findElement(By.cssSelector(".select-register")).click();
		
		// wait until the email field is visible
		letswait.until(ExpectedConditions.textToBe(By.id("join-neu-overlay-title"), "Create your account"));
		
		// enter email
		driver.findElement(By.name("email")).sendKeys("jon.dow@gmail.com");
		
		// enter name
		driver.findElement(By.name("first_name")).sendKeys("jon");
		
		// enter password
		driver.findElement(By.name("password")).sendKeys("Hfjkhsdft");
		
		// wait until the register button to be clickable
		//letswait.until(ExpectedConditions.elementToBeClickable(By.name("submit_attempt")));
		
		
		// click on the register button
		driver.findElement(By.name("submit_attempt")).click();
		
	}

}
