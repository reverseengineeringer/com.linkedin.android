package com.linkedin.android.feed.endor.ui.component.divider;

import android.view.View;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedDividerViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedDividerViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968720;
    }
  };
  @InjectView(2131755658)
  View dividerView;
  
  public FeedDividerViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.divider.FeedDividerViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */