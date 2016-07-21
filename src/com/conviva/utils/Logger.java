package com.conviva.utils;

import com.conviva.api.SystemSettings;
import com.conviva.api.SystemSettings.LogLevel;
import com.conviva.api.system.ILoggingInterface;
import com.conviva.api.system.ITimeInterface;
import java.util.List;

public final class Logger
  implements ILogger
{
  public ILoggingInterface _consoleInterface;
  List<String> _logBuffer;
  public String _moduleName;
  String _packageName;
  public int _sessionId;
  SystemSettings _settings;
  ITimeInterface _timeInterface;
  
  public Logger(ILoggingInterface paramILoggingInterface, ITimeInterface paramITimeInterface, SystemSettings paramSystemSettings, List<String> paramList, String paramString)
  {
    _consoleInterface = paramILoggingInterface;
    _timeInterface = paramITimeInterface;
    _settings = paramSystemSettings;
    _logBuffer = paramList;
    _packageName = paramString;
  }
  
  private void log(String paramString, SystemSettings.LogLevel paramLogLevel)
  {
    int i = 0;
    paramString = formatMessage(paramString, paramLogLevel);
    _logBuffer.add(paramString);
    switch (paramLogLevel)
    {
    default: 
    case ???: 
      do
      {
        if (i != 0) {
          _consoleInterface.consoleLog(paramString, paramLogLevel);
        }
        return;
      } while (_settings.logLevel != SystemSettings.LogLevel.DEBUG);
    }
    for (;;)
    {
      i = 1;
      break;
      if ((_settings.logLevel != SystemSettings.LogLevel.DEBUG) && (_settings.logLevel != SystemSettings.LogLevel.INFO)) {
        break;
      }
      i = 1;
      break;
      if ((_settings.logLevel != SystemSettings.LogLevel.DEBUG) && (_settings.logLevel != SystemSettings.LogLevel.INFO) && (_settings.logLevel != SystemSettings.LogLevel.WARNING)) {
        break;
      }
      i = 1;
      break;
      if ((_settings.logLevel != SystemSettings.LogLevel.DEBUG) && (_settings.logLevel != SystemSettings.LogLevel.INFO) && (_settings.logLevel != SystemSettings.LogLevel.WARNING)) {
        if (_settings.logLevel != SystemSettings.LogLevel.ERROR) {
          break;
        }
      }
    }
  }
  
  public final void debug(String paramString)
  {
    log(paramString, SystemSettings.LogLevel.DEBUG);
  }
  
  public final void error(String paramString)
  {
    log(paramString, SystemSettings.LogLevel.ERROR);
  }
  
  public final String formatMessage(String paramString, SystemSettings.LogLevel paramLogLevel)
  {
    String str = paramString;
    if (_sessionId > 0) {
      str = "sid=" + _sessionId + " " + paramString;
    }
    paramString = str;
    if (_moduleName != null)
    {
      paramString = str;
      if (_moduleName != "") {
        paramString = "[" + _moduleName + "] " + str;
      }
    }
    str = paramString;
    if (_packageName != null)
    {
      str = paramString;
      if (_packageName != "") {
        str = "[" + _packageName + "] " + paramString;
      }
    }
    paramString = "";
    switch (paramLogLevel)
    {
    }
    for (;;)
    {
      paramLogLevel = str;
      if (_packageName != null)
      {
        paramLogLevel = str;
        if (_packageName != "") {
          paramLogLevel = "[" + paramString + "] " + str;
        }
      }
      paramString = String.format("%.2f", new Object[] { Double.valueOf(_timeInterface.getEpochTimeMs() / 1000.0D) });
      paramLogLevel = "[" + paramString + "] " + paramLogLevel;
      paramString = paramLogLevel;
      if (_packageName != null)
      {
        paramString = paramLogLevel;
        if (_packageName != "") {
          paramString = "[Conviva] " + paramLogLevel;
        }
      }
      return paramString;
      paramString = "ERROR";
      continue;
      paramString = "WARNING";
      continue;
      paramString = "INFO";
      continue;
      paramString = "NONE";
    }
  }
  
  public final void info(String paramString)
  {
    log(paramString, SystemSettings.LogLevel.INFO);
  }
  
  public final void setModuleName(String paramString)
  {
    _moduleName = paramString;
  }
  
  public final void warning(String paramString)
  {
    log(paramString, SystemSettings.LogLevel.WARNING);
  }
}

/* Location:
 * Qualified Name:     com.conviva.utils.Logger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */