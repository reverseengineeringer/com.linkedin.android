package com.linkedin.android.feed.endor.ui.component.groupheader;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedGroupHeaderViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedGroupHeaderViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968723;
    }
  };
  @InjectView(2131755665)
  ImageView groupHeaderIcon;
  @InjectView(2131755666)
  TextView groupHeaderName;
  
  public FeedGroupHeaderViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.groupheader.FeedGroupHeaderViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */