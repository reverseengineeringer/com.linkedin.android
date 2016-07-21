package com.linkedin.android.pegasus.gen.voyager.premium.onboarding;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class JobCard
  implements FissileDataModel<JobCard>, RecordTemplate<JobCard>
{
  public static final JobCardBuilder BUILDER = JobCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final int applicantInsightPercent;
  public final long applicantInsightTotal;
  public final MiniCompany company;
  public final boolean hasApplicantInsightPercent;
  public final boolean hasApplicantInsightTotal;
  public final boolean hasCompany;
  public final boolean hasJob;
  public final MiniJob job;
  
  JobCard(MiniJob paramMiniJob, MiniCompany paramMiniCompany, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    job = paramMiniJob;
    company = paramMiniCompany;
    applicantInsightPercent = paramInt;
    applicantInsightTotal = paramLong;
    hasJob = paramBoolean1;
    hasCompany = paramBoolean2;
    hasApplicantInsightPercent = paramBoolean3;
    hasApplicantInsightTotal = paramBoolean4;
    _cachedId = null;
  }
  
  public final JobCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasJob)
    {
      paramDataProcessor.startRecordField$505cff1c("job");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = job.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label214;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label56:
      localObject1 = null;
      bool2 = false;
      if (hasCompany)
      {
        paramDataProcessor.startRecordField$505cff1c("company");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label223;
        }
        localObject1 = company.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label241;
        }
      }
    }
    label214:
    label223:
    label241:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasApplicantInsightPercent)
      {
        paramDataProcessor.startRecordField$505cff1c("applicantInsightPercent");
        paramDataProcessor.processInt(applicantInsightPercent);
      }
      if (hasApplicantInsightTotal)
      {
        paramDataProcessor.startRecordField$505cff1c("applicantInsightTotal");
        paramDataProcessor.processLong(applicantInsightTotal);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label333;
      }
      try
      {
        if (hasJob) {
          break label246;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.onboarding.JobCard", "job");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniJob)paramDataProcessor.processDataTemplate(job);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (MiniCompany)paramDataProcessor.processDataTemplate(company);
      break label95;
    }
    label246:
    if (!hasCompany) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.onboarding.JobCard", "company");
    }
    if (!hasApplicantInsightPercent) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.onboarding.JobCard", "applicantInsightPercent");
    }
    if (!hasApplicantInsightTotal) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.onboarding.JobCard", "applicantInsightTotal");
    }
    return new JobCard((MiniJob)localObject2, (MiniCompany)localObject1, applicantInsightPercent, applicantInsightTotal, bool1, bool2, hasApplicantInsightPercent, hasApplicantInsightTotal);
    label333:
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
      paramObject = (JobCard)paramObject;
      if (job != null)
      {
        if (job.equals(job)) {}
      }
      else {
        while (job != null) {
          return false;
        }
      }
      if (company != null)
      {
        if (company.equals(company)) {}
      }
      else {
        while (company != null) {
          return false;
        }
      }
      if (applicantInsightPercent != applicantInsightPercent) {
        return false;
      }
    } while (applicantInsightTotal == applicantInsightTotal);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    int j;
    if (hasJob)
    {
      if (job._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(job._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasCompany)
      {
        i = j + 1;
        if (company._cachedId == null) {
          break label149;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(company._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasApplicantInsightPercent) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasApplicantInsightTotal) {
        i = j + 8;
      }
      __sizeOfObject = i;
      return i;
      i = job.getSerializedSize() + 7;
      break;
      label149:
      i += company.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (job != null) {}
    for (int i = job.hashCode();; i = 0)
    {
      if (company != null) {
        j = company.hashCode();
      }
      i = (((i + 527) * 31 + j) * 31 + applicantInsightPercent) * 31 + (int)(applicantInsightTotal ^ applicantInsightTotal >>> 32);
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building JobCard");
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
    label230:
    label254:
    label346:
    label371:
    label381:
    label391:
    label399:
    label401:
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
        localByteBuffer.putInt(-1127752799);
        if (hasJob)
        {
          localByteBuffer.put((byte)1);
          if (job._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, job._cachedId);
            job.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasCompany) {
              break label371;
            }
            localByteBuffer.put((byte)1);
            if (company._cachedId == null) {
              break label346;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, company._cachedId);
            company.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasApplicantInsightPercent) {
              break label381;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(applicantInsightPercent);
            if (!hasApplicantInsightTotal) {
              break label391;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putLong(applicantInsightTotal);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label399;
          }
          if (str != null) {
            break label401;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          job.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          company.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)0);
          break label254;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.onboarding.JobCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */