package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class MobileApplicationErrorEventBuilder
  implements DataTemplateBuilder<MobileApplicationErrorEvent>
{
  public static final MobileApplicationErrorEventBuilder INSTANCE = new MobileApplicationErrorEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("header");
    JSON_KEY_STORE.put("requestHeader");
    JSON_KEY_STORE.put("mobileHeader");
    JSON_KEY_STORE.put("mobileApplicationName");
    JSON_KEY_STORE.put("buildNumber");
    JSON_KEY_STORE.put("carrierName");
    JSON_KEY_STORE.put("deviceID");
    JSON_KEY_STORE.put("connectionType");
    JSON_KEY_STORE.put("rawCrashData");
    JSON_KEY_STORE.put("errorSummary");
    JSON_KEY_STORE.put("errorType");
    JSON_KEY_STORE.put("applicationBuildType");
    JSON_KEY_STORE.put("applicationLogs");
    JSON_KEY_STORE.put("crashHints");
    JSON_KEY_STORE.put("stackTrace");
    JSON_KEY_STORE.put("threadSnapshots");
    JSON_KEY_STORE.put("errorTimestamp");
    JSON_KEY_STORE.put("userHasRootAccess");
    JSON_KEY_STORE.put("appDistributionBuildVariant");
    JSON_KEY_STORE.put("deviceOrientation");
    JSON_KEY_STORE.put("applicationVisibilityStatus");
    JSON_KEY_STORE.put("batteryLevel");
    JSON_KEY_STORE.put("deviceLocale");
    JSON_KEY_STORE.put("availableDiskSpace");
    JSON_KEY_STORE.put("freeDeviceMemory");
    JSON_KEY_STORE.put("totalDeviceMemory");
    JSON_KEY_STORE.put("cpuArchitecture");
    JSON_KEY_STORE.put("mobileLixTreatmentRecords");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.MobileApplicationErrorEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */