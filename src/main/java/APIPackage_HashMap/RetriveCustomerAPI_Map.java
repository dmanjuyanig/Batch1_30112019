package APIPackage_HashMap;

import static io.restassured.RestAssured.given;

import SetUpPackage.TestSetup;
import io.restassured.response.Response;

public class RetriveCustomerAPI_Map extends TestSetup 
{
	public static Response GetRequestToCreateCustomerWithValidSecretKey(String validSecretKey, String endPoint)
	{
		Response response = given().auth().basic(validSecretKey, "")
		.get(endPoint);
		
		return response;
	}
	
	public static Response GetRequestToCreateCustomerWithInvalidSecretKey(String inValidSecretKey, String endPoint, String ID)
	{
		Response response = given().auth().basic(inValidSecretKey, "")
		.get(endPoint);
		
		return response;
	}
	
	public static Response GetRequestToWithInvalidCustomerID(String validSecretKey, String endPoint, String InvalidID)
	{
		Response response = given().auth().basic(validSecretKey, "")
		.get(endPoint);
		
		return response;
	}
}
