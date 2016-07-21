package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.mobile.ApplicationVisibilityStatus;
import com.linkedin.gen.avro2pegasus.events.mobile.DeviceOrientation;
import com.linkedin.gen.avro2pegasus.events.mobile.MobileApplicationLixTreatment;
import java.util.Iterator;
import java.util.List;

public final class MobileApplicationErrorEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<MobileApplicationErrorEvent>
{
  private String appDistributionBuildVariant = null;
  public ApplicationBuildType applicationBuildType = null;
  private List<String> applicationLogs = null;
  private ApplicationVisibilityStatus applicationVisibilityStatus = null;
  private long availableDiskSpace = 0L;
  private double batteryLevel = 0.0D;
  public String buildNumber = null;
  private String carrierName = null;
  private String connectionType = null;
  private String cpuArchitecture = null;
  private List<MobileApplicationCrashHint> crashHints = null;
  private String deviceID = null;
  private String deviceLocale = null;
  private DeviceOrientation deviceOrientation = null;
  public String errorSummary = null;
  private long errorTimestamp = 0L;
  public ErrorType errorType = null;
  private long freeDeviceMemory = 0L;
  private boolean hasAppDistributionBuildVariant = false;
  public boolean hasApplicationBuildType = false;
  private boolean hasApplicationLogs = false;
  private boolean hasApplicationVisibilityStatus = false;
  private boolean hasAvailableDiskSpace = false;
  private boolean hasBatteryLevel = false;
  public boolean hasBuildNumber = false;
  private boolean hasCarrierName = false;
  private boolean hasConnectionType = false;
  private boolean hasCpuArchitecture = false;
  private boolean hasCrashHints = false;
  private boolean hasDeviceID = false;
  private boolean hasDeviceLocale = false;
  private boolean hasDeviceOrientation = false;
  public boolean hasErrorSummary = false;
  private boolean hasErrorTimestamp = false;
  public boolean hasErrorType = false;
  private boolean hasFreeDeviceMemory = false;
  private boolean hasHeader = false;
  public boolean hasMobileApplicationName = false;
  private boolean hasMobileHeader = false;
  private boolean hasMobileLixTreatmentRecords = false;
  public boolean hasRawCrashData = false;
  private boolean hasRequestHeader = false;
  private boolean hasStackTrace = false;
  private boolean hasThreadSnapshots = false;
  private boolean hasTotalDeviceMemory = false;
  private boolean hasUserHasRootAccess = false;
  private EventHeader header = null;
  public String mobileApplicationName = null;
  private MobileHeader mobileHeader = null;
  private List<MobileApplicationLixTreatment> mobileLixTreatmentRecords = null;
  public String rawCrashData = null;
  private UserRequestHeader requestHeader = null;
  private List<MobileApplicationStackFrame> stackTrace = null;
  private List<MobileApplicationThreadSnapshot> threadSnapshots = null;
  private long totalDeviceMemory = 0L;
  private boolean userHasRootAccess = false;
  
  public final MobileApplicationErrorEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MobileApplicationErrorEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (applicationLogs != null)
    {
      paramFlavor = applicationLogs.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((String)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.MobileApplicationErrorEvent", "applicationLogs");
            if (!hasErrorType) {
              errorType = ErrorType.CRASH;
            }
            if (!hasApplicationBuildType) {
              applicationBuildType = ApplicationBuildType.UNKNOWN;
            }
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.MobileApplicationErrorEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.MobileApplicationErrorEvent", "requestHeader");
            }
            if (hasMobileHeader) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.MobileApplicationErrorEvent", "mobileHeader");
          }
        }
      }
    }
    if (crashHints != null)
    {
      paramFlavor = crashHints.iterator();
      while (paramFlavor.hasNext()) {
        if ((MobileApplicationCrashHint)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.MobileApplicationErrorEvent", "crashHints");
        }
      }
    }
    if (stackTrace != null)
    {
      paramFlavor = stackTrace.iterator();
      while (paramFlavor.hasNext()) {
        if ((MobileApplicationStackFrame)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.MobileApplicationErrorEvent", "stackTrace");
        }
      }
    }
    if (threadSnapshots != null)
    {
      paramFlavor = threadSnapshots.iterator();
      while (paramFlavor.hasNext()) {
        if ((MobileApplicationThreadSnapshot)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.MobileApplicationErrorEvent", "threadSnapshots");
        }
      }
    }
    if (mobileLixTreatmentRecords != null)
    {
      paramFlavor = mobileLixTreatmentRecords.iterator();
      while (paramFlavor.hasNext()) {
        if ((MobileApplicationLixTreatment)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.MobileApplicationErrorEvent", "mobileLixTreatmentRecords");
        }
      }
    }
    return new MobileApplicationErrorEvent(header, requestHeader, mobileHeader, mobileApplicationName, buildNumber, carrierName, deviceID, connectionType, rawCrashData, errorSummary, errorType, applicationBuildType, applicationLogs, crashHints, stackTrace, threadSnapshots, errorTimestamp, userHasRootAccess, appDistributionBuildVariant, deviceOrientation, applicationVisibilityStatus, batteryLevel, deviceLocale, availableDiskSpace, freeDeviceMemory, totalDeviceMemory, cpuArchitecture, mobileLixTreatmentRecords, hasHeader, hasRequestHeader, hasMobileHeader, hasMobileApplicationName, hasBuildNumber, hasCarrierName, hasDeviceID, hasConnectionType, hasRawCrashData, hasErrorSummary, hasErrorType, hasApplicationBuildType, hasApplicationLogs, hasCrashHints, hasStackTrace, hasThreadSnapshots, hasErrorTimestamp, hasUserHasRootAccess, hasAppDistributionBuildVariant, hasDeviceOrientation, hasApplicationVisibilityStatus, hasBatteryLevel, hasDeviceLocale, hasAvailableDiskSpace, hasFreeDeviceMemory, hasTotalDeviceMemory, hasCpuArchitecture, hasMobileLixTreatmentRecords);
  }
  
  public final Builder setHeader(EventHeader paramEventHeader)
  {
    if (paramEventHeader == null)
    {
      hasHeader = false;
      header = null;
      return this;
    }
    hasHeader = true;
    header = paramEventHeader;
    return this;
  }
  
  public final Builder setMobileHeader(MobileHeader paramMobileHeader)
  {
    if (paramMobileHeader == null)
    {
      hasMobileHeader = false;
      mobileHeader = null;
      return this;
    }
    hasMobileHeader = true;
    mobileHeader = paramMobileHeader;
    return this;
  }
  
  public final Builder setRequestHeader(UserRequestHeader paramUserRequestHeader)
  {
    if (paramUserRequestHeader == null)
    {
      hasRequestHeader = false;
      requestHeader = null;
      return this;
    }
    hasRequestHeader = true;
    requestHeader = paramUserRequestHeader;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.MobileApplicationErrorEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */