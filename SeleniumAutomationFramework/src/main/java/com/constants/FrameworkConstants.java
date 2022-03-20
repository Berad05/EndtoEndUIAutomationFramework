package com.constants;

import com.enums.ConfigProperties;
import com.utils.PropertyUtils;

public final class FrameworkConstants {

	private FrameworkConstants() {};
	
	private static final String EXTENTREPORTFOLDER=System.getProperty("user.dir")+"/extent-test-output/";
	private static String extentReportFile="";
	private static final String EXCELPATH=System.getProperty("user.dir")+"/src/test/resources/excel/test.xlsx";
	private static final String DATASHEET="DATA";
	private static final String ITERATIONSHEET="RUNMANAGER";
	public static String getExcelpath() {
		return EXCELPATH;
	}
	public static String getDatasheet() {
		return DATASHEET;
	}
	public static String getIterationsheet() {
		return ITERATIONSHEET;
	}
	
    public static String getExtentReportFile() throws Exception {
    	if(extentReportFile.isEmpty())
    	{
    		extentReportFile=createReportFilePath();
    	}
    	
		return extentReportFile;
	}
	private static String createReportFilePath() {
		// TODO Auto-generated method stub
		try {
			if(PropertyUtils.get(ConfigProperties.OVERRIDERESULT).equalsIgnoreCase("no"))
			{
				extentReportFile=EXTENTREPORTFOLDER+System.currentTimeMillis()+"/index.html";
			}
			else
			{
				extentReportFile=EXTENTREPORTFOLDER+"/index.html";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return extentReportFile;
	}
	
}
