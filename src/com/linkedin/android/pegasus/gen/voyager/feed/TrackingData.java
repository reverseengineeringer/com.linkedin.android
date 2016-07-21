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

public final class TrackingData
  implements FissileDataModel<TrackingData>, RecordTemplate<TrackingData>
{
  public static final TrackingDataBuilder BUILDER = TrackingDataBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasRequestId;
  public final boolean hasSponsoredTracking;
  public final boolean hasTrackingId;
  public final String requestId;
  public final SponsoredMetadata sponsoredTracking;
  public final String trackingId;
  
  TrackingData(String paramString1, SponsoredMetadata paramSponsoredMetadata, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    trackingId = paramString1;
    sponsoredTracking = paramSponsoredMetadata;
    requestId = paramString2;
    hasTrackingId = paramBoolean1;
    hasSponsoredTracking = paramBoolean2;
    hasRequestId = paramBoolean3;
    _cachedId = null;
  }
  
  public final TrackingData accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingId");
      paramDataProcessor.processString(trackingId);
    }
    SponsoredMetadata localSponsoredMetadata = null;
    boolean bool = false;
    if (hasSponsoredTracking)
    {
      paramDataProcessor.startRecordField$505cff1c("sponsoredTracking");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label143;
      }
      localSponsoredMetadata = sponsoredTracking.accept(paramDataProcessor);
      if (localSponsoredMetadata == null) {
        break label160;
      }
    }
    label143:
    label160:
    for (bool = true;; bool = false)
    {
      if (hasRequestId)
      {
        paramDataProcessor.startRecordField$505cff1c("requestId");
        paramDataProcessor.processString(requestId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label191;
      }
      try
      {
        if (hasTrackingId) {
          break label165;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.TrackingData", "trackingId");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localSponsoredMetadata = (SponsoredMetadata)paramDataProcessor.processDataTemplate(sponsoredTracking);
      break;
    }
    label165:
    return new TrackingData(trackingId, localSponsoredMetadata, requestId, hasTrackingId, bool, hasRequestId);
    label191:
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
      paramObject = (TrackingData)paramObject;
      if (sponsoredTracking != null)
      {
        if (sponsoredTracking.equals(sponsoredTracking)) {}
      }
      else {
        while (sponsoredTracking != null) {
          return false;
        }
      }
      if (requestId == null) {
        break;
      }
    } while (requestId.equals(requestId));
    for (;;)
    {
      return false;
      if (requestId == null) {
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
    if (hasTrackingId) {
      i = PegasusBinaryUtils.getEncodedLength(trackingId) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasSponsoredTracking)
    {
      i = j + 1;
      if (sponsoredTracking._cachedId == null) {
        break label112;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(sponsoredTracking._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasRequestId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(requestId);
      }
      __sizeOfObject = i;
      return i;
      label112:
      i += sponsoredTracking.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (sponsoredTracking != null) {}
    for (int i = sponsoredTracking.hashCode();; i = 0)
    {
      if (requestId != null) {
        j = requestId.hashCode();
      }
      i = (i + 527) * 31 + j;
      _cachedHashCode = i;
      return i;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building TrackingData");
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
    label196:
    label265:
    label290:
    label300:
    label308:
    label310:
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
        localByteBuffer.putInt(-808372463);
        if (hasTrackingId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
          if (!hasSponsoredTracking) {
            break label290;
          }
          localByteBuffer.put((byte)1);
          if (sponsoredTracking._cachedId == null) {
            break label265;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, sponsoredTracking._cachedId);
          sponsoredTracking.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasRequestId) {
            break label300;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, requestId);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label308;
          }
          if (str != null) {
            break label310;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          sponsoredTracking.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label196;
          localByteBuffer.put((byte)0);
          break label196;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.TrackingData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */