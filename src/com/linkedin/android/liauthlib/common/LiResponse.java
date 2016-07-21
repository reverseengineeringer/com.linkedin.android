package com.linkedin.android.liauthlib.common;

public class LiResponse
{
  public LiError error = null;
  public int statusCode = -1;
  
  public String toString()
  {
    return "LiResponse [statusCode=" + statusCode + ", error=" + error + "]";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.common.LiResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */