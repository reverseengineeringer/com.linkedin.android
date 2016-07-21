package com.linkedin.android.feed.channel;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.data.UnionParceler;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel;

public final class ChannelBundle
  implements BundleBuilder
{
  private final Bundle bundle;
  
  private ChannelBundle(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public static ChannelBundle create(Channel paramChannel)
  {
    Bundle localBundle = new Bundle();
    RecordParceler.quietParcel(paramChannel, "channel", localBundle);
    localBundle.putString("channelName", name);
    localBundle.putInt("channelFollowers", followingInfo.followerCount);
    localBundle.putString("channelId", entityUrn.getId());
    localBundle.putBoolean("channelIsFollowing", followingInfo.following);
    if (logo != null) {
      UnionParceler.quietParcel(logo, "channelImageLogo", localBundle);
    }
    if (backgroundImage != null) {
      UnionParceler.quietParcel(backgroundImage, "channelImageBackground", localBundle);
    }
    return new ChannelBundle(localBundle);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.channel.ChannelBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */