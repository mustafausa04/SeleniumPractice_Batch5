package reviewSession;

import java.time.Duration;
import java.util.Set;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wednesday8_16 {

	public static void main(String[] args) throws InterruptedException {
		//-------------------------alerts and popups------------------------------------------
		//alerts are not part of HTML they are javascripts so we need alert class to locate them but pops ups are part
		//of HTML we just need window handels to get the window id
		
		//System.setProperty("webdriver.chrome.driver",
				//"C:\\Users\\MIKE\\Prime Tech School\\Batch5\\week17\\HTML\\Day2\\selenium_tools\\chromedriver_win32/chromedriver.exe");
		
		//alertHandle ();
		//windowHandles ();
		//testCase1();
		testCase2();

	}
	
  public static void alertHandle () throws InterruptedException {
    //Click the button to display an alert box.
    //Send text to the Alert with your name and title.
    //Then accept the Alert. 
    //Verify that the message displays as it should.

	WebDriver driver = new ChromeDriver();		
	driver.manage().window().maximize();
	
    //Go to "https://demo.automationtesting.in/Alerts.html"		
	driver.get("https://demo.automationtesting.in/Alerts.html");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
    //Click on Alert with text box. 
	WebElement alertWtext = driver.findElement(By.xpath("//*[text()='Alert with Textbox ']"));
	alertWtext.click();
	driver.findElement(By.className("btn-info")).click();
	
	Alert alt = driver.switchTo().alert();
	Thread.sleep(3000);
	alt.sendKeys("Hello, I am Sam");
	Thread.sleep(3000);
	System.out.println(alt.getText());
	alt.accept();
}

 public static void windowHandles () {
	WebDriver driver = new ChromeDriver();		
	driver.manage().window().maximize();
	
	driver.get("https://demo.automationtesting.in/Windows.html");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	//here we get the main window id
	String mainWindowId = driver.getWindowHandle();
	System.out.println(mainWindowId);
	
	//here to locate the (click) button on the first page so it can take us to the next page or the next window
	WebElement clickBtn = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
	clickBtn.click();
	
	//here we will get the list of all windows id including the main
	Set <String> windowsIds = driver.getWindowHandles();
	
	//here we will go through all the id's and print them out
	for (String str : windowsIds) {//here we say get the first id from all windows id then get the second then etc.
		System.out.println(str);//here we will print them all to see them
		if(!str.equals(mainWindowId)) {System.out.println(str);} {driver.switchTo().window(str);}//here we get the id
		//that is not equal to the main page id which the next page id we print it then we moved the driver from the
		//main page to the new page
	}
	
	//hre to make sure that we are on the next page we just grap an element there to confirm that we are on that page
	String newPageTxt = driver.findElement(By.className("fs-1")).getText();
	System.out.println(newPageTxt);
	
	//here we switch the driver back to the main page
	driver.switchTo().window(mainWindowId);
	
	//here to confirm that we are back to main page so we grap a text from the main page and print it to make sure
	//that we are back there.
	String mainPagetxt = driver.findElement(By.xpath("//h1[text()='Automation Demo Site ']")).getText();
	System.out.println(mainPagetxt);
 }

 public static void testCase1() throws InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	//Go to https://testautomationpractice.blogspot.com
	driver.get("https://testautomationpractice.blogspot.com");
	
	WebElement alertBtn = driver.findElement(By.xpath("//button[contains(text(), 'Alert')]"));
	alertBtn.click();
	Alert alert2 = driver.switchTo().alert();
	alert2.accept();
	
	Thread.sleep(3000);
	WebElement confirmBox = driver.findElement(By.xpath("//button[contains(text(), 'Confirm Box')]"));
	confirmBox.click();
	Alert alert3 = driver.switchTo().alert();
	alert3.dismiss();
	
	Thread.sleep(3000);

	WebElement prompt = driver.findElement(By.xpath("//button[contains(text(), 'Prompt')]"));
	prompt.click();
	Alert alert4 = driver.switchTo().alert();
	alert4.sendKeys("Mike");
	Thread.sleep(3000);
	alert4.accept();
	
	//driver.close();
 }


 public static void testCase2() {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
    //Go to https://testautomationpractice.blogspot.com/
	driver.get("https://testautomationpractice.blogspot.com");

    //Get the main window ID and store it in a String called mainWindowId.
	String mainWID = driver.getWindowHandle();
	System.out.println(mainWID);
	
    //Click on the 'New Browser Window' button
	WebElement newBrowserBtn = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
	newBrowserBtn.click();
	
    //now you rae on the new page, Get window IDs and store it into a Set
	Set <String> allWindowIds = driver.getWindowHandles();

	//Get the first window ID from the Set and Verify it matches with the main window id in step 2. 
	for (String str : allWindowIds) {
		if(str.equals(mainWID)) {System.out.println(str);}
	}
	
    //Switch to the second window. in order to get thesecond window id we have to go inside the loop again and get it
	for (String str : allWindowIds) {
		if(!str.equals(mainWID)) {driver.switchTo().window(str);} {System.out.println(str);}
	}
	
    //Verify that there is a Featured Products  is Displayed. this will return us true or false to confirm us that we are
	//on the second page or not
	System.out.println(driver.findElement(By.xpath("//h3[text()='Featured']")).isDisplayed());
	
	//Close the window, Switch back to the main window
	driver.close();//here we will close this window in this page only not all of them
	driver.switchTo().window(mainWID);//we have to switch the driver otherwise we will have an error
	
    //Verify you are on the main window by confirming the text "Automation Testing Practice" is Matching in the 
	//home page
	String mainPagetxt = driver.findElement(By.xpath("//h1[contains(text(),'Automation Testing Practice')]")).getText();
	System.out.println(mainPagetxt);
 }

}
