package com.linkedin.android.feed.viewmodels.models;

import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.viewmodel.ViewPortViewModel;
import java.util.List;

public abstract class FeedItemViewModel<VIEW_HOLDER extends BaseViewHolder>
  extends ViewPortViewModel<VIEW_HOLDER>
{
  public List<List<FeedComponentViewModel>> getComponentSegmentsForBorders()
  {
    return null;
  }
  
  @Deprecated
  public final void onLeaveViewPortViaScroll$4d81c81c() {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.viewmodels.models.FeedItemViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */