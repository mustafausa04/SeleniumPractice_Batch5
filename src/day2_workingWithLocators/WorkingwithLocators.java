package day2_workingWithLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingwithLocators {

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

       // we are creating an object here
       // WebDriver is an interface being a reference type
       // ChromeDriver is a class being an object type here.
       WebDriver driver = new ChromeDriver();
       
       //to go to facebook website
       driver.get("https://facebook.com");
       
		//after going to FB website go to emaile box inspect it in dev tools, get the name value which is email and put
        //it as a string in the By.name("email")
		WebElement emailField = driver.findElement(By.name("email"));
		emailField.sendKeys("automation");
		
		//here do same as the previous step but for the password box.
		WebElement password = driver.findElement(By.name("pass"));
		password.sendKeys("automation");
		
		//do same as above but for login button
		WebElement loginButton = driver.findElement(By.name("login"));
		loginButton.click();
		
		//what happen above it will take you face book site and login with password by itself but then it will tell 
		//you that the error because we put password (automation) and no account has this password it's just for
		//example purposes
		
		
		
		//now go to amazon website
		driver.get("https://amazon.com");
		
		// in order to use find By.linkText(), the element has to be a tag (anchor tag/ link tag)
		//so go to Clinic in the navbar on amazon website, inspect it and get the element "Clinic" that located in 
		//between the anchor tag ex <a href=.........> Clinic </a> and use like below, this will take you to Clinic
		WebElement clinicLink = driver.findElement(By.linkText("Clinic"));
		
		//and this will click on Clinic in the navbar to take you to Clinic page
		clinicLink.click();
		//now run the program, it will run facebook first then amazon by itself
		
		
		//now go to amazon again
		driver.get("https://amazon.com");
		
		// find (Discover more footwear on Shopbop) inspect it get partial of the element text in between the anchor 
		//<a href=.....>Discover more footwear on Shopbop</a> and use (By.partialLinkText())
		//but before we execute make copy of the "footwear on Shopbop" and paste it in the inspection box in the lower
		//screen in the dev tool, so if it was the only one and see number 1 then we can use it if it shows that we 
		//have more than 1 in the whole code then we can not use it because it has to be only 1
		WebElement partialText = driver.findElement(By.partialLinkText("footwear on Shopbop"));
		
		//click on it
		partialText.click();
		
		
		//go to amazon again
		driver.get("https://amazon.com");
		
		//finde unique class name it has to be only one in the whole code so for ex copy the class name (nav-swm-text)
		//copy it and paste it in the lower screen in dev tool but make sure you put (.) before it because it is class
		//and class start with (.) not like the id start with (#), so it will be like this(.nav-swm-text). so if it 
		//shows that is the only 1 we could use it but if it shows more then we can not use it.
		//Note: you could combinde more than one class and put it in that box to see if it's the only one or there is 
		//more for ex let's say you found class="a1 aa1 aaa1" just copy these 3 class names and put them like this
		//.a1.aa1.aaa1 in the lower screen box in dev tool to see if there is only 1 of them or more, if the combind 
		//of all of them shows up 1 then you could use them if the combinde of all of them is more than 1 then you 
		//can not use them
		WebElement off = driver.findElement(By.className("nav-swm-text"));
		
		//click on it
		off.click();
		
        //this is to delay time, hover on Thread and choose the first option it will add (throws InterruptedException)
		// in the top not by the import section but after the main method, look at it 
		Thread.sleep(1000);

	}

}
