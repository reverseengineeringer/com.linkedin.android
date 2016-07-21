package com.linkedin.android.feed.endor.datamodel.actor;

import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel;

public final class ChannelActorDataModel
  extends ActorDataModel<Channel>
{
  public ChannelActorDataModel(Channel paramChannel, String paramString1, FollowingInfo paramFollowingInfo, String paramString2) {}
  
  public final ImageModel makeFormattedImage(int paramInt, String paramString)
  {
    return new ImageModel(image, GhostImageUtils.getUnstructuredCompany(paramInt), paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.actor.ChannelActorDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */