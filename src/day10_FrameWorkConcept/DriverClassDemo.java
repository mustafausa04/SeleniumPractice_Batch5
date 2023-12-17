package day10_FrameWorkConcept;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import day10_utilities.Driver;

public class DriverClassDemo {
	
	public static void main(String[] args) {
		
		etsyActivity();
		
	}
	
	public static void etsyActivity() {
		//we don't need the below anymore because we will call the driver class method in Driver.java file and we will
		//change all the (driver) to Driver.getDriver() in the below code
		/*WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));*/
		Driver.getDriver().manage().window().maximize();
		Actions act = new Actions(Driver.getDriver());//here we call the getDriver method from the Driver.java file
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));//to create waiting time
		
		//go to Etsy.com
		Driver.getDriver().get("https://etsy.com");
		
		//Hover Over on Jewelry & Accessories
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Jewelry & Accessories')]")));
		WebElement JA = Driver.getDriver().findElement(By.xpath("//span[contains(text(), 'Jewelry & Accessories')]"));//to find it
		act.moveToElement(JA).build().perform();//to hover over it
		
		//to wait to appear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(), 'Bags & Purses')])[1]")));
		
		//Mouseover on Bags & Purses
		WebElement BP = Driver.getDriver().findElement(By.xpath("(//span[contains(text(), 'Bags & Purses')])[1]"));//to find it
		System.out.println(BP.isDisplayed()); //isDisplayed method only cares about the element visibility on the UInot on DOM
		act.moveToElement(BP).build().perform();//to hover over it
		
		//to wait to appear is very important 
		//we must put wait here so when the page download it can stop at the "Shoulder Bags" so it can read it then
		//move on, other wise it will be very fast and it can't read it so it return an error
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Shoulder Bags")));
		
		//Mouseover to Shoulder Bags
		WebElement ShoulderBags = Driver.getDriver().findElement(By.linkText("Shoulder Bags"));
		act.moveToElement(ShoulderBags).build().perform();
		
		//Click on the shoulder bags
		ShoulderBags.click();
		
		//now we are on new page so in order to confirm that we grap the title 
		//Verify you are on the Shoulder bags page
		if (Driver.getDriver().getTitle().contains("Shoulder Bags")) {
			System.out.println("We are on the shoulder bags page");
		}else {
			System.out.println("We are Not on the shoulder bags page");
		}
		//we call this function from the Driver.java file to close the browser after launched
		Driver.quitDriver();
	}


}
