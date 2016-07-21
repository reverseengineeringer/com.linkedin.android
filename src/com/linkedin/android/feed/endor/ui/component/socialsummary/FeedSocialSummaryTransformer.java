package com.linkedin.android.feed.endor.ui.component.socialsummary;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ViralSingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextLayout;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.utils.FeedUpdateUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class FeedSocialSummaryTransformer
{
  public static FeedBasicTextViewModel toViewModel(SingleUpdateDataModel paramSingleUpdateDataModel, FragmentComponent paramFragmentComponent)
  {
    if (socialDetail == null) {
      return null;
    }
    Object localObject1 = socialDetail;
    Object localObject2 = paramFragmentComponent.i18NManager();
    if ((totalLikes == 0) && (totalComments == 0)) {
      localObject1 = null;
    }
    while (TextUtils.isEmpty((CharSequence)localObject1))
    {
      return null;
      i = totalLikes;
      int j = totalComments;
      if (j == 0) {
        localObject1 = ((I18NManager)localObject2).getString(2131231300, new Object[] { Integer.valueOf(i) });
      } else if (i == 0) {
        localObject1 = ((I18NManager)localObject2).getString(2131231298, new Object[] { Integer.valueOf(j) });
      } else {
        localObject1 = ((I18NManager)localObject2).getString(2131231299, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      }
    }
    localObject2 = null;
    Bundle localBundle;
    label189:
    boolean bool1;
    if (!FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent))
    {
      if ((paramSingleUpdateDataModel instanceof ViralSingleUpdateDataModel))
      {
        localObject2 = urn;
        boolean bool2 = true;
        if (paramFragmentComponent.fragment() != null) {
          break label323;
        }
        localBundle = null;
        bool1 = bool2;
        if (localBundle != null)
        {
          bool1 = bool2;
          if (localBundle.getBoolean("backWhenReply")) {
            bool1 = false;
          }
        }
        if (!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_USE_VIRAL_UPDATE_IN_DETAIL)) {
          break label337;
        }
        localObject2 = FeedTracking.newUpdateClickListener(pegasusUpdate, paramFragmentComponent, 0, bool1, SocialDetailDataModel.getHighlightedCommentUrns(paramSingleUpdateDataModel), SocialDetailDataModel.getHighlightedReplyUrns(paramSingleUpdateDataModel), "social_count", "viewSocialCount");
      }
    }
    else {
      label255:
      if ((!FeedViewTransformerHelpers.isImageViewerPage(paramFragmentComponent)) && (!FeedViewTransformerHelpers.isPromptResponseListPage(paramFragmentComponent))) {
        break label367;
      }
    }
    label323:
    label337:
    label367:
    for (int i = 2131362479;; i = 2131361842)
    {
      paramSingleUpdateDataModel = new FeedBasicTextViewModel(new FeedBasicTextLayout(paramFragmentComponent.context().getResources(), i));
      text = ((CharSequence)localObject1);
      clickListener = ((TrackingOnClickListener)localObject2);
      componentType = "SocialSummary";
      return paramSingleUpdateDataModel;
      localObject2 = null;
      break;
      localBundle = paramFragmentComponent.fragment().getArguments();
      break label189;
      localObject2 = FeedTracking.newUpdateClickListener(FeedUpdateUtils.getOriginalPegasusUpdate(paramSingleUpdateDataModel), (String)localObject2, paramFragmentComponent, 0, bool1, SocialDetailDataModel.getHighlightedCommentUrns(paramSingleUpdateDataModel), SocialDetailDataModel.getHighlightedReplyUrns(paramSingleUpdateDataModel), "social_count", "viewSocialCount");
      break label255;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.socialsummary.FeedSocialSummaryTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */