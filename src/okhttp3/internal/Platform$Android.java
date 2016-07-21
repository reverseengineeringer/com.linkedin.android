package okhttp3.internal;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.tls.AndroidTrustRootIndex;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;

final class Platform$Android
  extends Platform
{
  private final OptionalMethod<Socket> getAlpnSelectedProtocol;
  private final OptionalMethod<Socket> setAlpnProtocols;
  private final OptionalMethod<Socket> setHostname;
  private final OptionalMethod<Socket> setUseSessionTickets;
  private final Class<?> sslParametersClass;
  
  public Platform$Android(Class<?> paramClass, OptionalMethod<Socket> paramOptionalMethod1, OptionalMethod<Socket> paramOptionalMethod2, OptionalMethod<Socket> paramOptionalMethod3, OptionalMethod<Socket> paramOptionalMethod4)
  {
    sslParametersClass = paramClass;
    setUseSessionTickets = paramOptionalMethod1;
    setHostname = paramOptionalMethod2;
    getAlpnSelectedProtocol = paramOptionalMethod3;
    setAlpnProtocols = paramOptionalMethod4;
  }
  
  public final void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    if (paramString != null)
    {
      setUseSessionTickets.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
      setHostname.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
    }
    if ((setAlpnProtocols != null) && (setAlpnProtocols.isSupported(paramSSLSocket)))
    {
      paramString = new Buffer();
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        Protocol localProtocol = (Protocol)paramList.get(i);
        if (localProtocol != Protocol.HTTP_1_0)
        {
          paramString.writeByte(localProtocol.toString().length());
          paramString.writeUtf8(localProtocol.toString());
        }
        i += 1;
      }
      paramString = paramString.readByteArray();
      setAlpnProtocols.invokeWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
    }
  }
  
  public final void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    try
    {
      paramSocket.connect(paramInetSocketAddress, paramInt);
      return;
    }
    catch (AssertionError paramSocket)
    {
      if (Util.isAndroidGetsocknameError(paramSocket)) {
        throw new IOException(paramSocket);
      }
      throw paramSocket;
    }
    catch (SecurityException paramSocket)
    {
      paramInetSocketAddress = new IOException("Exception in connect");
      paramInetSocketAddress.initCause(paramSocket);
      throw paramInetSocketAddress;
    }
  }
  
  public final String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    if (getAlpnSelectedProtocol == null) {
      return null;
    }
    if (!getAlpnSelectedProtocol.isSupported(paramSSLSocket)) {
      return null;
    }
    paramSSLSocket = (byte[])getAlpnSelectedProtocol.invokeWithoutCheckedException(paramSSLSocket, new Object[0]);
    if (paramSSLSocket != null) {
      return new String(paramSSLSocket, Util.UTF_8);
    }
    return null;
  }
  
  public final X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    Object localObject2 = readFieldOrNull(paramSSLSocketFactory, sslParametersClass, "sslParameters");
    Object localObject1 = localObject2;
    if (localObject2 == null) {}
    try
    {
      localObject1 = readFieldOrNull(paramSSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, paramSSLSocketFactory.getClass().getClassLoader()), "sslParameters");
      paramSSLSocketFactory = (X509TrustManager)readFieldOrNull(localObject1, X509TrustManager.class, "x509TrustManager");
      if (paramSSLSocketFactory != null) {
        return paramSSLSocketFactory;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return super.trustManager(paramSSLSocketFactory);
    }
    return (X509TrustManager)readFieldOrNull(localClassNotFoundException, X509TrustManager.class, "trustManager");
  }
  
  public final TrustRootIndex trustRootIndex(X509TrustManager paramX509TrustManager)
  {
    TrustRootIndex localTrustRootIndex = AndroidTrustRootIndex.get(paramX509TrustManager);
    if (localTrustRootIndex != null) {
      return localTrustRootIndex;
    }
    return super.trustRootIndex(paramX509TrustManager);
  }
}

/* Location:
 * Qualified Name:     okhttp3.internal.Platform.Android
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */