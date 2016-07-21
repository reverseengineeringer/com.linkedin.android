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

public final class PrivacySettings
  implements FissileDataModel<PrivacySettings>, RecordTemplate<PrivacySettings>
{
  public static final PrivacySettingsBuilder BUILDER = PrivacySettingsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean allowOpenProfile;
  public final boolean allowProfileEditBroadcasts;
  public final Urn entityUrn;
  public final boolean hasAllowOpenProfile;
  public final boolean hasAllowProfileEditBroadcasts;
  public final boolean hasEntityUrn;
  public final boolean hasProfilePictureVisibilitySetting;
  public final boolean hasShowPremiumSubscriberBadge;
  public final NetworkVisibilitySetting profilePictureVisibilitySetting;
  public final boolean showPremiumSubscriberBadge;
  
  PrivacySettings(Urn paramUrn, boolean paramBoolean1, boolean paramBoolean2, NetworkVisibilitySetting paramNetworkVisibilitySetting, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    entityUrn = paramUrn;
    showPremiumSubscriberBadge = paramBoolean1;
    allowOpenProfile = paramBoolean2;
    profilePictureVisibilitySetting = paramNetworkVisibilitySetting;
    allowProfileEditBroadcasts = paramBoolean3;
    hasEntityUrn = paramBoolean4;
    hasShowPremiumSubscriberBadge = paramBoolean5;
    hasAllowOpenProfile = paramBoolean6;
    hasProfilePictureVisibilitySetting = paramBoolean7;
    hasAllowProfileEditBroadcasts = paramBoolean8;
    paramNetworkVisibilitySetting = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  private PrivacySettings accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasShowPremiumSubscriberBadge)
    {
      paramDataProcessor.startRecordField$505cff1c("showPremiumSubscriberBadge");
      paramDataProcessor.processBoolean(showPremiumSubscriberBadge);
    }
    if (hasAllowOpenProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("allowOpenProfile");
      paramDataProcessor.processBoolean(allowOpenProfile);
    }
    if (hasProfilePictureVisibilitySetting)
    {
      paramDataProcessor.startRecordField$505cff1c("profilePictureVisibilitySetting");
      paramDataProcessor.processEnum(profilePictureVisibilitySetting);
    }
    if (hasAllowProfileEditBroadcasts)
    {
      paramDataProcessor.startRecordField$505cff1c("allowProfileEditBroadcasts");
      paramDataProcessor.processBoolean(allowProfileEditBroadcasts);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasEntityUrn) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettings", "entityUrn");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasShowPremiumSubscriberBadge) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettings", "showPremiumSubscriberBadge");
      }
      if (!hasAllowOpenProfile) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettings", "allowOpenProfile");
      }
      if (!hasProfilePictureVisibilitySetting) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettings", "profilePictureVisibilitySetting");
      }
      if (!hasAllowProfileEditBroadcasts) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettings", "allowProfileEditBroadcasts");
      }
      return new PrivacySettings(entityUrn, showPremiumSubscriberBadge, allowOpenProfile, profilePictureVisibilitySetting, allowProfileEditBroadcasts, hasEntityUrn, hasShowPremiumSubscriberBadge, hasAllowOpenProfile, hasProfilePictureVisibilitySetting, hasAllowProfileEditBroadcasts);
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
      paramObject = (PrivacySettings)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (showPremiumSubscriberBadge != showPremiumSubscriberBadge) {
        return false;
      }
      if (allowOpenProfile != allowOpenProfile) {
        return false;
      }
      if (profilePictureVisibilitySetting != null)
      {
        if (profilePictureVisibilitySetting.equals(profilePictureVisibilitySetting)) {}
      }
      else {
        while (profilePictureVisibilitySetting != null) {
          return false;
        }
      }
    } while (allowProfileEditBroadcasts == allowProfileEditBroadcasts);
    return false;
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
    if (hasShowPremiumSubscriberBadge) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasAllowOpenProfile) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasProfilePictureVisibilitySetting) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasAllowProfileEditBroadcasts) {
      i = j + 1;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int n = 1;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label39:
    int k;
    label48:
    int m;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (!showPremiumSubscriberBadge) {
        break label111;
      }
      j = 1;
      if (!allowOpenProfile) {
        break label116;
      }
      k = 1;
      if (profilePictureVisibilitySetting == null) {
        break label121;
      }
      m = profilePictureVisibilitySetting.hashCode();
      label64:
      if (!allowProfileEditBroadcasts) {
        break label127;
      }
    }
    for (;;)
    {
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      label111:
      j = 0;
      break label39;
      label116:
      k = 0;
      break label48;
      label121:
      m = 0;
      break label64;
      label127:
      n = 0;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    int j = 1;
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PrivacySettings");
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
    label171:
    label180:
    label204:
    label213:
    label242:
    label267:
    label319:
    label325:
    label335:
    label341:
    label351:
    label361:
    label367:
    label375:
    label377:
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
        localByteBuffer.putInt(68001919);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasShowPremiumSubscriberBadge) {
            break label325;
          }
          localByteBuffer.put((byte)1);
          if (!showPremiumSubscriberBadge) {
            break label319;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasAllowOpenProfile) {
            break label341;
          }
          localByteBuffer.put((byte)1);
          if (!allowOpenProfile) {
            break label335;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasProfilePictureVisibilitySetting) {
            break label351;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, profilePictureVisibilitySetting.ordinal());
          if (!hasAllowProfileEditBroadcasts) {
            break label367;
          }
          localByteBuffer.put((byte)1);
          if (!allowProfileEditBroadcasts) {
            break label361;
          }
          i = j;
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label375;
          }
          if (str != null) {
            break label377;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          i = 0;
          break label171;
          localByteBuffer.put((byte)0);
          break label180;
          i = 0;
          break label204;
          localByteBuffer.put((byte)0);
          break label213;
          localByteBuffer.put((byte)0);
          break label242;
          i = 0;
          break label267;
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
    implements RecordTemplateBuilder<PrivacySettings>
  {
    public boolean allowOpenProfile = false;
    private boolean allowProfileEditBroadcasts = false;
    private Urn entityUrn = null;
    public boolean hasAllowOpenProfile = false;
    private boolean hasAllowProfileEditBroadcasts = false;
    private boolean hasEntityUrn = false;
    public boolean hasProfilePictureVisibilitySetting = false;
    public boolean hasShowPremiumSubscriberBadge = false;
    public NetworkVisibilitySetting profilePictureVisibilitySetting = null;
    public boolean showPremiumSubscriberBadge = false;
    
    public Builder() {}
    
    public Builder(PrivacySettings paramPrivacySettings)
    {
      entityUrn = entityUrn;
      showPremiumSubscriberBadge = showPremiumSubscriberBadge;
      allowOpenProfile = allowOpenProfile;
      profilePictureVisibilitySetting = profilePictureVisibilitySetting;
      allowProfileEditBroadcasts = allowProfileEditBroadcasts;
      hasEntityUrn = hasEntityUrn;
      hasShowPremiumSubscriberBadge = hasShowPremiumSubscriberBadge;
      hasAllowOpenProfile = hasAllowOpenProfile;
      hasProfilePictureVisibilitySetting = hasProfilePictureVisibilitySetting;
      hasAllowProfileEditBroadcasts = hasAllowProfileEditBroadcasts;
    }
    
    public final PrivacySettings build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PrivacySettings.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new PrivacySettings(entityUrn, showPremiumSubscriberBadge, allowOpenProfile, profilePictureVisibilitySetting, allowProfileEditBroadcasts, hasEntityUrn, hasShowPremiumSubscriberBadge, hasAllowOpenProfile, hasProfilePictureVisibilitySetting, hasAllowProfileEditBroadcasts);
        if (!hasEntityUrn) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettings", "entityUrn");
        }
        if (!hasShowPremiumSubscriberBadge) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettings", "showPremiumSubscriberBadge");
        }
        if (!hasAllowOpenProfile) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettings", "allowOpenProfile");
        }
        if (!hasProfilePictureVisibilitySetting) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettings", "profilePictureVisibilitySetting");
        }
      } while (hasAllowProfileEditBroadcasts);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettings", "allowProfileEditBroadcasts");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */