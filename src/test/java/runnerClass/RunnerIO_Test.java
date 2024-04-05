package runnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".\\src\\test\\java\\featureFile\\OpportunitiesModule.feature",
		glue = "stepDefinitions",
		dryRun = false
		)


public class RunnerIO_Test extends AbstractTestNGCucumberTests {

}
