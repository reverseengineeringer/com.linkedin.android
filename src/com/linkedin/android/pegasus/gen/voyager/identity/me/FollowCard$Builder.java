package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class FollowCard$Builder
  implements RecordTemplateBuilder<FollowCard>
{
  private ActorMiniProfile follower = null;
  private boolean hasFollower = false;
  private boolean hasOccupation = false;
  private boolean hasPublishedAt = false;
  public boolean hasRead = false;
  private Occupation occupation = null;
  private long publishedAt = 0L;
  public boolean read = false;
  
  public FollowCard$Builder() {}
  
  public FollowCard$Builder(FollowCard paramFollowCard)
  {
    publishedAt = publishedAt;
    follower = follower;
    read = read;
    occupation = occupation;
    hasPublishedAt = hasPublishedAt;
    hasFollower = hasFollower;
    hasRead = hasRead;
    hasOccupation = hasOccupation;
  }
  
  public final FollowCard build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FollowCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new FollowCard(publishedAt, follower, read, occupation, hasPublishedAt, hasFollower, hasRead, hasOccupation);
      if (!hasPublishedAt) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard", "publishedAt");
      }
      if (!hasFollower) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard", "follower");
      }
    } while (hasRead);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard", "read");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */