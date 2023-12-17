package reviewSession;

import java.time.Duration;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Thursday8_10 {

	public static void main(String[] args) throws InterruptedException {
		//-----------Implicity is to set up a waiting time for the whole page elements
		//-----------expicity is to set up waiting time for one element only 
		
		//System.setProperty("webdriver.chrome.driver", 
				//"C:\\Users\\MIKE\\Prime Tech School\\Batch5\\week17\\HTML\\Day2\\selenium_tools\\chromedriver_win32/chromedriver.exe");
		
		//testCase1();
		registerUser();

	}
	
	
	public static void testCase1() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
        //Navigate to (https://www.thetestingworld.com/testings).
		String url = "https://www.thetestingworld.com/testings";
		driver.get(url);
        //Maximize the browser & declare implicitly wait for 5 second.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Implicit Wait:
        //1- Set globally
        //2- Applies to all elements
        //3- Does not require a setting of a condition
        //4- Best used when all elements are loaded before the duration time set

        //Locate  "Register" webelement & varifly the element isDisplayed().
		//the isDisplayed() is returns true or false to show me if the button is presented
		WebElement registerBtn = driver.findElement(By.id("tab1"));
		System.out.println("The Register Button is Displayed " + registerBtn.isDisplayed());
		
        //Locate the textBox's for:  userName, email, passWord & sendKeys the values for each box.
		WebElement userName = driver.findElement(By.xpath("//input[@name='fld_username']"));
		String userN = "KM";
		WebElement email = driver.findElement(By.xpath("//input[@name='fld_email']"));
		String userEmail = "km@gmail.com";
		WebElement passWord = driver.findElement(By.xpath("//input[@name='fld_password']"));
		WebElement confirmPassW = driver.findElement(By.xpath("//input[@name='fld_cpassword']"));
		String userPassw = "12345";
		
		userName.sendKeys(userN);
		email.sendKeys(userEmail);
		passWord.sendKeys(userPassw);
		confirmPassW.sendKeys(userPassw);
		
		
        //Locate the "Date of birth", send the date in the correct format then click "Enter" using (Keys.ENTER).
		WebElement dob = driver.findElement(By.xpath("//input[@name='dob']"));//here just to locate the box
		String userDOB = "12/12/2000";
		
		//dob.sendKeys(userDOB);     //here to put the date in the box
		//dob.sendKeys(Keys.ENTER);  //here to click enter so the date schedule will go away otherwise it will stay
		
		//this is a short cut for the 2 steps above
		dob.sendKeys(Keys.chord(userDOB, Keys.ENTER));
		//dob.sendKeys("06/13/1997", Keys.ENTER);  //here is also similar to the above
		
        //Locate "Select Country" dropdown & use select one for each: by value/visible text/index
		//when you run this block here you will see it will show nothing in the country box the first 2 seconds because
		//of index 0 then it will change to value 4 then it will change to "united state"
		WebElement countryDD = driver.findElement(By.id("countryId"));//to find the box or dropdown
		Select sel = new Select(countryDD);//because it is "select" then we have to create an object
		sel.selectByIndex(0);    //here we select index 0 which is "select country" so when you run the code you will not
		Thread.sleep(2000);      //anything in the box but if we choose index 1 you will see "Afghanstan"
		sel.selectByValue("4");  //here we select by value  
		Thread.sleep(2000);
		sel.selectByVisibleText("United States"); //here we select by visible
		
        //Locate the "State" dropdown, use explicit wait for 3 seconds the select state by value.
		//here we need to make the "State" dropdown to wait for 3 seconds after the previous step so we can have time 
		//to see the changes so we will use the Explicit wait because we can use it for individual elements
		WebElement stateDD = driver.findElement(By.id("stateId"));// here we located the "State" dropdown
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));//here we will wait for 3 seconds
		wait.until(ExpectedConditions.elementToBeClickable(stateDD));//here wait until the it will be clickable
		
		//here we need to select from State dropdown by value "3974" which is Virginia but again since it is Select
		//then we need to create an object first
		Select sle1 = new Select(stateDD); //creating an object for new Select dropdown
		sle1.selectByValue("3974");        //select by value

		
		
        //Locate the "City" dropdown, use explicit wait for 3 seconds the select state by value 
		WebElement cityDD = driver.findElement(By.id("cityId"));
		//class name, wt is object name, then new, then constructor name which is similar to class name with 2 parameter
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
		wt.until(ExpectedConditions.elementToBeClickable(cityDD));
		
		Select sle2 = new Select(cityDD);
		sle2.selectByVisibleText("Reston");
		
		
        //Locate checkbox for "terms & conditions" & "Sign up" then click on both.  
		
	}
	
	
     public static void registerUser() throws InterruptedException {
		
        //Test case: registerUser    
        //Step 1: Go to URL "https://www.thetestingworld.com/testings".
		WebDriver driver = new ChromeDriver();
		String url = "https://www.thetestingworld.com/testings";
		driver.get(url);
        //Step 2: Maximize the browser & declare implicitly wait for 5 second.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Step 3:  Verify the browser landed on the "Register" page. 
		
		WebElement registerBtn = driver.findElement(By.xpath("//*[@for='tab1']"));
		System.out.println("The Register Button is Displayed " + registerBtn.isDisplayed());

        //Step 4: Locate all the required Text Boxes, Dropdowns, Radio Buttons.
	
		WebElement userName = driver.findElement(By.xpath("//input[@name='fld_username']"));
		String userN = "helloT";
		WebElement email = driver.findElement(By.xpath("//input[@name='fld_email']"));
		String userEmail = "helloTech@hotmail.com";
		WebElement passWord = driver.findElement(By.xpath("//input[@name='fld_password']"));
		WebElement confirmPassW = driver.findElement(By.xpath("//input[@name='fld_cpassword']"));
		String userPassw = "12345";
		
		userName.sendKeys(userN);
		email.sendKeys(userEmail);
		passWord.sendKeys(userPassw);
		confirmPassW.sendKeys(userPassw);
		
		WebElement dob = driver.findElement(By.xpath("//input[@name='dob']"));
		String userDOB = "12/12/2000";
		
		//dob.sendKeys(userDOB);
		//dob.sendKeys(Keys.ENTER);
		//here is short cut for the 2 steps above
		dob.sendKeys(Keys.chord(userDOB, Keys.ENTER));
		
		WebElement phoneNumber = driver.findElement(By.cssSelector("input[name='phone']"));
		String userPHnumber = "1012023090";
		phoneNumber.sendKeys(userPHnumber);
		
		WebElement address = driver.findElement(By.cssSelector("input[name='address']"));
		String userAddress = "1234 fairfax blvd";
		address.sendKeys(userAddress);
		
		WebElement radioAddresstype = driver.findElement(By.cssSelector("input[value='office']"));
		radioAddresstype.click();
		
		WebElement genderDD = driver.findElement(By.cssSelector("select[name='sex']"));
		Select sl3 = new Select(genderDD);
		sl3.selectByVisibleText("Male");
		
		WebElement countryDD = driver.findElement(By.id("countryId"));
		Select sel = new Select(countryDD);
		sel.selectByValue("231");
		
		//explicity wait for state dropdown 
		WebElement stateDD = driver.findElement(By.id("stateId"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(stateDD));
		Select sle1 = new Select(stateDD);
		sle1.selectByValue("3974");
		
		//explicity wait for city dropdown
		WebElement cityDD = driver.findElement(By.id("cityId"));
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
		wt.until(ExpectedConditions.elementToBeClickable(cityDD));
		Select sle2 = new Select(cityDD);
		sle2.selectByVisibleText("Fairfax");
		
		WebElement zipCode = driver.findElement(By.cssSelector("input[name='zip']"));
		String userZipCode = "11001";
		zipCode.sendKeys(userZipCode);
		
		

        //Step 5: Locate the checkbox for Terms and Conditions and Sign Up button and click.  
		//note: with check button you need to wrap the xpath just like below and choose the button like [1] or [2]
		WebElement termsAndCond = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		termsAndCond.click();
		WebElement logInBtn = driver.findElement(By.xpath("//*[@value='Sign up']"));
		logInBtn.click();
		
        //Step 6: Locate "User is successfully Register. Now You can Login" webelement and verify its displayed on the 
		//page. 
		String actualMsg = "User is successfully Register. Now You can Login";
		String expectedMsg = driver.findElement(By.id("close")).getText();
        System.out.println(actualMsg + "VS" + expectedMsg);
        
        if (expectedMsg.contains(actualMsg)) {
			System.out.println("The meassage is matching with actual message test pass");
		}else {
			System.out.println("The message is not matching with actual message test fail");
		}
        //Step 7: Locate the Login button and click on it. 
		
		
	}

}
