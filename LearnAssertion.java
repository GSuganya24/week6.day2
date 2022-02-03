package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAssertion extends BaseClass_Assertion{
	@Test
public void hardAssertion() {
	System.out.println("HardAssertion");
	boolean value = driver.findElement(By.xpath("//input[@name='age'][2]")).isSelected();
	Assert.assertEquals(value, false); //or Assert.assertTrue(value);
	driver.findElement(By.xpath("//input[@name='age'][1]")).click();
	System.out.println("Selection successful");
}
@Test
public void softAssertion() {
	System.out.println("SoftAssertion");
	boolean value = driver.findElement(By.xpath("//input[@name='age'][2]")).isSelected();
	SoftAssert sAssert = new SoftAssert();
	sAssert.assertFalse(value); //sAssert.assertEquals(value, false); 
	driver.findElement(By.xpath("//input[@name='age'][1]")).click();
	System.out.println("Selection successful");
	sAssert.assertAll();
}
}
