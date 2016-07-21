package com.conviva.utils;

import com.conviva.api.SystemSettings;
import com.conviva.api.system.IStorageInterface;

public final class Storage
{
  public CallbackWithTimeout _callbackWithTimeout;
  public Logger _logger;
  public IStorageInterface _storageInterface;
  public SystemSettings _systemSettings;
  
  public Storage(Logger paramLogger, IStorageInterface paramIStorageInterface, CallbackWithTimeout paramCallbackWithTimeout, SystemSettings paramSystemSettings)
  {
    _logger = paramLogger;
    _storageInterface = paramIStorageInterface;
    _callbackWithTimeout = paramCallbackWithTimeout;
    _systemSettings = paramSystemSettings;
  }
}

/* Location:
 * Qualified Name:     com.conviva.utils.Storage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */