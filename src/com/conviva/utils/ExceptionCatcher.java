package com.conviva.utils;

import com.conviva.api.ClientSettings;
import com.conviva.api.SystemSettings;
import com.conviva.protocol.Protocol;
import java.net.URLEncoder;
import java.util.concurrent.Callable;

public final class ExceptionCatcher
{
  private Logger _logger;
  private Ping _ping;
  private SystemSettings _systemSettings;
  
  public ExceptionCatcher(Logger paramLogger, Ping paramPing, SystemSettings paramSystemSettings)
  {
    _logger = paramLogger;
    _logger._moduleName = "ExceptionCatcher";
    _ping = paramPing;
    _systemSettings = paramSystemSettings;
  }
  
  public final <V> void runProtected(Callable<V> paramCallable, String paramString)
    throws Exception
  {
    try
    {
      paramCallable.call();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (_systemSettings.allowUncaughtExceptions) {
          throw localException;
        }
        try
        {
          paramCallable = _ping;
          paramString = "Uncaught exception: " + paramString + ": " + localException.toString();
          boolean bool = _isSendingPing;
          if (bool) {
            continue;
          }
          try
          {
            _isSendingPing = true;
            if (!_cachedPingUrl)
            {
              _basePingUrl = (Ping.serviceUrl + "?comp=sdkjava&clv=2.109.0.30084");
              if (_clientSettings != null) {
                _basePingUrl = (_basePingUrl + "&cid=" + _clientSettings.customerKey);
              }
              _basePingUrl = (_basePingUrl + "&sch=" + Protocol.SDK_METADATA_SCHEMA);
              if (_clientSettings != null) {
                _cachedPingUrl = true;
              }
            }
            paramString = _basePingUrl + "&d=" + URLEncoder.encode(paramString, "UTF-8");
            _logger.error("send(): " + paramString);
            _httpClient.request("GET", paramString, null, null, null);
            _isSendingPing = false;
            return;
          }
          catch (Exception paramString)
          {
            _isSendingPing = false;
            _logger.error("failed to send ping");
            return;
          }
          return;
        }
        catch (Exception paramCallable)
        {
          _logger.error("Caught exception while sending ping: " + paramCallable.toString());
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.conviva.utils.ExceptionCatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */