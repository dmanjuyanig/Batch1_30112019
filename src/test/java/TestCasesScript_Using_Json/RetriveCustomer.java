package TestCasesScript_Using_Json;

import org.testng.Assert;
import org.testng.annotations.Test;
import APIPackage.RetriveCustomerAPI;
import SetUpPackage.TestSetup;
import UtilityPackage.TestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RetriveCustomer extends TestSetup{
		
	@Test (priority=1)
	public void RetriveCustomerWithValidSecretKey()
	{
		testLevelLog.get().assignAuthor("Manju Reddy");
		testLevelLog.get().assignCategory("Smoke");
//		CreateCustomer cc = new CreateCustomer();
//		cc.CreateCustomerValidSecretKey();
		System.out.println("value 2 - " + CreateCustomer.idValue1);
		Response response = RetriveCustomerAPI.GetRequestToCreateCustomerWithValidSecretKey(config.getValidSecretKey(), 
							config.getValidSecretKey()+"/"+CreateCustomer.idValue1);
		
		//System.out.println(config.getCustomerAPIEndPoint()+"/"+CreateCustomer.idValue1);
		//System.out.println(CreateCustomer.idValue1);
		
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
