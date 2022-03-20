package com.listeners;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.constants.FrameworkConstants;
import com.utils.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor{

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		// TODO Auto-generated method stub
		List<IMethodInstance> runtimelist=new ArrayList<>();
		
		List<Map<String,String>> runlist=ExcelUtils.gettestdatadetails(FrameworkConstants.getIterationsheet());
		
		for(int i=0;i<methods.size();i++)
		{
			for(int j=0;j<runlist.size();j++)
			{
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(runlist.get(j).get("TestCaseName")))
				{
					if(runlist.get(j).get("Execute").equalsIgnoreCase("yes"))
					{
						runtimelist.add(methods.get(i));
					}
					
				}
			}
		}
		
		return runtimelist;
	}

}
