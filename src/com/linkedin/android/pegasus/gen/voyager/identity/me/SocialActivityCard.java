package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
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

public final class SocialActivityCard
  implements FissileDataModel<SocialActivityCard>, RecordTemplate<SocialActivityCard>
{
  public static final SocialActivityCardBuilder BUILDER = SocialActivityCardBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final ActorMiniProfile actor;
  public final AttributedText comment;
  public final Urn commentUrn;
  public final Urn entity;
  public final MiniGroup group;
  public final String groupDiscussionUrl;
  public final boolean hasActor;
  public final boolean hasComment;
  public final boolean hasCommentUrn;
  public final boolean hasEntity;
  public final boolean hasGroup;
  public final boolean hasGroupDiscussionUrl;
  public final boolean hasHeadline;
  public final boolean hasHeadlineV2;
  public final boolean hasImage;
  public final boolean hasPublishedAt;
  public final boolean hasRead;
  public final boolean hasReplyUrn;
  public final boolean hasSharedEntity;
  public final boolean hasText;
  public final boolean hasTitle;
  public final boolean hasTotalSocialActivityCounts;
  public final boolean hasUrl;
  public final AttributedText headline;
  public final AttributedText headlineV2;
  public final Image image;
  public final long publishedAt;
  public final boolean read;
  public final Urn replyUrn;
  public final Urn sharedEntity;
  public final AttributedText text;
  public final String title;
  public final SocialActivityCounts totalSocialActivityCounts;
  public final String url;
  
  SocialActivityCard(long paramLong, Urn paramUrn1, Urn paramUrn2, AttributedText paramAttributedText1, AttributedText paramAttributedText2, ActorMiniProfile paramActorMiniProfile, SocialActivityCounts paramSocialActivityCounts, AttributedText paramAttributedText3, Urn paramUrn3, Urn paramUrn4, AttributedText paramAttributedText4, Image paramImage, String paramString1, String paramString2, boolean paramBoolean1, MiniGroup paramMiniGroup, String paramString3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17, boolean paramBoolean18)
  {
    publishedAt = paramLong;
    entity = paramUrn1;
    sharedEntity = paramUrn2;
    headline = paramAttributedText1;
    headlineV2 = paramAttributedText2;
    actor = paramActorMiniProfile;
    totalSocialActivityCounts = paramSocialActivityCounts;
    comment = paramAttributedText3;
    commentUrn = paramUrn3;
    replyUrn = paramUrn4;
    text = paramAttributedText4;
    image = paramImage;
    title = paramString1;
    url = paramString2;
    read = paramBoolean1;
    group = paramMiniGroup;
    groupDiscussionUrl = paramString3;
    hasPublishedAt = paramBoolean2;
    hasEntity = paramBoolean3;
    hasSharedEntity = paramBoolean4;
    hasHeadline = paramBoolean5;
    hasHeadlineV2 = paramBoolean6;
    hasActor = paramBoolean7;
    hasTotalSocialActivityCounts = paramBoolean8;
    hasComment = paramBoolean9;
    hasCommentUrn = paramBoolean10;
    hasReplyUrn = paramBoolean11;
    hasText = paramBoolean12;
    hasImage = paramBoolean13;
    hasTitle = paramBoolean14;
    hasUrl = paramBoolean15;
    hasRead = paramBoolean16;
    hasGroup = paramBoolean17;
    hasGroupDiscussionUrl = paramBoolean18;
    _cachedId = null;
  }
  
  public final SocialActivityCard accept(DataProcessor paramDataProcessor)
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
    if (hasSharedEntity)
    {
      paramDataProcessor.startRecordField$505cff1c("sharedEntity");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(sharedEntity));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    label147:
    Object localObject3;
    boolean bool2;
    label186:
    label197:
    Object localObject4;
    boolean bool3;
    label237:
    label249:
    Object localObject5;
    boolean bool4;
    label289:
    label301:
    Object localObject6;
    boolean bool5;
    label341:
    label353:
    Object localObject7;
    boolean bool6;
    label459:
    label471:
    Object localObject8;
    boolean bool7;
    if (hasHeadline)
    {
      paramDataProcessor.startRecordField$505cff1c("headline");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = headline.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label733;
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
          break label742;
        }
        localObject1 = headlineV2.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label760;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasActor)
      {
        paramDataProcessor.startRecordField$505cff1c("actor");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label769;
        }
        localObject1 = actor.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label787;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasTotalSocialActivityCounts)
      {
        paramDataProcessor.startRecordField$505cff1c("totalSocialActivityCounts");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label797;
        }
        localObject1 = totalSocialActivityCounts.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label815;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      localObject6 = null;
      bool5 = false;
      if (hasComment)
      {
        paramDataProcessor.startRecordField$505cff1c("comment");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label825;
        }
        localObject1 = comment.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label843;
        }
        bool5 = true;
        localObject6 = localObject1;
      }
      if (hasCommentUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("commentUrn");
        localObject1 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(commentUrn));
      }
      if (hasReplyUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("replyUrn");
        localObject1 = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(replyUrn));
      }
      localObject7 = null;
      bool6 = false;
      if (hasText)
      {
        paramDataProcessor.startRecordField$505cff1c("text");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label853;
        }
        localObject1 = text.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label871;
        }
        bool6 = true;
        localObject7 = localObject1;
      }
      localObject8 = null;
      bool7 = false;
      if (hasImage)
      {
        paramDataProcessor.startRecordField$505cff1c("image");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label881;
        }
        localObject1 = image.accept(paramDataProcessor);
        label511:
        if (localObject1 == null) {
          break label899;
        }
        bool7 = true;
        localObject8 = localObject1;
      }
      label523:
      if (hasTitle)
      {
        paramDataProcessor.startRecordField$505cff1c("title");
        paramDataProcessor.processString(title);
      }
      if (hasUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("url");
        paramDataProcessor.processString(url);
      }
      if (hasRead)
      {
        paramDataProcessor.startRecordField$505cff1c("read");
        paramDataProcessor.processBoolean(read);
      }
      localObject1 = null;
      bool8 = false;
      if (hasGroup)
      {
        paramDataProcessor.startRecordField$505cff1c("group");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label909;
        }
        localObject1 = group.accept(paramDataProcessor);
        label638:
        if (localObject1 == null) {
          break label927;
        }
      }
    }
    label733:
    label742:
    label760:
    label769:
    label787:
    label797:
    label815:
    label825:
    label843:
    label853:
    label871:
    label881:
    label899:
    label909:
    label927:
    for (boolean bool8 = true;; bool8 = false)
    {
      if (hasGroupDiscussionUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("groupDiscussionUrl");
        paramDataProcessor.processString(groupDiscussionUrl);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1138;
      }
      try
      {
        if (hasPublishedAt) {
          break label933;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard", "publishedAt");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(headline);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label147;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(headlineV2);
      break label186;
      bool2 = false;
      localObject3 = localObject1;
      break label197;
      localObject1 = (ActorMiniProfile)paramDataProcessor.processDataTemplate(actor);
      break label237;
      bool3 = false;
      localObject4 = localObject1;
      break label249;
      localObject1 = (SocialActivityCounts)paramDataProcessor.processDataTemplate(totalSocialActivityCounts);
      break label289;
      bool4 = false;
      localObject5 = localObject1;
      break label301;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(comment);
      break label341;
      bool5 = false;
      localObject6 = localObject1;
      break label353;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(text);
      break label459;
      bool6 = false;
      localObject7 = localObject1;
      break label471;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(image);
      break label511;
      bool7 = false;
      localObject8 = localObject1;
      break label523;
      localObject1 = (MiniGroup)paramDataProcessor.processDataTemplate(group);
      break label638;
    }
    label933:
    if (!hasEntity) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard", "entity");
    }
    if (!hasHeadline) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard", "headline");
    }
    if (!hasActor) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard", "actor");
    }
    if (!hasTotalSocialActivityCounts) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard", "totalSocialActivityCounts");
    }
    if (!hasRead) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard", "read");
    }
    return new SocialActivityCard(publishedAt, entity, sharedEntity, (AttributedText)localObject2, (AttributedText)localObject3, (ActorMiniProfile)localObject4, (SocialActivityCounts)localObject5, (AttributedText)localObject6, commentUrn, replyUrn, (AttributedText)localObject7, (Image)localObject8, title, url, read, (MiniGroup)localObject1, groupDiscussionUrl, hasPublishedAt, hasEntity, hasSharedEntity, bool1, bool2, bool3, bool4, bool5, hasCommentUrn, hasReplyUrn, bool6, bool7, hasTitle, hasUrl, hasRead, bool8, hasGroupDiscussionUrl);
    label1138:
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
      paramObject = (SocialActivityCard)paramObject;
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
      if (sharedEntity != null)
      {
        if (sharedEntity.equals(sharedEntity)) {}
      }
      else {
        while (sharedEntity != null) {
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
      if (replyUrn != null)
      {
        if (replyUrn.equals(replyUrn)) {}
      }
      else {
        while (replyUrn != null) {
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
      if (url != null)
      {
        if (url.equals(url)) {}
      }
      else {
        while (url != null) {
          return false;
        }
      }
      if (read != read) {
        return false;
      }
      if (group != null)
      {
        if (group.equals(group)) {}
      }
      else {
        while (group != null) {
          return false;
        }
      }
      if (groupDiscussionUrl == null) {
        break;
      }
    } while (groupDiscussionUrl.equals(groupDiscussionUrl));
    for (;;)
    {
      return false;
      if (groupDiscussionUrl == null) {
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
    UrnCoercer localUrnCoercer;
    if (hasEntity)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entity));
    }
    j = i + 1;
    i = j;
    if (hasSharedEntity)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(sharedEntity));
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
          break label610;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(headlineV2._cachedId);
      }
      label182:
      j = i + 1;
      i = j;
      if (hasActor)
      {
        i = j + 1;
        if (actor._cachedId == null) {
          break label623;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(actor._cachedId);
      }
      label224:
      j = i + 1;
      i = j;
      if (hasTotalSocialActivityCounts)
      {
        i = j + 1;
        if (totalSocialActivityCounts._cachedId == null) {
          break label636;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(totalSocialActivityCounts._cachedId);
      }
      label266:
      j = i + 1;
      i = j;
      if (hasComment)
      {
        i = j + 1;
        if (comment._cachedId == null) {
          break label649;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(comment._cachedId);
      }
      label308:
      j = i + 1;
      i = j;
      if (hasCommentUrn)
      {
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(commentUrn));
      }
      j = i + 1;
      i = j;
      if (hasReplyUrn)
      {
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(replyUrn));
      }
      j = i + 1;
      i = j;
      if (hasText)
      {
        i = j + 1;
        if (text._cachedId == null) {
          break label662;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(text._cachedId);
      }
      label414:
      j = i + 1;
      i = j;
      if (hasImage)
      {
        i = j + 1;
        if (image._cachedId == null) {
          break label675;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(image._cachedId);
      }
      label456:
      j = i + 1;
      i = j;
      if (hasTitle) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
      }
      j = i + 1;
      i = j;
      if (hasUrl) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(url);
      }
      j = i + 1;
      i = j;
      if (hasRead) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasGroup)
      {
        i = j + 1;
        if (group._cachedId == null) {
          break label688;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(group._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasGroupDiscussionUrl) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(groupDiscussionUrl);
      }
      __sizeOfObject = i;
      return i;
      i += headline.getSerializedSize();
      break;
      label610:
      i += headlineV2.getSerializedSize();
      break label182;
      label623:
      i += actor.getSerializedSize();
      break label224;
      label636:
      i += totalSocialActivityCounts.getSerializedSize();
      break label266;
      label649:
      i += comment.getSerializedSize();
      break label308;
      label662:
      i += text.getSerializedSize();
      break label414;
      label675:
      i += image.getSerializedSize();
      break label456;
      label688:
      i += group.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i11 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i12 = (int)(publishedAt ^ publishedAt >>> 32);
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
    label139:
    int i3;
    label155:
    int i4;
    label171:
    int i5;
    label187:
    int i6;
    label203:
    int i7;
    label219:
    int i8;
    label235:
    int i9;
    if (entity != null)
    {
      i = entity.hashCode();
      if (sharedEntity == null) {
        break label389;
      }
      j = sharedEntity.hashCode();
      if (headline == null) {
        break label394;
      }
      k = headline.hashCode();
      if (headlineV2 == null) {
        break label399;
      }
      m = headlineV2.hashCode();
      if (actor == null) {
        break label405;
      }
      n = actor.hashCode();
      if (totalSocialActivityCounts == null) {
        break label411;
      }
      i1 = totalSocialActivityCounts.hashCode();
      if (comment == null) {
        break label417;
      }
      i2 = comment.hashCode();
      if (commentUrn == null) {
        break label423;
      }
      i3 = commentUrn.hashCode();
      if (replyUrn == null) {
        break label429;
      }
      i4 = replyUrn.hashCode();
      if (text == null) {
        break label435;
      }
      i5 = text.hashCode();
      if (image == null) {
        break label441;
      }
      i6 = image.hashCode();
      if (title == null) {
        break label447;
      }
      i7 = title.hashCode();
      if (url == null) {
        break label453;
      }
      i8 = url.hashCode();
      if (!read) {
        break label459;
      }
      i9 = 1;
      label245:
      if (group == null) {
        break label465;
      }
    }
    label389:
    label394:
    label399:
    label405:
    label411:
    label417:
    label423:
    label429:
    label435:
    label441:
    label447:
    label453:
    label459:
    label465:
    for (int i10 = group.hashCode();; i10 = 0)
    {
      if (groupDiscussionUrl != null) {
        i11 = groupDiscussionUrl.hashCode();
      }
      i = (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + (i12 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i11;
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
      i3 = 0;
      break label155;
      i4 = 0;
      break label171;
      i5 = 0;
      break label187;
      i6 = 0;
      break label203;
      i7 = 0;
      break label219;
      i8 = 0;
      break label235;
      i9 = 0;
      break label245;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SocialActivityCard");
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
    label264:
    label324:
    label384:
    label444:
    label504:
    label538:
    label572:
    label632:
    label692:
    label718:
    label744:
    label768:
    label777:
    label837:
    label906:
    label916:
    label926:
    label951:
    label961:
    label986:
    label996:
    label1021:
    label1031:
    label1056:
    label1066:
    label1091:
    label1101:
    label1111:
    label1121:
    label1146:
    label1156:
    label1181:
    label1191:
    label1201:
    label1211:
    label1217:
    label1227:
    label1252:
    label1262:
    label1270:
    label1272:
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
        localByteBuffer.putInt(-320237211);
        if (hasPublishedAt)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(publishedAt);
          if (!hasEntity) {
            break label906;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entity));
          if (!hasSharedEntity) {
            break label916;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(sharedEntity));
          if (!hasHeadline) {
            break label951;
          }
          localByteBuffer.put((byte)1);
          if (headline._cachedId == null) {
            break label926;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, headline._cachedId);
          headline.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasHeadlineV2) {
            break label986;
          }
          localByteBuffer.put((byte)1);
          if (headlineV2._cachedId == null) {
            break label961;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, headlineV2._cachedId);
          headlineV2.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasActor) {
            break label1021;
          }
          localByteBuffer.put((byte)1);
          if (actor._cachedId == null) {
            break label996;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, actor._cachedId);
          actor.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasTotalSocialActivityCounts) {
            break label1056;
          }
          localByteBuffer.put((byte)1);
          if (totalSocialActivityCounts._cachedId == null) {
            break label1031;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, totalSocialActivityCounts._cachedId);
          totalSocialActivityCounts.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasComment) {
            break label1091;
          }
          localByteBuffer.put((byte)1);
          if (comment._cachedId == null) {
            break label1066;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, comment._cachedId);
          comment.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasCommentUrn) {
            break label1101;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(commentUrn));
          if (!hasReplyUrn) {
            break label1111;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(replyUrn));
          if (!hasText) {
            break label1146;
          }
          localByteBuffer.put((byte)1);
          if (text._cachedId == null) {
            break label1121;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, text._cachedId);
          text.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasImage) {
            break label1181;
          }
          localByteBuffer.put((byte)1);
          if (image._cachedId == null) {
            break label1156;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, image._cachedId);
          image.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasTitle) {
            break label1191;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasUrl) {
            break label1201;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, url);
          if (!hasRead) {
            break label1217;
          }
          localByteBuffer.put((byte)1);
          if (!read) {
            break label1211;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasGroup) {
            break label1252;
          }
          localByteBuffer.put((byte)1);
          if (group._cachedId == null) {
            break label1227;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, group._cachedId);
          group.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasGroupDiscussionUrl) {
            break label1262;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, groupDiscussionUrl);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label1270;
          }
          if (str != null) {
            break label1272;
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
          localByteBuffer.put((byte)1);
          headline.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label264;
          localByteBuffer.put((byte)0);
          break label264;
          localByteBuffer.put((byte)1);
          headlineV2.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label324;
          localByteBuffer.put((byte)0);
          break label324;
          localByteBuffer.put((byte)1);
          actor.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label384;
          localByteBuffer.put((byte)0);
          break label384;
          localByteBuffer.put((byte)1);
          totalSocialActivityCounts.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label444;
          localByteBuffer.put((byte)0);
          break label444;
          localByteBuffer.put((byte)1);
          comment.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label504;
          localByteBuffer.put((byte)0);
          break label504;
          localByteBuffer.put((byte)0);
          break label538;
          localByteBuffer.put((byte)0);
          break label572;
          localByteBuffer.put((byte)1);
          text.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label632;
          localByteBuffer.put((byte)0);
          break label632;
          localByteBuffer.put((byte)1);
          image.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label692;
          localByteBuffer.put((byte)0);
          break label692;
          localByteBuffer.put((byte)0);
          break label718;
          localByteBuffer.put((byte)0);
          break label744;
          i = 0;
          break label768;
          localByteBuffer.put((byte)0);
          break label777;
          localByteBuffer.put((byte)1);
          group.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label837;
          localByteBuffer.put((byte)0);
          break label837;
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
    implements RecordTemplateBuilder<SocialActivityCard>
  {
    private ActorMiniProfile actor = null;
    private AttributedText comment = null;
    private Urn commentUrn = null;
    private Urn entity = null;
    private MiniGroup group = null;
    private String groupDiscussionUrl = null;
    private boolean hasActor = false;
    private boolean hasComment = false;
    private boolean hasCommentUrn = false;
    private boolean hasEntity = false;
    private boolean hasGroup = false;
    private boolean hasGroupDiscussionUrl = false;
    private boolean hasHeadline = false;
    private boolean hasHeadlineV2 = false;
    private boolean hasImage = false;
    private boolean hasPublishedAt = false;
    public boolean hasRead = false;
    private boolean hasReplyUrn = false;
    private boolean hasSharedEntity = false;
    private boolean hasText = false;
    private boolean hasTitle = false;
    private boolean hasTotalSocialActivityCounts = false;
    private boolean hasUrl = false;
    private AttributedText headline = null;
    private AttributedText headlineV2 = null;
    private Image image = null;
    private long publishedAt = 0L;
    public boolean read = false;
    private Urn replyUrn = null;
    private Urn sharedEntity = null;
    private AttributedText text = null;
    private String title = null;
    private SocialActivityCounts totalSocialActivityCounts = null;
    private String url = null;
    
    public Builder() {}
    
    public Builder(SocialActivityCard paramSocialActivityCard)
    {
      publishedAt = publishedAt;
      entity = entity;
      sharedEntity = sharedEntity;
      headline = headline;
      headlineV2 = headlineV2;
      actor = actor;
      totalSocialActivityCounts = totalSocialActivityCounts;
      comment = comment;
      commentUrn = commentUrn;
      replyUrn = replyUrn;
      text = text;
      image = image;
      title = title;
      url = url;
      read = read;
      group = group;
      groupDiscussionUrl = groupDiscussionUrl;
      hasPublishedAt = hasPublishedAt;
      hasEntity = hasEntity;
      hasSharedEntity = hasSharedEntity;
      hasHeadline = hasHeadline;
      hasHeadlineV2 = hasHeadlineV2;
      hasActor = hasActor;
      hasTotalSocialActivityCounts = hasTotalSocialActivityCounts;
      hasComment = hasComment;
      hasCommentUrn = hasCommentUrn;
      hasReplyUrn = hasReplyUrn;
      hasText = hasText;
      hasImage = hasImage;
      hasTitle = hasTitle;
      hasUrl = hasUrl;
      hasRead = hasRead;
      hasGroup = hasGroup;
      hasGroupDiscussionUrl = hasGroupDiscussionUrl;
    }
    
    public final SocialActivityCard build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (SocialActivityCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new SocialActivityCard(publishedAt, entity, sharedEntity, headline, headlineV2, actor, totalSocialActivityCounts, comment, commentUrn, replyUrn, text, image, title, url, read, group, groupDiscussionUrl, hasPublishedAt, hasEntity, hasSharedEntity, hasHeadline, hasHeadlineV2, hasActor, hasTotalSocialActivityCounts, hasComment, hasCommentUrn, hasReplyUrn, hasText, hasImage, hasTitle, hasUrl, hasRead, hasGroup, hasGroupDiscussionUrl);
        if (!hasPublishedAt) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard", "publishedAt");
        }
        if (!hasEntity) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard", "entity");
        }
        if (!hasHeadline) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard", "headline");
        }
        if (!hasActor) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard", "actor");
        }
        if (!hasTotalSocialActivityCounts) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard", "totalSocialActivityCounts");
        }
      } while (hasRead);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard", "read");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */