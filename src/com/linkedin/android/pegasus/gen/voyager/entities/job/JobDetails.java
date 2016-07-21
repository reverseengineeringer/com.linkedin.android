package com.linkedin.android.pegasus.gen.voyager.entities.job;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class JobDetails
  implements FissileDataModel<JobDetails>, RecordTemplate<JobDetails>
{
  public static final JobDetailsBuilder BUILDER = JobDetailsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String employmentStatus;
  public final String experience;
  public final boolean hasEmploymentStatus;
  public final boolean hasExperience;
  public final boolean hasIndustries;
  public final boolean hasJobFunctions;
  public final boolean hasJobId;
  public final List<String> industries;
  public final List<String> jobFunctions;
  public final long jobId;
  
  JobDetails(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    employmentStatus = paramString1;
    experience = paramString2;
    if (paramList1 == null)
    {
      paramString1 = null;
      jobFunctions = paramString1;
      if (paramList2 != null) {
        break label97;
      }
    }
    label97:
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList2))
    {
      industries = paramString1;
      jobId = paramLong;
      hasEmploymentStatus = paramBoolean1;
      hasExperience = paramBoolean2;
      hasJobFunctions = paramBoolean3;
      hasIndustries = paramBoolean4;
      hasJobId = paramBoolean5;
      _cachedId = null;
      return;
      paramString1 = Collections.unmodifiableList(paramList1);
      break;
    }
  }
  
  public final JobDetails accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEmploymentStatus)
    {
      paramDataProcessor.startRecordField$505cff1c("employmentStatus");
      paramDataProcessor.processString(employmentStatus);
    }
    if (hasExperience)
    {
      paramDataProcessor.startRecordField$505cff1c("experience");
      paramDataProcessor.processString(experience);
    }
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    int i;
    Object localObject3;
    if (hasJobFunctions)
    {
      paramDataProcessor.startRecordField$505cff1c("jobFunctions");
      jobFunctions.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject2 = jobFunctions.iterator();
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
        break label336;
      }
    }
    label336:
    for (bool1 = true;; bool1 = false)
    {
      localObject2 = null;
      localObject3 = null;
      bool2 = false;
      if (!hasIndustries) {
        break label355;
      }
      paramDataProcessor.startRecordField$505cff1c("industries");
      industries.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      localObject3 = industries.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString(str);
        if (localObject2 != null) {
          ((List)localObject2).add(str);
        }
        i += 1;
      }
    }
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label355:
      if (hasJobId)
      {
        paramDataProcessor.startRecordField$505cff1c("jobId");
        paramDataProcessor.processLong(jobId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label574;
      }
      if (!hasJobFunctions) {
        localObject1 = Collections.emptyList();
      }
      if (!hasIndustries) {
        localObject2 = Collections.emptyList();
      }
      try
      {
        if (jobFunctions == null) {
          break;
        }
        paramDataProcessor = jobFunctions.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((String)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.job.JobDetails", "jobFunctions");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (industries != null)
    {
      paramDataProcessor = industries.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.job.JobDetails", "industries");
        }
      }
    }
    return new JobDetails(employmentStatus, experience, (List)localObject1, (List)localObject2, jobId, hasEmploymentStatus, hasExperience, bool1, bool2, hasJobId);
    label574:
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
      paramObject = (JobDetails)paramObject;
      if (employmentStatus != null)
      {
        if (employmentStatus.equals(employmentStatus)) {}
      }
      else {
        while (employmentStatus != null) {
          return false;
        }
      }
      if (experience != null)
      {
        if (experience.equals(experience)) {}
      }
      else {
        while (experience != null) {
          return false;
        }
      }
      if (jobFunctions != null)
      {
        if (jobFunctions.equals(jobFunctions)) {}
      }
      else {
        while (jobFunctions != null) {
          return false;
        }
      }
      if (industries != null)
      {
        if (industries.equals(industries)) {}
      }
      else {
        while (industries != null) {
          return false;
        }
      }
    } while (jobId == jobId);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasEmploymentStatus) {
      i = PegasusBinaryUtils.getEncodedLength(employmentStatus) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasExperience) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(experience);
    }
    i += 1;
    j = i;
    Iterator localIterator;
    if (hasJobFunctions)
    {
      i += 2;
      localIterator = jobFunctions.iterator();
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
    if (hasIndustries)
    {
      i += 2;
      localIterator = industries.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)localIterator.next());
      }
    }
    j += 1;
    i = j;
    if (hasJobId) {
      i = j + 8;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (employmentStatus != null)
    {
      i = employmentStatus.hashCode();
      if (experience == null) {
        break label131;
      }
      j = experience.hashCode();
      label45:
      if (jobFunctions == null) {
        break label136;
      }
    }
    label131:
    label136:
    for (int k = jobFunctions.hashCode();; k = 0)
    {
      if (industries != null) {
        m = industries.hashCode();
      }
      i = ((k + (j + (i + 527) * 31) * 31) * 31 + m) * 31 + (int)(jobId ^ jobId >>> 32);
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building JobDetails");
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
    label245:
    label255:
    label409:
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
        localByteBuffer.putInt(-2088958332);
        if (hasEmploymentStatus)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, employmentStatus);
          if (!hasExperience) {
            break label245;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, experience);
        }
        Iterator localIterator;
        for (;;)
        {
          if (!hasJobFunctions) {
            break label255;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, jobFunctions.size());
          localIterator = jobFunctions.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)localIterator.next());
          }
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
        }
        localByteBuffer.put((byte)0);
        if (hasIndustries)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, industries.size());
          localIterator = industries.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)localIterator.next());
          }
        }
        localByteBuffer.put((byte)0);
        if (hasJobId)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(jobId);
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label409;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.JobDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */