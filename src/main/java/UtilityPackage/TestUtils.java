package UtilityPackage;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

import SetUpPackage.TestSetup;

public class TestUtils extends TestSetup{
	
	public static boolean jsonHasKey(String json, String key)
	{
		JSONObject jsonobject = new JSONObject(json);
		boolean flag = jsonobject.has(key);
		return flag;
		
		//This is another way to validate the content in json
		//return json.contains(key);
	}

	public static void archiveTestReport() 
	{
		String reportName = config.getTestReportName();

		String lastTestReportFilePath = System.getProperty("user.dir")+"./AutomationReport.html";
		String archiveReportPath = System.getProperty("user.dir")+"/src/test/resources/archivedTestReport/";

		Date date = new Date();
		SimpleDateFormat dateFormate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String formatedDate = dateFormate.format(date);
		String archiveTestReportName = formatedDate + "_" + reportName;

		File oldReport = new File(lastTestReportFilePath + reportName);

		File newFile = new File(archiveReportPath + archiveTestReportName);
		
		System.out.println(oldReport.exists());
		
		if (oldReport.exists()) 
		{
			System.out.println("inside if");
			oldReport.renameTo(newFile);
			oldReport.delete();
		}
		
	}
	
}
	



