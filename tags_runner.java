package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import tags_steps.BaseClass_tags;

@CucumberOptions(features = "src/test/java/feature/Tag.feature", glue = "tags_steps", monochrome = true, dryRun = false, snippets = SnippetType.CAMELCASE, tags="@Duplicate or @DeleteLead")
public class tags_runner extends BaseClass_tags {

}
