package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class MediaProcessorConfig
  implements FissileDataModel<MediaProcessorConfig>, RecordTemplate<MediaProcessorConfig>
{
  public static final MediaProcessorConfigBuilder BUILDER = MediaProcessorConfigBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final MediaProcessorFilters filters;
  public final boolean hasFilters;
  public final boolean hasSizes;
  public final List<MediaProcessorSize> sizes;
  
  MediaProcessorConfig(MediaProcessorFilters paramMediaProcessorFilters, List<MediaProcessorSize> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    filters = paramMediaProcessorFilters;
    if (paramList == null) {}
    for (paramMediaProcessorFilters = null;; paramMediaProcessorFilters = Collections.unmodifiableList(paramList))
    {
      sizes = paramMediaProcessorFilters;
      hasFilters = paramBoolean1;
      hasSizes = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final MediaProcessorConfig accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    int i;
    if (hasFilters)
    {
      paramDataProcessor.startRecordField$505cff1c("filters");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = filters.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label222;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localMediaProcessorSize = null;
      bool2 = false;
      if (!hasSizes) {
        break label261;
      }
      paramDataProcessor.startRecordField$505cff1c("sizes");
      sizes.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localMediaProcessorSize;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = sizes.iterator();
      label131:
      if (!localIterator.hasNext()) {
        break label247;
      }
      localMediaProcessorSize = (MediaProcessorSize)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label231;
      }
    }
    label222:
    label231:
    for (MediaProcessorSize localMediaProcessorSize = localMediaProcessorSize.accept(paramDataProcessor);; localMediaProcessorSize = (MediaProcessorSize)paramDataProcessor.processDataTemplate(localMediaProcessorSize))
    {
      if ((localObject1 != null) && (localMediaProcessorSize != null)) {
        ((List)localObject1).add(localMediaProcessorSize);
      }
      i += 1;
      break label131;
      localObject1 = (MediaProcessorFilters)paramDataProcessor.processDataTemplate(filters);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
    }
    label247:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label261:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label395;
      }
      try
      {
        if (hasFilters) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorConfig", "filters");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasSizes) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorConfig", "sizes");
    }
    if (sizes != null)
    {
      paramDataProcessor = sizes.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((MediaProcessorSize)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorConfig", "sizes");
        }
      }
    }
    return new MediaProcessorConfig((MediaProcessorFilters)localObject2, (List)localObject1, bool1, bool2);
    label395:
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
      paramObject = (MediaProcessorConfig)paramObject;
      if (filters != null)
      {
        if (filters.equals(filters)) {}
      }
      else {
        while (filters != null) {
          return false;
        }
      }
      if (sizes == null) {
        break;
      }
    } while (sizes.equals(sizes));
    for (;;)
    {
      return false;
      if (sizes == null) {
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
    int j;
    Iterator localIterator;
    if (hasFilters)
    {
      if (filters._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(filters._cachedId) + 9;
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasSizes) {
        break label153;
      }
      i += 2;
      localIterator = sizes.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label153;
      }
      MediaProcessorSize localMediaProcessorSize = (MediaProcessorSize)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = filters.getSerializedSize() + 7;
        break;
      }
      i += localMediaProcessorSize.getSerializedSize();
    }
    label153:
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (filters != null) {}
    for (int i = filters.hashCode();; i = 0)
    {
      if (sizes != null) {
        j = sizes.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MediaProcessorConfig");
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
    label335:
    label342:
    do
    {
      ByteBuffer localByteBuffer;
      do
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(328909338);
        Iterator localIterator;
        if (hasFilters)
        {
          localByteBuffer.put((byte)1);
          if (filters._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, filters._cachedId);
            filters.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasSizes) {
              break label335;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, sizes.size());
            localIterator = sizes.iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label342;
          }
          MediaProcessorSize localMediaProcessorSize = (MediaProcessorSize)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localMediaProcessorSize.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            filters.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
          }
          localByteBuffer.put((byte)1);
          localMediaProcessorSize.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
      } while (paramByteBuffer != null);
      if (str == null)
      {
        paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
        return;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */