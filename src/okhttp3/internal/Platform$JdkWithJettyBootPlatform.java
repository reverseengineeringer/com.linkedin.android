package okhttp3.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

final class Platform$JdkWithJettyBootPlatform
  extends Platform
{
  private final Class<?> clientProviderClass;
  private final Method getMethod;
  private final Method putMethod;
  private final Method removeMethod;
  private final Class<?> serverProviderClass;
  
  public Platform$JdkWithJettyBootPlatform(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass1, Class<?> paramClass2)
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

/* Location:
 * Qualified Name:     okhttp3.internal.Platform.JdkWithJettyBootPlatform
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */