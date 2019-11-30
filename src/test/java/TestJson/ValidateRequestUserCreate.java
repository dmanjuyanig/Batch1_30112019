package TestJson;



import org.testng.annotations.Test;

import APIPackage.RequestResponseCreateUserAPI;
import UtilityPackage.DataProviderClass;

public class ValidateRequestUserCreate {
	
	@Test(dataProviderClass = DataProviderClass.class, dataProvider="dp")
	public void validateCreateUserWithValidData()
	{
		//RequestResponseCreateUserAPI.sendPostRequestWithValidData(name, job)
	}

}
