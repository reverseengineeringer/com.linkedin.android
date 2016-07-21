package com.linkedin.android.pegasus.gen.videocontent;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ProgressiveDownloadMetadata
  implements FissileDataModel<ProgressiveDownloadMetadata>, RecordTemplate<ProgressiveDownloadMetadata>
{
  public static final ProgressiveDownloadMetadataBuilder BUILDER = ProgressiveDownloadMetadataBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final int bitRate;
  public final boolean hasBitRate;
  public final boolean hasHeight;
  public final boolean hasSize;
  public final boolean hasStreamingLocations;
  public final boolean hasThumbnail;
  public final boolean hasWidth;
  public final int height;
  public final long size;
  public final List<StreamingLocation> streamingLocations;
  public final Thumbnail thumbnail;
  public final int width;
  
  ProgressiveDownloadMetadata(int paramInt1, int paramInt2, List<StreamingLocation> paramList, long paramLong, int paramInt3, Thumbnail paramThumbnail, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    width = paramInt1;
    height = paramInt2;
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      streamingLocations = paramList;
      size = paramLong;
      bitRate = paramInt3;
      thumbnail = paramThumbnail;
      hasWidth = paramBoolean1;
      hasHeight = paramBoolean2;
      hasStreamingLocations = paramBoolean3;
      hasSize = paramBoolean4;
      hasBitRate = paramBoolean5;
      hasThumbnail = paramBoolean6;
      return;
    }
  }
  
  public final ProgressiveDownloadMetadata accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasWidth)
    {
      paramDataProcessor.startRecordField$505cff1c("width");
      paramDataProcessor.processInt(width);
    }
    if (hasHeight)
    {
      paramDataProcessor.startRecordField$505cff1c("height");
      paramDataProcessor.processInt(height);
    }
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    if (hasStreamingLocations)
    {
      paramDataProcessor.startRecordField$505cff1c("streamingLocations");
      streamingLocations.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = streamingLocations.iterator();
      if (localIterator.hasNext())
      {
        localObject2 = (StreamingLocation)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((StreamingLocation)localObject2).accept(paramDataProcessor);; localObject2 = (StreamingLocation)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject1 != null)
      {
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasSize)
      {
        paramDataProcessor.startRecordField$505cff1c("size");
        paramDataProcessor.processLong(size);
      }
      if (hasBitRate)
      {
        paramDataProcessor.startRecordField$505cff1c("bitRate");
        paramDataProcessor.processInt(bitRate);
      }
      localObject1 = null;
      bool2 = false;
      if (hasThumbnail)
      {
        paramDataProcessor.startRecordField$505cff1c("thumbnail");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label401;
        }
        localObject1 = thumbnail.accept(paramDataProcessor);
        label322:
        if (localObject1 == null) {
          break label419;
        }
      }
    }
    label401:
    label419:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label425;
      }
      return new ProgressiveDownloadMetadata(width, height, (List)localObject2, size, bitRate, (Thumbnail)localObject1, hasWidth, hasHeight, bool1, hasSize, hasBitRate, bool2);
      bool1 = false;
      localObject2 = localObject1;
      break;
      localObject1 = (Thumbnail)paramDataProcessor.processDataTemplate(thumbnail);
      break label322;
    }
    label425:
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
      paramObject = (ProgressiveDownloadMetadata)paramObject;
      if (width != width) {
        return false;
      }
      if (height != height) {
        return false;
      }
      if (streamingLocations != null)
      {
        if (streamingLocations.equals(streamingLocations)) {}
      }
      else {
        while (streamingLocations != null) {
          return false;
        }
      }
      if (size != size) {
        return false;
      }
      if (bitRate != bitRate) {
        return false;
      }
      if (thumbnail == null) {
        break;
      }
    } while (thumbnail.equals(thumbnail));
    for (;;)
    {
      return false;
      if (thumbnail == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasWidth) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasHeight) {
      i = j + 4;
    }
    i += 1;
    j = i;
    if (hasStreamingLocations)
    {
      i += 2;
      Iterator localIterator = streamingLocations.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i + 1 + ((StreamingLocation)localIterator.next()).getSerializedSize();
      }
    }
    j += 1;
    i = j;
    if (hasSize) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasBitRate) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasThumbnail) {
      i = j + 1 + thumbnail.getSerializedSize();
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int k = width;
    int m = height;
    if (streamingLocations != null) {}
    for (int i = streamingLocations.hashCode();; i = 0)
    {
      int n = (int)(size ^ size >>> 32);
      int i1 = bitRate;
      if (thumbnail != null) {
        j = thumbnail.hashCode();
      }
      i = (((i + ((k + 527) * 31 + m) * 31) * 31 + n) * 31 + i1) * 31 + j;
      _cachedHashCode = i;
      return i;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ProgressiveDownloadMetadata");
    }
    if (paramBoolean) {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
    }
    label227:
    label237:
    label292:
    label366:
    label376:
    label384:
    for (;;)
    {
      return;
      ByteBuffer localByteBuffer = paramByteBuffer;
      if (paramByteBuffer == null) {
        localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
      }
      localByteBuffer.put((byte)1);
      localByteBuffer.putInt(1078079280);
      if (hasWidth)
      {
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(width);
        if (!hasHeight) {
          break label227;
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(height);
      }
      for (;;)
      {
        if (!hasStreamingLocations) {
          break label237;
        }
        localByteBuffer.put((byte)1);
        paramFissionAdapter.writeUnsignedShort(localByteBuffer, streamingLocations.size());
        Iterator localIterator = streamingLocations.iterator();
        while (localIterator.hasNext())
        {
          StreamingLocation localStreamingLocation = (StreamingLocation)localIterator.next();
          localByteBuffer.put((byte)1);
          localStreamingLocation.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        break;
        localByteBuffer.put((byte)0);
      }
      localByteBuffer.put((byte)0);
      if (hasSize)
      {
        localByteBuffer.put((byte)1);
        localByteBuffer.putLong(size);
        if (!hasBitRate) {
          break label366;
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(bitRate);
        if (!hasThumbnail) {
          break label376;
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.put((byte)1);
        thumbnail.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
      }
      for (;;)
      {
        if (paramByteBuffer != null) {
          break label384;
        }
        paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
        return;
        localByteBuffer.put((byte)0);
        break;
        localByteBuffer.put((byte)0);
        break label292;
        localByteBuffer.put((byte)0);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.videocontent.ProgressiveDownloadMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */