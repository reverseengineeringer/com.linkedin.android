package com.conviva.api.system;

public final class SystemInterface
{
  public IGraphicalInterface _graphicalInterface = null;
  public IHttpInterface _httpInterface = null;
  public ILoggingInterface _loggingInterface = null;
  public IMetadataInterface _metadataInterface = null;
  public IStorageInterface _storageInterface = null;
  public ITimeInterface _timeInterface = null;
  public ITimerInterface _timerInterface = null;
  
  public SystemInterface(ITimeInterface paramITimeInterface, ITimerInterface paramITimerInterface, IHttpInterface paramIHttpInterface, IStorageInterface paramIStorageInterface, IMetadataInterface paramIMetadataInterface, ILoggingInterface paramILoggingInterface, IGraphicalInterface paramIGraphicalInterface)
    throws Exception
  {
    _timeInterface = paramITimeInterface;
    _timerInterface = paramITimerInterface;
    _httpInterface = paramIHttpInterface;
    _storageInterface = paramIStorageInterface;
    _metadataInterface = paramIMetadataInterface;
    _loggingInterface = paramILoggingInterface;
    _graphicalInterface = paramIGraphicalInterface;
  }
}

/* Location:
 * Qualified Name:     com.conviva.api.system.SystemInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */