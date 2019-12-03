package TestCasesScript_Using_HashMap;

import org.testng.annotations.Test;

import APIPackage_HashMap.DeleteCustomerAPI_Map;
import SetUpPackage.TestSetup;
import TestCasesScript_Using_ConfigProperties.CreateCustomer_Config;
import io.restassured.response.Response;

public class DeleteCustomer_Map extends TestSetup 
{
	
	@Test (priority=1)
	public void DeleteCustomerWithValidSecretKey()
	{
		testLevelLog.get().assignAuthor("Manju Reddy");
		testLevelLog.get().assignCategory("Smoke");
		
		Response response = DeleteCustomerAPI_Map.DeleteRequestToWithValidSecretKey(config.getValidSecretKey(), 
							config.getCustomerAPIEndPoint()+"/"+CreateCustomer_Config.idValue1);
		
		response.prettyPrint();
		testLevelLog.get().info(response.body().asString());
	}

}
