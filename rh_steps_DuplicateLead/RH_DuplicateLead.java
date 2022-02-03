package rh_steps_DuplicateLead;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RH_DuplicateLead extends BaseClass_RH_DuplicateLead{
	public static String fName;
	public static String fLead;
	@Given("Click the Find Lead Tab")
	public void clickFindLead() {
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	}
	@Given("Click Email Tab")
	public void clickEmail() {
		driver.findElement(By.xpath("//span[text()='Email']")).click();
	}
	@Given("Enter the email address as {string}")
	public void enterEmail(String email) {
		driver.findElement(By.xpath("//div[@class='x-form-element']/input[@name='emailAddress']"))
		.sendKeys(email);
	}
	@When("Click Find Leads")
	public void clickFind() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
	}
	@Then("Records should be displayed")
	public void checkRecords() {
		boolean record = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).isDisplayed();
		if(record == true) {
			System.out.println("Records available to create duplicate");
		}else {
			System.out.println("No Lead records available to create duplicate");
		}
	}
	@Given("Take the firstName of the Lead")
	public static String takeName() {
		fLead = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();
		return fLead;
	}
	@Given("Click the first resulting Lead")
	public void clickFirstLead() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	@Given("Click the Duplicate Lead button")
	public void clickDupLeadButton() {
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
	}
	@When("Click the Create Lead button")
	public void clickCreateLead() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		Thread.sleep(2000);
	}
	@Then("View Lead page should be displayed")
	public void verifyPage() {
		boolean view = driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_leads' and text()='View Lead']")).isDisplayed();
		if(view == true) {
			System.out.println("Created Duplicate Lead");
		}else {
			System.out.println("Unable to Create Duplicate Lead");
		}
	}
	@Given("Take the firstName of the Lead created")
	public static String takeFirstName() {
		fName = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		return fName;
	}
	@Given("Check Whether the names are equal")
	public void check() {
		if (fLead.equalsIgnoreCase(fName)) {
			System.out.println("Duplicated lead name is same as captured name");
		}
		else {
			System.out.println("Duplicated lead name is not same as captured name");
		}
	}
}
