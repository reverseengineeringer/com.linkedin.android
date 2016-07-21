package okhttp3;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

public final class Handshake
{
  public final CipherSuite cipherSuite;
  final List<Certificate> localCertificates;
  public final List<Certificate> peerCertificates;
  final TlsVersion tlsVersion;
  
  Handshake(TlsVersion paramTlsVersion, CipherSuite paramCipherSuite, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    tlsVersion = paramTlsVersion;
    cipherSuite = paramCipherSuite;
    peerCertificates = paramList1;
    localCertificates = paramList2;
  }
  
  public static Handshake get(SSLSession paramSSLSession)
  {
    Object localObject = paramSSLSession.getCipherSuite();
    if (localObject == null) {
      throw new IllegalStateException("cipherSuite == null");
    }
    CipherSuite localCipherSuite = CipherSuite.forJavaName((String)localObject);
    localObject = paramSSLSession.getProtocol();
    if (localObject == null) {
      throw new IllegalStateException("tlsVersion == null");
    }
    TlsVersion localTlsVersion = TlsVersion.forJavaName((String)localObject);
    try
    {
      localObject = paramSSLSession.getPeerCertificates();
      if (localObject != null)
      {
        localObject = Util.immutableList((Object[])localObject);
        paramSSLSession = paramSSLSession.getLocalCertificates();
        if (paramSSLSession == null) {
          break label109;
        }
        paramSSLSession = Util.immutableList(paramSSLSession);
        return new Handshake(localTlsVersion, localCipherSuite, (List)localObject, paramSSLSession);
      }
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      for (;;)
      {
        List localList = null;
        continue;
        localList = Collections.emptyList();
        continue;
        label109:
        paramSSLSession = Collections.emptyList();
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Handshake)) {}
    do
    {
      return false;
      paramObject = (Handshake)paramObject;
    } while ((!Util.equal(cipherSuite, cipherSuite)) || (!cipherSuite.equals(cipherSuite)) || (!peerCertificates.equals(peerCertificates)) || (!localCertificates.equals(localCertificates)));
    return true;
  }
  
  public final int hashCode()
  {
    if (tlsVersion != null) {}
    for (int i = tlsVersion.hashCode();; i = 0) {
      return (((i + 527) * 31 + cipherSuite.hashCode()) * 31 + peerCertificates.hashCode()) * 31 + localCertificates.hashCode();
    }
  }
}

/* Location:
 * Qualified Name:     okhttp3.Handshake
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */