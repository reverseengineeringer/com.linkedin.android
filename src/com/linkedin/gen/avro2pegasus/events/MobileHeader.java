package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class MobileHeader
  implements RecordTemplate<MobileHeader>
{
  public static final MobileHeaderBuilder BUILDER = MobileHeaderBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String advertiserId;
  public final String appVersion;
  public final String deviceModel;
  public final boolean hasAdvertiserId;
  public final boolean hasAppVersion;
  public final boolean hasDeviceModel;
  public final boolean hasIsAdTrackingLimited;
  public final boolean hasOsName;
  public final boolean hasOsVersion;
  public final boolean hasVendorId;
  public final boolean isAdTrackingLimited;
  public final String osName;
  public final String osVersion;
  public final String vendorId;
  
  MobileHeader(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    osName = paramString1;
    osVersion = paramString2;
    deviceModel = paramString3;
    appVersion = paramString4;
    advertiserId = paramString5;
    vendorId = paramString6;
    isAdTrackingLimited = paramBoolean1;
    hasOsName = paramBoolean2;
    hasOsVersion = paramBoolean3;
    hasDeviceModel = paramBoolean4;
    hasAppVersion = paramBoolean5;
    hasAdvertiserId = paramBoolean6;
    hasVendorId = paramBoolean7;
    hasIsAdTrackingLimited = paramBoolean8;
    _cachedId = null;
  }
  
  public final MobileHeader accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasOsName)
    {
      paramDataProcessor.startRecordField$505cff1c("osName");
      paramDataProcessor.processString(osName);
    }
    if (hasOsVersion)
    {
      paramDataProcessor.startRecordField$505cff1c("osVersion");
      paramDataProcessor.processString(osVersion);
    }
    if (hasDeviceModel)
    {
      paramDataProcessor.startRecordField$505cff1c("deviceModel");
      paramDataProcessor.processString(deviceModel);
    }
    if (hasAppVersion)
    {
      paramDataProcessor.startRecordField$505cff1c("appVersion");
      paramDataProcessor.processString(appVersion);
    }
    if (hasAdvertiserId)
    {
      paramDataProcessor.startRecordField$505cff1c("advertiserId");
      paramDataProcessor.processString(advertiserId);
    }
    if (hasVendorId)
    {
      paramDataProcessor.startRecordField$505cff1c("vendorId");
      paramDataProcessor.processString(vendorId);
    }
    if (hasIsAdTrackingLimited)
    {
      paramDataProcessor.startRecordField$505cff1c("isAdTrackingLimited");
      paramDataProcessor.processBoolean(isAdTrackingLimited);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new MobileHeader(osName, osVersion, deviceModel, appVersion, advertiserId, vendorId, isAdTrackingLimited, hasOsName, hasOsVersion, hasDeviceModel, hasAppVersion, hasAdvertiserId, hasVendorId, hasIsAdTrackingLimited);
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (MobileHeader)paramObject;
      if (osName != null)
      {
        if (osName.equals(osName)) {}
      }
      else {
        while (osName != null) {
          return false;
        }
      }
      if (osVersion != null)
      {
        if (osVersion.equals(osVersion)) {}
      }
      else {
        while (osVersion != null) {
          return false;
        }
      }
      if (deviceModel != null)
      {
        if (deviceModel.equals(deviceModel)) {}
      }
      else {
        while (deviceModel != null) {
          return false;
        }
      }
      if (appVersion != null)
      {
        if (appVersion.equals(appVersion)) {}
      }
      else {
        while (appVersion != null) {
          return false;
        }
      }
      if (advertiserId != null)
      {
        if (advertiserId.equals(advertiserId)) {}
      }
      else {
        while (advertiserId != null) {
          return false;
        }
      }
      if (vendorId != null)
      {
        if (vendorId.equals(vendorId)) {}
      }
      else {
        while (vendorId != null) {
          return false;
        }
      }
    } while (isAdTrackingLimited == isAdTrackingLimited);
    return false;
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int n;
    if (osName != null)
    {
      i = osName.hashCode();
      if (osVersion == null) {
        break label170;
      }
      j = osVersion.hashCode();
      if (deviceModel == null) {
        break label175;
      }
      k = deviceModel.hashCode();
      if (appVersion == null) {
        break label180;
      }
      m = appVersion.hashCode();
      if (advertiserId == null) {
        break label186;
      }
      n = advertiserId.hashCode();
      label92:
      if (vendorId == null) {
        break label192;
      }
    }
    label170:
    label175:
    label180:
    label186:
    label192:
    for (int i1 = vendorId.hashCode();; i1 = 0)
    {
      if (isAdTrackingLimited) {
        i2 = 1;
      }
      i = (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
      n = 0;
      break label92;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<MobileHeader>
  {
    public String advertiserId = null;
    public String appVersion = null;
    public String deviceModel = null;
    public boolean hasAdvertiserId = false;
    public boolean hasAppVersion = false;
    public boolean hasDeviceModel = false;
    public boolean hasIsAdTrackingLimited = false;
    public boolean hasOsName = false;
    public boolean hasOsVersion = false;
    private boolean hasVendorId = false;
    public boolean isAdTrackingLimited = false;
    public String osName = null;
    public String osVersion = null;
    private String vendorId = null;
    
    public final MobileHeader build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      int[] arrayOfInt = MobileHeader.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
      paramFlavor.ordinal();
      return new MobileHeader(osName, osVersion, deviceModel, appVersion, advertiserId, vendorId, isAdTrackingLimited, hasOsName, hasOsVersion, hasDeviceModel, hasAppVersion, hasAdvertiserId, hasVendorId, hasIsAdTrackingLimited);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.MobileHeader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */