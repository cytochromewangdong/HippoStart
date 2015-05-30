package com.dt.hippo.business.exception;

public class HippoResultException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5687386851328459579L;

	public HippoResultException(String errorMsg, int errorCode)
	{
		super(errorMsg);
		this.errorCode = errorCode;
	}
	public static void RaiseException(String errorMsg)
	{
		throw new HippoResultException(errorMsg);
	}
	public static void RaiseException(int errorCode)
	{
		throw new HippoResultException(errorCode);
	}
	public static void RaiseException(String errorMsg, int errorCode)
	{
		throw new HippoResultException(errorMsg, errorCode);
	}
	public HippoResultException(String errorMsg)
	{
		this(errorMsg, -1);
	}

	public HippoResultException(int errorCode)
	{
		this("unpredicted error", errorCode);
	}

	private int errorCode;

	public int getErrorCode()
	{
		return errorCode;
	}
}
