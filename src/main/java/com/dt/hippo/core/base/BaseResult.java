package com.dt.hippo.core.base;

import java.util.List;

import org.springframework.validation.ObjectError;

public class BaseResult
{
	protected String errorCode;

	public String getErrorCode()
	{
		return errorCode;
	}

	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}

	public int getResult()
	{
		return result;
	}

	public void setResult(int result)
	{
		this.result = result;
	}

	protected int result;
	protected String error;

	protected List<ObjectError> allError;

	public List<ObjectError> getAllError()
	{
		return allError;
	}

	public void setAllError(List<ObjectError> allError)
	{
		this.allError = allError;
	}

	protected String forwardURL;

	public String getForwardURL()
	{
		return forwardURL;
	}

	public void setForwardURL(String forwardURL)
	{
		this.forwardURL = forwardURL;
	}

	public BaseResult()
	{

	}

	public BaseResult(int result, String error)
	{
		this(result, error, null);
	}

	public BaseResult(int result, String error, String forwardUR)
	{
		super();
		this.result = result;
		this.error = error;
		this.forwardURL = forwardUR;
	}

	public String getError()
	{
		return error;
	}

	public void setError(String error)
	{
		this.error = error;
		this.result = -1;
	}
}
