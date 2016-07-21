package com.linkedin.android.networking.interfaces;

public abstract interface PerfEventListener
{
  public abstract void didReceiveFirstChunk(String paramString);
  
  public abstract void dnsLookupDidEnd(String paramString);
  
  public abstract void dnsLookupWillStart(String paramString);
  
  public abstract void requestDidEnd(String paramString1, long paramLong1, long paramLong2, String paramString2);
  
  public abstract void requestWillStart(String paramString);
  
  public abstract void setCDNProvider$16da05f7(String paramString);
  
  public abstract void setPopId(String paramString);
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.interfaces.PerfEventListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */