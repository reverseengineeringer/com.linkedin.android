package com.linkedin.android.feed.endor.ui.component.discussiontitle;

import android.content.Context;
import android.content.res.Resources;
import com.linkedin.android.feed.endor.datamodel.content.discussion.GroupDiscussionContentDataModel;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
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
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class FeedDiscussionTitleTransformer
{
  public static FeedBasicTextViewModel toViewModel(UpdateDataModel paramUpdateDataModel, FragmentComponent paramFragmentComponent)
  {
    Object localObject1 = SingleUpdateDataModel.getContentDataModel(paramUpdateDataModel);
    if ((localObject1 == null) || (!(localObject1 instanceof GroupDiscussionContentDataModel))) {
      return null;
    }
    Object localObject2 = (GroupDiscussionContentDataModel)localObject1;
    String str;
    if ((paramUpdateDataModel instanceof ViralSingleUpdateDataModel))
    {
      str = urn;
      localObject1 = null;
      if (!FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent)) {
        if (!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_USE_VIRAL_UPDATE_IN_DETAIL)) {
          break label127;
        }
      }
    }
    label127:
    for (localObject1 = FeedTracking.newUpdateClickListener(pegasusUpdate, paramFragmentComponent, 0, true, SocialDetailDataModel.getHighlightedCommentUrns(paramUpdateDataModel), SocialDetailDataModel.getHighlightedReplyUrns(paramUpdateDataModel), "discussion_description", "viewUpdateDetail");; localObject1 = FeedTracking.newUpdateClickListener(FeedUpdateUtils.getOriginalPegasusUpdate(paramUpdateDataModel), str, paramFragmentComponent, 0, true, SocialDetailDataModel.getHighlightedCommentUrns(paramUpdateDataModel), SocialDetailDataModel.getHighlightedReplyUrns(paramUpdateDataModel), "discussion_description", "viewUpdateDetail"))
    {
      paramUpdateDataModel = paramFragmentComponent.context().getString(2131231090);
      str = title;
      localObject2 = paramFragmentComponent.context();
      if (localObject2 != null) {
        break label155;
      }
      return null;
      str = null;
      break;
    }
    label155:
    localObject2 = ((Context)localObject2).getResources();
    if (FeedViewTransformerHelpers.isImageViewerPage(paramFragmentComponent)) {}
    for (int i = 2131362510;; i = 2131361905)
    {
      paramFragmentComponent = new FeedBasicTextViewModel(new FeedBasicTextLayout((Resources)localObject2, i));
      text = str;
      clickListener = ((TrackingOnClickListener)localObject1);
      contentDescription = paramUpdateDataModel;
      return paramFragmentComponent;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.discussiontitle.FeedDiscussionTitleTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */