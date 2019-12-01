/*package TestJson;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import APIPackage.CreateCustomerAPI;
import SetUpPackage.TestSetup;
import UtilityPackage.DataProviderClass;
import UtilityPackage.TestUtils;
import io.restassured.response.Response;

public class TestDummy extends TestSetup{
	
	@Test
	public void validateAPIWithValidSecretKey()
	{
		testLevelLog.get().assignAuthor("Manju Reddy");
		testLevelLog.get().assignCategory("Smoke");
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerWithValidSecretKey(config.getEmail(), config.getDescription(), 
				config.getValidSecretKey(), config.getCustomerAPIEndPoint());
		
		//testLevelLog.get().info(response.body().asString());
		logResponseInReport(response.asString());
		
		response.prettyPrint();
		
		//Assert to verify the status code
		testLevelLog.get().info("Status code inthe response :- " +response.getStatusCode());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.statusCode(), config.getSuccessResponseCode());
		
		//Assert to json response body contains ID field
		testLevelLog.get().info("Status code inthe response :- " +response.jsonPath().get("id"));
		Assert.assertTrue(TestUtils.jsonHasKey(response.asString(), "id"));
		
		//Assert that that ID field is not null
		String idValue = response.jsonPath().get("id");
		Assert.assertNotNull(idValue);
	}
	
	@Test(dataProviderClass = DataProviderClass.class, dataProvider="dp", priority =2)
	public void validateAPIWithValidParameters(Hashtable<String, String> data)
	{
		testLevelLog.get().assignAuthor("Aadya Reddy");
		testLevelLog.get().assignCategory("Adhoc");
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerWithValidSecretKey(data.get("email"), data.get("description"), 
				config.getValidSecretKey(), config.getCustomerAPIEndPoint());
		
		//testLevelLog.get().info(response.body().asString());
		logResponseInReport(response.asString());
		
		response.prettyPrint();
		
		//Assert to verify the status code
		testLevelLog.get().info("Status code inthe response :- " +response.getStatusCode());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.statusCode(), config.getSuccessResponseCode());
		
		//Assert to json response body contains ID field
		testLevelLog.get().info("Status code inthe response :- " +response.jsonPath().get("id"));
		Assert.assertTrue(TestUtils.jsonHasKey(response.asString(), "id"));
		
		//Assert that that ID field is not null
		String idValue = response.jsonPath().get("id");
		Assert.assertNotNull(idValue);
	}

}
*/