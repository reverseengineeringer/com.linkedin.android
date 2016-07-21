package org.acra.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.log.ACRALog;
import org.acra.sender.HttpSender.Method;
import org.acra.sender.HttpSender.Type;

public final class HttpRequest
{
  public int connectionTimeOut = 3000;
  public Map<String, String> headers;
  public String login;
  public String password;
  public int socketTimeOut = 3000;
  
  public static String getParamsAsFormString(Map<?, ?> paramMap)
    throws UnsupportedEncodingException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append('&');
      }
      Object localObject1 = paramMap.get(localObject2);
      if (localObject1 == null) {
        localObject1 = "";
      }
      for (;;)
      {
        localStringBuilder.append(URLEncoder.encode(localObject2.toString(), "UTF-8"));
        localStringBuilder.append('=');
        localStringBuilder.append(URLEncoder.encode(localObject1.toString(), "UTF-8"));
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public final void send(URL paramURL, HttpSender.Method paramMethod, String paramString, HttpSender.Type paramType)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    if ((localHttpURLConnection instanceof HttpsURLConnection)) {}
    for (;;)
    {
      try
      {
        HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)localHttpURLConnection;
        TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        localObject = ACRA.getConfig();
        if (mKeyStore == null) {
          continue;
        }
        localObject = mKeyStore;
        if (localObject != null) {
          localTrustManagerFactory.init((KeyStore)localObject);
        }
        localObject = SSLContext.getInstance("TLS");
        ((SSLContext)localObject).init(null, localTrustManagerFactory.getTrustManagers(), null);
        localHttpsURLConnection.setSSLSocketFactory(((SSLContext)localObject).getSocketFactory());
      }
      catch (GeneralSecurityException localGeneralSecurityException)
      {
        Object localObject;
        ACRA.log.e(ACRA.LOG_TAG, "Could not configure SSL for ACRA request to " + paramURL, localGeneralSecurityException);
        continue;
        localHttpURLConnection.setRequestMethod(paramMethod.name());
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.setChunkedStreamingMode(0);
        localHttpURLConnection.connect();
        paramMethod = new BufferedOutputStream(localHttpURLConnection.getOutputStream());
        paramMethod.write(paramString.getBytes("UTF-8"));
        paramMethod.flush();
        paramMethod.close();
        ACRA.log.d(ACRA.LOG_TAG, "Sending request to " + paramURL);
        i = localHttpURLConnection.getResponseCode();
        ACRA.log.d(ACRA.LOG_TAG, "Request response : " + i + " : " + localHttpURLConnection.getResponseMessage());
        if (i != 200) {
          break label442;
        }
      }
      if ((login != null) && (password != null)) {
        Authenticator.setDefault(new HttpRequest.1(this));
      }
      localHttpURLConnection.setConnectTimeout(connectionTimeOut);
      localHttpURLConnection.setReadTimeout(socketTimeOut);
      localHttpURLConnection.setRequestProperty("User-Agent", "Android");
      localHttpURLConnection.setRequestProperty("Accept", "text/html,application/xml,application/json,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
      localHttpURLConnection.setRequestProperty("Content-Type", paramType.getContentType());
      if (headers == null) {
        continue;
      }
      paramType = headers.keySet().iterator();
      if (!paramType.hasNext()) {
        continue;
      }
      localObject = (String)paramType.next();
      localHttpURLConnection.setRequestProperty((String)localObject, (String)headers.get(localObject));
      continue;
      localObject = null;
    }
    int i;
    ACRA.log.d(ACRA.LOG_TAG, "Request received by server");
    for (;;)
    {
      localHttpURLConnection.disconnect();
      return;
      label442:
      if (i == 403)
      {
        ACRA.log.d(ACRA.LOG_TAG, "Data validation error on server - request will be discarded");
      }
      else if (i == 409)
      {
        ACRA.log.d(ACRA.LOG_TAG, "Server has already received this post - request will be discarded");
      }
      else
      {
        if ((i >= 400) && (i < 600)) {
          throw new IOException("Host returned error code " + i);
        }
        ACRA.log.w(ACRA.LOG_TAG, "Could not send ACRA Post - request will be discarded");
      }
    }
  }
}

/* Location:
 * Qualified Name:     org.acra.util.HttpRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */