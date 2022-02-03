package rh_steps_MergeLead;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RH_MergeLead extends BaseClass_RH_MergeLead{
	public static String leadID;
	@Given("Click the MergeLeads Tab")
	public void clickTheMergeLeadsTab() {
		driver.findElement(By.linkText("Merge Leads")).click();
	}
	@Given("Enter the first name as {string} in the From Lead field")
	public String enterFromLead(String fName) throws InterruptedException {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fName);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles.get(0));
		return leadID;
	}
	@Given("Enter the first name as {string} in the To Lead field")
	public void enterToLead(String tName) throws InterruptedException {
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> allWindows2 = driver.getWindowHandles();
		List<String> allhandles2 = new ArrayList<String>(allWindows2);
		driver.switchTo().window(allhandles2.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(tName);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles2.get(0));
	}
	@Given("Click the Merge button")
	public void clickTheMergeButton() {
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		driver.switchTo().alert().accept();
	}
	@Given("Click the FindLeads tab")
	public void clickTheFindLeadsTab() {
		driver.findElement(By.linkText("Find Leads")).click();
	}
	@Given("Enter the LeadId in the search field")
	public void enterTheLeadIdInTheSearchField() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	}
	@When("Click the Find Leads button")
	public void clickFindLeads() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
	}
	@Then("No record should return")
	public void noRecordShouldReturn() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
	}
}
