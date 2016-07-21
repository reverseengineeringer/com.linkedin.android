package com.conviva.platforms.android;

import com.conviva.api.system.ICallbackInterface;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EncodingUtils;

public final class HTTPTask
  implements Runnable
{
  ICallbackInterface _callback = null;
  private HttpClient _client = null;
  String _contentT;
  String _data;
  String _httpMethod;
  private HttpUriRequest _method = null;
  private ResponseHandler<Void> _responseHandler;
  int _timeoutMs;
  String _url;
  
  private void doneHandler(Exception paramException, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = null;
      if (_callback != null)
      {
        if (paramException != null) {
          break label44;
        }
        _callback.done(true, paramArrayOfByte);
      }
    }
    for (;;)
    {
      _callback = null;
      return;
      paramArrayOfByte = EncodingUtils.getString(paramArrayOfByte, "UTF-8");
      break;
      label44:
      _callback.done(false, paramException.toString());
    }
  }
  
  public final void run()
  {
    Object localObject1 = new BasicHttpParams();
    HttpProtocolParams.setVersion((HttpParams)localObject1, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset((HttpParams)localObject1, "UTF-8");
    HttpProtocolParams.setUseExpectContinue((HttpParams)localObject1, false);
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject1, _timeoutMs);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient((HttpParams)localObject1);
    try
    {
      if (!_url.contains("https://")) {
        break label262;
      }
      localObject1 = new X509TrustManager()
      {
        public final void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
          throws CertificateException
        {}
        
        public final void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
          throws CertificateException
        {
          try
          {
            paramAnonymousArrayOfX509Certificate[0].checkValidity();
            return;
          }
          catch (Exception paramAnonymousArrayOfX509Certificate)
          {
            throw new CertificateException("Certificate not valid or trusted.");
          }
        }
        
        public final X509Certificate[] getAcceptedIssuers()
        {
          return null;
        }
      };
      Object localObject3 = SSLContext.getInstance("TLS");
      ((SSLContext)localObject3).init(null, new TrustManager[] { localObject1 }, null);
      localObject1 = new ConvivaSSLSocketFactory((SSLContext)localObject3);
      ((SSLSocketFactory)localObject1).setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
      localObject3 = localDefaultHttpClient.getConnectionManager();
      ((ClientConnectionManager)localObject3).getSchemeRegistry().register(new Scheme("https", (SocketFactory)localObject1, 443));
      _client = new DefaultHttpClient((ClientConnectionManager)localObject3, localDefaultHttpClient.getParams());
      if (!_httpMethod.equalsIgnoreCase("post")) {
        break label289;
      }
      localObject1 = new HttpPost(_url);
      ((HttpPost)localObject1).setEntity(new ByteArrayEntity(_data.getBytes("UTF-8")));
      _method = ((HttpUriRequest)localObject1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label197:
        doneHandler(localException, null);
        return;
        if (!_httpMethod.equalsIgnoreCase("get")) {
          break;
        }
        _method = new HttpGet(_url);
      }
    }
    finally
    {
      localDefaultHttpClient.getConnectionManager().shutdown();
    }
    if (_contentT == null) {}
    label262:
    label289:
    String str;
    for (localObject1 = "application/json";; str = _contentT)
    {
      _method.setHeader("Content-Type", (String)localObject1);
      _responseHandler = new HttpResponseHandler((byte)0);
      _client.execute(_method, _responseHandler);
      localDefaultHttpClient.getConnectionManager().shutdown();
      return;
      _client = localDefaultHttpClient;
      break;
      doneHandler(new Exception("Unknown method: " + _httpMethod), null);
      break label197;
    }
  }
  
  private final class HttpResponseHandler
    implements ResponseHandler<Void>
  {
    private HttpResponseHandler() {}
    
    private Void handleResponse(HttpResponse paramHttpResponse)
    {
      int i;
      try
      {
        i = paramHttpResponse.getStatusLine().getStatusCode();
        if (i != 200) {
          break label95;
        }
        paramHttpResponse = paramHttpResponse.getEntity().getContent();
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrayOfByte = new byte['Ѐ'];
        for (;;)
        {
          i = paramHttpResponse.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
        HTTPTask.this.doneHandler(null, localByteArrayOutputStream.toByteArray());
      }
      catch (Exception paramHttpResponse)
      {
        HTTPTask.this.doneHandler(paramHttpResponse, null);
        return null;
      }
      return null;
      label95:
      HTTPTask.this.doneHandler(new Exception("Status code in HTTP response is not OK: " + i), null);
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     com.conviva.platforms.android.HTTPTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */