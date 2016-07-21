package okhttp3;

public final class ConnectionSpec$Builder
{
  String[] cipherSuites;
  boolean supportsTlsExtensions;
  boolean tls;
  String[] tlsVersions;
  
  public ConnectionSpec$Builder(ConnectionSpec paramConnectionSpec)
  {
    tls = ConnectionSpec.access$400(paramConnectionSpec);
    cipherSuites = ConnectionSpec.access$500(paramConnectionSpec);
    tlsVersions = ConnectionSpec.access$600(paramConnectionSpec);
    supportsTlsExtensions = ConnectionSpec.access$700(paramConnectionSpec);
  }
  
  ConnectionSpec$Builder(boolean paramBoolean)
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

/* Location:
 * Qualified Name:     okhttp3.ConnectionSpec.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */