package com.linkedin.android.feed.endor.ui.component.basicbutton;

import android.view.View;
import android.widget.Button;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedBasicButtonViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedBasicButtonViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968710;
    }
  };
  @InjectView(2131755611)
  public Button button;
  @InjectView(2131755610)
  public View topDivider;
  
  public FeedBasicButtonViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.basicbutton.FeedBasicButtonViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */