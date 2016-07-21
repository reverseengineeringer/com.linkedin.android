package okhttp3.internal.tls;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public final class AndroidTrustRootIndex
  implements TrustRootIndex
{
  private final Method findByIssuerAndSignatureMethod;
  private final X509TrustManager trustManager;
  
  private AndroidTrustRootIndex(X509TrustManager paramX509TrustManager, Method paramMethod)
  {
    findByIssuerAndSignatureMethod = paramMethod;
    trustManager = paramX509TrustManager;
  }
  
  public static TrustRootIndex get(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Method localMethod = paramX509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[] { X509Certificate.class });
      localMethod.setAccessible(true);
      paramX509TrustManager = new AndroidTrustRootIndex(paramX509TrustManager, localMethod);
      return paramX509TrustManager;
    }
    catch (NoSuchMethodException paramX509TrustManager) {}
    return null;
  }
  
  public final X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate)
  {
    Object localObject = null;
    try
    {
      TrustAnchor localTrustAnchor = (TrustAnchor)findByIssuerAndSignatureMethod.invoke(trustManager, new Object[] { paramX509Certificate });
      paramX509Certificate = (X509Certificate)localObject;
      if (localTrustAnchor != null) {
        paramX509Certificate = localTrustAnchor.getTrustedCert();
      }
      return paramX509Certificate;
    }
    catch (IllegalAccessException paramX509Certificate)
    {
      throw new AssertionError();
    }
    catch (InvocationTargetException paramX509Certificate) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     okhttp3.internal.tls.AndroidTrustRootIndex
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */