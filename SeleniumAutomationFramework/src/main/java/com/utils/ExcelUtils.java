package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.constants.FrameworkConstants;
import com.exceptions.ExcelFilePathNotFoundException;

public final class ExcelUtils {
 
	private ExcelUtils() {};
	public static List<Map<String, String>> gettestdatadetails(String sheetName)
	{
		Map<String,String> map = null;
		
		XSSFWorkbook workbook = null;
		List<Map<String,String>> testList=new ArrayList<>();
		try (FileInputStream fis=new FileInputStream(FrameworkConstants.getExcelpath())){
		
			workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet(sheetName);
		
			int rowNum=sheet.getLastRowNum();
			int columnNum=sheet.getRow(0).getLastCellNum();
			for(int i=1;i<=rowNum;i++)
			{
			    map=new HashMap<>();
				for(int j=0;j<columnNum;j++)
				{
					String key=sheet.getRow(0).getCell(j).getStringCellValue();
					String value=sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				testList.add(map);
			}
		 
		
		} catch (IOException e) {
		
		   throw new ExcelFilePathNotFoundException("Excel File Path not found");
		}
	
		
		 return testList;
	
	}
}
