package com.linkedin.android.pegasus.gen.voyager.identity.profile;

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

public final class PendingEndorsedSkill
  implements FissileDataModel<PendingEndorsedSkill>, RecordTemplate<PendingEndorsedSkill>
{
  public static final PendingEndorsedSkillBuilder BUILDER = PendingEndorsedSkillBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final int endorsementCount;
  public final List<Endorsement> endorsements;
  public final boolean hasEndorsementCount;
  public final boolean hasEndorsements;
  public final boolean hasSkill;
  public final CoreSkill skill;
  
  PendingEndorsedSkill(CoreSkill paramCoreSkill, int paramInt, List<Endorsement> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    skill = paramCoreSkill;
    endorsementCount = paramInt;
    if (paramList == null) {}
    for (paramCoreSkill = null;; paramCoreSkill = Collections.unmodifiableList(paramList))
    {
      endorsements = paramCoreSkill;
      hasSkill = paramBoolean1;
      hasEndorsementCount = paramBoolean2;
      hasEndorsements = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  private PendingEndorsedSkill accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    int i;
    if (hasSkill)
    {
      paramDataProcessor.startRecordField$505cff1c("skill");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = skill.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label247;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasEndorsementCount)
      {
        paramDataProcessor.startRecordField$505cff1c("endorsementCount");
        paramDataProcessor.processInt(endorsementCount);
      }
      localObject1 = null;
      localEndorsement = null;
      bool2 = false;
      if (!hasEndorsements) {
        break label286;
      }
      paramDataProcessor.startRecordField$505cff1c("endorsements");
      endorsements.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localEndorsement;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = endorsements.iterator();
      label156:
      if (!localIterator.hasNext()) {
        break label272;
      }
      localEndorsement = (Endorsement)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label256;
      }
    }
    label247:
    label256:
    for (Endorsement localEndorsement = localEndorsement.accept(paramDataProcessor);; localEndorsement = (Endorsement)paramDataProcessor.processDataTemplate(localEndorsement))
    {
      if ((localObject1 != null) && (localEndorsement != null)) {
        ((List)localObject1).add(localEndorsement);
      }
      i += 1;
      break label156;
      localObject1 = (CoreSkill)paramDataProcessor.processDataTemplate(skill);
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
        if (hasSkill) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PendingEndorsedSkill", "skill");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasEndorsementCount) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PendingEndorsedSkill", "endorsementCount");
    }
    if (!hasEndorsements) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PendingEndorsedSkill", "endorsements");
    }
    if (endorsements != null)
    {
      paramDataProcessor = endorsements.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Endorsement)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PendingEndorsedSkill", "endorsements");
        }
      }
    }
    return new PendingEndorsedSkill((CoreSkill)localObject2, endorsementCount, (List)localObject1, bool1, hasEndorsementCount, bool2);
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
      paramObject = (PendingEndorsedSkill)paramObject;
      if (skill != null)
      {
        if (skill.equals(skill)) {}
      }
      else {
        while (skill != null) {
          return false;
        }
      }
      if (endorsementCount != endorsementCount) {
        return false;
      }
      if (endorsements == null) {
        break;
      }
    } while (endorsements.equals(endorsements));
    for (;;)
    {
      return false;
      if (endorsements == null) {
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
    if (hasSkill)
    {
      if (skill._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(skill._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasEndorsementCount) {
        i = j + 4;
      }
      i += 1;
      j = i;
      if (!hasEndorsements) {
        break label170;
      }
      i += 2;
      localIterator = endorsements.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label170;
      }
      Endorsement localEndorsement = (Endorsement)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = skill.getSerializedSize() + 7;
        break;
      }
      i += localEndorsement.getSerializedSize();
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
    if (skill != null) {}
    for (int i = skill.hashCode();; i = 0)
    {
      int k = endorsementCount;
      if (endorsements != null) {
        j = endorsements.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PendingEndorsedSkill");
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
        localByteBuffer.putInt(1962165191);
        Iterator localIterator;
        if (hasSkill)
        {
          localByteBuffer.put((byte)1);
          if (skill._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, skill._cachedId);
            skill.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasEndorsementCount) {
              break label336;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(endorsementCount);
            if (!hasEndorsements) {
              break label369;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, endorsements.size());
            localIterator = endorsements.iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label376;
          }
          Endorsement localEndorsement = (Endorsement)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localEndorsement.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            skill.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label194;
          }
          localByteBuffer.put((byte)1);
          localEndorsement.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.PendingEndorsedSkill
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */