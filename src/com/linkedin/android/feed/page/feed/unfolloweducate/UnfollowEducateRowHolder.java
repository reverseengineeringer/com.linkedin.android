package com.linkedin.android.feed.page.feed.unfolloweducate;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.linkedin.android.imageloader.LiImageView;

public class UnfollowEducateRowHolder
  extends RecyclerView.ViewHolder
{
  @InjectView(2131755859)
  TextView followStatus;
  @InjectView(2131755856)
  LiImageView image;
  @InjectView(2131755858)
  TextView subTitle;
  @InjectView(2131755857)
  TextView title;
  
  public UnfollowEducateRowHolder(View paramView)
  {
    super(paramView);
    ButterKnife.inject(this, paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateRowHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */