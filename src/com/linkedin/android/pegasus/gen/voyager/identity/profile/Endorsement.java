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

public final class Endorsement
  implements FissileDataModel<Endorsement>, RecordTemplate<Endorsement>
{
  public static final EndorsementBuilder BUILDER = EndorsementBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final EndorserMiniProfile endorser;
  public final Urn entityUrn;
  public final boolean hasEndorser;
  public final boolean hasEntityUrn;
  public final boolean hasStatus;
  public final EndorsementStatusType status;
  
  Endorsement(Urn paramUrn, EndorserMiniProfile paramEndorserMiniProfile, EndorsementStatusType paramEndorsementStatusType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    entityUrn = paramUrn;
    endorser = paramEndorserMiniProfile;
    status = paramEndorsementStatusType;
    hasEntityUrn = paramBoolean1;
    hasEndorser = paramBoolean2;
    hasStatus = paramBoolean3;
    paramEndorserMiniProfile = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  public final Endorsement accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    Object localObject = null;
    boolean bool = false;
    if (hasEndorser)
    {
      paramDataProcessor.startRecordField$505cff1c("endorser");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label150;
      }
      localObject = endorser.accept(paramDataProcessor);
      if (localObject == null) {
        break label167;
      }
    }
    label150:
    label167:
    for (bool = true;; bool = false)
    {
      if (hasStatus)
      {
        paramDataProcessor.startRecordField$505cff1c("status");
        paramDataProcessor.processEnum(status);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label217;
      }
      try
      {
        if (hasEndorser) {
          break label172;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement", "endorser");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (EndorserMiniProfile)paramDataProcessor.processDataTemplate(endorser);
      break;
    }
    label172:
    if (!hasStatus) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement", "status");
    }
    return new Endorsement(entityUrn, (EndorserMiniProfile)localObject, status, hasEntityUrn, bool, hasStatus);
    label217:
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
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (endorser != null)
      {
        if (endorser.equals(endorser)) {}
      }
      else {
        while (endorser != null) {
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
    if (hasEntityUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasEndorser)
    {
      i = j + 1;
      if (endorser._cachedId == null) {
        break label111;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(endorser._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasStatus) {
        i = j + 2;
      }
      __sizeOfObject = i;
      return i;
      label111:
      i += endorser.getSerializedSize();
    }
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
      if (endorser == null) {
        break label87;
      }
    }
    label87:
    for (int j = endorser.hashCode();; j = 0)
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
    label204:
    label276:
    label301:
    label311:
    label319:
    label321:
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
        localByteBuffer.putInt(-174325374);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasEndorser) {
            break label301;
          }
          localByteBuffer.put((byte)1);
          if (endorser._cachedId == null) {
            break label276;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, endorser._cachedId);
          endorser.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasStatus) {
            break label311;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, status.ordinal());
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label319;
          }
          if (str != null) {
            break label321;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          endorser.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label204;
          localByteBuffer.put((byte)0);
          break label204;
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
    implements RecordTemplateBuilder<Endorsement>
  {
    private EndorserMiniProfile endorser = null;
    private Urn entityUrn = null;
    private boolean hasEndorser = false;
    private boolean hasEntityUrn = false;
    private boolean hasStatus = false;
    private EndorsementStatusType status = null;
    
    public Builder() {}
    
    public Builder(Endorsement paramEndorsement)
    {
      entityUrn = entityUrn;
      endorser = endorser;
      status = status;
      hasEntityUrn = hasEntityUrn;
      hasEndorser = hasEndorser;
      hasStatus = hasStatus;
    }
    
    public final Endorsement build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (Endorsement.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new Endorsement(entityUrn, endorser, status, hasEntityUrn, hasEndorser, hasStatus);
        if (!hasEndorser) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement", "endorser");
        }
      } while (hasStatus);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement", "status");
    }
    
    public final Builder setEndorser(EndorserMiniProfile paramEndorserMiniProfile)
    {
      if (paramEndorserMiniProfile == null)
      {
        hasEndorser = false;
        endorser = null;
        return this;
      }
      hasEndorser = true;
      endorser = paramEndorserMiniProfile;
      return this;
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
    
    public final Builder setStatus(EndorsementStatusType paramEndorsementStatusType)
    {
      if (paramEndorsementStatusType == null)
      {
        hasStatus = false;
        status = null;
        return this;
      }
      hasStatus = true;
      status = paramEndorsementStatusType;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */