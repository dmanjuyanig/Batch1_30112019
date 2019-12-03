package TestCasesScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import APIPackage.DeleteCustomerAPI;
import APIPackage.RetriveCustomerAPI;
import SetUpPackage.TestSetup;
import io.restassured.response.Response;

public class DeleteCustomer extends TestSetup 
{
	
	@Test (priority=1)
	public void DeleteCustomerWithValidSecretKey()
	{
		testLevelLog.get().assignAuthor("Manju Reddy");
		testLevelLog.get().assignCategory("Smoke");
		
		Response response = DeleteCustomerAPI.DeleteRequestToWithValidSecretKey(config.getValidSecretKey(), 
							config.getCustomerAPIEndPoint() , "cus_GHmjr9iuXG1tPH");
		
		response.prettyPrint();
		testLevelLog.get().info(response.body().asString());
	}

}
