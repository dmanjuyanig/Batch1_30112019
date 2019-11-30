package TestJson;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import SetUpPackage.TestSetup;
import io.restassured.response.Response;

public class ValidateRetriveCustomerAPI2 extends TestSetup{
	
	@Test (priority=1)
	public void ValidateCreateCusAPIWithValidSK()
	{
		
		Response response = given().formParams("id", "1")
				.get("http://localhost:8080/SmartUtilityApi/rest/resource/getemployee/1");
		
		//******************Headers Validation in Json********************************//
		
		//Assert to verify the status code
		Assert.assertEquals(response.statusCode(), config.getSuccessResponseCode());
		
		//Assert to verify the content-type in header
		Assert.assertEquals(response.header("Content-Type"), config.getContentType());
		/*String contentType = response.header("Content-Type");
		System.out.println("Content-Type value: " + contentType);
		Assert.assertEquals(contentType, "application/json");*/
		
		//System.out.println(response.getStatusCode());
		//System.out.println(response.getStatusLine());
		
		response.prettyPrint();
		
		//Assert to verify the server details in header
		Assert.assertEquals(response.header("Server"), config.getServer());
		
		//String acceptLanguage = response.header("transfer-encoding");
		//System.out.println("Content-Encoding: " + acceptLanguage);
		
		//Assert to verify the transfer encoding details in header
		Assert.assertEquals(response.header("transfer-encoding"), config.getTransferEncoding());

		
	}
	

}
