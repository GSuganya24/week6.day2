package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import rh_steps_DeleteLead.BaseClass_RH_DeleteLead;

@CucumberOptions(features = "src/test/java/feature/DeleteLead.feature", glue = "rh_steps_DeleteLead", monochrome = true,
dryRun = false, snippets = SnippetType.CAMELCASE, publish = true)
public class RH_DeleteLeadRunner extends BaseClass_RH_DeleteLead {

}
