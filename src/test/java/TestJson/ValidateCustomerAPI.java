package TestJson;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import SetUpPackage.TestSetup;
import UtilityPackage.configProperties;
import io.restassured.response.Response;

public class ValidateCustomerAPI extends TestSetup{
	
	@Test
	public void ValidateCreateCustomerAPIWithValidKey()
	{
		Response response = given().auth().basic(config.getValidSecretKey(), "")
				.formParam("email", "rest@gmail.com")
				.formParam("description", "Test User")
				.post(config.getCustomerAPIEndPoint());
	
response.prettyPrint();	

System.out.println(response.statusCode()); //200	
	}
	
	@Test
	public void ValidateCreateCustomerAPIWithINvalidKey()
	{
		
	}
	
	@Test
	public void ValidateDaleteAPI()
	{
		
	}
	
	@Test
	public void retriveCostomer()
	{
		
	}

}
