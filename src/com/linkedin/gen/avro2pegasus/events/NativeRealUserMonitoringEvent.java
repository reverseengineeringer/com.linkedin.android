package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class NativeRealUserMonitoringEvent
  implements RecordTemplate<NativeRealUserMonitoringEvent>
{
  public static final NativeRealUserMonitoringEventBuilder BUILDER = NativeRealUserMonitoringEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String androidProcessId;
  public final long appColdLaunchDuration;
  public final long appLaunchStartTimestamp;
  public final long appWarmLaunchDuration;
  public final long cacheRenderDuration;
  public final long cacheRenderStartTimestamp;
  public final String carrierName;
  public final double carrierSignalStrength;
  public final long connectionDuration;
  public final long connectionStartTimestamp;
  public final String connectionType;
  public final int deviceClassYear;
  public final long domainLookupDuration;
  public final long domainLookupStartTimestamp;
  public final List<GranularMetrics> granularMetrics;
  public final boolean hasAndroidProcessId;
  public final boolean hasAppColdLaunchDuration;
  public final boolean hasAppLaunchStartTimestamp;
  public final boolean hasAppWarmLaunchDuration;
  public final boolean hasCacheRenderDuration;
  public final boolean hasCacheRenderStartTimestamp;
  public final boolean hasCarrierName;
  public final boolean hasCarrierSignalStrength;
  public final boolean hasConnectionDuration;
  public final boolean hasConnectionStartTimestamp;
  public final boolean hasConnectionType;
  public final boolean hasDeviceClassYear;
  public final boolean hasDomainLookupDuration;
  public final boolean hasDomainLookupStartTimestamp;
  public final boolean hasGranularMetrics;
  public final boolean hasHeader;
  public final boolean hasIsBackgroundTiming;
  public final boolean hasIsCrossLinked;
  public final boolean hasIsDeepLinked;
  public final boolean hasMobileHeader;
  public final boolean hasNetworkQuality;
  public final boolean hasNumberOfCores;
  public final boolean hasPageLoadStartTimestamp;
  public final boolean hasPointOfPresenceId;
  public final boolean hasRenderDuration;
  public final boolean hasRenderStartTimestamp;
  public final boolean hasRequestHeader;
  public final boolean hasRoamingCarrierName;
  public final boolean hasScreenDensity;
  public final boolean hasTotalDeviceMemory;
  public final boolean hasTotalFreeMemory;
  public final boolean hasTotalPageDuration;
  public final boolean hasTotalSessionMemoryUsage;
  public final boolean hasUploadNetworkQuality;
  public final boolean hasUserSessionId;
  public final boolean hasViewInteractiveTimestamp;
  public final EventHeader header;
  public final boolean isBackgroundTiming;
  public final CrossLinkValue isCrossLinked;
  public final DeepLinkValue isDeepLinked;
  public final MobileHeader mobileHeader;
  public final NetworkQuality networkQuality;
  public final int numberOfCores;
  public final long pageLoadStartTimestamp;
  public final String pointOfPresenceId;
  public final long renderDuration;
  public final long renderStartTimestamp;
  public final UserRequestHeader requestHeader;
  public final String roamingCarrierName;
  public final int screenDensity;
  public final long totalDeviceMemory;
  public final long totalFreeMemory;
  public final long totalPageDuration;
  public final long totalSessionMemoryUsage;
  public final UploadNetworkQuality uploadNetworkQuality;
  public final String userSessionId;
  public final long viewInteractiveTimestamp;
  
  NativeRealUserMonitoringEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, int paramInt1, int paramInt2, int paramInt3, long paramLong1, NetworkQuality paramNetworkQuality, DeepLinkValue paramDeepLinkValue, CrossLinkValue paramCrossLinkValue, String paramString1, String paramString2, String paramString3, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, long paramLong12, long paramLong13, long paramLong14, long paramLong15, long paramLong16, double paramDouble, String paramString4, String paramString5, long paramLong17, UploadNetworkQuality paramUploadNetworkQuality, List<GranularMetrics> paramList, boolean paramBoolean1, String paramString6, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17, boolean paramBoolean18, boolean paramBoolean19, boolean paramBoolean20, boolean paramBoolean21, boolean paramBoolean22, boolean paramBoolean23, boolean paramBoolean24, boolean paramBoolean25, boolean paramBoolean26, boolean paramBoolean27, boolean paramBoolean28, boolean paramBoolean29, boolean paramBoolean30, boolean paramBoolean31, boolean paramBoolean32, boolean paramBoolean33, boolean paramBoolean34, boolean paramBoolean35, boolean paramBoolean36, boolean paramBoolean37)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    numberOfCores = paramInt1;
    deviceClassYear = paramInt2;
    screenDensity = paramInt3;
    totalSessionMemoryUsage = paramLong1;
    networkQuality = paramNetworkQuality;
    isDeepLinked = paramDeepLinkValue;
    isCrossLinked = paramCrossLinkValue;
    carrierName = paramString1;
    userSessionId = paramString2;
    connectionType = paramString3;
    totalPageDuration = paramLong2;
    appLaunchStartTimestamp = paramLong3;
    appWarmLaunchDuration = paramLong4;
    appColdLaunchDuration = paramLong5;
    domainLookupStartTimestamp = paramLong6;
    domainLookupDuration = paramLong7;
    connectionStartTimestamp = paramLong8;
    connectionDuration = paramLong9;
    renderStartTimestamp = paramLong10;
    renderDuration = paramLong11;
    cacheRenderStartTimestamp = paramLong12;
    cacheRenderDuration = paramLong13;
    viewInteractiveTimestamp = paramLong14;
    totalFreeMemory = paramLong15;
    totalDeviceMemory = paramLong16;
    carrierSignalStrength = paramDouble;
    pointOfPresenceId = paramString4;
    roamingCarrierName = paramString5;
    pageLoadStartTimestamp = paramLong17;
    uploadNetworkQuality = paramUploadNetworkQuality;
    if (paramList == null) {}
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList))
    {
      granularMetrics = paramEventHeader;
      isBackgroundTiming = paramBoolean1;
      androidProcessId = paramString6;
      hasHeader = paramBoolean2;
      hasRequestHeader = paramBoolean3;
      hasMobileHeader = paramBoolean4;
      hasNumberOfCores = paramBoolean5;
      hasDeviceClassYear = paramBoolean6;
      hasScreenDensity = paramBoolean7;
      hasTotalSessionMemoryUsage = paramBoolean8;
      hasNetworkQuality = paramBoolean9;
      hasIsDeepLinked = paramBoolean10;
      hasIsCrossLinked = paramBoolean11;
      hasCarrierName = paramBoolean12;
      hasUserSessionId = paramBoolean13;
      hasConnectionType = paramBoolean14;
      hasTotalPageDuration = paramBoolean15;
      hasAppLaunchStartTimestamp = paramBoolean16;
      hasAppWarmLaunchDuration = paramBoolean17;
      hasAppColdLaunchDuration = paramBoolean18;
      hasDomainLookupStartTimestamp = paramBoolean19;
      hasDomainLookupDuration = paramBoolean20;
      hasConnectionStartTimestamp = paramBoolean21;
      hasConnectionDuration = paramBoolean22;
      hasRenderStartTimestamp = paramBoolean23;
      hasRenderDuration = paramBoolean24;
      hasCacheRenderStartTimestamp = paramBoolean25;
      hasCacheRenderDuration = paramBoolean26;
      hasViewInteractiveTimestamp = paramBoolean27;
      hasTotalFreeMemory = paramBoolean28;
      hasTotalDeviceMemory = paramBoolean29;
      hasCarrierSignalStrength = paramBoolean30;
      hasPointOfPresenceId = paramBoolean31;
      hasRoamingCarrierName = paramBoolean32;
      hasPageLoadStartTimestamp = paramBoolean33;
      hasUploadNetworkQuality = paramBoolean34;
      hasGranularMetrics = paramBoolean35;
      hasIsBackgroundTiming = paramBoolean36;
      hasAndroidProcessId = paramBoolean37;
      _cachedId = null;
      return;
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
      paramObject = (NativeRealUserMonitoringEvent)paramObject;
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
      if (numberOfCores != numberOfCores) {
        return false;
      }
      if (deviceClassYear != deviceClassYear) {
        return false;
      }
      if (screenDensity != screenDensity) {
        return false;
      }
      if (totalSessionMemoryUsage != totalSessionMemoryUsage) {
        return false;
      }
      if (networkQuality != null)
      {
        if (networkQuality.equals(networkQuality)) {}
      }
      else {
        while (networkQuality != null) {
          return false;
        }
      }
      if (isDeepLinked != null)
      {
        if (isDeepLinked.equals(isDeepLinked)) {}
      }
      else {
        while (isDeepLinked != null) {
          return false;
        }
      }
      if (isCrossLinked != null)
      {
        if (isCrossLinked.equals(isCrossLinked)) {}
      }
      else {
        while (isCrossLinked != null) {
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
      if (userSessionId != null)
      {
        if (userSessionId.equals(userSessionId)) {}
      }
      else {
        while (userSessionId != null) {
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
      if (totalPageDuration != totalPageDuration) {
        return false;
      }
      if (appLaunchStartTimestamp != appLaunchStartTimestamp) {
        return false;
      }
      if (appWarmLaunchDuration != appWarmLaunchDuration) {
        return false;
      }
      if (appColdLaunchDuration != appColdLaunchDuration) {
        return false;
      }
      if (domainLookupStartTimestamp != domainLookupStartTimestamp) {
        return false;
      }
      if (domainLookupDuration != domainLookupDuration) {
        return false;
      }
      if (connectionStartTimestamp != connectionStartTimestamp) {
        return false;
      }
      if (connectionDuration != connectionDuration) {
        return false;
      }
      if (renderStartTimestamp != renderStartTimestamp) {
        return false;
      }
      if (renderDuration != renderDuration) {
        return false;
      }
      if (cacheRenderStartTimestamp != cacheRenderStartTimestamp) {
        return false;
      }
      if (cacheRenderDuration != cacheRenderDuration) {
        return false;
      }
      if (viewInteractiveTimestamp != viewInteractiveTimestamp) {
        return false;
      }
      if (totalFreeMemory != totalFreeMemory) {
        return false;
      }
      if (totalDeviceMemory != totalDeviceMemory) {
        return false;
      }
      if (carrierSignalStrength != carrierSignalStrength) {
        return false;
      }
      if (pointOfPresenceId != null)
      {
        if (pointOfPresenceId.equals(pointOfPresenceId)) {}
      }
      else {
        while (pointOfPresenceId != null) {
          return false;
        }
      }
      if (roamingCarrierName != null)
      {
        if (roamingCarrierName.equals(roamingCarrierName)) {}
      }
      else {
        while (roamingCarrierName != null) {
          return false;
        }
      }
      if (pageLoadStartTimestamp != pageLoadStartTimestamp) {
        return false;
      }
      if (uploadNetworkQuality != null)
      {
        if (uploadNetworkQuality.equals(uploadNetworkQuality)) {}
      }
      else {
        while (uploadNetworkQuality != null) {
          return false;
        }
      }
      if (granularMetrics != null)
      {
        if (granularMetrics.equals(granularMetrics)) {}
      }
      else {
        while (granularMetrics != null) {
          return false;
        }
      }
      if (isBackgroundTiming != isBackgroundTiming) {
        return false;
      }
      if (androidProcessId == null) {
        break;
      }
    } while (androidProcessId.equals(androidProcessId));
    for (;;)
    {
      return false;
      if (androidProcessId == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i10 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int i11;
    int i12;
    int i13;
    int i14;
    int m;
    label109:
    int n;
    label125:
    int i1;
    label141:
    int i2;
    label157:
    int i3;
    label173:
    int i4;
    label189:
    int i15;
    int i16;
    int i17;
    int i18;
    int i19;
    int i20;
    int i21;
    int i22;
    int i23;
    int i24;
    int i25;
    int i26;
    int i27;
    int i28;
    int i29;
    int i30;
    int i5;
    label451:
    int i6;
    label467:
    int i31;
    int i7;
    label498:
    int i8;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label768;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label773;
      }
      k = mobileHeader.hashCode();
      i11 = numberOfCores;
      i12 = deviceClassYear;
      i13 = screenDensity;
      i14 = (int)(totalSessionMemoryUsage ^ totalSessionMemoryUsage >>> 32);
      if (networkQuality == null) {
        break label778;
      }
      m = networkQuality.hashCode();
      if (isDeepLinked == null) {
        break label784;
      }
      n = isDeepLinked.hashCode();
      if (isCrossLinked == null) {
        break label790;
      }
      i1 = isCrossLinked.hashCode();
      if (carrierName == null) {
        break label796;
      }
      i2 = carrierName.hashCode();
      if (userSessionId == null) {
        break label802;
      }
      i3 = userSessionId.hashCode();
      if (connectionType == null) {
        break label808;
      }
      i4 = connectionType.hashCode();
      i15 = (int)(totalPageDuration ^ totalPageDuration >>> 32);
      i16 = (int)(appLaunchStartTimestamp ^ appLaunchStartTimestamp >>> 32);
      i17 = (int)(appWarmLaunchDuration ^ appWarmLaunchDuration >>> 32);
      i18 = (int)(appColdLaunchDuration ^ appColdLaunchDuration >>> 32);
      i19 = (int)(domainLookupStartTimestamp ^ domainLookupStartTimestamp >>> 32);
      i20 = (int)(domainLookupDuration ^ domainLookupDuration >>> 32);
      i21 = (int)(connectionStartTimestamp ^ connectionStartTimestamp >>> 32);
      i22 = (int)(connectionDuration ^ connectionDuration >>> 32);
      i23 = (int)(renderStartTimestamp ^ renderStartTimestamp >>> 32);
      i24 = (int)(renderDuration ^ renderDuration >>> 32);
      i25 = (int)(cacheRenderStartTimestamp ^ cacheRenderStartTimestamp >>> 32);
      i26 = (int)(cacheRenderDuration ^ cacheRenderDuration >>> 32);
      i27 = (int)(viewInteractiveTimestamp ^ viewInteractiveTimestamp >>> 32);
      i28 = (int)(totalFreeMemory ^ totalFreeMemory >>> 32);
      i29 = (int)(totalDeviceMemory ^ totalDeviceMemory >>> 32);
      i30 = (int)(Double.doubleToLongBits(carrierSignalStrength) ^ Double.doubleToLongBits(carrierSignalStrength) >>> 32);
      if (pointOfPresenceId == null) {
        break label814;
      }
      i5 = pointOfPresenceId.hashCode();
      if (roamingCarrierName == null) {
        break label820;
      }
      i6 = roamingCarrierName.hashCode();
      i31 = (int)(pageLoadStartTimestamp ^ pageLoadStartTimestamp >>> 32);
      if (uploadNetworkQuality == null) {
        break label826;
      }
      i7 = uploadNetworkQuality.hashCode();
      if (granularMetrics == null) {
        break label832;
      }
      i8 = granularMetrics.hashCode();
      label516:
      if (!isBackgroundTiming) {
        break label838;
      }
    }
    label768:
    label773:
    label778:
    label784:
    label790:
    label796:
    label802:
    label808:
    label814:
    label820:
    label826:
    label832:
    label838:
    for (int i9 = 1;; i9 = 0)
    {
      if (androidProcessId != null) {
        i10 = androidProcessId.hashCode();
      }
      i = (i9 + (i8 + (i7 + ((i6 + (i5 + (((((((((((((((((i4 + (i3 + (i2 + (i1 + (n + (m + (((((k + (j + (i + 527) * 31) * 31) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i15) * 31 + i16) * 31 + i17) * 31 + i18) * 31 + i19) * 31 + i20) * 31 + i21) * 31 + i22) * 31 + i23) * 31 + i24) * 31 + i25) * 31 + i26) * 31 + i27) * 31 + i28) * 31 + i29) * 31 + i30) * 31) * 31) * 31 + i31) * 31) * 31) * 31) * 31 + i10;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label109;
      n = 0;
      break label125;
      i1 = 0;
      break label141;
      i2 = 0;
      break label157;
      i3 = 0;
      break label173;
      i4 = 0;
      break label189;
      i5 = 0;
      break label451;
      i6 = 0;
      break label467;
      i7 = 0;
      break label498;
      i8 = 0;
      break label516;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<NativeRealUserMonitoringEvent>
  {
    public String androidProcessId = null;
    public long appColdLaunchDuration = 0L;
    public long appLaunchStartTimestamp = 0L;
    public long appWarmLaunchDuration = 0L;
    public long cacheRenderDuration = 0L;
    private long cacheRenderStartTimestamp = 0L;
    public String carrierName = null;
    private double carrierSignalStrength = 0.0D;
    private long connectionDuration = 0L;
    private long connectionStartTimestamp = 0L;
    public String connectionType = null;
    public int deviceClassYear = 0;
    private long domainLookupDuration = 0L;
    private long domainLookupStartTimestamp = 0L;
    public List<GranularMetrics> granularMetrics = null;
    public boolean hasAndroidProcessId = false;
    public boolean hasAppColdLaunchDuration = false;
    public boolean hasAppLaunchStartTimestamp = false;
    public boolean hasAppWarmLaunchDuration = false;
    public boolean hasCacheRenderDuration = false;
    private boolean hasCacheRenderStartTimestamp = false;
    public boolean hasCarrierName = false;
    private boolean hasCarrierSignalStrength = false;
    private boolean hasConnectionDuration = false;
    private boolean hasConnectionStartTimestamp = false;
    public boolean hasConnectionType = false;
    public boolean hasDeviceClassYear = false;
    private boolean hasDomainLookupDuration = false;
    private boolean hasDomainLookupStartTimestamp = false;
    public boolean hasGranularMetrics = false;
    private boolean hasHeader = false;
    private boolean hasIsBackgroundTiming = false;
    private boolean hasIsCrossLinked = false;
    private boolean hasIsDeepLinked = false;
    private boolean hasMobileHeader = false;
    public boolean hasNetworkQuality = false;
    public boolean hasNumberOfCores = false;
    public boolean hasPageLoadStartTimestamp = false;
    public boolean hasPointOfPresenceId = false;
    public boolean hasRenderDuration = false;
    private boolean hasRenderStartTimestamp = false;
    private boolean hasRequestHeader = false;
    private boolean hasRoamingCarrierName = false;
    private boolean hasScreenDensity = false;
    private boolean hasTotalDeviceMemory = false;
    private boolean hasTotalFreeMemory = false;
    public boolean hasTotalPageDuration = false;
    private boolean hasTotalSessionMemoryUsage = false;
    private boolean hasUploadNetworkQuality = false;
    public boolean hasUserSessionId = false;
    private boolean hasViewInteractiveTimestamp = false;
    private EventHeader header = null;
    private boolean isBackgroundTiming = false;
    private CrossLinkValue isCrossLinked = null;
    private DeepLinkValue isDeepLinked = null;
    private MobileHeader mobileHeader = null;
    public NetworkQuality networkQuality = null;
    public int numberOfCores = 0;
    public long pageLoadStartTimestamp = 0L;
    public String pointOfPresenceId = null;
    public long renderDuration = 0L;
    private long renderStartTimestamp = 0L;
    private UserRequestHeader requestHeader = null;
    private String roamingCarrierName = null;
    private int screenDensity = 0;
    private long totalDeviceMemory = 0L;
    private long totalFreeMemory = 0L;
    public long totalPageDuration = 0L;
    private long totalSessionMemoryUsage = 0L;
    private UploadNetworkQuality uploadNetworkQuality = null;
    public String userSessionId = null;
    private long viewInteractiveTimestamp = 0L;
    
    private NativeRealUserMonitoringEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (NativeRealUserMonitoringEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (granularMetrics != null)
      {
        paramFlavor = granularMetrics.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((GranularMetrics)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.NativeRealUserMonitoringEvent", "granularMetrics");
              if (!hasHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.NativeRealUserMonitoringEvent", "header");
              }
              if (!hasRequestHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.NativeRealUserMonitoringEvent", "requestHeader");
              }
              if (hasMobileHeader) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.NativeRealUserMonitoringEvent", "mobileHeader");
            }
          }
        }
      }
      return new NativeRealUserMonitoringEvent(header, requestHeader, mobileHeader, numberOfCores, deviceClassYear, screenDensity, totalSessionMemoryUsage, networkQuality, isDeepLinked, isCrossLinked, carrierName, userSessionId, connectionType, totalPageDuration, appLaunchStartTimestamp, appWarmLaunchDuration, appColdLaunchDuration, domainLookupStartTimestamp, domainLookupDuration, connectionStartTimestamp, connectionDuration, renderStartTimestamp, renderDuration, cacheRenderStartTimestamp, cacheRenderDuration, viewInteractiveTimestamp, totalFreeMemory, totalDeviceMemory, carrierSignalStrength, pointOfPresenceId, roamingCarrierName, pageLoadStartTimestamp, uploadNetworkQuality, granularMetrics, isBackgroundTiming, androidProcessId, hasHeader, hasRequestHeader, hasMobileHeader, hasNumberOfCores, hasDeviceClassYear, hasScreenDensity, hasTotalSessionMemoryUsage, hasNetworkQuality, hasIsDeepLinked, hasIsCrossLinked, hasCarrierName, hasUserSessionId, hasConnectionType, hasTotalPageDuration, hasAppLaunchStartTimestamp, hasAppWarmLaunchDuration, hasAppColdLaunchDuration, hasDomainLookupStartTimestamp, hasDomainLookupDuration, hasConnectionStartTimestamp, hasConnectionDuration, hasRenderStartTimestamp, hasRenderDuration, hasCacheRenderStartTimestamp, hasCacheRenderDuration, hasViewInteractiveTimestamp, hasTotalFreeMemory, hasTotalDeviceMemory, hasCarrierSignalStrength, hasPointOfPresenceId, hasRoamingCarrierName, hasPageLoadStartTimestamp, hasUploadNetworkQuality, hasGranularMetrics, hasIsBackgroundTiming, hasAndroidProcessId);
    }
    
    public final Builder setCacheRenderStartTimestamp(Long paramLong)
    {
      if (paramLong == null)
      {
        hasCacheRenderStartTimestamp = false;
        cacheRenderStartTimestamp = 0L;
        return this;
      }
      hasCacheRenderStartTimestamp = true;
      cacheRenderStartTimestamp = paramLong.longValue();
      return this;
    }
    
    public final Builder setIsCrossLinked(CrossLinkValue paramCrossLinkValue)
    {
      if (paramCrossLinkValue == null)
      {
        hasIsCrossLinked = false;
        isCrossLinked = null;
        return this;
      }
      hasIsCrossLinked = true;
      isCrossLinked = paramCrossLinkValue;
      return this;
    }
    
    public final Builder setIsDeepLinked(DeepLinkValue paramDeepLinkValue)
    {
      if (paramDeepLinkValue == null)
      {
        hasIsDeepLinked = false;
        isDeepLinked = null;
        return this;
      }
      hasIsDeepLinked = true;
      isDeepLinked = paramDeepLinkValue;
      return this;
    }
    
    public final Builder setRenderStartTimestamp(Long paramLong)
    {
      if (paramLong == null)
      {
        hasRenderStartTimestamp = false;
        renderStartTimestamp = 0L;
        return this;
      }
      hasRenderStartTimestamp = true;
      renderStartTimestamp = paramLong.longValue();
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.NativeRealUserMonitoringEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */