package com.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.constants.FrameworkConstants;

public final class DataProviderUtils {
	private DataProviderUtils() {};
	@DataProvider
	public static Object[] getData(Method m) throws IOException
	{
		String testCaseName=m.getName();
		
		List<Map<String,String>> datalist=ExcelUtils.gettestdatadetails(FrameworkConstants.getDatasheet());
		List<Map<String,String>> rundatalist=new ArrayList<>();
		for(int i=0;i<datalist.size();i++)
		{
			if(datalist.get(i).get("TestCaseName").equalsIgnoreCase(testCaseName))
			{
				if(datalist.get(i).get("Execute").equalsIgnoreCase("yes"))
				{
					rundatalist.add(datalist.get(i));
				}
			}
		}
		return rundatalist.toArray();
		
	}
	

}
