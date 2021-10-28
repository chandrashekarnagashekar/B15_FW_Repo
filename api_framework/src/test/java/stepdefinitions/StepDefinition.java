package stepdefinitions;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.CreateGithubRepoResponsePOJO;
import pojo.CreateRepoPOJO;
import utils.GenericUtils;

public class StepDefinition{	
	
	private BaseUtils baseUtils;
	
	public StepDefinition(BaseUtils base) {
		this.baseUtils = base;
	}	
	
	@Given("Header has {string} with value {string}")
	public void headerHasValue(String key, String value) {	    
		System.out.println("Executing Given");
		System.out.println("-----Token value is :"+baseUtils.token);
		System.out.println("Header Key="+key+" --- Value="+value);
		baseUtils.rSpec = RestAssured
				.given()
					.header(key, value);
	}				
	
	@And("Query param {string} is {string}")
	public void queryParamIs(String key, String value) {
	    System.out.println("Executing Given Query Param");
	    baseUtils.rSpec.queryParam(key, value);
	}		
	
	@When("I execute {string} request")
	public void executeRequest(String requestType) {	    
		System.out.println("Executing When");
		if(requestType.equals("GET")) {
			baseUtils.res = baseUtils.rSpec.when().log().all()
					.get(baseUtils.url);
		}
		else if(requestType.equals("POST")) {
			baseUtils.res = baseUtils.rSpec.when()
					.post(baseUtils.url);
		}
	}
	
	
	@Then("I verify statuscode is {int}")
	public void verifyStatuscodeIs(int statusCode) {	    
		System.out.println("Executing Then");
		baseUtils.res.then()
			.statusCode(statusCode);
		
//		String respBody = res.then().extract().response().body().asString();
//		ExtentCucumberAdapter.addTestStepLog(respBody);
	}
	
	
	
	
	//The deserialization with multiple steps will not work.
	//This is if you want validation with RestAssured way / JsonPath way
	@Then("I verify {string} is {string}")
	public void iVerifyIs(String key, String expectedValue) {
		int statusCode = baseUtils.res.then()
			.extract().response().statusCode();
		
		System.out.println(statusCode);
		
//		CreateGithubRepoResponsePOJO obj = res.then()
//		.extract().response().body().as(CreateGithubRepoResponsePOJO.class);
//		
//		String actualRespName = obj.getName();
//		MatcherAssert.assertThat(actualRespName, Matchers.equalTo(expectedValue));
//		
//		String actualDescription = obj.getDescription();
//		MatcherAssert.assertThat(actualDescription, Matchers.equalTo(expectedValue));
				
		
		if(statusCode == 201) {
			baseUtils.res.then()
			.assertThat()
				.body(key, Matchers.equalTo(expectedValue));
		}
		
		
//		//Method 1:
//		res.then()
//			.assertThat()
//				.body(key, Matchers.equalTo(expectedValue));
//		
//		//Method 2:
//		JsonPath jPath = res.then().extract().response().jsonPath();		
//		String actualValue = jPath.get(key);
//		System.out.println(actualValue);
//		MatcherAssert.assertThat(actualValue, Matchers.equalTo(expectedValue));
	}

}
