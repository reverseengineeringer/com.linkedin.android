package com.linkedin.android.feed.endor.ui.component.endoffeed;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedEndOfFeedViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedEndOfFeedViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968722;
    }
  };
  @InjectView(2131755661)
  Button button;
  @InjectView(2131755662)
  Button link;
  @InjectView(2131755660)
  TextView text;
  
  public FeedEndOfFeedViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.endoffeed.FeedEndOfFeedViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */