package com.linkedin.android.pegasus.gen.voyager.entities.job;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniProfileWithDistance;
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

public final class SimilarJobTitlesEmployees
  implements FissileDataModel<SimilarJobTitlesEmployees>, RecordTemplate<SimilarJobTitlesEmployees>
{
  public static final SimilarJobTitlesEmployeesBuilder BUILDER = SimilarJobTitlesEmployeesBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasPeopleWithDistance;
  public final boolean hasTotal;
  public final List<MiniProfileWithDistance> peopleWithDistance;
  public final int total;
  
  SimilarJobTitlesEmployees(List<MiniProfileWithDistance> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      peopleWithDistance = paramList;
      total = paramInt;
      hasPeopleWithDistance = paramBoolean1;
      hasTotal = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final SimilarJobTitlesEmployees accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    MiniProfileWithDistance localMiniProfileWithDistance = null;
    boolean bool = false;
    if (hasPeopleWithDistance)
    {
      paramDataProcessor.startRecordField$505cff1c("peopleWithDistance");
      peopleWithDistance.size();
      paramDataProcessor.startArray$13462e();
      localObject = localMiniProfileWithDistance;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = peopleWithDistance.iterator();
      if (localIterator.hasNext())
      {
        localMiniProfileWithDistance = (MiniProfileWithDistance)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localMiniProfileWithDistance = localMiniProfileWithDistance.accept(paramDataProcessor);; localMiniProfileWithDistance = (MiniProfileWithDistance)paramDataProcessor.processDataTemplate(localMiniProfileWithDistance))
        {
          if ((localObject != null) && (localMiniProfileWithDistance != null)) {
            ((List)localObject).add(localMiniProfileWithDistance);
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
      if (hasTotal)
      {
        paramDataProcessor.startRecordField$505cff1c("total");
        paramDataProcessor.processInt(total);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label344;
      }
      try
      {
        if (hasPeopleWithDistance) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.SimilarJobTitlesEmployees", "peopleWithDistance");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasTotal) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.SimilarJobTitlesEmployees", "total");
    }
    if (peopleWithDistance != null)
    {
      paramDataProcessor = peopleWithDistance.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((MiniProfileWithDistance)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.job.SimilarJobTitlesEmployees", "peopleWithDistance");
        }
      }
    }
    return new SimilarJobTitlesEmployees((List)localObject, total, bool, hasTotal);
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
      paramObject = (SimilarJobTitlesEmployees)paramObject;
      if (peopleWithDistance != null)
      {
        if (peopleWithDistance.equals(peopleWithDistance)) {}
      }
      else {
        while (peopleWithDistance != null) {
          return false;
        }
      }
    } while (total == total);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    int j = i;
    if (hasPeopleWithDistance)
    {
      i += 2;
      Iterator localIterator = peopleWithDistance.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        MiniProfileWithDistance localMiniProfileWithDistance = (MiniProfileWithDistance)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localMiniProfileWithDistance.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasTotal) {
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
    if (peopleWithDistance != null) {}
    for (int i = peopleWithDistance.hashCode();; i = 0)
    {
      i = (i + 527) * 31 + total;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SimilarJobTitlesEmployees");
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
        localByteBuffer.putInt(764406402);
        if (hasPeopleWithDistance)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, peopleWithDistance.size());
          Iterator localIterator = peopleWithDistance.iterator();
          while (localIterator.hasNext())
          {
            MiniProfileWithDistance localMiniProfileWithDistance = (MiniProfileWithDistance)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localMiniProfileWithDistance.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localMiniProfileWithDistance.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasTotal)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(total);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.SimilarJobTitlesEmployees
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */