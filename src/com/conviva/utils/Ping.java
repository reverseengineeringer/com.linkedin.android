package com.conviva.utils;

import com.conviva.api.ClientSettings;

public final class Ping
{
  public static String serviceUrl = "https://pings.conviva.com/ping.ping";
  String _basePingUrl = null;
  boolean _cachedPingUrl = false;
  ClientSettings _clientSettings;
  IHttpClient _httpClient;
  boolean _isSendingPing = false;
  ILogger _logger;
  
  public Ping(ILogger paramILogger, IHttpClient paramIHttpClient, ClientSettings paramClientSettings)
  {
    _logger = paramILogger;
    _logger.setModuleName("Ping");
    _httpClient = paramIHttpClient;
    _clientSettings = paramClientSettings;
  }
}

/* Location:
 * Qualified Name:     com.conviva.utils.Ping
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */