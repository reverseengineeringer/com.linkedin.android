package com.linkedin.android.pegasus.gen.voyager.feed;

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

public final class SponsoredMetadata
  implements FissileDataModel<SponsoredMetadata>, RecordTemplate<SponsoredMetadata>
{
  public static final SponsoredMetadataBuilder BUILDER = SponsoredMetadataBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final SponsoredActivityType activityType;
  public final String displayFormat;
  public final ExternalTracking externalTracking;
  public final boolean hasActivityType;
  public final boolean hasDisplayFormat;
  public final boolean hasExternalTracking;
  public final boolean hasLandingUrl;
  public final boolean hasTscpUrl;
  public final String landingUrl;
  public final String tscpUrl;
  
  SponsoredMetadata(String paramString1, SponsoredActivityType paramSponsoredActivityType, String paramString2, ExternalTracking paramExternalTracking, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    tscpUrl = paramString1;
    activityType = paramSponsoredActivityType;
    displayFormat = paramString2;
    externalTracking = paramExternalTracking;
    landingUrl = paramString3;
    hasTscpUrl = paramBoolean1;
    hasActivityType = paramBoolean2;
    hasDisplayFormat = paramBoolean3;
    hasExternalTracking = paramBoolean4;
    hasLandingUrl = paramBoolean5;
    _cachedId = null;
  }
  
  public final SponsoredMetadata accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTscpUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("tscpUrl");
      paramDataProcessor.processString(tscpUrl);
    }
    if (hasActivityType)
    {
      paramDataProcessor.startRecordField$505cff1c("activityType");
      paramDataProcessor.processEnum(activityType);
    }
    if (hasDisplayFormat)
    {
      paramDataProcessor.startRecordField$505cff1c("displayFormat");
      paramDataProcessor.processString(displayFormat);
    }
    ExternalTracking localExternalTracking = null;
    boolean bool = false;
    if (hasExternalTracking)
    {
      paramDataProcessor.startRecordField$505cff1c("externalTracking");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label193;
      }
      localExternalTracking = externalTracking.accept(paramDataProcessor);
      if (localExternalTracking == null) {
        break label210;
      }
    }
    label193:
    label210:
    for (bool = true;; bool = false)
    {
      if (hasLandingUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("landingUrl");
        paramDataProcessor.processString(landingUrl);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label257;
      }
      try
      {
        if (hasTscpUrl) {
          break label215;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.SponsoredMetadata", "tscpUrl");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localExternalTracking = (ExternalTracking)paramDataProcessor.processDataTemplate(externalTracking);
      break;
    }
    label215:
    return new SponsoredMetadata(tscpUrl, activityType, displayFormat, localExternalTracking, landingUrl, hasTscpUrl, hasActivityType, hasDisplayFormat, bool, hasLandingUrl);
    label257:
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
      paramObject = (SponsoredMetadata)paramObject;
      if (tscpUrl != null)
      {
        if (tscpUrl.equals(tscpUrl)) {}
      }
      else {
        while (tscpUrl != null) {
          return false;
        }
      }
      if (activityType != null)
      {
        if (activityType.equals(activityType)) {}
      }
      else {
        while (activityType != null) {
          return false;
        }
      }
      if (displayFormat != null)
      {
        if (displayFormat.equals(displayFormat)) {}
      }
      else {
        while (displayFormat != null) {
          return false;
        }
      }
      if (externalTracking != null)
      {
        if (externalTracking.equals(externalTracking)) {}
      }
      else {
        while (externalTracking != null) {
          return false;
        }
      }
      if (landingUrl == null) {
        break;
      }
    } while (landingUrl.equals(landingUrl));
    for (;;)
    {
      return false;
      if (landingUrl == null) {
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
    if (hasTscpUrl) {
      i = PegasusBinaryUtils.getEncodedLength(tscpUrl) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasActivityType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasDisplayFormat) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(displayFormat);
    }
    j = i + 1;
    i = j;
    if (hasExternalTracking)
    {
      i = j + 1;
      if (externalTracking._cachedId == null) {
        break label154;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(externalTracking._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasLandingUrl) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(landingUrl);
      }
      __sizeOfObject = i;
      return i;
      label154:
      i += externalTracking.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (tscpUrl != null)
    {
      i = tscpUrl.hashCode();
      if (activityType == null) {
        break label132;
      }
      j = activityType.hashCode();
      if (displayFormat == null) {
        break label137;
      }
      k = displayFormat.hashCode();
      label60:
      if (externalTracking == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = externalTracking.hashCode();; m = 0)
    {
      if (landingUrl != null) {
        n = landingUrl.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SponsoredMetadata");
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
    label165:
    label191:
    label251:
    label320:
    label330:
    label340:
    label365:
    label375:
    label383:
    label385:
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
        localByteBuffer.putInt(-736678863);
        if (hasTscpUrl)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, tscpUrl);
          if (!hasActivityType) {
            break label320;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, activityType.ordinal());
          if (!hasDisplayFormat) {
            break label330;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, displayFormat);
          if (!hasExternalTracking) {
            break label365;
          }
          localByteBuffer.put((byte)1);
          if (externalTracking._cachedId == null) {
            break label340;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, externalTracking._cachedId);
          externalTracking.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasLandingUrl) {
            break label375;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, landingUrl);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label383;
          }
          if (str != null) {
            break label385;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label165;
          localByteBuffer.put((byte)0);
          break label191;
          localByteBuffer.put((byte)1);
          externalTracking.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label251;
          localByteBuffer.put((byte)0);
          break label251;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.SponsoredMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */