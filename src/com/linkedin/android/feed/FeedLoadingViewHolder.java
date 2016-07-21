package com.linkedin.android.feed;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.app.BaseViewHolder;

public class FeedLoadingViewHolder
  extends BaseViewHolder
{
  @InjectView(2131755826)
  public ProgressBar progressBar;
  @InjectView(2131755827)
  public TextView text;
  
  public FeedLoadingViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.FeedLoadingViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */