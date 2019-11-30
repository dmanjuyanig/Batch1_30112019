package TestJson;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import SetUpPackage.TestSetup;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class ValidateRetriveCustomerAPI extends TestSetup{
	

	@Test (priority=1)
	public void RetriveCustomerAPI()
	{
		testLevelLog.get().assignAuthor("Aadvike Reddy");
		testLevelLog.get().assignCategory("Exploratory");
		Response response = given().formParams("id", "1")
				.get("http://localhost:8080/SmartUtilityApi/rest/resource/getemployee/1");
		
		response.prettyPrint();
		testLevelLog.get().info(response.body().asString());
		
		//Assert to verify the status code
		testLevelLog.get().info("Status code inthe response :- " +response.getStatusCode());
		Assert.assertEquals(response.statusCode(), config.getSuccessResponseCode());
		
		testLevelLog.get().info("Status code inthe response :- " +response.jsonPath().get("id"));
		
		//Assert to verify the status line
		Assert.assertEquals(response.statusLine(), config.getStatusLine());
		
		//******************Headers Validation in Json********************************//
		
		//Assert to verify the content-type in header
		Assert.assertEquals(response.header("Content-Type"), config.getContentType());
		
		//Assert to verify the server details in header
		Assert.assertEquals(response.header("Server"), config.getServer());
		
		//Assert to verify the transfer encoding details in header
		Assert.assertEquals(response.header("transfer-encoding"), config.getTransferEncoding());

		//Getting json body as string
		String body = response.getBody().toString();
		
		//Assert to verify all fields present in json body
		Assert.assertTrue(body.contains(config.validateJsonString()));
		
		//Assert to verify the response time
		Assert.assertTrue(response.getTime()<=config.getResponseTime());
	}
}
