package com.dt.hippo.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dt.hippo.auto.data.repository.jpa.ExternalaccountJpaRepository;
import com.dt.hippo.auto.model.Externalaccount;
import com.dt.hippo.auto.model.jpa.ExternalaccountEntity;
import com.dt.hippo.business.base.BaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;

@Component
public class TaskManagerService extends BaseService
{

	// @Autowired
	// protected LoginService loginService;

	@Autowired
	protected MailService mailService;

	// @Autowired
	// protected SystemParameterService systemParameterService;

	@Resource
	protected ExternalaccountJpaRepository externalaccountJpaRepository;


	private void share(long userId, int usersource,
		 String language,
			String content)
	{
		
		ExternalaccountEntity externalaccount = externalaccountJpaRepository
				.findByUseridAndUsersource(userId,
						usersource);
		
		String token = externalaccount.getAccesstoken();
		String tokenSecret = externalaccount.getTokensecret();
		String shareUrl = null;
		int contentLen = 0;
		String apiKey = "";
		String secretKey = "";
		HttpClient httpclient = new DefaultHttpClient();

//		switch (usersource)
//		{
//		case GoPurposeConst.USERSOURCE_WEIBO:
//			url = GoPurposeConst.SINAWEIBO_PUBLISH_URL[0];
//			tokenKey = "access_token";
//			mediaKey = "pic";
//			contentKey = "status";
//			contentLen = 140;
//			break;
//		case GoPurposeConst.USERSOURCE_QQ:
//			tokenKey = "access_token";
//			url = GoPurposeConst.QQWEIBO_PUBLISH_URL[2];
//			apiKey = GoPurposeConst.API_KEY[1];
//			secretKey = GoPurposeConst.SECRET_KEY[1];
//			contentKey = "content";
//			mediaUrlKey = "url";
//			contentLen = 140;
//			break;
//		case GoPurposeConst.USERSOURCE_FACEBOOK:
//			apiKey = GoPurposeConst.API_KEY[2];
//			secretKey = GoPurposeConst.SECRET_KEY[2];
//			title = this.getMessageForTask(
//					GoPurposeConst.FACEBOOK_TWEET_TITLE,
//					language);
//			tokenKey = "access_token";
//			contentKey = "description";
//			titleKey = "name";
//			mediaUrlKey = "url";
//			if (fundvideotype == 0)
//			{
//				mediaKey = "source";
//				contentKey = "description";
//				titleKey = "name";
//				url = GoPurposeConst.FACEBOOK_UPLOAD_VIDEO_URL;
//			} else if (fundvideotype == 1)
//			{
//				contentKey = "message";
//				titleKey = "subject";
//				url = GoPurposeConst.FACEBOOK_UPLOAD_NOTE_URL;
//			} else
//			{
//				contentKey = "message";
//				titleKey = "subject";
//				url = GoPurposeConst.FACEBOOK_UPLOAD_NOTE_URL;
//			}
//			break;
//		case GoPurposeConst.USERSOURCE_TWITTER:
//			url = GoPurposeConst.TWITTER_PUBLISH_URL[0];
//			apiKey = GoPurposeConst.API_KEY[3];
//			secretKey = GoPurposeConst.SECRET_KEY[3];
//			tokenKey = "oauth_token";
//			contentKey = "status";
//			contentLen = 140;
//			break;
//		}
//
//		// if (usersource != GoPurposeConst.USERSOURCE_FACEBOOK) {
//		// content = content + " " + shareUrl;
//		// } else {
//		// if (shareCat == 2 || (shareCat == 1 && fundvideotype == 1)) {
//		// content = content + " " + shareUrl;
//		// }
//		// }
//		content = content + " " + shareUrl;
//
//		SSLConnectionSocketFactory socketFactory = null;
//		try
//		{
//			socketFactory = new SSLConnectionSocketFactory(
//					(new GopurposeTrustManager())
//							.getSSLContext());
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//		Scheme sch = new Scheme("https", 443, socketFactory);
//		httpclient.getConnectionManager().getSchemeRegistry()
//				.register(sch);
//		HttpPost httppost = new HttpPost(url);
//
//		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//		if (usersource == GoPurposeConst.USERSOURCE_FACEBOOK
//				&& fundvideotype == 0 && shareCat == 1)
//		{
//			String strFile = projectService
//					.getMediaPath(projectinfo
//							.getFundraiservideoid());
//			File uploadFile = new File(strFile);
//			MultipartEntity reqEntity = new MultipartEntity();
//			try
//			{
//				reqEntity.addPart(tokenKey,
//						new StringBody(token));
//				reqEntity
//						.addPart(
//								contentKey,
//								new StringBody(
//										content,
//										Charset.forName(GoPurposeConst.CONST_CHARSET)));
//				reqEntity
//						.addPart(
//								titleKey,
//								new StringBody(
//										title,
//										Charset.forName(GoPurposeConst.CONST_CHARSET)));
//			} catch (UnsupportedEncodingException e)
//			{
//				e.printStackTrace();
//			}
//			FileBody bin = null;
//			bin = new FileBody(uploadFile, uploadFile.getName(),
//					"video/mpeg", GoPurposeConst.CONST_CHARSET);
//			reqEntity.addPart(mediaKey, bin);
//			httppost.setEntity(reqEntity);
//		} else
//		{
//			if (contentLen > 0 && content.length() > contentLen)
//			{
//				// content = content.substring(0, contentLen);
//			}
//			if (usersource != GoPurposeConst.USERSOURCE_TWITTER)
//			{
//				nvps.add(new BasicNameValuePair(tokenKey, token));
//				nvps.add(new BasicNameValuePair(contentKey,
//						content));
//			}
//			if (StringUtils.isNotEmpty(mediaUrlKey)
//					&& StringUtils.isNotEmpty(shareUrl))
//			{
//				nvps.add(new BasicNameValuePair(mediaUrlKey,
//						shareUrl));
//			}
//			if (usersource == GoPurposeConst.USERSOURCE_QQ)
//			{
//				nvps.add(new BasicNameValuePair(
//						"oauth_consumer_key", apiKey));
//				nvps.add(new BasicNameValuePair("openid",
//						externalaccount.getExternaluserid()));
//				nvps.add(new BasicNameValuePair("oauth_version",
//						"2.a"));
//			}
//			if (usersource == GoPurposeConst.USERSOURCE_FACEBOOK)
//			{
//				nvps.add(new BasicNameValuePair(titleKey, title));
//			}
//			if (usersource == GoPurposeConst.USERSOURCE_TWITTER)
//			{
//				OAuthParameters requestParameters = goPurposeUtils
//						.completeOAuthParameters(
//								GoPurposeConst.API_KEY[3],
//								token, null, false);
//				// nvps.add(new BasicNameValuePair("appkey", apiKey));
//				// nvps.add(new BasicNameValuePair("secret", secretKey));
//				// nvps.add(new BasicNameValuePair("oauth_token_secret",
//				// tokenSecret));
//				// requestParameters.put(contentKey, content);
//				try
//				{
//					url = url
//							+ "?"
//							+ contentKey
//							+ "="
//							+ URLEncoder
//									.encode(content, "UTF-8");
//				} catch (UnsupportedEncodingException e)
//				{
//					e.printStackTrace();
//				}
//				String signature = goPurposeUtils.sign("POST",
//						secretKey, tokenSecret, url,
//						requestParameters);
//				requestParameters.put(
//						GoPurposeConst.OAUTH_SIGNATURE,
//						signature);
//				Set<String> keySet = requestParameters.keySet();
//				for (Iterator<String> i = keySet.iterator(); i
//						.hasNext();)
//				{
//					String key = (String) i.next();
//					nvps.add(new BasicNameValuePair(key,
//							requestParameters.getFirst(key)));
//				}
//			}
//			try
//			{
//				httppost.setEntity(new UrlEncodedFormEntity(
//						nvps, HTTP.UTF_8));
//			} catch (UnsupportedEncodingException e)
//			{
//				e.printStackTrace();
//			}
//		}
//
//		try
//		{
//			HttpResponse response = httpclient.execute(httppost);
//			int statusCode = response.getStatusLine()
//					.getStatusCode();
//			// share failure
//			if (statusCode != HttpURLConnection.HTTP_OK)
//			{
//				// push notification
//				// this.pushNotification(null, userUID,
//				// GoPurposeConst.PUSH_TYPE[5], targetType,
//				// externalaccount.getName(), GoPurposeConst.SHARE_FAILURE);
//			} else
//			{
//				// push notification
//				// this.pushNotification(null, userUID,
//				// GoPurposeConst.PUSH_TYPE[5],
//				// targetType, externalaccount.getName(),
//				// GoPurposeConst.SHARE_SUCCESS);
//				if (shareCat == 1)
//				{
//					double point = pointruleMapper
//							.selectByPrimaryKey((byte) 1)
//							.getPoint();
//					projectService.statisticPoint(
//							externalaccount.getUserid(), point);
//					projectService.countShareCnt(
//							projectinfo.getId(), usersource);
//				}
//			}
//
//			HttpEntity resEntity = response.getEntity();
//
//			EntityUtils.consume(resEntity);
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//			// push notification
//			// this.pushNotification(null, userUID, GoPurposeConst.PUSH_TYPE[5],
//			// targetType, externalaccount.getName(),
//			// GoPurposeConst.SHARE_FAILURE);
//			// Sharefailrecord sharefailrecord = entityFactory
//			// .createSharefailrecord();
//			// sharefailrecord.setUseruid(userUID);
//			// sharefailrecord.setUsersource(usersource);
//			// sharefailrecord.setIssueid(issueinfo.getId());
//			// sharefailrecord.setLanguage(language);
//			// sharefailrecord.setErrormessage(e.getMessage());
//			// recordShareFailureInfo(sharefailrecord);
//			// // List<Byte> sourceList = new ArrayList<Byte>();
//			// // sourceList.add(usersource);
//			// // this.registerShare(userUID, issueinfo, sourceList, language);
//			// if (issuecategory == 1 && uploadFile.exists()) {
//			// uploadFile.delete();
//			// }
//		} finally
//		{
//			try
//			{
//				httpclient.getConnectionManager().shutdown();
//				// if (issuecategory == 1 && uploadFile.exists()) {
//				// uploadFile.delete();
//				// }
//			} catch (Exception ignore)
//			{
//			}
//		}
	}




//	public void sendMail(Map<String, Object> param)
//	{
//		String email = (String) param.get("email");
//		String username = (String) param.get("username");
//		String url = (String) param.get("url");
//		String projectname = (String) param.get("projectname");
//		String story = (String) param.get("story");
//		String orderdate = (String) param.get("orderdate");
//		String legalname = (String) param.get("legalname");
//		String amount = (String) param.get("amount");
//		String rewardname = (String) param.get("rewardname");
//		String address = (String) param.get("address");
//		String subjectCode = (String) param.get("subjectCode");
//		String language = (String) param.get("language");
//		String subject = this.getMessageForTask(subjectCode,
//				language);
//		String templateFileCode = (String) param
//				.get("templateFileCode");
//		String templateFile = this.getMessageForTask(
//				templateFileCode, language);
//		mailService.sendMail(email, username, url, projectname,
//				story, orderdate, legalname, amount, rewardname,
//				address, subject, templateFile);
//	}

	public String executeCmd(String strCmd) throws Exception
	{
		Process p;
		try
		{
			p = Runtime.getRuntime().exec(strCmd);
		} catch (IOException e1)
		{
			e1.printStackTrace();
			return null;
		}
		StringBuilder sbCmd = new StringBuilder();
		final Thread thread = Thread.currentThread();
		final boolean[] done = new boolean[] { false };
		new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				int count = 0;
				while (!done[0] && count++ < 600000)
				{
					try
					{
						Thread.sleep(100);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				if (!done[0])
				{
					thread.interrupt();
				}

			}
		}).start();
		try
		{
			p.waitFor();
			done[0] = true;
			BufferedReader br = new BufferedReader(
					new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = br.readLine()) != null)
			{
				sbCmd.append(line + "\n");
			}
			// System.out.println(sbCmd);
			return sbCmd.toString();
		} catch (Exception e)
		{
			return null;
		}
	}

	public void refreshToken()
	{
//		ExternalaccountExample example = new ExternalaccountExample();
//		example.createCriteria().andUsersourceEqualTo((byte) 4);
//		example.or().andUsersourceEqualTo((byte) 5);
//		List<Externalaccount> externalaccountList = externalaccountMapper
//				.selectByExample(example);
//		if (externalaccountList == null
//				|| externalaccountList.size() == 0)
//		{
//			return;
//		}
//		for (Externalaccount externalaccount : externalaccountList)
//		{
//			if (GoPurposeUtils.isNumEmpty(externalaccount
//					.getExpiretime()))
//			{
//				continue;
//			}
//			if (needRefresh(externalaccount.getModifydate(),
//					externalaccount.getExpiretime()))
//			{
//				JsonNode node = getNewAccesstoken(
//						externalaccount.getUsersource(),
//						externalaccount.getRefreshtoken());
//				if (node != null
//						&& node != NullNode.getInstance())
//				{
//					externalaccount.setAccesstoken(node.get(
//							"access_token").asText());
//					externalaccount.setRefreshtoken(node.get(
//							"refresh_token").asText());
//					externalaccount.setExpiretime(node.get(
//							"expires_in").asLong());
////					loginService TODO
////							.updateAccesstoken(externalaccount);
//				}
//			}
//		}
	}

	private boolean needRefresh(Date updateTime, long expireTime)
	{
		Calendar expireDate = Calendar.getInstance();
		expireDate.setTime(updateTime);
		expireDate.add(Calendar.SECOND, (int) expireTime);
		Calendar compareDate = Calendar.getInstance();
		compareDate.add(Calendar.HOUR, -5);
		if (expireDate.before(compareDate))
		{
			return true;
		}
		return false;
	}

	private JsonNode getNewAccesstoken(byte usersource,
			String refreshtoken)
	{
//		String requstTokenUrl = null;
//		String apikey = null;
//		String secret = null;
//		List<NameValuePair> params = new ArrayList<NameValuePair>();
//		params.add(new BasicNameValuePair("grant_type",
//				"refresh_token"));
//		params.add(new BasicNameValuePair("client_id", apikey));
//		params.add(new BasicNameValuePair("client_secret",
//				secret));
//		params.add(new BasicNameValuePair("refresh_token",
//				refreshtoken));
//		String response = goPurposeUtils.getRequestValue(params,
//				requstTokenUrl);
//		if (response != null)
//		{
//			ObjectMapper objectMapper = new ObjectMapper();
//			try
//			{
//				return objectMapper.readTree(response);
//			} catch (JsonProcessingException e)
//			{
//				e.printStackTrace();
//			} catch (IOException e)
//			{
//				e.printStackTrace();
//			}
//		}
		return null;
	}

	public void pushNewUpdate(Map<String, Object> paramMap)
	{
//		long projectId = (Long) paramMap.get("projectId");
//		byte authority = (Byte) paramMap.get("authority");
//		List<MyAccount> accountList = new ArrayList<MyAccount>();
//		// 1：only for funder 2：for all
//		if ((byte) 1 == authority)
//		{
//			accountList = myAccountMapper
//					.getProjectFundUser(projectId);
//		} else if ((byte) 2 == authority)
//		{
//			accountList = myAccountMapper
//					.getProjectFollowUser(projectId);
//		}
//		if (accountList != null && accountList.size() > 0)
//		{
//			String projectName = projectinfoMapper
//					.selectByPrimaryKey(projectId)
//					.getFundraisertitle();
//			HashMap<String, Object> param = new HashMap<String, Object>();
//			param.put("projectName", projectName);
//			for (MyAccount account : accountList)
//			{
//				param.put("toUserid", account.getId());
//				// 0:DEFAULT, 1:update, 2:message, 3:comment, 4:back
//				param.put("pushType",
//						GoPurposeConst.PUSH_TYPE[1]);
//				pushNotification(param);
//			}
//		}
	}

	public void pushNotification(Map<String, Object> param)
	{
//		String userName = (String) param.get("userName");
//		String projectName = (String) param.get("projectName");
//		long toUserid = (Long) param.get("toUserid");
//		int pushType = (Integer) param.get("pushType");
//		// apple push notification
//		List<Pushinfo> pushinfoList = loginService
//				.getPushToken(toUserid);
//		if (pushinfoList == null || pushinfoList.size() == 0)
//		{
//			return;
//		}
//		String alert = null;
//		// Connect to APNs
//		boolean production = false; // 设置true为正式服务地址，false为开发者地址
//		PushNotificationManager pushManager = new PushNotificationManager();
//		PushedNotifications notifications = new PushedNotifications();
//		try
//		{
//			AppleNotificationServer server = new AppleNotificationServerBasicImpl(
//					configuration.getCertificatePath(),
//					configuration.getCertificatePwd(),
//					production);
//			pushManager.initializeConnection(server);
//
//			for (Pushinfo pushinfo : pushinfoList)
//			{
//				try
//				{
//					pushinfo.setUserid(toUserid);
//					// update badgeCnt
//					loginService.updatePushInfo(pushinfo);
//					// push notification
//					List<Device> client = Devices
//							.asDevices(pushinfo.getDevicetoken());
//					notifications.setMaxRetained(client.size());
//					if ((pushType == GoPurposeConst.PUSH_TYPE[1] && (byte) 0 == pushinfo
//							.getUpdateflg())
//							|| (pushType == GoPurposeConst.PUSH_TYPE[2] && (byte) 0 == pushinfo
//									.getMessageflg())
//							|| (pushType == GoPurposeConst.PUSH_TYPE[3] && (byte) 0 == pushinfo
//									.getCommentflg())
//							|| (pushType == GoPurposeConst.PUSH_TYPE[4] && (byte) 0 == pushinfo
//									.getBackflg()))
//					{
//						int badgeCnt = pushinfo.getBadgecount() + 1;
//						// PUSH CONTENT
//						switch (pushType)
//						{
//						// 0:DEFAULT, 1:update, 2:message, 3:comment, 4:back
//						case 0:
//							alert = "";
//							break;
//						case 1:
//							alert = this.getMessageFromJms(
//									GoPurposeConst.PUSHUPDATE,
//									pushinfo.getLanguage(),
//									projectName);
//							break;
//						case 2:
//							alert = this.getMessageFromJms(
//									GoPurposeConst.PUSHMESSAGE,
//									pushinfo.getLanguage(),
//									userName);
//							break;
//						case 3:
//							alert = this.getMessageFromJms(
//									GoPurposeConst.PUSHCOMMENT,
//									pushinfo.getLanguage(),
//									userName, projectName);
//							break;
//						case 4:
//							alert = this.getMessageFromJms(
//									GoPurposeConst.PUSHBACK,
//									pushinfo.getLanguage(),
//									userName, projectName);
//							break;
//						}
//
//						PushNotificationPayload payload = PushNotificationPayload
//								.complex();
//						payload.addAlert(alert);// Content
//						payload.addBadge(badgeCnt);// Count
//						payload.addSound("default");// Voice
//						payload.addCustomDictionary("type",
//								Integer.toString(pushType));
//						BasicDevice.validateTokenFormat(client
//								.get(0).getToken());
//						PushedNotification notification = pushManager
//								.sendNotification(client.get(0),
//										payload, production);
//						notifications.add(notification);
//					}
//				} catch (Exception e)
//				{
//					e.printStackTrace();
//				}
//			}
//			pushManager.stopConnection();
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		}
	}
}
