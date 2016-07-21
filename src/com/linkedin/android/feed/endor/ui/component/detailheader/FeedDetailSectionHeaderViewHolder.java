package com.linkedin.android.feed.endor.ui.component.detailheader;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedDetailSectionHeaderViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedDetailSectionHeaderViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968719;
    }
  };
  @InjectView(2131755655)
  public TextView title;
  @InjectView(2131755656)
  public TextView toggle;
  
  public FeedDetailSectionHeaderViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.detailheader.FeedDetailSectionHeaderViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */