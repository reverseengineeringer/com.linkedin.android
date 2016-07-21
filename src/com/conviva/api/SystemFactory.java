package com.conviva.api;

import com.conviva.api.system.IGraphicalInterface;
import com.conviva.api.system.IHttpInterface;
import com.conviva.api.system.ILoggingInterface;
import com.conviva.api.system.IMetadataInterface;
import com.conviva.api.system.IStorageInterface;
import com.conviva.api.system.ITimeInterface;
import com.conviva.api.system.ITimerInterface;
import com.conviva.api.system.SystemInterface;
import com.conviva.utils.CallbackWithTimeout;
import com.conviva.utils.ExceptionCatcher;
import com.conviva.utils.HttpClient;
import com.conviva.utils.Logger;
import com.conviva.utils.Ping;
import com.conviva.utils.Time;
import com.conviva.utils.Timer;
import java.util.LinkedList;
import java.util.List;

public final class SystemFactory
{
  ClientSettings _clientSettings;
  public IGraphicalInterface _graphicalInterface;
  private IHttpInterface _httpInterface;
  public List<String> _logBuffer = new LinkedList();
  private ILoggingInterface _loggingInterface;
  public IMetadataInterface _metadataInterface;
  public String _packageName = null;
  public SystemSettings _settings;
  IStorageInterface _storageInterface;
  public SystemInterface _systemInterface;
  private ITimeInterface _timeInterface;
  private ITimerInterface _timerInterface;
  
  public SystemFactory(SystemInterface paramSystemInterface, SystemSettings paramSystemSettings)
  {
    _systemInterface = paramSystemInterface;
    _timeInterface = _systemInterface._timeInterface;
    _timerInterface = _systemInterface._timerInterface;
    _httpInterface = _systemInterface._httpInterface;
    _storageInterface = _systemInterface._storageInterface;
    _metadataInterface = _systemInterface._metadataInterface;
    _loggingInterface = _systemInterface._loggingInterface;
    _graphicalInterface = _systemInterface._graphicalInterface;
    paramSystemInterface = paramSystemSettings;
    if (paramSystemSettings == null) {
      paramSystemInterface = new SystemSettings();
    }
    _settings = paramSystemInterface;
  }
  
  public final CallbackWithTimeout buildCallbackWithTimeout()
  {
    return new CallbackWithTimeout(buildTimer());
  }
  
  public final ExceptionCatcher buildExceptionCatcher()
  {
    return new ExceptionCatcher(buildLogger(), new Ping(buildLogger(), buildHttpClient(), _clientSettings), _settings);
  }
  
  public final HttpClient buildHttpClient()
  {
    return new HttpClient(buildLogger(), _httpInterface, _settings);
  }
  
  public final Logger buildLogger()
  {
    return new Logger(_loggingInterface, _timeInterface, _settings, _logBuffer, _packageName);
  }
  
  public final Time buildTime()
  {
    return new Time(_timeInterface);
  }
  
  public final Timer buildTimer()
  {
    return new Timer(buildLogger(), _timerInterface, buildExceptionCatcher());
  }
}

/* Location:
 * Qualified Name:     com.conviva.api.SystemFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */