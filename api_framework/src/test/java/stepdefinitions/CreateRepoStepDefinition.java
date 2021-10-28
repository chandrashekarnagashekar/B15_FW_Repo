package stepdefinitions;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pojo.CreateGithubRepoResponsePOJO;
import pojo.CreateRepoPOJO;
import utils.GenericUtils;

public class CreateRepoStepDefinition {

	private BaseUtils baseUtils;
	public CreateRepoStepDefinition(BaseUtils base) {
		this.baseUtils = base;
	}
	
	@Given("Input JSON contains {string} with value {string}")
	public void inputJSONContainsWithValue(String paramName, String paramValue) {
		String inputJson = GenericUtils.getCreateRepoInputJson(paramName,paramValue);
	    System.out.println(inputJson);
	    //Log a message to the extent report
	    ExtentCucumberAdapter.addTestStepLog(inputJson);
	    baseUtils.rSpec.body(inputJson);
	}
	
	@Given("Input JSON contains {string},{string},{string}")
	public void inputJSONContains(String repoName, String description, String privateVal) {		
	    System.out.println("------------Input JSON step-----------");
		CreateRepoPOJO input = GenericUtils.getCreateRepoInputJson(repoName, description, privateVal);	    
		baseUtils.rSpec.body(input);
	}
	
	@Then("I verify response body contains {string},{string},{string}")
	public void verifyResponseBody(String name, String description, String privateVal) {	    
		CreateGithubRepoResponsePOJO obj = baseUtils.res.then()
				.extract().response().body().as(CreateGithubRepoResponsePOJO.class);
		
		MatcherAssert.assertThat(obj.getName(), Matchers.equalTo(name));
		MatcherAssert.assertThat(obj.getDescription(), Matchers.equalTo(description));	
		MatcherAssert.assertThat(obj.isPrivateVal(), Matchers.equalTo(Boolean.parseBoolean(privateVal)));	
	}
}
