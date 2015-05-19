package com.dt.hippo.core.base;

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
	}
}
