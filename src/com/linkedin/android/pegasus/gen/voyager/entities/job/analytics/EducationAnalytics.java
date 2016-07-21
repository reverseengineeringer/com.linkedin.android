package com.linkedin.android.pegasus.gen.voyager.entities.job.analytics;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class EducationAnalytics
  implements FissileDataModel<EducationAnalytics>, RecordTemplate<EducationAnalytics>
{
  public static final EducationAnalyticsBuilder BUILDER = EducationAnalyticsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final List<DegreeCount> degrees;
  public final List<FieldOfStudy> fieldsOfStudy;
  public final boolean hasDegrees;
  public final boolean hasFieldsOfStudy;
  
  EducationAnalytics(List<FieldOfStudy> paramList, List<DegreeCount> paramList1, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null)
    {
      paramList = null;
      fieldsOfStudy = paramList;
      if (paramList1 != null) {
        break label61;
      }
    }
    label61:
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList1))
    {
      degrees = paramList;
      hasFieldsOfStudy = paramBoolean1;
      hasDegrees = paramBoolean2;
      _cachedId = null;
      return;
      paramList = Collections.unmodifiableList(paramList);
      break;
    }
  }
  
  public final EducationAnalytics accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    int i;
    if (hasFieldsOfStudy)
    {
      paramDataProcessor.startRecordField$505cff1c("fieldsOfStudy");
      fieldsOfStudy.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = fieldsOfStudy.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (FieldOfStudy)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((FieldOfStudy)localObject2).accept(paramDataProcessor);; localObject2 = (FieldOfStudy)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject1 != null) {
        bool1 = true;
      }
    }
    else
    {
      localObject2 = null;
      localObject3 = null;
      bool2 = false;
      if (!hasDegrees) {
        break label365;
      }
      paramDataProcessor.startRecordField$505cff1c("degrees");
      degrees.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = degrees.iterator();
      label257:
      if (!localIterator.hasNext()) {
        break label351;
      }
      localObject3 = (DegreeCount)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label335;
      }
    }
    label335:
    for (Object localObject3 = ((DegreeCount)localObject3).accept(paramDataProcessor);; localObject3 = (DegreeCount)paramDataProcessor.processDataTemplate((DataTemplate)localObject3))
    {
      if ((localObject2 != null) && (localObject3 != null)) {
        ((List)localObject2).add(localObject3);
      }
      i += 1;
      break label257;
      bool1 = false;
      break;
    }
    label351:
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label365:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label535;
      }
      if (!hasFieldsOfStudy) {
        localObject1 = Collections.emptyList();
      }
      if (!hasDegrees) {
        localObject2 = Collections.emptyList();
      }
      try
      {
        if (fieldsOfStudy == null) {
          break;
        }
        paramDataProcessor = fieldsOfStudy.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((FieldOfStudy)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.EducationAnalytics", "fieldsOfStudy");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (degrees != null)
    {
      paramDataProcessor = degrees.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((DegreeCount)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.EducationAnalytics", "degrees");
        }
      }
    }
    return new EducationAnalytics((List)localObject1, (List)localObject2, bool1, bool2);
    label535:
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
      paramObject = (EducationAnalytics)paramObject;
      if (fieldsOfStudy != null)
      {
        if (fieldsOfStudy.equals(fieldsOfStudy)) {}
      }
      else {
        while (fieldsOfStudy != null) {
          return false;
        }
      }
      if (degrees == null) {
        break;
      }
    } while (degrees.equals(degrees));
    for (;;)
    {
      return false;
      if (degrees == null) {
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
    Object localObject;
    if (hasFieldsOfStudy)
    {
      i += 2;
      localIterator = fieldsOfStudy.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (FieldOfStudy)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((FieldOfStudy)localObject).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasDegrees)
    {
      i += 2;
      localIterator = degrees.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (DegreeCount)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((DegreeCount)localObject).getSerializedSize();
        }
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
    if (fieldsOfStudy != null) {}
    for (int i = fieldsOfStudy.hashCode();; i = 0)
    {
      if (degrees != null) {
        j = degrees.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building EducationAnalytics");
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
        localByteBuffer.putInt(-776277535);
        Iterator localIterator;
        Object localObject;
        if (hasFieldsOfStudy)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, fieldsOfStudy.size());
          localIterator = fieldsOfStudy.iterator();
          while (localIterator.hasNext())
          {
            localObject = (FieldOfStudy)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((FieldOfStudy)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((FieldOfStudy)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasDegrees)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, degrees.size());
          localIterator = degrees.iterator();
          while (localIterator.hasNext())
          {
            localObject = (DegreeCount)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((DegreeCount)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((DegreeCount)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.EducationAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */