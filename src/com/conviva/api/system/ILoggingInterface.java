package com.conviva.api.system;

import com.conviva.api.SystemSettings.LogLevel;

public abstract interface ILoggingInterface
{
  public abstract void consoleLog(String paramString, SystemSettings.LogLevel paramLogLevel);
}

/* Location:
 * Qualified Name:     com.conviva.api.system.ILoggingInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */