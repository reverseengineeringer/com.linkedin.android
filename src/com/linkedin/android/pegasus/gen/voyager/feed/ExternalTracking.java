package com.linkedin.android.pegasus.gen.voyager.feed;

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

public final class ExternalTracking
  implements FissileDataModel<ExternalTracking>, RecordTemplate<ExternalTracking>
{
  public static final ExternalTrackingBuilder BUILDER = ExternalTrackingBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<String> clickUrls;
  public final boolean hasClickUrls;
  public final boolean hasImpressionUrls;
  public final List<String> impressionUrls;
  
  ExternalTracking(List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList1 == null)
    {
      paramList1 = null;
      impressionUrls = paramList1;
      if (paramList2 != null) {
        break label61;
      }
    }
    label61:
    for (paramList1 = null;; paramList1 = Collections.unmodifiableList(paramList2))
    {
      clickUrls = paramList1;
      hasImpressionUrls = paramBoolean1;
      hasClickUrls = paramBoolean2;
      _cachedId = null;
      return;
      paramList1 = Collections.unmodifiableList(paramList1);
      break;
    }
  }
  
  public final ExternalTracking accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    int i;
    Object localObject3;
    if (hasImpressionUrls)
    {
      paramDataProcessor.startRecordField$505cff1c("impressionUrls");
      impressionUrls.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject2 = impressionUrls.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString((String)localObject3);
        if (localObject1 != null) {
          ((List)localObject1).add(localObject3);
        }
        i += 1;
      }
      paramDataProcessor.endArray();
      if (localObject1 == null) {
        break label286;
      }
      bool1 = true;
    }
    for (localObject2 = localObject1;; localObject2 = localObject1)
    {
      localObject1 = null;
      localObject3 = null;
      bool2 = false;
      if (!hasClickUrls) {
        break label309;
      }
      paramDataProcessor.startRecordField$505cff1c("clickUrls");
      clickUrls.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = clickUrls.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString(str);
        if (localObject1 != null) {
          ((List)localObject1).add(str);
        }
        i += 1;
      }
      label286:
      bool1 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label309:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label493;
      }
      try
      {
        if (hasImpressionUrls) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ExternalTracking", "impressionUrls");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasClickUrls) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.ExternalTracking", "clickUrls");
    }
    if (impressionUrls != null)
    {
      paramDataProcessor = impressionUrls.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.ExternalTracking", "impressionUrls");
        }
      }
    }
    if (clickUrls != null)
    {
      paramDataProcessor = clickUrls.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.ExternalTracking", "clickUrls");
        }
      }
    }
    return new ExternalTracking((List)localObject2, (List)localObject1, bool1, bool2);
    label493:
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
      paramObject = (ExternalTracking)paramObject;
      if (impressionUrls != null)
      {
        if (impressionUrls.equals(impressionUrls)) {}
      }
      else {
        while (impressionUrls != null) {
          return false;
        }
      }
      if (clickUrls == null) {
        break;
      }
    } while (clickUrls.equals(clickUrls));
    for (;;)
    {
      return false;
      if (clickUrls == null) {
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
    int j = i;
    Iterator localIterator;
    if (hasImpressionUrls)
    {
      i += 2;
      localIterator = impressionUrls.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)localIterator.next());
      }
    }
    i = j + 1;
    j = i;
    if (hasClickUrls)
    {
      i += 2;
      localIterator = clickUrls.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)localIterator.next());
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (impressionUrls != null) {}
    for (int i = impressionUrls.hashCode();; i = 0)
    {
      if (clickUrls != null) {
        j = clickUrls.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ExternalTracking");
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
        localByteBuffer.putInt(659231976);
        Iterator localIterator;
        if (hasImpressionUrls)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, impressionUrls.size());
          localIterator = impressionUrls.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)localIterator.next());
          }
        }
        localByteBuffer.put((byte)0);
        if (hasClickUrls)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, clickUrls.size());
          localIterator = clickUrls.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)localIterator.next());
          }
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ExternalTracking
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */