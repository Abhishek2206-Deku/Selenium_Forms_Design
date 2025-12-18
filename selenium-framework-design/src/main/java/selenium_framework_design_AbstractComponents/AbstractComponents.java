package selenium_framework_design_AbstractComponents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractComponents {

	public WebDriver driver;

	public  void ApplicationUrl() {
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
	}
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
	}

//-----   scrollIntoView(WebElement element)     -------//
	public void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
