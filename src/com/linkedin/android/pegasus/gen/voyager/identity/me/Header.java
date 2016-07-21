package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.BackgroundImage;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Header
  implements FissileDataModel<Header>, RecordTemplate<Header>
{
  public static final HeaderBuilder BUILDER = HeaderBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final BackgroundImage backgroundImage;
  public final Urn entityUrn;
  public final boolean hasBackgroundImage;
  public final boolean hasEntityUrn;
  public final boolean hasLastUpdateType;
  public final boolean hasMiniProfile;
  public final boolean hasNumActivities;
  public final boolean hasNumFollowers;
  public final boolean hasNumLastUpdateViews;
  public final boolean hasNumProfileViews;
  public final SocialUpdateType lastUpdateType;
  public final MiniProfile miniProfile;
  public final long numActivities;
  public final long numFollowers;
  public final long numLastUpdateViews;
  public final long numProfileViews;
  
  Header(Urn paramUrn, MiniProfile paramMiniProfile, BackgroundImage paramBackgroundImage, long paramLong1, long paramLong2, SocialUpdateType paramSocialUpdateType, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    entityUrn = paramUrn;
    miniProfile = paramMiniProfile;
    backgroundImage = paramBackgroundImage;
    numProfileViews = paramLong1;
    numLastUpdateViews = paramLong2;
    lastUpdateType = paramSocialUpdateType;
    numFollowers = paramLong3;
    numActivities = paramLong4;
    hasEntityUrn = paramBoolean1;
    hasMiniProfile = paramBoolean2;
    hasBackgroundImage = paramBoolean3;
    hasNumProfileViews = paramBoolean4;
    hasNumLastUpdateViews = paramBoolean5;
    hasLastUpdateType = paramBoolean6;
    hasNumFollowers = paramBoolean7;
    hasNumActivities = paramBoolean8;
    paramMiniProfile = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  private Header accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1;
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    if (hasMiniProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("miniProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniProfile.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label322;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label89:
      localObject1 = null;
      bool2 = false;
      if (hasBackgroundImage)
      {
        paramDataProcessor.startRecordField$505cff1c("backgroundImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label331;
        }
        localObject1 = backgroundImage.accept(paramDataProcessor);
        label128:
        if (localObject1 == null) {
          break label349;
        }
      }
    }
    label322:
    label331:
    label349:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasNumProfileViews)
      {
        paramDataProcessor.startRecordField$505cff1c("numProfileViews");
        paramDataProcessor.processLong(numProfileViews);
      }
      if (hasNumLastUpdateViews)
      {
        paramDataProcessor.startRecordField$505cff1c("numLastUpdateViews");
        paramDataProcessor.processLong(numLastUpdateViews);
      }
      if (hasLastUpdateType)
      {
        paramDataProcessor.startRecordField$505cff1c("lastUpdateType");
        paramDataProcessor.processEnum(lastUpdateType);
      }
      if (hasNumFollowers)
      {
        paramDataProcessor.startRecordField$505cff1c("numFollowers");
        paramDataProcessor.processLong(numFollowers);
      }
      if (hasNumActivities)
      {
        paramDataProcessor.startRecordField$505cff1c("numActivities");
        paramDataProcessor.processLong(numActivities);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label435;
      }
      try
      {
        if (hasEntityUrn) {
          break label354;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.Header", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfile);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label89;
      localObject1 = (BackgroundImage)paramDataProcessor.processDataTemplate(backgroundImage);
      break label128;
    }
    label354:
    if (!hasMiniProfile) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.Header", "miniProfile");
    }
    return new Header(entityUrn, (MiniProfile)localObject2, (BackgroundImage)localObject1, numProfileViews, numLastUpdateViews, lastUpdateType, numFollowers, numActivities, hasEntityUrn, bool1, bool2, hasNumProfileViews, hasNumLastUpdateViews, hasLastUpdateType, hasNumFollowers, hasNumActivities);
    label435:
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
      paramObject = (Header)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (miniProfile != null)
      {
        if (miniProfile.equals(miniProfile)) {}
      }
      else {
        while (miniProfile != null) {
          return false;
        }
      }
      if (backgroundImage != null)
      {
        if (backgroundImage.equals(backgroundImage)) {}
      }
      else {
        while (backgroundImage != null) {
          return false;
        }
      }
      if (numProfileViews != numProfileViews) {
        return false;
      }
      if (numLastUpdateViews != numLastUpdateViews) {
        return false;
      }
      if (lastUpdateType != null)
      {
        if (lastUpdateType.equals(lastUpdateType)) {}
      }
      else {
        while (lastUpdateType != null) {
          return false;
        }
      }
      if (numFollowers != numFollowers) {
        return false;
      }
    } while (numActivities == numActivities);
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
    if (hasMiniProfile)
    {
      i = j + 1;
      if (miniProfile._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniProfile._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasBackgroundImage)
      {
        i = j + 1;
        if (backgroundImage._cachedId == null) {
          break label238;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(backgroundImage._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasNumProfileViews) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasNumLastUpdateViews) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasLastUpdateType) {
        i = j + 2;
      }
      j = i + 1;
      i = j;
      if (hasNumFollowers) {
        i = j + 8;
      }
      j = i + 1;
      i = j;
      if (hasNumActivities) {
        i = j + 8;
      }
      __sizeOfObject = i;
      return i;
      i += miniProfile.getSerializedSize();
      break;
      label238:
      i += backgroundImage.getSerializedSize();
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
      if (miniProfile == null) {
        break label186;
      }
      j = miniProfile.hashCode();
      label45:
      if (backgroundImage == null) {
        break label191;
      }
    }
    label186:
    label191:
    for (int k = backgroundImage.hashCode();; k = 0)
    {
      int n = (int)(numProfileViews ^ numProfileViews >>> 32);
      int i1 = (int)(numLastUpdateViews ^ numLastUpdateViews >>> 32);
      if (lastUpdateType != null) {
        m = lastUpdateType.hashCode();
      }
      i = (((((k + (j + (i + 527) * 31) * 31) * 31 + n) * 31 + i1) * 31 + m) * 31 + (int)(numFollowers ^ numFollowers >>> 32)) * 31 + (int)(numActivities ^ numActivities >>> 32);
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Header");
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
    label264:
    label288:
    label312:
    label341:
    label365:
    label432:
    label457:
    label467:
    label492:
    label502:
    label512:
    label522:
    label532:
    label542:
    label550:
    label552:
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
        localByteBuffer.putInt(-1530519191);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasMiniProfile) {
            break label457;
          }
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId == null) {
            break label432;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
          miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasBackgroundImage) {
            break label492;
          }
          localByteBuffer.put((byte)1);
          if (backgroundImage._cachedId == null) {
            break label467;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, backgroundImage._cachedId);
          backgroundImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasNumProfileViews) {
            break label502;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numProfileViews);
          if (!hasNumLastUpdateViews) {
            break label512;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numLastUpdateViews);
          if (!hasLastUpdateType) {
            break label522;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, lastUpdateType.ordinal());
          if (!hasNumFollowers) {
            break label532;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numFollowers);
          if (!hasNumActivities) {
            break label542;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(numActivities);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label550;
          }
          if (str != null) {
            break label552;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          miniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label204;
          localByteBuffer.put((byte)0);
          break label204;
          localByteBuffer.put((byte)1);
          backgroundImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label264;
          localByteBuffer.put((byte)0);
          break label264;
          localByteBuffer.put((byte)0);
          break label288;
          localByteBuffer.put((byte)0);
          break label312;
          localByteBuffer.put((byte)0);
          break label341;
          localByteBuffer.put((byte)0);
          break label365;
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.Header
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */