package com.conviva.utils;

import com.conviva.api.system.IMetadataInterface;
import java.util.Map;
import java.util.concurrent.Callable;

public final class SystemMetadata
{
  public static String ANROID_BUILD_MODEL = "androidBuildModel";
  public static String DEVICE_BRAND = "deviceBrand";
  public static String DEVICE_MANUFACTURER = "deviceManufacturer";
  public static String DEVICE_MODEL = "deviceModel";
  public static String DEVICE_TYPE = "deviceType";
  public static String DEVICE_VERSION = "deviceVersion";
  public static String FRAMEWORK_NAME = "frameworkName";
  public static String FRAMEWORK_VERSION = "frameworkVersion";
  public static String OPERATING_SYSTEM_VERSION = "operatingSystemVersion";
  public Map<String, String> _cachedMetadata = null;
  public ExceptionCatcher _exceptionCatcher;
  private Logger _logger;
  private IMetadataInterface _metadataInterface;
  
  public SystemMetadata(Logger paramLogger, IMetadataInterface paramIMetadataInterface, ExceptionCatcher paramExceptionCatcher)
  {
    _metadataInterface = paramIMetadataInterface;
    _exceptionCatcher = paramExceptionCatcher;
    _logger = paramLogger;
  }
}

/* Location:
 * Qualified Name:     com.conviva.utils.SystemMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */