package TestJson;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import SetUpPackage.TestSetup;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestCase extends TestSetup{
	
	
	@Test (priority=1)
	public void ValidateCreateCusAPIWithValidSK()
	{
		Response response = given().auth().basic(config.getValidSecretKey(), "")
							.formParam("email", "rest@gmail.com")
							.formParam("description", "Test User")
							.post("/customers");
				
		response.prettyPrint();	
		
		System.out.println(response.statusCode()); //200	
	}
	
	/*
	@Test (priority=2)
	public void ValidateCreateCustomerAPIWithInvalidSecretKey()
	{
		Response response = given().auth().basic("sk_test_4eC39HqLyjWDarjtT1zdp7d", "")
							.formParam("email", "rest@gmail.com")
							.formParam("description", "Test User")
							.post("https://api.stripe.com/v1/customers");
				
		response.prettyPrint();
		
		int actualResponse = 401;
		
		System.out.println(response.statusCode()); //401
		
		Assert.assertEquals(actualResponse actual value, 401 expected value, "Correct status code returned");
	}*/
}
