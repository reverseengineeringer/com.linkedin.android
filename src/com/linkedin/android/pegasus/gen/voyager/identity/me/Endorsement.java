package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Endorsement
  implements FissileDataModel<Endorsement>, RecordTemplate<Endorsement>
{
  public static final EndorsementBuilder BUILDER = EndorsementBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn endorsementUrn;
  public final boolean hasEndorsementUrn;
  public final boolean hasSkill;
  public final boolean hasStatus;
  public final String skill;
  public final EndorsementStatus status;
  
  Endorsement(Urn paramUrn, String paramString, EndorsementStatus paramEndorsementStatus, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    endorsementUrn = paramUrn;
    skill = paramString;
    status = paramEndorsementStatus;
    hasEndorsementUrn = paramBoolean1;
    hasSkill = paramBoolean2;
    hasStatus = paramBoolean3;
    _cachedId = null;
  }
  
  public final Endorsement accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEndorsementUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("endorsementUrn");
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(endorsementUrn));
    }
    if (hasSkill)
    {
      paramDataProcessor.startRecordField$505cff1c("skill");
      paramDataProcessor.processString(skill);
    }
    if (hasStatus)
    {
      paramDataProcessor.startRecordField$505cff1c("status");
      paramDataProcessor.processEnum(status);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasEndorsementUrn) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.Endorsement", "endorsementUrn");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasSkill) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.Endorsement", "skill");
      }
      if (!hasStatus) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.Endorsement", "status");
      }
      return new Endorsement(endorsementUrn, skill, status, hasEndorsementUrn, hasSkill, hasStatus);
    }
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
      paramObject = (Endorsement)paramObject;
      if (endorsementUrn != null)
      {
        if (endorsementUrn.equals(endorsementUrn)) {}
      }
      else {
        while (endorsementUrn != null) {
          return false;
        }
      }
      if (skill != null)
      {
        if (skill.equals(skill)) {}
      }
      else {
        while (skill != null) {
          return false;
        }
      }
      if (status == null) {
        break;
      }
    } while (status.equals(status));
    for (;;)
    {
      return false;
      if (status == null) {
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
    if (hasEndorsementUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(endorsementUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasSkill) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(skill);
    }
    j = i + 1;
    i = j;
    if (hasStatus) {
      i = j + 2;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (endorsementUrn != null)
    {
      i = endorsementUrn.hashCode();
      if (skill == null) {
        break label87;
      }
    }
    label87:
    for (int j = skill.hashCode();; j = 0)
    {
      if (status != null) {
        k = status.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Endorsement");
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
    label242:
    label252:
    label260:
    label262:
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
        localByteBuffer.putInt(-1981289077);
        if (hasEndorsementUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(endorsementUrn));
          if (!hasSkill) {
            break label242;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, skill);
          if (!hasStatus) {
            break label252;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, status.ordinal());
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label260;
          }
          if (str != null) {
            break label262;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.Endorsement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */