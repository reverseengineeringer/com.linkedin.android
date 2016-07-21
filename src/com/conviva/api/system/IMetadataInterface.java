package com.conviva.api.system;

import com.conviva.api.Client.DeviceType;

public abstract interface IMetadataInterface
{
  public abstract String getAndroidBuildModel();
  
  public abstract String getDeviceBrand();
  
  public abstract String getDeviceManufacturer();
  
  public abstract Client.DeviceType getDeviceType();
  
  public abstract String getOperatingSystemVersion();
}

/* Location:
 * Qualified Name:     com.conviva.api.system.IMetadataInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */