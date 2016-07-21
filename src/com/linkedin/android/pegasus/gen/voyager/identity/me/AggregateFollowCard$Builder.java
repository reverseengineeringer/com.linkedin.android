package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class AggregateFollowCard$Builder
  implements RecordTemplateBuilder<AggregateFollowCard>
{
  private List<ActorMiniProfile> followers = null;
  private boolean hasFollowers = false;
  private boolean hasNumFollowers = false;
  private boolean hasPublishedAt = false;
  public boolean hasRead = false;
  private long numFollowers = 0L;
  private long publishedAt = 0L;
  public boolean read = false;
  
  public AggregateFollowCard$Builder() {}
  
  public AggregateFollowCard$Builder(AggregateFollowCard paramAggregateFollowCard)
  {
    publishedAt = publishedAt;
    followers = followers;
    numFollowers = numFollowers;
    read = read;
    hasPublishedAt = hasPublishedAt;
    hasFollowers = hasFollowers;
    hasNumFollowers = hasNumFollowers;
    hasRead = hasRead;
  }
  
  public final AggregateFollowCard build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (AggregateFollowCard.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (followers != null)
    {
      paramFlavor = followers.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((ActorMiniProfile)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard", "followers");
            if (!hasPublishedAt) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard", "publishedAt");
            }
            if (!hasFollowers) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard", "followers");
            }
            if (!hasNumFollowers) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard", "numFollowers");
            }
            if (hasRead) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard", "read");
          }
        }
      }
    }
    return new AggregateFollowCard(publishedAt, followers, numFollowers, read, hasPublishedAt, hasFollowers, hasNumFollowers, hasRead);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */