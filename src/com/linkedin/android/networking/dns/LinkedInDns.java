package com.linkedin.android.networking.dns;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Dns;

public final class LinkedInDns
  implements Dns
{
  private final boolean forceIpV4;
  
  public LinkedInDns(boolean paramBoolean)
  {
    forceIpV4 = paramBoolean;
  }
  
  public final List<InetAddress> lookup(String paramString)
    throws UnknownHostException
  {
    if (paramString == null) {
      throw new UnknownHostException("hostname == null");
    }
    paramString = InetAddress.getAllByName(paramString);
    ArrayList localArrayList = new ArrayList();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      if ((!forceIpV4) || ((localObject instanceof Inet4Address))) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.dns.LinkedInDns
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */