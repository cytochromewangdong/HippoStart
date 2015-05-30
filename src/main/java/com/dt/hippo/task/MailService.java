package com.dt.hippo.task;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.dt.hippo.core.base.BaseActor;

public class MailService extends BaseActor
{

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private VelocityEngine velocityEngine;

	private String fromEmail;

	public String getFromEmail()
	{
		return fromEmail;
	}

	public void setFromEmail(String fromEmail)
	{
		this.fromEmail = fromEmail;
	}

	public void sendMail(String email, String username,
			String url, String projectname, String story,
			String orderdate, String legalname, String amount,
			String rewardname, String address, String subject,
			String templateFile)
	{
		MimeMessage message = mailSender.createMimeMessage();
		// use the true flag to indicate you need a multipart message
		try
		{
			MimeMessageHelper helper = new MimeMessageHelper(
					message, true, "UTF-8");
			helper.setSubject(subject);
			helper.setTo(email);
			helper.setFrom(new InternetAddress(fromEmail,
					"HippoOrder", "UTF-8"));
			// use the true flag to indicate the text included is HTML
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("username", username);
			model.put("url", url);
			model.put("projectname", projectname);
			model.put("story", story);
			model.put("orderdate", orderdate);
			model.put("legalname", legalname);
			model.put("amount", amount);
			model.put("rewardname", rewardname);
			model.put("address", address);
			String text = VelocityEngineUtils
					.mergeTemplateIntoString(velocityEngine,
							templateFile, "UTF-8", model);
			helper.setText(text, true);
			// TODO, we need flag the mail has been sent.
		} catch (Exception e)
		{
			logger.error("failed to send mail", e);
		}
		mailSender.send(message);
	}

}
