package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSkill;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Skill
  implements FissileDataModel<Skill>, RecordTemplate<Skill>
{
  public static final SkillBuilder BUILDER = SkillBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasName;
  public final boolean hasStandardizedSkill;
  public final boolean hasStandardizedSkillUrn;
  public final String name;
  public final MiniSkill standardizedSkill;
  public final Urn standardizedSkillUrn;
  
  Skill(Urn paramUrn1, String paramString, Urn paramUrn2, MiniSkill paramMiniSkill, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    standardizedSkillUrn = paramUrn1;
    name = paramString;
    entityUrn = paramUrn2;
    standardizedSkill = paramMiniSkill;
    hasStandardizedSkillUrn = paramBoolean1;
    hasName = paramBoolean2;
    hasEntityUrn = paramBoolean3;
    hasStandardizedSkill = paramBoolean4;
    paramUrn1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn2);
  }
  
  public final Skill accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasStandardizedSkillUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("standardizedSkillUrn");
      localObject = UrnCoercer.INSTANCE;
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
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    Object localObject = null;
    boolean bool = false;
    if (hasStandardizedSkill)
    {
      paramDataProcessor.startRecordField$505cff1c("standardizedSkill");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label182;
      }
      localObject = standardizedSkill.accept(paramDataProcessor);
      if (localObject == null) {
        break label199;
      }
    }
    label182:
    label199:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label238;
      }
      try
      {
        if (hasName) {
          break label204;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Skill", "name");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (MiniSkill)paramDataProcessor.processDataTemplate(standardizedSkill);
      break;
    }
    label204:
    return new Skill(standardizedSkillUrn, name, entityUrn, (MiniSkill)localObject, hasStandardizedSkillUrn, hasName, hasEntityUrn, bool);
    label238:
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
      paramObject = (Skill)paramObject;
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
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (standardizedSkill == null) {
        break;
      }
    } while (standardizedSkill.equals(standardizedSkill));
    for (;;)
    {
      return false;
      if (standardizedSkill == null) {
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
    j = i + 1;
    i = j;
    if (hasStandardizedSkill)
    {
      i = j + 1;
      if (standardizedSkill._cachedId == null) {
        break label151;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(standardizedSkill._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label151:
      i += standardizedSkill.getSerializedSize();
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
    if (standardizedSkillUrn != null)
    {
      i = standardizedSkillUrn.hashCode();
      if (name == null) {
        break label110;
      }
      j = name.hashCode();
      label45:
      if (entityUrn == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = entityUrn.hashCode();; k = 0)
    {
      if (standardizedSkill != null) {
        m = standardizedSkill.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Skill");
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
    label204:
    label307:
    label317:
    label327:
    label352:
    label360:
    label362:
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
        localByteBuffer.putInt(-1336031963);
        if (hasStandardizedSkillUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(standardizedSkillUrn));
          if (!hasName) {
            break label307;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, name);
          if (!hasEntityUrn) {
            break label317;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasStandardizedSkill) {
            break label352;
          }
          localByteBuffer.put((byte)1);
          if (standardizedSkill._cachedId == null) {
            break label327;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, standardizedSkill._cachedId);
          standardizedSkill.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label360;
          }
          if (str != null) {
            break label362;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)0);
          break label204;
          localByteBuffer.put((byte)1);
          standardizedSkill.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Builder
    implements RecordTemplateBuilder<Skill>
  {
    private Urn entityUrn = null;
    private boolean hasEntityUrn = false;
    private boolean hasName = false;
    private boolean hasStandardizedSkill = false;
    private boolean hasStandardizedSkillUrn = false;
    private String name = null;
    private MiniSkill standardizedSkill = null;
    private Urn standardizedSkillUrn = null;
    
    public final Skill build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (Skill.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new Skill(standardizedSkillUrn, name, entityUrn, standardizedSkill, hasStandardizedSkillUrn, hasName, hasEntityUrn, hasStandardizedSkill);
      } while (hasName);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Skill", "name");
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
    
    public final Builder setStandardizedSkillUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasStandardizedSkillUrn = false;
        standardizedSkillUrn = null;
        return this;
      }
      hasStandardizedSkillUrn = true;
      standardizedSkillUrn = paramUrn;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Skill
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */