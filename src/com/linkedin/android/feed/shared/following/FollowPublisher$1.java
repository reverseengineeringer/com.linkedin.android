package com.linkedin.android.feed.shared.following;

import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.consistency.DefaultConsistencyListener;

final class FollowPublisher$1
  extends DefaultConsistencyListener<FollowingInfo>
{
  FollowPublisher$1(FollowPublisher paramFollowPublisher, FollowingInfo paramFollowingInfo, String paramString)
  {
    super(paramFollowingInfo);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.following.FollowPublisher.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */