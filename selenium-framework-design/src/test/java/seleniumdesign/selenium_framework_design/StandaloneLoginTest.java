package seleniumdesign.selenium_framework_design;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import selenium_framework_design.BaseTest.BaseTest;
import selenium_framework_design.BaseTest.DriverManager;
import seleniumdesign.selenium_framework_design.pom.LoginPage;

public class StandaloneLoginTest extends BaseTest {

	@Test
	public void loginForm() throws IOException {
		WebDriver driver = DriverManager.getDriver();
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

		LoginPage login = new LoginPage(driver);

		login.LoginBtn();
		login.NewUserBtn();
		login.FirstName("Izuku");
		login.LastName("Midoriya");
		login.UserName("midoriyaizuku9@gmail.com");
		login.Password("Deku@9");
		login.RegisterBtn();

		login.loginEmail("midoriya9@gmail.com");
		login.LoginPassword("Deku@9");
		login.LoginClick();
	}

	@Test(dataProvider = "getLoginData", groups = { "LoginFormValidation" })
	public void LoginValidation(String userName, String password) {
		WebDriver driver = DriverManager.getDriver();
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		LoginPage login = new LoginPage(driver);

		login.LoginBtn();
		login.loginEmail(userName);
		login.LoginPassword(password);
		login.LoginClick();
	}

	@DataProvider
	public Object[][] getLoginData() {

		return new Object[][] { { "UzumakiNaruto7@gmail.com", "Uzumaki@07" },
				{ "midoriyaizuku9@gmail.com", "Deku@9" } };
	}
}
