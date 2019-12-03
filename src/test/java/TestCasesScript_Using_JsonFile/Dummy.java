package TestCasesScript_Using_JsonFile;

import org.testng.Assert;
import org.testng.annotations.Test;

import APIPackage_ConfigProperties.RetriveCustomerAPI_Config;

import static io.restassured.RestAssured.given;

import java.io.File;

import SetUpPackage.TestSetup;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Dummy extends TestSetup{
	
	public static String idValue2="";
	
	@Test (priority=1)
	public void PostCustomerDetails()
	{
		testLevelLog.get().assignAuthor("Manju Reddy");
		testLevelLog.get().assignCategory("Smoke");
		
		Response response = given().contentType(ContentType.URLENC).auth().basic("sk_test_4eC39HqLyjWDarjtT1zdp7dc", "")
				.body(new File("./src/test/java/TestCasesScript_Using_JsonFile/CreateUser.json"))
				.post("https://api.stripe.com/v1/customers");
		
		response.prettyPrint();
		
		idValue2 = response.jsonPath().get("id");
		System.out.println("idValue2 : " + idValue2);
		System.out.println("*********************************************");
		
	}
	
	/*@Test (priority=2)
	public void UpdateCustomerDetails()
	{
		testLevelLog.get().assignAuthor("Manju Reddy");
		testLevelLog.get().assignCategory("Smoke");
		
		Response response = given().auth().basic("sk_test_4eC39HqLyjWDarjtT1zdp7dc", "")
				.formParam("email", "ManjuReddykruthi@gmail.com")
				.formParam("description", "description added")
				.put("https://api.stripe.com/v1/customers/" + idValue2);
		
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		System.out.println("*********************************************");
	}*/
	
	@Test (priority=3)
	public void GetCustomerDetails()
	{
		testLevelLog.get().assignAuthor("Manju Reddy");
		testLevelLog.get().assignCategory("Smoke");
		
		Response response = given().auth().basic("sk_test_4eC39HqLyjWDarjtT1zdp7dc", "")
				.get("https://api.stripe.com/v1/customers/"+ idValue2);
		
		response.prettyPrint();
		System.out.println("*********************************************");
		
	}
	
	@Test (priority=4)
	public void DeleteCustomerDetails()
	{
		testLevelLog.get().assignAuthor("Manju Reddy");
		testLevelLog.get().assignCategory("Smoke");
		
		Response response = given().auth().basic("sk_test_4eC39HqLyjWDarjtT1zdp7dc", "")
				.delete("https://api.stripe.com/v1/customers/" + idValue2);
		
		response.prettyPrint();
		System.out.println("*********************************************");
		
	}

}
