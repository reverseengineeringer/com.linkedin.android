package okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class CertificateChainCleaner
{
  private final TrustRootIndex trustRootIndex;
  
  public CertificateChainCleaner(TrustRootIndex paramTrustRootIndex)
  {
    trustRootIndex = paramTrustRootIndex;
  }
  
  private static boolean verifySignature(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2)
  {
    if (!paramX509Certificate1.getIssuerDN().equals(paramX509Certificate2.getSubjectDN())) {
      return false;
    }
    try
    {
      paramX509Certificate1.verify(paramX509Certificate2.getPublicKey());
      return true;
    }
    catch (GeneralSecurityException paramX509Certificate1) {}
    return false;
  }
  
  public final List<Certificate> clean(List<Certificate> paramList)
    throws SSLPeerUnverifiedException
  {
    paramList = new ArrayDeque(paramList);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramList.removeFirst());
    int j = 0;
    int i = 0;
    if (i < 9)
    {
      X509Certificate localX509Certificate1 = (X509Certificate)localArrayList.get(localArrayList.size() - 1);
      Object localObject = trustRootIndex.findByIssuerAndSignature(localX509Certificate1);
      if (localObject != null)
      {
        if ((localArrayList.size() > 1) || (!localX509Certificate1.equals(localObject))) {
          localArrayList.add(localObject);
        }
        if (!verifySignature((X509Certificate)localObject, (X509Certificate)localObject)) {}
      }
      do
      {
        return localArrayList;
        j = 1;
        for (;;)
        {
          i += 1;
          break;
          localObject = paramList.iterator();
          X509Certificate localX509Certificate2;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localX509Certificate2 = (X509Certificate)((Iterator)localObject).next();
          } while (!verifySignature(localX509Certificate1, localX509Certificate2));
          ((Iterator)localObject).remove();
          localArrayList.add(localX509Certificate2);
        }
      } while (j != 0);
      throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + localX509Certificate1);
    }
    throw new SSLPeerUnverifiedException("Certificate chain too long: " + localArrayList);
  }
}

/* Location:
 * Qualified Name:     okhttp3.internal.tls.CertificateChainCleaner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */