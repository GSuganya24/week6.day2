package week6.day2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass_Assertion {
	public ChromeDriver driver;
@BeforeMethod
public void url() {
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("http://www.leafground.com/pages/radio.html");
driver.manage().window().maximize();
}
@AfterMethod
public void close() {
	driver.close();
}

}
