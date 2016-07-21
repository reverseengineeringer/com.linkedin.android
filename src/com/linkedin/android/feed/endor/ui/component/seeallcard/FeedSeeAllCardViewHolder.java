package com.linkedin.android.feed.endor.ui.component.seeallcard;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedSeeAllCardViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedSeeAllCardViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968734;
    }
  };
  @InjectView(2131755728)
  public Button actionButton;
  @InjectView(2131755725)
  public View stackedImages;
  @InjectView(2131755726)
  public TextView title;
  
  public FeedSeeAllCardViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.seeallcard.FeedSeeAllCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */