package runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import io.restassured.RestAssured;
import utils.GenericUtils;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"stepdefinitions"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		tags = "@regression"
)
public class TestRunner {

	@BeforeClass
	public static void beforeRun() {
		System.out.println("---------Before Any scenario runs -----------");
		String env = GenericUtils.getProperties("global","ENV");
		String url = GenericUtils.getProperties(env,"URL");
		RestAssured.baseURI=url;
		System.out.println("Environment is: "+env);
		System.out.println("URL is :"+url);
	}
}


