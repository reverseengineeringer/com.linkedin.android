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
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class NormContributor
  implements FissileDataModel<NormContributor>, RecordTemplate<NormContributor>
{
  public static final NormContributorBuilder BUILDER = NormContributorBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn entityUrn;
  public final boolean hasEntityUrn;
  public final boolean hasName;
  public final boolean hasProfileUrn;
  public final String name;
  public final Urn profileUrn;
  
  NormContributor(Urn paramUrn1, String paramString, Urn paramUrn2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    entityUrn = paramUrn1;
    name = paramString;
    profileUrn = paramUrn2;
    hasEntityUrn = paramBoolean1;
    hasName = paramBoolean2;
    hasProfileUrn = paramBoolean3;
    paramString = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
  }
  
  public final NormContributor accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    UrnCoercer localUrnCoercer;
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localUrnCoercer = UrnCoercer.INSTANCE;
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
      localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(profileUrn));
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new NormContributor(entityUrn, name, profileUrn, hasEntityUrn, hasName, hasProfileUrn);
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
      paramObject = (NormContributor)paramObject;
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
      if (profileUrn == null) {
        break;
      }
    } while (profileUrn.equals(profileUrn));
    for (;;)
    {
      return false;
      if (profileUrn == null) {
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
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (name == null) {
        break label87;
      }
    }
    label87:
    for (int j = name.hashCode();; j = 0)
    {
      if (profileUrn != null) {
        k = profileUrn.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building NormContributor");
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
        localByteBuffer.putInt(-498467720);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasName) {
            break label247;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, name);
          if (!hasProfileUrn) {
            break label257;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(profileUrn));
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
    implements RecordTemplateBuilder<NormContributor>
  {
    private Urn entityUrn = null;
    private boolean hasEntityUrn = false;
    private boolean hasName = false;
    private boolean hasProfileUrn = false;
    private String name = null;
    private Urn profileUrn = null;
    
    public final NormContributor build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      int[] arrayOfInt = NormContributor.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
      paramFlavor.ordinal();
      return new NormContributor(entityUrn, name, profileUrn, hasEntityUrn, hasName, hasProfileUrn);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormContributor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */