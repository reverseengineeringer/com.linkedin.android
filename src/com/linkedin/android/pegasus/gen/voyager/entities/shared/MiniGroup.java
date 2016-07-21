package com.linkedin.android.pegasus.gen.voyager.entities.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MiniGroup
  implements FissileDataModel<MiniGroup>, RecordTemplate<MiniGroup>
{
  public static final MiniGroupBuilder BUILDER = MiniGroupBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Urn entityUrn;
  public final String groupDescription;
  public final String groupName;
  public final boolean hasEntityUrn;
  public final boolean hasGroupDescription;
  public final boolean hasGroupName;
  public final boolean hasLogo;
  public final boolean hasObjectUrn;
  public final boolean hasRecentActivityCount;
  public final boolean hasTrackingId;
  public final Image logo;
  public final Urn objectUrn;
  public final int recentActivityCount;
  public final String trackingId;
  
  MiniGroup(String paramString1, Urn paramUrn1, Urn paramUrn2, String paramString2, String paramString3, Image paramImage, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    trackingId = paramString1;
    objectUrn = paramUrn1;
    entityUrn = paramUrn2;
    groupName = paramString2;
    groupDescription = paramString3;
    logo = paramImage;
    recentActivityCount = paramInt;
    hasTrackingId = paramBoolean1;
    hasObjectUrn = paramBoolean2;
    hasEntityUrn = paramBoolean3;
    hasGroupName = paramBoolean4;
    hasGroupDescription = paramBoolean5;
    hasLogo = paramBoolean6;
    hasRecentActivityCount = paramBoolean7;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn2);
  }
  
  public final MiniGroup accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingId");
      paramDataProcessor.processString(trackingId);
    }
    if (hasObjectUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("objectUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(objectUrn));
    }
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasGroupName)
    {
      paramDataProcessor.startRecordField$505cff1c("groupName");
      paramDataProcessor.processString(groupName);
    }
    if (hasGroupDescription)
    {
      paramDataProcessor.startRecordField$505cff1c("groupDescription");
      paramDataProcessor.processString(groupDescription);
    }
    Object localObject = null;
    boolean bool = false;
    if (hasLogo)
    {
      paramDataProcessor.startRecordField$505cff1c("logo");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label257;
      }
      localObject = logo.accept(paramDataProcessor);
      if (localObject == null) {
        break label274;
      }
    }
    label257:
    label274:
    for (bool = true;; bool = false)
    {
      if (hasRecentActivityCount)
      {
        paramDataProcessor.startRecordField$505cff1c("recentActivityCount");
        paramDataProcessor.processInt(recentActivityCount);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label356;
      }
      try
      {
        if (hasEntityUrn) {
          break label279;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (Image)paramDataProcessor.processDataTemplate(logo);
      break;
    }
    label279:
    if (!hasGroupName) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup", "groupName");
    }
    return new MiniGroup(trackingId, objectUrn, entityUrn, groupName, groupDescription, (Image)localObject, recentActivityCount, hasTrackingId, hasObjectUrn, hasEntityUrn, hasGroupName, hasGroupDescription, bool, hasRecentActivityCount);
    label356:
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
      paramObject = (MiniGroup)paramObject;
      if (objectUrn != null)
      {
        if (objectUrn.equals(objectUrn)) {}
      }
      else {
        while (objectUrn != null) {
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
      if (groupName != null)
      {
        if (groupName.equals(groupName)) {}
      }
      else {
        while (groupName != null) {
          return false;
        }
      }
      if (groupDescription != null)
      {
        if (groupDescription.equals(groupDescription)) {}
      }
      else {
        while (groupDescription != null) {
          return false;
        }
      }
      if (logo != null)
      {
        if (logo.equals(logo)) {}
      }
      else {
        while (logo != null) {
          return false;
        }
      }
    } while (recentActivityCount == recentActivityCount);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasTrackingId) {
      i = PegasusBinaryUtils.getEncodedLength(trackingId) + 8;
    }
    int j = i + 1;
    i = j;
    UrnCoercer localUrnCoercer;
    if (hasObjectUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(objectUrn));
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
    if (hasGroupName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(groupName);
    }
    j = i + 1;
    i = j;
    if (hasGroupDescription) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(groupDescription);
    }
    j = i + 1;
    i = j;
    if (hasLogo)
    {
      i = j + 1;
      if (logo._cachedId == null) {
        break label218;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(logo._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasRecentActivityCount) {
        i = j + 4;
      }
      __sizeOfObject = i;
      return i;
      label218:
      i += logo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (objectUrn != null)
    {
      i = objectUrn.hashCode();
      if (entityUrn == null) {
        break label140;
      }
      j = entityUrn.hashCode();
      if (groupName == null) {
        break label145;
      }
      k = groupName.hashCode();
      label60:
      if (groupDescription == null) {
        break label150;
      }
    }
    label140:
    label145:
    label150:
    for (int m = groupDescription.hashCode();; m = 0)
    {
      if (logo != null) {
        n = logo.hashCode();
      }
      i = ((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n) * 31 + recentActivityCount;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MiniGroup");
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
    label230:
    label256:
    label316:
    label383:
    label393:
    label403:
    label413:
    label423:
    label448:
    label458:
    label466:
    label468:
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
        localByteBuffer.putInt(-1426750681);
        if (hasTrackingId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
          if (!hasObjectUrn) {
            break label383;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(objectUrn));
          if (!hasEntityUrn) {
            break label393;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasGroupName) {
            break label403;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, groupName);
          if (!hasGroupDescription) {
            break label413;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, groupDescription);
          if (!hasLogo) {
            break label448;
          }
          localByteBuffer.put((byte)1);
          if (logo._cachedId == null) {
            break label423;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, logo._cachedId);
          logo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasRecentActivityCount) {
            break label458;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(recentActivityCount);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label466;
          }
          if (str != null) {
            break label468;
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
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)0);
          break label256;
          localByteBuffer.put((byte)1);
          logo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label316;
          localByteBuffer.put((byte)0);
          break label316;
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
    implements RecordTemplateBuilder<MiniGroup>
  {
    private Urn entityUrn = null;
    private String groupDescription = null;
    public String groupName = null;
    private boolean hasEntityUrn = false;
    private boolean hasGroupDescription = false;
    public boolean hasGroupName = false;
    private boolean hasLogo = false;
    private boolean hasObjectUrn = false;
    private boolean hasRecentActivityCount = false;
    private boolean hasTrackingId = false;
    private Image logo = null;
    private Urn objectUrn = null;
    private int recentActivityCount = 0;
    private String trackingId = null;
    
    public final MiniGroup build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (MiniGroup.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new MiniGroup(trackingId, objectUrn, entityUrn, groupName, groupDescription, logo, recentActivityCount, hasTrackingId, hasObjectUrn, hasEntityUrn, hasGroupName, hasGroupDescription, hasLogo, hasRecentActivityCount);
        if (!hasEntityUrn) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup", "entityUrn");
        }
      } while (hasGroupName);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup", "groupName");
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
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */