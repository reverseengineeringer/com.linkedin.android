package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class MobileHeader$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.MobileHeader.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */