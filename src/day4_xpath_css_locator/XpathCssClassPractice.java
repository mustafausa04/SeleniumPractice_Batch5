package day4_xpath_css_locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathCssClassPractice {

	public static void main(String[] args) throws InterruptedException {
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
		
		XpathCssClassPractice practice = new XpathCssClassPractice();//creating object
		//practice.xpath_contains();//calling the first method
		//practice.xpath_text();//calling the second method
		//practice.css_practice();//calling the third method
		practice.css_classActivity();
		
	}
	
	
	public void css_classActivity() throws InterruptedException {
		
        //Test case:  use css selector only
		//Go to etsy.com
	WebDriver driver = new ChromeDriver();
	driver.get("https://etsy.com");
		//Click on Sign in.
	WebElement signinBtn = driver.findElement(
			By.cssSelector(".select-signin"));
	signinBtn.click();
	Thread.sleep(1000);
	    //Click on Register.
	WebElement registerBtn = 
			driver.findElement(By.cssSelector(".select-register"));
	registerBtn.click();
	Thread.sleep(1000);
	    //Enter an email address, (jon.dow@gmail.com)
	driver.findElement(By.cssSelector("#join_neu_email_field")).sendKeys("jon.dow@gmail.com");
		//Enter first name.
	driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("jon");
		//Enter password.
	driver.findElement(By.cssSelector("input[name='password']")).sendKeys("jkhgkjdgfgsd");
		//Click on Register.
	Thread.sleep(500);
	driver.findElement(By.cssSelector("button[name='submit_attempt']")).click();
	Thread.sleep(3000);
		//Verify you get the error message:
		//“Sorry, the email you have entered is already in use.”
	
	String errorMessage = driver.findElement(By.cssSelector("#aria-join_neu_email_field-error")).getText();
	System.out.println(errorMessage);
	if (errorMessage.equals("Sorry, the email you have entered is already in use.")) {
		System.out.println("Test pass");
	}else {
		System.out.println("Test fail");
	}

}
	
        public void css_practice() {
		
        //-----------------------------------using css-------------------------------------------
		//Test case use only css
		// there are 3 typs of css selecting method
		// 1. tagname[attribute=value]
		// 2. #id
		// 3. .classname
		
		
		// advantages of css selector is that it's fast, and simpler in syntax compared to xpath
		
		// draw backs of css:
		// there is no contains() or text() function like xpath does. 
		// and there is no axes like xpath does,  parents, following-sibling etc:
		
		// go to facebook.com
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		// find email and type automation
		//here we are using the cssSelector, so we go to facebook and we inspect the box where is says 'Email or phone'
		//then we go to its input in the DOM and we get the id where it says id="email" and we put it like below
		//for the cssSelector. this is the css id ex and we could do the same with class element we just use for ex
		//".email" so the difference is the dot with class and hash tag with id.
		driver.findElement(By.cssSelector("#email")).sendKeys("automation");
		// find password and type automation
		//same as above but we are using another way for css like this CSS = tagname[attribute=value]
		WebElement password = driver.findElement(By.cssSelector("input[data-testid='royal_pass']"));
		System.out.println("data-testid attribute value is: " + password.getAttribute("data-testid"));
		password.sendKeys("password");
		System.out.println(password.getCssValue("color"));
		
		// find login button and click on it
		//same way here CSS = tagname[attribute=value]
		driver.findElement(By.cssSelector("button[data-testid='royal_login_button']")).click();
		
	}
	
	
	//------------------------------using xpath with contains()------------------------------
	//Contains(); //tagname[contains(@attribute, ‘someValue’)]; Example:
	//.....//button[contains(@class, ‘someclassname’)]
	//.....//input[contains(@id, ‘loginBtn’)]
	//.....//a[contains(@href, ‘google.com’)] with all above we use attributes with @ before it 
	//.....//div[contains(text(), ‘user’)] with this one we use the text element for ex: <button>Sign in</button> which
	//is the 'Sign in' it will be like this //button[contains(text(), 'Sign in')]
	//the reason we use it because it is shorter than the xpath locator 
	
	public void xpath_contains() throws InterruptedException {
		// we use the text() to locate an element when the element has an element text, 
		//and doesn't provide other unique locators
		
		
		//Test case:
				//Go to etsy.com
			WebDriver driver = new ChromeDriver();
			driver.get("https://etsy.com");
				//Click on Sign in.
			//here we used the xpath with contains() to make it shorter and easier than the xpath locater because 
			//with that one you have to print the whole path of class with this one you don't need to
			WebElement signinBtn = driver.findElement(
					By.xpath("//button[contains(@class, 'select-signin')]"));
			signinBtn.click();
			Thread.sleep(1000);
			    //Click on Register.
			WebElement registerBtn = 
					driver.findElement(By.xpath("//button[contains(@class, 'select-register')]"));
			registerBtn.click();
			Thread.sleep(1000);
			    //Enter an email address, (jon.dow@gmail.com)
			driver.findElement(By.xpath("//input[contains(@id, 'email_field')]")).sendKeys("jon.dow@gmail.com");
				//Enter first name.
			driver.findElement(By.xpath("//input[contains(@id, 'first_name')]")).sendKeys("jon");
				//Enter password.
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("jkhgkjdgfgsd");
				//Click on Register.
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[contains(text(), 'Register')]")).click();
			Thread.sleep(3000);
				//Verify you get the error message:
				//“Sorry, the email you have entered is already in use.”
			
			String errorMessage = driver.findElement(By.xpath("//div[@id='aria-join_neu_email_field-error']")).getText();
			System.out.println(errorMessage);
			if (errorMessage.equals("Sorry, the email you have entered is already in use.")) {
				System.out.println("Test pass");
			}else {
				System.out.println("Test fail");
			}
	}
	
	//note you could also use different attribute than class when you use xpath contains() for ex:
	//you could use if we have input box in the web site, we inspect it then we go get the input
	// it will be like this //input[contains(@placeholder, 'Email')] so here the placeholder was an attribute
	//and 'Email' was a portion of the word there so we can get the portion of the word or the whole word.
	//we could also use it this way //tagname[text()=’elementText’] - which uses the .equals() method
	
	//------------------------------using xpath with text()------------------------------
	public void xpath_text() throws InterruptedException {
		// we use the text() to locate an element when the element has an element text, 
		//and doesn't provide other unique locators
		
		
		//Test case:
				//Go to etsy.com
			WebDriver driver = new ChromeDriver();
			driver.get("https://etsy.com");
				//Click on Sign in.
			WebElement signinBtn = driver.findElement(
					By.xpath("//button[contains(text(), 'Sign in')]"));//or //button[text()='Sign in']
			signinBtn.click();
			Thread.sleep(1000);
			    //Click on Register.
			WebElement registerBtn = 
					driver.findElement(By.xpath("//button[contains(text(), 'Register')]"));
			registerBtn.click();
			Thread.sleep(1000);
			    //Enter an email address, (jon.dow@gmail.com)
			driver.findElement(By.xpath("//input[contains(@id, 'email_field')]")).sendKeys("jon.dow@gmail.com");
				//Enter first name.
			driver.findElement(By.xpath("//input[contains(@id, 'first_name')]")).sendKeys("jon");
				//Enter password.
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("jkhgkjdgfgsd");
				//Click on Register.
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[contains(text(), 'Register')]")).click();
			Thread.sleep(3000);
				//Verify you get the error message:
				//“Sorry, the email you have entered is already in use.”
			
			String errorMessage = driver.findElement(By.xpath("//div[@id='aria-join_neu_email_field-error']")).getText();
			System.out.println(errorMessage);
			if (errorMessage.equals("Sorry, the email you have entered is already in use.")) {
				System.out.println("Test pass");
			}else {
				System.out.println("Test fail");
			}
	}
	

}
