package okhttp3.internal.tls;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.security.auth.x500.X500Principal;

public final class RealTrustRootIndex
  implements TrustRootIndex
{
  private final Map<X500Principal, List<X509Certificate>> subjectToCaCerts = new LinkedHashMap();
  
  public RealTrustRootIndex(X509Certificate... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      X509Certificate localX509Certificate = paramVarArgs[i];
      X500Principal localX500Principal = localX509Certificate.getSubjectX500Principal();
      List localList = (List)subjectToCaCerts.get(localX500Principal);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList(1);
        subjectToCaCerts.put(localX500Principal, localObject);
      }
      ((List)localObject).add(localX509Certificate);
      i += 1;
    }
  }
  
  public final X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate)
  {
    Object localObject = paramX509Certificate.getIssuerX500Principal();
    localObject = (List)subjectToCaCerts.get(localObject);
    if (localObject == null) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      X509Certificate localX509Certificate = (X509Certificate)((Iterator)localObject).next();
      PublicKey localPublicKey = localX509Certificate.getPublicKey();
      try
      {
        paramX509Certificate.verify(localPublicKey);
        return localX509Certificate;
      }
      catch (Exception localException) {}
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     okhttp3.internal.tls.RealTrustRootIndex
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */