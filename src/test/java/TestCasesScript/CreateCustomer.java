package TestCasesScript;


import org.testng.Assert;
import org.testng.annotations.Test;

import APIPackage.CreateCustomerAPI;
import SetUpPackage.TestSetup;
import UtilityPackage.TestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateCustomer extends TestSetup{
	
	@Test (priority=1)
	public void CreateCustomerValidSecretKey()
	{
		testLevelLog.get().assignAuthor("Manju Reddy");
		testLevelLog.get().assignCategory("Smoke");
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerWithValidSecretKey(config.getCreateCustomerValidSecretKey_email(), 
							config.getCreateCustomerValidSecretKey_description(), 
							config.getValidSecretKey(), 
							config.getCustomerAPIEndPoint());
		
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
	
	@Test (priority=2)
	public void CreateCustomerValidParameter()
	{
		testLevelLog.get().assignAuthor("Kruthi Reddy");
		testLevelLog.get().assignCategory("Adhoc");
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerWithValidSecretKey(config.getCreateCustomerValidParameter_email(), 
							config.getCreateCustomerValidParameter_description(), 
							config.getValidSecretKey(), 
							config.getCustomerAPIEndPoint());
		
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
	
	@Test (priority=3)
	public void CreateCustomerWithInvalidParameter()
	{
		testLevelLog.get().assignAuthor("Aadvike Reddy");
		testLevelLog.get().assignCategory("Exploratory");
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerWithValidSecretKey(config.getCreateCustomerWithInvalidParameter_email(), 
							config.getCreateCustomerWithInvalidParameter_description(), 
							config.getValidSecretKey(), 
							config.getCustomerAPIEndPoint());
		
		logResponseInReport(response.asString());
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		
		//Assert to verify the status code
		testLevelLog.get().info("Status code inthe response :- " +response.getStatusCode());
		Assert.assertEquals(response.statusCode(), config.getBadRequestResponseCode());
		
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
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerWithInvalidSecretKey(config.getCreateCustomerWithInvalidSecretKey_email(),
							config.getCreateCustomerWithInvalidSecretKey_description(), 
							config.getInValidSecretKey(), 
							config.getCustomerAPIEndPoint()); 

		logResponseInReport(response.asString());
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		
		//Assert to verify the status code
		testLevelLog.get().info("Status code inthe response :- " +response.getStatusCode());
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
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerWithoutSecretKey(config.getCreateCustomerWithNoSecretKey_email(),
							config.getCreateCustomerWithNoSecretKey_description(), 
							config.getCustomerAPIEndPoint()); 

		logResponseInReport(response.asString());
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		
		//Assert to verify the status code
		testLevelLog.get().info("Status code inthe response :- " +response.getStatusCode());
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
