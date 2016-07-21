package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class FollowingInfo$Builder
  implements RecordTemplateBuilder<FollowingInfo>
{
  private Urn entityUrn = null;
  private int followerCount = 0;
  private boolean following = false;
  private boolean hasEntityUrn = false;
  private boolean hasFollowerCount = false;
  private boolean hasFollowing = false;
  
  public final FollowingInfo build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (FollowingInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new FollowingInfo(entityUrn, following, followerCount, hasEntityUrn, hasFollowing, hasFollowerCount);
      if (!hasEntityUrn) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo", "entityUrn");
      }
    } while (hasFollowing);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo", "following");
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
  
  public final Builder setFollowerCount(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      hasFollowerCount = false;
      followerCount = 0;
      return this;
    }
    hasFollowerCount = true;
    followerCount = paramInteger.intValue();
    return this;
  }
  
  public final Builder setFollowing(Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      hasFollowing = false;
      following = false;
      return this;
    }
    hasFollowing = true;
    following = paramBoolean.booleanValue();
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */