package com.dt.hippo.business;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang.time.DateUtils;
import org.apache.http.NameValuePair;
import org.springframework.stereotype.Component;

@Component
public class Utils
{
	public Date getCurrentDate()
	{
		return DateUtils.truncate(getCurrentDateTime(),
				Calendar.DAY_OF_MONTH);
	}

	public Date getCurrentDateTime()
	{
		return new Date();
	}

	char[] baseChars = new char[] { 48, 49, 50, 51, 52, 53, 54,
			55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74,
			75, 76, 77, 78, 80, 81, 82, 83, 84, 85, 86, 87,// 79,
			88, 89, 90 };
	private Random random = new Random();

	public String makeNumberShort(long val)
	{
		int length = baseChars.length;
		StringBuilder sb = new StringBuilder();
		do
		{
			sb.append(baseChars[(int) (val % length)]);
			val /= length;
		} while (val > 0);

		return sb.toString();
	}

	public String createReadableOrderNo(long val)
	{
		long newVal = val * 1000 + random.nextInt(1000);
		char checkVal = baseChars[(int) (newVal % 23)];
		return new StringBuilder("A")
				.append(makeNumberShort(newVal))
				.append(checkVal).toString();

	}

	public String getGUIDCode()
	{
		return UUID.randomUUID().toString();

	}
	public String getUniqueFileName()
	{
		return getGUIDCode();
	}
	
    public int getCurrentTime()
    {
        Date dateTime = this.getCurrentDateTime();
        Calendar current = Calendar.getInstance();
        current.setTime(dateTime);
        int hour = current.get(Calendar.HOUR_OF_DAY);
        int minute = current.get(Calendar.MINUTE);
        int second = current.get(Calendar.SECOND);
        int secondID = hour * 10000 + minute * 100 + second;
        return secondID;
    }
    
    public Date getDateFromDateTime(Date dateTime)
    {
        return DateUtils.truncate(dateTime, Calendar.DAY_OF_MONTH);
    }
    
    
	public String getRequestValue(final List<NameValuePair> params,
			final String requestUrl) {
		return null;
//		SSLSocketFactory socketFactory = null;
//		try {
//			HostnameVerifier hostnameVerifier = org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
//			socketFactory = new SSLSocketFactory(
//					(new GopurposeTrustManager()).getSSLContext(),
//					(X509HostnameVerifier) hostnameVerifier);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		HttpParams httpParams = new BasicHttpParams();
//		HttpClientParams.setRedirecting(httpParams, true);
//
//		DefaultHttpClient httpclient = new DefaultHttpClient(httpParams);
//		final Map<String, String> data = new HashMap<String, String>();
//		httpclient.setRedirectStrategy(new DefaultRedirectStrategy() {
//			public boolean isRedirected(HttpRequest request,
//					HttpResponse response, HttpContext context) {
//				try {
//					HttpUriRequest url = this.getRedirect(request, response,
//							context);
//					String redirectResponse = GoPurposeUtils.this
//							.getRequestValue(params, url.getURI().toString());
//					data.put("redirectData", redirectResponse);
//				} catch (org.apache.http.ProtocolException e) {
//
//				}
//				return false;
//			}
//		});
//		Scheme sch = new Scheme("https", 443, socketFactory);
//		httpclient.getConnectionManager().getSchemeRegistry().register(sch);
//		HttpPost httppost = new HttpPost(requestUrl);
//		String resDataStr = null;
//		try {
//			httppost.setEntity(new UrlEncodedFormEntity(params,
//					GoPurposeConst.CONST_CHARSET));
//
//			HttpResponse response = httpclient.execute(httppost);
//			if (response.getStatusLine().getStatusCode() == 200) {
//				resDataStr = EntityUtils.toString(response.getEntity());
//			} else if (response.getStatusLine().getStatusCode() == 301) {
//				resDataStr = data.get("redirectData");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return resDataStr;
	}

}
