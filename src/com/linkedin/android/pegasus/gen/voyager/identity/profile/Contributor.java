package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Contributor
  implements FissileDataModel<Contributor>, RecordTemplate<Contributor>
{
  public static final ContributorBuilder BUILDER = ContributorBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasMember;
  public final boolean hasName;
  public final boolean hasProfileUrn;
  public final MiniProfile member;
  public final String name;
  public final Urn profileUrn;
  
  Contributor(Urn paramUrn1, String paramString, Urn paramUrn2, MiniProfile paramMiniProfile, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    entityUrn = paramUrn1;
    name = paramString;
    profileUrn = paramUrn2;
    member = paramMiniProfile;
    hasEntityUrn = paramBoolean1;
    hasName = paramBoolean2;
    hasProfileUrn = paramBoolean3;
    hasMember = paramBoolean4;
    paramString = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
  }
  
  public final Contributor accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasName)
    {
      paramDataProcessor.startRecordField$505cff1c("name");
      paramDataProcessor.processString(name);
    }
    if (hasProfileUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("profileUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(profileUrn));
    }
    Object localObject = null;
    boolean bool = false;
    if (hasMember)
    {
      paramDataProcessor.startRecordField$505cff1c("member");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label187;
      }
      localObject = member.accept(paramDataProcessor);
      if (localObject == null) {
        break label204;
      }
    }
    label187:
    label204:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label209;
      }
      return new Contributor(entityUrn, name, profileUrn, (MiniProfile)localObject, hasEntityUrn, hasName, hasProfileUrn, bool);
      localObject = (MiniProfile)paramDataProcessor.processDataTemplate(member);
      break;
    }
    label209:
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
      paramObject = (Contributor)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
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
      if (profileUrn != null)
      {
        if (profileUrn.equals(profileUrn)) {}
      }
      else {
        while (profileUrn != null) {
          return false;
        }
      }
      if (member == null) {
        break;
      }
    } while (member.equals(member));
    for (;;)
    {
      return false;
      if (member == null) {
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
    if (hasEntityUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(name);
    }
    j = i + 1;
    i = j;
    if (hasProfileUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(profileUrn));
    }
    j = i + 1;
    i = j;
    if (hasMember)
    {
      i = j + 1;
      if (member._cachedId == null) {
        break label151;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(member._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label151:
      i += member.getSerializedSize();
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
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (name == null) {
        break label110;
      }
      j = name.hashCode();
      label45:
      if (profileUrn == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = profileUrn.hashCode();; k = 0)
    {
      if (member != null) {
        m = member.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Contributor");
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
        localByteBuffer.putInt(283709042);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasName) {
            break label307;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, name);
          if (!hasProfileUrn) {
            break label317;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(profileUrn));
          if (!hasMember) {
            break label352;
          }
          localByteBuffer.put((byte)1);
          if (member._cachedId == null) {
            break label327;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, member._cachedId);
          member.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          member.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
    implements RecordTemplateBuilder<Contributor>
  {
    private Urn entityUrn = null;
    private boolean hasEntityUrn = false;
    private boolean hasMember = false;
    private boolean hasName = false;
    private boolean hasProfileUrn = false;
    private MiniProfile member = null;
    private String name = null;
    private Urn profileUrn = null;
    
    public final Contributor build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      int[] arrayOfInt = Contributor.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
      paramFlavor.ordinal();
      return new Contributor(entityUrn, name, profileUrn, member, hasEntityUrn, hasName, hasProfileUrn, hasMember);
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
    
    public final Builder setMember(MiniProfile paramMiniProfile)
    {
      if (paramMiniProfile == null)
      {
        hasMember = false;
        member = null;
        return this;
      }
      hasMember = true;
      member = paramMiniProfile;
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
    
    public final Builder setProfileUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasProfileUrn = false;
        profileUrn = null;
        return this;
      }
      hasProfileUrn = true;
      profileUrn = paramUrn;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Contributor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */