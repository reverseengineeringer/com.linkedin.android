package com.conviva.platforms.android;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

final class HTTPTask$1
  implements X509TrustManager
{
  HTTPTask$1(HTTPTask paramHTTPTask) {}
  
  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {}
  
  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    try
    {
      paramArrayOfX509Certificate[0].checkValidity();
      return;
    }
    catch (Exception paramArrayOfX509Certificate)
    {
      throw new CertificateException("Certificate not valid or trusted.");
    }
  }
  
  public final X509Certificate[] getAcceptedIssuers()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.conviva.platforms.android.HTTPTask.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */