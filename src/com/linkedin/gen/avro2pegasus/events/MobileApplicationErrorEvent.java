package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.mobile.ApplicationVisibilityStatus;
import com.linkedin.gen.avro2pegasus.events.mobile.DeviceOrientation;
import com.linkedin.gen.avro2pegasus.events.mobile.MobileApplicationLixTreatment;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class MobileApplicationErrorEvent
  implements RecordTemplate<MobileApplicationErrorEvent>
{
  public static final MobileApplicationErrorEventBuilder BUILDER = MobileApplicationErrorEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String appDistributionBuildVariant;
  public final ApplicationBuildType applicationBuildType;
  public final List<String> applicationLogs;
  public final ApplicationVisibilityStatus applicationVisibilityStatus;
  public final long availableDiskSpace;
  public final double batteryLevel;
  public final String buildNumber;
  public final String carrierName;
  public final String connectionType;
  public final String cpuArchitecture;
  public final List<MobileApplicationCrashHint> crashHints;
  public final String deviceID;
  public final String deviceLocale;
  public final DeviceOrientation deviceOrientation;
  public final String errorSummary;
  public final long errorTimestamp;
  public final ErrorType errorType;
  public final long freeDeviceMemory;
  public final boolean hasAppDistributionBuildVariant;
  public final boolean hasApplicationBuildType;
  public final boolean hasApplicationLogs;
  public final boolean hasApplicationVisibilityStatus;
  public final boolean hasAvailableDiskSpace;
  public final boolean hasBatteryLevel;
  public final boolean hasBuildNumber;
  public final boolean hasCarrierName;
  public final boolean hasConnectionType;
  public final boolean hasCpuArchitecture;
  public final boolean hasCrashHints;
  public final boolean hasDeviceID;
  public final boolean hasDeviceLocale;
  public final boolean hasDeviceOrientation;
  public final boolean hasErrorSummary;
  public final boolean hasErrorTimestamp;
  public final boolean hasErrorType;
  public final boolean hasFreeDeviceMemory;
  public final boolean hasHeader;
  public final boolean hasMobileApplicationName;
  public final boolean hasMobileHeader;
  public final boolean hasMobileLixTreatmentRecords;
  public final boolean hasRawCrashData;
  public final boolean hasRequestHeader;
  public final boolean hasStackTrace;
  public final boolean hasThreadSnapshots;
  public final boolean hasTotalDeviceMemory;
  public final boolean hasUserHasRootAccess;
  public final EventHeader header;
  public final String mobileApplicationName;
  public final MobileHeader mobileHeader;
  public final List<MobileApplicationLixTreatment> mobileLixTreatmentRecords;
  public final String rawCrashData;
  public final UserRequestHeader requestHeader;
  public final List<MobileApplicationStackFrame> stackTrace;
  public final List<MobileApplicationThreadSnapshot> threadSnapshots;
  public final long totalDeviceMemory;
  public final boolean userHasRootAccess;
  
  MobileApplicationErrorEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, ErrorType paramErrorType, ApplicationBuildType paramApplicationBuildType, List<String> paramList, List<MobileApplicationCrashHint> paramList1, List<MobileApplicationStackFrame> paramList2, List<MobileApplicationThreadSnapshot> paramList3, long paramLong1, boolean paramBoolean1, String paramString8, DeviceOrientation paramDeviceOrientation, ApplicationVisibilityStatus paramApplicationVisibilityStatus, double paramDouble, String paramString9, long paramLong2, long paramLong3, long paramLong4, String paramString10, List<MobileApplicationLixTreatment> paramList4, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17, boolean paramBoolean18, boolean paramBoolean19, boolean paramBoolean20, boolean paramBoolean21, boolean paramBoolean22, boolean paramBoolean23, boolean paramBoolean24, boolean paramBoolean25, boolean paramBoolean26, boolean paramBoolean27, boolean paramBoolean28, boolean paramBoolean29)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    mobileApplicationName = paramString1;
    buildNumber = paramString2;
    carrierName = paramString3;
    deviceID = paramString4;
    connectionType = paramString5;
    rawCrashData = paramString6;
    errorSummary = paramString7;
    errorType = paramErrorType;
    applicationBuildType = paramApplicationBuildType;
    if (paramList == null)
    {
      paramEventHeader = null;
      applicationLogs = paramEventHeader;
      if (paramList1 != null) {
        break label387;
      }
      paramEventHeader = null;
      label97:
      crashHints = paramEventHeader;
      if (paramList2 != null) {
        break label396;
      }
      paramEventHeader = null;
      label109:
      stackTrace = paramEventHeader;
      if (paramList3 != null) {
        break label405;
      }
      paramEventHeader = null;
      label121:
      threadSnapshots = paramEventHeader;
      errorTimestamp = paramLong1;
      userHasRootAccess = paramBoolean1;
      appDistributionBuildVariant = paramString8;
      deviceOrientation = paramDeviceOrientation;
      applicationVisibilityStatus = paramApplicationVisibilityStatus;
      batteryLevel = paramDouble;
      deviceLocale = paramString9;
      availableDiskSpace = paramLong2;
      freeDeviceMemory = paramLong3;
      totalDeviceMemory = paramLong4;
      cpuArchitecture = paramString10;
      if (paramList4 != null) {
        break label414;
      }
    }
    label387:
    label396:
    label405:
    label414:
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList4))
    {
      mobileLixTreatmentRecords = paramEventHeader;
      hasHeader = paramBoolean2;
      hasRequestHeader = paramBoolean3;
      hasMobileHeader = paramBoolean4;
      hasMobileApplicationName = paramBoolean5;
      hasBuildNumber = paramBoolean6;
      hasCarrierName = paramBoolean7;
      hasDeviceID = paramBoolean8;
      hasConnectionType = paramBoolean9;
      hasRawCrashData = paramBoolean10;
      hasErrorSummary = paramBoolean11;
      hasErrorType = paramBoolean12;
      hasApplicationBuildType = paramBoolean13;
      hasApplicationLogs = paramBoolean14;
      hasCrashHints = paramBoolean15;
      hasStackTrace = paramBoolean16;
      hasThreadSnapshots = paramBoolean17;
      hasErrorTimestamp = paramBoolean18;
      hasUserHasRootAccess = paramBoolean19;
      hasAppDistributionBuildVariant = paramBoolean20;
      hasDeviceOrientation = paramBoolean21;
      hasApplicationVisibilityStatus = paramBoolean22;
      hasBatteryLevel = paramBoolean23;
      hasDeviceLocale = paramBoolean24;
      hasAvailableDiskSpace = paramBoolean25;
      hasFreeDeviceMemory = paramBoolean26;
      hasTotalDeviceMemory = paramBoolean27;
      hasCpuArchitecture = paramBoolean28;
      hasMobileLixTreatmentRecords = paramBoolean29;
      _cachedId = null;
      return;
      paramEventHeader = Collections.unmodifiableList(paramList);
      break;
      paramEventHeader = Collections.unmodifiableList(paramList1);
      break label97;
      paramEventHeader = Collections.unmodifiableList(paramList2);
      break label109;
      paramEventHeader = Collections.unmodifiableList(paramList3);
      break label121;
    }
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
      paramObject = (MobileApplicationErrorEvent)paramObject;
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (requestHeader != null)
      {
        if (requestHeader.equals(requestHeader)) {}
      }
      else {
        while (requestHeader != null) {
          return false;
        }
      }
      if (mobileHeader != null)
      {
        if (mobileHeader.equals(mobileHeader)) {}
      }
      else {
        while (mobileHeader != null) {
          return false;
        }
      }
      if (mobileApplicationName != null)
      {
        if (mobileApplicationName.equals(mobileApplicationName)) {}
      }
      else {
        while (mobileApplicationName != null) {
          return false;
        }
      }
      if (buildNumber != null)
      {
        if (buildNumber.equals(buildNumber)) {}
      }
      else {
        while (buildNumber != null) {
          return false;
        }
      }
      if (carrierName != null)
      {
        if (carrierName.equals(carrierName)) {}
      }
      else {
        while (carrierName != null) {
          return false;
        }
      }
      if (deviceID != null)
      {
        if (deviceID.equals(deviceID)) {}
      }
      else {
        while (deviceID != null) {
          return false;
        }
      }
      if (connectionType != null)
      {
        if (connectionType.equals(connectionType)) {}
      }
      else {
        while (connectionType != null) {
          return false;
        }
      }
      if (rawCrashData != null)
      {
        if (rawCrashData.equals(rawCrashData)) {}
      }
      else {
        while (rawCrashData != null) {
          return false;
        }
      }
      if (errorSummary != null)
      {
        if (errorSummary.equals(errorSummary)) {}
      }
      else {
        while (errorSummary != null) {
          return false;
        }
      }
      if (errorType != null)
      {
        if (errorType.equals(errorType)) {}
      }
      else {
        while (errorType != null) {
          return false;
        }
      }
      if (applicationBuildType != null)
      {
        if (applicationBuildType.equals(applicationBuildType)) {}
      }
      else {
        while (applicationBuildType != null) {
          return false;
        }
      }
      if (applicationLogs != null)
      {
        if (applicationLogs.equals(applicationLogs)) {}
      }
      else {
        while (applicationLogs != null) {
          return false;
        }
      }
      if (crashHints != null)
      {
        if (crashHints.equals(crashHints)) {}
      }
      else {
        while (crashHints != null) {
          return false;
        }
      }
      if (stackTrace != null)
      {
        if (stackTrace.equals(stackTrace)) {}
      }
      else {
        while (stackTrace != null) {
          return false;
        }
      }
      if (threadSnapshots != null)
      {
        if (threadSnapshots.equals(threadSnapshots)) {}
      }
      else {
        while (threadSnapshots != null) {
          return false;
        }
      }
      if (errorTimestamp != errorTimestamp) {
        return false;
      }
      if (userHasRootAccess != userHasRootAccess) {
        return false;
      }
      if (appDistributionBuildVariant != null)
      {
        if (appDistributionBuildVariant.equals(appDistributionBuildVariant)) {}
      }
      else {
        while (appDistributionBuildVariant != null) {
          return false;
        }
      }
      if (deviceOrientation != null)
      {
        if (deviceOrientation.equals(deviceOrientation)) {}
      }
      else {
        while (deviceOrientation != null) {
          return false;
        }
      }
      if (applicationVisibilityStatus != null)
      {
        if (applicationVisibilityStatus.equals(applicationVisibilityStatus)) {}
      }
      else {
        while (applicationVisibilityStatus != null) {
          return false;
        }
      }
      if (batteryLevel != batteryLevel) {
        return false;
      }
      if (deviceLocale != null)
      {
        if (deviceLocale.equals(deviceLocale)) {}
      }
      else {
        while (deviceLocale != null) {
          return false;
        }
      }
      if (availableDiskSpace != availableDiskSpace) {
        return false;
      }
      if (freeDeviceMemory != freeDeviceMemory) {
        return false;
      }
      if (totalDeviceMemory != totalDeviceMemory) {
        return false;
      }
      if (cpuArchitecture != null)
      {
        if (cpuArchitecture.equals(cpuArchitecture)) {}
      }
      else {
        while (cpuArchitecture != null) {
          return false;
        }
      }
      if (mobileLixTreatmentRecords == null) {
        break;
      }
    } while (mobileLixTreatmentRecords.equals(mobileLixTreatmentRecords));
    for (;;)
    {
      return false;
      if (mobileLixTreatmentRecords == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i18 = 0;
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
    label92:
    int i1;
    label108:
    int i2;
    label124:
    int i3;
    label140:
    int i4;
    label156:
    int i5;
    label172:
    int i6;
    label188:
    int i7;
    label204:
    int i8;
    label222:
    int i9;
    label240:
    int i10;
    label258:
    int i11;
    label276:
    int i19;
    int i12;
    label301:
    int i13;
    label317:
    int i14;
    label333:
    int i15;
    label349:
    int i20;
    int i16;
    label386:
    int i21;
    int i22;
    int i23;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label643;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label648;
      }
      k = mobileHeader.hashCode();
      if (mobileApplicationName == null) {
        break label653;
      }
      m = mobileApplicationName.hashCode();
      if (buildNumber == null) {
        break label659;
      }
      n = buildNumber.hashCode();
      if (carrierName == null) {
        break label665;
      }
      i1 = carrierName.hashCode();
      if (deviceID == null) {
        break label671;
      }
      i2 = deviceID.hashCode();
      if (connectionType == null) {
        break label677;
      }
      i3 = connectionType.hashCode();
      if (rawCrashData == null) {
        break label683;
      }
      i4 = rawCrashData.hashCode();
      if (errorSummary == null) {
        break label689;
      }
      i5 = errorSummary.hashCode();
      if (errorType == null) {
        break label695;
      }
      i6 = errorType.hashCode();
      if (applicationBuildType == null) {
        break label701;
      }
      i7 = applicationBuildType.hashCode();
      if (applicationLogs == null) {
        break label707;
      }
      i8 = applicationLogs.hashCode();
      if (crashHints == null) {
        break label713;
      }
      i9 = crashHints.hashCode();
      if (stackTrace == null) {
        break label719;
      }
      i10 = stackTrace.hashCode();
      if (threadSnapshots == null) {
        break label725;
      }
      i11 = threadSnapshots.hashCode();
      i19 = (int)(errorTimestamp ^ errorTimestamp >>> 32);
      if (!userHasRootAccess) {
        break label731;
      }
      i12 = 1;
      if (appDistributionBuildVariant == null) {
        break label737;
      }
      i13 = appDistributionBuildVariant.hashCode();
      if (deviceOrientation == null) {
        break label743;
      }
      i14 = deviceOrientation.hashCode();
      if (applicationVisibilityStatus == null) {
        break label749;
      }
      i15 = applicationVisibilityStatus.hashCode();
      i20 = (int)(Double.doubleToLongBits(batteryLevel) ^ Double.doubleToLongBits(batteryLevel) >>> 32);
      if (deviceLocale == null) {
        break label755;
      }
      i16 = deviceLocale.hashCode();
      i21 = (int)(availableDiskSpace ^ availableDiskSpace >>> 32);
      i22 = (int)(freeDeviceMemory ^ freeDeviceMemory >>> 32);
      i23 = (int)(totalDeviceMemory ^ totalDeviceMemory >>> 32);
      if (cpuArchitecture == null) {
        break label761;
      }
    }
    label643:
    label648:
    label653:
    label659:
    label665:
    label671:
    label677:
    label683:
    label689:
    label695:
    label701:
    label707:
    label713:
    label719:
    label725:
    label731:
    label737:
    label743:
    label749:
    label755:
    label761:
    for (int i17 = cpuArchitecture.hashCode();; i17 = 0)
    {
      if (mobileLixTreatmentRecords != null) {
        i18 = mobileLixTreatmentRecords.hashCode();
      }
      i = (i17 + ((((i16 + ((i15 + (i14 + (i13 + (i12 + ((i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i19) * 31) * 31) * 31) * 31) * 31 + i20) * 31) * 31 + i21) * 31 + i22) * 31 + i23) * 31) * 31 + i18;
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
      i1 = 0;
      break label108;
      i2 = 0;
      break label124;
      i3 = 0;
      break label140;
      i4 = 0;
      break label156;
      i5 = 0;
      break label172;
      i6 = 0;
      break label188;
      i7 = 0;
      break label204;
      i8 = 0;
      break label222;
      i9 = 0;
      break label240;
      i10 = 0;
      break label258;
      i11 = 0;
      break label276;
      i12 = 0;
      break label301;
      i13 = 0;
      break label317;
      i14 = 0;
      break label333;
      i15 = 0;
      break label349;
      i16 = 0;
      break label386;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.MobileApplicationErrorEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */