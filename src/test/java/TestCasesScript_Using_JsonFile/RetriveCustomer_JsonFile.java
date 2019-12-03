package TestCasesScript_Using_JsonFile;

import org.testng.Assert;
import org.testng.annotations.Test;

import APIPackage_ConfigProperties.RetriveCustomerAPI_Config;
import APIPackage_HashMap.RetriveCustomerAPI_Map;
import SetUpPackage.TestSetup;
import UtilityPackage.TestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RetriveCustomer_JsonFile extends TestSetup{
		
	@Test (priority=1)
	public void RetriveCustomerWithValidSecretKey()
	{
		testLevelLog.get().assignAuthor("Manju Reddy");
		testLevelLog.get().assignCategory("Smoke");

		Response response = RetriveCustomerAPI_Map.GetRequestToCreateCustomerWithValidSecretKey(config.getValidSecretKey(), 
							config.getCustomerAPIEndPoint()+"/"+CreateCustomer_JsonFile.idValue1);
		
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
}
