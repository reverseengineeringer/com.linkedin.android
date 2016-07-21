package com.linkedin.android.pegasus.gen.voyager.relationships.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
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

public final class SharedConnectionsInsight
  implements FissileDataModel<SharedConnectionsInsight>, RecordTemplate<SharedConnectionsInsight>
{
  public static final SharedConnectionsInsightBuilder BUILDER = SharedConnectionsInsightBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<MiniProfile> connections;
  public final boolean hasConnections;
  public final boolean hasTotalCount;
  public final int totalCount;
  
  SharedConnectionsInsight(List<MiniProfile> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      connections = paramList;
      totalCount = paramInt;
      hasConnections = paramBoolean1;
      hasTotalCount = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final SharedConnectionsInsight accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    MiniProfile localMiniProfile = null;
    boolean bool = false;
    if (hasConnections)
    {
      paramDataProcessor.startRecordField$505cff1c("connections");
      connections.size();
      paramDataProcessor.startArray$13462e();
      localObject = localMiniProfile;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = connections.iterator();
      if (localIterator.hasNext())
      {
        localMiniProfile = (MiniProfile)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localMiniProfile = localMiniProfile.accept(paramDataProcessor);; localMiniProfile = (MiniProfile)paramDataProcessor.processDataTemplate(localMiniProfile))
        {
          if ((localObject != null) && (localMiniProfile != null)) {
            ((List)localObject).add(localMiniProfile);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label263;
      }
    }
    label263:
    for (bool = true;; bool = false)
    {
      if (hasTotalCount)
      {
        paramDataProcessor.startRecordField$505cff1c("totalCount");
        paramDataProcessor.processInt(totalCount);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label337;
      }
      if (!hasConnections) {
        localObject = Collections.emptyList();
      }
      try
      {
        if (hasTotalCount) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.SharedConnectionsInsight", "totalCount");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (connections != null)
    {
      paramDataProcessor = connections.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((MiniProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.SharedConnectionsInsight", "connections");
        }
      }
    }
    return new SharedConnectionsInsight((List)localObject, totalCount, bool, hasTotalCount);
    label337:
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
      paramObject = (SharedConnectionsInsight)paramObject;
      if (connections != null)
      {
        if (connections.equals(connections)) {}
      }
      else {
        while (connections != null) {
          return false;
        }
      }
    } while (totalCount == totalCount);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    int j = i;
    if (hasConnections)
    {
      i += 2;
      Iterator localIterator = connections.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        MiniProfile localMiniProfile = (MiniProfile)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localMiniProfile.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasTotalCount) {
      i = j + 4;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (connections != null) {}
    for (int i = connections.hashCode();; i = 0)
    {
      i = (i + 527) * 31 + totalCount;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SharedConnectionsInsight");
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
    label314:
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
        localByteBuffer.putInt(1242379778);
        if (hasConnections)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, connections.size());
          Iterator localIterator = connections.iterator();
          while (localIterator.hasNext())
          {
            MiniProfile localMiniProfile = (MiniProfile)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localMiniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localMiniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasTotalCount)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(totalCount);
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label314;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.SharedConnectionsInsight
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */