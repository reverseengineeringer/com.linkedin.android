package com.linkedin.android.feed.endor.ui.component.ellipsisrollupitem;

import android.view.View;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.ui.TintableImageButton;

public class FeedEllipsisRollupItemViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedEllipsisRollupItemViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968721;
    }
  };
  @InjectView(2131755659)
  public TintableImageButton ellipsisView;
  
  public FeedEllipsisRollupItemViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.ellipsisrollupitem.FeedEllipsisRollupItemViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */