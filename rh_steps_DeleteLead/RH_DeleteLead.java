package rh_steps_DeleteLead;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RH_DeleteLead extends BaseClass_RH_DeleteLead {
	public static String leadId;
	@Given("Click the Find Leads Tab")
	public void clickFindLeads() {
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	}
	@Given("Search by phoneNumber {string}")
	public void searchByNumber(String num) throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(num);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
	}
	@Given("Capture the first resulting LeadId")
	public String captureLeadId() {
		leadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		return leadId;
	}
	@Given("Click the first resulting LeadId")
	public void clickTheLeadId() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	@Given("Delete the record")
	public void delete() {
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
	}
	@When("Search for the LeadId captured")
	public void searchLeadId() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item']//input")).sendKeys(leadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
	}
	@Then("No records found should be displayed")
	public void noRecordMessage() {
		String result = driver.findElement(By.xpath("//div[@class='x-toolbar x-small-editor' ]//div")).getText();
		System.out.println(result);
	}
}
