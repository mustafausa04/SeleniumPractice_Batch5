package day2_workingWithLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassActivity2 {

	public static void main(String[] args) throws InterruptedException {
		//--------------NOTE-----------------PAY ATTENTION-----------------------
		//if you run this program on f11 or clicking the run button most likely it won't work i don't know why,
		//so click on the drop down arrow next to the run button, then run as, then java application. this is the only
		//way to run it
		
		//---------------------Task--------------------------
		//go to facebook.com
		//find the Create New Account button and click on it
		//find the FirstName, LastName, Email and Password fields
		//and type Automation
		//find the Sign Up button and click on it.
		
		/*// this is how it looks like on mac computer
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/selenium_tools/chromedriver_mac64/chromedriver");

       // on windows computer, this is how it looks like
       //System.setProperty("webdriver.chrome.driver", 
				//"/Users/primetech/Documents/selenium_tools/chromedriver_mac64/chromedriver.exe");*/
		
       //System.setProperty("webdriver.chrome.driver", 
		     //"C:\\Users\\MIKE\\Prime Tech School\\Batch5\\week17\\HTML\\Day2\\selenium_tools\\chromedriver_win32/chromedriver.exe");
       
            //go to facebook.com
     		WebDriver driver = new ChromeDriver();
     		driver.get("https://facebook.com");
     		
     		
     		//this is an extra step to use getTitle() the one on the url page and it will print it in the 
     		//bottom of the console
     		String webTitle = driver.getTitle();
     		System.out.println("Title is: " + webTitle);
     		
     		
     		
            //find the Create New Account button and inspect it and get the anchore text element "Create new account"
     		WebElement newAccountBtn = driver.findElement(By.linkText("Create new account"));
     		newAccountBtn.click();
     		
     		// Thread.sleep - stops the java code execution for certain amount of time given so the next window
     		//will have time to upload what we going to enter like first name, last, email and password. if we don't
     		//put this time the next window won't upload the names email, password, 
     		Thread.sleep(1000);//this is one second
     		
            //find the FirstName,  LastName, Email and Password fields and type Automation, go to each of those inspect
     		//them then get the text element in the name and paste it in each one of them
     		WebElement firstName = driver.findElement(By.name("firstname"));
     		WebElement lastName = driver.findElement(By.name("lastname"));
     		WebElement email = driver.findElement(By.name("reg_email__"));
     		WebElement password = driver.findElement(By.name("reg_passwd__"));
     		firstName.sendKeys("automation");    //the automation here it's just a name we choose for ex purposes
     		lastName.sendKeys("automation");
     		email.sendKeys("automation");
     		password.sendKeys("automation");
     		
            //find the Sign Up button and inspect it it will has id and name we choose to take the name text element
     		//instead of the id text element because the id text is including number and we don't want that
     		WebElement signupBtn = driver.findElement(By.name("websubmit"));
     		signupBtn.click();
     		
     		
     		//extra step to getCurrentU() and it will be in the console
     		System.out.println("Current URL is: " + driver.getCurrentUrl());
     		
     		
     		//this is an extra step to usegeText() of element "Learn more" in the sign up screen when it pops up, we chose
     		//the id text in the inspection dev tools.
     		WebElement nonUserNoticeLink = driver.findElement(By.id("non-users-notice-link"));
     		String noticeLinkText = nonUserNoticeLink.getText();
     		System.out.println("Notice LInk Text Is: " + noticeLinkText);
     		
     		
     		//using close() the browser - closes the current browser, if there are multiple tabs open, it only closes the 
     		//current one but it will stays in the memory running because the close() is only for close not for shut down
     		driver.close();
     		
     		//using quit() the driver  - shut down everything.
     		driver.quit();

	}

}
