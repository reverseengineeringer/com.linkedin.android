package com.linkedin.android.feed.endor.ui.component.unsupported;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedUnsupportedViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedUnsupportedViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968748;
    }
  };
  @InjectView(2131755773)
  public TextView text;
  
  public FeedUnsupportedViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.unsupported.FeedUnsupportedViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */