package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SocialDetail
  implements FissileDataModel<SocialDetail>, RecordTemplate<SocialDetail>
{
  public static final SocialDetailBuilder BUILDER = SocialDetailBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Comments comments;
  public final Urn entityUrn;
  public final boolean hasComments;
  public final boolean hasEntityUrn;
  public final boolean hasLiked;
  public final boolean hasLikes;
  public final boolean hasThreadId;
  public final boolean hasTotalShares;
  public final boolean hasTotalSocialActivityCounts;
  public final boolean hasUrn;
  public final boolean liked;
  public final Likes likes;
  public final String threadId;
  public final int totalShares;
  public final SocialActivityCounts totalSocialActivityCounts;
  public final Urn urn;
  
  SocialDetail(Urn paramUrn1, Urn paramUrn2, SocialActivityCounts paramSocialActivityCounts, int paramInt, boolean paramBoolean1, Likes paramLikes, Comments paramComments, String paramString, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9)
  {
    urn = paramUrn1;
    entityUrn = paramUrn2;
    totalSocialActivityCounts = paramSocialActivityCounts;
    totalShares = paramInt;
    liked = paramBoolean1;
    likes = paramLikes;
    comments = paramComments;
    threadId = paramString;
    hasUrn = paramBoolean2;
    hasEntityUrn = paramBoolean3;
    hasTotalSocialActivityCounts = paramBoolean4;
    hasTotalShares = paramBoolean5;
    hasLiked = paramBoolean6;
    hasLikes = paramBoolean7;
    hasComments = paramBoolean8;
    hasThreadId = paramBoolean9;
    paramUrn1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn2);
  }
  
  public final SocialDetail accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
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
    Object localObject2 = null;
    boolean bool1 = false;
    label122:
    Object localObject3;
    boolean bool2;
    if (hasTotalSocialActivityCounts)
    {
      paramDataProcessor.startRecordField$505cff1c("totalSocialActivityCounts");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = totalSocialActivityCounts.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label357;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasTotalShares)
      {
        paramDataProcessor.startRecordField$505cff1c("totalShares");
        paramDataProcessor.processInt(totalShares);
      }
      if (hasLiked)
      {
        paramDataProcessor.startRecordField$505cff1c("liked");
        paramDataProcessor.processBoolean(liked);
      }
      localObject3 = null;
      bool2 = false;
      if (hasLikes)
      {
        paramDataProcessor.startRecordField$505cff1c("likes");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label366;
        }
        localObject1 = likes.accept(paramDataProcessor);
        label211:
        if (localObject1 == null) {
          break label384;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label222:
      localObject1 = null;
      bool3 = false;
      if (hasComments)
      {
        paramDataProcessor.startRecordField$505cff1c("comments");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label393;
        }
        localObject1 = comments.accept(paramDataProcessor);
        label262:
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
      if (hasThreadId)
      {
        paramDataProcessor.startRecordField$505cff1c("threadId");
        paramDataProcessor.processString(threadId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label513;
      }
      try
      {
        if (hasTotalSocialActivityCounts) {
          break label417;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail", "totalSocialActivityCounts");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (SocialActivityCounts)paramDataProcessor.processDataTemplate(totalSocialActivityCounts);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label122;
      localObject1 = (Likes)paramDataProcessor.processDataTemplate(likes);
      break label211;
      bool2 = false;
      localObject3 = localObject1;
      break label222;
      localObject1 = (Comments)paramDataProcessor.processDataTemplate(comments);
      break label262;
    }
    label417:
    if (!hasLikes) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail", "likes");
    }
    if (!hasComments) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail", "comments");
    }
    return new SocialDetail(urn, entityUrn, (SocialActivityCounts)localObject2, totalShares, liked, (Likes)localObject3, (Comments)localObject1, threadId, hasUrn, hasEntityUrn, bool1, hasTotalShares, hasLiked, bool2, bool3, hasThreadId);
    label513:
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
      paramObject = (SocialDetail)paramObject;
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
      if (totalSocialActivityCounts != null)
      {
        if (totalSocialActivityCounts.equals(totalSocialActivityCounts)) {}
      }
      else {
        while (totalSocialActivityCounts != null) {
          return false;
        }
      }
      if (totalShares != totalShares) {
        return false;
      }
      if (liked != liked) {
        return false;
      }
      if (likes != null)
      {
        if (likes.equals(likes)) {}
      }
      else {
        while (likes != null) {
          return false;
        }
      }
      if (comments != null)
      {
        if (comments.equals(comments)) {}
      }
      else {
        while (comments != null) {
          return false;
        }
      }
      if (threadId == null) {
        break;
      }
    } while (threadId.equals(threadId));
    for (;;)
    {
      return false;
      if (threadId == null) {
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
    UrnCoercer localUrnCoercer;
    if (hasUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(urn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasEntityUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    j = i + 1;
    i = j;
    if (hasTotalSocialActivityCounts)
    {
      i = j + 1;
      if (totalSocialActivityCounts._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(totalSocialActivityCounts._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasTotalShares) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasLiked) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasLikes)
      {
        i = j + 1;
        if (likes._cachedId == null) {
          break label282;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(likes._cachedId);
      }
      label195:
      j = i + 1;
      i = j;
      if (hasComments)
      {
        i = j + 1;
        if (comments._cachedId == null) {
          break label295;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(comments._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasThreadId) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(threadId);
      }
      __sizeOfObject = i;
      return i;
      i += totalSocialActivityCounts.getSerializedSize();
      break;
      label282:
      i += likes.getSerializedSize();
      break label195;
      label295:
      i += comments.getSerializedSize();
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
    int i3;
    int m;
    label76:
    int n;
    if (urn != null)
    {
      i = urn.hashCode();
      if (entityUrn == null) {
        break label182;
      }
      j = entityUrn.hashCode();
      if (totalSocialActivityCounts == null) {
        break label187;
      }
      k = totalSocialActivityCounts.hashCode();
      i3 = totalShares;
      if (!liked) {
        break label192;
      }
      m = 1;
      if (likes == null) {
        break label198;
      }
      n = likes.hashCode();
      label92:
      if (comments == null) {
        break label204;
      }
    }
    label182:
    label187:
    label192:
    label198:
    label204:
    for (int i1 = comments.hashCode();; i1 = 0)
    {
      if (threadId != null) {
        i2 = threadId.hashCode();
      }
      i = (i1 + (n + (m + ((k + (j + (i + 527) * 31) * 31) * 31 + i3) * 31) * 31) * 31) * 31 + i2;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SocialDetail");
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
    label178:
    label238:
    label262:
    label286:
    label295:
    label355:
    label415:
    label484:
    label494:
    label519:
    label529:
    label539:
    label545:
    label555:
    label580:
    label590:
    label615:
    label625:
    label633:
    label635:
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
        localByteBuffer.putInt(1363310372);
        if (hasUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(urn));
          if (!hasEntityUrn) {
            break label484;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasTotalSocialActivityCounts) {
            break label519;
          }
          localByteBuffer.put((byte)1);
          if (totalSocialActivityCounts._cachedId == null) {
            break label494;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, totalSocialActivityCounts._cachedId);
          totalSocialActivityCounts.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasTotalShares) {
            break label529;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(totalShares);
          if (!hasLiked) {
            break label545;
          }
          localByteBuffer.put((byte)1);
          if (!liked) {
            break label539;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasLikes) {
            break label580;
          }
          localByteBuffer.put((byte)1);
          if (likes._cachedId == null) {
            break label555;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, likes._cachedId);
          likes.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasComments) {
            break label615;
          }
          localByteBuffer.put((byte)1);
          if (comments._cachedId == null) {
            break label590;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, comments._cachedId);
          comments.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasThreadId) {
            break label625;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, threadId);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label633;
          }
          if (str != null) {
            break label635;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label178;
          localByteBuffer.put((byte)1);
          totalSocialActivityCounts.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label238;
          localByteBuffer.put((byte)0);
          break label238;
          localByteBuffer.put((byte)0);
          break label262;
          i = 0;
          break label286;
          localByteBuffer.put((byte)0);
          break label295;
          localByteBuffer.put((byte)1);
          likes.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label355;
          localByteBuffer.put((byte)0);
          break label355;
          localByteBuffer.put((byte)1);
          comments.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label415;
          localByteBuffer.put((byte)0);
          break label415;
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
    implements RecordTemplateBuilder<SocialDetail>
  {
    private Comments comments = null;
    private Urn entityUrn = null;
    private boolean hasComments = false;
    private boolean hasEntityUrn = false;
    private boolean hasLiked = false;
    private boolean hasLikes = false;
    private boolean hasThreadId = false;
    private boolean hasTotalShares = false;
    private boolean hasTotalSocialActivityCounts = false;
    private boolean hasUrn = false;
    private boolean liked = false;
    private Likes likes = null;
    private String threadId = null;
    private int totalShares = 0;
    private SocialActivityCounts totalSocialActivityCounts = null;
    private Urn urn = null;
    
    public Builder() {}
    
    public Builder(SocialDetail paramSocialDetail)
    {
      urn = urn;
      entityUrn = entityUrn;
      totalSocialActivityCounts = totalSocialActivityCounts;
      totalShares = totalShares;
      liked = liked;
      likes = likes;
      comments = comments;
      threadId = threadId;
      hasUrn = hasUrn;
      hasEntityUrn = hasEntityUrn;
      hasTotalSocialActivityCounts = hasTotalSocialActivityCounts;
      hasTotalShares = hasTotalShares;
      hasLiked = hasLiked;
      hasLikes = hasLikes;
      hasComments = hasComments;
      hasThreadId = hasThreadId;
    }
    
    public final SocialDetail build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (SocialDetail.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new SocialDetail(urn, entityUrn, totalSocialActivityCounts, totalShares, liked, likes, comments, threadId, hasUrn, hasEntityUrn, hasTotalSocialActivityCounts, hasTotalShares, hasLiked, hasLikes, hasComments, hasThreadId);
        if (!hasTotalShares) {
          totalShares = 0;
        }
        if (!hasLiked) {
          liked = false;
        }
        if (!hasTotalSocialActivityCounts) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail", "totalSocialActivityCounts");
        }
        if (!hasLikes) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail", "likes");
        }
      } while (hasComments);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail", "comments");
    }
    
    public final Builder setComments(Comments paramComments)
    {
      if (paramComments == null)
      {
        hasComments = false;
        comments = null;
        return this;
      }
      hasComments = true;
      comments = paramComments;
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
    
    public final Builder setLiked(Boolean paramBoolean)
    {
      if ((paramBoolean == null) || (!paramBoolean.booleanValue()))
      {
        hasLiked = false;
        liked = false;
        return this;
      }
      hasLiked = true;
      liked = paramBoolean.booleanValue();
      return this;
    }
    
    public final Builder setLikes(Likes paramLikes)
    {
      if (paramLikes == null)
      {
        hasLikes = false;
        likes = null;
        return this;
      }
      hasLikes = true;
      likes = paramLikes;
      return this;
    }
    
    public final Builder setThreadId(String paramString)
    {
      if (paramString == null)
      {
        hasThreadId = false;
        threadId = null;
        return this;
      }
      hasThreadId = true;
      threadId = paramString;
      return this;
    }
    
    public final Builder setTotalShares(Integer paramInteger)
    {
      if ((paramInteger == null) || (paramInteger.intValue() == 0))
      {
        hasTotalShares = false;
        totalShares = 0;
        return this;
      }
      hasTotalShares = true;
      totalShares = paramInteger.intValue();
      return this;
    }
    
    public final Builder setTotalSocialActivityCounts(SocialActivityCounts paramSocialActivityCounts)
    {
      if (paramSocialActivityCounts == null)
      {
        hasTotalSocialActivityCounts = false;
        totalSocialActivityCounts = null;
        return this;
      }
      hasTotalSocialActivityCounts = true;
      totalSocialActivityCounts = paramSocialActivityCounts;
      return this;
    }
    
    public final Builder setUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasUrn = false;
        urn = null;
        return this;
      }
      hasUrn = true;
      urn = paramUrn;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */