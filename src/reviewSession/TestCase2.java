package reviewSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", 
				//"C:\\Users\\MIKE\\Prime Tech School\\Batch5\\week17\\HTML\\Day2\\selenium_tools\\chromedriver_win32/chromedriver.exe");
		
		test2();
	}
	
	
    public static void test2() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	
//		Go to “https://automationtesting.co.uk”
		driver.get("https://automationtesting.co.uk");
		
//		Click on Contact Us Form Test.
		WebElement ConactUsForm = driver.findElement(By.xpath("//a[@href='contactForm.html']"));
		ConactUsForm.click();
		Thread.sleep(1000);
		
//		Find the Test field for email
//		Enter email address 
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("Zhivko@gmail.com");
		
//		Click on Submit
		WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
		submit.click();
//		Verify you get the error message:
//		“Error: all fields are required”
//	
		
		Thread.sleep(2000);
		
		String  expectedMsg = driver.findElement(By.xpath("html/body")).getText();
		//System.out.println(expectedMsg);
		
		String actualMsg = "Error: all fields are required";

		if(expectedMsg.equals(actualMsg)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		
		
		
		driver.quit();
		
		
	}

}
