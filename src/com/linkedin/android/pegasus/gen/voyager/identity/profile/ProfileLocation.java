package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.NormBasicLocation;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ProfileLocation
  implements FissileDataModel<ProfileLocation>, RecordTemplate<ProfileLocation>
{
  public static final ProfileLocationBuilder BUILDER = ProfileLocationBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final NormBasicLocation basicLocation;
  public final boolean hasBasicLocation;
  public final boolean hasPreferredGeoPlace;
  public final Urn preferredGeoPlace;
  
  ProfileLocation(NormBasicLocation paramNormBasicLocation, Urn paramUrn, boolean paramBoolean1, boolean paramBoolean2)
  {
    basicLocation = paramNormBasicLocation;
    preferredGeoPlace = paramUrn;
    hasBasicLocation = paramBoolean1;
    hasPreferredGeoPlace = paramBoolean2;
    _cachedId = null;
  }
  
  public final ProfileLocation accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    NormBasicLocation localNormBasicLocation = null;
    boolean bool = false;
    if (hasBasicLocation)
    {
      paramDataProcessor.startRecordField$505cff1c("basicLocation");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label126;
      }
      localNormBasicLocation = basicLocation.accept(paramDataProcessor);
      if (localNormBasicLocation == null) {
        break label143;
      }
    }
    label126:
    label143:
    for (bool = true;; bool = false)
    {
      if (hasPreferredGeoPlace)
      {
        paramDataProcessor.startRecordField$505cff1c("preferredGeoPlace");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(preferredGeoPlace));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label166;
      }
      try
      {
        if (hasBasicLocation) {
          break label148;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileLocation", "basicLocation");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localNormBasicLocation = (NormBasicLocation)paramDataProcessor.processDataTemplate(basicLocation);
      break;
    }
    label148:
    return new ProfileLocation(localNormBasicLocation, preferredGeoPlace, bool, hasPreferredGeoPlace);
    label166:
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
      paramObject = (ProfileLocation)paramObject;
      if (basicLocation != null)
      {
        if (basicLocation.equals(basicLocation)) {}
      }
      else {
        while (basicLocation != null) {
          return false;
        }
      }
      if (preferredGeoPlace == null) {
        break;
      }
    } while (preferredGeoPlace.equals(preferredGeoPlace));
    for (;;)
    {
      return false;
      if (preferredGeoPlace == null) {
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
    if (hasBasicLocation) {
      if (basicLocation._cachedId == null) {
        break label90;
      }
    }
    label90:
    for (i = PegasusBinaryUtils.getEncodedLength(basicLocation._cachedId) + 9;; i = basicLocation.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasPreferredGeoPlace)
      {
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(preferredGeoPlace));
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (basicLocation != null) {}
    for (int i = basicLocation.hashCode();; i = 0)
    {
      if (preferredGeoPlace != null) {
        j = preferredGeoPlace.hashCode();
      }
      i = (i + 527) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ProfileLocation");
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
    label272:
    label280:
    label282:
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
        localByteBuffer.putInt(-1273377653);
        if (hasBasicLocation)
        {
          localByteBuffer.put((byte)1);
          if (basicLocation._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, basicLocation._cachedId);
            basicLocation.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPreferredGeoPlace) {
              break label272;
            }
            localByteBuffer.put((byte)1);
            UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(preferredGeoPlace));
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label280;
          }
          if (str != null) {
            break label282;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          basicLocation.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
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
    implements RecordTemplateBuilder<ProfileLocation>
  {
    private NormBasicLocation basicLocation = null;
    private boolean hasBasicLocation = false;
    private boolean hasPreferredGeoPlace = false;
    private Urn preferredGeoPlace = null;
    
    public Builder() {}
    
    public Builder(ProfileLocation paramProfileLocation)
    {
      basicLocation = basicLocation;
      preferredGeoPlace = preferredGeoPlace;
      hasBasicLocation = hasBasicLocation;
      hasPreferredGeoPlace = hasPreferredGeoPlace;
    }
    
    public final ProfileLocation build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ProfileLocation.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new ProfileLocation(basicLocation, preferredGeoPlace, hasBasicLocation, hasPreferredGeoPlace);
      } while (hasBasicLocation);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileLocation", "basicLocation");
    }
    
    public final Builder setBasicLocation(NormBasicLocation paramNormBasicLocation)
    {
      if (paramNormBasicLocation == null)
      {
        hasBasicLocation = false;
        basicLocation = null;
        return this;
      }
      hasBasicLocation = true;
      basicLocation = paramNormBasicLocation;
      return this;
    }
    
    public final Builder setPreferredGeoPlace(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasPreferredGeoPlace = false;
        preferredGeoPlace = null;
        return this;
      }
      hasPreferredGeoPlace = true;
      preferredGeoPlace = paramUrn;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileLocation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */