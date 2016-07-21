package com.conviva.api;

public final class ClientSettings
{
  public String customerKey = null;
  public String gatewayUrl = "https://cws.conviva.com";
  public int heartbeatInterval = 20;
  
  public ClientSettings(String paramString)
    throws Exception
  {
    if ((paramString == null) || (paramString == "")) {
      throw new Exception("customerKey must be valid");
    }
    customerKey = paramString;
  }
}

/* Location:
 * Qualified Name:     com.conviva.api.ClientSettings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */