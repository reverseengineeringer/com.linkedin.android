package com.linkedin.android.feed.endor.ui.component.likesrollup;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.social.LikeDataModel;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.component.likesrollup.rollupitem.FeedLikesRollupItemViewModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class FeedLikesRollupTransformer
{
  public static FeedLikesRollupViewModel toViewModel(FragmentComponent paramFragmentComponent, SingleUpdateDataModel paramSingleUpdateDataModel)
  {
    SocialDetailDataModel localSocialDetailDataModel = socialDetail;
    if (localSocialDetailDataModel == null) {}
    do
    {
      return null;
      localObject1 = likes;
    } while ((totalLikes == 0) || (((List)localObject1).isEmpty()));
    FeedLikesRollupViewModel localFeedLikesRollupViewModel = new FeedLikesRollupViewModel();
    likeItemViewModels = new ArrayList();
    Object localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (LikeDataModel)((Iterator)localObject1).next();
      List localList = likeItemViewModels;
      localObject2 = actor;
      FeedLikesRollupItemViewModel localFeedLikesRollupItemViewModel = new FeedLikesRollupItemViewModel();
      actorImage = ((ActorDataModel)localObject2).makeFormattedImage(2131492961, Util.retrieveRumSessionId(paramFragmentComponent));
      actorId = id;
      localList.add(localFeedLikesRollupItemViewModel);
    }
    rollupTotalCount = totalLikes;
    likesRollupOnClickListener = FeedTracking.newLikesRollupClickListener(pegasusUpdate, paramFragmentComponent, highlightedLike);
    return localFeedLikesRollupViewModel;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.likesrollup.FeedLikesRollupTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */