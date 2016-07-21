package com.linkedin.android.feed.endor.ui.transformer;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.MemberActorDataModel;
import com.linkedin.android.feed.endor.datamodel.social.LikeDataModel;
import com.linkedin.android.feed.endor.datamodel.transformer.SocialDetailTransformer;
import com.linkedin.android.feed.endor.ui.component.likerow.FeedLikeRowLayout;
import com.linkedin.android.feed.endor.ui.component.likerow.FeedLikeRowViewModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.identity.shared.ProfileViewUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.DateUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Like;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class LikesDetailTransformer
{
  public static List<FeedLikeRowViewModel> toLikeViewModels(FragmentComponent paramFragmentComponent, TrackingData paramTrackingData, Urn paramUrn, List<Like> paramList)
  {
    return toLikeViewModels(paramFragmentComponent, paramTrackingData, paramUrn, paramList, null);
  }
  
  public static List<FeedLikeRowViewModel> toLikeViewModels(FragmentComponent paramFragmentComponent, TrackingData paramTrackingData, Urn paramUrn, List<Like> paramList, Like paramLike)
  {
    paramList = SocialDetailTransformer.transformLikes(paramFragmentComponent, paramList, paramLike, new HashSet());
    paramLike = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    LikeDataModel localLikeDataModel;
    if (localIterator.hasNext())
    {
      localLikeDataModel = (LikeDataModel)localIterator.next();
      if ((!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_SHOW_ACTOR_DISTANCE)) || (!(actor instanceof MemberActorDataModel))) {
        break label428;
      }
      paramList = actor).memberDistance;
      paramFragmentComponent.context();
      paramList = ProfileViewUtils.networkDistanceFromGraphDistance$d8bbb93(paramList);
      if ((Util.safeEquals(paramList, Integer.valueOf(1))) || (Util.safeEquals(paramList, Integer.valueOf(2))) || (Util.safeEquals(paramList, Integer.valueOf(3)))) {
        paramList = paramFragmentComponent.i18NManager().getString(2131231078, new Object[] { paramList });
      }
    }
    for (;;)
    {
      label163:
      label170:
      FeedLikeRowViewModel localFeedLikeRowViewModel;
      ActorDataModel localActorDataModel;
      if (paramList != null)
      {
        bool = true;
        localFeedLikeRowViewModel = new FeedLikeRowViewModel(new FeedLikeRowLayout(bool));
        localActorDataModel = actor;
        likeActorId = id;
        likeActorName = formattedName;
        if (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_SHOW_ACTOR_DISTANCE)) {
          if ((!(localActorDataModel instanceof MemberActorDataModel)) || (!isInfluencer)) {
            break label419;
          }
        }
      }
      label419:
      for (boolean bool = true;; bool = false)
      {
        isInfluencer = bool;
        likeActorDistance = paramList;
        likeActorHeadline = formattedHeadline;
        likeActorInsight = null;
        likeActorImage = localActorDataModel.makeFormattedImage(2131492962, Util.retrieveRumSessionId(paramFragmentComponent));
        likeActorClickListener = FeedTracking.actorClickListener(localActorDataModel, paramFragmentComponent, "like_actor", paramTrackingData, paramUrn);
        if ((FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_TOGGLE_LIKES_ORDERING)) && (createTime > 0L))
        {
          paramFragmentComponent.timeWrapper();
          likeTime = DateUtils.getTimestampText(System.currentTimeMillis(), createTime, paramFragmentComponent.i18NManager());
          paramFragmentComponent.timeWrapper();
          likeTimeContentDescription = DateUtils.getTimeAgoContentDescription(System.currentTimeMillis(), createTime, paramFragmentComponent.i18NManager());
        }
        paramLike.add(localFeedLikeRowViewModel);
        break;
        paramList = null;
        break label163;
        bool = false;
        break label170;
      }
      return paramLike;
      label428:
      paramList = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.transformer.LikesDetailTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */