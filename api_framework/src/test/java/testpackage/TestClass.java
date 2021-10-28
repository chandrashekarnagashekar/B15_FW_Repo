package testpackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestClass {

	public static void main(String[] args) {
		String url = "https://api.github.com/orgs/orgchandra/repos";
		
		RequestSpecification rSpec = 
				RestAssured
					.given();
		
		rSpec.header("","");
		rSpec.queryParam("", "");
		rSpec.body("");
		Response res = rSpec.when().post();
		
		res.then().statusCode(201);
				
//		RestAssured
//			.given()
//				.header("","")
//				.queryParam("","")
//				.body(""))
//				
//			.when()
//				.post()
//				
//			.then()
//				.statusCode(200);
		
//		RequestSpecification rSpec = RestAssured
//			.given()
//				.header("Authorization", "Bearer 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");
//			
//				
//		Response res = rSpec.when()
//				.get(url);
//				
//				
//		res.then()
//			.statusCode(200);

	}

}
