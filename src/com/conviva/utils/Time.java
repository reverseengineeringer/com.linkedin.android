package com.conviva.utils;

import com.conviva.api.system.ITimeInterface;

public final class Time
{
  private ITimeInterface _timeInterface;
  
  public Time(ITimeInterface paramITimeInterface)
  {
    _timeInterface = paramITimeInterface;
  }
  
  public final double current()
  {
    return _timeInterface.getEpochTimeMs();
  }
}

/* Location:
 * Qualified Name:     com.conviva.utils.Time
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */