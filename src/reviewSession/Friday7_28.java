package reviewSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Friday7_28 {

	public static void main(String[] args) throws InterruptedException  {
		
		//System.setProperty("webdriver.chrome.driver", 
				//"C:\\Users\\MIKE\\Prime Tech School\\Batch5\\week17\\HTML\\Day2\\selenium_tools\\chromedriver_win32/chromedriver.exe");
		
		testCase1();

	}
	
    public static void testCase1() throws InterruptedException  {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
    //Step 2: Store the String "http://practice.primetech-apps.com" in a variable and name "ActualUrl".
	String actualUrl = "http://practice.primetech-apps.com";
	driver.get(actualUrl);
	Thread.sleep(1000);
	
    //Step 3: Locate "Practice Now Button" for Elements and store in a WebElement variable name it "practiceBtn".
	WebElement practiceBtn = driver.findElement(By.id("elements"));
	
    //Step 4: Click on "practiceBtn".
	practiceBtn.click();
	Thread.sleep(1000);
	
    //Step 5: Locate "Text Box Button" and store in a WebElement variable name it "textBoxBtn". then click on it
	WebElement textBoxBtn = driver.findElement(By.id("text-box"));
	textBoxBtn.click();
	Thread.sleep(2000);
	
    //Step 6: Get the First name text box and store it in WebElement name it "fNameTxtBox".
	WebElement fNameTxtBox = driver.findElement(By.id("firstName"));
	
    //Step 7: Get the Last name text box and store it in WebElement name it "lNameTxtBox". 
	WebElement lNameTxtBox = driver.findElement(By.id("lastName"));
	
    //Step 8: Get the Email text box and store it in WebElement name it "emailTxtBox" .
	WebElement emailTxtBox = driver.findElement(By.id("email"));
	
    //Step 9: Get the Password text box and store it in WebElement name it "passwordTxtBox" .
	WebElement passwordTxtBox = driver.findElement(By.id("password"));
	
    //Step 10: Create String variables for 'actualFname, actualLName, actualEmail, actualPassword' and assign values to each one.
	String actualFname = "PrimeTech";
	String actualLName = "school";
	String actualEmail = "primetech@school.com";
	String actualPassword= "12345";
	Thread.sleep(2000);
	
    //Step 11: Use SendKeys function to send all values to the text box. 
	fNameTxtBox.sendKeys(actualFname);
	lNameTxtBox.sendKeys(actualLName);
	emailTxtBox.sendKeys(actualEmail);
	passwordTxtBox.sendKeys(actualPassword);
	
    //Step 12: find the submit btn and Click on it
	WebElement submitBtn = driver.findElement(By.className("btn-primary"));
	submitBtn.click(); 
	Thread.sleep(2000);
    
	//Step 13: Get all the User Info and store it Strings name them expected'Variable'
	String expectedFname = fNameTxtBox.getAttribute("value");
	String expectedLname = lNameTxtBox.getAttribute("value");
	String expectedEmail = emailTxtBox.getAttribute("value");
	String expectedPassword = passwordTxtBox.getAttribute("value");
	Thread.sleep(2000);
	
	//Step 14: Validate all the User Info and print statement to confirm the validation for each field.
	if (expectedFname.equals(actualFname)) {
	    System.out.println("First name passed: " + expectedFname);
	} else {
	    System.out.println("First name failed. Expected: " + actualFname + ", Actual: " + expectedFname);
	}

	if (expectedLname.equals(actualLName)) {
	    System.out.println("Last name is passed: " + expectedLname);
	} else {
	    System.out.println("Last name failed. Expected: " + actualLName + ", Actual: " + expectedLname);
	}

	if (expectedEmail.equals(actualEmail)) {
	    System.out.println("Email passed: " + expectedEmail);
	} else {
	    System.out.println("Email failed. Expected: " + actualEmail + ", Actual: " + expectedEmail);
	}

	if (expectedPassword.equals(actualPassword)) {
	    System.out.println("Password passed: " + expectedPassword);
	} else {
	    System.out.println("Password failed. Expected: " + actualPassword + ", Actual: " + expectedPassword);
	}
	
	}
	//this code is not running for some reason

}
