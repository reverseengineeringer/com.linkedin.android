package com.linkedin.android.feed.endor.ui.component.improvemyfeedcard;

import android.view.View;
import android.widget.Button;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedImproveMyFeedCardViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedImproveMyFeedCardViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968726;
    }
  };
  @InjectView(2131755689)
  public Button actionButton;
  
  public FeedImproveMyFeedCardViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.improvemyfeedcard.FeedImproveMyFeedCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */