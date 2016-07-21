package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;

public final class Route
{
  public final Address address;
  public final InetSocketAddress inetSocketAddress;
  public final Proxy proxy;
  
  public Route(Address paramAddress, Proxy paramProxy, InetSocketAddress paramInetSocketAddress)
  {
    if (paramAddress == null) {
      throw new NullPointerException("address == null");
    }
    if (paramProxy == null) {
      throw new NullPointerException("proxy == null");
    }
    if (paramInetSocketAddress == null) {
      throw new NullPointerException("inetSocketAddress == null");
    }
    address = paramAddress;
    proxy = paramProxy;
    inetSocketAddress = paramInetSocketAddress;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Route))
    {
      paramObject = (Route)paramObject;
      bool1 = bool2;
      if (address.equals(address))
      {
        bool1 = bool2;
        if (proxy.equals(proxy))
        {
          bool1 = bool2;
          if (inetSocketAddress.equals(inetSocketAddress)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return ((address.hashCode() + 527) * 31 + proxy.hashCode()) * 31 + inetSocketAddress.hashCode();
  }
}

/* Location:
 * Qualified Name:     okhttp3.Route
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */