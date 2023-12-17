package day5_MoreOnWebElement;

import java.time.Duration;
import java.util.List;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithWebElements {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", 
				//"C:\\Users\\MIKE\\Prime Tech School\\Batch5\\week17\\HTML\\Day2\\selenium_tools\\chromedriver_win32/chromedriver.exe");
		
		WorkingWithWebElements classObject = new WorkingWithWebElements();
		
		//calling methods
		//classObject.KeyPressExample();
		//classObject.navigateExamples();
		//classObject.classActivity1();
		//classObject.findElementsDemo();
		classObject.classActivity2();

	}
	
	public void classActivity2() {
		  // Test case 2 
					WebDriver driver = new ChromeDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
		     //go to https://saucedemo.com 
					driver.get("https://saucedemo.com");
		     //log in with username = standard_user   password = secret_sauce
					driver.findElement(By.id("user-name")).sendKeys("standard_user");
					driver.findElement(By.id("password")).sendKeys("secret_sauce");
					driver.findElement(By.id("login-button")).click();
		     //find all the results. print the price of each result. 
		     //Hint: loop through the list, get index and get text
					List<WebElement> itemsPrice = driver.findElements(By.cssSelector(".inventory_item_price"));
					
					for (int i = 0; i < itemsPrice.size(); i++) {
					    System.out.println(itemsPrice.get(i).getText());
					    //or we could do this
                        //WebElement singleItem = itemsPrice.get(i);
                        //String priceofItem = singleItem.getText();
                        //System.out.println(priceofItem);
					}
					
					//this one is same as above 
					// for each loop version  == demo purpose only
					for (WebElement singleItemPrice : itemsPrice) {
						System.out.println(singleItemPrice.getText());
					}
	
    }
					
	
	//-------------------using findElements()--------------------------------
	public void findElementsDemo() {
		// Test case 1
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    // go to https://saucedemo.com
		driver.get("https://saucedemo.com");
	    //use this to log in with username = standard_user   password = secret_sauce
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	    // find all the results and get them in a list, and print the size of the list.
		//here we grab the class .inventory_item because it is available in all the elements that we need to print out
		List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item"));
		int sizeOfList = items.size();//here to get the size
		System.out.println(sizeOfList + " Items available on the page.");
		
	}
	
	
	public void classActivity1() throws InterruptedException {
		// Test case 
		WebDriver driver = new ChromeDriver();
	    // maximize browser
		driver.manage().window().maximize();
	    // declare implicitly wait for 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    // go to amazon.com
		driver.get("https://amazon.com");
	    // Search coffee mug.
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Coffee mug", Keys.ENTER);
		Thread.sleep(1000);
	    // Navigate back then search pretty coffee mug. 
		//here the program will stop and don't finish until we provide grabing the element again because driver once
		//passed the first element in line 37 it can't read again so we have to provide that element again in line 44
		driver.navigate().back();
		searchBox = driver.findElement(By.id("twotabsearchtextbox"));//here finding the element again so it can read it
		searchBox.sendKeys("Pretty coffee mug", Keys.ENTER);
		
		// driver is page specific tool, whenever driver moves to a different page, driver loses the references to the 
		// elements within the previous page.
		
		Thread.sleep(1000);
	    // Navigate back then navigate forward
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
	    // Refresh the page.
		driver.navigate().refresh();
		
		//note: if you see error with stale it means that the driver passed the elemnt and it needs it again in order
		//to read it again.
		
	}
	
	
	
	//-------------------using navigate()----------------------------------
	public void navigateExamples() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		// window maximize
		driver.manage().window().maximize();
		
		//--------------using Implicity-------------------
		// implicitly wait - Implicitly wait - waits the page (html elements / dom structure) to be loaded properly.
		// That doen't mean your element to be visible on the screen.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// it doesn't wait 5 second if the page is loaded in 1 second, it just moves to next command.
		
		//------------------using navigate().to----------------
		driver.navigate().to("https://google.com");//similar to driver.get("https://google.com")
		WebElement inputBox = driver.findElement(By.name("q"));
		
		inputBox.sendKeys("Coffee mug", Keys.ENTER);
		Thread.sleep(2000);
		
		//using navigate().back to previous page
		driver.navigate().back();
		Thread.sleep(2000);
		
		//using navigate forward to last visited page
		driver.navigate().forward();
		Thread.sleep(2000);
		
		//using navigate().refresh
		driver.navigate().refresh();
	}
	
	//sometimes for ex if you put in the search bar for google something and you want to search it there is no button
	//there so you use your keyboard enter instead of the button, here we wil learn hoe to use that it's called
	//--------------------------Key Press Event--------------------------
	public void KeyPressExample() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		// window maximize
		driver.manage().window().maximize();
		
		// implicitly wait is waits the page (html elements / DOM structure) to be loaded properly.
		// That doen't mean your element to be visible on the screen.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// it doesn't wait 5 second if the page is loaded in 1 second, it just moves to next command.
		
		// navigate to google.com
		driver.get("https://google.com");
		// search for coffee mug
		WebElement inputBox = driver.findElement(By.name("q"));
		inputBox.sendKeys("Coffee Mug");//also we could use inputBox.sendKeys("Coffee Mug", Keys.ENTER) as of combind step
		// to click enter using the key press event
		inputBox.sendKeys(Keys.ENTER);
		// find the search box again
		WebElement searchInputBox = driver.findElement(By.name("q"));
		// select the text in the search box by clicking ctrl+a it will highlighted the whole text in that search box.
		//also using the keys.chord in the Key will allow you to use multiple functions
		searchInputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));//here we highlighted the text in the search box
		/*//to cope the text in the search bar like in normal when using ctrl+c to make a copy
		searchInputBox.sendKeys(Keys.CONTROL, "c");//here we are making a copy of the text */
		Thread.sleep(2000);
		// delete the selected text
		searchInputBox.sendKeys(Keys.DELETE);//here we deleted the 'Coffee Mug' text in the search box
		Thread.sleep(2000);
		//to search new item and then click enter at the same time
		searchInputBox.sendKeys("Pretty coffee mug", Keys.ENTER);//we put ''Pretty coffee mug' then we clicked enter
		
		
	}

}
