package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class GranularMetrics
  implements RecordTemplate<GranularMetrics>
{
  public static final GranularMetricsBuilder BUILDER = GranularMetricsBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final long cacheModelBindingDuration;
  public final long cacheModelBindingStartTimestamp;
  public final long cachedParseDuration;
  public final long cachedParseStartTimestamp;
  public final double carrierSignalStrength;
  public final long cellTowerId;
  public final int connectionDropCount;
  public final long connectionDropDuration;
  public final long connectionRefusedDuration;
  public final long connectionStartTimestamp;
  public final long connectionTimeoutDuration;
  public final long diskCacheLookupDuration;
  public final long diskCacheLookupStartTimestamp;
  public final double dnsCacheHitRatio;
  public final long dnsLookupDuration;
  public final long dnsLookupStartTimestamp;
  public final double downloadSpeed;
  public final boolean hasCacheModelBindingDuration;
  public final boolean hasCacheModelBindingStartTimestamp;
  public final boolean hasCachedParseDuration;
  public final boolean hasCachedParseStartTimestamp;
  public final boolean hasCarrierSignalStrength;
  public final boolean hasCellTowerId;
  public final boolean hasConnectionDropCount;
  public final boolean hasConnectionDropDuration;
  public final boolean hasConnectionRefusedDuration;
  public final boolean hasConnectionStartTimestamp;
  public final boolean hasConnectionTimeoutDuration;
  public final boolean hasDiskCacheLookupDuration;
  public final boolean hasDiskCacheLookupStartTimestamp;
  public final boolean hasDnsCacheHitRatio;
  public final boolean hasDnsLookupDuration;
  public final boolean hasDnsLookupStartTimestamp;
  public final boolean hasDownloadSpeed;
  public final boolean hasHttpStatusCode;
  public final boolean hasImageDecodingDuration;
  public final boolean hasImageDecodingStartTimestamp;
  public final boolean hasImagePostprocessingDuration;
  public final boolean hasImagePostprocessingStartTimestamp;
  public final boolean hasIsCacheHit;
  public final boolean hasIsConnectionPoolHit;
  public final boolean hasIsTlsSessionCacheHit;
  public final boolean hasLocationAreaCode;
  public final boolean hasMemoryCacheLookupDuration;
  public final boolean hasMemoryCacheLookupStartTimestamp;
  public final boolean hasMobileCountryCode;
  public final boolean hasMobileNetworkCode;
  public final boolean hasModelBindingDuration;
  public final boolean hasModelBindingStartTimestamp;
  public final boolean hasNetworkRequestDuration;
  public final boolean hasNetworkRequestStartTimestamp;
  public final boolean hasNetworkTimeoutCount;
  public final boolean hasPageLoadStartTimestamp;
  public final boolean hasParseDuration;
  public final boolean hasParseStartTimestamp;
  public final boolean hasPointOfPresenceId;
  public final boolean hasReceivedFirstByteTimestamp;
  public final boolean hasRequestTreeId;
  public final boolean hasRequestUrl;
  public final boolean hasResponseSize;
  public final boolean hasRoamingCarrierName;
  public final boolean hasServerDuration;
  public final boolean hasTlsHandshakeDuration;
  public final boolean hasTlsHandshakeStartTimestamp;
  public final boolean hasTotalDeviceMemory;
  public final boolean hasTotalFreeMemory;
  public final boolean hasUploadSpeed;
  public final int httpStatusCode;
  public final long imageDecodingDuration;
  public final long imageDecodingStartTimestamp;
  public final long imagePostprocessingDuration;
  public final long imagePostprocessingStartTimestamp;
  public final isCacheHit isCacheHit;
  public final boolean isConnectionPoolHit;
  public final boolean isTlsSessionCacheHit;
  public final int locationAreaCode;
  public final long memoryCacheLookupDuration;
  public final long memoryCacheLookupStartTimestamp;
  public final int mobileCountryCode;
  public final int mobileNetworkCode;
  public final long modelBindingDuration;
  public final long modelBindingStartTimestamp;
  public final long networkRequestDuration;
  public final long networkRequestStartTimestamp;
  public final int networkTimeoutCount;
  public final long pageLoadStartTimestamp;
  public final long parseDuration;
  public final long parseStartTimestamp;
  public final String pointOfPresenceId;
  public final long receivedFirstByteTimestamp;
  public final String requestTreeId;
  public final String requestUrl;
  public final long responseSize;
  public final String roamingCarrierName;
  public final long serverDuration;
  public final long tlsHandshakeDuration;
  public final long tlsHandshakeStartTimestamp;
  public final long totalDeviceMemory;
  public final long totalFreeMemory;
  public final double uploadSpeed;
  
  GranularMetrics(long paramLong1, long paramLong2, long paramLong3, isCacheHit paramisCacheHit, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, long paramLong12, long paramLong13, long paramLong14, long paramLong15, long paramLong16, int paramInt1, long paramLong17, String paramString1, String paramString2, int paramInt2, int paramInt3, long paramLong18, long paramLong19, double paramDouble1, long paramLong20, long paramLong21, long paramLong22, long paramLong23, long paramLong24, long paramLong25, double paramDouble2, String paramString3, String paramString4, long paramLong26, long paramLong27, long paramLong28, long paramLong29, long paramLong30, long paramLong31, long paramLong32, boolean paramBoolean1, boolean paramBoolean2, double paramDouble3, double paramDouble4, int paramInt4, int paramInt5, int paramInt6, long paramLong33, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17, boolean paramBoolean18, boolean paramBoolean19, boolean paramBoolean20, boolean paramBoolean21, boolean paramBoolean22, boolean paramBoolean23, boolean paramBoolean24, boolean paramBoolean25, boolean paramBoolean26, boolean paramBoolean27, boolean paramBoolean28, boolean paramBoolean29, boolean paramBoolean30, boolean paramBoolean31, boolean paramBoolean32, boolean paramBoolean33, boolean paramBoolean34, boolean paramBoolean35, boolean paramBoolean36, boolean paramBoolean37, boolean paramBoolean38, boolean paramBoolean39, boolean paramBoolean40, boolean paramBoolean41, boolean paramBoolean42, boolean paramBoolean43, boolean paramBoolean44, boolean paramBoolean45, boolean paramBoolean46, boolean paramBoolean47, boolean paramBoolean48, boolean paramBoolean49, boolean paramBoolean50, boolean paramBoolean51, boolean paramBoolean52)
  {
    diskCacheLookupStartTimestamp = paramLong1;
    diskCacheLookupDuration = paramLong2;
    receivedFirstByteTimestamp = paramLong3;
    isCacheHit = paramisCacheHit;
    memoryCacheLookupStartTimestamp = paramLong4;
    memoryCacheLookupDuration = paramLong5;
    networkRequestStartTimestamp = paramLong6;
    networkRequestDuration = paramLong7;
    modelBindingStartTimestamp = paramLong8;
    modelBindingDuration = paramLong9;
    cacheModelBindingStartTimestamp = paramLong10;
    cacheModelBindingDuration = paramLong11;
    parseStartTimestamp = paramLong12;
    parseDuration = paramLong13;
    cachedParseStartTimestamp = paramLong14;
    cachedParseDuration = paramLong15;
    serverDuration = paramLong16;
    httpStatusCode = paramInt1;
    responseSize = paramLong17;
    requestUrl = paramString1;
    requestTreeId = paramString2;
    networkTimeoutCount = paramInt2;
    connectionDropCount = paramInt3;
    dnsLookupStartTimestamp = paramLong18;
    dnsLookupDuration = paramLong19;
    dnsCacheHitRatio = paramDouble1;
    imageDecodingStartTimestamp = paramLong20;
    imageDecodingDuration = paramLong21;
    imagePostprocessingStartTimestamp = paramLong22;
    imagePostprocessingDuration = paramLong23;
    totalFreeMemory = paramLong24;
    totalDeviceMemory = paramLong25;
    carrierSignalStrength = paramDouble2;
    pointOfPresenceId = paramString3;
    roamingCarrierName = paramString4;
    pageLoadStartTimestamp = paramLong26;
    connectionStartTimestamp = paramLong27;
    connectionRefusedDuration = paramLong28;
    connectionTimeoutDuration = paramLong29;
    connectionDropDuration = paramLong30;
    tlsHandshakeStartTimestamp = paramLong31;
    tlsHandshakeDuration = paramLong32;
    isTlsSessionCacheHit = paramBoolean1;
    isConnectionPoolHit = paramBoolean2;
    uploadSpeed = paramDouble3;
    downloadSpeed = paramDouble4;
    locationAreaCode = paramInt4;
    mobileNetworkCode = paramInt5;
    mobileCountryCode = paramInt6;
    cellTowerId = paramLong33;
    hasDiskCacheLookupStartTimestamp = paramBoolean3;
    hasDiskCacheLookupDuration = paramBoolean4;
    hasReceivedFirstByteTimestamp = paramBoolean5;
    hasIsCacheHit = paramBoolean6;
    hasMemoryCacheLookupStartTimestamp = paramBoolean7;
    hasMemoryCacheLookupDuration = paramBoolean8;
    hasNetworkRequestStartTimestamp = paramBoolean9;
    hasNetworkRequestDuration = paramBoolean10;
    hasModelBindingStartTimestamp = paramBoolean11;
    hasModelBindingDuration = paramBoolean12;
    hasCacheModelBindingStartTimestamp = paramBoolean13;
    hasCacheModelBindingDuration = paramBoolean14;
    hasParseStartTimestamp = paramBoolean15;
    hasParseDuration = paramBoolean16;
    hasCachedParseStartTimestamp = paramBoolean17;
    hasCachedParseDuration = paramBoolean18;
    hasServerDuration = paramBoolean19;
    hasHttpStatusCode = paramBoolean20;
    hasResponseSize = paramBoolean21;
    hasRequestUrl = paramBoolean22;
    hasRequestTreeId = paramBoolean23;
    hasNetworkTimeoutCount = paramBoolean24;
    hasConnectionDropCount = paramBoolean25;
    hasDnsLookupStartTimestamp = paramBoolean26;
    hasDnsLookupDuration = paramBoolean27;
    hasDnsCacheHitRatio = paramBoolean28;
    hasImageDecodingStartTimestamp = paramBoolean29;
    hasImageDecodingDuration = paramBoolean30;
    hasImagePostprocessingStartTimestamp = paramBoolean31;
    hasImagePostprocessingDuration = paramBoolean32;
    hasTotalFreeMemory = paramBoolean33;
    hasTotalDeviceMemory = paramBoolean34;
    hasCarrierSignalStrength = paramBoolean35;
    hasPointOfPresenceId = paramBoolean36;
    hasRoamingCarrierName = paramBoolean37;
    hasPageLoadStartTimestamp = paramBoolean38;
    hasConnectionStartTimestamp = paramBoolean39;
    hasConnectionRefusedDuration = paramBoolean40;
    hasConnectionTimeoutDuration = paramBoolean41;
    hasConnectionDropDuration = paramBoolean42;
    hasTlsHandshakeStartTimestamp = paramBoolean43;
    hasTlsHandshakeDuration = paramBoolean44;
    hasIsTlsSessionCacheHit = paramBoolean45;
    hasIsConnectionPoolHit = paramBoolean46;
    hasUploadSpeed = paramBoolean47;
    hasDownloadSpeed = paramBoolean48;
    hasLocationAreaCode = paramBoolean49;
    hasMobileNetworkCode = paramBoolean50;
    hasMobileCountryCode = paramBoolean51;
    hasCellTowerId = paramBoolean52;
    _cachedId = null;
  }
  
  public final GranularMetrics accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasDiskCacheLookupStartTimestamp)
    {
      paramDataProcessor.startRecordField$505cff1c("diskCacheLookupStartTimestamp");
      paramDataProcessor.processLong(diskCacheLookupStartTimestamp);
    }
    if (hasDiskCacheLookupDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("diskCacheLookupDuration");
      paramDataProcessor.processLong(diskCacheLookupDuration);
    }
    if (hasReceivedFirstByteTimestamp)
    {
      paramDataProcessor.startRecordField$505cff1c("receivedFirstByteTimestamp");
      paramDataProcessor.processLong(receivedFirstByteTimestamp);
    }
    if (hasIsCacheHit)
    {
      paramDataProcessor.startRecordField$505cff1c("isCacheHit");
      paramDataProcessor.processEnum(isCacheHit);
    }
    if (hasMemoryCacheLookupStartTimestamp)
    {
      paramDataProcessor.startRecordField$505cff1c("memoryCacheLookupStartTimestamp");
      paramDataProcessor.processLong(memoryCacheLookupStartTimestamp);
    }
    if (hasMemoryCacheLookupDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("memoryCacheLookupDuration");
      paramDataProcessor.processLong(memoryCacheLookupDuration);
    }
    if (hasNetworkRequestStartTimestamp)
    {
      paramDataProcessor.startRecordField$505cff1c("networkRequestStartTimestamp");
      paramDataProcessor.processLong(networkRequestStartTimestamp);
    }
    if (hasNetworkRequestDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("networkRequestDuration");
      paramDataProcessor.processLong(networkRequestDuration);
    }
    if (hasModelBindingStartTimestamp)
    {
      paramDataProcessor.startRecordField$505cff1c("modelBindingStartTimestamp");
      paramDataProcessor.processLong(modelBindingStartTimestamp);
    }
    if (hasModelBindingDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("modelBindingDuration");
      paramDataProcessor.processLong(modelBindingDuration);
    }
    if (hasCacheModelBindingStartTimestamp)
    {
      paramDataProcessor.startRecordField$505cff1c("cacheModelBindingStartTimestamp");
      paramDataProcessor.processLong(cacheModelBindingStartTimestamp);
    }
    if (hasCacheModelBindingDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("cacheModelBindingDuration");
      paramDataProcessor.processLong(cacheModelBindingDuration);
    }
    if (hasParseStartTimestamp)
    {
      paramDataProcessor.startRecordField$505cff1c("parseStartTimestamp");
      paramDataProcessor.processLong(parseStartTimestamp);
    }
    if (hasParseDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("parseDuration");
      paramDataProcessor.processLong(parseDuration);
    }
    if (hasCachedParseStartTimestamp)
    {
      paramDataProcessor.startRecordField$505cff1c("cachedParseStartTimestamp");
      paramDataProcessor.processLong(cachedParseStartTimestamp);
    }
    if (hasCachedParseDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("cachedParseDuration");
      paramDataProcessor.processLong(cachedParseDuration);
    }
    if (hasServerDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("serverDuration");
      paramDataProcessor.processLong(serverDuration);
    }
    if (hasHttpStatusCode)
    {
      paramDataProcessor.startRecordField$505cff1c("httpStatusCode");
      paramDataProcessor.processInt(httpStatusCode);
    }
    if (hasResponseSize)
    {
      paramDataProcessor.startRecordField$505cff1c("responseSize");
      paramDataProcessor.processLong(responseSize);
    }
    if (hasRequestUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("requestUrl");
      paramDataProcessor.processString(requestUrl);
    }
    if (hasRequestTreeId)
    {
      paramDataProcessor.startRecordField$505cff1c("requestTreeId");
      BytesCoercer localBytesCoercer = BytesCoercer.INSTANCE;
      paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(requestTreeId));
    }
    if (hasNetworkTimeoutCount)
    {
      paramDataProcessor.startRecordField$505cff1c("networkTimeoutCount");
      paramDataProcessor.processInt(networkTimeoutCount);
    }
    if (hasConnectionDropCount)
    {
      paramDataProcessor.startRecordField$505cff1c("connectionDropCount");
      paramDataProcessor.processInt(connectionDropCount);
    }
    if (hasDnsLookupStartTimestamp)
    {
      paramDataProcessor.startRecordField$505cff1c("dnsLookupStartTimestamp");
      paramDataProcessor.processLong(dnsLookupStartTimestamp);
    }
    if (hasDnsLookupDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("dnsLookupDuration");
      paramDataProcessor.processLong(dnsLookupDuration);
    }
    if (hasDnsCacheHitRatio)
    {
      paramDataProcessor.startRecordField$505cff1c("dnsCacheHitRatio");
      paramDataProcessor.processDouble(dnsCacheHitRatio);
    }
    if (hasImageDecodingStartTimestamp)
    {
      paramDataProcessor.startRecordField$505cff1c("imageDecodingStartTimestamp");
      paramDataProcessor.processLong(imageDecodingStartTimestamp);
    }
    if (hasImageDecodingDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("imageDecodingDuration");
      paramDataProcessor.processLong(imageDecodingDuration);
    }
    if (hasImagePostprocessingStartTimestamp)
    {
      paramDataProcessor.startRecordField$505cff1c("imagePostprocessingStartTimestamp");
      paramDataProcessor.processLong(imagePostprocessingStartTimestamp);
    }
    if (hasImagePostprocessingDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("imagePostprocessingDuration");
      paramDataProcessor.processLong(imagePostprocessingDuration);
    }
    if (hasTotalFreeMemory)
    {
      paramDataProcessor.startRecordField$505cff1c("totalFreeMemory");
      paramDataProcessor.processLong(totalFreeMemory);
    }
    if (hasTotalDeviceMemory)
    {
      paramDataProcessor.startRecordField$505cff1c("totalDeviceMemory");
      paramDataProcessor.processLong(totalDeviceMemory);
    }
    if (hasCarrierSignalStrength)
    {
      paramDataProcessor.startRecordField$505cff1c("carrierSignalStrength");
      paramDataProcessor.processDouble(carrierSignalStrength);
    }
    if (hasPointOfPresenceId)
    {
      paramDataProcessor.startRecordField$505cff1c("pointOfPresenceId");
      paramDataProcessor.processString(pointOfPresenceId);
    }
    if (hasRoamingCarrierName)
    {
      paramDataProcessor.startRecordField$505cff1c("roamingCarrierName");
      paramDataProcessor.processString(roamingCarrierName);
    }
    if (hasPageLoadStartTimestamp)
    {
      paramDataProcessor.startRecordField$505cff1c("pageLoadStartTimestamp");
      paramDataProcessor.processLong(pageLoadStartTimestamp);
    }
    if (hasConnectionStartTimestamp)
    {
      paramDataProcessor.startRecordField$505cff1c("connectionStartTimestamp");
      paramDataProcessor.processLong(connectionStartTimestamp);
    }
    if (hasConnectionRefusedDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("connectionRefusedDuration");
      paramDataProcessor.processLong(connectionRefusedDuration);
    }
    if (hasConnectionTimeoutDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("connectionTimeoutDuration");
      paramDataProcessor.processLong(connectionTimeoutDuration);
    }
    if (hasConnectionDropDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("connectionDropDuration");
      paramDataProcessor.processLong(connectionDropDuration);
    }
    if (hasTlsHandshakeStartTimestamp)
    {
      paramDataProcessor.startRecordField$505cff1c("tlsHandshakeStartTimestamp");
      paramDataProcessor.processLong(tlsHandshakeStartTimestamp);
    }
    if (hasTlsHandshakeDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("tlsHandshakeDuration");
      paramDataProcessor.processLong(tlsHandshakeDuration);
    }
    if (hasIsTlsSessionCacheHit)
    {
      paramDataProcessor.startRecordField$505cff1c("isTlsSessionCacheHit");
      paramDataProcessor.processBoolean(isTlsSessionCacheHit);
    }
    if (hasIsConnectionPoolHit)
    {
      paramDataProcessor.startRecordField$505cff1c("isConnectionPoolHit");
      paramDataProcessor.processBoolean(isConnectionPoolHit);
    }
    if (hasUploadSpeed)
    {
      paramDataProcessor.startRecordField$505cff1c("uploadSpeed");
      paramDataProcessor.processDouble(uploadSpeed);
    }
    if (hasDownloadSpeed)
    {
      paramDataProcessor.startRecordField$505cff1c("downloadSpeed");
      paramDataProcessor.processDouble(downloadSpeed);
    }
    if (hasLocationAreaCode)
    {
      paramDataProcessor.startRecordField$505cff1c("locationAreaCode");
      paramDataProcessor.processInt(locationAreaCode);
    }
    if (hasMobileNetworkCode)
    {
      paramDataProcessor.startRecordField$505cff1c("mobileNetworkCode");
      paramDataProcessor.processInt(mobileNetworkCode);
    }
    if (hasMobileCountryCode)
    {
      paramDataProcessor.startRecordField$505cff1c("mobileCountryCode");
      paramDataProcessor.processInt(mobileCountryCode);
    }
    if (hasCellTowerId)
    {
      paramDataProcessor.startRecordField$505cff1c("cellTowerId");
      paramDataProcessor.processLong(cellTowerId);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new GranularMetrics(diskCacheLookupStartTimestamp, diskCacheLookupDuration, receivedFirstByteTimestamp, isCacheHit, memoryCacheLookupStartTimestamp, memoryCacheLookupDuration, networkRequestStartTimestamp, networkRequestDuration, modelBindingStartTimestamp, modelBindingDuration, cacheModelBindingStartTimestamp, cacheModelBindingDuration, parseStartTimestamp, parseDuration, cachedParseStartTimestamp, cachedParseDuration, serverDuration, httpStatusCode, responseSize, requestUrl, requestTreeId, networkTimeoutCount, connectionDropCount, dnsLookupStartTimestamp, dnsLookupDuration, dnsCacheHitRatio, imageDecodingStartTimestamp, imageDecodingDuration, imagePostprocessingStartTimestamp, imagePostprocessingDuration, totalFreeMemory, totalDeviceMemory, carrierSignalStrength, pointOfPresenceId, roamingCarrierName, pageLoadStartTimestamp, connectionStartTimestamp, connectionRefusedDuration, connectionTimeoutDuration, connectionDropDuration, tlsHandshakeStartTimestamp, tlsHandshakeDuration, isTlsSessionCacheHit, isConnectionPoolHit, uploadSpeed, downloadSpeed, locationAreaCode, mobileNetworkCode, mobileCountryCode, cellTowerId, hasDiskCacheLookupStartTimestamp, hasDiskCacheLookupDuration, hasReceivedFirstByteTimestamp, hasIsCacheHit, hasMemoryCacheLookupStartTimestamp, hasMemoryCacheLookupDuration, hasNetworkRequestStartTimestamp, hasNetworkRequestDuration, hasModelBindingStartTimestamp, hasModelBindingDuration, hasCacheModelBindingStartTimestamp, hasCacheModelBindingDuration, hasParseStartTimestamp, hasParseDuration, hasCachedParseStartTimestamp, hasCachedParseDuration, hasServerDuration, hasHttpStatusCode, hasResponseSize, hasRequestUrl, hasRequestTreeId, hasNetworkTimeoutCount, hasConnectionDropCount, hasDnsLookupStartTimestamp, hasDnsLookupDuration, hasDnsCacheHitRatio, hasImageDecodingStartTimestamp, hasImageDecodingDuration, hasImagePostprocessingStartTimestamp, hasImagePostprocessingDuration, hasTotalFreeMemory, hasTotalDeviceMemory, hasCarrierSignalStrength, hasPointOfPresenceId, hasRoamingCarrierName, hasPageLoadStartTimestamp, hasConnectionStartTimestamp, hasConnectionRefusedDuration, hasConnectionTimeoutDuration, hasConnectionDropDuration, hasTlsHandshakeStartTimestamp, hasTlsHandshakeDuration, hasIsTlsSessionCacheHit, hasIsConnectionPoolHit, hasUploadSpeed, hasDownloadSpeed, hasLocationAreaCode, hasMobileNetworkCode, hasMobileCountryCode, hasCellTowerId);
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
      paramObject = (GranularMetrics)paramObject;
      if (diskCacheLookupStartTimestamp != diskCacheLookupStartTimestamp) {
        return false;
      }
      if (diskCacheLookupDuration != diskCacheLookupDuration) {
        return false;
      }
      if (receivedFirstByteTimestamp != receivedFirstByteTimestamp) {
        return false;
      }
      if (isCacheHit != null)
      {
        if (isCacheHit.equals(isCacheHit)) {}
      }
      else {
        while (isCacheHit != null) {
          return false;
        }
      }
      if (memoryCacheLookupStartTimestamp != memoryCacheLookupStartTimestamp) {
        return false;
      }
      if (memoryCacheLookupDuration != memoryCacheLookupDuration) {
        return false;
      }
      if (networkRequestStartTimestamp != networkRequestStartTimestamp) {
        return false;
      }
      if (networkRequestDuration != networkRequestDuration) {
        return false;
      }
      if (modelBindingStartTimestamp != modelBindingStartTimestamp) {
        return false;
      }
      if (modelBindingDuration != modelBindingDuration) {
        return false;
      }
      if (cacheModelBindingStartTimestamp != cacheModelBindingStartTimestamp) {
        return false;
      }
      if (cacheModelBindingDuration != cacheModelBindingDuration) {
        return false;
      }
      if (parseStartTimestamp != parseStartTimestamp) {
        return false;
      }
      if (parseDuration != parseDuration) {
        return false;
      }
      if (cachedParseStartTimestamp != cachedParseStartTimestamp) {
        return false;
      }
      if (cachedParseDuration != cachedParseDuration) {
        return false;
      }
      if (serverDuration != serverDuration) {
        return false;
      }
      if (httpStatusCode != httpStatusCode) {
        return false;
      }
      if (responseSize != responseSize) {
        return false;
      }
      if (requestUrl != null)
      {
        if (requestUrl.equals(requestUrl)) {}
      }
      else {
        while (requestUrl != null) {
          return false;
        }
      }
      if (requestTreeId != null)
      {
        if (requestTreeId.equals(requestTreeId)) {}
      }
      else {
        while (requestTreeId != null) {
          return false;
        }
      }
      if (networkTimeoutCount != networkTimeoutCount) {
        return false;
      }
      if (connectionDropCount != connectionDropCount) {
        return false;
      }
      if (dnsLookupStartTimestamp != dnsLookupStartTimestamp) {
        return false;
      }
      if (dnsLookupDuration != dnsLookupDuration) {
        return false;
      }
      if (dnsCacheHitRatio != dnsCacheHitRatio) {
        return false;
      }
      if (imageDecodingStartTimestamp != imageDecodingStartTimestamp) {
        return false;
      }
      if (imageDecodingDuration != imageDecodingDuration) {
        return false;
      }
      if (imagePostprocessingStartTimestamp != imagePostprocessingStartTimestamp) {
        return false;
      }
      if (imagePostprocessingDuration != imagePostprocessingDuration) {
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
      if (connectionStartTimestamp != connectionStartTimestamp) {
        return false;
      }
      if (connectionRefusedDuration != connectionRefusedDuration) {
        return false;
      }
      if (connectionTimeoutDuration != connectionTimeoutDuration) {
        return false;
      }
      if (connectionDropDuration != connectionDropDuration) {
        return false;
      }
      if (tlsHandshakeStartTimestamp != tlsHandshakeStartTimestamp) {
        return false;
      }
      if (tlsHandshakeDuration != tlsHandshakeDuration) {
        return false;
      }
      if (isTlsSessionCacheHit != isTlsSessionCacheHit) {
        return false;
      }
      if (isConnectionPoolHit != isConnectionPoolHit) {
        return false;
      }
      if (uploadSpeed != uploadSpeed) {
        return false;
      }
      if (downloadSpeed != downloadSpeed) {
        return false;
      }
      if (locationAreaCode != locationAreaCode) {
        return false;
      }
      if (mobileNetworkCode != mobileNetworkCode) {
        return false;
      }
      if (mobileCountryCode != mobileCountryCode) {
        return false;
      }
    } while (cellTowerId == cellTowerId);
    return false;
  }
  
  public final int hashCode()
  {
    int i2 = 1;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i3 = (int)(diskCacheLookupStartTimestamp ^ diskCacheLookupStartTimestamp >>> 32);
    int i4 = (int)(diskCacheLookupDuration ^ diskCacheLookupDuration >>> 32);
    int i5 = (int)(receivedFirstByteTimestamp ^ receivedFirstByteTimestamp >>> 32);
    int i;
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int i12;
    int i13;
    int i14;
    int i15;
    int i16;
    int i17;
    int i18;
    int i19;
    int i20;
    int j;
    label306:
    int k;
    label321:
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
    int i31;
    int i32;
    int m;
    label511:
    int n;
    label527:
    int i33;
    int i34;
    int i35;
    int i36;
    int i37;
    int i38;
    int i39;
    int i1;
    if (isCacheHit != null)
    {
      i = isCacheHit.hashCode();
      i6 = (int)(memoryCacheLookupStartTimestamp ^ memoryCacheLookupStartTimestamp >>> 32);
      i7 = (int)(memoryCacheLookupDuration ^ memoryCacheLookupDuration >>> 32);
      i8 = (int)(networkRequestStartTimestamp ^ networkRequestStartTimestamp >>> 32);
      i9 = (int)(networkRequestDuration ^ networkRequestDuration >>> 32);
      i10 = (int)(modelBindingStartTimestamp ^ modelBindingStartTimestamp >>> 32);
      i11 = (int)(modelBindingDuration ^ modelBindingDuration >>> 32);
      i12 = (int)(cacheModelBindingStartTimestamp ^ cacheModelBindingStartTimestamp >>> 32);
      i13 = (int)(cacheModelBindingDuration ^ cacheModelBindingDuration >>> 32);
      i14 = (int)(parseStartTimestamp ^ parseStartTimestamp >>> 32);
      i15 = (int)(parseDuration ^ parseDuration >>> 32);
      i16 = (int)(cachedParseStartTimestamp ^ cachedParseStartTimestamp >>> 32);
      i17 = (int)(cachedParseDuration ^ cachedParseDuration >>> 32);
      i18 = (int)(serverDuration ^ serverDuration >>> 32);
      i19 = httpStatusCode;
      i20 = (int)(responseSize ^ responseSize >>> 32);
      if (requestUrl == null) {
        break label1010;
      }
      j = requestUrl.hashCode();
      if (requestTreeId == null) {
        break label1015;
      }
      k = requestTreeId.hashCode();
      i21 = networkTimeoutCount;
      i22 = connectionDropCount;
      i23 = (int)(dnsLookupStartTimestamp ^ dnsLookupStartTimestamp >>> 32);
      i24 = (int)(dnsLookupDuration ^ dnsLookupDuration >>> 32);
      i25 = (int)(Double.doubleToLongBits(dnsCacheHitRatio) ^ Double.doubleToLongBits(dnsCacheHitRatio) >>> 32);
      i26 = (int)(imageDecodingStartTimestamp ^ imageDecodingStartTimestamp >>> 32);
      i27 = (int)(imageDecodingDuration ^ imageDecodingDuration >>> 32);
      i28 = (int)(imagePostprocessingStartTimestamp ^ imagePostprocessingStartTimestamp >>> 32);
      i29 = (int)(imagePostprocessingDuration ^ imagePostprocessingDuration >>> 32);
      i30 = (int)(totalFreeMemory ^ totalFreeMemory >>> 32);
      i31 = (int)(totalDeviceMemory ^ totalDeviceMemory >>> 32);
      i32 = (int)(Double.doubleToLongBits(carrierSignalStrength) ^ Double.doubleToLongBits(carrierSignalStrength) >>> 32);
      if (pointOfPresenceId == null) {
        break label1020;
      }
      m = pointOfPresenceId.hashCode();
      if (roamingCarrierName == null) {
        break label1026;
      }
      n = roamingCarrierName.hashCode();
      i33 = (int)(pageLoadStartTimestamp ^ pageLoadStartTimestamp >>> 32);
      i34 = (int)(connectionStartTimestamp ^ connectionStartTimestamp >>> 32);
      i35 = (int)(connectionRefusedDuration ^ connectionRefusedDuration >>> 32);
      i36 = (int)(connectionTimeoutDuration ^ connectionTimeoutDuration >>> 32);
      i37 = (int)(connectionDropDuration ^ connectionDropDuration >>> 32);
      i38 = (int)(tlsHandshakeStartTimestamp ^ tlsHandshakeStartTimestamp >>> 32);
      i39 = (int)(tlsHandshakeDuration ^ tlsHandshakeDuration >>> 32);
      if (!isTlsSessionCacheHit) {
        break label1032;
      }
      i1 = 1;
      label642:
      if (!isConnectionPoolHit) {
        break label1038;
      }
    }
    for (;;)
    {
      i = (((((((i1 + ((((((((n + (m + (((((((((((((k + (j + ((((((((((((((((i + (((i3 + 527) * 31 + i4) * 31 + i5) * 31) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + i15) * 31 + i16) * 31 + i17) * 31 + i18) * 31 + i19) * 31 + i20) * 31) * 31) * 31 + i21) * 31 + i22) * 31 + i23) * 31 + i24) * 31 + i25) * 31 + i26) * 31 + i27) * 31 + i28) * 31 + i29) * 31 + i30) * 31 + i31) * 31 + i32) * 31) * 31) * 31 + i33) * 31 + i34) * 31 + i35) * 31 + i36) * 31 + i37) * 31 + i38) * 31 + i39) * 31) * 31 + i2) * 31 + (int)(Double.doubleToLongBits(uploadSpeed) ^ Double.doubleToLongBits(uploadSpeed) >>> 32)) * 31 + (int)(Double.doubleToLongBits(downloadSpeed) ^ Double.doubleToLongBits(downloadSpeed) >>> 32)) * 31 + locationAreaCode) * 31 + mobileNetworkCode) * 31 + mobileCountryCode) * 31 + (int)(cellTowerId ^ cellTowerId >>> 32);
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      label1010:
      j = 0;
      break label306;
      label1015:
      k = 0;
      break label321;
      label1020:
      m = 0;
      break label511;
      label1026:
      n = 0;
      break label527;
      label1032:
      i1 = 0;
      break label642;
      label1038:
      i2 = 0;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.GranularMetrics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */