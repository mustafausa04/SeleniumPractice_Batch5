package reviewSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class homeWork {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", 
				//"C:\\Users\\MIKE\\Prime Tech School\\Batch5\\week17\\HTML\\Day2\\selenium_tools\\chromedriver_win32/chromedriver.exe");
		
		//note: because the main method is static and the other one test1() is static too then we can call it here
		//without creating an object for it we can call it direct because both methods up and down are static
		test1();

	}
	
	public static void test1() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		// go to the URL "http://practice.primetech-apps.com/practice/text-box"
		driver.get("https://demoqa.com/text-box");
		Thread.sleep(1000);
		//Find the Full Name field and store it in a variable, do same with the other fields 
		WebElement fNameTextbox = driver.findElement(By.id("userName"));
		WebElement emailTextbox = driver.findElement(By.id("userEmail"));
		WebElement currentAddressbox = driver.findElement(By.id("currentAddress"));
		WebElement permentAddressbox = driver.findElement(By.id("permanentAddress"));
		WebElement submitBtn = driver.findElement(By.id("submit"));

        //enter name,email, current address, perminnent address
		String actulFullName = "PrimeTech";
		String actuaEmail = "primetech@school.com";
		String actualCaddress = "Fairfax city";
		String actualPaddress = "VA";
		
		fNameTextbox.sendKeys(actulFullName);
		emailTextbox.sendKeys(actuaEmail);
		Thread.sleep(1000);
		currentAddressbox.sendKeys(actualCaddress);	
		permentAddressbox.sendKeys(actualPaddress);
		
		submitBtn.click();
		String expectedFName = fNameTextbox.getAttribute("value");
		String expectedemail = emailTextbox.getAttribute("value");
		String expectedCaddress= currentAddressbox.getAttribute("value");
		String expectedPaddress= permentAddressbox.getAttribute("value");
		Thread.sleep(2000);
		
		//this step just to make sure that we get the value
		System.out.println(expectedFName);
		System.out.println(expectedemail);
		System.out.println(expectedCaddress);
		System.out.println(expectedPaddress);
		
		// Validating full name 
		if(expectedFName.equals(actulFullName)) {
			System.out.println("TEST PASS: The expected full name: "+ expectedFName + "is equals the actual full name " +actulFullName);
		}else {
			System.out.println("Test failed");
		}
		// validate the email 
		if(expectedemail.equals(actuaEmail)) {
			System.out.println("TEST PASS: The expected email: "+ expectedemail + " is equals the actual email " +actuaEmail);

		}else {
			System.out.println("TEST FAILD");
		}
		
		// validate the current address
		if(expectedCaddress.equals(actualCaddress)) {
			System.out.println("TEST pass: the expected address is equals to the actual address");
			
		}else {
			System.out.println("TEST FAIL");
		}
		// validate the perment address 
		if(expectedPaddress.equals(actualPaddress)) { 
			System.out.println("TEST PASS: the expected current address is equals to the actual current address");
			
		}
	}
}