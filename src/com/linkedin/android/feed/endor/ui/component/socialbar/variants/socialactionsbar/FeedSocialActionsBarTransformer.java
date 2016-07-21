package com.linkedin.android.feed.endor.ui.component.socialbar.variants.socialactionsbar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ViralSingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.utils.FeedUpdateUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public final class FeedSocialActionsBarTransformer
{
  public static FeedSocialActionsBarViewModel toViewModel(SingleUpdateDataModel paramSingleUpdateDataModel, FragmentComponent paramFragmentComponent)
  {
    if (socialDetail == null) {
      return null;
    }
    boolean bool2 = FeedViewTransformerHelpers.isPromptResponseListPage(paramFragmentComponent);
    if ((FeedViewTransformerHelpers.isImageViewerPage(paramFragmentComponent)) || (bool2))
    {
      bool1 = true;
      if (bool2) {
        break label71;
      }
    }
    FeedSocialActionsBarViewModel localFeedSocialActionsBarViewModel;
    label71:
    for (bool2 = true;; bool2 = false)
    {
      localFeedSocialActionsBarViewModel = new FeedSocialActionsBarViewModel(new FeedSocialActionsBarLayout(bool1, bool2), bool1);
      if (socialDetail != null) {
        break label76;
      }
      paramSingleUpdateDataModel = null;
      return (FeedSocialActionsBarViewModel)paramSingleUpdateDataModel;
      bool1 = false;
      break;
    }
    label76:
    if (paramSingleUpdateDataModel.isReshareable()) {
      reshareClickListener = FeedTracking.newReshareClickListener(pegasusUpdate, paramFragmentComponent);
    }
    Object localObject;
    if (paramFragmentComponent.fragment() == null)
    {
      localObject = null;
      label108:
      if ((localObject == null) || (!((Bundle)localObject).getBoolean("backWhenReply"))) {
        break label292;
      }
    }
    label146:
    label162:
    label255:
    label261:
    label292:
    for (boolean bool1 = false;; bool1 = true)
    {
      String str;
      if (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_USE_VIRAL_UPDATE_IN_DETAIL))
      {
        localObject = pegasusUpdate;
        if (!(paramSingleUpdateDataModel instanceof ViralSingleUpdateDataModel)) {
          break label255;
        }
        str = urn;
        likeClickListener = FeedTracking.newLikeClickListener((Update)localObject, paramFragmentComponent);
        if (!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_USE_VIRAL_UPDATE_IN_DETAIL)) {
          break label261;
        }
      }
      for (replyClickListener = FeedTracking.newCommentOnUpdateClickListener((Update)localObject, bool1, socialDetail.highlightedCommentUrns, socialDetail.highlightedReplyUrns, paramFragmentComponent);; replyClickListener = FeedTracking.newCommentOnUpdateClickListener((Update)localObject, str, bool1, socialDetail.highlightedCommentUrns, socialDetail.highlightedReplyUrns, paramFragmentComponent))
      {
        isLiked = socialDetail.liked;
        paramSingleUpdateDataModel = localFeedSocialActionsBarViewModel;
        break;
        localObject = paramFragmentComponent.fragment().getArguments();
        break label108;
        localObject = FeedUpdateUtils.getOriginalPegasusUpdate(paramSingleUpdateDataModel);
        break label146;
        str = null;
        break label162;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.socialbar.variants.socialactionsbar.FeedSocialActionsBarTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */