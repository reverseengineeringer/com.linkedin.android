package com.linkedin.android.feed.endor.ui.component.commentary;

import android.view.View;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.ui.ExpandableTextView;

public class FeedCommentaryViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedCommentaryViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968716;
    }
  };
  @InjectView(2131755643)
  public ExpandableTextView commentary;
  
  public FeedCommentaryViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.commentary.FeedCommentaryViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */