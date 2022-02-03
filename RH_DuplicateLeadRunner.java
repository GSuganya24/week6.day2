package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import rh_steps_DuplicateLead.BaseClass_RH_DuplicateLead;

@CucumberOptions(features = "src/test/java/feature/DuplicateLead.feature", glue = "rh_steps_DuplicateLead", monochrome = true, dryRun = false, snippets = SnippetType.CAMELCASE, publish = true)
public class RH_DuplicateLeadRunner extends BaseClass_RH_DuplicateLead {

}
