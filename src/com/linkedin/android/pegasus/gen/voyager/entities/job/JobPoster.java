package com.linkedin.android.pegasus.gen.voyager.entities.job;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class JobPoster
  implements FissileDataModel<JobPoster>, RecordTemplate<JobPoster>
{
  public static final JobPosterBuilder BUILDER = JobPosterBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<EntitiesMiniProfile> connections;
  public final boolean hasConnections;
  public final boolean hasPagingInfo;
  public final boolean hasPoster;
  public final PagingInfo pagingInfo;
  public final EntitiesMiniProfile poster;
  
  JobPoster(EntitiesMiniProfile paramEntitiesMiniProfile, List<EntitiesMiniProfile> paramList, PagingInfo paramPagingInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    poster = paramEntitiesMiniProfile;
    if (paramList == null) {}
    for (paramEntitiesMiniProfile = null;; paramEntitiesMiniProfile = Collections.unmodifiableList(paramList))
    {
      connections = paramEntitiesMiniProfile;
      pagingInfo = paramPagingInfo;
      hasPoster = paramBoolean1;
      hasConnections = paramBoolean2;
      hasPagingInfo = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final JobPoster accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject3 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    boolean bool2;
    int i;
    if (hasPoster)
    {
      paramDataProcessor.startRecordField$505cff1c("poster");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = poster.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label222;
        }
        bool1 = true;
        localObject3 = localObject1;
      }
    }
    else
    {
      localObject1 = null;
      localObject2 = null;
      bool2 = false;
      if (!hasConnections) {
        break label261;
      }
      paramDataProcessor.startRecordField$505cff1c("connections");
      connections.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = connections.iterator();
      label131:
      if (!localIterator.hasNext()) {
        break label247;
      }
      localObject2 = (EntitiesMiniProfile)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label231;
      }
    }
    label222:
    label231:
    for (Object localObject2 = ((EntitiesMiniProfile)localObject2).accept(paramDataProcessor);; localObject2 = (EntitiesMiniProfile)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label131;
      localObject1 = (EntitiesMiniProfile)paramDataProcessor.processDataTemplate(poster);
      break;
      bool1 = false;
      localObject3 = localObject1;
      break label56;
    }
    label247:
    paramDataProcessor.endArray();
    if (localObject1 != null)
    {
      bool2 = true;
      label261:
      localObject2 = null;
      bool3 = false;
      if (hasPagingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("pagingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label371;
        }
        localObject2 = pagingInfo.accept(paramDataProcessor);
        label301:
        if (localObject2 == null) {
          break label389;
        }
      }
    }
    label371:
    label389:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label483;
      }
      if (!hasConnections) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasPoster) {
          break label395;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.JobPoster", "poster");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      bool2 = false;
      break;
      localObject2 = (PagingInfo)paramDataProcessor.processDataTemplate(pagingInfo);
      break label301;
    }
    label395:
    if (!hasPagingInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.JobPoster", "pagingInfo");
    }
    if (connections != null)
    {
      paramDataProcessor = connections.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((EntitiesMiniProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.job.JobPoster", "connections");
        }
      }
    }
    return new JobPoster((EntitiesMiniProfile)localObject3, (List)localObject1, (PagingInfo)localObject2, bool1, bool2, bool3);
    label483:
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
      paramObject = (JobPoster)paramObject;
      if (poster != null)
      {
        if (poster.equals(poster)) {}
      }
      else {
        while (poster != null) {
          return false;
        }
      }
      if (connections != null)
      {
        if (connections.equals(connections)) {}
      }
      else {
        while (connections != null) {
          return false;
        }
      }
      if (pagingInfo == null) {
        break;
      }
    } while (pagingInfo.equals(pagingInfo));
    for (;;)
    {
      return false;
      if (pagingInfo == null) {
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
    if (hasPoster)
    {
      if (poster._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(poster._cachedId) + 9;
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasConnections) {
        break label153;
      }
      i += 2;
      localIterator = connections.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label153;
      }
      EntitiesMiniProfile localEntitiesMiniProfile = (EntitiesMiniProfile)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = poster.getSerializedSize() + 7;
        break;
      }
      i += localEntitiesMiniProfile.getSerializedSize();
    }
    label153:
    j += 1;
    i = j;
    if (hasPagingInfo)
    {
      i = j + 1;
      if (pagingInfo._cachedId == null) {
        break label202;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(pagingInfo._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label202:
      i += pagingInfo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (poster != null)
    {
      i = poster.hashCode();
      if (connections == null) {
        break label89;
      }
    }
    label89:
    for (int j = connections.hashCode();; j = 0)
    {
      if (pagingInfo != null) {
        k = pagingInfo.hashCode();
      }
      i = (j + (i + 527) * 31) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building JobPoster");
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
    label470:
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
        localByteBuffer.putInt(1101551008);
        Iterator localIterator;
        if (hasPoster)
        {
          localByteBuffer.put((byte)1);
          if (poster._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, poster._cachedId);
            poster.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasConnections) {
              break label335;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, connections.size());
            localIterator = connections.iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label342;
          }
          EntitiesMiniProfile localEntitiesMiniProfile = (EntitiesMiniProfile)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localEntitiesMiniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            poster.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
          }
          localByteBuffer.put((byte)1);
          localEntitiesMiniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasPagingInfo)
        {
          localByteBuffer.put((byte)1);
          if (pagingInfo._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, pagingInfo._cachedId);
            pagingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label470;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          pagingInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.JobPoster
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */