package Base;

import org.testng.annotations.BeforeTest;

import com.testingacademy.actions.AssertsActions;
import com.testingacademy.endpoints.APIContstants;
import com.testingacademy.modules.PayloadsManager;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class baseTest {

	public RequestSpecification requestSpecification;
	public AssertsActions assertsActions;
	public PayloadsManager payloadsManager;
	public JsonPath jsonPath;
	public Response response;
	public ValidatableResponse validatableResponse;
	
	
	@BeforeTest
	public void setConfig() {
		System.out.println("Before Test");
		payloadsManager = new PayloadsManager();
		assertsActions = new AssertsActions();
		
		requestSpecification = new RequestSpecBuilder()
				.setBaseUri(APIContstants.BASE_URL)
				.addHeader("Content-Type", "application/json")
				.build().log().all();
		
		// Any one we can use---
		
//		requestSpecification = RestAssured.given()
//				.baseUri(APIContstants.BASE_URL)
//				.contentType(ContentType.JSON)
//				.log().all();
//		
	}
	
	public String getToken() {
		return null;
	}
	
}
