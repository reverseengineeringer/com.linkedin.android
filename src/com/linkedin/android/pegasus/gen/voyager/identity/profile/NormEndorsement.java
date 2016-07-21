package com.linkedin.android.pegasus.gen.voyager.identity.profile;

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
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class NormEndorsement
  implements FissileDataModel<NormEndorsement>, RecordTemplate<NormEndorsement>
{
  public static final NormEndorsementBuilder BUILDER = NormEndorsementBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Urn endorseeUrn;
  public final Urn endorserUrn;
  public final boolean hasEndorseeUrn;
  public final boolean hasEndorserUrn;
  public final boolean hasSkill;
  public final boolean hasStatus;
  public final Skill skill;
  public final NormEndorsementStatusType status;
  
  NormEndorsement(Skill paramSkill, Urn paramUrn1, Urn paramUrn2, NormEndorsementStatusType paramNormEndorsementStatusType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    skill = paramSkill;
    endorserUrn = paramUrn1;
    endorseeUrn = paramUrn2;
    status = paramNormEndorsementStatusType;
    hasSkill = paramBoolean1;
    hasEndorserUrn = paramBoolean2;
    hasEndorseeUrn = paramBoolean3;
    hasStatus = paramBoolean4;
    _cachedId = null;
  }
  
  private NormEndorsement accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Skill localSkill = null;
    boolean bool = false;
    if (hasSkill)
    {
      paramDataProcessor.startRecordField$505cff1c("skill");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label184;
      }
      localSkill = skill.accept(paramDataProcessor);
      if (localSkill == null) {
        break label201;
      }
    }
    label184:
    label201:
    for (bool = true;; bool = false)
    {
      UrnCoercer localUrnCoercer;
      if (hasEndorserUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("endorserUrn");
        localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(endorserUrn));
      }
      if (hasEndorseeUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("endorseeUrn");
        localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(endorseeUrn));
      }
      if (hasStatus)
      {
        paramDataProcessor.startRecordField$505cff1c("status");
        paramDataProcessor.processEnum(status);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label240;
      }
      try
      {
        if (hasSkill) {
          break label206;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEndorsement", "skill");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localSkill = (Skill)paramDataProcessor.processDataTemplate(skill);
      break;
    }
    label206:
    return new NormEndorsement(localSkill, endorserUrn, endorseeUrn, status, bool, hasEndorserUrn, hasEndorseeUrn, hasStatus);
    label240:
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
      paramObject = (NormEndorsement)paramObject;
      if (skill != null)
      {
        if (skill.equals(skill)) {}
      }
      else {
        while (skill != null) {
          return false;
        }
      }
      if (endorserUrn != null)
      {
        if (endorserUrn.equals(endorserUrn)) {}
      }
      else {
        while (endorserUrn != null) {
          return false;
        }
      }
      if (endorseeUrn != null)
      {
        if (endorseeUrn.equals(endorseeUrn)) {}
      }
      else {
        while (endorseeUrn != null) {
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
    if (hasSkill) {
      if (skill._cachedId == null) {
        break label139;
      }
    }
    label139:
    for (i = PegasusBinaryUtils.getEncodedLength(skill._cachedId) + 9;; i = skill.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      UrnCoercer localUrnCoercer;
      if (hasEndorserUrn)
      {
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(endorserUrn));
      }
      j = i + 1;
      i = j;
      if (hasEndorseeUrn)
      {
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(endorseeUrn));
      }
      j = i + 1;
      i = j;
      if (hasStatus) {
        i = j + 2;
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (skill != null)
    {
      i = skill.hashCode();
      if (endorserUrn == null) {
        break label110;
      }
      j = endorserUrn.hashCode();
      label45:
      if (endorseeUrn == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = endorseeUrn.hashCode();; k = 0)
    {
      if (status != null) {
        m = status.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NormEndorsement");
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
    label238:
    label335:
    label345:
    label355:
    label363:
    label365:
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
        localByteBuffer.putInt(1896281347);
        if (hasSkill)
        {
          localByteBuffer.put((byte)1);
          if (skill._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, skill._cachedId);
            skill.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasEndorserUrn) {
              break label335;
            }
            localByteBuffer.put((byte)1);
            UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(endorserUrn));
            if (!hasEndorseeUrn) {
              break label345;
            }
            localByteBuffer.put((byte)1);
            localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(endorseeUrn));
            if (!hasStatus) {
              break label355;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, status.ordinal());
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label363;
          }
          if (str != null) {
            break label365;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          skill.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label204;
          localByteBuffer.put((byte)0);
          break label238;
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
    implements RecordTemplateBuilder<NormEndorsement>
  {
    private Urn endorseeUrn = null;
    private Urn endorserUrn = null;
    private boolean hasEndorseeUrn = false;
    private boolean hasEndorserUrn = false;
    private boolean hasSkill = false;
    private boolean hasStatus = false;
    private Skill skill = null;
    private NormEndorsementStatusType status = null;
    
    public final NormEndorsement build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (NormEndorsement.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new NormEndorsement(skill, endorserUrn, endorseeUrn, status, hasSkill, hasEndorserUrn, hasEndorseeUrn, hasStatus);
        if (!hasStatus) {
          status = NormEndorsementStatusType.ACCEPTED;
        }
      } while (hasSkill);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEndorsement", "skill");
    }
    
    public final Builder setEndorseeUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasEndorseeUrn = false;
        endorseeUrn = null;
        return this;
      }
      hasEndorseeUrn = true;
      endorseeUrn = paramUrn;
      return this;
    }
    
    public final Builder setEndorserUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasEndorserUrn = false;
        endorserUrn = null;
        return this;
      }
      hasEndorserUrn = true;
      endorserUrn = paramUrn;
      return this;
    }
    
    public final Builder setSkill(Skill paramSkill)
    {
      if (paramSkill == null)
      {
        hasSkill = false;
        skill = null;
        return this;
      }
      hasSkill = true;
      skill = paramSkill;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEndorsement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */