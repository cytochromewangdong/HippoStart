package com.dt.hippo.web.controller.api;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dt.hippo.business.base.BaseController;
import com.dt.hippo.business.common.ConfigurationHelper;
import com.dt.hippo.business.model.com.FileCom;

@Controller
public class UtilController extends BaseController
{

	@Resource
	private ConfigurationHelper configure;

	// @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	// public @ResponseBody FileCom uploadFileHandler()
	// {
	// return new FileCom();
	// }
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody FileCom uploadFileHandler(
			@RequestParam(value = "action", required = false) String action,
			@RequestParam(value = "file", required = false) MultipartFile file)
	{

		FileCom com = new FileCom();
		com.setResult(-1);
		if (!file.isEmpty())
		{
			String filename = this.utils.getUniqueFileName();
			File targetFile = new File(configure.getFileDir(),
					filename);
			try
			{
				file.transferTo(targetFile);
				com.setFileUniqueName(filename);
				com.setResult(0);
			} catch (IllegalStateException e)
			{
				logger.error(action + ", File upload error:", e);
			} catch (IOException e)
			{
				logger.error(action + ", File upload error:", e);
			}
			// ;
		}
		return com;
	}
}
