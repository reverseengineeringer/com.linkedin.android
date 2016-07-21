package com.linkedin.android.feed.endor.ui.component.detailheader;

import android.text.Spanned;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.SortOrder;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.net.URISyntaxException;
import java.util.List;

public final class FeedDetailSectionHeaderTransformer
{
  private static FeedDetailSectionHeaderViewModel toCommentsViewModel(FragmentComponent paramFragmentComponent, SocialDetailDataModel paramSocialDetailDataModel, TrackingData paramTrackingData, Urn paramUrn)
  {
    if (totalComments == 0) {
      localObject = null;
    }
    do
    {
      return (FeedDetailSectionHeaderViewModel)localObject;
      bool2 = FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_TOGGLE_COMMENTS_ORDERING);
      bool1 = bool2;
      if (threadId != null) {}
      try
      {
        boolean bool3 = "groupPost".equals(createUrnFromNSSthreadId).entityType);
        bool1 = bool2;
        if (bool3) {
          bool1 = false;
        }
      }
      catch (URISyntaxException localURISyntaxException)
      {
        for (;;)
        {
          FeedDetailSectionHeaderViewModel localFeedDetailSectionHeaderViewModel;
          SortOrder localSortOrder;
          paramFragmentComponent.context();
          Util.safeThrow$7a8b4789(new RuntimeException("Cannot get urn from threadId"));
          bool1 = bool2;
          continue;
          Spanned localSpanned = localURISyntaxException.getSpannedString(2131231263, new Object[0]);
        }
      }
      localFeedDetailSectionHeaderViewModel = new FeedDetailSectionHeaderViewModel();
      type = 2131231154;
      titleText = paramFragmentComponent.i18NManager().getString(2131231154);
      localObject = localFeedDetailSectionHeaderViewModel;
    } while (!bool1);
    Object localObject = paramFragmentComponent.i18NManager();
    localSortOrder = commentsOrdering;
    switch (localSortOrder)
    {
    default: 
      localObject = ((I18NManager)localObject).getSpannedString(2131231264, new Object[0]);
      toggleText = ((CharSequence)localObject);
      toggleOnClickListener = FeedTracking.newCommentOrderingClickListener(paramFragmentComponent, paramTrackingData, paramUrn, commentsOrdering);
      return localFeedDetailSectionHeaderViewModel;
    }
  }
  
  private static FeedDetailSectionHeaderViewModel toLikesViewModel(FragmentComponent paramFragmentComponent, SocialDetailDataModel paramSocialDetailDataModel, TrackingData paramTrackingData, Urn paramUrn)
  {
    Object localObject;
    if ((!FeedViewTransformerHelpers.isLikesDetailPage(paramFragmentComponent)) && ((totalLikes == 0) || (likes.isEmpty())))
    {
      localObject = null;
      return (FeedDetailSectionHeaderViewModel)localObject;
    }
    if ((FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_TOGGLE_LIKES_ORDERING)) && (FeedViewTransformerHelpers.isLikesDetailPage(paramFragmentComponent))) {}
    for (i = 1;; i = 0)
    {
      j = i;
      if (threadId != null) {}
      try
      {
        boolean bool = "groupPost".equals(createUrnFromNSSthreadId).entityType);
        j = i;
        if (bool) {
          j = 0;
        }
      }
      catch (URISyntaxException localURISyntaxException)
      {
        for (;;)
        {
          FeedDetailSectionHeaderViewModel localFeedDetailSectionHeaderViewModel;
          SortOrder localSortOrder;
          paramFragmentComponent.context();
          Util.safeThrow$7a8b4789(new RuntimeException("Cannot get urn from threadId"));
          j = i;
          continue;
          Spanned localSpanned = localURISyntaxException.getSpannedString(2131231263, new Object[0]);
        }
      }
      localFeedDetailSectionHeaderViewModel = new FeedDetailSectionHeaderViewModel();
      type = 2131231255;
      titleText = paramFragmentComponent.i18NManager().getString(2131231255);
      localObject = localFeedDetailSectionHeaderViewModel;
      if (j == 0) {
        break;
      }
      localObject = paramFragmentComponent.i18NManager();
      localSortOrder = likesOrdering;
      switch (localSortOrder)
      {
      case ???: 
      default: 
        localObject = ((I18NManager)localObject).getSpannedString(2131231264, new Object[0]);
        toggleText = ((CharSequence)localObject);
        toggleOnClickListener = FeedTracking.newLikeOrderingClickListener(paramFragmentComponent, paramTrackingData, paramUrn, likesOrdering);
        return localFeedDetailSectionHeaderViewModel;
      }
    }
  }
  
  public static FeedDetailSectionHeaderViewModel toViewModel(FragmentComponent paramFragmentComponent, SocialDetailDataModel paramSocialDetailDataModel, int paramInt, TrackingData paramTrackingData, Urn paramUrn)
  {
    if (paramSocialDetailDataModel == null) {
      return null;
    }
    if (paramInt == 2131231154) {
      return toCommentsViewModel(paramFragmentComponent, paramSocialDetailDataModel, paramTrackingData, paramUrn);
    }
    return toLikesViewModel(paramFragmentComponent, paramSocialDetailDataModel, paramTrackingData, paramUrn);
  }
  
  public static FeedDetailSectionHeaderViewModel toViewModel(FragmentComponent paramFragmentComponent, SingleUpdateDataModel paramSingleUpdateDataModel, int paramInt)
  {
    return toViewModel(paramFragmentComponent, socialDetail, paramInt, pegasusUpdate.tracking, pegasusUpdate.urn);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.detailheader.FeedDetailSectionHeaderTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */