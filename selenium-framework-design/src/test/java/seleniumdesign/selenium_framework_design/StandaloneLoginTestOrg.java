package seleniumdesign.selenium_framework_design;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StandaloneLoginTestOrg {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		// Implicit wait to wait for the page load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.tutorialspoint.com/selenium/practice/login.php");
		driver.manage().window().maximize();

		// Clicking on the New User button to redirect the Registration page
		driver.findElement(By.xpath("//a[contains(@class, btn-primary) and text()='New User']")).click();

		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Deku");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Izuku Midoriya");

		driver.findElement(By.id("username")).sendKeys("IzukuMidoriya09@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Izuku@09");

		driver.findElement(By.xpath("//input[@value='Register']")).click();

		// Clicking on the Back to Login Button for Login
		driver.findElement(By.xpath("//a[contains(@class, 'btn-primary') and text()='Back to Login']")).click();

		driver.findElement(By.id("email")).sendKeys("IzukuMidoriya09@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Izuku@09");

		driver.findElement(By.xpath("//input[@value='Login']")).click();

		System.out.println("Registration and Login functionality completed");

	}
}
