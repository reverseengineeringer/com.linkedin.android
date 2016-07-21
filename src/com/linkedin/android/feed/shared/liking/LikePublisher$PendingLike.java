package com.linkedin.android.feed.shared.liking;

import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.SponsoredMetadata;
import java.util.Map;

final class LikePublisher$PendingLike
{
  final boolean like;
  int likeSource;
  final SocialDetail socialDetail;
  final SponsoredMetadata sponsoredMetadata;
  final Map<String, String> trackingHeader;
  
  private LikePublisher$PendingLike(SocialDetail paramSocialDetail, Map<String, String> paramMap, boolean paramBoolean, int paramInt, SponsoredMetadata paramSponsoredMetadata)
  {
    socialDetail = paramSocialDetail;
    trackingHeader = paramMap;
    like = paramBoolean;
    likeSource = paramInt;
    sponsoredMetadata = paramSponsoredMetadata;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.liking.LikePublisher.PendingLike
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */