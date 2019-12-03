package TestJson;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import APIPackage_ConfigProperties.CreateCustomerAPI_Config;
import SetUpPackage.TestSetup;
import UtilityPackage.DataProviderClass;
import UtilityPackage.TestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class ValidateCreateCustomerAPI extends TestSetup{
	
	
	@Test(dataProviderClass = DataProviderClass.class, dataProvider="dp", priority =1)
	public void validateAPIWithValidSecretKey(Hashtable<String, String> data)
	{
		testLevelLog.get().assignAuthor("Manju Reddy");
		testLevelLog.get().assignCategory("Smoke");
		Response response = CreateCustomerAPI_Config.sendPostRequestToCreateCustomerWithValidSecretKey(data.get("email"), data.get("description"), 
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
	
	/*@Test(dataProviderClass = DataProviderClass.class, dataProvider="dp", priority =2)
	public void validateAPIWithoutValidSecretKey(Hashtable<String, String> data)
	{
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerWithoutSecretKey(data.get("email"), data.get("description"), config.getInValidSecretKey(), config.getCustomerAPIEndPoint()); 

		response.prettyPrint();
		
		System.out.println(response.statusCode());
		
		//Assert to verify the status code
		Assert.assertEquals(response.statusCode(), 401);
		
		//Assert to json response body contains ID field
		Assert.assertTrue(TestUtils.jsonHasKey(response.asString(), "id"));
		
		//Assert that that ID field is not null
		String idValue = response.jsonPath().get("id");
		Assert.assertNotNull(idValue);
	}*/
	
	/*@Test(dataProviderClass = DataProviderClass.class, dataProvider="dp", priority =3)
	public void validateAPIWithInvalidSecretKey(Hashtable<String, String> data)
	{
		testLevelLog.get().assignAuthor("Kruthi Reddy");
		testLevelLog.get().assignCategory("Regression");
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerWithInvalidSecretKey(data.get("email"), data.get("description"), 
				config.getInValidSecretKey(), config.getCustomerAPIEndPoint());
		
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		
		//Assert to verify the status code
		Assert.assertEquals(response.statusCode(), 401);
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println("Error Message : " + jsonPathEvaluator.get("error.message"));
		
		//Assert to json response body contains ID field
		Assert.assertTrue(TestUtils.jsonHasKey(response.asString(), "error"));
		
		//Assert that that ID field is null
		String idValue = response.jsonPath().get("id");
		Assert.assertNull(idValue);
	}*/
	
	@Test(dataProviderClass = DataProviderClass.class, dataProvider="dp", priority =4)
	public void validateAPIWithValidParameters(Hashtable<String, String> data)
	{
		testLevelLog.get().assignAuthor("Aadya Reddy");
		testLevelLog.get().assignCategory("Adhoc");
		Response response = CreateCustomerAPI_Config.sendPostRequestToCreateCustomerWithValidSecretKey(data.get("email"), data.get("description"), 
				config.getValidSecretKey(), config.getCustomerAPIEndPoint());
		
		response.prettyPrint();
		
		//Assert to verify the status code
		Assert.assertEquals(response.statusCode(), 200);
		
		//Assert to json response body contains ID field
		Assert.assertTrue(TestUtils.jsonHasKey(response.asString(), "id"));
		
		//Assert that that ID field is not null
		String idValue = response.jsonPath().get("id");
		Assert.assertNotNull(idValue);
	}
	
	/*@Test(dataProviderClass = DataProviderClass.class, dataProvider="dp",priority =5)
	public void validateAPIWithInvalidParameter(Hashtable<String, String> data)
	{
		testLevelLog.get().assignAuthor("Aadvike Reddy");
		testLevelLog.get().assignCategory("Exploratory");
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerWithValidSecretKey(data.get("email"), data.get("description"), 
				config.getValidSecretKey(), config.getCustomerAPIEndPoint());
		
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		
		//Assert to verify the status code
		Assert.assertEquals(response.statusCode(), 400);
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println("Error Message : " + jsonPathEvaluator.get("error.message"));
		
		//Assert to json response body contains ID field
		Assert.assertTrue(TestUtils.jsonHasKey(response.asString(), "error"));
		
		//Assert that that ID field is null
		String idValue = response.jsonPath().get("id");
		Assert.assertNull(idValue);
	}
	*/
	/*@Test(dataProvider="dp",dataProviderClass = DataProviderClass.class)
	public void validateAPIWithoutValidSecretKey(Hashtable<String, String> data)
	{
		System.out.println("Email---> " +data.get("email"));
		System.out.println("Description---> " +data.get("description"));
		System.out.println("Email---> " +data.get("email"));
	}*/
	
/*	@Test
	public void validateFail()
	{
		Assert.fail();
	}
	
	@Test(dependsOnMethods = "validateFail")
	public void validateSkip()
	{
		//this will skip
	}*/
	

}
