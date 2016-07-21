package okhttp3.internal;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.tls.AndroidTrustRootIndex;
import okhttp3.internal.tls.RealTrustRootIndex;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;

public class Platform
{
  private static final Platform PLATFORM = ;
  
  private static Platform findPlatform()
  {
    try
    {
      localClass = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
      try
      {
        localOptionalMethod2 = new OptionalMethod(null, "setUseSessionTickets", new Class[] { Boolean.TYPE });
        localOptionalMethod3 = new OptionalMethod(null, "setHostname", new Class[] { String.class });
        localObject4 = null;
        localObject3 = null;
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        try
        {
          OptionalMethod localOptionalMethod2;
          OptionalMethod localOptionalMethod3;
          OptionalMethod localOptionalMethod1;
          label97:
          Object localObject1 = Class.forName("org.eclipse.jetty.alpn.ALPN");
          localClass = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
          Object localObject3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
          localObject4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
          localObject1 = new JdkWithJettyBootPlatform(((Class)localObject1).getMethod("put", new Class[] { SSLSocket.class, localClass }), ((Class)localObject1).getMethod("get", new Class[] { SSLSocket.class }), ((Class)localObject1).getMethod("remove", new Class[] { SSLSocket.class }), (Class)localObject3, (Class)localObject4);
          return (Platform)localObject1;
        }
        catch (ClassNotFoundException localClassNotFoundException3)
        {
          return new Platform();
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          for (;;) {}
        }
      }
      try
      {
        Class.forName("android.net.Network");
        localOptionalMethod1 = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
      }
      catch (ClassNotFoundException localClassNotFoundException4)
      {
        Object localObject2 = localObject4;
        break label97;
      }
      try
      {
        localObject4 = new OptionalMethod(null, "setAlpnProtocols", new Class[] { byte[].class });
        localObject3 = localObject4;
      }
      catch (ClassNotFoundException localClassNotFoundException5)
      {
        break label97;
      }
      return new Android(localClass, localOptionalMethod2, localOptionalMethod3, localOptionalMethod1, (OptionalMethod)localObject3);
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      for (;;)
      {
        localClass = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
      }
    }
  }
  
  public static Platform get()
  {
    return PLATFORM;
  }
  
  public static String getPrefix()
  {
    return "OkHttp";
  }
  
  public static void logW(String paramString)
  {
    System.out.println(paramString);
  }
  
  static <T> T readFieldOrNull(Object paramObject, Class<T> paramClass, String paramString)
  {
    do
    {
      Class localClass = paramObject.getClass();
      while (localClass != Object.class) {
        try
        {
          Object localObject = localClass.getDeclaredField(paramString);
          ((Field)localObject).setAccessible(true);
          localObject = ((Field)localObject).get(paramObject);
          if (localObject == null) {
            break label103;
          }
          if (!paramClass.isInstance(localObject)) {
            return null;
          }
          localObject = paramClass.cast(localObject);
          return (T)localObject;
        }
        catch (IllegalAccessException paramObject)
        {
          throw new AssertionError();
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          localClass = localClass.getSuperclass();
        }
      }
      if (paramString.equals("delegate")) {
        break;
      }
      paramObject = readFieldOrNull(paramObject, Object.class, "delegate");
    } while (paramObject != null);
    label103:
    return null;
  }
  
  public void afterHandshake(SSLSocket paramSSLSocket) {}
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList) {}
  
  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    return null;
  }
  
  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    try
    {
      paramSSLSocketFactory = readFieldOrNull(paramSSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
      if (paramSSLSocketFactory == null) {
        return null;
      }
      paramSSLSocketFactory = (X509TrustManager)readFieldOrNull(paramSSLSocketFactory, X509TrustManager.class, "trustManager");
      return paramSSLSocketFactory;
    }
    catch (ClassNotFoundException paramSSLSocketFactory) {}
    return null;
  }
  
  public TrustRootIndex trustRootIndex(X509TrustManager paramX509TrustManager)
  {
    return new RealTrustRootIndex(paramX509TrustManager.getAcceptedIssuers());
  }
  
  private static final class Android
    extends Platform
  {
    private final OptionalMethod<Socket> getAlpnSelectedProtocol;
    private final OptionalMethod<Socket> setAlpnProtocols;
    private final OptionalMethod<Socket> setHostname;
    private final OptionalMethod<Socket> setUseSessionTickets;
    private final Class<?> sslParametersClass;
    
    public Android(Class<?> paramClass, OptionalMethod<Socket> paramOptionalMethod1, OptionalMethod<Socket> paramOptionalMethod2, OptionalMethod<Socket> paramOptionalMethod3, OptionalMethod<Socket> paramOptionalMethod4)
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
  
  private static final class JdkWithJettyBootPlatform
    extends Platform
  {
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;
    
    public JdkWithJettyBootPlatform(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass1, Class<?> paramClass2)
    {
      putMethod = paramMethod1;
      getMethod = paramMethod2;
      removeMethod = paramMethod3;
      clientProviderClass = paramClass1;
      serverProviderClass = paramClass2;
    }
    
    public final void afterHandshake(SSLSocket paramSSLSocket)
    {
      try
      {
        removeMethod.invoke(null, new Object[] { paramSSLSocket });
        return;
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        for (;;) {}
      }
    }
    
    public final void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
    {
      paramString = new ArrayList(paramList.size());
      int i = 0;
      int j = paramList.size();
      Object localObject;
      while (i < j)
      {
        localObject = (Protocol)paramList.get(i);
        if (localObject != Protocol.HTTP_1_0) {
          paramString.add(((Protocol)localObject).toString());
        }
        i += 1;
      }
      try
      {
        paramList = Platform.class.getClassLoader();
        localObject = clientProviderClass;
        Class localClass = serverProviderClass;
        paramString = new Platform.JettyNegoProvider(paramString);
        paramString = Proxy.newProxyInstance(paramList, new Class[] { localObject, localClass }, paramString);
        putMethod.invoke(null, new Object[] { paramSSLSocket, paramString });
        return;
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError(paramSSLSocket);
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        for (;;) {}
      }
    }
    
    public final String getSelectedProtocol(SSLSocket paramSSLSocket)
    {
      try
      {
        paramSSLSocket = (Platform.JettyNegoProvider)Proxy.getInvocationHandler(getMethod.invoke(null, new Object[] { paramSSLSocket }));
        if ((!Platform.JettyNegoProvider.access$000(paramSSLSocket)) && (Platform.JettyNegoProvider.access$100(paramSSLSocket) == null))
        {
          Internal.logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
          return null;
        }
        if (!Platform.JettyNegoProvider.access$000(paramSSLSocket))
        {
          paramSSLSocket = Platform.JettyNegoProvider.access$100(paramSSLSocket);
          return paramSSLSocket;
        }
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        for (;;) {}
      }
      return null;
    }
  }
  
  private static final class JettyNegoProvider
    implements InvocationHandler
  {
    private final List<String> protocols;
    private String selected;
    private boolean unsupported;
    
    public JettyNegoProvider(List<String> paramList)
    {
      protocols = paramList;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      String str = paramMethod.getName();
      Class localClass = paramMethod.getReturnType();
      paramObject = paramArrayOfObject;
      if (paramArrayOfObject == null) {
        paramObject = Util.EMPTY_STRING_ARRAY;
      }
      if ((str.equals("supports")) && (Boolean.TYPE == localClass)) {
        return Boolean.valueOf(true);
      }
      if ((str.equals("unsupported")) && (Void.TYPE == localClass))
      {
        unsupported = true;
        return null;
      }
      if ((str.equals("protocols")) && (paramObject.length == 0)) {
        return protocols;
      }
      if (((str.equals("selectProtocol")) || (str.equals("select"))) && (String.class == localClass) && (paramObject.length == 1) && ((paramObject[0] instanceof List)))
      {
        paramObject = (List)paramObject[0];
        int i = 0;
        int j = ((List)paramObject).size();
        while (i < j)
        {
          if (protocols.contains(((List)paramObject).get(i)))
          {
            paramObject = (String)((List)paramObject).get(i);
            selected = ((String)paramObject);
            return paramObject;
          }
          i += 1;
        }
        paramObject = (String)protocols.get(0);
        selected = ((String)paramObject);
        return paramObject;
      }
      if (((str.equals("protocolSelected")) || (str.equals("selected"))) && (paramObject.length == 1))
      {
        selected = ((String)paramObject[0]);
        return null;
      }
      return paramMethod.invoke(this, (Object[])paramObject);
    }
  }
}

/* Location:
 * Qualified Name:     okhttp3.internal.Platform
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */