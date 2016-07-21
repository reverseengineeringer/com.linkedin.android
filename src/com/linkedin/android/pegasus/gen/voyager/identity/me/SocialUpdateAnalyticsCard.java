package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SocialUpdateAnalyticsCard
  implements FissileDataModel<SocialUpdateAnalyticsCard>, RecordTemplate<SocialUpdateAnalyticsCard>
{
  public static final SocialUpdateAnalyticsCardBuilder BUILDER = SocialUpdateAnalyticsCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasHeadline;
  public final boolean hasInsight;
  public final boolean hasObjectUrn;
  public final boolean hasPublishedAt;
  public final boolean hasRead;
  public final boolean hasSocialUpdateInfo;
  public final AttributedText headline;
  public final Insight insight;
  public final Urn objectUrn;
  public final long publishedAt;
  public final boolean read;
  public final SocialUpdateInfo socialUpdateInfo;
  
  SocialUpdateAnalyticsCard(long paramLong, boolean paramBoolean1, AttributedText paramAttributedText, SocialUpdateInfo paramSocialUpdateInfo, Insight paramInsight, Urn paramUrn, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    publishedAt = paramLong;
    read = paramBoolean1;
    headline = paramAttributedText;
    socialUpdateInfo = paramSocialUpdateInfo;
    insight = paramInsight;
    objectUrn = paramUrn;
    hasPublishedAt = paramBoolean2;
    hasRead = paramBoolean3;
    hasHeadline = paramBoolean4;
    hasSocialUpdateInfo = paramBoolean5;
    hasInsight = paramBoolean6;
    hasObjectUrn = paramBoolean7;
    _cachedId = null;
  }
  
  public final SocialUpdateAnalyticsCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasPublishedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("publishedAt");
      paramDataProcessor.processLong(publishedAt);
    }
    if (hasRead)
    {
      paramDataProcessor.startRecordField$505cff1c("read");
      paramDataProcessor.processBoolean(read);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label106:
    Object localObject3;
    boolean bool2;
    if (hasHeadline)
    {
      paramDataProcessor.startRecordField$505cff1c("headline");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = headline.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label299;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasSocialUpdateInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("socialUpdateInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label308;
        }
        localObject1 = socialUpdateInfo.accept(paramDataProcessor);
        label145:
        if (localObject1 == null) {
          break label326;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label156:
      localObject1 = null;
      bool3 = false;
      if (hasInsight)
      {
        paramDataProcessor.startRecordField$505cff1c("insight");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label335;
        }
        localObject1 = insight.accept(paramDataProcessor);
        label196:
        if (localObject1 == null) {
          break label353;
        }
      }
    }
    label299:
    label308:
    label326:
    label335:
    label353:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (hasObjectUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("objectUrn");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(objectUrn));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label477;
      }
      try
      {
        if (hasPublishedAt) {
          break label359;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsCard", "publishedAt");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(headline);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label106;
      localObject1 = (SocialUpdateInfo)paramDataProcessor.processDataTemplate(socialUpdateInfo);
      break label145;
      bool2 = false;
      localObject3 = localObject1;
      break label156;
      localObject1 = (Insight)paramDataProcessor.processDataTemplate(insight);
      break label196;
    }
    label359:
    if (!hasRead) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsCard", "read");
    }
    if (!hasHeadline) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsCard", "headline");
    }
    if (!hasSocialUpdateInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsCard", "socialUpdateInfo");
    }
    if (!hasObjectUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsCard", "objectUrn");
    }
    return new SocialUpdateAnalyticsCard(publishedAt, read, (AttributedText)localObject2, (SocialUpdateInfo)localObject3, (Insight)localObject1, objectUrn, hasPublishedAt, hasRead, bool1, bool2, bool3, hasObjectUrn);
    label477:
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
      paramObject = (SocialUpdateAnalyticsCard)paramObject;
      if (publishedAt != publishedAt) {
        return false;
      }
      if (read != read) {
        return false;
      }
      if (headline != null)
      {
        if (headline.equals(headline)) {}
      }
      else {
        while (headline != null) {
          return false;
        }
      }
      if (socialUpdateInfo != null)
      {
        if (socialUpdateInfo.equals(socialUpdateInfo)) {}
      }
      else {
        while (socialUpdateInfo != null) {
          return false;
        }
      }
      if (insight != null)
      {
        if (insight.equals(insight)) {}
      }
      else {
        while (insight != null) {
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
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasPublishedAt) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasRead) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasHeadline)
    {
      i = j + 1;
      if (headline._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(headline._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasSocialUpdateInfo)
      {
        i = j + 1;
        if (socialUpdateInfo._cachedId == null) {
          break label229;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(socialUpdateInfo._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasInsight)
      {
        i = j + 1;
        if (insight._cachedId == null) {
          break label242;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(insight._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasObjectUrn)
      {
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(objectUrn));
      }
      __sizeOfObject = i;
      return i;
      i += headline.getSerializedSize();
      break;
      label229:
      i += socialUpdateInfo.getSerializedSize();
      break label135;
      label242:
      i += insight.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i1 = (int)(publishedAt ^ publishedAt >>> 32);
    int i;
    int j;
    label54:
    int k;
    if (read)
    {
      i = 1;
      if (headline == null) {
        break label147;
      }
      j = headline.hashCode();
      if (socialUpdateInfo == null) {
        break label152;
      }
      k = socialUpdateInfo.hashCode();
      label69:
      if (insight == null) {
        break label157;
      }
    }
    label147:
    label152:
    label157:
    for (int m = insight.hashCode();; m = 0)
    {
      if (objectUrn != null) {
        n = objectUrn.hashCode();
      }
      i = (m + (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label54;
      k = 0;
      break label69;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SocialUpdateAnalyticsCard");
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
    label158:
    label167:
    label227:
    label287:
    label347:
    label424:
    label430:
    label440:
    label465:
    label475:
    label500:
    label510:
    label535:
    label545:
    label553:
    label555:
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
        localByteBuffer.putInt(2134859204);
        if (hasPublishedAt)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(publishedAt);
          if (!hasRead) {
            break label430;
          }
          localByteBuffer.put((byte)1);
          if (!read) {
            break label424;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasHeadline) {
            break label465;
          }
          localByteBuffer.put((byte)1);
          if (headline._cachedId == null) {
            break label440;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, headline._cachedId);
          headline.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSocialUpdateInfo) {
            break label500;
          }
          localByteBuffer.put((byte)1);
          if (socialUpdateInfo._cachedId == null) {
            break label475;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, socialUpdateInfo._cachedId);
          socialUpdateInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasInsight) {
            break label535;
          }
          localByteBuffer.put((byte)1);
          if (insight._cachedId == null) {
            break label510;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, insight._cachedId);
          insight.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasObjectUrn) {
            break label545;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(objectUrn));
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label553;
          }
          if (str != null) {
            break label555;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          i = 0;
          break label158;
          localByteBuffer.put((byte)0);
          break label167;
          localByteBuffer.put((byte)1);
          headline.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label227;
          localByteBuffer.put((byte)0);
          break label227;
          localByteBuffer.put((byte)1);
          socialUpdateInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label287;
          localByteBuffer.put((byte)0);
          break label287;
          localByteBuffer.put((byte)1);
          insight.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label347;
          localByteBuffer.put((byte)0);
          break label347;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */