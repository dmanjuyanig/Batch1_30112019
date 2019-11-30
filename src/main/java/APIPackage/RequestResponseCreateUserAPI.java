package APIPackage;

import static io.restassured.RestAssured.*;

import POJO.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestResponseCreateUserAPI {
	
	public static Response sendPostRequestWithValidData(String name, String job)
	{
		User user = new User(name, job);
		Response response = given().contentType(ContentType.JSON)
							.body(user).post("https://reqres.in/api/users");
		return response;
	}
	
	/*public void sendPostRequestWithoutName()
	{
		
	}
	
	public void sendPostRequestWithoutJob()
	{
		
	}*/

}
