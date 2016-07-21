package com.linkedin.android.pegasus.gen.voyager.growth.interests;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Channel
  implements FissileDataModel<Channel>, RecordTemplate<Channel>
{
  public static final ChannelBuilder BUILDER = ChannelBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Image backgroundImage;
  public final Urn entityUrn;
  public final FollowingInfo followingInfo;
  public final boolean hasBackgroundImage;
  public final boolean hasEntityUrn;
  public final boolean hasFollowingInfo;
  public final boolean hasId;
  public final boolean hasLogo;
  public final boolean hasName;
  public final boolean hasUrn;
  public final String id;
  public final Image logo;
  public final String name;
  public final Urn urn;
  
  Channel(String paramString1, Urn paramUrn1, Urn paramUrn2, String paramString2, Image paramImage1, Image paramImage2, FollowingInfo paramFollowingInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    id = paramString1;
    urn = paramUrn1;
    entityUrn = paramUrn2;
    name = paramString2;
    logo = paramImage1;
    backgroundImage = paramImage2;
    followingInfo = paramFollowingInfo;
    hasId = paramBoolean1;
    hasUrn = paramBoolean2;
    hasEntityUrn = paramBoolean3;
    hasName = paramBoolean4;
    hasLogo = paramBoolean5;
    hasBackgroundImage = paramBoolean6;
    hasFollowingInfo = paramBoolean7;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn2);
  }
  
  public final Channel accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasId)
    {
      paramDataProcessor.startRecordField$505cff1c("id");
      paramDataProcessor.processString(id);
    }
    Object localObject1;
    if (hasUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("urn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(urn));
    }
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasName)
    {
      paramDataProcessor.startRecordField$505cff1c("name");
      paramDataProcessor.processString(name);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    label172:
    Object localObject3;
    boolean bool2;
    if (hasLogo)
    {
      paramDataProcessor.startRecordField$505cff1c("logo");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = logo.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label332;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasBackgroundImage)
      {
        paramDataProcessor.startRecordField$505cff1c("backgroundImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label341;
        }
        localObject1 = backgroundImage.accept(paramDataProcessor);
        label211:
        if (localObject1 == null) {
          break label359;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label222:
      localObject1 = null;
      bool3 = false;
      if (hasFollowingInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("followingInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label368;
        }
        localObject1 = followingInfo.accept(paramDataProcessor);
        label262:
        if (localObject1 == null) {
          break label386;
        }
      }
    }
    label332:
    label341:
    label359:
    label368:
    label386:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label518;
      }
      try
      {
        if (hasId) {
          break label392;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel", "id");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (Image)paramDataProcessor.processDataTemplate(logo);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label172;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(backgroundImage);
      break label211;
      bool2 = false;
      localObject3 = localObject1;
      break label222;
      localObject1 = (FollowingInfo)paramDataProcessor.processDataTemplate(followingInfo);
      break label262;
    }
    label392:
    if (!hasUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel", "urn");
    }
    if (!hasEntityUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel", "entityUrn");
    }
    if (!hasName) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel", "name");
    }
    if (!hasFollowingInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel", "followingInfo");
    }
    return new Channel(id, urn, entityUrn, name, (Image)localObject2, (Image)localObject3, (FollowingInfo)localObject1, hasId, hasUrn, hasEntityUrn, hasName, bool1, bool2, bool3);
    label518:
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
      paramObject = (Channel)paramObject;
      if (id != null)
      {
        if (id.equals(id)) {}
      }
      else {
        while (id != null) {
          return false;
        }
      }
      if (urn != null)
      {
        if (urn.equals(urn)) {}
      }
      else {
        while (urn != null) {
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
      if (name != null)
      {
        if (name.equals(name)) {}
      }
      else {
        while (name != null) {
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
      if (backgroundImage != null)
      {
        if (backgroundImage.equals(backgroundImage)) {}
      }
      else {
        while (backgroundImage != null) {
          return false;
        }
      }
      if (followingInfo == null) {
        break;
      }
    } while (followingInfo.equals(followingInfo));
    for (;;)
    {
      return false;
      if (followingInfo == null) {
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
    if (hasId) {
      i = PegasusBinaryUtils.getEncodedLength(id) + 8;
    }
    int j = i + 1;
    i = j;
    UrnCoercer localUrnCoercer;
    if (hasUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(urn));
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
    if (hasName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(name);
    }
    j = i + 1;
    i = j;
    if (hasLogo)
    {
      i = j + 1;
      if (logo._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(logo._cachedId);
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
          break label273;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(backgroundImage._cachedId);
      }
      label211:
      j = i + 1;
      i = j;
      if (hasFollowingInfo)
      {
        i = j + 1;
        if (followingInfo._cachedId == null) {
          break label286;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(followingInfo._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += logo.getSerializedSize();
      break;
      label273:
      i += backgroundImage.getSerializedSize();
      break label211;
      label286:
      i += followingInfo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int n;
    if (id != null)
    {
      i = id.hashCode();
      if (urn == null) {
        break label176;
      }
      j = urn.hashCode();
      if (entityUrn == null) {
        break label181;
      }
      k = entityUrn.hashCode();
      if (name == null) {
        break label186;
      }
      m = name.hashCode();
      if (logo == null) {
        break label192;
      }
      n = logo.hashCode();
      label92:
      if (backgroundImage == null) {
        break label198;
      }
    }
    label176:
    label181:
    label186:
    label192:
    label198:
    for (int i1 = backgroundImage.hashCode();; i1 = 0)
    {
      if (followingInfo != null) {
        i2 = followingInfo.hashCode();
      }
      i = (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
      n = 0;
      break label92;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Channel");
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
    label290:
    label350:
    label453:
    label463:
    label473:
    label483:
    label508:
    label518:
    label543:
    label553:
    label578:
    label586:
    label588:
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
        localByteBuffer.putInt(888517622);
        if (hasId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, id);
          if (!hasUrn) {
            break label453;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(urn));
          if (!hasEntityUrn) {
            break label463;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasName) {
            break label473;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, name);
          if (!hasLogo) {
            break label508;
          }
          localByteBuffer.put((byte)1);
          if (logo._cachedId == null) {
            break label483;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, logo._cachedId);
          logo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasBackgroundImage) {
            break label543;
          }
          localByteBuffer.put((byte)1);
          if (backgroundImage._cachedId == null) {
            break label518;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, backgroundImage._cachedId);
          backgroundImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasFollowingInfo) {
            break label578;
          }
          localByteBuffer.put((byte)1);
          if (followingInfo._cachedId == null) {
            break label553;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, followingInfo._cachedId);
          followingInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label586;
          }
          if (str != null) {
            break label588;
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
          localByteBuffer.put((byte)1);
          logo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          backgroundImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label350;
          localByteBuffer.put((byte)0);
          break label350;
          localByteBuffer.put((byte)1);
          followingInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */