package com.linkedin.android.pegasus.gen.voyager.search;

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
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchHistoryProfile
  implements FissileDataModel<SearchHistoryProfile>, RecordTemplate<SearchHistoryProfile>
{
  public static final SearchHistoryProfileBuilder BUILDER = SearchHistoryProfileBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn backendUrn;
  public final boolean hasBackendUrn;
  public final boolean hasProfile;
  public final MiniProfile profile;
  
  SearchHistoryProfile(MiniProfile paramMiniProfile, Urn paramUrn, boolean paramBoolean1, boolean paramBoolean2)
  {
    profile = paramMiniProfile;
    backendUrn = paramUrn;
    hasProfile = paramBoolean1;
    hasBackendUrn = paramBoolean2;
    _cachedId = null;
  }
  
  public final SearchHistoryProfile accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    MiniProfile localMiniProfile = null;
    boolean bool = false;
    if (hasProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("profile");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label126;
      }
      localMiniProfile = profile.accept(paramDataProcessor);
      if (localMiniProfile == null) {
        break label143;
      }
    }
    label126:
    label143:
    for (bool = true;; bool = false)
    {
      if (hasBackendUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("backendUrn");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(backendUrn));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label185;
      }
      try
      {
        if (hasProfile) {
          break label148;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryProfile", "profile");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localMiniProfile = (MiniProfile)paramDataProcessor.processDataTemplate(profile);
      break;
    }
    label148:
    if (!hasBackendUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryProfile", "backendUrn");
    }
    return new SearchHistoryProfile(localMiniProfile, backendUrn, bool, hasBackendUrn);
    label185:
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
      paramObject = (SearchHistoryProfile)paramObject;
      if (profile != null)
      {
        if (profile.equals(profile)) {}
      }
      else {
        while (profile != null) {
          return false;
        }
      }
      if (backendUrn == null) {
        break;
      }
    } while (backendUrn.equals(backendUrn));
    for (;;)
    {
      return false;
      if (backendUrn == null) {
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
    if (hasProfile) {
      if (profile._cachedId == null) {
        break label90;
      }
    }
    label90:
    for (i = PegasusBinaryUtils.getEncodedLength(profile._cachedId) + 9;; i = profile.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasBackendUrn)
      {
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(backendUrn));
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
    if (profile != null) {}
    for (int i = profile.hashCode();; i = 0)
    {
      if (backendUrn != null) {
        j = backendUrn.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchHistoryProfile");
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
        localByteBuffer.putInt(-1264369451);
        if (hasProfile)
        {
          localByteBuffer.put((byte)1);
          if (profile._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, profile._cachedId);
            profile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasBackendUrn) {
              break label272;
            }
            localByteBuffer.put((byte)1);
            UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(backendUrn));
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
          profile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
    implements RecordTemplateBuilder<SearchHistoryProfile>
  {
    private Urn backendUrn = null;
    private boolean hasBackendUrn = false;
    private boolean hasProfile = false;
    private MiniProfile profile = null;
    
    public final SearchHistoryProfile build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (SearchHistoryProfile.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new SearchHistoryProfile(profile, backendUrn, hasProfile, hasBackendUrn);
        if (!hasProfile) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryProfile", "profile");
        }
      } while (hasBackendUrn);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryProfile", "backendUrn");
    }
    
    public final Builder setBackendUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasBackendUrn = false;
        backendUrn = null;
        return this;
      }
      hasBackendUrn = true;
      backendUrn = paramUrn;
      return this;
    }
    
    public final Builder setProfile(MiniProfile paramMiniProfile)
    {
      if (paramMiniProfile == null)
      {
        hasProfile = false;
        profile = null;
        return this;
      }
      hasProfile = true;
      profile = paramMiniProfile;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryProfile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */