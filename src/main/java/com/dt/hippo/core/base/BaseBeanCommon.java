package com.dt.hippo.core.base;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "createdate", "modifydate",
		"createuser", "modifyuser", "status", "platform" })
public abstract class BaseBeanCommon
{
	public Date getStartdate()
	{
		return null;
	}

	public void setStartdate(Date startdate)
	{
	}

	public Date getEnddate()
	{
		return null;
	}

	public void setEnddate(Date enddate)
	{
	}

	public void setCreatedate(Date createdate)
	{

	}

	public Date getCreatedate()
	{
		return null;
	}

	public void setModifydate(Date modifydate)
	{

	}

	public Date getModifydate()
	{
		return null;
	}

	public void setCreateuser(String createuser)
	{

	}

	public String getCreateuser()
	{
		return null;
	}

	public void setModifyuser(String modifyuser)
	{

	}

	public String getModifyuser()
	{
		return null;
	}

	public void setStatus(Integer status)
	{

	}

	public Integer getStatus()
	{
		return null;
	}

	public void setPlatform(String platform)
	{

	}

	public String getPlatform()
	{
		return null;
	}

}
