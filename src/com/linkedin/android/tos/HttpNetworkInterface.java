package com.linkedin.android.tos;

import java.net.CookieStore;

public abstract interface HttpNetworkInterface
{
  public abstract void get(String paramString, HttpNetworkInterface.ResponseListener paramResponseListener);
  
  public abstract CookieStore getCookieStore();
  
  public abstract void post(String paramString1, String paramString2, byte[] paramArrayOfByte, HttpNetworkInterface.ResponseListener paramResponseListener);
}

/* Location:
 * Qualified Name:     com.linkedin.android.tos.HttpNetworkInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */