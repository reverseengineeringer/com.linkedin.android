package com.linkedin.android.datamanager.perf;

import com.linkedin.android.datamanager.interfaces.EventListener;
import com.linkedin.android.networking.interfaces.PerfEventListener;

public final class NetworkPerfEventListener
  implements PerfEventListener
{
  private EventListener eventListener;
  private String sessionId;
  
  public NetworkPerfEventListener(EventListener paramEventListener, String paramString)
  {
    sessionId = paramString;
    eventListener = paramEventListener;
  }
  
  public final void didReceiveFirstChunk(String paramString)
  {
    eventListener.didReceiveFirstChunk(sessionId, paramString);
  }
  
  public final void dnsLookupDidEnd(String paramString)
  {
    eventListener.dnsLookupDidEnd(sessionId, paramString);
  }
  
  public final void dnsLookupWillStart(String paramString)
  {
    eventListener.dnsLookupWillStart(sessionId, paramString);
  }
  
  public final void requestDidEnd(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    eventListener.networkRequestDidEnd(sessionId, paramString1, paramLong1, paramLong2, paramString2);
  }
  
  public final void requestWillStart(String paramString)
  {
    eventListener.networkRequestWillStart(sessionId, paramString);
  }
  
  public final void setCDNProvider$16da05f7(String paramString)
  {
    eventListener.setCDNProvider$14e1ec6d(sessionId, paramString);
  }
  
  public final void setPopId(String paramString)
  {
    eventListener.setPopId(sessionId, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.perf.NetworkPerfEventListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */