package com.conviva.utils;

import com.conviva.api.system.ICallbackInterface;

public abstract interface IHttpClient
{
  public abstract void request(String paramString1, String paramString2, String paramString3, String paramString4, ICallbackInterface paramICallbackInterface);
}

/* Location:
 * Qualified Name:     com.conviva.utils.IHttpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */