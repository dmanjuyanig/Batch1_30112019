package APIPackage_HashMap;

import static io.restassured.RestAssured.given;

import SetUpPackage.TestSetup;
import io.restassured.response.Response;

public class DeleteCustomerAPI_Map extends TestSetup
{
	
	public static Response DeleteRequestToWithValidSecretKey(String validSecretKey, String endPoint)
	{
		Response response = given().auth().basic(validSecretKey, "")
		.delete(endPoint);
		
		return response;
	}
	
	public static Response DeleteRequestToWithInvalidSecretKey(String inValidSecretKey, String endPoint, String ID)
	{
		Response response = given().auth().basic(inValidSecretKey, "")
		.delete(endPoint);
		
		return response;
	}
	
	public static Response DeleteRequestToWithInvalidUniqueID(String validSecretKey, String endPoint, String InvalidID)
	{
		Response response = given().auth().basic(validSecretKey, "")
		.delete(endPoint);
		
		return response;
	}

}
