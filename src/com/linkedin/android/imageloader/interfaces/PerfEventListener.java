package com.linkedin.android.imageloader.interfaces;

public abstract interface PerfEventListener
{
  public abstract void cacheLookupDidEnd$25decb5(boolean paramBoolean);
  
  public abstract void cacheLookupDidStart$1385ff();
  
  public abstract void decodeDidEnd();
  
  public abstract void decodeDidStart();
  
  public abstract void didReceiveFirstChunk(String paramString);
  
  public abstract void dnsLookupDidEnd(String paramString);
  
  public abstract void dnsLookupWillStart(String paramString);
  
  public abstract void networkRequestWillStart(String paramString);
  
  public abstract void requestDidEnd(String paramString1, long paramLong1, long paramLong2, String paramString2);
  
  public abstract void setPopId(String paramString);
  
  public abstract void transformDidEnd();
  
  public abstract void transformDidStart();
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.interfaces.PerfEventListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */