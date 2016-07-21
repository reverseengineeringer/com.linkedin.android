package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class NativeRealUserMonitoringEventBuilder
  implements DataTemplateBuilder<NativeRealUserMonitoringEvent>
{
  public static final NativeRealUserMonitoringEventBuilder INSTANCE = new NativeRealUserMonitoringEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("numberOfCores");
    JSON_KEY_STORE.put("deviceClassYear");
    JSON_KEY_STORE.put("screenDensity");
    JSON_KEY_STORE.put("totalSessionMemoryUsage");
    JSON_KEY_STORE.put("networkQuality");
    JSON_KEY_STORE.put("isDeepLinked");
    JSON_KEY_STORE.put("isCrossLinked");
    JSON_KEY_STORE.put("carrierName");
    JSON_KEY_STORE.put("userSessionId");
    JSON_KEY_STORE.put("connectionType");
    JSON_KEY_STORE.put("totalPageDuration");
    JSON_KEY_STORE.put("appLaunchStartTimestamp");
    JSON_KEY_STORE.put("appWarmLaunchDuration");
    JSON_KEY_STORE.put("appColdLaunchDuration");
    JSON_KEY_STORE.put("domainLookupStartTimestamp");
    JSON_KEY_STORE.put("domainLookupDuration");
    JSON_KEY_STORE.put("connectionStartTimestamp");
    JSON_KEY_STORE.put("connectionDuration");
    JSON_KEY_STORE.put("renderStartTimestamp");
    JSON_KEY_STORE.put("renderDuration");
    JSON_KEY_STORE.put("cacheRenderStartTimestamp");
    JSON_KEY_STORE.put("cacheRenderDuration");
    JSON_KEY_STORE.put("viewInteractiveTimestamp");
    JSON_KEY_STORE.put("totalFreeMemory");
    JSON_KEY_STORE.put("totalDeviceMemory");
    JSON_KEY_STORE.put("carrierSignalStrength");
    JSON_KEY_STORE.put("pointOfPresenceId");
    JSON_KEY_STORE.put("roamingCarrierName");
    JSON_KEY_STORE.put("pageLoadStartTimestamp");
    JSON_KEY_STORE.put("uploadNetworkQuality");
    JSON_KEY_STORE.put("granularMetrics");
    JSON_KEY_STORE.put("isBackgroundTiming");
    JSON_KEY_STORE.put("androidProcessId");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.NativeRealUserMonitoringEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */