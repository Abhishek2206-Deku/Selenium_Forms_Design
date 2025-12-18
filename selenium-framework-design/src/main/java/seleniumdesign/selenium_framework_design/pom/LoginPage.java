package seleniumdesign.selenium_framework_design.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium_framework_design_AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='login.php']")
	WebElement loginBtn;

	@FindBy(css = "a[class*='ms-4']")
	WebElement newUserBtn;

	@FindBy(id = "firstname")
	WebElement firstName;

	@FindBy(id = "lastname")
	WebElement lastName;

	@FindBy(css = "input[name='username']")
	WebElement userName;

	@FindBy(css = "input[name='password']")
	WebElement password;

	@FindBy(css = "a[class*='btn btn-primary']")
	WebElement register;

	@FindBy(id = "email")
	WebElement loginEmail;

	@FindBy(id = "password")
	WebElement loginPass;

	@FindBy(css = "input[value='Login']")
	WebElement loginButton;

	public void LoginBtn() {
		loginBtn.click();
	}

	public void NewUserBtn() {
		newUserBtn.click();
	}

	public void FirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void LastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void UserName(String uname) {
		userName.sendKeys(uname);
	}

	public void Password(String pass) {
		password.sendKeys(pass);
	}

	public void RegisterBtn() {
		register.click();
	}

	public void loginEmail(String logMail) {
		loginEmail.sendKeys(logMail);
	}

	public void LoginPassword(String logPass) {
		loginPass.sendKeys(logPass);
	}

	public void LoginClick() {
		loginButton.click();
	}
}
