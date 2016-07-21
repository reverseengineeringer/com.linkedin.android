package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class GranularMetrics$Builder
  implements RecordTemplateBuilder<GranularMetrics>
{
  private long cacheModelBindingDuration = 0L;
  public long cacheModelBindingStartTimestamp = 0L;
  private long cachedParseDuration = 0L;
  public long cachedParseStartTimestamp = 0L;
  private double carrierSignalStrength = 0.0D;
  private long cellTowerId = 0L;
  public int connectionDropCount = 0;
  public long connectionDropDuration = 0L;
  private long connectionRefusedDuration = 0L;
  public long connectionStartTimestamp = 0L;
  public long connectionTimeoutDuration = 0L;
  public long diskCacheLookupDuration = 0L;
  public long diskCacheLookupStartTimestamp = 0L;
  private double dnsCacheHitRatio = 0.0D;
  public long dnsLookupDuration = 0L;
  public long dnsLookupStartTimestamp = 0L;
  private double downloadSpeed = 0.0D;
  private boolean hasCacheModelBindingDuration = false;
  public boolean hasCacheModelBindingStartTimestamp = false;
  private boolean hasCachedParseDuration = false;
  public boolean hasCachedParseStartTimestamp = false;
  private boolean hasCarrierSignalStrength = false;
  private boolean hasCellTowerId = false;
  public boolean hasConnectionDropCount = false;
  public boolean hasConnectionDropDuration = false;
  private boolean hasConnectionRefusedDuration = false;
  public boolean hasConnectionStartTimestamp = false;
  public boolean hasConnectionTimeoutDuration = false;
  public boolean hasDiskCacheLookupDuration = false;
  public boolean hasDiskCacheLookupStartTimestamp = false;
  private boolean hasDnsCacheHitRatio = false;
  public boolean hasDnsLookupDuration = false;
  public boolean hasDnsLookupStartTimestamp = false;
  private boolean hasDownloadSpeed = false;
  public boolean hasHttpStatusCode = false;
  public boolean hasImageDecodingDuration = false;
  public boolean hasImageDecodingStartTimestamp = false;
  public boolean hasImagePostprocessingDuration = false;
  public boolean hasImagePostprocessingStartTimestamp = false;
  private boolean hasIsCacheHit = false;
  private boolean hasIsConnectionPoolHit = false;
  private boolean hasIsTlsSessionCacheHit = false;
  private boolean hasLocationAreaCode = false;
  public boolean hasMemoryCacheLookupDuration = false;
  public boolean hasMemoryCacheLookupStartTimestamp = false;
  private boolean hasMobileCountryCode = false;
  private boolean hasMobileNetworkCode = false;
  public boolean hasModelBindingDuration = false;
  public boolean hasModelBindingStartTimestamp = false;
  public boolean hasNetworkRequestDuration = false;
  public boolean hasNetworkRequestStartTimestamp = false;
  public boolean hasNetworkTimeoutCount = false;
  private boolean hasPageLoadStartTimestamp = false;
  public boolean hasParseDuration = false;
  public boolean hasParseStartTimestamp = false;
  private boolean hasPointOfPresenceId = false;
  public boolean hasReceivedFirstByteTimestamp = false;
  public boolean hasRequestTreeId = false;
  public boolean hasRequestUrl = false;
  public boolean hasResponseSize = false;
  private boolean hasRoamingCarrierName = false;
  public boolean hasServerDuration = false;
  private boolean hasTlsHandshakeDuration = false;
  private boolean hasTlsHandshakeStartTimestamp = false;
  private boolean hasTotalDeviceMemory = false;
  private boolean hasTotalFreeMemory = false;
  private boolean hasUploadSpeed = false;
  public int httpStatusCode = 0;
  public long imageDecodingDuration = 0L;
  public long imageDecodingStartTimestamp = 0L;
  public long imagePostprocessingDuration = 0L;
  public long imagePostprocessingStartTimestamp = 0L;
  private isCacheHit isCacheHit = null;
  private boolean isConnectionPoolHit = false;
  private boolean isTlsSessionCacheHit = false;
  private int locationAreaCode = 0;
  public long memoryCacheLookupDuration = 0L;
  public long memoryCacheLookupStartTimestamp = 0L;
  private int mobileCountryCode = 0;
  private int mobileNetworkCode = 0;
  public long modelBindingDuration = 0L;
  public long modelBindingStartTimestamp = 0L;
  public long networkRequestDuration = 0L;
  public long networkRequestStartTimestamp = 0L;
  public int networkTimeoutCount = 0;
  private long pageLoadStartTimestamp = 0L;
  public long parseDuration = 0L;
  public long parseStartTimestamp = 0L;
  private String pointOfPresenceId = null;
  public long receivedFirstByteTimestamp = 0L;
  public String requestTreeId = null;
  public String requestUrl = null;
  public long responseSize = 0L;
  private String roamingCarrierName = null;
  public long serverDuration = 0L;
  private long tlsHandshakeDuration = 0L;
  private long tlsHandshakeStartTimestamp = 0L;
  private long totalDeviceMemory = 0L;
  private long totalFreeMemory = 0L;
  private double uploadSpeed = 0.0D;
  
  public final GranularMetrics build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    int[] arrayOfInt = GranularMetrics.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
    paramFlavor.ordinal();
    return new GranularMetrics(diskCacheLookupStartTimestamp, diskCacheLookupDuration, receivedFirstByteTimestamp, isCacheHit, memoryCacheLookupStartTimestamp, memoryCacheLookupDuration, networkRequestStartTimestamp, networkRequestDuration, modelBindingStartTimestamp, modelBindingDuration, cacheModelBindingStartTimestamp, cacheModelBindingDuration, parseStartTimestamp, parseDuration, cachedParseStartTimestamp, cachedParseDuration, serverDuration, httpStatusCode, responseSize, requestUrl, requestTreeId, networkTimeoutCount, connectionDropCount, dnsLookupStartTimestamp, dnsLookupDuration, dnsCacheHitRatio, imageDecodingStartTimestamp, imageDecodingDuration, imagePostprocessingStartTimestamp, imagePostprocessingDuration, totalFreeMemory, totalDeviceMemory, carrierSignalStrength, pointOfPresenceId, roamingCarrierName, pageLoadStartTimestamp, connectionStartTimestamp, connectionRefusedDuration, connectionTimeoutDuration, connectionDropDuration, tlsHandshakeStartTimestamp, tlsHandshakeDuration, isTlsSessionCacheHit, isConnectionPoolHit, uploadSpeed, downloadSpeed, locationAreaCode, mobileNetworkCode, mobileCountryCode, cellTowerId, hasDiskCacheLookupStartTimestamp, hasDiskCacheLookupDuration, hasReceivedFirstByteTimestamp, hasIsCacheHit, hasMemoryCacheLookupStartTimestamp, hasMemoryCacheLookupDuration, hasNetworkRequestStartTimestamp, hasNetworkRequestDuration, hasModelBindingStartTimestamp, hasModelBindingDuration, hasCacheModelBindingStartTimestamp, hasCacheModelBindingDuration, hasParseStartTimestamp, hasParseDuration, hasCachedParseStartTimestamp, hasCachedParseDuration, hasServerDuration, hasHttpStatusCode, hasResponseSize, hasRequestUrl, hasRequestTreeId, hasNetworkTimeoutCount, hasConnectionDropCount, hasDnsLookupStartTimestamp, hasDnsLookupDuration, hasDnsCacheHitRatio, hasImageDecodingStartTimestamp, hasImageDecodingDuration, hasImagePostprocessingStartTimestamp, hasImagePostprocessingDuration, hasTotalFreeMemory, hasTotalDeviceMemory, hasCarrierSignalStrength, hasPointOfPresenceId, hasRoamingCarrierName, hasPageLoadStartTimestamp, hasConnectionStartTimestamp, hasConnectionRefusedDuration, hasConnectionTimeoutDuration, hasConnectionDropDuration, hasTlsHandshakeStartTimestamp, hasTlsHandshakeDuration, hasIsTlsSessionCacheHit, hasIsConnectionPoolHit, hasUploadSpeed, hasDownloadSpeed, hasLocationAreaCode, hasMobileNetworkCode, hasMobileCountryCode, hasCellTowerId);
  }
  
  public final Builder setCachedParseDuration(Long paramLong)
  {
    if (paramLong == null)
    {
      hasCachedParseDuration = false;
      cachedParseDuration = 0L;
      return this;
    }
    hasCachedParseDuration = true;
    cachedParseDuration = paramLong.longValue();
    return this;
  }
  
  public final Builder setIsCacheHit(isCacheHit paramisCacheHit)
  {
    if (paramisCacheHit == null)
    {
      hasIsCacheHit = false;
      isCacheHit = null;
      return this;
    }
    hasIsCacheHit = true;
    isCacheHit = paramisCacheHit;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.GranularMetrics.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */