package tags_steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeadMethods extends BaseClass_tags {
    public static String fName;
	public static String fLead;
	public static String leadID;
	public static String leadId1;

//	Create Lead	
	
	@When("Click the CreateLead Button")
	public void clickCreateLead() throws InterruptedException {
		driver.findElement(By.linkText("Create Lead")).click();
		Thread.sleep(2000);
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
    
//    Duplicate Lead
    
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
	
//	MergeLead
	
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
	
//	DeleteLead
	
	@Given("Search by phoneNumber {string}")
	public void searchByNumber(String num) throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(num);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
	}
	@Given("Capture the first resulting LeadId")
	public String captureLeadId() {
		leadId1 = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		return leadId1;
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
		driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item']//input")).sendKeys(leadId1);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
	}
	@Then("No records found should be displayed")
	public void noRecordMessage() {
		String result = driver.findElement(By.xpath("//div[@class='x-toolbar x-small-editor' ]//div")).getText();
		System.out.println(result);
	}
}
