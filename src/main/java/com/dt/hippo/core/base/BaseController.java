package com.dt.hippo.core.base;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public abstract class BaseController extends BaseActor {
	
	@Autowired
	MessageSource messageSource;
	protected String getNotLoginError( Locale locale)
	{
		return messageSource.getMessage("not_login", null, locale);
	}
	protected String getNotLoginError()
	{
		return getNotLoginError(null);
	}
}
