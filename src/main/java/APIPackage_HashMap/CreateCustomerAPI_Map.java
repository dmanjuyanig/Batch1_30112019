package APIPackage_HashMap;

import SetUpPackage.TestSetup;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateCustomerAPI_Map extends TestSetup{
	
	public static Response sendPostRequestToCreateCustomerWithValidSecretKey(String email, String description, String validSecretKey, String endPoint)
	{
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email", email);
		map.put("description", description);
		Response response = given().auth().basic(validSecretKey, "")
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
	
	public static Response sendPostRequestToCreateCustomerWithInvalidParameter(String email, String description, String inValidSecretKey,String endPoint)
	{
		Response response = given().auth().basic("", "")
		.formParam("email", email)
		.formParam("description", description)
		.post(endPoint);
		
		return response;
	}
}
