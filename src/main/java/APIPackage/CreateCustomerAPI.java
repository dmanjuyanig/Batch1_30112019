package APIPackage;

import SetUpPackage.TestSetup;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateCustomerAPI extends TestSetup{
	
	public static Response sendPostRequestToCreateCustomerWithValidSecretKey(String email, String description, String validSecretKey, String endPoint)
	{
		Response response = given().auth().basic(validSecretKey, "")
		.formParam("email", email)
		.formParam("description", description)
		.post(endPoint);
		
		return response;
	}
	
	public static Response sendPostRequestToCreateCustomerWithInvalidSecretKey(String email, String description, String inValidSecretKey, String endPoint)
	{
		Response response = given().auth().basic(inValidSecretKey, "")
		.formParam("email", email)
		.formParam("description", description)
		.post(endPoint);
		
		return response;
	}
	
	public static Response sendPostRequestToCreateCustomerWithoutSecretKey(String email, String description, String endPoint)
	{
		Response response = given().auth().basic("", "")
		.formParam("email", email)
		.formParam("description", description)
		.post(endPoint);
		
		return response;
	}

}
