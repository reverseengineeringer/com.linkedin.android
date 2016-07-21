package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class ProfileNetworkInfo$Builder
  implements RecordTemplateBuilder<ProfileNetworkInfo>
{
  public int connectionsCount = 0;
  public MemberDistance distance = null;
  private Urn entityUrn = null;
  public boolean followable = false;
  public long followersCount = 0L;
  private boolean following = false;
  public FollowingInfo followingInfo = null;
  public boolean hasConnectionsCount = false;
  public boolean hasDistance = false;
  private boolean hasEntityUrn = false;
  public boolean hasFollowable = false;
  public boolean hasFollowersCount = false;
  private boolean hasFollowing = false;
  public boolean hasFollowingInfo = false;
  
  public final ProfileNetworkInfo build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ProfileNetworkInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new ProfileNetworkInfo(entityUrn, distance, connectionsCount, followingInfo, followersCount, following, followable, hasEntityUrn, hasDistance, hasConnectionsCount, hasFollowingInfo, hasFollowersCount, hasFollowing, hasFollowable);
      if (!hasDistance) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileNetworkInfo", "distance");
      }
    } while (hasConnectionsCount);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileNetworkInfo", "connectionsCount");
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileNetworkInfo.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */