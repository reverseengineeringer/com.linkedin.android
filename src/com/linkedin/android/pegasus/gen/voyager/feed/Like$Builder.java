package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class Like$Builder
  implements RecordTemplateBuilder<Like>
{
  private SocialActor actor = null;
  private long createdAt = 0L;
  private Urn entityUrn = null;
  private boolean hasActor = false;
  private boolean hasCreatedAt = false;
  private boolean hasEntityUrn = false;
  private boolean hasInsight = false;
  public boolean hasThreadId = false;
  private boolean hasUrn = false;
  private Insight insight = null;
  public String threadId = null;
  private Urn urn = null;
  
  public Like$Builder() {}
  
  public Like$Builder(Like paramLike)
  {
    urn = urn;
    entityUrn = entityUrn;
    actor = actor;
    insight = insight;
    threadId = threadId;
    createdAt = createdAt;
    hasUrn = hasUrn;
    hasEntityUrn = hasEntityUrn;
    hasActor = hasActor;
    hasInsight = hasInsight;
    hasThreadId = hasThreadId;
    hasCreatedAt = hasCreatedAt;
  }
  
  public final Like build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Like.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new Like(urn, entityUrn, actor, insight, threadId, createdAt, hasUrn, hasEntityUrn, hasActor, hasInsight, hasThreadId, hasCreatedAt);
    } while (hasActor);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.Like", "actor");
  }
  
  public final Builder setActor(SocialActor paramSocialActor)
  {
    if (paramSocialActor == null)
    {
      hasActor = false;
      actor = null;
      return this;
    }
    hasActor = true;
    actor = paramSocialActor;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.Like.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */