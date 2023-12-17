package day3_advancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyXpathActivity {

	public static void main(String[] args) throws InterruptedException {
		//-----------------Relative Xpath basic syntax:tagname[@attribute='value']---------------
		//Starts with // tagname, // means any tagname.
		//[@ attribute = ‘value’]
		//Attribute is any attribute you may find like: id, name, type, value, class, data-testid …..
		
		//--------------NOTE-----------------PAY ATTENTION-----------------------
		//if you run this program on f11 or clicking the run button most likely it won't work i don't know why,
		//so click on the drop down arrow next to the run button, then run as, then java application. this is the only
		//way to run it
				
		/*// this is how it looks like on mac computer
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/selenium_tools/chromedriver_mac64/chromedriver");

		// on windows computer, this is how it looks like
		//System.setProperty("webdriver.chrome.driver", 
			    //"/Users/primetech/Documents/selenium_tools/chromedriver_mac64/chromedriver.exe");*/
				
		//System.setProperty("webdriver.chrome.driver", 
				//"C:\\Users\\MIKE\\Prime Tech School\\Batch5\\week17\\HTML\\Day2\\selenium_tools\\chromedriver_win32/chromedriver.exe");
		
		EtsyXpathActivity etsy = new EtsyXpathActivity();// create an object
		etsy.etsyXpathClassActivity();//calling the method below
		
	}
	
	
	//Test case: use xpath locators only
	//Go to etsy.com
	//Click on Sign in.
	//Click on Register.
	//Enter an email address, (jon.dow@gmail.com)
	//Enter first name.
	//Enter password.
	//Click on Register.
	//Verify you get the error message:
	//“Sorry, the email you have entered is already in use.”
	
	public void etsyXpathClassActivity() throws InterruptedException {
		//Test case:
			//Go to etsy.com
		WebDriver driver = new ChromeDriver();
		driver.get("https://etsy.com");
			//Click on Sign in.
		//here we will be using the By.xpath, go to the sign button on etsy site, inspect it and put in the DOM search 
		//bar //tagname[@ attribute = ‘value’] which is //button[@class=.....] like below to make sure it's unique
		//only 1 shows there so you can use it.
		WebElement signinBtn = driver.findElement(
				By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']"));
		signinBtn.click();
		Thread.sleep(1000);
		    //Click on Register.
		//here we will do the same as above button
		WebElement registerBtn = 
				driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--secondary wt-btn--small inline-overlay-trigger register-header-action select-register']"));
		registerBtn.click();
		Thread.sleep(1000);
		    //Enter an email address, (jon.dow@gmail.com)
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jon.dow@gmail.com");
			//Enter first name.
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("jon");
			//Enter password.
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("jkhgkjdgfgsd");
			//Click on Register.
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@name='submit_attempt']")).click();
		Thread.sleep(3000);
			//Verify you get the error message:
			//“Sorry, the email you have entered is already in use.”
		//once you sign up you will get an error message so inspect it and use By.xpath like the above, and because 
		//it will turn an error message back for us this means it's string so we can store it in a string variable
		String errorMessage = driver.findElement(By.xpath("//div[@id='aria-join_neu_email_field-error']")).getText();
		System.out.println(errorMessage);
		if (errorMessage.equals("Sorry, the email you have entered is already in use.")) {
			System.out.println("Test pass");
		}else {
			System.out.println("Test fail");
		}
	}	

}
