package com.linkedin.android.feed.endor.ui.component.header;

import com.linkedin.android.feed.endor.datamodel.update.single.MentionedInNewsUpdateDataModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.ui.spans.EntityUrnClickableSpan;
import com.linkedin.android.infra.ui.spans.EntityUrnClickableSpan.EntityUrnClickListener;

final class FeedHeaderViewTransformer$2
  implements EntityUrnClickableSpan.EntityUrnClickListener
{
  FeedHeaderViewTransformer$2(FragmentComponent paramFragmentComponent, MentionedInNewsUpdateDataModel paramMentionedInNewsUpdateDataModel) {}
  
  public final void onEntityUrnClicked(EntityUrnClickableSpan paramEntityUrnClickableSpan)
  {
    FeedTracking.trackEntityUrnClick(val$fragmentComponent, "update_topbar_actor", paramEntityUrnClickableSpan.getActionType(), val$mentionedInTheNewsUpdate.pegasusUpdate);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.header.FeedHeaderViewTransformer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */