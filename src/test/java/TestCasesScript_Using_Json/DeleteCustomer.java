package TestCasesScript_Using_Json;

import org.testng.Assert;
import org.testng.annotations.Test;

import APIPackage.DeleteCustomerAPI;
import APIPackage.RetriveCustomerAPI;
import SetUpPackage.TestSetup;
import TestCasesScript_Using_ConfigProperties.CreateCustomer_Config;
import io.restassured.response.Response;

public class DeleteCustomer extends TestSetup 
{
	
	@Test (priority=1)
	public void DeleteCustomerWithValidSecretKey()
	{
		testLevelLog.get().assignAuthor("Manju Reddy");
		testLevelLog.get().assignCategory("Smoke");
		
		Response response = DeleteCustomerAPI.DeleteRequestToWithValidSecretKey(config.getValidSecretKey(), 
							config.getCustomerAPIEndPoint()+"/"+CreateCustomer_Config.idValue1);
		
		response.prettyPrint();
		testLevelLog.get().info(response.body().asString());
	}

}
