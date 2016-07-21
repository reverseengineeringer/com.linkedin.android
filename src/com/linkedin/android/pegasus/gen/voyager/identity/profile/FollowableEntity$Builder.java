package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class FollowableEntity$Builder
  implements RecordTemplateBuilder<FollowableEntity>
{
  private FollowableEntity.Entity entity = null;
  private FollowingInfo followingInfo = null;
  private boolean hasEntity = false;
  private boolean hasFollowingInfo = false;
  
  public final FollowableEntity build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FollowableEntity.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new FollowableEntity(entity, followingInfo, hasEntity, hasFollowingInfo);
    } while (hasEntity);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.FollowableEntity", "entity");
  }
  
  public final Builder setEntity(FollowableEntity.Entity paramEntity)
  {
    if (paramEntity == null)
    {
      hasEntity = false;
      entity = null;
      return this;
    }
    hasEntity = true;
    entity = paramEntity;
    return this;
  }
  
  public final Builder setFollowingInfo(FollowingInfo paramFollowingInfo)
  {
    if (paramFollowingInfo == null)
    {
      hasFollowingInfo = false;
      followingInfo = null;
      return this;
    }
    hasFollowingInfo = true;
    followingInfo = paramFollowingInfo;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.FollowableEntity.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */