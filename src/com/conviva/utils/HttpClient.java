package com.conviva.utils;

import com.conviva.api.SystemSettings;
import com.conviva.api.system.ICallbackInterface;
import com.conviva.api.system.IHttpInterface;

public final class HttpClient
  implements IHttpClient
{
  private IHttpInterface _httpInterface;
  private Logger _logger;
  private SystemSettings _systemSettings;
  
  public HttpClient(Logger paramLogger, IHttpInterface paramIHttpInterface, SystemSettings paramSystemSettings)
  {
    _logger = paramLogger;
    _httpInterface = paramIHttpInterface;
    _systemSettings = paramSystemSettings;
  }
  
  public final void request(String paramString1, String paramString2, String paramString3, String paramString4, ICallbackInterface paramICallbackInterface)
  {
    _logger.debug("request(): calling IHttpInterface:makeRequest");
    _httpInterface.makeRequest(paramString1, paramString2, paramString3, paramString4, _systemSettings.httpTimeout * 1000, paramICallbackInterface);
  }
}

/* Location:
 * Qualified Name:     com.conviva.utils.HttpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */