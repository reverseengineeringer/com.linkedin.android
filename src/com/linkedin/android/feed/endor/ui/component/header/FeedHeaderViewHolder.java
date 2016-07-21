package com.linkedin.android.feed.endor.ui.component.header;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedHeaderViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedHeaderViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968724;
    }
  };
  @InjectView(2131755668)
  public ViewGroup container;
  @InjectView(2131755671)
  public View controlMenu;
  @InjectView(2131755669)
  public TextView text;
  
  public FeedHeaderViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.header.FeedHeaderViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */