package com.linkedin.android.tos;

public enum Host
{
  HOST_EI("https://www.linkedin-ei.com"),  HOST_PROD("https://www.linkedin.com");
  
  private final String text;
  
  private Host(String paramString)
  {
    text = paramString;
  }
  
  public final String toString()
  {
    return text;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.tos.Host
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */