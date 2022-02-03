package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import rh_steps_MergeLead.BaseClass_RH_MergeLead;

@CucumberOptions(features = "src/test/java/feature/MergeLead.feature", glue = "rh_steps_MergeLead", monochrome = true, dryRun = false, snippets = SnippetType.CAMELCASE, publish = true)
public class RH_MergeLeadRunner extends BaseClass_RH_MergeLead{

}
