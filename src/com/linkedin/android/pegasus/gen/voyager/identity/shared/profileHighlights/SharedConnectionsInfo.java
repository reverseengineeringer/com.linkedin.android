package com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.HighlightsMiniProfile;
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

public final class SharedConnectionsInfo
  implements FissileDataModel<SharedConnectionsInfo>, RecordTemplate<SharedConnectionsInfo>
{
  public static final SharedConnectionsInfoBuilder BUILDER = SharedConnectionsInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasSharedConnections;
  public final boolean hasTotalCount;
  public final List<HighlightsMiniProfile> sharedConnections;
  public final int totalCount;
  
  SharedConnectionsInfo(Urn paramUrn, List<HighlightsMiniProfile> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    entityUrn = paramUrn;
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      sharedConnections = paramList;
      totalCount = paramInt;
      hasEntityUrn = paramBoolean1;
      hasSharedConnections = paramBoolean2;
      hasTotalCount = paramBoolean3;
      paramList = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
      return;
    }
  }
  
  public final SharedConnectionsInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    Object localObject = null;
    HighlightsMiniProfile localHighlightsMiniProfile = null;
    boolean bool = false;
    if (hasSharedConnections)
    {
      paramDataProcessor.startRecordField$505cff1c("sharedConnections");
      sharedConnections.size();
      paramDataProcessor.startArray$13462e();
      localObject = localHighlightsMiniProfile;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = sharedConnections.iterator();
      if (localIterator.hasNext())
      {
        localHighlightsMiniProfile = (HighlightsMiniProfile)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localHighlightsMiniProfile = localHighlightsMiniProfile.accept(paramDataProcessor);; localHighlightsMiniProfile = (HighlightsMiniProfile)paramDataProcessor.processDataTemplate(localHighlightsMiniProfile))
        {
          if ((localObject != null) && (localHighlightsMiniProfile != null)) {
            ((List)localObject).add(localHighlightsMiniProfile);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label296;
      }
    }
    label296:
    for (bool = true;; bool = false)
    {
      if (hasTotalCount)
      {
        paramDataProcessor.startRecordField$505cff1c("totalCount");
        paramDataProcessor.processInt(totalCount);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label378;
      }
      if (!hasSharedConnections) {
        localObject = Collections.emptyList();
      }
      try
      {
        if (hasTotalCount) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedConnectionsInfo", "totalCount");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (sharedConnections != null)
    {
      paramDataProcessor = sharedConnections.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((HighlightsMiniProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedConnectionsInfo", "sharedConnections");
        }
      }
    }
    return new SharedConnectionsInfo(entityUrn, (List)localObject, totalCount, hasEntityUrn, bool, hasTotalCount);
    label378:
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
      paramObject = (SharedConnectionsInfo)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (sharedConnections != null)
      {
        if (sharedConnections.equals(sharedConnections)) {}
      }
      else {
        while (sharedConnections != null) {
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
    Object localObject;
    if (hasEntityUrn)
    {
      localObject = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    i += 1;
    int j = i;
    if (hasSharedConnections)
    {
      i += 2;
      localObject = sharedConnections.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        HighlightsMiniProfile localHighlightsMiniProfile = (HighlightsMiniProfile)((Iterator)localObject).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localHighlightsMiniProfile.getSerializedSize();
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
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (entityUrn != null) {}
    for (int i = entityUrn.hashCode();; i = 0)
    {
      if (sharedConnections != null) {
        j = sharedConnections.hashCode();
      }
      i = ((i + 527) * 31 + j) * 31 + totalCount;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SharedConnectionsInfo");
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
    label291:
    label358:
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
        localByteBuffer.putInt(1859413630);
        Object localObject;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (hasSharedConnections)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, sharedConnections.size());
            localObject = sharedConnections.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!((Iterator)localObject).hasNext()) {
              break label291;
            }
            HighlightsMiniProfile localHighlightsMiniProfile = (HighlightsMiniProfile)((Iterator)localObject).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localHighlightsMiniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            localHighlightsMiniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
            break label358;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedConnectionsInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */