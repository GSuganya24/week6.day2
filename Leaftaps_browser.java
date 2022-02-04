package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leaftaps_browser {
	public static RemoteWebDriver driver;

	public static void browserSelect(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Leaftaps_browser.browserSelect("Edge");
		driver.get("http://www.leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Go to Home Page']")).click();
		driver.findElement(By.xpath("//h5[text()='Button']")).click();
		System.out.println("Loaction : " +driver.findElement(By.xpath("//button[text()='Get Position']")).getLocation());
		System.out.println("Color : "+driver.findElement(By.id("color")).getCssValue("background-color"));//This will give color value
	    System.out.println("Size : " +driver.findElement(By.xpath("//button[text()='What is my size?']")).getSize());
	    Thread.sleep(1000);
		driver.close();
System.out.println("###########Change Browser with different url##############");
		Leaftaps_browser.browserSelect("Chrome");
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[1]/input")).click();
		driver.findElement(By.xpath("//div[4]/input")).click();
		System.out.println("Is the check box checked : " +(driver.findElement(By.xpath("//div[text()='Selenium']/input")).isSelected()));
		Boolean sel = driver.findElement(By.xpath("//div[text()='Not Selected']/input")).isSelected();
		Boolean desel = driver.findElement(By.xpath("//div[text()='I am Selected']/input")).isSelected();
		if(sel == true) {
			driver.findElement(By.xpath("//div[text()='Not Selected']/input")).click();
		}else if(desel == true) {
			driver.findElement(By.xpath("//div[text()='I am Selected']/input")).click();
		}
		//Select all the options
		driver.findElement(By.xpath("//div[text()='Option 1']/input")).click();
		driver.findElement(By.xpath("//div[text()='Option 2']/input")).click();
		driver.findElement(By.xpath("//div[text()='Option 3']/input")).click();
		driver.findElement(By.xpath("//div[text()='Option 4']/input")).click();
		driver.findElement(By.xpath("//div[text()='Option 5']/input")).click();
		Thread.sleep(1000);
		driver.close();

	}
}
