package com.linkedin.android.litrackinglib.network;

import java.util.Map;

public abstract interface IRequestData
{
  public abstract String getPostBody();
  
  public abstract Map<String, String> getRequestHeaders();
  
  public abstract String getRequestUrl();
}

/* Location:
 * Qualified Name:     com.linkedin.android.litrackinglib.network.IRequestData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */