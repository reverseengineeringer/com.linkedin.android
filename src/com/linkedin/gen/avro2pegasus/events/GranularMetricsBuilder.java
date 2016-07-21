package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class GranularMetricsBuilder
  implements DataTemplateBuilder<GranularMetrics>
{
  public static final GranularMetricsBuilder INSTANCE = new GranularMetricsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("diskCacheLookupStartTimestamp");
    JSON_KEY_STORE.put("diskCacheLookupDuration");
    JSON_KEY_STORE.put("receivedFirstByteTimestamp");
    JSON_KEY_STORE.put("isCacheHit");
    JSON_KEY_STORE.put("memoryCacheLookupStartTimestamp");
    JSON_KEY_STORE.put("memoryCacheLookupDuration");
    JSON_KEY_STORE.put("networkRequestStartTimestamp");
    JSON_KEY_STORE.put("networkRequestDuration");
    JSON_KEY_STORE.put("modelBindingStartTimestamp");
    JSON_KEY_STORE.put("modelBindingDuration");
    JSON_KEY_STORE.put("cacheModelBindingStartTimestamp");
    JSON_KEY_STORE.put("cacheModelBindingDuration");
    JSON_KEY_STORE.put("parseStartTimestamp");
    JSON_KEY_STORE.put("parseDuration");
    JSON_KEY_STORE.put("cachedParseStartTimestamp");
    JSON_KEY_STORE.put("cachedParseDuration");
    JSON_KEY_STORE.put("serverDuration");
    JSON_KEY_STORE.put("httpStatusCode");
    JSON_KEY_STORE.put("responseSize");
    JSON_KEY_STORE.put("requestUrl");
    JSON_KEY_STORE.put("requestTreeId");
    JSON_KEY_STORE.put("networkTimeoutCount");
    JSON_KEY_STORE.put("connectionDropCount");
    JSON_KEY_STORE.put("dnsLookupStartTimestamp");
    JSON_KEY_STORE.put("dnsLookupDuration");
    JSON_KEY_STORE.put("dnsCacheHitRatio");
    JSON_KEY_STORE.put("imageDecodingStartTimestamp");
    JSON_KEY_STORE.put("imageDecodingDuration");
    JSON_KEY_STORE.put("imagePostprocessingStartTimestamp");
    JSON_KEY_STORE.put("imagePostprocessingDuration");
    JSON_KEY_STORE.put("totalFreeMemory");
    JSON_KEY_STORE.put("totalDeviceMemory");
    JSON_KEY_STORE.put("carrierSignalStrength");
    JSON_KEY_STORE.put("pointOfPresenceId");
    JSON_KEY_STORE.put("roamingCarrierName");
    JSON_KEY_STORE.put("pageLoadStartTimestamp");
    JSON_KEY_STORE.put("connectionStartTimestamp");
    JSON_KEY_STORE.put("connectionRefusedDuration");
    JSON_KEY_STORE.put("connectionTimeoutDuration");
    JSON_KEY_STORE.put("connectionDropDuration");
    JSON_KEY_STORE.put("tlsHandshakeStartTimestamp");
    JSON_KEY_STORE.put("tlsHandshakeDuration");
    JSON_KEY_STORE.put("isTlsSessionCacheHit");
    JSON_KEY_STORE.put("isConnectionPoolHit");
    JSON_KEY_STORE.put("uploadSpeed");
    JSON_KEY_STORE.put("downloadSpeed");
    JSON_KEY_STORE.put("locationAreaCode");
    JSON_KEY_STORE.put("mobileNetworkCode");
    JSON_KEY_STORE.put("mobileCountryCode");
    JSON_KEY_STORE.put("cellTowerId");
  }
  
  public static GranularMetrics build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l33 = 0L;
    long l32 = 0L;
    long l31 = 0L;
    isCacheHit localisCacheHit = null;
    long l30 = 0L;
    long l29 = 0L;
    long l28 = 0L;
    long l27 = 0L;
    long l26 = 0L;
    long l25 = 0L;
    long l24 = 0L;
    long l23 = 0L;
    long l22 = 0L;
    long l21 = 0L;
    long l20 = 0L;
    long l19 = 0L;
    long l18 = 0L;
    int i1 = 0;
    long l17 = 0L;
    String str3 = null;
    Object localObject = null;
    int n = 0;
    int m = 0;
    long l16 = 0L;
    long l15 = 0L;
    double d4 = 0.0D;
    long l14 = 0L;
    long l13 = 0L;
    long l12 = 0L;
    long l11 = 0L;
    long l10 = 0L;
    long l9 = 0L;
    double d3 = 0.0D;
    String str2 = null;
    String str1 = null;
    long l8 = 0L;
    long l7 = 0L;
    long l6 = 0L;
    long l5 = 0L;
    long l4 = 0L;
    long l3 = 0L;
    long l2 = 0L;
    boolean bool52 = false;
    boolean bool51 = false;
    double d2 = 0.0D;
    double d1 = 0.0D;
    int k = 0;
    int j = 0;
    int i = 0;
    long l1 = 0L;
    boolean bool50 = false;
    boolean bool49 = false;
    boolean bool48 = false;
    boolean bool47 = false;
    boolean bool46 = false;
    boolean bool45 = false;
    boolean bool44 = false;
    boolean bool43 = false;
    boolean bool42 = false;
    boolean bool41 = false;
    boolean bool40 = false;
    boolean bool39 = false;
    boolean bool38 = false;
    boolean bool37 = false;
    boolean bool36 = false;
    boolean bool35 = false;
    boolean bool34 = false;
    boolean bool33 = false;
    boolean bool32 = false;
    boolean bool31 = false;
    boolean bool30 = false;
    boolean bool29 = false;
    boolean bool28 = false;
    boolean bool27 = false;
    boolean bool26 = false;
    boolean bool25 = false;
    boolean bool24 = false;
    boolean bool23 = false;
    boolean bool22 = false;
    boolean bool21 = false;
    boolean bool20 = false;
    boolean bool19 = false;
    boolean bool18 = false;
    boolean bool17 = false;
    boolean bool16 = false;
    boolean bool15 = false;
    boolean bool14 = false;
    boolean bool13 = false;
    boolean bool12 = false;
    boolean bool11 = false;
    boolean bool10 = false;
    boolean bool8 = false;
    boolean bool9 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("diskCacheLookupStartTimestamp", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l33 = paramDataReader.readLong();
        bool50 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("diskCacheLookupDuration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l32 = paramDataReader.readLong();
        bool49 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("receivedFirstByteTimestamp", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l31 = paramDataReader.readLong();
        bool48 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("isCacheHit", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localisCacheHit = (isCacheHit)paramDataReader.readEnum(isCacheHit.Builder.INSTANCE);
        bool47 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("memoryCacheLookupStartTimestamp", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l30 = paramDataReader.readLong();
        bool46 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("memoryCacheLookupDuration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l29 = paramDataReader.readLong();
        bool45 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("networkRequestStartTimestamp", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l28 = paramDataReader.readLong();
        bool44 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("networkRequestDuration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l27 = paramDataReader.readLong();
        bool43 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("modelBindingStartTimestamp", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l26 = paramDataReader.readLong();
        bool42 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("modelBindingDuration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l25 = paramDataReader.readLong();
        bool41 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("cacheModelBindingStartTimestamp", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l24 = paramDataReader.readLong();
        bool40 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("cacheModelBindingDuration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l23 = paramDataReader.readLong();
        bool39 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("parseStartTimestamp", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l22 = paramDataReader.readLong();
        bool38 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("parseDuration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l21 = paramDataReader.readLong();
        bool37 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("cachedParseStartTimestamp", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l20 = paramDataReader.readLong();
        bool36 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("cachedParseDuration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l19 = paramDataReader.readLong();
        bool35 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("serverDuration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l18 = paramDataReader.readLong();
        bool34 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("httpStatusCode", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i1 = paramDataReader.readInt();
        bool33 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("responseSize", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l17 = paramDataReader.readLong();
        bool32 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("requestUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool31 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("requestTreeId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = BytesCoercer.INSTANCE;
        localObject = BytesCoercer.coerceToCustomType(paramDataReader.readBytes());
        bool30 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("networkTimeoutCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        n = paramDataReader.readInt();
        bool29 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("connectionDropCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        m = paramDataReader.readInt();
        bool28 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("dnsLookupStartTimestamp", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l16 = paramDataReader.readLong();
        bool27 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("dnsLookupDuration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l15 = paramDataReader.readLong();
        bool26 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("dnsCacheHitRatio", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        d4 = paramDataReader.readDouble();
        bool25 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("imageDecodingStartTimestamp", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l14 = paramDataReader.readLong();
        bool24 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("imageDecodingDuration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l13 = paramDataReader.readLong();
        bool23 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("imagePostprocessingStartTimestamp", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l12 = paramDataReader.readLong();
        bool22 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("imagePostprocessingDuration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l11 = paramDataReader.readLong();
        bool21 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("totalFreeMemory", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l10 = paramDataReader.readLong();
        bool20 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("totalDeviceMemory", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l9 = paramDataReader.readLong();
        bool19 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("carrierSignalStrength", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        d3 = paramDataReader.readDouble();
        bool18 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("pointOfPresenceId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool17 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("roamingCarrierName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool16 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("pageLoadStartTimestamp", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l8 = paramDataReader.readLong();
        bool15 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("connectionStartTimestamp", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l7 = paramDataReader.readLong();
        bool14 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("connectionRefusedDuration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l6 = paramDataReader.readLong();
        bool13 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("connectionTimeoutDuration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l5 = paramDataReader.readLong();
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("connectionDropDuration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l4 = paramDataReader.readLong();
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("tlsHandshakeStartTimestamp", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l3 = paramDataReader.readLong();
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("tlsHandshakeDuration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l2 = paramDataReader.readLong();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("isTlsSessionCacheHit", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool52 = paramDataReader.readBoolean();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("isConnectionPoolHit", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool51 = paramDataReader.readBoolean();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("uploadSpeed", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        d2 = paramDataReader.readDouble();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("downloadSpeed", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        d1 = paramDataReader.readDouble();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("locationAreaCode", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        k = paramDataReader.readInt();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("mobileNetworkCode", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("mobileCountryCode", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("cellTowerId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l1 = paramDataReader.readLong();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    return new GranularMetrics(l33, l32, l31, localisCacheHit, l30, l29, l28, l27, l26, l25, l24, l23, l22, l21, l20, l19, l18, i1, l17, str3, (String)localObject, n, m, l16, l15, d4, l14, l13, l12, l11, l10, l9, d3, str2, str1, l8, l7, l6, l5, l4, l3, l2, bool52, bool51, d2, d1, k, j, i, l1, bool50, bool49, bool48, bool47, bool46, bool45, bool44, bool43, bool42, bool41, bool40, bool39, bool38, bool37, bool36, bool35, bool34, bool33, bool32, bool31, bool30, bool29, bool28, bool27, bool26, bool25, bool24, bool23, bool22, bool21, bool20, bool19, bool18, bool17, bool16, bool15, bool14, bool13, bool12, bool11, bool10, bool8, bool9, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.GranularMetricsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */