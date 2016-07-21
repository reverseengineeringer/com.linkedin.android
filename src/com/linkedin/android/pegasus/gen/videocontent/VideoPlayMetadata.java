package com.linkedin.android.pegasus.gen.videocontent;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class VideoPlayMetadata
  implements FissileDataModel<VideoPlayMetadata>, RecordTemplate<VideoPlayMetadata>
{
  public static final VideoPlayMetadataBuilder BUILDER = VideoPlayMetadataBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final long duration;
  public final boolean hasDuration;
  public final boolean hasMedia;
  public final boolean hasProgressiveStreams;
  public final boolean hasTrackingId;
  public final String media;
  public final List<ProgressiveDownloadMetadata> progressiveStreams;
  public final String trackingId;
  
  VideoPlayMetadata(String paramString1, String paramString2, long paramLong, List<ProgressiveDownloadMetadata> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    media = paramString1;
    trackingId = paramString2;
    duration = paramLong;
    if (paramList == null) {}
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList))
    {
      progressiveStreams = paramString1;
      hasMedia = paramBoolean1;
      hasTrackingId = paramBoolean2;
      hasDuration = paramBoolean3;
      hasProgressiveStreams = paramBoolean4;
      return;
    }
  }
  
  public final VideoPlayMetadata accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasMedia)
    {
      paramDataProcessor.startRecordField$505cff1c("media");
      paramDataProcessor.processString(media);
    }
    if (hasTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingId");
      paramDataProcessor.processString(trackingId);
    }
    if (hasDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("duration");
      paramDataProcessor.processLong(duration);
    }
    Object localObject = null;
    ProgressiveDownloadMetadata localProgressiveDownloadMetadata = null;
    boolean bool = false;
    if (hasProgressiveStreams)
    {
      paramDataProcessor.startRecordField$505cff1c("progressiveStreams");
      progressiveStreams.size();
      paramDataProcessor.startArray$13462e();
      localObject = localProgressiveDownloadMetadata;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = progressiveStreams.iterator();
      if (localIterator.hasNext())
      {
        localProgressiveDownloadMetadata = (ProgressiveDownloadMetadata)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localProgressiveDownloadMetadata = localProgressiveDownloadMetadata.accept(paramDataProcessor);; localProgressiveDownloadMetadata = (ProgressiveDownloadMetadata)paramDataProcessor.processDataTemplate(localProgressiveDownloadMetadata))
        {
          if ((localObject != null) && (localProgressiveDownloadMetadata != null)) {
            ((List)localObject).add(localProgressiveDownloadMetadata);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label307;
      }
    }
    label307:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break;
      }
      return new VideoPlayMetadata(media, trackingId, duration, (List)localObject, hasMedia, hasTrackingId, hasDuration, bool);
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
      paramObject = (VideoPlayMetadata)paramObject;
      if (media != null)
      {
        if (media.equals(media)) {}
      }
      else {
        while (media != null) {
          return false;
        }
      }
      if (trackingId != null)
      {
        if (trackingId.equals(trackingId)) {}
      }
      else {
        while (trackingId != null) {
          return false;
        }
      }
      if (duration != duration) {
        return false;
      }
      if (progressiveStreams == null) {
        break;
      }
    } while (progressiveStreams.equals(progressiveStreams));
    for (;;)
    {
      return false;
      if (progressiveStreams == null) {
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
    if (hasMedia) {
      i = PegasusBinaryUtils.getEncodedLength(media) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasTrackingId) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(trackingId);
    }
    j = i + 1;
    i = j;
    if (hasDuration) {
      i = j + 8;
    }
    i += 1;
    j = i;
    if (hasProgressiveStreams)
    {
      i += 2;
      Iterator localIterator = progressiveStreams.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i + 1 + ((ProgressiveDownloadMetadata)localIterator.next()).getSerializedSize();
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (media != null)
    {
      i = media.hashCode();
      if (trackingId == null) {
        break label110;
      }
    }
    label110:
    for (int j = trackingId.hashCode();; j = 0)
    {
      int m = (int)(duration ^ duration >>> 32);
      if (progressiveStreams != null) {
        k = progressiveStreams.hashCode();
      }
      i = ((j + (i + 527) * 31) * 31 + m) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
    }
  }
  
  public final String id()
  {
    return null;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    if ((paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building VideoPlayMetadata");
    }
    if (paramBoolean) {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
    }
    ByteBuffer localByteBuffer;
    label134:
    label255:
    label265:
    label275:
    do
    {
      return;
      localByteBuffer = paramByteBuffer;
      if (paramByteBuffer == null) {
        localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
      }
      localByteBuffer.put((byte)1);
      localByteBuffer.putInt(52369227);
      if (hasMedia)
      {
        localByteBuffer.put((byte)1);
        paramFissionAdapter.writeString(localByteBuffer, media);
        if (!hasTrackingId) {
          break label255;
        }
        localByteBuffer.put((byte)1);
        paramFissionAdapter.writeString(localByteBuffer, trackingId);
        if (!hasDuration) {
          break label265;
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putLong(duration);
      }
      for (;;)
      {
        if (!hasProgressiveStreams) {
          break label275;
        }
        localByteBuffer.put((byte)1);
        paramFissionAdapter.writeUnsignedShort(localByteBuffer, progressiveStreams.size());
        Iterator localIterator = progressiveStreams.iterator();
        while (localIterator.hasNext())
        {
          ProgressiveDownloadMetadata localProgressiveDownloadMetadata = (ProgressiveDownloadMetadata)localIterator.next();
          localByteBuffer.put((byte)1);
          localProgressiveDownloadMetadata.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        break;
        localByteBuffer.put((byte)0);
        break label134;
        localByteBuffer.put((byte)0);
      }
      localByteBuffer.put((byte)0);
    } while (paramByteBuffer != null);
    paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
    paramFissionAdapter.recycle(localByteBuffer);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.videocontent.VideoPlayMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */