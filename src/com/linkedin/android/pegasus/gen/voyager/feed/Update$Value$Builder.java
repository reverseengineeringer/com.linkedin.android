package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.UnionMemberCountException;

public final class Update$Value$Builder
{
  private AggregatedConnectionUpdate aggregatedConnectionUpdateValue = null;
  private AggregatedFollowRecommendationUpdate aggregatedFollowRecommendationUpdateValue = null;
  private AggregatedJymbiiUpdate aggregatedJymbiiUpdateValue = null;
  private AggregatedPymkUpdate aggregatedPymkUpdateValue = null;
  private AggregatedShareContentUpdate aggregatedShareContentUpdateValue = null;
  private ArticleUpdate articleUpdateValue = null;
  private ChannelUpdate channelUpdateValue = null;
  private ConnectionUpdate connectionUpdateValue = null;
  private CrossPromoUpdate crossPromoUpdateValue = null;
  private DiscussionUpdate discussionUpdateValue = null;
  private FollowRecommendationUpdate followRecommendationUpdateValue = null;
  private GenericPromoUpdate genericPromoUpdateValue = null;
  private boolean hasAggregatedConnectionUpdateValue = false;
  private boolean hasAggregatedFollowRecommendationUpdateValue = false;
  private boolean hasAggregatedJymbiiUpdateValue = false;
  private boolean hasAggregatedPymkUpdateValue = false;
  private boolean hasAggregatedShareContentUpdateValue = false;
  private boolean hasArticleUpdateValue = false;
  private boolean hasChannelUpdateValue = false;
  private boolean hasConnectionUpdateValue = false;
  private boolean hasCrossPromoUpdateValue = false;
  private boolean hasDiscussionUpdateValue = false;
  private boolean hasFollowRecommendationUpdateValue = false;
  private boolean hasGenericPromoUpdateValue = false;
  private boolean hasJymbiiUpdateValue = false;
  private boolean hasLyndaUpdateValue = false;
  private boolean hasMentionedInNewsUpdateValue = false;
  private boolean hasPromptResponseUpdateValue = false;
  private boolean hasPropUpdateValue = false;
  private boolean hasPymkUpdateValue = false;
  private boolean hasReshareValue = false;
  private boolean hasShareUpdateValue = false;
  private boolean hasViralUpdateValue = false;
  private JymbiiUpdate jymbiiUpdateValue = null;
  private LyndaUpdate lyndaUpdateValue = null;
  private MentionedInNewsUpdate mentionedInNewsUpdateValue = null;
  private PromptResponseUpdate promptResponseUpdateValue = null;
  private PropUpdate propUpdateValue = null;
  private PymkUpdate pymkUpdateValue = null;
  private Reshare reshareValue = null;
  private ShareUpdate shareUpdateValue = null;
  private ViralUpdate viralUpdateValue = null;
  
  public final Update.Value build()
    throws BuilderException
  {
    int j = 0;
    if (hasAggregatedFollowRecommendationUpdateValue) {
      j = 0 + 1;
    }
    int i = j;
    if (hasAggregatedConnectionUpdateValue) {
      i = j + 1;
    }
    j = i;
    if (hasAggregatedJymbiiUpdateValue) {
      j = i + 1;
    }
    i = j;
    if (hasAggregatedPymkUpdateValue) {
      i = j + 1;
    }
    j = i;
    if (hasAggregatedShareContentUpdateValue) {
      j = i + 1;
    }
    i = j;
    if (hasArticleUpdateValue) {
      i = j + 1;
    }
    j = i;
    if (hasChannelUpdateValue) {
      j = i + 1;
    }
    i = j;
    if (hasConnectionUpdateValue) {
      i = j + 1;
    }
    j = i;
    if (hasCrossPromoUpdateValue) {
      j = i + 1;
    }
    i = j;
    if (hasDiscussionUpdateValue) {
      i = j + 1;
    }
    j = i;
    if (hasFollowRecommendationUpdateValue) {
      j = i + 1;
    }
    i = j;
    if (hasGenericPromoUpdateValue) {
      i = j + 1;
    }
    j = i;
    if (hasJymbiiUpdateValue) {
      j = i + 1;
    }
    i = j;
    if (hasLyndaUpdateValue) {
      i = j + 1;
    }
    j = i;
    if (hasMentionedInNewsUpdateValue) {
      j = i + 1;
    }
    i = j;
    if (hasPromptResponseUpdateValue) {
      i = j + 1;
    }
    j = i;
    if (hasPropUpdateValue) {
      j = i + 1;
    }
    i = j;
    if (hasPymkUpdateValue) {
      i = j + 1;
    }
    j = i;
    if (hasReshareValue) {
      j = i + 1;
    }
    i = j;
    if (hasShareUpdateValue) {
      i = j + 1;
    }
    j = i;
    if (hasViralUpdateValue) {
      j = i + 1;
    }
    if (j > 1) {
      throw new UnionMemberCountException("Value", j);
    }
    return new Update.Value(aggregatedFollowRecommendationUpdateValue, aggregatedConnectionUpdateValue, aggregatedJymbiiUpdateValue, aggregatedPymkUpdateValue, aggregatedShareContentUpdateValue, articleUpdateValue, channelUpdateValue, connectionUpdateValue, crossPromoUpdateValue, discussionUpdateValue, followRecommendationUpdateValue, genericPromoUpdateValue, jymbiiUpdateValue, lyndaUpdateValue, mentionedInNewsUpdateValue, promptResponseUpdateValue, propUpdateValue, pymkUpdateValue, reshareValue, shareUpdateValue, viralUpdateValue, hasAggregatedFollowRecommendationUpdateValue, hasAggregatedConnectionUpdateValue, hasAggregatedJymbiiUpdateValue, hasAggregatedPymkUpdateValue, hasAggregatedShareContentUpdateValue, hasArticleUpdateValue, hasChannelUpdateValue, hasConnectionUpdateValue, hasCrossPromoUpdateValue, hasDiscussionUpdateValue, hasFollowRecommendationUpdateValue, hasGenericPromoUpdateValue, hasJymbiiUpdateValue, hasLyndaUpdateValue, hasMentionedInNewsUpdateValue, hasPromptResponseUpdateValue, hasPropUpdateValue, hasPymkUpdateValue, hasReshareValue, hasShareUpdateValue, hasViralUpdateValue);
  }
  
  public final Builder setDiscussionUpdateValue(DiscussionUpdate paramDiscussionUpdate)
  {
    if (paramDiscussionUpdate == null)
    {
      hasDiscussionUpdateValue = false;
      discussionUpdateValue = null;
      return this;
    }
    hasDiscussionUpdateValue = true;
    discussionUpdateValue = paramDiscussionUpdate;
    return this;
  }
  
  public final Builder setReshareValue(Reshare paramReshare)
  {
    if (paramReshare == null)
    {
      hasReshareValue = false;
      reshareValue = null;
      return this;
    }
    hasReshareValue = true;
    reshareValue = paramReshare;
    return this;
  }
  
  public final Builder setShareUpdateValue(ShareUpdate paramShareUpdate)
  {
    if (paramShareUpdate == null)
    {
      hasShareUpdateValue = false;
      shareUpdateValue = null;
      return this;
    }
    hasShareUpdateValue = true;
    shareUpdateValue = paramShareUpdate;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.Update.Value.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */