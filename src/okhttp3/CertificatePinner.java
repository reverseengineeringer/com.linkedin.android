package okhttp3;

import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.ByteString;

public final class CertificatePinner
{
  public static final CertificatePinner DEFAULT = new Builder().build();
  private final List<Pin> pins;
  private final TrustRootIndex trustRootIndex;
  
  private CertificatePinner(Builder paramBuilder)
  {
    pins = Util.immutableList(pins);
    trustRootIndex = trustRootIndex;
  }
  
  public static String pin(Certificate paramCertificate)
  {
    if (!(paramCertificate instanceof X509Certificate)) {
      throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }
    return "sha256/" + sha256((X509Certificate)paramCertificate).base64();
  }
  
  private static ByteString sha256(X509Certificate paramX509Certificate)
  {
    return Util.sha256(ByteString.of(paramX509Certificate.getPublicKey().getEncoded()));
  }
  
  public final void check(String paramString, List<Certificate> paramList)
    throws SSLPeerUnverifiedException
  {
    Object localObject3 = Collections.emptyList();
    Object localObject2 = pins.iterator();
    Object localObject1;
    label151:
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (Pin)((Iterator)localObject2).next();
      if (pattern.equals(paramString)) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label151;
        }
        localObject1 = localObject3;
        if (((List)localObject3).isEmpty()) {
          localObject1 = new ArrayList();
        }
        ((List)localObject1).add(localObject4);
        localObject3 = localObject1;
        break;
        i = paramString.indexOf('.');
        if ((pattern.startsWith("*.")) && (paramString.regionMatches(false, i + 1, pattern, 2, pattern.length() - 2))) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    if (((List)localObject3).isEmpty()) {
      return;
    }
    Object localObject4 = paramList;
    if (trustRootIndex != null) {
      localObject4 = new CertificateChainCleaner(trustRootIndex).clean(paramList);
    }
    int i = 0;
    int k = ((List)localObject4).size();
    for (;;)
    {
      if (i >= k) {
        break label384;
      }
      X509Certificate localX509Certificate = (X509Certificate)((List)localObject4).get(i);
      localObject1 = null;
      paramList = null;
      j = 0;
      int m = ((List)localObject3).size();
      if (j < m)
      {
        Pin localPin = (Pin)((List)localObject3).get(j);
        if (hashAlgorithm.equals("sha256/"))
        {
          localObject2 = paramList;
          if (paramList == null) {
            localObject2 = sha256(localX509Certificate);
          }
          if (hash.equals(localObject2)) {
            break;
          }
          paramList = (List<Certificate>)localObject2;
        }
        do
        {
          j += 1;
          break;
          if (!hashAlgorithm.equals("sha1/")) {
            break label369;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = Util.sha1(ByteString.of(localX509Certificate.getPublicKey().getEncoded()));
          }
          localObject1 = localObject2;
        } while (!hash.equals(localObject2));
        return;
        label369:
        throw new AssertionError();
      }
      i += 1;
    }
    label384:
    paramList = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
    i = 0;
    int j = ((List)localObject4).size();
    while (i < j)
    {
      localObject1 = (X509Certificate)((List)localObject4).get(i);
      paramList.append("\n    ").append(pin((Certificate)localObject1)).append(": ").append(((X509Certificate)localObject1).getSubjectDN().getName());
      i += 1;
    }
    paramList.append("\n  Pinned certificates for ").append(paramString).append(":");
    i = 0;
    j = ((List)localObject3).size();
    while (i < j)
    {
      paramString = (Pin)((List)localObject3).get(i);
      paramList.append("\n    ").append(paramString);
      i += 1;
    }
    throw new SSLPeerUnverifiedException(paramList.toString());
  }
  
  public static final class Builder
  {
    final List<CertificatePinner.Pin> pins = new ArrayList();
    TrustRootIndex trustRootIndex;
    
    public Builder() {}
    
    Builder(CertificatePinner paramCertificatePinner)
    {
      pins.addAll(pins);
      trustRootIndex = trustRootIndex;
    }
    
    public final CertificatePinner build()
    {
      return new CertificatePinner(this, (byte)0);
    }
  }
  
  static final class Pin
  {
    final ByteString hash;
    final String hashAlgorithm;
    final String pattern;
    
    public final boolean equals(Object paramObject)
    {
      return ((paramObject instanceof Pin)) && (pattern.equals(pattern)) && (hashAlgorithm.equals(hashAlgorithm)) && (hash.equals(hash));
    }
    
    public final int hashCode()
    {
      return ((pattern.hashCode() + 527) * 31 + hashAlgorithm.hashCode()) * 31 + hash.hashCode();
    }
    
    public final String toString()
    {
      return hashAlgorithm + hash.base64();
    }
  }
}

/* Location:
 * Qualified Name:     okhttp3.CertificatePinner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */