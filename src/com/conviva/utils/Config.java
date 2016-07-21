package com.conviva.utils;

import com.conviva.api.system.ICallbackInterface;
import com.conviva.json.IJsonInterface;
import com.conviva.protocol.Protocol;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public final class Config
{
  private final String CONFIG_STORAGE_KEY_CLIENT_ID = "clId";
  private final String STORAGE_KEY = "sdkConfig";
  public Map<String, Object> _config;
  private Map<String, Object> _defaultConfig;
  public IJsonInterface _jsonInterface;
  public boolean _loaded;
  public boolean _loadedEmpty;
  Logger _logger;
  public Storage _storage;
  public Stack<CallableWithParameters.With0> _waitingConsumers;
  
  public Config(Logger paramLogger, Storage paramStorage, IJsonInterface paramIJsonInterface)
  {
    _logger = paramLogger;
    _storage = paramStorage;
    _jsonInterface = paramIJsonInterface;
    _loaded = false;
    _waitingConsumers = new Stack();
    _logger._moduleName = "Config";
    _defaultConfig = new HashMap();
    _defaultConfig.put("clientId", Protocol.DEFAULT_CLIENT_ID);
    _defaultConfig.put("sendLogs", Boolean.valueOf(false));
    _config = new HashMap();
    _config.putAll(_defaultConfig);
  }
  
  public final Object get(String paramString)
  {
    if (_loaded) {
      return _config.get(paramString);
    }
    return null;
  }
  
  public final void set(String paramString, Object paramObject)
  {
    if (_loaded) {
      _config.put(paramString, paramObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.conviva.utils.Config
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */