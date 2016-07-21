package com.linkedin.android.perf.commons;

import java.util.Map;

public abstract interface IHttpStack
{
  public abstract void sendHttpPost(String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte)
    throws Exception;
}

/* Location:
 * Qualified Name:     com.linkedin.android.perf.commons.IHttpStack
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */