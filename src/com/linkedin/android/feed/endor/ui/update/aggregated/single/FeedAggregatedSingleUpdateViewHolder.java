package com.linkedin.android.feed.endor.ui.update.aggregated.single;

import android.view.View;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.feed.endor.ui.FeedComponentsView;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedAggregatedSingleUpdateViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedAggregatedSingleUpdateViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968756;
    }
  };
  @InjectView(2131755820)
  public FeedComponentsView cardInterior;
  
  public FeedAggregatedSingleUpdateViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.update.aggregated.single.FeedAggregatedSingleUpdateViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */