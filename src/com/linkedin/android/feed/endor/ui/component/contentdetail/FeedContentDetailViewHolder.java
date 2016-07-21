package com.linkedin.android.feed.endor.ui.component.contentdetail;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.ui.ExpandableTextView;

public class FeedContentDetailViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedContentDetailViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968718;
    }
  };
  @InjectView(2131755653)
  public ExpandableTextView bodyText;
  @InjectView(2131755647)
  public LiImageView image;
  @InjectView(2131755650)
  public TextView subtitle;
  @InjectView(2131755651)
  public TextView tertiaryText;
  @InjectView(2131755652)
  public TextView time;
  @InjectView(2131755649)
  public TextView title;
  
  public FeedContentDetailViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.contentdetail.FeedContentDetailViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */