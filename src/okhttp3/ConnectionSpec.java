package okhttp3;

import java.util.Arrays;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;

public final class ConnectionSpec
{
  private static final CipherSuite[] APPROVED_CIPHER_SUITES = { CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA };
  public static final ConnectionSpec CLEARTEXT = new Builder(false).build();
  public static final ConnectionSpec COMPATIBLE_TLS;
  public static final ConnectionSpec MODERN_TLS;
  final String[] cipherSuites;
  public final boolean supportsTlsExtensions;
  final boolean tls;
  final String[] tlsVersions;
  
  static
  {
    Builder localBuilder = new Builder(true);
    CipherSuite[] arrayOfCipherSuite = APPROVED_CIPHER_SUITES;
    if (!tls) {
      throw new IllegalStateException("no cipher suites for cleartext connections");
    }
    String[] arrayOfString = new String[arrayOfCipherSuite.length];
    int i = 0;
    while (i < arrayOfCipherSuite.length)
    {
      arrayOfString[i] = javaName;
      i += 1;
    }
    MODERN_TLS = localBuilder.cipherSuites(arrayOfString).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0 }).supportsTlsExtensions$260aee36().build();
    COMPATIBLE_TLS = new Builder(MODERN_TLS).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_0 }).supportsTlsExtensions$260aee36().build();
  }
  
  private ConnectionSpec(Builder paramBuilder)
  {
    tls = tls;
    cipherSuites = cipherSuites;
    tlsVersions = tlsVersions;
    supportsTlsExtensions = supportsTlsExtensions;
  }
  
  private static boolean nonEmptyIntersection(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString1 == null) || (paramArrayOfString2 == null) || (paramArrayOfString1.length == 0) || (paramArrayOfString2.length == 0)) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        if (Util.contains(paramArrayOfString2, paramArrayOfString1[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ConnectionSpec)) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (ConnectionSpec)paramObject;
    } while ((tls != tls) || ((tls) && ((!Arrays.equals(cipherSuites, cipherSuites)) || (!Arrays.equals(tlsVersions, tlsVersions)) || (supportsTlsExtensions != supportsTlsExtensions))));
    return true;
  }
  
  public final int hashCode()
  {
    int i = 17;
    int j;
    int k;
    if (tls)
    {
      j = Arrays.hashCode(cipherSuites);
      k = Arrays.hashCode(tlsVersions);
      if (!supportsTlsExtensions) {
        break label53;
      }
    }
    label53:
    for (i = 0;; i = 1)
    {
      i = ((j + 527) * 31 + k) * 31 + i;
      return i;
    }
  }
  
  public final boolean isCompatible(SSLSocket paramSSLSocket)
  {
    if (!tls) {}
    while (((tlsVersions != null) && (!nonEmptyIntersection(tlsVersions, paramSSLSocket.getEnabledProtocols()))) || ((cipherSuites != null) && (!nonEmptyIntersection(cipherSuites, paramSSLSocket.getEnabledCipherSuites())))) {
      return false;
    }
    return true;
  }
  
  public final String toString()
  {
    Object localObject2 = null;
    int j = 0;
    if (!tls) {
      return "ConnectionSpec()";
    }
    Object localObject1;
    if (cipherSuites != null) {
      if (cipherSuites == null)
      {
        localObject1 = null;
        localObject1 = localObject1.toString();
        label36:
        if (tlsVersions == null) {
          break label205;
        }
        if (tlsVersions != null) {
          break label154;
        }
      }
    }
    label50:
    label154:
    label205:
    for (localObject2 = localObject2.toString();; localObject2 = "[all enabled]")
    {
      return "ConnectionSpec(cipherSuites=" + (String)localObject1 + ", tlsVersions=" + (String)localObject2 + ", supportsTlsExtensions=" + supportsTlsExtensions + ")";
      localObject1 = new CipherSuite[cipherSuites.length];
      int i = 0;
      while (i < cipherSuites.length)
      {
        localObject1[i] = CipherSuite.forJavaName(cipherSuites[i]);
        i += 1;
      }
      localObject1 = Util.immutableList((Object[])localObject1);
      break;
      localObject1 = "[all enabled]";
      break label36;
      localObject2 = new TlsVersion[tlsVersions.length];
      i = j;
      while (i < tlsVersions.length)
      {
        localObject2[i] = TlsVersion.forJavaName(tlsVersions[i]);
        i += 1;
      }
      localObject2 = Util.immutableList((Object[])localObject2);
      break label50;
    }
  }
  
  public static final class Builder
  {
    String[] cipherSuites;
    boolean supportsTlsExtensions;
    boolean tls;
    String[] tlsVersions;
    
    public Builder(ConnectionSpec paramConnectionSpec)
    {
      tls = tls;
      cipherSuites = cipherSuites;
      tlsVersions = tlsVersions;
      supportsTlsExtensions = supportsTlsExtensions;
    }
    
    Builder(boolean paramBoolean)
    {
      tls = paramBoolean;
    }
    
    public final ConnectionSpec build()
    {
      return new ConnectionSpec(this, (byte)0);
    }
    
    public final Builder cipherSuites(String... paramVarArgs)
    {
      if (!tls) {
        throw new IllegalStateException("no cipher suites for cleartext connections");
      }
      if (paramVarArgs.length == 0) {
        throw new IllegalArgumentException("At least one cipher suite is required");
      }
      cipherSuites = ((String[])paramVarArgs.clone());
      return this;
    }
    
    public final Builder supportsTlsExtensions$260aee36()
    {
      if (!tls) {
        throw new IllegalStateException("no TLS extensions for cleartext connections");
      }
      supportsTlsExtensions = true;
      return this;
    }
    
    public final Builder tlsVersions(String... paramVarArgs)
    {
      if (!tls) {
        throw new IllegalStateException("no TLS versions for cleartext connections");
      }
      if (paramVarArgs.length == 0) {
        throw new IllegalArgumentException("At least one TLS version is required");
      }
      tlsVersions = ((String[])paramVarArgs.clone());
      return this;
    }
    
    public final Builder tlsVersions(TlsVersion... paramVarArgs)
    {
      if (!tls) {
        throw new IllegalStateException("no TLS versions for cleartext connections");
      }
      String[] arrayOfString = new String[paramVarArgs.length];
      int i = 0;
      while (i < paramVarArgs.length)
      {
        arrayOfString[i] = javaName;
        i += 1;
      }
      return tlsVersions(arrayOfString);
    }
  }
}

/* Location:
 * Qualified Name:     okhttp3.ConnectionSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */