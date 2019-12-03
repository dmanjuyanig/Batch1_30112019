package TestCasesScript_Using_JsonFile;

import org.testng.Assert;
import org.testng.annotations.Test;

import APIPackage_ConfigProperties.CreateCustomerAPI_Config;
import APIPackage_HashMap.CreateCustomerAPI_Map;
import APIPackage_JsonFile.CreateCustomerAPI_JsonFile;
import SetUpPackage.TestSetup;
import UtilityPackage.TestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateCustomer_JsonFile extends TestSetup{
	
	public static String idValue1, idValue2;
			
	@Test (priority=1)
	public void CreateCustomerValidSecretKey()
	{
		testLevelLog.get().assignAuthor("Manju Reddy");
		testLevelLog.get().assignCategory("Smoke");
		
		Response response = CreateCustomerAPI_JsonFile.sendPostRequestToCreateCustomerWithValidSecretKey(config.getValidSecretKey(), 
							config.getCustomerAPIEndPoint());
		
		//testLevelLog.get().info(response.body().asString());
		logResponseInReport(response.asString());
		response.prettyPrint();
		
		//Assert to verify the status code
		testLevelLog.get().info("Status code in the response :- " +response.getStatusCode());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.statusCode(), config.getSuccessResponseCode());
		
		//Assert to json response body contains ID field
		testLevelLog.get().info("Status code in the response :- " +response.jsonPath().get("id"));
		Assert.assertTrue(TestUtils.jsonHasKey(response.asString(), "id"));
		
		//Assert that that ID field is not null
		idValue1 = response.jsonPath().get("id");
		System.out.println("idValue1 : " + idValue1);
		Assert.assertNotNull(idValue1);
	}
	
	@Test (priority=2)
	public void CreateCustomerValidParameter()
	{
		testLevelLog.get().assignAuthor("Kruthi Reddy");
		testLevelLog.get().assignCategory("Adhoc");
		Response response = CreateCustomerAPI_JsonFile.sendPostRequestToCreateCustomerWithInvalidSecretKey(config.getCreateCustomerValidParameter_email(), 
							config.getCreateCustomerValidParameter_description(), 
							config.getValidSecretKey(), 
							config.getCustomerAPIEndPoint());
		
		//testLevelLog.get().info(response.body().asString());
		logResponseInReport(response.asString());
		response.prettyPrint();
		
		//Assert to verify the status code
		testLevelLog.get().info("Status code in the response :- " +response.getStatusCode());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.statusCode(), config.getSuccessResponseCode());
		
		//Assert to json response body contains ID field
		testLevelLog.get().info("Status code in the response :- " +response.jsonPath().get("id"));
		Assert.assertTrue(TestUtils.jsonHasKey(response.asString(), "id"));
		
		//Assert that that ID field is not null
		idValue2 = response.jsonPath().get("id");
		System.out.println("idValue2 : " + idValue2);
		Assert.assertNotNull(idValue2);
	}
	
	@Test (priority=3)
	public void CreateCustomerWithInvalidParameter()
	{
		testLevelLog.get().assignAuthor("Aadvike Reddy");
		testLevelLog.get().assignCategory("Exploratory");
		
		Response response = CreateCustomerAPI_JsonFile.sendPostRequestToCreateCustomerWithInvalidParameter(config.getCreateCustomerWithInvalidParameter_email(), 
							config.getCreateCustomerWithInvalidParameter_description(), 
							config.getValidSecretKey(), 
							config.getCustomerAPIEndPoint());
		
		logResponseInReport(response.asString());
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		
		//Assert to verify the status code
		testLevelLog.get().info("Status code in the response :- " +response.getStatusCode());
		Assert.assertEquals(response.statusCode(), config.getUnauthorizedErrorResponseCode());
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println("Error Message : " + jsonPathEvaluator.get("error.message"));
		
		//Assert to json response body contains ID field
		Assert.assertTrue(TestUtils.jsonHasKey(response.asString(), "error"));
		
		//Assert that that ID field is null
		String idValue = response.jsonPath().get("id");
		Assert.assertNull(idValue);
	}
	
	@Test(priority =4)
	public void CreateCustomerWithInvalidSecretKey()
	{
		testLevelLog.get().assignAuthor("Aadya Reddy");
		testLevelLog.get().assignCategory("Exploratory");
		Response response = CreateCustomerAPI_JsonFile.sendPostRequestToCreateCustomerWithInvalidSecretKey(config.getCreateCustomerWithInvalidSecretKey_email(),
							config.getCreateCustomerWithInvalidSecretKey_description(), 
							config.getInValidSecretKey(), 
							config.getCustomerAPIEndPoint()); 

		logResponseInReport(response.asString());
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		
		//Assert to verify the status code
		testLevelLog.get().info("Status code in the response :- " +response.getStatusCode());
		Assert.assertEquals(response.statusCode(), config.getUnauthorizedErrorResponseCode());
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println("Error Message : " + jsonPathEvaluator.get("error.message"));
		
		//Assert to json response body contains ID field
		Assert.assertTrue(TestUtils.jsonHasKey(response.asString(), "error"));
		
		//Assert that that ID field is null
		String idValue = response.jsonPath().get("id");
		Assert.assertNull(idValue);
	}
	
	@Test(priority =5)
	public void CreateCustomerWithNoSecretKey()
	{
		testLevelLog.get().assignAuthor("Manju Reddy");
		testLevelLog.get().assignCategory("Regression");
		Response response = CreateCustomerAPI_JsonFile.sendPostRequestToCreateCustomerWithoutSecretKey(config.getCreateCustomerWithNoSecretKey_email(),
							config.getCreateCustomerWithNoSecretKey_description(), 
							config.getCustomerAPIEndPoint()); 

		logResponseInReport(response.asString());
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		
		//Assert to verify the status code
		testLevelLog.get().info("Status code in the response :- " +response.getStatusCode());
		Assert.assertEquals(response.statusCode(), config.getUnauthorizedErrorResponseCode());
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println("Error Message : " + jsonPathEvaluator.get("error.message"));
		
		//Assert to json response body contains ID field
		Assert.assertTrue(TestUtils.jsonHasKey(response.asString(), "error"));
		
		//Assert that that ID field is null
		String idValue = response.jsonPath().get("id");
		Assert.assertNull(idValue);
	}	
}
