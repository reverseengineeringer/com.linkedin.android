package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
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

public final class JobUpdateActivityCard
  implements FissileDataModel<JobUpdateActivityCard>, RecordTemplate<JobUpdateActivityCard>
{
  public static final JobUpdateActivityCardBuilder BUILDER = JobUpdateActivityCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final ActorMiniProfile actor;
  public final AttributedText comment;
  public final Urn commentUrn;
  public final Urn entity;
  public final boolean hasActor;
  public final boolean hasComment;
  public final boolean hasCommentUrn;
  public final boolean hasEntity;
  public final boolean hasHeadline;
  public final boolean hasHeadlineV2;
  public final boolean hasPublishedAt;
  public final boolean hasRead;
  public final boolean hasText;
  public final boolean hasTotalSocialActivityCounts;
  public final AttributedText headline;
  public final AttributedText headlineV2;
  public final long publishedAt;
  public final boolean read;
  public final AttributedText text;
  public final SocialActivityCounts totalSocialActivityCounts;
  
  JobUpdateActivityCard(long paramLong, Urn paramUrn1, AttributedText paramAttributedText1, AttributedText paramAttributedText2, AttributedText paramAttributedText3, AttributedText paramAttributedText4, Urn paramUrn2, ActorMiniProfile paramActorMiniProfile, SocialActivityCounts paramSocialActivityCounts, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11)
  {
    publishedAt = paramLong;
    entity = paramUrn1;
    headline = paramAttributedText1;
    headlineV2 = paramAttributedText2;
    text = paramAttributedText3;
    comment = paramAttributedText4;
    commentUrn = paramUrn2;
    actor = paramActorMiniProfile;
    totalSocialActivityCounts = paramSocialActivityCounts;
    read = paramBoolean1;
    hasPublishedAt = paramBoolean2;
    hasEntity = paramBoolean3;
    hasHeadline = paramBoolean4;
    hasHeadlineV2 = paramBoolean5;
    hasText = paramBoolean6;
    hasComment = paramBoolean7;
    hasCommentUrn = paramBoolean8;
    hasActor = paramBoolean9;
    hasTotalSocialActivityCounts = paramBoolean10;
    hasRead = paramBoolean11;
    _cachedId = null;
  }
  
  public final JobUpdateActivityCard accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasPublishedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("publishedAt");
      paramDataProcessor.processLong(publishedAt);
    }
    Object localObject1;
    if (hasEntity)
    {
      paramDataProcessor.startRecordField$505cff1c("entity");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entity));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    label114:
    Object localObject3;
    boolean bool2;
    label153:
    label164:
    Object localObject4;
    boolean bool3;
    label204:
    label216:
    Object localObject5;
    boolean bool4;
    label256:
    label268:
    Object localObject6;
    boolean bool5;
    if (hasHeadline)
    {
      paramDataProcessor.startRecordField$505cff1c("headline");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = headline.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label488;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasHeadlineV2)
      {
        paramDataProcessor.startRecordField$505cff1c("headlineV2");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label497;
        }
        localObject1 = headlineV2.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label515;
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
          break label524;
        }
        localObject1 = text.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label542;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasComment)
      {
        paramDataProcessor.startRecordField$505cff1c("comment");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label552;
        }
        localObject1 = comment.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label570;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      if (hasCommentUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("commentUrn");
        localObject1 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(commentUrn));
      }
      localObject6 = null;
      bool5 = false;
      if (hasActor)
      {
        paramDataProcessor.startRecordField$505cff1c("actor");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label580;
        }
        localObject1 = actor.accept(paramDataProcessor);
        label341:
        if (localObject1 == null) {
          break label598;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      label353:
      localObject1 = null;
      bool6 = false;
      if (hasTotalSocialActivityCounts)
      {
        paramDataProcessor.startRecordField$505cff1c("totalSocialActivityCounts");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label608;
        }
        localObject1 = totalSocialActivityCounts.accept(paramDataProcessor);
        label393:
        if (localObject1 == null) {
          break label626;
        }
      }
    }
    label488:
    label497:
    label515:
    label524:
    label542:
    label552:
    label570:
    label580:
    label598:
    label608:
    label626:
    for (boolean bool6 = true;; bool6 = false)
    {
      if (hasRead)
      {
        paramDataProcessor.startRecordField$505cff1c("read");
        paramDataProcessor.processBoolean(read);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label808;
      }
      try
      {
        if (hasPublishedAt) {
          break label632;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard", "publishedAt");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(headline);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label114;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(headlineV2);
      break label153;
      bool2 = false;
      localObject3 = localObject1;
      break label164;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(text);
      break label204;
      bool3 = false;
      localObject4 = localObject1;
      break label216;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(comment);
      break label256;
      bool4 = false;
      localObject5 = localObject1;
      break label268;
      localObject1 = (ActorMiniProfile)paramDataProcessor.processDataTemplate(actor);
      break label341;
      bool5 = false;
      localObject6 = localObject1;
      break label353;
      localObject1 = (SocialActivityCounts)paramDataProcessor.processDataTemplate(totalSocialActivityCounts);
      break label393;
    }
    label632:
    if (!hasEntity) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard", "entity");
    }
    if (!hasHeadline) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard", "headline");
    }
    if (!hasText) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard", "text");
    }
    if (!hasActor) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard", "actor");
    }
    if (!hasTotalSocialActivityCounts) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard", "totalSocialActivityCounts");
    }
    if (!hasRead) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard", "read");
    }
    return new JobUpdateActivityCard(publishedAt, entity, (AttributedText)localObject2, (AttributedText)localObject3, (AttributedText)localObject4, (AttributedText)localObject5, commentUrn, (ActorMiniProfile)localObject6, (SocialActivityCounts)localObject1, read, hasPublishedAt, hasEntity, bool1, bool2, bool3, bool4, hasCommentUrn, bool5, bool6, hasRead);
    label808:
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
      paramObject = (JobUpdateActivityCard)paramObject;
      if (publishedAt != publishedAt) {
        return false;
      }
      if (entity != null)
      {
        if (entity.equals(entity)) {}
      }
      else {
        while (entity != null) {
          return false;
        }
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
      if (headlineV2 != null)
      {
        if (headlineV2.equals(headlineV2)) {}
      }
      else {
        while (headlineV2 != null) {
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
      if (comment != null)
      {
        if (comment.equals(comment)) {}
      }
      else {
        while (comment != null) {
          return false;
        }
      }
      if (commentUrn != null)
      {
        if (commentUrn.equals(commentUrn)) {}
      }
      else {
        while (commentUrn != null) {
          return false;
        }
      }
      if (actor != null)
      {
        if (actor.equals(actor)) {}
      }
      else {
        while (actor != null) {
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
    } while (read == read);
    return false;
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
    UrnCoercer localUrnCoercer;
    if (hasEntity)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entity));
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
      if (hasHeadlineV2)
      {
        i = j + 1;
        if (headlineV2._cachedId == null) {
          break label387;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(headlineV2._cachedId);
      }
      label150:
      j = i + 1;
      i = j;
      if (hasText)
      {
        i = j + 1;
        if (text._cachedId == null) {
          break label400;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(text._cachedId);
      }
      label192:
      j = i + 1;
      i = j;
      if (hasComment)
      {
        i = j + 1;
        if (comment._cachedId == null) {
          break label413;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(comment._cachedId);
      }
      label234:
      j = i + 1;
      i = j;
      if (hasCommentUrn)
      {
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(commentUrn));
      }
      j = i + 1;
      i = j;
      if (hasActor)
      {
        i = j + 1;
        if (actor._cachedId == null) {
          break label426;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(actor._cachedId);
      }
      label308:
      j = i + 1;
      i = j;
      if (hasTotalSocialActivityCounts)
      {
        i = j + 1;
        if (totalSocialActivityCounts._cachedId == null) {
          break label439;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(totalSocialActivityCounts._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasRead) {
        i = j + 1;
      }
      __sizeOfObject = i;
      return i;
      i += headline.getSerializedSize();
      break;
      label387:
      i += headlineV2.getSerializedSize();
      break label150;
      label400:
      i += text.getSerializedSize();
      break label192;
      label413:
      i += comment.getSerializedSize();
      break label234;
      label426:
      i += actor.getSerializedSize();
      break label308;
      label439:
      i += totalSocialActivityCounts.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i4 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i5 = (int)(publishedAt ^ publishedAt >>> 32);
    int i;
    int j;
    label60:
    int k;
    label75:
    int m;
    label91:
    int n;
    label107:
    int i1;
    label123:
    int i2;
    if (entity != null)
    {
      i = entity.hashCode();
      if (headline == null) {
        break label235;
      }
      j = headline.hashCode();
      if (headlineV2 == null) {
        break label240;
      }
      k = headlineV2.hashCode();
      if (text == null) {
        break label245;
      }
      m = text.hashCode();
      if (comment == null) {
        break label251;
      }
      n = comment.hashCode();
      if (commentUrn == null) {
        break label257;
      }
      i1 = commentUrn.hashCode();
      if (actor == null) {
        break label263;
      }
      i2 = actor.hashCode();
      label139:
      if (totalSocialActivityCounts == null) {
        break label269;
      }
    }
    label235:
    label240:
    label245:
    label251:
    label257:
    label263:
    label269:
    for (int i3 = totalSocialActivityCounts.hashCode();; i3 = 0)
    {
      if (read) {
        i4 = 1;
      }
      i = (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + (i5 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label60;
      k = 0;
      break label75;
      m = 0;
      break label91;
      n = 0;
      break label107;
      i1 = 0;
      break label123;
      i2 = 0;
      break label139;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building JobUpdateActivityCard");
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
    label169:
    label229:
    label289:
    label349:
    label409:
    label443:
    label503:
    label563:
    label587:
    label639:
    label649:
    label674:
    label684:
    label709:
    label719:
    label744:
    label754:
    label779:
    label789:
    label799:
    label824:
    label834:
    label859:
    label869:
    label875:
    label883:
    label885:
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
        localByteBuffer.putInt(126638937);
        if (hasPublishedAt)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(publishedAt);
          if (!hasEntity) {
            break label639;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entity));
          if (!hasHeadline) {
            break label674;
          }
          localByteBuffer.put((byte)1);
          if (headline._cachedId == null) {
            break label649;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, headline._cachedId);
          headline.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasHeadlineV2) {
            break label709;
          }
          localByteBuffer.put((byte)1);
          if (headlineV2._cachedId == null) {
            break label684;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, headlineV2._cachedId);
          headlineV2.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasText) {
            break label744;
          }
          localByteBuffer.put((byte)1);
          if (text._cachedId == null) {
            break label719;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, text._cachedId);
          text.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasComment) {
            break label779;
          }
          localByteBuffer.put((byte)1);
          if (comment._cachedId == null) {
            break label754;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, comment._cachedId);
          comment.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCommentUrn) {
            break label789;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(commentUrn));
          if (!hasActor) {
            break label824;
          }
          localByteBuffer.put((byte)1);
          if (actor._cachedId == null) {
            break label799;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, actor._cachedId);
          actor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasTotalSocialActivityCounts) {
            break label859;
          }
          localByteBuffer.put((byte)1);
          if (totalSocialActivityCounts._cachedId == null) {
            break label834;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, totalSocialActivityCounts._cachedId);
          totalSocialActivityCounts.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasRead) {
            break label875;
          }
          localByteBuffer.put((byte)1);
          if (!read) {
            break label869;
          }
          i = 1;
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label883;
          }
          if (str != null) {
            break label885;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label169;
          localByteBuffer.put((byte)1);
          headline.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label229;
          localByteBuffer.put((byte)0);
          break label229;
          localByteBuffer.put((byte)1);
          headlineV2.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label289;
          localByteBuffer.put((byte)0);
          break label289;
          localByteBuffer.put((byte)1);
          text.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label349;
          localByteBuffer.put((byte)0);
          break label349;
          localByteBuffer.put((byte)1);
          comment.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label409;
          localByteBuffer.put((byte)0);
          break label409;
          localByteBuffer.put((byte)0);
          break label443;
          localByteBuffer.put((byte)1);
          actor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label503;
          localByteBuffer.put((byte)0);
          break label503;
          localByteBuffer.put((byte)1);
          totalSocialActivityCounts.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label563;
          localByteBuffer.put((byte)0);
          break label563;
          i = 0;
          break label587;
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
    implements RecordTemplateBuilder<JobUpdateActivityCard>
  {
    private ActorMiniProfile actor = null;
    private AttributedText comment = null;
    private Urn commentUrn = null;
    private Urn entity = null;
    private boolean hasActor = false;
    private boolean hasComment = false;
    private boolean hasCommentUrn = false;
    private boolean hasEntity = false;
    private boolean hasHeadline = false;
    private boolean hasHeadlineV2 = false;
    private boolean hasPublishedAt = false;
    public boolean hasRead = false;
    private boolean hasText = false;
    private boolean hasTotalSocialActivityCounts = false;
    private AttributedText headline = null;
    private AttributedText headlineV2 = null;
    private long publishedAt = 0L;
    public boolean read = false;
    private AttributedText text = null;
    private SocialActivityCounts totalSocialActivityCounts = null;
    
    public Builder() {}
    
    public Builder(JobUpdateActivityCard paramJobUpdateActivityCard)
    {
      publishedAt = publishedAt;
      entity = entity;
      headline = headline;
      headlineV2 = headlineV2;
      text = text;
      comment = comment;
      commentUrn = commentUrn;
      actor = actor;
      totalSocialActivityCounts = totalSocialActivityCounts;
      read = read;
      hasPublishedAt = hasPublishedAt;
      hasEntity = hasEntity;
      hasHeadline = hasHeadline;
      hasHeadlineV2 = hasHeadlineV2;
      hasText = hasText;
      hasComment = hasComment;
      hasCommentUrn = hasCommentUrn;
      hasActor = hasActor;
      hasTotalSocialActivityCounts = hasTotalSocialActivityCounts;
      hasRead = hasRead;
    }
    
    public final JobUpdateActivityCard build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (JobUpdateActivityCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new JobUpdateActivityCard(publishedAt, entity, headline, headlineV2, text, comment, commentUrn, actor, totalSocialActivityCounts, read, hasPublishedAt, hasEntity, hasHeadline, hasHeadlineV2, hasText, hasComment, hasCommentUrn, hasActor, hasTotalSocialActivityCounts, hasRead);
        if (!hasPublishedAt) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard", "publishedAt");
        }
        if (!hasEntity) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard", "entity");
        }
        if (!hasHeadline) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard", "headline");
        }
        if (!hasText) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard", "text");
        }
        if (!hasActor) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard", "actor");
        }
        if (!hasTotalSocialActivityCounts) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard", "totalSocialActivityCounts");
        }
      } while (hasRead);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard", "read");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */