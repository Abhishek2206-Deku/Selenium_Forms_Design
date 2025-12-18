package seleniumdesign.selenium_framework_design;

import java.awt.AWTException;
//import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class StandaloneFormTestOrg {
	public static void main(String[] args) throws AWTException {

		// WebDriver Initialization and launching Web application
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// Targeting Forms Elements in the application

		driver.findElement(By.id("name")).sendKeys("Abhishek Samal");
		driver.findElement(By.id("email")).sendKeys("abhisheksamal221@gmail.com");
		driver.findElement(By.xpath("//label[text()='Male']/preceding-sibling::input")).click();
		driver.findElement(By.id("mobile")).sendKeys("9876543210");
		driver.findElement(By.id("subjects")).sendKeys("Automation Testing");
		driver.findElement(By.xpath("//label[text()='Sports']/preceding-sibling::input")).click();

		// Code for Calendar
		WebElement dateInput = driver.findElement(By.id("dob"));
		dateInput.sendKeys("15/11/2025");

		/*
		 * Scrolling mechanism using JavaScript Executor Scroll down by pixels:
		 * JavascriptExecutor js=(JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,500)");
		 */

		// Scroll to the bottom of the page:
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		JS.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		/*
		 * Code for File Upload if the HTML code contains type='file' in those scenario
		 * we can use sendKeys() method. in other scenario we can use Robot class and
		 * for uploading files.
		 */
		driver.findElement(By.xpath("//input[@id='picture']"))
				.sendKeys("C:\\Users\\abhis\\OneDrive\\Pictures\\Saved Pictures\\RangeRover.jpeg");

		driver.findElement(By.xpath("//textarea[@id='picture']")).sendKeys("Whitefield, Bengaluru");

		// Handling Select Drop down Class
		WebElement dropdown = driver.findElement(By.id("state"));
		Select select = new Select(dropdown);
		select.selectByValue("Rajasthan");

		WebElement dropdownCity = driver.findElement(By.id("city"));
		Select selectCity = new Select(dropdownCity);
		selectCity.selectByValue("Meerut");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		System.out.println("Submit button Clicked");

	}
}
