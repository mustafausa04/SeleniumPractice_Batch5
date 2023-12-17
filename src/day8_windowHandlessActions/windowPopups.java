package day8_windowHandlessActions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowPopups {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", 
				//"C:\\Users\\MIKE\\Prime Tech School\\Batch5\\week17\\HTML\\Day2\\selenium_tools\\chromedriver_win32/chromedriver.exe");
			
		//windowHandlesDemo();
		windowHandlesDemoWithIterator();
		
	}
	
	public static void windowHandlesDemoWithIterator() {
		//Test case 2 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//go to http://practice.primetech-apps.com/practice/browser-windows
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		
		//1. Get the main window ID and store it in a String called mainWindowId, 
		String mainWindowId = driver.getWindowHandle();
		
		//2. Click on the ‘New Tab’ button
		driver.findElement(By.id("newTab")).click();
		
		//3. Get window IDs and store it into a Set
		Set<String> windowIds = driver.getWindowHandles();
		
		//4. Get the first window ID from the Set and Verify it matches with the main window id in step 1. 
		//here we will use iterate to go throw all ids 
		Iterator<String> iterate = windowIds.iterator();
		
		//iterator it means moving from item to another
		//here we will move to the next id
		String firstWindowId = iterate.next();
		System.out.println("first window id: " + firstWindowId);
		if (firstWindowId.equals(mainWindowId)) {
			System.out.println("First window id match to main window id");
		}else {
			System.out.println("First window id Not match to main window id");
		}
		
		//Then get the second window id and store it in variable called secondWindowId.
		//here we will go to the second id
		String secondWindowId = iterate.next();
		System.out.println("second window id: " + secondWindowId);
		
		//5. Switch to the second window
		driver.switchTo().window(secondWindowId);
		
		//6. verify that there is a text as 'This is a new tab'
		WebElement newTabText = driver.findElement(By.xpath("//p[text()='This is a new tab']"));
		if (newTabText.isDisplayed()) {
			System.out.println("We are on the child window");
		}else {
			System.out.println("We are not on the child window yet");
		}
		
		//7. Close the window, 
		driver.close();
		// Switch back to the main window, 
		driver.switchTo().window(mainWindowId);
		
		//Verify you are on the main window. 
		if (driver.findElement(By.xpath("//h3[text()='Browser Windows']")).isDisplayed()) {
			System.out.println("we are back to main window");
		}else {
			System.out.println("I am lost between the windows");
		}
	}
	
	
	
	public static void windowHandlesDemo() {
		WebDriver  driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// got to this website
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		
		// get the window id and store it in a variable
		String mainWindowID = driver.getWindowHandle(); //here we will get the id for the first window
	
		// print it out
		System.out.println(mainWindowID);//the id for the main window will be printed 
		
		// click on new tab button
		driver.findElement(By.id("newTab")).click();
		
		// get the all window ids and store them into a set of string
		Set<String> windowIds =  driver.getWindowHandles();
		
		// print them out
		// switch to the new window / child window
		for (String singleWindowId : windowIds) {
			System.out.println(singleWindowId);//here we will print all windows id they will be 2including the main + the main one from above
			//now the driver still on the main page so we need to switch it to the child page so we do the next step
			// if the singleWindowId is not equal to main windowId, then switch the driver
			if (!singleWindowId.equals(mainWindowID)) {
				driver.switchTo().window(singleWindowId);
			}
		}
		
		// verify that there is a text as 'This is a new tab' in the child page so we go grab that element 
		WebElement newTabText = driver.findElement(By.xpath("//p[text()='This is a new tab']"));
		//now we are going to see if this element "This is a new tab" if it's displayed it means we are in that page if 
		//not it means we are not on that page which is the child page
		if (newTabText.isDisplayed()) {
			System.out.println("We are on the child window");
		}else {
			System.out.println("We are not on the child window yet");
		}
		
		// close the new window if you want to close all tabs main and child then we use driver.quit()
		driver.close();
		
		// driver will not automatically switch between the windows, we have to command it
		// switch back to main window
		driver.switchTo().window(mainWindowID);
		
		//here is to make sure on the console that the driver is back to the main window
		if (driver.findElement(By.xpath("//h3[text()='Browser Windows']")).isDisplayed()) {
			System.out.println("we are back to main window");
		}else {
			System.out.println("I am lost between the windows");
		}
		
	}
	
		//--------------------just an ex------------------------
		public static void java_variable_demo() {
			
			String name1 = "Sam";
			String name2 = "Hamza";
			String name3 = "Helil";
			
			String [] names = {name1, name2, name3};
			
			for (int i = 0; i < names.length; i++) {
				// print the name which is not equal to Sam
				if (!names[i].equals("Hamza")) {
					System.out.println(names[i]);
				}
			}
			
			
			List<String> newNames = new ArrayList<>();
			newNames.add("Ali");
			newNames.add("Qasir");
			
			for (int i = 0; i < newNames.size(); i++) {
				if (!newNames.get(i).equals("Ali")) {
					String name = newNames.get(i);
					System.out.println(name);
				}
				
			}
			
			
	}

}