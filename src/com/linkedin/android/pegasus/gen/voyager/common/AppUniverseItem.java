package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class AppUniverseItem
  implements FissileDataModel<AppUniverseItem>, RecordTemplate<AppUniverseItem>
{
  public static final AppUniverseItemBuilder BUILDER = AppUniverseItemBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String appName;
  public final String appUrl;
  public final boolean hasAppName;
  public final boolean hasAppUrl;
  public final boolean hasIconUrl;
  public final boolean hasLegoTrackingToken;
  public final boolean hasStoreUrl;
  public final boolean hasTagline;
  public final boolean hasTrackingCode;
  public final String iconUrl;
  public final String legoTrackingToken;
  public final String storeUrl;
  public final String tagline;
  public final String trackingCode;
  
  AppUniverseItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    appName = paramString1;
    tagline = paramString2;
    storeUrl = paramString3;
    appUrl = paramString4;
    iconUrl = paramString5;
    trackingCode = paramString6;
    legoTrackingToken = paramString7;
    hasAppName = paramBoolean1;
    hasTagline = paramBoolean2;
    hasStoreUrl = paramBoolean3;
    hasAppUrl = paramBoolean4;
    hasIconUrl = paramBoolean5;
    hasTrackingCode = paramBoolean6;
    hasLegoTrackingToken = paramBoolean7;
    _cachedId = null;
  }
  
  public final AppUniverseItem accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasAppName)
    {
      paramDataProcessor.startRecordField$505cff1c("appName");
      paramDataProcessor.processString(appName);
    }
    if (hasTagline)
    {
      paramDataProcessor.startRecordField$505cff1c("tagline");
      paramDataProcessor.processString(tagline);
    }
    if (hasStoreUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("storeUrl");
      paramDataProcessor.processString(storeUrl);
    }
    if (hasAppUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("appUrl");
      paramDataProcessor.processString(appUrl);
    }
    if (hasIconUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("iconUrl");
      paramDataProcessor.processString(iconUrl);
    }
    if (hasTrackingCode)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingCode");
      paramDataProcessor.processString(trackingCode);
    }
    if (hasLegoTrackingToken)
    {
      paramDataProcessor.startRecordField$505cff1c("legoTrackingToken");
      paramDataProcessor.processString(legoTrackingToken);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasAppName) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem", "appName");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasTagline) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem", "tagline");
      }
      if (!hasStoreUrl) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem", "storeUrl");
      }
      if (!hasAppUrl) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem", "appUrl");
      }
      if (!hasIconUrl) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem", "iconUrl");
      }
      if (!hasTrackingCode) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem", "trackingCode");
      }
      if (!hasLegoTrackingToken) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem", "legoTrackingToken");
      }
      return new AppUniverseItem(appName, tagline, storeUrl, appUrl, iconUrl, trackingCode, legoTrackingToken, hasAppName, hasTagline, hasStoreUrl, hasAppUrl, hasIconUrl, hasTrackingCode, hasLegoTrackingToken);
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
      paramObject = (AppUniverseItem)paramObject;
      if (appName != null)
      {
        if (appName.equals(appName)) {}
      }
      else {
        while (appName != null) {
          return false;
        }
      }
      if (tagline != null)
      {
        if (tagline.equals(tagline)) {}
      }
      else {
        while (tagline != null) {
          return false;
        }
      }
      if (storeUrl != null)
      {
        if (storeUrl.equals(storeUrl)) {}
      }
      else {
        while (storeUrl != null) {
          return false;
        }
      }
      if (appUrl != null)
      {
        if (appUrl.equals(appUrl)) {}
      }
      else {
        while (appUrl != null) {
          return false;
        }
      }
      if (iconUrl != null)
      {
        if (iconUrl.equals(iconUrl)) {}
      }
      else {
        while (iconUrl != null) {
          return false;
        }
      }
      if (trackingCode != null)
      {
        if (trackingCode.equals(trackingCode)) {}
      }
      else {
        while (trackingCode != null) {
          return false;
        }
      }
      if (legoTrackingToken == null) {
        break;
      }
    } while (legoTrackingToken.equals(legoTrackingToken));
    for (;;)
    {
      return false;
      if (legoTrackingToken == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasAppName) {
      i = PegasusBinaryUtils.getEncodedLength(appName) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasTagline) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(tagline);
    }
    j = i + 1;
    i = j;
    if (hasStoreUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(storeUrl);
    }
    j = i + 1;
    i = j;
    if (hasAppUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(appUrl);
    }
    j = i + 1;
    i = j;
    if (hasIconUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(iconUrl);
    }
    j = i + 1;
    i = j;
    if (hasTrackingCode) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(trackingCode);
    }
    j = i + 1;
    i = j;
    if (hasLegoTrackingToken) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(legoTrackingToken);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int i2 = 0;
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
    if (appName != null)
    {
      i = appName.hashCode();
      if (tagline == null) {
        break label176;
      }
      j = tagline.hashCode();
      if (storeUrl == null) {
        break label181;
      }
      k = storeUrl.hashCode();
      if (appUrl == null) {
        break label186;
      }
      m = appUrl.hashCode();
      if (iconUrl == null) {
        break label192;
      }
      n = iconUrl.hashCode();
      label92:
      if (trackingCode == null) {
        break label198;
      }
    }
    label176:
    label181:
    label186:
    label192:
    label198:
    for (int i1 = trackingCode.hashCode();; i1 = 0)
    {
      if (legoTrackingToken != null) {
        i2 = legoTrackingToken.hashCode();
      }
      i = (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
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
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building AppUniverseItem");
    }
    if (paramBoolean)
    {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
      if (str != null) {
        paramFissionAdapter.writeToCache(str, null, 0, paramFissionTransaction);
      }
    }
    label162:
    label188:
    label214:
    label240:
    label266:
    label335:
    label345:
    label355:
    label365:
    label375:
    label385:
    label393:
    label395:
    do
    {
      ByteBuffer localByteBuffer;
      for (;;)
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(1215427962);
        if (hasAppName)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, appName);
          if (!hasTagline) {
            break label335;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, tagline);
          if (!hasStoreUrl) {
            break label345;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, storeUrl);
          if (!hasAppUrl) {
            break label355;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, appUrl);
          if (!hasIconUrl) {
            break label365;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, iconUrl);
          if (!hasTrackingCode) {
            break label375;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingCode);
          if (!hasLegoTrackingToken) {
            break label385;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, legoTrackingToken);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label393;
          }
          if (str != null) {
            break label395;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          localByteBuffer.put((byte)0);
          break label188;
          localByteBuffer.put((byte)0);
          break label214;
          localByteBuffer.put((byte)0);
          break label240;
          localByteBuffer.put((byte)0);
          break label266;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    int i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */