package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import rh_steps_CreateLead.BaseClass_RH_CreateLead;

@CucumberOptions(features = "src/test/java/feature/Login_Lead.feature", glue = "rh_steps_CreateLead", monochrome = true, dryRun = false, snippets = SnippetType.CAMELCASE, publish = true)
public class RH_CreateLeadRunner extends BaseClass_RH_CreateLead{

}
