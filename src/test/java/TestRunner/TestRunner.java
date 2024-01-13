package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features={"AllFeatureFiles/orange.feature"},
	glue={"StepDefination"},
	plugin=
	{
		"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	},
	dryRun=false
	
)
public class TestRunner {

}
