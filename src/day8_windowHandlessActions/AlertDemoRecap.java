package day8_windowHandlessActions;

import java.time.Duration;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertDemoRecap {

	public static void main(String[] args) {
		//-------------------Alerts---------------------------
		//System.setProperty("webdriver.chrome.driver", 
				//"C:\\Users\\MIKE\\Prime Tech School\\Batch5\\week17\\HTML\\Day2\\selenium_tools\\chromedriver_win32/chromedriver.exe");
		
		//alert_testcase3();
		alert_testcase4();

	}
	
	
	public static void alert_testcase4() {
		//Test case 4
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//go to http://practice.primetech-apps.com/practice/alerts 
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		
		//Click on the ‘Prompt Alert’ button and type PrimeTech. 
		String input = "Helil";
		driver.findElement(By.id("prompt")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		
		// switch to the alert
		Alert handle = driver.switchTo().alert();
		handle.sendKeys(input);
		
		//Then dismiss the Alert. 
		handle.dismiss();//it means click cancel
		
		//Verify that “User cancelled the prompt.” text displays.
		//wait the message visibility
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo")));
		String actualMessage = driver.findElement(By.id("demo")).getText();
		
		String expectedMessage = "User cancelled the prompt.";
		
		if (actualMessage.equals(expectedMessage)) {
			System.out.println("Cancelled Message match, Test Pass.");
		}else {
			System.out.println("Cancelled Message does not match, Test Fail.");
		}
	}
	
	
	public static void alert_testcase3() {
		//Test case 3
		WebDriver  driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//go to http://practice.primetech-apps.com/practice/alerts 
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		
		//Click on the ‘Prompt Alert’ button and type PrimeTech
		String input = "PrimeTech";
		driver.findElement(By.id("prompt")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert handle = driver.switchTo().alert();
		handle.sendKeys(input);
		
		//Then accept the Alert. Verify that a greeting message displays as
		//“Hello <your input>! How are you today?”.
		
		handle.accept();//it means click ok
		
		//wait the message visibility
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo")));
		String actualMessage = driver.findElement(By.id("demo")).getText();
		
		String expectedMessage = "Hello "+ input +"! How are you today?";
		
		if (actualMessage.equals(expectedMessage)) {
			System.out.println("Greeting match, Test Pass.");
		}else {
			System.out.println("Greeting does not match, Test Fail.");
		}
	}

}
