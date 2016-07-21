package com.linkedin.android.feed.endor.ui.update.single;

import android.support.v7.widget.CardView;
import android.view.View;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.feed.endor.ui.FeedComponentsView;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedSingleUpdateViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedSingleUpdateViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968757;
    }
  };
  @InjectView(2131755747)
  public CardView cardView;
  @InjectView(2131755821)
  public FeedComponentsView componentsView;
  
  public FeedSingleUpdateViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */