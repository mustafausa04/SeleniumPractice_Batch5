package day9_actionsClassDemo;

import java.time.Duration;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassDemo {

	public static void main(String[] args) {
		//---------------------Action Class-------------------
		//usually is not used that much, it used for hover over the element, or sometimes dragging element
		//if the web site allows you, or making some element to extand like. 
		
		//we upgraded to selenium 114 so we don't need to bring the path anymore
		//actionsClassDemo();
		etsyActivity();

	}
	
	
    public static void actionsClassDemo() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Actions action = new Actions(driver);
		
		// got to http://practice.primetech-apps.com/practice/drag-and-drop
		driver.get("http://practice.primetech-apps.com/practice/drag-and-drop");
		
		// drag the text to empty box (source and target) so the source will be the text element and the target will be
		//the other empty box where we will drag the text element into it
		WebElement sourceTextElement = driver.findElement(By.id("text"));
		WebElement sourceTextAreaElement = driver.findElement(By.id("textarea"));
		WebElement sourceNumberElement = driver.findElement(By.id("Number"));
		
		//here we get the target box element 
		WebElement targetBoxElement = driver.findElement(By.id("dropzone"));
		
		// remember: whenever you use actions function, you need to finish the function with perform() function.
		// .perform() - can be used alone when there is only one actions functions used.
		// .build().perform() - is for more than one chained actions functions.
		// to make it easy use always .build.perform() for single and multiple
		//here we are dragging the elements to the empty box
		action.dragAndDrop(sourceTextElement, targetBoxElement).build().perform();
		action.dragAndDrop(sourceTextAreaElement, targetBoxElement).build().perform();
		action.dragAndDrop(sourceNumberElement, targetBoxElement).build().perform();
		
	}
    
    
    public static void etsyActivity() {
		//Test case: 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Actions act = new Actions(driver);//to create actions so we can use them
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));//to create waiting time
		
		//go to Etsy.com
		driver.get("https://etsy.com");
		
		//Hover Over on Jewelry & Accessories
		WebElement JA = driver.findElement(By.xpath("//span[contains(text(), 'Jewelry & Accessories')]"));//to find it
		act.moveToElement(JA).build().perform();//to hover over it
		
		//to wait to appear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(), 'Bags & Purses')])[1]")));
		
		//Mouseover on Bags & Purses
		WebElement BP = driver.findElement(By.xpath("(//span[contains(text(), 'Bags & Purses')])[1]"));//to find it
		System.out.println(BP.isDisplayed()); //isDisplayed method only cares about the element visibility on the UInot on DOM
		act.moveToElement(BP).build().perform();//to hover over it
		
		//to wait to appear is very important 
		//we must put wait here so when the page download it can stop at the "Shoulder Bags" so it can read it then
		//move on, other wise it will be very fast and it can't read it so it return an error
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Shoulder Bags")));
		
		//Mouseover to Shoulder Bags
		WebElement ShoulderBags = driver.findElement(By.linkText("Shoulder Bags"));
		act.moveToElement(ShoulderBags).build().perform();
		
		//Click on the shoulder bags
		ShoulderBags.click();
		
		//now we are on new page so in order to confirm that we grap the title 
		//Verify you are on the Shoulder bags page
		if (driver.getTitle().contains("Shoulder Bags")) {
			System.out.println("We are on the shoulder bags page");
		}else {
			System.out.println("We are Not on the shoulder bags page");
		}
	}

}
