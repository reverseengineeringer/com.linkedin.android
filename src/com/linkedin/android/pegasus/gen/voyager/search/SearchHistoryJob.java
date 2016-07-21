package com.linkedin.android.pegasus.gen.voyager.search;

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
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchHistoryJob
  implements FissileDataModel<SearchHistoryJob>, RecordTemplate<SearchHistoryJob>
{
  public static final SearchHistoryJobBuilder BUILDER = SearchHistoryJobBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn backendUrn;
  public final boolean hasBackendUrn;
  public final boolean hasJob;
  public final MiniJob job;
  
  SearchHistoryJob(MiniJob paramMiniJob, Urn paramUrn, boolean paramBoolean1, boolean paramBoolean2)
  {
    job = paramMiniJob;
    backendUrn = paramUrn;
    hasJob = paramBoolean1;
    hasBackendUrn = paramBoolean2;
    _cachedId = null;
  }
  
  public final SearchHistoryJob accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    MiniJob localMiniJob = null;
    boolean bool = false;
    if (hasJob)
    {
      paramDataProcessor.startRecordField$505cff1c("job");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label126;
      }
      localMiniJob = job.accept(paramDataProcessor);
      if (localMiniJob == null) {
        break label143;
      }
    }
    label126:
    label143:
    for (bool = true;; bool = false)
    {
      if (hasBackendUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("backendUrn");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(backendUrn));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label185;
      }
      try
      {
        if (hasJob) {
          break label148;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryJob", "job");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localMiniJob = (MiniJob)paramDataProcessor.processDataTemplate(job);
      break;
    }
    label148:
    if (!hasBackendUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryJob", "backendUrn");
    }
    return new SearchHistoryJob(localMiniJob, backendUrn, bool, hasBackendUrn);
    label185:
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
      paramObject = (SearchHistoryJob)paramObject;
      if (job != null)
      {
        if (job.equals(job)) {}
      }
      else {
        while (job != null) {
          return false;
        }
      }
      if (backendUrn == null) {
        break;
      }
    } while (backendUrn.equals(backendUrn));
    for (;;)
    {
      return false;
      if (backendUrn == null) {
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
    if (hasJob) {
      if (job._cachedId == null) {
        break label90;
      }
    }
    label90:
    for (i = PegasusBinaryUtils.getEncodedLength(job._cachedId) + 9;; i = job.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasBackendUrn)
      {
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(backendUrn));
      }
      __sizeOfObject = i;
      return i;
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
      if (backendUrn != null) {
        j = backendUrn.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchHistoryJob");
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
    label272:
    label280:
    label282:
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
        localByteBuffer.putInt(-580568140);
        if (hasJob)
        {
          localByteBuffer.put((byte)1);
          if (job._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, job._cachedId);
            job.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasBackendUrn) {
              break label272;
            }
            localByteBuffer.put((byte)1);
            UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(backendUrn));
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label280;
          }
          if (str != null) {
            break label282;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          job.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
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
  
  public static final class Builder
    implements RecordTemplateBuilder<SearchHistoryJob>
  {
    public Urn backendUrn = null;
    public boolean hasBackendUrn = false;
    public boolean hasJob = false;
    public MiniJob job = null;
    
    public final SearchHistoryJob build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (SearchHistoryJob.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new SearchHistoryJob(job, backendUrn, hasJob, hasBackendUrn);
        if (!hasJob) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryJob", "job");
        }
      } while (hasBackendUrn);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryJob", "backendUrn");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */