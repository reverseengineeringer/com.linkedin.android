package com.linkedin.android.feed.endor.ui.component.primaryactor;

import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.ui.spans.EntityUrnClickableSpan;
import com.linkedin.android.infra.ui.spans.EntityUrnClickableSpan.EntityUrnClickListener;

final class FeedPrimaryActorTransformer$1
  implements EntityUrnClickableSpan.EntityUrnClickListener
{
  FeedPrimaryActorTransformer$1(FragmentComponent paramFragmentComponent, SingleUpdateDataModel paramSingleUpdateDataModel) {}
  
  public final void onEntityUrnClicked(EntityUrnClickableSpan paramEntityUrnClickableSpan)
  {
    FeedTracking.trackEntityUrnClick(val$fragmentComponent, "update_subheadline_actor", paramEntityUrnClickableSpan.getActionType(), val$update.pegasusUpdate);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.primaryactor.FeedPrimaryActorTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */