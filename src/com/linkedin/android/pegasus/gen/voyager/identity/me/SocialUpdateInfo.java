package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SocialUpdateInfo
  implements FissileDataModel<SocialUpdateInfo>, RecordTemplate<SocialUpdateInfo>
{
  public static final SocialUpdateInfoBuilder BUILDER = SocialUpdateInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn entity;
  public final boolean hasEntity;
  public final boolean hasImage;
  public final boolean hasText;
  public final boolean hasTitle;
  public final boolean hasTotalSocialActivityCounts;
  public final boolean hasType;
  public final Image image;
  public final AttributedText text;
  public final AttributedText title;
  public final SocialActivityCounts totalSocialActivityCounts;
  public final SocialUpdateType type;
  
  SocialUpdateInfo(SocialUpdateType paramSocialUpdateType, Image paramImage, AttributedText paramAttributedText1, AttributedText paramAttributedText2, SocialActivityCounts paramSocialActivityCounts, Urn paramUrn, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    type = paramSocialUpdateType;
    image = paramImage;
    title = paramAttributedText1;
    text = paramAttributedText2;
    totalSocialActivityCounts = paramSocialActivityCounts;
    entity = paramUrn;
    hasType = paramBoolean1;
    hasImage = paramBoolean2;
    hasTitle = paramBoolean3;
    hasText = paramBoolean4;
    hasTotalSocialActivityCounts = paramBoolean5;
    hasEntity = paramBoolean6;
    _cachedId = null;
  }
  
  public final SocialUpdateInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processEnum(type);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label81:
    Object localObject3;
    boolean bool2;
    label120:
    label131:
    Object localObject4;
    boolean bool3;
    if (hasImage)
    {
      paramDataProcessor.startRecordField$505cff1c("image");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = image.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label326;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasTitle)
      {
        paramDataProcessor.startRecordField$505cff1c("title");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label335;
        }
        localObject1 = title.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label353;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasText)
      {
        paramDataProcessor.startRecordField$505cff1c("text");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label362;
        }
        localObject1 = text.accept(paramDataProcessor);
        label171:
        if (localObject1 == null) {
          break label380;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label183:
      localObject1 = null;
      bool4 = false;
      if (hasTotalSocialActivityCounts)
      {
        paramDataProcessor.startRecordField$505cff1c("totalSocialActivityCounts");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label390;
        }
        localObject1 = totalSocialActivityCounts.accept(paramDataProcessor);
        label223:
        if (localObject1 == null) {
          break label408;
        }
      }
    }
    label326:
    label335:
    label353:
    label362:
    label380:
    label390:
    label408:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (hasEntity)
      {
        paramDataProcessor.startRecordField$505cff1c("entity");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entity));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label471;
      }
      try
      {
        if (hasType) {
          break label414;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateInfo", "type");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (Image)paramDataProcessor.processDataTemplate(image);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label81;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(title);
      break label120;
      bool2 = false;
      localObject3 = localObject1;
      break label131;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(text);
      break label171;
      bool3 = false;
      localObject4 = localObject1;
      break label183;
      localObject1 = (SocialActivityCounts)paramDataProcessor.processDataTemplate(totalSocialActivityCounts);
      break label223;
    }
    label414:
    if (!hasEntity) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateInfo", "entity");
    }
    return new SocialUpdateInfo(type, (Image)localObject2, (AttributedText)localObject3, (AttributedText)localObject4, (SocialActivityCounts)localObject1, entity, hasType, bool1, bool2, bool3, bool4, hasEntity);
    label471:
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
      paramObject = (SocialUpdateInfo)paramObject;
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (image != null)
      {
        if (image.equals(image)) {}
      }
      else {
        while (image != null) {
          return false;
        }
      }
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
          return false;
        }
      }
      if (text != null)
      {
        if (text.equals(text)) {}
      }
      else {
        while (text != null) {
          return false;
        }
      }
      if (totalSocialActivityCounts != null)
      {
        if (totalSocialActivityCounts.equals(totalSocialActivityCounts)) {}
      }
      else {
        while (totalSocialActivityCounts != null) {
          return false;
        }
      }
      if (entity == null) {
        break;
      }
    } while (entity.equals(entity));
    for (;;)
    {
      return false;
      if (entity == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasImage)
    {
      i = j + 1;
      if (image._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(image._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasTitle)
      {
        i = j + 1;
        if (title._cachedId == null) {
          break label253;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(title._cachedId);
      }
      label117:
      j = i + 1;
      i = j;
      if (hasText)
      {
        i = j + 1;
        if (text._cachedId == null) {
          break label266;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(text._cachedId);
      }
      label159:
      j = i + 1;
      i = j;
      if (hasTotalSocialActivityCounts)
      {
        i = j + 1;
        if (totalSocialActivityCounts._cachedId == null) {
          break label279;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(totalSocialActivityCounts._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasEntity)
      {
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entity));
      }
      __sizeOfObject = i;
      return i;
      i += image.getSerializedSize();
      break;
      label253:
      i += title.getSerializedSize();
      break label117;
      label266:
      i += text.getSerializedSize();
      break label159;
      label279:
      i += totalSocialActivityCounts.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    if (type != null)
    {
      i = type.hashCode();
      if (image == null) {
        break label154;
      }
      j = image.hashCode();
      if (title == null) {
        break label159;
      }
      k = title.hashCode();
      if (text == null) {
        break label164;
      }
      m = text.hashCode();
      label76:
      if (totalSocialActivityCounts == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = totalSocialActivityCounts.hashCode();; n = 0)
    {
      if (entity != null) {
        i1 = entity.hashCode();
      }
      i = (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SocialUpdateInfo");
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
    label199:
    label259:
    label319:
    label379:
    label456:
    label481:
    label491:
    label516:
    label526:
    label551:
    label561:
    label586:
    label596:
    label604:
    label606:
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
        localByteBuffer.putInt(-124834702);
        if (hasType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, type.ordinal());
          if (!hasImage) {
            break label481;
          }
          localByteBuffer.put((byte)1);
          if (image._cachedId == null) {
            break label456;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, image._cachedId);
          image.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasTitle) {
            break label516;
          }
          localByteBuffer.put((byte)1);
          if (title._cachedId == null) {
            break label491;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, title._cachedId);
          title.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasText) {
            break label551;
          }
          localByteBuffer.put((byte)1);
          if (text._cachedId == null) {
            break label526;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, text._cachedId);
          text.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasTotalSocialActivityCounts) {
            break label586;
          }
          localByteBuffer.put((byte)1);
          if (totalSocialActivityCounts._cachedId == null) {
            break label561;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, totalSocialActivityCounts._cachedId);
          totalSocialActivityCounts.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasEntity) {
            break label596;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entity));
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label604;
          }
          if (str != null) {
            break label606;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          image.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label199;
          localByteBuffer.put((byte)0);
          break label199;
          localByteBuffer.put((byte)1);
          title.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label259;
          localByteBuffer.put((byte)0);
          break label259;
          localByteBuffer.put((byte)1);
          text.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label319;
          localByteBuffer.put((byte)0);
          break label319;
          localByteBuffer.put((byte)1);
          totalSocialActivityCounts.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label379;
          localByteBuffer.put((byte)0);
          break label379;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */