package com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateType;
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
  public final Date createdOn;
  public final Urn entityUrn;
  public final boolean hasCreatedOn;
  public final boolean hasEntityUrn;
  public final boolean hasImage;
  public final boolean hasObjectUrn;
  public final boolean hasSocialUpdateType;
  public final boolean hasTitle;
  public final boolean hasTotalSocialActivityCounts;
  public final boolean hasTrackingId;
  public final Image image;
  public final Urn objectUrn;
  public final SocialUpdateType socialUpdateType;
  public final String title;
  public final SocialActivityCounts totalSocialActivityCounts;
  public final String trackingId;
  
  Header(String paramString1, Date paramDate, SocialActivityCounts paramSocialActivityCounts, Image paramImage, SocialUpdateType paramSocialUpdateType, String paramString2, Urn paramUrn1, Urn paramUrn2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    title = paramString1;
    createdOn = paramDate;
    totalSocialActivityCounts = paramSocialActivityCounts;
    image = paramImage;
    socialUpdateType = paramSocialUpdateType;
    trackingId = paramString2;
    entityUrn = paramUrn1;
    objectUrn = paramUrn2;
    hasTitle = paramBoolean1;
    hasCreatedOn = paramBoolean2;
    hasTotalSocialActivityCounts = paramBoolean3;
    hasImage = paramBoolean4;
    hasSocialUpdateType = paramBoolean5;
    hasTrackingId = paramBoolean6;
    hasEntityUrn = paramBoolean7;
    hasObjectUrn = paramBoolean8;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
  }
  
  private Header accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label81:
    Object localObject3;
    boolean bool2;
    if (hasCreatedOn)
    {
      paramDataProcessor.startRecordField$505cff1c("createdOn");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = createdOn.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label357;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasTotalSocialActivityCounts)
      {
        paramDataProcessor.startRecordField$505cff1c("totalSocialActivityCounts");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label366;
        }
        localObject1 = totalSocialActivityCounts.accept(paramDataProcessor);
        label120:
        if (localObject1 == null) {
          break label384;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label131:
      localObject1 = null;
      bool3 = false;
      if (hasImage)
      {
        paramDataProcessor.startRecordField$505cff1c("image");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label393;
        }
        localObject1 = image.accept(paramDataProcessor);
        label171:
        if (localObject1 == null) {
          break label411;
        }
      }
    }
    label357:
    label366:
    label384:
    label393:
    label411:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (hasSocialUpdateType)
      {
        paramDataProcessor.startRecordField$505cff1c("socialUpdateType");
        paramDataProcessor.processEnum(socialUpdateType);
      }
      if (hasTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingId");
        paramDataProcessor.processString(trackingId);
      }
      UrnCoercer localUrnCoercer;
      if (hasEntityUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("entityUrn");
        localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
      }
      if (hasObjectUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("objectUrn");
        localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(objectUrn));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label570;
      }
      try
      {
        if (hasCreatedOn) {
          break label417;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.Header", "createdOn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (Date)paramDataProcessor.processDataTemplate(createdOn);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label81;
      localObject1 = (SocialActivityCounts)paramDataProcessor.processDataTemplate(totalSocialActivityCounts);
      break label120;
      bool2 = false;
      localObject3 = localObject1;
      break label131;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(image);
      break label171;
    }
    label417:
    if (!hasTotalSocialActivityCounts) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.Header", "totalSocialActivityCounts");
    }
    if (!hasSocialUpdateType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.Header", "socialUpdateType");
    }
    if (!hasTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.Header", "trackingId");
    }
    if (!hasEntityUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.Header", "entityUrn");
    }
    if (!hasObjectUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.Header", "objectUrn");
    }
    return new Header(title, (Date)localObject2, (SocialActivityCounts)localObject3, (Image)localObject1, socialUpdateType, trackingId, entityUrn, objectUrn, hasTitle, bool1, bool2, bool3, hasSocialUpdateType, hasTrackingId, hasEntityUrn, hasObjectUrn);
    label570:
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
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
          return false;
        }
      }
      if (createdOn != null)
      {
        if (createdOn.equals(createdOn)) {}
      }
      else {
        while (createdOn != null) {
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
      if (image != null)
      {
        if (image.equals(image)) {}
      }
      else {
        while (image != null) {
          return false;
        }
      }
      if (socialUpdateType != null)
      {
        if (socialUpdateType.equals(socialUpdateType)) {}
      }
      else {
        while (socialUpdateType != null) {
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
      if (objectUrn == null) {
        break;
      }
    } while (objectUrn.equals(objectUrn));
    for (;;)
    {
      return false;
      if (objectUrn == null) {
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
    if (hasTitle) {
      i = PegasusBinaryUtils.getEncodedLength(title) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasCreatedOn)
    {
      i = j + 1;
      if (createdOn._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(createdOn._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasTotalSocialActivityCounts)
      {
        i = j + 1;
        if (totalSocialActivityCounts._cachedId == null) {
          break label290;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(totalSocialActivityCounts._cachedId);
      }
      label122:
      j = i + 1;
      i = j;
      if (hasImage)
      {
        i = j + 1;
        if (image._cachedId == null) {
          break label303;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(image._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasSocialUpdateType) {
        i = j + 2;
      }
      j = i + 1;
      i = j;
      if (hasTrackingId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(trackingId);
      }
      j = i + 1;
      i = j;
      UrnCoercer localUrnCoercer;
      if (hasEntityUrn)
      {
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn));
      }
      j = i + 1;
      i = j;
      if (hasObjectUrn)
      {
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(objectUrn));
      }
      __sizeOfObject = i;
      return i;
      i += createdOn.getSerializedSize();
      break;
      label290:
      i += totalSocialActivityCounts.getSerializedSize();
      break label122;
      label303:
      i += image.getSerializedSize();
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
    if (title != null)
    {
      i = title.hashCode();
      if (createdOn == null) {
        break label176;
      }
      j = createdOn.hashCode();
      if (totalSocialActivityCounts == null) {
        break label181;
      }
      k = totalSocialActivityCounts.hashCode();
      if (image == null) {
        break label186;
      }
      m = image.hashCode();
      if (socialUpdateType == null) {
        break label192;
      }
      n = socialUpdateType.hashCode();
      label92:
      if (entityUrn == null) {
        break label198;
      }
    }
    label176:
    label181:
    label186:
    label192:
    label198:
    for (int i1 = entityUrn.hashCode();; i1 = 0)
    {
      if (objectUrn != null) {
        i2 = objectUrn.hashCode();
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
    label196:
    label256:
    label316:
    label345:
    label371:
    label405:
    label482:
    label507:
    label517:
    label542:
    label552:
    label577:
    label587:
    label597:
    label607:
    label617:
    label625:
    label627:
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
        localByteBuffer.putInt(-1322951007);
        if (hasTitle)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasCreatedOn) {
            break label507;
          }
          localByteBuffer.put((byte)1);
          if (createdOn._cachedId == null) {
            break label482;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, createdOn._cachedId);
          createdOn.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasTotalSocialActivityCounts) {
            break label542;
          }
          localByteBuffer.put((byte)1);
          if (totalSocialActivityCounts._cachedId == null) {
            break label517;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, totalSocialActivityCounts._cachedId);
          totalSocialActivityCounts.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasImage) {
            break label577;
          }
          localByteBuffer.put((byte)1);
          if (image._cachedId == null) {
            break label552;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, image._cachedId);
          image.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSocialUpdateType) {
            break label587;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, socialUpdateType.ordinal());
          if (!hasTrackingId) {
            break label597;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingId);
          if (!hasEntityUrn) {
            break label607;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasObjectUrn) {
            break label617;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(objectUrn));
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label625;
          }
          if (str != null) {
            break label627;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          createdOn.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label196;
          localByteBuffer.put((byte)0);
          break label196;
          localByteBuffer.put((byte)1);
          totalSocialActivityCounts.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label256;
          localByteBuffer.put((byte)0);
          break label256;
          localByteBuffer.put((byte)1);
          image.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label316;
          localByteBuffer.put((byte)0);
          break label316;
          localByteBuffer.put((byte)0);
          break label345;
          localByteBuffer.put((byte)0);
          break label371;
          localByteBuffer.put((byte)0);
          break label405;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.Header
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */