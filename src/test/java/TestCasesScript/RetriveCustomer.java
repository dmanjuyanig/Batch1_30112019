package TestCasesScript;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import APIPackage.CreateCustomerAPI;
import APIPackage.RetriveCustomerAPI;
import SetUpPackage.TestSetup;
import UtilityPackage.TestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class RetriveCustomer extends TestSetup{
	
	@Test (priority=1)
	public void RetriveCustomerValidSecretKey()
	{
		testLevelLog.get().assignAuthor("Manju Reddy");
		testLevelLog.get().assignCategory("Smoke");
		
		Response response = RetriveCustomerAPI.GetRequestToCreateCustomerWithValidSecretKey(config.getValidSecretKey(), 
							config.getGetCustomerAPIEndPoint());
		
		response.prettyPrint();
		testLevelLog.get().info(response.body().asString());
		
		//Assert to verify the status code
		testLevelLog.get().info("Status code in the response :- " +response.getStatusCode());
		Assert.assertEquals(response.statusCode(), config.getSuccessResponseCode());
				
		testLevelLog.get().info("ID in the response :- " +response.jsonPath().get("id"));
		
		//Assert to verify the status line
		Assert.assertEquals(response.statusLine(), config.getStatusLine());
				
		//******************Headers Validation in Json********************************//
				
		//Assert to verify the content-type in header
		Assert.assertEquals(response.header("Content-Type"), config.getContentType());
				
		//Assert to verify the server details in header
		//Assert.assertEquals(response.header("Server"), config.getServer());
				
		//Assert to verify the transfer encoding details in header
		//Assert.assertEquals(response.header("transfer-encoding"), config.getTransferEncoding());

		//Getting json body as string
		String body = response.getBody().toString();
				
		//Assert to verify all fields present in json body
		Assert.assertTrue(body.contains(config.validateJsonString()));
				
		//Assert to verify the response time
		//Assert.assertTrue(response.getTime()<=config.getResponseTime());
	}

	@Test (priority=2)
	public void RetriveCustomerInvalidSecretKey()
	{
		testLevelLog.get().assignAuthor("Manju Reddy");
		testLevelLog.get().assignCategory("Smoke");
		
		Response response = RetriveCustomerAPI.GetRequestToCreateCustomerWithInvalidSecretKey(config.getInValidSecretKey(), 
							config.getGetCustomerAPIEndPoint());
		
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
