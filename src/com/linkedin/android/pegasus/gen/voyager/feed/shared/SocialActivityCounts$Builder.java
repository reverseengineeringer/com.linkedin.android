package com.linkedin.android.pegasus.gen.voyager.feed.shared;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class SocialActivityCounts$Builder
  implements RecordTemplateBuilder<SocialActivityCounts>
{
  private Urn entityUrn = null;
  private boolean hasEntityUrn = false;
  private boolean hasLiked = false;
  private boolean hasNumComments = false;
  private boolean hasNumLikes = false;
  private boolean hasNumViews = false;
  private boolean liked = false;
  private long numComments = 0L;
  private long numLikes = 0L;
  private long numViews = 0L;
  
  public SocialActivityCounts$Builder() {}
  
  public SocialActivityCounts$Builder(SocialActivityCounts paramSocialActivityCounts)
  {
    entityUrn = entityUrn;
    numComments = numComments;
    numLikes = numLikes;
    numViews = numViews;
    liked = liked;
    hasEntityUrn = hasEntityUrn;
    hasNumComments = hasNumComments;
    hasNumLikes = hasNumLikes;
    hasNumViews = hasNumViews;
    hasLiked = hasLiked;
  }
  
  public final SocialActivityCounts build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SocialActivityCounts.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new SocialActivityCounts(entityUrn, numComments, numLikes, numViews, liked, hasEntityUrn, hasNumComments, hasNumLikes, hasNumViews, hasLiked);
      if (!hasEntityUrn) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts", "entityUrn");
      }
      if (!hasNumComments) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts", "numComments");
      }
      if (!hasNumLikes) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts", "numLikes");
      }
    } while (hasLiked);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts", "liked");
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
    if (paramBoolean == null)
    {
      hasLiked = false;
      liked = false;
      return this;
    }
    hasLiked = true;
    liked = paramBoolean.booleanValue();
    return this;
  }
  
  public final Builder setNumComments(Long paramLong)
  {
    if (paramLong == null)
    {
      hasNumComments = false;
      numComments = 0L;
      return this;
    }
    hasNumComments = true;
    numComments = paramLong.longValue();
    return this;
  }
  
  public final Builder setNumLikes(Long paramLong)
  {
    if (paramLong == null)
    {
      hasNumLikes = false;
      numLikes = 0L;
      return this;
    }
    hasNumLikes = true;
    numLikes = paramLong.longValue();
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */