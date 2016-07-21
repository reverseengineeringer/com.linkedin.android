package com.linkedin.android.datamanager.interfaces;

public abstract interface EventListener
{
  public abstract void cacheRequestEnqueued(String paramString1, String paramString2);
  
  public abstract void didReceiveFirstChunk(String paramString1, String paramString2);
  
  public abstract void dnsLookupDidEnd(String paramString1, String paramString2);
  
  public abstract void dnsLookupWillStart(String paramString1, String paramString2);
  
  public abstract void multiplexedNetworkRequestDidEnd(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3);
  
  public abstract void networkRequestDidEnd(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3);
  
  public abstract void networkRequestEnqueued(String paramString1, String paramString2);
  
  public abstract void networkRequestWillStart(String paramString1, String paramString2);
  
  public abstract void parsingDidEnd(String paramString1, String paramString2);
  
  public abstract void parsingWillStart(String paramString1, String paramString2);
  
  public abstract void setCDNProvider$14e1ec6d(String paramString1, String paramString2);
  
  public abstract void setPopId(String paramString1, String paramString2);
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.interfaces.EventListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */