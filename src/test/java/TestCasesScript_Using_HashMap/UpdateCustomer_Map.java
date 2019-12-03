package TestCasesScript_Using_HashMap;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import APIPackage_ConfigProperties.CreateCustomerAPI_Config;
import APIPackage_ConfigProperties.RetriveCustomerAPI_Config;
import SetUpPackage.TestSetup;
import UtilityPackage.TestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class UpdateCustomer_Map extends TestSetup{
	
	@Test (priority=1)
	public void RetriveCustomerValidSecretKey()
	{
		Response response = given().auth().basic("sk_test_4eC39HqLyjWDarjtT1zdp7dc", "")
				.formParam("email", "rest@gmail.com")
				.formParam("address", "Test User")
				.put("https://api.stripe.com/v1/customers/cus_GHR40d9bPFDOzl");
	
				response.prettyPrint();	

				System.out.println(response.statusCode()); //200	
	}

	


}
