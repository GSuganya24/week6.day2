package rh_steps_CreateLead;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RH_CreateLead extends BaseClass_RH_CreateLead {
	@When("Click the CreateLead Button")
	public void clickCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
	}
	@Then("CreateLead page should open")
	public void leadPage() {
		boolean page = driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_leads' and text()='Create Lead']")).isDisplayed();
		if(page == true) {
			System.out.println("Opened Create Lead Page");
		}else {
			System.out.println("Not opened Create Lead Page ");
		}
	}
	@Given("Enter the companyName as {string}")
	public void companyName(String cName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
	}
	@Given("Enter the firstName as {string}")
	public void fName(String fName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
	}
	@Given("Enter the lastName as {string}")
	public void lName(String lName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
	}
    @Given("Enter the Email Address as {string}")
    public void email(String email) {
    	driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email);
    }
    @Given("Enter the PhoneNumber as {string}")
    public void phoneNumber(String num) {
    	driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(num);
    }
    @When("Click Submit button")
    public void submit() {
    	driver.findElement(By.className("smallSubmit")).click();
    }
    @Then("ViewLead should be displayed")
    public void viewLead() {
    	boolean view = driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_leads' and text()='View Lead']")).isDisplayed();
    	if(view == true) {
    		System.out.println("Lead creation is successful");
    	}else {
    		System.out.println("Lead is not created");
    	}
    }
}
