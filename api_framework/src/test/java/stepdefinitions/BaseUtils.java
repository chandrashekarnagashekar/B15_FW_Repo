package stepdefinitions;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseUtils {

	String url = "orgs/orgchandra/repos";
	RequestSpecification rSpec;
	Response res;
	String token;
}

