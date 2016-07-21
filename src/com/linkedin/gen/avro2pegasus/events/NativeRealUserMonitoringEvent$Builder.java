package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class NativeRealUserMonitoringEvent$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.NativeRealUserMonitoringEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */