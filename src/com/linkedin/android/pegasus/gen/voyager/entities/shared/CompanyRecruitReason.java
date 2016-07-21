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

public final class CompanyRecruitReason
  implements FissileDataModel<CompanyRecruitReason>, RecordTemplate<CompanyRecruitReason>
{
  public static final CompanyRecruitReasonBuilder BUILDER = CompanyRecruitReasonBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<EntitiesMiniProfile> coworkers;
  public final MiniCompany currentCompany;
  public final boolean hasCoworkers;
  public final boolean hasCurrentCompany;
  public final boolean hasTotalNumberOfPastCoworkers;
  public final int totalNumberOfPastCoworkers;
  
  CompanyRecruitReason(MiniCompany paramMiniCompany, int paramInt, List<EntitiesMiniProfile> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    currentCompany = paramMiniCompany;
    totalNumberOfPastCoworkers = paramInt;
    if (paramList == null) {}
    for (paramMiniCompany = null;; paramMiniCompany = Collections.unmodifiableList(paramList))
    {
      coworkers = paramMiniCompany;
      hasCurrentCompany = paramBoolean1;
      hasTotalNumberOfPastCoworkers = paramBoolean2;
      hasCoworkers = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final CompanyRecruitReason accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    int i;
    if (hasCurrentCompany)
    {
      paramDataProcessor.startRecordField$505cff1c("currentCompany");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = currentCompany.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label247;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasTotalNumberOfPastCoworkers)
      {
        paramDataProcessor.startRecordField$505cff1c("totalNumberOfPastCoworkers");
        paramDataProcessor.processInt(totalNumberOfPastCoworkers);
      }
      localObject1 = null;
      localEntitiesMiniProfile = null;
      bool2 = false;
      if (!hasCoworkers) {
        break label286;
      }
      paramDataProcessor.startRecordField$505cff1c("coworkers");
      coworkers.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localEntitiesMiniProfile;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = coworkers.iterator();
      label156:
      if (!localIterator.hasNext()) {
        break label272;
      }
      localEntitiesMiniProfile = (EntitiesMiniProfile)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label256;
      }
    }
    label247:
    label256:
    for (EntitiesMiniProfile localEntitiesMiniProfile = localEntitiesMiniProfile.accept(paramDataProcessor);; localEntitiesMiniProfile = (EntitiesMiniProfile)paramDataProcessor.processDataTemplate(localEntitiesMiniProfile))
    {
      if ((localObject1 != null) && (localEntitiesMiniProfile != null)) {
        ((List)localObject1).add(localEntitiesMiniProfile);
      }
      i += 1;
      break label156;
      localObject1 = (MiniCompany)paramDataProcessor.processDataTemplate(currentCompany);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
    }
    label272:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label286:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label447;
      }
      try
      {
        if (hasCurrentCompany) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.CompanyRecruitReason", "currentCompany");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasTotalNumberOfPastCoworkers) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.CompanyRecruitReason", "totalNumberOfPastCoworkers");
    }
    if (!hasCoworkers) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.CompanyRecruitReason", "coworkers");
    }
    if (coworkers != null)
    {
      paramDataProcessor = coworkers.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((EntitiesMiniProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.shared.CompanyRecruitReason", "coworkers");
        }
      }
    }
    return new CompanyRecruitReason((MiniCompany)localObject2, totalNumberOfPastCoworkers, (List)localObject1, bool1, hasTotalNumberOfPastCoworkers, bool2);
    label447:
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
      paramObject = (CompanyRecruitReason)paramObject;
      if (currentCompany != null)
      {
        if (currentCompany.equals(currentCompany)) {}
      }
      else {
        while (currentCompany != null) {
          return false;
        }
      }
      if (totalNumberOfPastCoworkers != totalNumberOfPastCoworkers) {
        return false;
      }
      if (coworkers == null) {
        break;
      }
    } while (coworkers.equals(coworkers));
    for (;;)
    {
      return false;
      if (coworkers == null) {
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
    if (hasCurrentCompany)
    {
      if (currentCompany._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(currentCompany._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasTotalNumberOfPastCoworkers) {
        i = j + 4;
      }
      i += 1;
      j = i;
      if (!hasCoworkers) {
        break label170;
      }
      i += 2;
      localIterator = coworkers.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label170;
      }
      EntitiesMiniProfile localEntitiesMiniProfile = (EntitiesMiniProfile)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = currentCompany.getSerializedSize() + 7;
        break;
      }
      i += localEntitiesMiniProfile.getSerializedSize();
    }
    label170:
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (currentCompany != null) {}
    for (int i = currentCompany.hashCode();; i = 0)
    {
      int k = totalNumberOfPastCoworkers;
      if (coworkers != null) {
        j = coworkers.hashCode();
      }
      i = ((i + 527) * 31 + k) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CompanyRecruitReason");
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
    label194:
    label336:
    label369:
    label376:
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
        localByteBuffer.putInt(-1061943916);
        Iterator localIterator;
        if (hasCurrentCompany)
        {
          localByteBuffer.put((byte)1);
          if (currentCompany._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, currentCompany._cachedId);
            currentCompany.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasTotalNumberOfPastCoworkers) {
              break label336;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(totalNumberOfPastCoworkers);
            if (!hasCoworkers) {
              break label369;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, coworkers.size());
            localIterator = coworkers.iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label376;
          }
          EntitiesMiniProfile localEntitiesMiniProfile = (EntitiesMiniProfile)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localEntitiesMiniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            currentCompany.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label194;
          }
          localByteBuffer.put((byte)1);
          localEntitiesMiniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.CompanyRecruitReason
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */