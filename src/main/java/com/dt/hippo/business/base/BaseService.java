package com.dt.hippo.business.base;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.dt.hippo.business.Utils;
import com.dt.hippo.core.base.BaseBeanCommon;
import com.dt.hippo.core.security.SecurityUser;

public abstract class BaseService extends
		com.dt.hippo.core.base.BaseService
{
	protected SecurityUser getCurrentLoginUser()
	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		return auth != null ? (SecurityUser) auth.getPrincipal()
				: null;
	}

	protected void prepare(BaseBeanCommon bean)
	{
		SecurityUser loginUser = this.getCurrentLoginUser();
		String userId = loginUser != null ? loginUser
				.getUsername() : null;
		Date date = this.utils.getCurrentDateTime();
		if (bean.getCreatedate() == null)
		{
			bean.setCreatedate(date);
			bean.setCreateuser(userId);
		}
		bean.setModifydate(date);
		bean.setModifyuser(userId);
		if (bean.getStatus() == null)
		{
			bean.setStatus(0);
		}
	}

	@Resource
	protected Utils utils;
}
