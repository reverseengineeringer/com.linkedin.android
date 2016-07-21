package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class JobUpdateActivityCard$Builder
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
  
  public JobUpdateActivityCard$Builder() {}
  
  public JobUpdateActivityCard$Builder(JobUpdateActivityCard paramJobUpdateActivityCard)
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

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */