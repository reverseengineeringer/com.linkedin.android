package okhttp3.internal.tls;

import java.security.cert.X509Certificate;

public abstract interface TrustRootIndex
{
  public abstract X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate);
}

/* Location:
 * Qualified Name:     okhttp3.internal.tls.TrustRootIndex
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */