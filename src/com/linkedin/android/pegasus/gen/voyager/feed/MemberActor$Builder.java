package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class MemberActor$Builder
  implements RecordTemplateBuilder<MemberActor>
{
  private MemberDistance distance = null;
  private FollowingInfo followingInfo = null;
  private boolean hasDistance = false;
  private boolean hasFollowingInfo = false;
  private boolean hasMiniProfile = false;
  private boolean hasShowFollowAction = false;
  private boolean hasUrn = false;
  private MiniProfile miniProfile = null;
  private boolean showFollowAction = false;
  private Urn urn = null;
  
  public final MemberActor build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MemberActor.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MemberActor(urn, miniProfile, followingInfo, showFollowAction, distance, hasUrn, hasMiniProfile, hasFollowingInfo, hasShowFollowAction, hasDistance);
      if (!hasMiniProfile) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.MemberActor", "miniProfile");
      }
    } while (hasFollowingInfo);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.MemberActor", "followingInfo");
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
  
  public final Builder setMiniProfile(MiniProfile paramMiniProfile)
  {
    if (paramMiniProfile == null)
    {
      hasMiniProfile = false;
      miniProfile = null;
      return this;
    }
    hasMiniProfile = true;
    miniProfile = paramMiniProfile;
    return this;
  }
  
  public final Builder setShowFollowAction(Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      hasShowFollowAction = false;
      showFollowAction = false;
      return this;
    }
    hasShowFollowAction = true;
    showFollowAction = paramBoolean.booleanValue();
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.MemberActor.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */