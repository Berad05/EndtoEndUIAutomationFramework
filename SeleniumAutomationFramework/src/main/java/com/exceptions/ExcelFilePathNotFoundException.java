package com.exceptions;

@SuppressWarnings("serial")
public class ExcelFilePathNotFoundException extends FrameworkException{

	public ExcelFilePathNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	public ExcelFilePathNotFoundException(String message,Throwable cause)
	{
		super(message,cause);
	}
}
