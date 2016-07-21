package com.linkedin.android.pegasus.gen.voyager.entities.shared;

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

public final class InNetworkReason
  implements FissileDataModel<InNetworkReason>, RecordTemplate<InNetworkReason>
{
  public static final InNetworkReasonBuilder BUILDER = InNetworkReasonBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasTopConnections;
  public final boolean hasTotalNumberOfConnections;
  public final List<EntitiesMiniProfile> topConnections;
  public final int totalNumberOfConnections;
  
  InNetworkReason(int paramInt, List<EntitiesMiniProfile> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    totalNumberOfConnections = paramInt;
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      topConnections = paramList;
      hasTotalNumberOfConnections = paramBoolean1;
      hasTopConnections = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final InNetworkReason accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTotalNumberOfConnections)
    {
      paramDataProcessor.startRecordField$505cff1c("totalNumberOfConnections");
      paramDataProcessor.processInt(totalNumberOfConnections);
    }
    Object localObject = null;
    EntitiesMiniProfile localEntitiesMiniProfile = null;
    boolean bool = false;
    if (hasTopConnections)
    {
      paramDataProcessor.startRecordField$505cff1c("topConnections");
      topConnections.size();
      paramDataProcessor.startArray$13462e();
      localObject = localEntitiesMiniProfile;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = topConnections.iterator();
      if (localIterator.hasNext())
      {
        localEntitiesMiniProfile = (EntitiesMiniProfile)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localEntitiesMiniProfile = localEntitiesMiniProfile.accept(paramDataProcessor);; localEntitiesMiniProfile = (EntitiesMiniProfile)paramDataProcessor.processDataTemplate(localEntitiesMiniProfile))
        {
          if ((localObject != null) && (localEntitiesMiniProfile != null)) {
            ((List)localObject).add(localEntitiesMiniProfile);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label251;
      }
    }
    label251:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label344;
      }
      try
      {
        if (hasTotalNumberOfConnections) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.InNetworkReason", "totalNumberOfConnections");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasTopConnections) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.InNetworkReason", "topConnections");
    }
    if (topConnections != null)
    {
      paramDataProcessor = topConnections.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((EntitiesMiniProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.shared.InNetworkReason", "topConnections");
        }
      }
    }
    return new InNetworkReason(totalNumberOfConnections, (List)localObject, hasTotalNumberOfConnections, bool);
    label344:
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
      paramObject = (InNetworkReason)paramObject;
      if (totalNumberOfConnections != totalNumberOfConnections) {
        return false;
      }
      if (topConnections == null) {
        break;
      }
    } while (topConnections.equals(topConnections));
    for (;;)
    {
      return false;
      if (topConnections == null) {
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
    if (hasTotalNumberOfConnections) {
      i = j + 4;
    }
    i += 1;
    j = i;
    if (hasTopConnections)
    {
      i += 2;
      Iterator localIterator = topConnections.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        EntitiesMiniProfile localEntitiesMiniProfile = (EntitiesMiniProfile)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localEntitiesMiniProfile.getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int j = totalNumberOfConnections;
    if (topConnections != null) {}
    for (int i = topConnections.hashCode();; i = 0)
    {
      i = (j + 527) * 31 + i;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building InNetworkReason");
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
    label281:
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
        localByteBuffer.putInt(1090454533);
        Iterator localIterator;
        if (hasTotalNumberOfConnections)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(totalNumberOfConnections);
          if (hasTopConnections)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, topConnections.size());
            localIterator = topConnections.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label281;
            }
            EntitiesMiniProfile localEntitiesMiniProfile = (EntitiesMiniProfile)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localEntitiesMiniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            localEntitiesMiniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.InNetworkReason
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */