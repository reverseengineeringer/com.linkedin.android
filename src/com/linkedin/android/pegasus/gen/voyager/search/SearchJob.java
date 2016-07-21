package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedConnectionsInfo;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public class SearchJob
  implements FissileDataModel<SearchJob>, RecordTemplate<SearchJob>
{
  public static final SearchJobBuilder BUILDER = SearchJobBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn backendUrn;
  public final String companyName;
  public final boolean hasBackendUrn;
  public final boolean hasCompanyName;
  public final boolean hasId;
  public final boolean hasJob;
  public final boolean hasSharedConnectionsInfo;
  public final String id;
  public final MiniJob job;
  public final SharedConnectionsInfo sharedConnectionsInfo;
  
  SearchJob(String paramString1, Urn paramUrn, MiniJob paramMiniJob, String paramString2, SharedConnectionsInfo paramSharedConnectionsInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    id = paramString1;
    backendUrn = paramUrn;
    job = paramMiniJob;
    companyName = paramString2;
    sharedConnectionsInfo = paramSharedConnectionsInfo;
    hasId = paramBoolean1;
    hasBackendUrn = paramBoolean2;
    hasJob = paramBoolean3;
    hasCompanyName = paramBoolean4;
    hasSharedConnectionsInfo = paramBoolean5;
    _cachedId = null;
  }
  
  public final SearchJob accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasId)
    {
      paramDataProcessor.startRecordField$505cff1c("id");
      paramDataProcessor.processString(id);
    }
    Object localObject1;
    if (hasBackendUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("backendUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(backendUrn));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    if (hasJob)
    {
      paramDataProcessor.startRecordField$505cff1c("job");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = job.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label247;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label114:
      if (hasCompanyName)
      {
        paramDataProcessor.startRecordField$505cff1c("companyName");
        paramDataProcessor.processString(companyName);
      }
      localObject1 = null;
      bool2 = false;
      if (hasSharedConnectionsInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("sharedConnectionsInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label256;
        }
        localObject1 = sharedConnectionsInfo.accept(paramDataProcessor);
        label178:
        if (localObject1 == null) {
          break label274;
        }
      }
    }
    label247:
    label256:
    label274:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label355;
      }
      try
      {
        if (hasId) {
          break label279;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchJob", "id");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniJob)paramDataProcessor.processDataTemplate(job);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label114;
      localObject1 = (SharedConnectionsInfo)paramDataProcessor.processDataTemplate(sharedConnectionsInfo);
      break label178;
    }
    label279:
    if (!hasBackendUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchJob", "backendUrn");
    }
    if (!hasJob) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchJob", "job");
    }
    return new SearchJob(id, backendUrn, (MiniJob)localObject2, companyName, (SharedConnectionsInfo)localObject1, hasId, hasBackendUrn, bool1, hasCompanyName, bool2);
    label355:
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (SearchJob)paramObject;
      if (id != null)
      {
        if (id.equals(id)) {}
      }
      else {
        while (id != null) {
          return false;
        }
      }
      if (backendUrn != null)
      {
        if (backendUrn.equals(backendUrn)) {}
      }
      else {
        while (backendUrn != null) {
          return false;
        }
      }
      if (job != null)
      {
        if (job.equals(job)) {}
      }
      else {
        while (job != null) {
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
      if (sharedConnectionsInfo == null) {
        break;
      }
    } while (sharedConnectionsInfo.equals(sharedConnectionsInfo));
    for (;;)
    {
      return false;
      if (sharedConnectionsInfo == null) {
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
    if (hasId) {
      i = PegasusBinaryUtils.getEncodedLength(id) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasBackendUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(backendUrn));
    }
    j = i + 1;
    i = j;
    if (hasJob)
    {
      i = j + 1;
      if (job._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(job._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasCompanyName) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(companyName);
      }
      j = i + 1;
      i = j;
      if (hasSharedConnectionsInfo)
      {
        i = j + 1;
        if (sharedConnectionsInfo._cachedId == null) {
          break label199;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(sharedConnectionsInfo._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += job.getSerializedSize();
      break;
      label199:
      i += sharedConnectionsInfo.getSerializedSize();
    }
  }
  
  public int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (id != null)
    {
      i = id.hashCode();
      if (backendUrn == null) {
        break label132;
      }
      j = backendUrn.hashCode();
      if (job == null) {
        break label137;
      }
      k = job.hashCode();
      label60:
      if (companyName == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = companyName.hashCode();; m = 0)
    {
      if (sharedConnectionsInfo != null) {
        n = sharedConnectionsInfo.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchJob");
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
    label170:
    label230:
    label256:
    label359:
    label369:
    label394:
    label404:
    label414:
    label439:
    label447:
    label449:
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
        localByteBuffer.putInt(-657004922);
        if (hasId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, id);
          if (!hasBackendUrn) {
            break label359;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(backendUrn));
          if (!hasJob) {
            break label394;
          }
          localByteBuffer.put((byte)1);
          if (job._cachedId == null) {
            break label369;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, job._cachedId);
          job.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCompanyName) {
            break label404;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, companyName);
          if (!hasSharedConnectionsInfo) {
            break label439;
          }
          localByteBuffer.put((byte)1);
          if (sharedConnectionsInfo._cachedId == null) {
            break label414;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, sharedConnectionsInfo._cachedId);
          sharedConnectionsInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label447;
          }
          if (str != null) {
            break label449;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)1);
          job.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)0);
          break label256;
          localByteBuffer.put((byte)1);
          sharedConnectionsInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */