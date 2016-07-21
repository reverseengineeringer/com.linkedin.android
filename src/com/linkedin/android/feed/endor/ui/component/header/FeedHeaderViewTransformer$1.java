package com.linkedin.android.feed.endor.ui.component.header;

import com.linkedin.android.feed.endor.datamodel.update.single.ViralSingleUpdateDataModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.ui.spans.EntityUrnClickableSpan;
import com.linkedin.android.infra.ui.spans.EntityUrnClickableSpan.EntityUrnClickListener;

final class FeedHeaderViewTransformer$1
  implements EntityUrnClickableSpan.EntityUrnClickListener
{
  FeedHeaderViewTransformer$1(FragmentComponent paramFragmentComponent, ViralSingleUpdateDataModel paramViralSingleUpdateDataModel) {}
  
  public final void onEntityUrnClicked(EntityUrnClickableSpan paramEntityUrnClickableSpan)
  {
    FeedTracking.trackEntityUrnClick(val$fragmentComponent, "update_topbar_actor", paramEntityUrnClickableSpan.getActionType(), val$viralUpdate.pegasusUpdate);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.header.FeedHeaderViewTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */