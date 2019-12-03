package TestCasesScript_Using_ConfigProperties;

import org.testng.Assert;
import org.testng.annotations.Test;

import APIPackage_ConfigProperties.DeleteCustomerAPI_Config;
import SetUpPackage.TestSetup;
import UtilityPackage.TestUtils;
import io.restassured.response.Response;

public class DeleteCustomer_Config extends TestSetup 
{
	
	@Test (priority=1)
	public void DeleteCustomerWithValidSecretKey()
	{
		testLevelLog.get().assignAuthor("Manju Reddy");
		testLevelLog.get().assignCategory("Smoke");
		
		Response response = DeleteCustomerAPI_Config.DeleteRequestToWithValidSecretKey(config.getValidSecretKey(), 
							config.getCustomerAPIEndPoint()+"/"+CreateCustomer_Config.idValue1);
		
		response.prettyPrint();
		testLevelLog.get().info(response.body().asString());
		
		//Assert to json response body contains ID field
		Assert.assertTrue(TestUtils.jsonHasKey(response.asString(), "deleted"));
				
		//String DeleteStatus = response.jsonPath().get("deleted");
		//System.out.println("Customer deleted successfully : " + DeleteStatus);
		System.out.println("*********Execution of DeleteCustomerWithValidSecretKey is completed*********");
	}

}
