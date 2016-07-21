package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class SocialActivityCard$Builder
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
  
  public SocialActivityCard$Builder() {}
  
  public SocialActivityCard$Builder(SocialActivityCard paramSocialActivityCard)
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

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */