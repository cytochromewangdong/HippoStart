package com.dt.hippo.business.msg;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

@Configurable
public class Message
{

	private String key;

	@Resource
	private MessageSource messageSource;

	public Message(String key)
	{
		this.key = key;
	}

	public String value()
	{
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(key, new Object[0],
				locale);
	}

	@Override
	public String toString()
	{
		return value();
	}
}