package com.linkedin.android.feed.endor.ui.component.componentlist;

import android.view.View;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.feed.endor.ui.FeedComponentsView;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedComponentListViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedComponentListViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968717;
    }
  };
  @InjectView(2131755644)
  public FeedComponentsView componentsView;
  
  public FeedComponentListViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.componentlist.FeedComponentListViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */