package UtilityPackage;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources
({
	"file:src/test/resources/propertyfiles/config.properties"
})

public interface configProperties extends Config{
	
	//*****************URL************************
	@Key("baseURI")
	public String getBaseURI();
	
	@Key("basePath")
	String getBasePath();
	
	@Key("createcustomerAPIEndPoint")
	String getCustomerAPIEndPoint();
	
	@Key("getcustomerAPIEndPoint")
	String getGetCustomerAPIEndPoint();
	
	//*************SecretKey*********************
	@Key("validSecretKey")
	String getValidSecretKey();
	
	@Key("invalidSecretKey")
	String getInValidSecretKey();
	
	//*************JsonResponseHeaderValidation*********************
	@Key("successresponsecode")
	int getSuccessResponseCode();
	
	@Key("statusline")
	String getStatusLine();
	
	@Key("contentType")
	String getContentType();
	
	@Key("server")
	String getServer();
	
	@Key("transfer-encoding")
	String getTransferEncoding();
	
	@Key("responsetime")
	int getResponseTime();
	
	@Key("unauthorizedErrorresponsecode")
	int getUnauthorizedErrorResponseCode();
	
	@Key("badrequestresponsecode")
	int getBadRequestResponseCode();
	
	//*************JsonResponseFieldValidation*************************
	@Key("id/firstname/middlename/lastname/dob/email/address1/address2/city/zipcode/state/phone/website/compname/compaddress/compphone")
	String validateJsonString();
	
	//*************CreateUser_validateAPIWithValidSecretKey*****************
	@Key("CreateCustomerValidSecretKey_email")
	String getCreateCustomerValidSecretKey_email();
	
	@Key("CreateCustomerValidSecretKey_description")
	String getCreateCustomerValidSecretKey_description();
	
	//*************CreateUser_validateAPIWithValidSecretKey*****************
	@Key("CreateCustomerValidParameter_email")
	String getCreateCustomerValidParameter_email();
	
	@Key("CreateCustomerValidParameter_description")
	String getCreateCustomerValidParameter_description();
	
	//*************CreateUser_CreateCustomerWithInvalidParameter*****************
	@Key("CreateCustomerWithInvalidParameter_email")
	String getCreateCustomerWithInvalidParameter_email();
	
	@Key("CreateCustomerWithInvalidParameter_description")
	String getCreateCustomerWithInvalidParameter_description();
	
	//*************CreateUser_CreateCustomerWithInvalidSecretKey*****************
	@Key("CreateCustomerWithInvalidSecretKey_email")
	String getCreateCustomerWithInvalidSecretKey_email();
	
	@Key("CreateCustomerWithInvalidSecretKey_description")
	String getCreateCustomerWithInvalidSecretKey_description();
	
	//*************CreateUser_CreateCustomerWithNoSecretKey*****************
	@Key("CreateCustomerWithNoSecretKey_email")
	String getCreateCustomerWithNoSecretKey_email();
	
	@Key("CreateCustomerWithNoSecretKey_description")
	String getCreateCustomerWithNoSecretKey_description();
	
	//*************Report*************************
	@Key("testReportPath")
	String getTestReportFilepath();

	@Key("testReportName")
	String getTestReportName();
	
	@Key("testDataSheet")
	String getTestDataSheetName();
	
	//*************Negative Validation*************************
	@Key("invalidCustomerID")
	String getInvalidCustomerID();
	

	
	
	
	

}
