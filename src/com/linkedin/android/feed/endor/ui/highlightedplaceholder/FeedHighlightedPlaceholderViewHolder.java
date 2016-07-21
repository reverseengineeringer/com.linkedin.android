package com.linkedin.android.feed.endor.ui.highlightedplaceholder;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedHighlightedPlaceholderViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedHighlightedPlaceholderViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968753;
    }
  };
  @InjectView(2131755814)
  public TextView text;
  
  public FeedHighlightedPlaceholderViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.highlightedplaceholder.FeedHighlightedPlaceholderViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */