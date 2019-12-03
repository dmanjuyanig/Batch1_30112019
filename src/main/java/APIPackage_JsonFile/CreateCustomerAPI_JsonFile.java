package APIPackage_JsonFile;

import SetUpPackage.TestSetup;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;

public class CreateCustomerAPI_JsonFile extends TestSetup{
	
	public static Response sendPostRequestToCreateCustomerWithValidSecretKey(String validSecretKey, String endPoint)
	{
		File body = new File("./src/test/java/TestCasesScript_Using_JsonFile/CreateUser.json");
		Response response = given().auth().basic(validSecretKey, "").body(body)
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
