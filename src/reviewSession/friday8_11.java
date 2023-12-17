package reviewSession;

import java.time.Duration;
import java.util.List;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class friday8_11 {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", 
				//"C:\\Users\\MIKE\\Prime Tech School\\Batch5\\week17\\HTML\\Day2\\selenium_tools\\chromedriver_win32/chromedriver.exe");
		
		//login();
		//testcase2();
		alerthandle();

	}
	
	
	public static void login() throws InterruptedException {
		//Test case: register
		//Step 1: Go to URL"https://www.the testingworld.com/testings".
        WebDriver driver = new ChromeDriver();
		
        //Navigate to (https://www.thetestingworld.com/testings).
		String url = "https://www.thetestingworld.com/testings";
		driver.get(url);
        //Maximize the browser & declare implicitly wait for 5 second.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Locate the Log in button and click on it.
		driver.findElement(By.xpath("//label[contains(text(), 'Login')]")).click();
		
		//Locate the userName and passWord text box and put your info.
		WebElement userNameBox = driver.findElement(By.xpath("//input[@name='_txtUserName']"));
		userNameBox.sendKeys("helloT");
		WebElement passWordBox = driver.findElement(By.xpath("//input[@name='_txtPassword']"));
		passWordBox.sendKeys("12345");
		
		//Locate the Login button and click on it
		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		loginBtn.click();
		
		//Locate the Home button then select "user list" from the drop down menue.
		//here is the tricky part because usually we click on any drop down button and we choose what we want but with
		//this Home button we can not because there is no drop down it just happen but only hover on it, so what we
		//do is locate the home button first then we create an object throw Actions class and use moveToElement() to have
		//the mouse over over the Home element like below.
		WebElement homeBtn = driver.findElement(By.xpath("//*[contains(text(), 'Home')]"));
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(homeBtn).perform();
		//after the hover over the Home now find the User List and click on it.
		WebElement userListbtn = driver.findElement(By.xpath("//*[contains(text(), 'User List')]"));
		userListbtn.click();
		
		//Save all users in a list for webElements, then print the user information
		//Print only the email and phone number for user 2.
		List <WebElement> usersLst = driver.findElements(By.className("items"));
		System.out.println(usersLst.size());        //note: we use size() for lists and length() for arrays
		for (int i = 0; i < usersLst.size(); i++) {
			System.out.println(usersLst.get(i).getText());
		}
	}
	
	
     public static void testcase2() throws InterruptedException {
		
        //Go to URL “https://www.thetestingworld.com/testings”.
		WebDriver driver = new ChromeDriver();
		String url = "https://www.thetestingworld.com/testings";
		driver.get(url);
		
        //Step 2: Maximize the browser & declare implicitly wait for 5 second.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		

        //Login to your account 
		driver.findElement(By.xpath("//label[contains(text(),'Login')]")).click();

		WebElement userNameBox = driver.findElement(By.xpath("//input[@name='_txtUserName']"));
		userNameBox.sendKeys("helloT");
		WebElement passWordBox = driver.findElement(By.xpath("//input[@name='_txtPassword']"));
		passWordBox.sendKeys("12345");
		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		loginBtn.click();
		
        //Locate the “Dual List Box Demo”  and save it in a List of WebElements.
		WebElement listBox = driver.findElement(By.className("pickData"));
		
        //Use Select Class to select the first 5 names on the list ‘by index’ or ‘visible text’.	
		Select slt1 = new Select(listBox);
		slt1.selectByIndex(0);
		slt1.selectByIndex(1);
		slt1.selectByVisibleText("Alice");
		slt1.selectByVisibleText("Isabella");
		slt1.selectByVisibleText("Manuela");
		
        //Get all the selected options using getAllSelectedOptions
		List <WebElement> selectedoption = slt1.getAllSelectedOptions();
		System.out.println(selectedoption.get(0).getText());
		
        //Add the selected names to the second list. 
		driver.findElement(By.className("pAdd")).click();
		
        //Select all the names from the second list and deselect the last two names. 
        //Use wait for 3 seconds then Locate Remove All button and click on it.
		Thread.sleep(1000);
		WebElement listofselecteduser = driver.findElement(By.className("pickListResult"));
		Select slt2 = new Select(listofselecteduser);
		slt2.selectByIndex(0);
		slt2.selectByIndex(1);
		slt2.selectByIndex(2);
		slt2.selectByIndex(3);
		slt2.selectByIndex(4);
		
		Thread.sleep(2000);
		slt2.deselectByIndex(4);
		slt2.deselectByIndex(3);

	}
     
     
     //-----------------------Alert ex------------------------------
     public static void alerthandle() throws InterruptedException {
 		WebDriver driver = new ChromeDriver();
 		String url = "https://demoqa.com/alerts";
 		driver.get(url);
 		driver.manage().window().maximize();
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 		Thread.sleep(1000);
 		
 		//this is the third button on the website it says click me once we click on it there will be an alert message
 		//so we either selected or dismiss it
 		driver.findElement(By.id("confirmButton")).click();
 		Alert alert = driver.switchTo().alert();
 		alert.accept();//here we accepted the alert using accept()
 		//alert.dismiss();//or to dismiss the alert
 		
 		/*//this is for the fourth button where we can send the name "Kewan" once the box open on the website
 		driver.findElement(By.id("promtButton")).click();
 		Alert alert1 = driver.switchTo().alert();
 		
 		//here we will send the key then we have to accept it in order to work
 		alert1.sendKeys("K");//here we are using the sendKeys to sent the name
 		alert1.accept();//here we accepted the alert using accept()
 		*/
 	}
     

}
