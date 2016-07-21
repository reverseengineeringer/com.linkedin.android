package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.Util;

public final class Address
{
  public final CertificatePinner certificatePinner;
  public final List<ConnectionSpec> connectionSpecs;
  public final Dns dns;
  public final HostnameVerifier hostnameVerifier;
  public final List<Protocol> protocols;
  public final Proxy proxy;
  public final Authenticator proxyAuthenticator;
  public final ProxySelector proxySelector;
  public final SocketFactory socketFactory;
  public final SSLSocketFactory sslSocketFactory;
  public final HttpUrl url;
  
  public Address(String paramString, int paramInt, Dns paramDns, SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, CertificatePinner paramCertificatePinner, Authenticator paramAuthenticator, Proxy paramProxy, List<Protocol> paramList, List<ConnectionSpec> paramList1, ProxySelector paramProxySelector)
  {
    Object localObject2 = new HttpUrl.Builder();
    if (paramSSLSocketFactory != null) {}
    for (Object localObject1 = "https";; localObject1 = "http")
    {
      localObject1 = ((HttpUrl.Builder)localObject2).scheme((String)localObject1);
      if (paramString != null) {
        break;
      }
      throw new IllegalArgumentException("host == null");
    }
    localObject2 = HttpUrl.Builder.canonicalizeHost(paramString, 0, paramString.length());
    if (localObject2 == null) {
      throw new IllegalArgumentException("unexpected host: " + paramString);
    }
    host = ((String)localObject2);
    if ((paramInt <= 0) || (paramInt > 65535)) {
      throw new IllegalArgumentException("unexpected port: " + paramInt);
    }
    port = paramInt;
    url = ((HttpUrl.Builder)localObject1).build();
    if (paramDns == null) {
      throw new IllegalArgumentException("dns == null");
    }
    dns = paramDns;
    if (paramSocketFactory == null) {
      throw new IllegalArgumentException("socketFactory == null");
    }
    socketFactory = paramSocketFactory;
    if (paramAuthenticator == null) {
      throw new IllegalArgumentException("proxyAuthenticator == null");
    }
    proxyAuthenticator = paramAuthenticator;
    if (paramList == null) {
      throw new IllegalArgumentException("protocols == null");
    }
    protocols = Util.immutableList(paramList);
    if (paramList1 == null) {
      throw new IllegalArgumentException("connectionSpecs == null");
    }
    connectionSpecs = Util.immutableList(paramList1);
    if (paramProxySelector == null) {
      throw new IllegalArgumentException("proxySelector == null");
    }
    proxySelector = paramProxySelector;
    proxy = paramProxy;
    sslSocketFactory = paramSSLSocketFactory;
    hostnameVerifier = paramHostnameVerifier;
    certificatePinner = paramCertificatePinner;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Address))
    {
      paramObject = (Address)paramObject;
      bool1 = bool2;
      if (url.equals(url))
      {
        bool1 = bool2;
        if (dns.equals(dns))
        {
          bool1 = bool2;
          if (proxyAuthenticator.equals(proxyAuthenticator))
          {
            bool1 = bool2;
            if (protocols.equals(protocols))
            {
              bool1 = bool2;
              if (connectionSpecs.equals(connectionSpecs))
              {
                bool1 = bool2;
                if (proxySelector.equals(proxySelector))
                {
                  bool1 = bool2;
                  if (Util.equal(proxy, proxy))
                  {
                    bool1 = bool2;
                    if (Util.equal(sslSocketFactory, sslSocketFactory))
                    {
                      bool1 = bool2;
                      if (Util.equal(hostnameVerifier, hostnameVerifier))
                      {
                        bool1 = bool2;
                        if (Util.equal(certificatePinner, certificatePinner)) {
                          bool1 = true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    int m = 0;
    int n = url.hashCode();
    int i1 = dns.hashCode();
    int i2 = proxyAuthenticator.hashCode();
    int i3 = protocols.hashCode();
    int i4 = connectionSpecs.hashCode();
    int i5 = proxySelector.hashCode();
    int i;
    int j;
    if (proxy != null)
    {
      i = proxy.hashCode();
      if (sslSocketFactory == null) {
        break label185;
      }
      j = sslSocketFactory.hashCode();
      label91:
      if (hostnameVerifier == null) {
        break label190;
      }
    }
    label185:
    label190:
    for (int k = hostnameVerifier.hashCode();; k = 0)
    {
      if (certificatePinner != null) {
        m = certificatePinner.hashCode();
      }
      return (((((((((n + 527) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i) * 31 + j) * 31 + k) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label91;
    }
  }
}

/* Location:
 * Qualified Name:     okhttp3.Address
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */