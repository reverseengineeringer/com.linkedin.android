package com.conviva.protocol;

import com.conviva.api.player.PlayerStateManager.PlayerState;
import com.conviva.utils.SystemMetadata;
import java.util.HashMap;
import java.util.Map;

public final class Protocol
{
  public static String BACKEND_RESPONSE_NO_ERRORS = "ok";
  public static String DEFAULT_CLIENT_ID;
  public static String SDK_METADATA_SCHEMA = "sdk.android.1";
  public static String gatewayPath;
  public static Map<String, Integer> stateToInt = null;
  public static String version = "1.7";
  
  static
  {
    gatewayPath = "/0/wsg";
    DEFAULT_CLIENT_ID = "0";
  }
  
  public static Map<String, String> buildPlatformMetadata(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sch", SDK_METADATA_SCHEMA);
    if (paramMap.containsKey(SystemMetadata.ANROID_BUILD_MODEL)) {
      localHashMap.put("abm", paramMap.get(SystemMetadata.ANROID_BUILD_MODEL));
    }
    if (paramMap.containsKey(SystemMetadata.OPERATING_SYSTEM_VERSION)) {
      localHashMap.put("osv", paramMap.get(SystemMetadata.OPERATING_SYSTEM_VERSION));
    }
    if (paramMap.containsKey(SystemMetadata.DEVICE_BRAND)) {
      localHashMap.put("dvb", paramMap.get(SystemMetadata.DEVICE_BRAND));
    }
    if (paramMap.containsKey(SystemMetadata.DEVICE_MANUFACTURER)) {
      localHashMap.put("dvma", paramMap.get(SystemMetadata.DEVICE_MANUFACTURER));
    }
    if (paramMap.containsKey(SystemMetadata.DEVICE_MODEL)) {
      localHashMap.put("dvm", paramMap.get(SystemMetadata.DEVICE_MODEL));
    }
    if (paramMap.containsKey(SystemMetadata.DEVICE_TYPE)) {
      localHashMap.put("dvt", paramMap.get(SystemMetadata.DEVICE_TYPE));
    }
    if (paramMap.containsKey(SystemMetadata.DEVICE_VERSION)) {
      localHashMap.put("dvv", paramMap.get(SystemMetadata.DEVICE_VERSION));
    }
    if (paramMap.containsKey(SystemMetadata.FRAMEWORK_NAME)) {
      localHashMap.put("fw", paramMap.get(SystemMetadata.FRAMEWORK_NAME));
    }
    if (paramMap.containsKey(SystemMetadata.FRAMEWORK_VERSION)) {
      localHashMap.put("fwv", paramMap.get(SystemMetadata.FRAMEWORK_VERSION));
    }
    return localHashMap;
  }
  
  public static int convertPlayerState(PlayerStateManager.PlayerState paramPlayerState)
  {
    if (paramPlayerState == PlayerStateManager.PlayerState.STOPPED) {
      return 1;
    }
    if (paramPlayerState == PlayerStateManager.PlayerState.PLAYING) {
      return 3;
    }
    if (paramPlayerState == PlayerStateManager.PlayerState.BUFFERING) {
      return 6;
    }
    if (paramPlayerState == PlayerStateManager.PlayerState.PAUSED) {
      return 12;
    }
    if (paramPlayerState == PlayerStateManager.PlayerState.NOT_MONITORED) {
      return 98;
    }
    return 100;
  }
}

/* Location:
 * Qualified Name:     com.conviva.protocol.Protocol
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */