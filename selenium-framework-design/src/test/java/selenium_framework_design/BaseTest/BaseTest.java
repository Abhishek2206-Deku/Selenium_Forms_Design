package selenium_framework_design.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	@BeforeMethod(alwaysRun = true)
	public void LaunchAppliction() throws IOException {
		WebDriver driver = DriverIntialization();
		DriverManager.setDriver(driver);
	}

	public WebDriver DriverIntialization() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\selenium_framework_design_resources\\GlobalData.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		WebDriver driver = null;

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			// firefox
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			// edge
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

		// Read Json to String
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// String to HashMap (Jackson Databind -- Dependency)
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String GetScreenShot(String testCaseName) throws IOException {
		WebDriver ssDriver = DriverManager.getDriver();
		TakesScreenshot ts = (TakesScreenshot) ssDriver;
		File source = ts.getScreenshotAs(OutputType.FILE);
//		File file= new File(System.getProperty("user.dir") + "//reports//" + testCaseName +".png");
//		return System.getProperty("user.dir") + "//reports//" + testCaseName +".png";
		String destination = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

		FileUtils.copyFile(source, new File(destination));

		return destination;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		DriverManager.getDriver().quit();
		DriverManager.unload();
	}

}
