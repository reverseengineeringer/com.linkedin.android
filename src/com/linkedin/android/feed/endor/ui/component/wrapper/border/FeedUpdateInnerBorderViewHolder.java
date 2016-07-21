package com.linkedin.android.feed.endor.ui.component.wrapper.border;

import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedUpdateInnerBorderViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedUpdateInnerBorderViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968727;
    }
  };
  @InjectView(2131755695)
  public View bottomBorder;
  @InjectView(2131755692)
  public View leftBorder;
  @InjectView(2131755693)
  public View rightBorder;
  @InjectView(2131755694)
  public View topBorder;
  @InjectView(2131755691)
  public ViewGroup wrapperArea;
  
  public FeedUpdateInnerBorderViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.wrapper.border.FeedUpdateInnerBorderViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */