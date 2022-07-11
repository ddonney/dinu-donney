package com.automation.api.cucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
/**
 * @author dinudonney
 * @Date 07/07/22
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/FindPetByID.feature",glue={"com/automation/api/stepDefinitions"},snippets = CucumberOptions.SnippetType.CAMELCASE)
public class CucumberRunner {
}
