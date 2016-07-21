package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class SocialDetail$Builder
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
  
  public SocialDetail$Builder() {}
  
  public SocialDetail$Builder(SocialDetail paramSocialDetail)
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

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */