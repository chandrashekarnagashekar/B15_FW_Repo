package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.GenericUtils;

public class BaseClass {
//	Cucumber Hooks - import has to be io.cucumber.java
	//
	//	Before / After -> get executed before and after each scenario
	//	You can have multiple @Before and @After hooks
	//	You can specify the tags for @Before and @After to control the hooks execution for specific scenarios
	
	private BaseUtils baseUtils;
	
	public BaseClass(BaseUtils base) {
		this.baseUtils=base;
	}
	
	@Before
	public void beforeScenarioOne() {
		//Generate a token using client Id / secret to be used for the scenarios
		System.out.println("------------ Executing Before Scenario One------------");		
	}
	
	//@Before -> io.cucumber.java.Before -> Cucumber hook
	@Before
	public void beforeScenario() {
		//Generate a token using client Id / secret to be used for the scenarios
		System.out.println("------------ Executing Before Scenario ------------");
		//pass clientID/Secret -> get the response. Extract the token and save
		baseUtils.token = "Brearer token value";
	}		
	
	//@After -> io.cucumber.java.After -> Cucumber hook
	@After("@p2")
	public void afterScenario() {
		System.out.println("------------ Executing After Scenario ------------");
	}
	
	@After("@createrepo")
	public void afterScenarioDelete() {
		System.out.println("------------ Code to delete repo ------------");
	}
}
