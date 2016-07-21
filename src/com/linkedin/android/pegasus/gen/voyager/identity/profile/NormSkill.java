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

public final class NormSkill
  implements FissileDataModel<NormSkill>, RecordTemplate<NormSkill>
{
  public static final NormSkillBuilder BUILDER = NormSkillBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasName;
  public final boolean hasStandardizedSkillUrn;
  public final String name;
  public final Urn standardizedSkillUrn;
  
  NormSkill(Urn paramUrn1, String paramString, Urn paramUrn2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    standardizedSkillUrn = paramUrn1;
    name = paramString;
    entityUrn = paramUrn2;
    hasStandardizedSkillUrn = paramBoolean1;
    hasName = paramBoolean2;
    hasEntityUrn = paramBoolean3;
    paramUrn1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn2);
  }
  
  private NormSkill accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    UrnCoercer localUrnCoercer;
    if (hasStandardizedSkillUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("standardizedSkillUrn");
      localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(standardizedSkillUrn));
    }
    if (hasName)
    {
      paramDataProcessor.startRecordField$505cff1c("name");
      paramDataProcessor.processString(name);
    }
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasName) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormSkill", "name");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new NormSkill(standardizedSkillUrn, name, entityUrn, hasStandardizedSkillUrn, hasName, hasEntityUrn);
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
      paramObject = (NormSkill)paramObject;
      if (standardizedSkillUrn != null)
      {
        if (standardizedSkillUrn.equals(standardizedSkillUrn)) {}
      }
      else {
        while (standardizedSkillUrn != null) {
          return false;
        }
      }
      if (name != null)
      {
        if (name.equals(name)) {}
      }
      else {
        while (name != null) {
          return false;
        }
      }
      if (entityUrn == null) {
        break;
      }
    } while (entityUrn.equals(entityUrn));
    for (;;)
    {
      return false;
      if (entityUrn == null) {
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
    UrnCoercer localUrnCoercer;
    if (hasStandardizedSkillUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(standardizedSkillUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(name);
    }
    j = i + 1;
    i = j;
    if (hasEntityUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn));
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
    if (standardizedSkillUrn != null)
    {
      i = standardizedSkillUrn.hashCode();
      if (name == null) {
        break label87;
      }
    }
    label87:
    for (int j = name.hashCode();; j = 0)
    {
      if (entityUrn != null) {
        k = entityUrn.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NormSkill");
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
    label247:
    label257:
    label265:
    label267:
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
        localByteBuffer.putInt(-1500608200);
        if (hasStandardizedSkillUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(standardizedSkillUrn));
          if (!hasName) {
            break label247;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, name);
          if (!hasEntityUrn) {
            break label257;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label265;
          }
          if (str != null) {
            break label267;
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
  
  public static final class Builder
    implements RecordTemplateBuilder<NormSkill>
  {
    private Urn entityUrn = null;
    private boolean hasEntityUrn = false;
    private boolean hasName = false;
    public boolean hasStandardizedSkillUrn = false;
    private String name = null;
    public Urn standardizedSkillUrn = null;
    
    public final NormSkill build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (NormSkill.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new NormSkill(standardizedSkillUrn, name, entityUrn, hasStandardizedSkillUrn, hasName, hasEntityUrn);
      } while (hasName);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormSkill", "name");
    }
    
    public final Builder setEntityUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasEntityUrn = false;
        entityUrn = null;
        return this;
      }
      hasEntityUrn = true;
      entityUrn = paramUrn;
      return this;
    }
    
    public final Builder setName(String paramString)
    {
      if (paramString == null)
      {
        hasName = false;
        name = null;
        return this;
      }
      hasName = true;
      name = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormSkill
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */