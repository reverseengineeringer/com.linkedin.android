package com.linkedin.android.pegasus.gen.voyager.entities.job;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class NextJob
  implements FissileDataModel<NextJob>, RecordTemplate<NextJob>
{
  public static final NextJobBuilder BUILDER = NextJobBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final long applicantCounts;
  public final String companyName;
  public final Urn entityUrn;
  public final boolean hasApplicantCounts;
  public final boolean hasCompanyName;
  public final boolean hasEntityUrn;
  public final boolean hasMiniJob;
  public final MiniJob miniJob;
  
  NextJob(Urn paramUrn, MiniJob paramMiniJob, String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    entityUrn = paramUrn;
    miniJob = paramMiniJob;
    companyName = paramString;
    applicantCounts = paramLong;
    hasEntityUrn = paramBoolean1;
    hasMiniJob = paramBoolean2;
    hasCompanyName = paramBoolean3;
    hasApplicantCounts = paramBoolean4;
    paramMiniJob = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  public final NextJob accept(DataProcessor paramDataProcessor)
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
    boolean bool = false;
    if (hasMiniJob)
    {
      paramDataProcessor.startRecordField$505cff1c("miniJob");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label175;
      }
      localObject = miniJob.accept(paramDataProcessor);
      if (localObject == null) {
        break label192;
      }
    }
    label175:
    label192:
    for (bool = true;; bool = false)
    {
      if (hasCompanyName)
      {
        paramDataProcessor.startRecordField$505cff1c("companyName");
        paramDataProcessor.processString(companyName);
      }
      if (hasApplicantCounts)
      {
        paramDataProcessor.startRecordField$505cff1c("applicantCounts");
        paramDataProcessor.processLong(applicantCounts);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label231;
      }
      try
      {
        if (hasMiniJob) {
          break label197;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.NextJob", "miniJob");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (MiniJob)paramDataProcessor.processDataTemplate(miniJob);
      break;
    }
    label197:
    return new NextJob(entityUrn, (MiniJob)localObject, companyName, applicantCounts, hasEntityUrn, bool, hasCompanyName, hasApplicantCounts);
    label231:
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
      paramObject = (NextJob)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (miniJob != null)
      {
        if (miniJob.equals(miniJob)) {}
      }
      else {
        while (miniJob != null) {
          return false;
        }
      }
      if (companyName != null)
      {
        if (companyName.equals(companyName)) {}
      }
      else {
        while (companyName != null) {
          return false;
        }
      }
    } while (applicantCounts == applicantCounts);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasEntityUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasMiniJob)
    {
      i = j + 1;
      if (miniJob._cachedId == null) {
        break label137;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniJob._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasCompanyName) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(companyName);
      }
      j = i + 1;
      i = j;
      if (hasApplicantCounts) {
        i = j + 8;
      }
      __sizeOfObject = i;
      return i;
      label137:
      i += miniJob.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (miniJob == null) {
        break label104;
      }
    }
    label104:
    for (int j = miniJob.hashCode();; j = 0)
    {
      if (companyName != null) {
        k = companyName.hashCode();
      }
      i = ((j + (i + 527) * 31) * 31 + k) * 31 + (int)(applicantCounts ^ applicantCounts >>> 32);
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NextJob");
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
    label204:
    label230:
    label297:
    label322:
    label332:
    label342:
    label350:
    label352:
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
        localByteBuffer.putInt(-1906283893);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasMiniJob) {
            break label322;
          }
          localByteBuffer.put((byte)1);
          if (miniJob._cachedId == null) {
            break label297;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniJob._cachedId);
          miniJob.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCompanyName) {
            break label332;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, companyName);
          if (!hasApplicantCounts) {
            break label342;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(applicantCounts);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label350;
          }
          if (str != null) {
            break label352;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          miniJob.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label204;
          localByteBuffer.put((byte)0);
          break label204;
          localByteBuffer.put((byte)0);
          break label230;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.NextJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */